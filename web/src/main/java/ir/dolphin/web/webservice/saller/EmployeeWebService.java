package ir.dolphin.web.webservice.saller;


import com.google.gson.Gson;
import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.employee.facade.RegisterEmployeeFacade;
import ir.dolphin.model.entity.employee.EmployeeProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saller")
public class EmployeeWebService {
    @Autowired
    RegisterEmployeeFacade registerEmployeeFacade;

    @RequestMapping(value = "/registersaller", method = RequestMethod.POST)
    @ResponseBody
    public InvocationContext<EmployeeProfile> insert(@RequestBody EmployeeProfile employeeProfile) {
        try {
            ServiceContext sc = new ServiceContext();
            Gson gson = new Gson();
            InvocationContext<EmployeeProfile> addressInvocationContext = registerEmployeeFacade.registerEmployeeProfile(sc, employeeProfile);

            return addressInvocationContext;
        } catch (BaseException e) {
            return  null;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/deletesaller", method = RequestMethod.POST)
    @ResponseBody
    public InvocationContext<EmployeeProfile> deleteSaler(@RequestBody EmployeeProfile employeeProfile) {
        try {
            ServiceContext sc = new ServiceContext();
            Gson gson = new Gson();
            InvocationContext<EmployeeProfile> addressInvocationContext = registerEmployeeFacade.removeEmployee(sc, employeeProfile);

            return addressInvocationContext;
        } catch (BaseException e) {
            return  null;
        } catch (Exception e) {
            return null;
        }
    }


    @RequestMapping(value = "/editSaller", method = RequestMethod.POST)
    @ResponseBody
    public InvocationContext<EmployeeProfile> editSaller(@RequestBody EmployeeProfile employeeProfile) {
        try {
            ServiceContext sc = new ServiceContext();
            Gson gson = new Gson();
            InvocationContext<EmployeeProfile> addressInvocationContext = registerEmployeeFacade.editEmployee(sc, employeeProfile);

            return addressInvocationContext;
        } catch (BaseException e) {
            return  null;
        } catch (Exception e) {
            return null;
        }
    }




    @RequestMapping(value = "/getallsaller", method = RequestMethod.GET)
    @ResponseBody
    public InvocationContext<List<EmployeeProfile>> getAllSaller() {
        try {
            ServiceContext sc = new ServiceContext();
            Gson gson = new Gson();
            InvocationContext<List<EmployeeProfile>> addressInvocationContext = registerEmployeeFacade.getAllEmployeeProfile(sc);

            return addressInvocationContext;
        } catch (BaseException e) {
            return  null;
        } catch (Exception e) {
            return null;
        }
    }
    @RequestMapping(value = "/getsallerbynationalcod", method = RequestMethod.GET)
    @ResponseBody
    public InvocationContext<EmployeeProfile> getSaller(
            @RequestParam(value = "nationalCode", required = true) String nationalCode
    ) {
        try {
            ServiceContext sc = new ServiceContext();
            Gson gson = new Gson();
            InvocationContext<EmployeeProfile> sallerProfileInvocationContext = registerEmployeeFacade.getEmployeeByNationalCode(sc, nationalCode);
            return sallerProfileInvocationContext;
        } catch (BaseException e) {
            return  null;
        } catch (Exception e) {
            return null;
        }
    }
}
