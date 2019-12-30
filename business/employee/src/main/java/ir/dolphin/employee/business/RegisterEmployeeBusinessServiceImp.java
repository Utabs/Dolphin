package ir.dolphin.employee.business;

import ir.dolphin.base.*;
import ir.dolphin.employee.component.RegisterEmployeeComponentService;
import ir.dolphin.model.entity.employee.EmployeeProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("RegisterEmployeeBusinessService")
@Transactional
public class RegisterEmployeeBusinessServiceImp implements RegisterEmployeeBusinessService {
    @Autowired
    RegisterEmployeeComponentService registerEmployeeComponentService;


    public InvocationContext<EmployeeProfile> registerEmployeeProfile(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        try {
            InvocationContext<EmployeeProfile> sallerProfileDtoInvocationContext = new InvocationContext<EmployeeProfile>();
            sallerProfileDtoInvocationContext = registerEmployeeComponentService.registerEmployeeProfile(sc, employeeProfile);
            return sallerProfileDtoInvocationContext;

        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<List<EmployeeProfile>> getAllEmployeeProfile(ServiceContext sc) throws BaseException {
        try {
            InvocationContext<List<EmployeeProfile>> sallerProfileDtoInvocationContext = new InvocationContext<List<EmployeeProfile>>();
            sallerProfileDtoInvocationContext = registerEmployeeComponentService.getAllEmployeeProfile(sc);
            return sallerProfileDtoInvocationContext;

        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<EmployeeProfile> getEmployeeByNationalCode(ServiceContext sc, String nationalCode) throws BaseException {
        InvocationContext<EmployeeProfile> sallerProfileDtoInvocationContext = new InvocationContext<EmployeeProfile>();
        try {
            sallerProfileDtoInvocationContext = registerEmployeeComponentService.getEmployeeByNationalCode(sc, nationalCode);

            return sallerProfileDtoInvocationContext;

        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<EmployeeProfile> editEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        InvocationContext<EmployeeProfile> editSallerProfileInvocationContext = new InvocationContext<EmployeeProfile>();
        try {
            editSallerProfileInvocationContext = registerEmployeeComponentService.editEmployee(sc, employeeProfile);
            return editSallerProfileInvocationContext;
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<EmployeeProfile> removeEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        InvocationContext<EmployeeProfile> deleteSallerProfileInvocationContext = new InvocationContext<EmployeeProfile>();
        try {
            deleteSallerProfileInvocationContext = registerEmployeeComponentService.removeEmployee(sc, employeeProfile);
            return deleteSallerProfileInvocationContext;
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

}

