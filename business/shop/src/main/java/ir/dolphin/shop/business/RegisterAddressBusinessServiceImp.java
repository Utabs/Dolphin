package ir.dolphin.shop.business;

import ir.dolphin.base.*;
import ir.dolphin.model.entity.Address;
import ir.dolphin.shop.component.RegisterAddressComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("RegisterAddressBusinessService")
@Transactional
public class RegisterAddressBusinessServiceImp implements RegisterAddressBusinessService {
    @Autowired
    RegisterAddressComponentService registerAddressComponentService;

    public InvocationContext<Address> insert(ServiceContext sc, Address address)throws BaseException  {


        try {
            InvocationContext<Address> addressInvocationContext = new InvocationContext<Address>();
            InvocationContext<List<Address>> addressesInvocationContext = new InvocationContext<List<Address>>();

            addressInvocationContext = registerAddressComponentService.insert(sc, address);

            addressInvocationContext = registerAddressComponentService.getById(sc, new Long("9"));
            Address address1 = addressInvocationContext.getData();
            address1.setState("qwe");
            addressInvocationContext = registerAddressComponentService.update(sc, address1);

            addressInvocationContext = registerAddressComponentService.getById(sc, new Long("3"));
            address1 = addressInvocationContext.getData();
            registerAddressComponentService.delete(sc, address1);


            addressesInvocationContext = registerAddressComponentService.getAll(sc);
            addressesInvocationContext = registerAddressComponentService.getByState(sc, "qwe");

            addressInvocationContext.setData(addressesInvocationContext.getData().get(0));
            return addressInvocationContext;

        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.BUSINESS, Module.SHOP);
        }
    }
}
