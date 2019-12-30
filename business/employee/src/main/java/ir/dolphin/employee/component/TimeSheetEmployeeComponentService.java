package ir.dolphin.employee.component;

import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.Address;
import ir.dolphin.model.entity.employee.EmployeeProfile;

import java.util.List;

public interface TimeSheetEmployeeComponentService {
    InvocationContext<EmployeeProfile> insertTime(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException;
    InvocationContext<EmployeeProfile> updateTime(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException;
    InvocationContext deleteTime(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException;
    InvocationContext<Address> getTimeById(ServiceContext sc, Long id) throws BaseException;
    InvocationContext<Address> getTimeByDate(ServiceContext sc, Long id) throws BaseException;
    InvocationContext<List<EmployeeProfile>> getAllTime(ServiceContext sc) throws BaseException;

}
