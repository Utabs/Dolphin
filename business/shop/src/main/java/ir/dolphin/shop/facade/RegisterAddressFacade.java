package ir.dolphin.shop.facade;

import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.Address;

public interface RegisterAddressFacade {
    public InvocationContext<Address> insert(ServiceContext serviceContext, Address address) throws BaseException;

}
