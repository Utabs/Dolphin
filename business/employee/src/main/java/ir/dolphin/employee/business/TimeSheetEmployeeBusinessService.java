package ir.dolphin.employee.business;


import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.employee.TimeSheetTO;

import java.util.List;

public interface TimeSheetEmployeeBusinessService {

    InvocationContext<TimeSheetTO> registerTimeSheetByEmployeeIdAndShopId(ServiceContext sc, TimeSheetTO timeSheetTO) throws BaseException;

    InvocationContext<List<TimeSheetTO>> getAllTimeSheetByEmployeeId(ServiceContext sc) throws BaseException;

    InvocationContext<TimeSheetTO> getTimeSheetByEmployeeIdAndShopId(ServiceContext sc, String nationalCode) throws BaseException;

    InvocationContext<TimeSheetTO> editTimeSheetById(ServiceContext sc, TimeSheetTO timeSheetTO) throws BaseException;

    InvocationContext<TimeSheetTO> removeTimeSheetById(ServiceContext sc, TimeSheetTO timeSheetTO) throws BaseException;
}
