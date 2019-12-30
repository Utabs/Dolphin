package ir.dolphin.employee.component;

import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.Address;
import ir.dolphin.model.entity.employee.EmployeeProfile;

import java.util.List;

//@Component("TimeSheetSellerComponentService")
//@Transactional(rollbackFor =RuntimeException.class,isolation = Isolation.DEFAULT,readOnly =false ,propagation = Propagation.MANDATORY,timeout = -1)
public class TimeSheetEmployeeComponentServiceImp implements TimeSheetEmployeeComponentService {
//
//    @Autowired
//    BaseDao baseDao;

    @Override
    public InvocationContext<EmployeeProfile> insertTime(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<EmployeeProfile> updateTime(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext deleteTime(ServiceContext sc, EmployeeProfile employeeProfile) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<Address> getTimeById(ServiceContext sc, Long id) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<Address> getTimeByDate(ServiceContext sc, Long id) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<List<EmployeeProfile>> getAllTime(ServiceContext sc) throws BaseException {
        return null;
    }
}
