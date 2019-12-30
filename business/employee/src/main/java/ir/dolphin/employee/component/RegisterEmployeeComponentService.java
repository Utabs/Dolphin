package ir.dolphin.employee.component;

import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.employee.EmployeeProfile;

import java.util.List;

public interface RegisterEmployeeComponentService {
    InvocationContext<EmployeeProfile> registerEmployeeProfile(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException;

    InvocationContext<EmployeeProfile> editEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException;

    InvocationContext removeEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException;

    InvocationContext<List<EmployeeProfile>> getAllEmployeeProfile(ServiceContext sc) throws BaseException;

    InvocationContext<EmployeeProfile> getEmployeeByNationalCode(ServiceContext sc, String state) throws BaseException;

}
