package ir.dolphin.web.webservice.saller;


import com.google.gson.Gson;
import ir.dolphin.base.*;
import ir.dolphin.model.entity.saller.SallerProfile;
import ir.dolphin.saller.facade.RegisterSallerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saller")
public class RegisterSallerWebService {
    @Autowired
    RegisterSallerFacade registerSallerFacade;

    @RequestMapping(value = "/registersaller", method = RequestMethod.POST)
    @ResponseBody
    public InvocationContext<SallerProfile> insert( @RequestBody  SallerProfile sallerProfile) {
        try {
            ServiceContext sc = new ServiceContext();
            Gson gson = new Gson();
            InvocationContext<SallerProfile> addressInvocationContext = registerSallerFacade.insert(sc, sallerProfile);

            return addressInvocationContext;
        } catch (BaseException e) {
            return  null;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/getallsaller", method = RequestMethod.POST)
    @ResponseBody
    public InvocationContext<List<SallerProfile>> getAllSaller() {
        try {
            ServiceContext sc = new ServiceContext();
            Gson gson = new Gson();
            InvocationContext<List<SallerProfile>> addressInvocationContext = registerSallerFacade.getAllSallers(sc);

            return addressInvocationContext;
        } catch (BaseException e) {
            return  null;
        } catch (Exception e) {
            return null;
        }
    }
    @RequestMapping(value = "/getsallerbynationalcod", method = RequestMethod.POST)
    @ResponseBody
    public InvocationContext<SallerProfile> getSaller(
            @RequestParam(value = "nationalCode", required = true) String nationalCode
    ) {
        try {
            ServiceContext sc = new ServiceContext();
            Gson gson = new Gson();
            InvocationContext<SallerProfile> sallerProfileInvocationContext = registerSallerFacade.getSallerByNationalCode(sc, nationalCode);

            return sallerProfileInvocationContext;
        } catch (BaseException e) {
            return  null;
        } catch (Exception e) {
            return null;
        }
    }
}
