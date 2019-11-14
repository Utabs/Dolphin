package ir.dolphin.saller.component;

import ir.dolphin.base.*;
import ir.dolphin.model.QueryName;
import ir.dolphin.model.entity.Address;
import ir.dolphin.model.entity.saller.SallerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("RegisterSallerComponentService")
//@Transactional(rollbackFor =RuntimeException.class,isolation = Isolation.DEFAULT,readOnly =false ,propagation = Propagation.MANDATORY,timeout = -1)
public class RegisterSallerComponentServiceImp implements RegisterSallerComponentService {

    @Autowired
    BaseDao baseDao;

    public InvocationContext<SallerProfile> insert(ServiceContext sc, SallerProfile sallerProfile) throws BaseException {
        try {
            InvocationContext<SallerProfile> sallerProfileDtoInvocationContext = baseDao.generalCreate(sc, sallerProfile);
            if (sallerProfileDtoInvocationContext.isSuccessful())
                sallerProfileDtoInvocationContext.setData(sallerProfile);
            return sallerProfileDtoInvocationContext;
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<SallerProfile> update(ServiceContext sc, SallerProfile sallerProfile) throws BaseException {
        try {
            InvocationContext<SallerProfile> editSallerProfileInvocationContext = baseDao.edit(sc, sallerProfile);
            if (editSallerProfileInvocationContext.isSuccessful())
                editSallerProfileInvocationContext.setData(sallerProfile);
            return editSallerProfileInvocationContext;
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null,e.getMessage(),Layer.COMPONENT,Module.SALLER);
        }
    }


    public InvocationContext delete(ServiceContext sc, SallerProfile sallerProfile) throws BaseException {
        try {
            return baseDao.remove(sc, sallerProfile);
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }

    public InvocationContext<Address> getById(ServiceContext sc, Long id) throws BaseException {
        try {
            return baseDao.find(sc, id, SallerProfile.class);
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }

    public InvocationContext<List<SallerProfile>> getAll(ServiceContext sc) throws BaseException {
        try {
            return baseDao.findAll(sc, SallerProfile.class);
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }

    public InvocationContext<SallerProfile> getSallerByNationalCode(ServiceContext sc, String nationalCode) throws BaseException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("nationalCode", nationalCode);
            return baseDao.findByField(sc, SallerProfile.class, param, QueryName.getSallersByNationalCode);
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }
}
