package ir.dolphin.employee.facade;


import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.employee.EmployeeProfile;

import java.util.List;

//@Service("TimeSheetSellerFacade")
public class TimeSheetEmployeeFacadeImp implements RegisterEmployeeFacade {
//    @Autowired
//    TimeSheetEmployeeBusinessService timeSheetEmployeeBusinessService;

    @Override
    public InvocationContext<EmployeeProfile> registerEmployeeProfile(ServiceContext serviceContext, EmployeeProfile employeeProfile) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<List<EmployeeProfile>> getAllEmployeeProfile(ServiceContext sc) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<EmployeeProfile> getEmployeeByNationalCode(ServiceContext serviceContext, String nationalCode) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<EmployeeProfile> editEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<EmployeeProfile> removeEmployee(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        return null;
    }
}
