package ir.dolphin.employee.business;

import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.employee.TimeSheetTO;

import java.util.List;

//@Service("TimeSheetEmployeeBusinessService")
//@Transactional
public class TimeSheetEmployeeBusinessServiceImp implements TimeSheetEmployeeBusinessService {

    @Override
    public InvocationContext<TimeSheetTO> registerTimeSheetByEmployeeIdAndShopId(ServiceContext sc, TimeSheetTO timeSheetTO) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<List<TimeSheetTO>> getAllTimeSheetByEmployeeId(ServiceContext sc) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<TimeSheetTO> getTimeSheetByEmployeeIdAndShopId(ServiceContext sc, String nationalCode) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<TimeSheetTO> editTimeSheetById(ServiceContext sc, TimeSheetTO timeSheetTO) throws BaseException {
        return null;
    }

    @Override
    public InvocationContext<TimeSheetTO> removeTimeSheetById(ServiceContext sc, TimeSheetTO timeSheetTO) throws BaseException {
        return null;
    }
}

