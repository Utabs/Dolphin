package ir.dolphin.shop.facade;

import ir.dolphin.base.*;
import ir.dolphin.model.entity.Address;
import ir.dolphin.shop.business.RegisterAddressBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("RegisterAddressFacade")
public class RegisterAddressFacadeImp implements RegisterAddressFacade {
    @Autowired
    RegisterAddressBusinessService registerAddressBusinessService;

    public InvocationContext<Address> insert(ServiceContext sc, Address address) throws BaseException {
        try {
            return registerAddressBusinessService.insert(sc,address);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.FACADE, Module.SHOP);
        }
    }
}
