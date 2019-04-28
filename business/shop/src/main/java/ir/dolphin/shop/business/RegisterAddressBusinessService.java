package ir.dolphin.shop.business;

import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.Address;

public interface RegisterAddressBusinessService {
    InvocationContext<Address> insert(ServiceContext sc, Address address) throws BaseException;
}
