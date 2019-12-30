package ir.dolphin.employee.facade;


import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.employee.EmployeeProfile;

import java.util.List;

public interface RegisterEmployeeFacade {
    InvocationContext<EmployeeProfile> registerEmployeeProfile(ServiceContext serviceContext, EmployeeProfile employeeProfile) throws BaseException;

    InvocationContext<List<EmployeeProfile>> getAllEmployeeProfile(ServiceContext sc) throws BaseException;

    InvocationContext<EmployeeProfile> getEmployeeByNationalCode(ServiceContext serviceContext, String nationalCode) throws BaseException;

    InvocationContext<EmployeeProfile> editEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException;

    InvocationContext<EmployeeProfile> removeEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException;
}
