package ir.dolphin.web.webservice;

import com.google.gson.Gson;
import ir.dolphin.base.*;
import ir.dolphin.model.entity.Address;
import ir.dolphin.shop.facade.RegisterAddressFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person")
public class RegisterAddressWebService {
    @Autowired
    RegisterAddressFacade registerAddressFacade;

    public RegisterAddressWebService() {
        System.out.println("Heloo constructor");
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert() {
		try {

            ServiceContext sc =new ServiceContext();
            Gson gson= new Gson();
            Address address = new Address();
            address.setState("sss");
            InvocationContext<Address> addressInvocationContext = registerAddressFacade.insert(sc,address);
            System.out.println(addressInvocationContext.getData().getState());
            System.out.println(addressInvocationContext.getData().getID());
            return gson.toJson(address);
        }catch (BaseException e){
		    return e.toJson();
		} catch (Exception e) {
            return (new BaseException(null, e, e.getMessage(), Layer.WEB_SERVICE, Module.SHOP)).toJson();
		}
	}
/*

    @RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		try {

            Address  address=new Address();
            address.setState("sss");
            InvocationContext<Address> addressInvocationContext = registerAddressFacade.update(address);

            System.out.println(addressInvocationContext.getData().getState());
            System.out.println(addressInvocationContext.getData().getID());

			return "get----------------";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		try {

            Address  address=new Address();
            address.setState("sss");
            InvocationContext<Address> addressInvocationContext = registerAddressFacade.delete(address);

            System.out.println(addressInvocationContext.getData().getState());
            System.out.println(addressInvocationContext.getData().getID());

			return "get----------------";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
	public String getById() {
		try {

            Address  address=new Address();
            address.setState("sss");
            InvocationContext<Address> addressInvocationContext = registerAddressFacade.getById(address);

            System.out.println(addressInvocationContext.getData().getState());
            System.out.println(addressInvocationContext.getData().getID());

			return "get----------------";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String getAll() {
		try {

            Address  address=new Address();
            address.setState("sss");
            InvocationContext<Address> addressInvocationContext = registerAddressFacade.getAll(address);

            System.out.println(addressInvocationContext.getData().getState());
            System.out.println(addressInvocationContext.getData().getID());

			return "get----------------";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

*/
    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public String create2() {
        try {

            System.out.println("post");

            return "post---------------";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
