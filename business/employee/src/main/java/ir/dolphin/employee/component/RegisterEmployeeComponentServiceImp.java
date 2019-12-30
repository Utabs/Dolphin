package ir.dolphin.employee.component;

import ir.dolphin.base.*;
import ir.dolphin.model.QueryName;
import ir.dolphin.model.entity.Address;
import ir.dolphin.model.entity.employee.EmployeeProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("RegisterEmployeeComponentService")
//@Transactional(rollbackFor =RuntimeException.class,isolation = Isolation.DEFAULT,readOnly =false ,propagation = Propagation.MANDATORY,timeout = -1)
public class RegisterEmployeeComponentServiceImp implements RegisterEmployeeComponentService {

    @Autowired
    BaseDao baseDao;

    public InvocationContext<EmployeeProfile> registerEmployeeProfile(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        try {
            InvocationContext<EmployeeProfile> sallerProfileDtoInvocationContext = baseDao.generalCreate(sc, employeeProfile);
            if (sallerProfileDtoInvocationContext.isSuccessful())
                sallerProfileDtoInvocationContext.setData(employeeProfile);
            return sallerProfileDtoInvocationContext;
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<EmployeeProfile> editEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        try {
            InvocationContext<EmployeeProfile> editSallerProfileInvocationContext = baseDao.edit(sc, employeeProfile);
            if (editSallerProfileInvocationContext.isSuccessful())
                editSallerProfileInvocationContext.setData(employeeProfile);
            return editSallerProfileInvocationContext;
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null,e.getMessage(),Layer.COMPONENT,Module.SALLER);
        }
    }


    public InvocationContext removeEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        try {
            return baseDao.remove(sc, employeeProfile);
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }

    public InvocationContext<Address> getById(ServiceContext sc, Long id) throws BaseException {
        try {
            return baseDao.find(sc, id, EmployeeProfile.class);
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }

    public InvocationContext<List<EmployeeProfile>> getAllEmployeeProfile(ServiceContext sc) throws BaseException {
        try {
            return baseDao.findAll(sc, EmployeeProfile.class);
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }

    public InvocationContext<EmployeeProfile> getEmployeeByNationalCode(ServiceContext sc, String nationalCode) throws BaseException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("nationalCode", nationalCode);
            return baseDao.findByField(sc, EmployeeProfile.class, param, QueryName.getSallersByNationalCode);
        } catch (BaseException e) {
            throw new BaseException(e.getExceptionCode(), e, e.getExceptionDescription(), e.getLayer(), Module.SALLER);
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.COMPONENT, Module.SALLER);
        }
    }
}
