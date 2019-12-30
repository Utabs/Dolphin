package ir.dolphin.employee.facade;


import ir.dolphin.base.*;
import ir.dolphin.employee.business.RegisterEmployeeBusinessService;
import ir.dolphin.model.entity.employee.EmployeeProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RegisterSallerFacade")
public class RegisterEmployeeFacadeImp implements RegisterEmployeeFacade {
    @Autowired
    RegisterEmployeeBusinessService registerEmployeeBusinessService;

    @Override
    public InvocationContext<EmployeeProfile> registerEmployeeProfile(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        try {
            return registerEmployeeBusinessService.registerEmployeeProfile(sc, employeeProfile);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.FACADE, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<List<EmployeeProfile>> getAllEmployeeProfile(ServiceContext sc) throws BaseException {
        try {

            return registerEmployeeBusinessService.getAllEmployeeProfile(sc);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.FACADE, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<EmployeeProfile> getEmployeeByNationalCode(ServiceContext sc, String nationalCode) throws BaseException {
        try {

            return registerEmployeeBusinessService.getEmployeeByNationalCode(sc, nationalCode);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.FACADE, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<EmployeeProfile> editEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        try {
            return registerEmployeeBusinessService.editEmployee(sc, employeeProfile);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e.getMessage(), Layer.FACADE, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<EmployeeProfile> removeEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        try {
            return registerEmployeeBusinessService.removeEmployee(sc, employeeProfile);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e.getMessage(), Layer.FACADE, Module.SALLER);
        }

    }


}
