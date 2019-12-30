package ir.dolphin.base;

import ir.dolphin.model.BaseQueryName;
import ir.dolphin.model.BaseStaticEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class BaseDao {

    private final int ID = 1;
    private final int IDENTITY = 2;
    private final int SEQUENCE = 3;

    protected static final Logger log = LoggerFactory.getLogger(BaseDao.class);

    @PersistenceContext
    private EntityManager em;


    @Transactional(propagation = Propagation.MANDATORY)
    public InvocationContext generalCreate(ServiceContext sc, BaseStaticEntity element) throws BaseException {
        return generalCreate(sc, element, false);
    }


    @Transactional(propagation = Propagation.MANDATORY)
    public InvocationContext generalCreate(ServiceContext sc, BaseStaticEntity element, boolean flushMode) throws BaseException {
        int ID_TYPE = 0;
        for (Field field : element.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation instanceof SequenceGenerator) {
                    ID_TYPE = SEQUENCE;
                    break;
                } else if (annotation instanceof GeneratedValue) {
                    if (ID_TYPE < IDENTITY) {
                        ID_TYPE = IDENTITY;
                    }
                } else if (annotation instanceof Id) {
                    if (ID_TYPE < ID) {
                        ID_TYPE = ID;
                    }
                }
            }

            if (ID_TYPE != 0) {
                break;
            }
        }
        InvocationContext invContext = new InvocationContext();
        try {
            if (ID_TYPE == ID) {
                if (isExist(sc, em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(element), element.getClass())) {
                    invContext.setErrorCode(ErrorMessageConstant.DB_RECORD_IS_DUPLICATE_CODE);
                    return invContext;
                }
            }
            em.persist(element);
            if (flushMode) {
                em.flush();
                em.refresh(element);
            }

//            clearNamedQueryCache(element.getClass());
            invContext.setErrorCode(0);
            return invContext;
        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();
            if (cause instanceof SQLIntegrityConstraintViolationException) {
                log.error("Integrity Constraint Violation occured in " + element.getClass().getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
            } else if (cause instanceof RollbackException) {
                log.error("Rollback Exception occured in " + element.getClass().getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
            } else {
                log.error("Persistence Exception occured in " + element.getClass().getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
            }
        } catch (ConstraintViolationException cve) {
            log.error("Constraint Violation occured in " + element.getClass().getName() + cve.getConstraintViolations().toString());
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), cve, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), ex, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
        }

    }

    @Transactional(propagation = Propagation.MANDATORY)
    public InvocationContext edit(ServiceContext sc, BaseStaticEntity element) throws BaseException {

        InvocationContext invContext = new InvocationContext();
        try {
//            if (!isExist(em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(element), element.getClass())) {
//                invContext.setErrorCode(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE);
//            } else {
            em.merge(element);
//            }
            invContext.setErrorCode(0);
            return invContext;
        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();
            if (cause instanceof SQLIntegrityConstraintViolationException) {
                log.error("Integrity Constraint Violation occured in " + element.getClass().getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_UPDATED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_UPDATED_MESSAGE, Layer.DAO, null);
            } else if (cause instanceof RollbackException) {
                log.error("Rollback Exception occured in " + element.getClass().getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_UPDATED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_UPDATED_MESSAGE, Layer.DAO, null);
            } else {
                log.error("Persistence Exception occured in " + element.getClass().getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_UPDATED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_UPDATED_MESSAGE, Layer.DAO, null);
            }
        } catch (ConstraintViolationException cve) {
            log.error("Constraint Violation occured in " + element.getClass().getName() + cve.getConstraintViolations().toString());
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_UPDATED_CODE.toString(), cve, ErrorMessageConstant.DB_RECORD_NOT_UPDATED_MESSAGE, Layer.DAO, null);
        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_UPDATED_CODE.toString(), ex, ErrorMessageConstant.DB_RECORD_NOT_UPDATED_MESSAGE, Layer.DAO, null);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public InvocationContext remove(ServiceContext sc, BaseStaticEntity element) throws BaseException {
        InvocationContext invContext = new InvocationContext();
        try {
            //todo get id from input element
            element = em.find(element.getClass(), em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(element));
            if (element == null) {
                invContext.setErrorCode(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE);
            } else {
                em.remove(element);
//            em.remove(em.contains(element) ? element : em.merge(element));
//                clearNamedQueryCache(element.getClass());
//                    em.refresh(element);
                invContext.setErrorCode(0);
            }
            return invContext;
        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();
            if (cause instanceof SQLIntegrityConstraintViolationException) {
                log.error("Integrity Constraint Violation occured in " + element.getClass().getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_DELETED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_DELETED_MESSAGE, Layer.DAO, null);
            } else if (cause instanceof RollbackException) {
                log.error("Rollback Exception occured in " + element.getClass().getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_DELETED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_DELETED_MESSAGE, Layer.DAO, null);
            } else {
                log.error("Persistence Exception occured in " + element.getClass().getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_DELETED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_DELETED_MESSAGE, Layer.DAO, null);
            }
        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_DELETED_CODE.toString(), ex, ErrorMessageConstant.DB_RECORD_NOT_DELETED_MESSAGE, Layer.DAO, null);
        }
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public InvocationContext find(ServiceContext sc, Object id, Class<? extends BaseStaticEntity> clazz) throws BaseException {
        InvocationContext<BaseStaticEntity> invContext = new InvocationContext<BaseStaticEntity>();
        try {
            BaseStaticEntity entity = em.find(clazz, id);
            if (entity == null) {
                invContext.setErrorCode(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE);
            } else {
                invContext.setData(entity);
                invContext.setErrorCode(0);
            }
            return invContext;
        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();
            log.error("Persistence Exception occured in " + clazz.getName() + cause);
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_FOUND_MESSAGE, Layer.DAO, null);

        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE.toString(), ex, ErrorMessageConstant.DB_RECORD_NOT_FOUND_MESSAGE, Layer.DAO, null);
        }
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public InvocationContext findAll(ServiceContext sc, Class<? extends BaseStaticEntity> clazz) throws BaseException {
        InvocationContext<List<? extends BaseStaticEntity>> invContext = new InvocationContext<List<? extends BaseStaticEntity>>();
        try {
            List<? extends BaseStaticEntity> entities = em.createNamedQuery(clazz.getSimpleName() + ".findAll", clazz).getResultList();
            if (entities == null || entities.isEmpty()) {
                invContext.setErrorCode(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE);
            } else {
                invContext.setData(entities);
                invContext.setErrorCode(0);
            }
            return invContext;
        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();

            log.error("Persistence Exception occured in " + clazz.getName() + cause);
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_FOUND_MESSAGE, Layer.DAO, null);

        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE.toString(), ex, ErrorMessageConstant.DB_RECORD_NOT_FOUND_MESSAGE, Layer.DAO, null);
        }
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public InvocationContext findByField(ServiceContext sc, Class<? extends BaseStaticEntity> clazz, Map<String, Object> param, BaseQueryName queryName) throws BaseException {
        return findByField(sc, clazz, param, queryName, null);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public InvocationContext findByField(ServiceContext sc, Class<? extends BaseStaticEntity> clazz, Map<String, Object> param, BaseQueryName queryName, Integer maxResult) throws BaseException {
        InvocationContext<List<BaseStaticEntity>> invContext = new InvocationContext<List<BaseStaticEntity>>();
        try {
            Query q = em.createNamedQuery(clazz.getSimpleName() + "." + queryName.getName(), clazz);
            if (maxResult != null && maxResult != 0)
                q.setMaxResults(maxResult);
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
            List<BaseStaticEntity> entities = q.getResultList();
            if (entities == null || entities.isEmpty()) {
                invContext.setErrorCode(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE);
            } else {
                invContext.setData(entities);
                invContext.setErrorCode(0);
            }
            return invContext;
        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();

            log.error("Persistence Exception occured in " + clazz.getName() + cause);
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_FOUND_MESSAGE, Layer.DAO, null);

        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE.toString(), ex, ErrorMessageConstant.DB_RECORD_NOT_FOUND_MESSAGE, Layer.DAO, null);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public InvocationContext<Integer> executeNativeQuery(ServiceContext sc, String nativeQuery) throws BaseException {
        try {
            Integer resultChanges = em.createNativeQuery(nativeQuery).executeUpdate();
            InvocationContext<Integer> invocationContext = new InvocationContext<Integer>();
            invocationContext.setData(resultChanges);
            invocationContext.setErrorCode(0);
            return invocationContext;
        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();
            if (cause instanceof SQLIntegrityConstraintViolationException) {
                log.error("Integrity Constraint Violation occured " + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
            } else if (cause instanceof RollbackException) {
                log.error("Rollback Exception occured in " + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
            } else {
                log.error("Persistence Exception occured in " + cause);
                throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
            }
        } catch (ConstraintViolationException cve) {
            log.error("Constraint Violation occured in " + cve.getConstraintViolations().toString());
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), cve, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_INSERTED_CODE.toString(), ex, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
        }
    }


    //@TransactionAttribute(TransactionAttributeType.MANDATORY)
    public InvocationContext executeQuery(Class<? extends BaseStaticEntity> clazz, Map<String, Object> param, BaseQueryName queryName) throws BaseException {
        InvocationContext invContext = new InvocationContext();
        try {
            Query q = em.createNamedQuery(clazz.getSimpleName() + "." + queryName.getName(), clazz);
//            q.setFlushMode(FlushModeType.AUTO);
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
            int count = q.executeUpdate();
            invContext.setData(count);
            invContext.setErrorCode(0);
//            em.flush();
//            refresh(clazz);
            return invContext;
        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();
            /*if (cause instanceof SQLIntegrityConstraintViolationException) {
                log.error("Integrity Constraint Violation occured in " + clazz.getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_NOT_SUCCESSFULL_QUERY_CODE.toString(), cause);
            } else */if (cause instanceof RollbackException) {
                log.error("Rollback Exception occured in " + clazz.getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_NOT_SUCCESSFULL_QUERY_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
            } else {
                log.error("Persistence Exception occured in " + clazz.getName() + cause);
                throw new BaseException(ErrorMessageConstant.DB_NOT_SUCCESSFULL_QUERY_CODE.toString(), cause, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
            }
        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_NOT_SUCCESSFULL_QUERY_CODE.toString(), ex, ErrorMessageConstant.DB_RECORD_NOT_INSERTED_MESSAGE, Layer.DAO, null);
        }
    }

    private boolean isExist(ServiceContext sc, Object id, Class<? extends BaseStaticEntity> clazz) throws Exception {
        try {
            if (em.find(clazz, id) == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    private InvocationContext execStoredProcedure(ServiceContext sc) throws Exception {
        try {
            StoredProcedureQuery storedProcedure = this.em.createStoredProcedureQuery("FISCAL.FATRBRV0");
            storedProcedure.registerStoredProcedureParameter("I_BOOK_DATE", Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("I_OPRTR_BRNCH", Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("O_ERROR", Integer.class, ParameterMode.OUT);
            storedProcedure.registerStoredProcedureParameter("O_DETAIL_COUNT", Integer.class, ParameterMode.OUT);
            storedProcedure.registerStoredProcedureParameter("O_LEVEL", Integer.class, ParameterMode.OUT);
            storedProcedure.setParameter("I_BOOK_DATE", 13980118);
            storedProcedure.setParameter("I_OPRTR_BRNCH", 60);
            storedProcedure.execute();
            Integer O_ERROR = (Integer) storedProcedure.getOutputParameterValue("O_ERROR") == null ? 0 : (Integer) storedProcedure.getOutputParameterValue("O_ERROR");
            Integer O_DETAIL_COUNT = (Integer) storedProcedure.getOutputParameterValue("O_DETAIL_COUNT");
            Integer O_LEVEL = (Integer) storedProcedure.getOutputParameterValue("O_LEVEL");
            System.out.println(O_ERROR + "----" + O_DETAIL_COUNT + "-------" + O_LEVEL);
            return null;
        } catch (Exception ex) {

            throw new Exception(ex);
        }
    }









 /*   //@TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void refresh(Class<? extends BaseStaticEntity> clazz) {
        try {
            InvocationContext<List<Object>> result = findAll(clazz);
            List<Object> list = result.getData();

            *//*if (clazz.getName().equals(Usecase.class.getName())) {
                for (Object obj : result.getData()) {
                    ((JpaCache) (em.getEntityManagerFactory().getCache())).evict(obj, true);
                }
            }*//*

            if (list != null && !list.isEmpty()) {
                ((JpaCache) (em.getEntityManagerFactory().getCache())).evict(list.get(0), true);
            }
            log.info("All objects of class " + clazz.getName() + " SYNCED ");

            clearNamedQueryCache(clazz);
            em.getEntityManagerFactory().getCache().evict(clazz);
            log.info("Evict Cache " + clazz.getName());
        } catch (Exception ex) {
            log.error("Can Not Refresh" + ex);
//            throw new BaseException(ErrorMessageConstant.DB_NOT_SUCCESSFULL_QUERY_CODE.toString(), ex);
        }
    }

    //@TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void refreshAll() throws BaseException {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_NOT_SUCCESSFULL_QUERY_CODE.toString(), ex);
        }
    }

    //@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Map<String, Class> getAllEntityNames() {
        Metamodel metamodel = em.getMetamodel();
        Set<EntityType<?>> allEntityTypes = metamodel.getEntities();
        Iterator<EntityType<?>> entityTypeIterator = allEntityTypes.iterator();
        Map<String, Class> entityMap = new HashMap<String, Class>();
        while (entityTypeIterator.hasNext()) {
            EntityType<?> next = entityTypeIterator.next();
            entityMap.put(next.getName(), next.getJavaType());
        }
        return entityMap;
    }

    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    private void clearNamedQueryCache(Class<? extends BaseStaticEntity> clazz) throws BaseException {

        NamedQueries namedQueriesAnnotation = clazz.getAnnotation(NamedQueries.class);
        if (namedQueriesAnnotation != null) {
            NamedQuery[] namedQueryAnnotations = namedQueriesAnnotation.value();

            for (NamedQuery namedQuery : namedQueryAnnotations) {
                if (namedQuery.name().contains("find")) {
                    ((JpaCache) em.getEntityManagerFactory().getCache()).clearQueryCache(namedQuery.name());
                }
            }
        }
    }

    //@TransactionAttribute(TransactionAttributeType.MANDATORY)
    private String getSequenceForZOS(String schemaName, String sequenceName) throws BaseException {
        try {

            return (String) em.createNamedQuery("SELECT NEXT VALUE FOR "+ schemaName + "." +sequenceName  + " FROM SYSIBM.SYSDUMMY1 WITH UR").getSingleResult();

        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();
            log.error("Persistence Exception occured in Sequence " );
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE.toString(), cause);

        } catch (Exception ex) {
            throw new BaseException(ErrorMessageConstant.DB_RECORD_NOT_FOUND_CODE.toString(), ex);
        }
    }
*/


    /*//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void prepare() {
        Session session = JpaHelper.getEntityManager(em).getServerSession();
        DynamicClassLoader dynamicClassLoader = DynamicClassLoader.lookup(session);
        JPADynamicHelper jpaDynamicHelper = new JPADynamicHelper(em);


        Class<?> dynamicEntityClass = dynamicClassLoader.createDynamicClass("org.demo.entity.DemoDynamicEntity");
        JPADynamicTypeBuilder newType = new JPADynamicTypeBuilder(dynamicEntityClass, null, "DEMO_DYNAMIC_ENTITY");
        newType.addDirectMapping("ID", Integer.class, "ID");
        newType.addDirectMapping("name", String.class, "NAME");
        newType.addDirectMapping("description", String.class, "DESCRIPTION");
        newType.setPrimaryKeyFields("ID");
        jpaDynamicHelper.addTypes(true, true, newType.getType());

        DynamicEntity newDynamicEntity = jpaDynamicHelper.newDynamicEntity("org.demo.entity.DemoDynamicEntity");

        newDynamicEntity.set("ID", 1);
        newDynamicEntity.set("name", "Demo");
        newDynamicEntity.set("description", "Demo Entity");
        em.persist(newDynamicEntity);

    }*/


}
