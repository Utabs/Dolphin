package ir.dolphin.saller.component;

import ir.dolphin.base.*;
import ir.dolphin.model.QueryName;
import ir.dolphin.model.entity.saller.SallerProfile;
import ir.dolphin.model.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("RegisterSallerComponentService")
//@Transactional(rollbackFor =RuntimeException.class,isolation = Isolation.DEFAULT,readOnly =false ,propagation = Propagation.MANDATORY,timeout = -1)
public class RegisterSallerComponentServiceImp implements  RegisterSallerComponentService {

    @Autowired
    BaseDao baseDao;

    public InvocationContext<SallerProfile> insert(ServiceContext sc, SallerProfile address) throws BaseException {
        try {
            InvocationContext<SallerProfile> sallerProfileDtoInvocationContext = baseDao.generalCreate(sc, address);
            if (sallerProfileDtoInvocationContext.isSuccessful())
                sallerProfileDtoInvocationContext.setData(address);
            return sallerProfileDtoInvocationContext;
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

    public InvocationContext<List<SallerProfile>> getAll(ServiceContext sc) throws BaseException {
        try {
            return baseDao.findAll(sc, SallerProfile.class);
        }
        catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SHOP);
        }
        catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SHOP);
        }
    }

    public InvocationContext<SallerProfile>  getByState(ServiceContext sc, String nationalCode) throws BaseException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("nationalCode", nationalCode);

            return baseDao.findByField(sc, SallerProfile.class, param, QueryName.getSallersByNationalCode);
        }
        catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SHOP);
        }
        catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SHOP);
        }
    }
}
