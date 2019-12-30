package ir.dolphin.employee.facade;


import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.dto.timesheet.TimeSheetDto;
import ir.dolphin.model.entity.employee.TimeSheetTO;

import java.util.List;

public interface TimeSheetEmployeeFacade {
    InvocationContext<TimeSheetTO> registerTimeSheet(ServiceContext sc, TimeSheetDto timeSheetDto) throws BaseException;

    InvocationContext<TimeSheetTO> editTimeSheet(ServiceContext sc, TimeSheetTO timeSheetTO) throws BaseException;

    InvocationContext removeTimeSheet(ServiceContext sc, TimeSheetTO timeSheetTO) throws BaseException;

    InvocationContext<TimeSheetTO> getTimeSheetById(ServiceContext sc, Long id) throws BaseException;

    InvocationContext<TimeSheetTO> getTimeSheetByDate(ServiceContext sc, Long id) throws BaseException;

    InvocationContext<List<TimeSheetTO>> getAllTimeSheet(ServiceContext sc) throws BaseException;

}
