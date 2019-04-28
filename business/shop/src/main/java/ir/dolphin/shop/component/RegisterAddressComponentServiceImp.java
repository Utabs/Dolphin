package ir.dolphin.shop.component;

import ir.dolphin.base.*;
import ir.dolphin.model.QueryName;
import ir.dolphin.model.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("RegisterAddressComponentService")
@Transactional(rollbackFor =RuntimeException.class,isolation = Isolation.DEFAULT,readOnly =false ,propagation = Propagation.MANDATORY,timeout = -1)
public class RegisterAddressComponentServiceImp implements RegisterAddressComponentService{

    @Autowired
    BaseDao baseDao;

    public InvocationContext<Address> insert(ServiceContext sc, Address address) throws BaseException {
        try {
            InvocationContext<Address> addressInvocationContext = baseDao.generalCreate(sc, address);
            if (addressInvocationContext.isSuccessful())
                addressInvocationContext.setData(address);
            return addressInvocationContext;
        }
        catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SHOP);
        }
        catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SHOP);
        }
    }


    public InvocationContext<Address> update(ServiceContext sc, Address address) throws BaseException {
        try {
            InvocationContext<Address> addressInvocationContext = baseDao.edit(sc, address);
            if (addressInvocationContext.isSuccessful())
                addressInvocationContext.setData(address);

            return addressInvocationContext;
        }
        catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SHOP);
        }
        catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SHOP);
        }
    }

    public InvocationContext delete(ServiceContext sc, Address address) throws BaseException {
        try {
            return  baseDao.remove(sc, address);
        }
        catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SHOP);
        }
        catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SHOP);
        }
    }

    public InvocationContext<Address> getById(ServiceContext sc, Long id) throws BaseException {
        try {
            return baseDao.find(sc, id,Address.class);
        }
        catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SHOP);
        }
        catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SHOP);
        }
    }

    public InvocationContext<List<Address>> getAll(ServiceContext sc) throws BaseException {
        try {
            return baseDao.findAll(sc, Address.class);
        }
        catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SHOP);
        }
        catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SHOP);
        }
    }

    public InvocationContext<List<Address>> getByState(ServiceContext sc, String state) throws BaseException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("state", state);

            return baseDao.findByField(sc, Address.class, param, QueryName.getByState);
        }
        catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SHOP);
        }
        catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SHOP);
        }
    }
}
