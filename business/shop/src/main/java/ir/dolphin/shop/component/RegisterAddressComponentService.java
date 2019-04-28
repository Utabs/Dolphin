package ir.dolphin.shop.component;

import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.Address;

import java.util.List;

public interface RegisterAddressComponentService {
    InvocationContext<Address> insert(ServiceContext sc, Address address) throws BaseException;
    InvocationContext<Address> update(ServiceContext sc, Address address) throws BaseException;
    InvocationContext delete(ServiceContext sc, Address address) throws BaseException;
    InvocationContext<Address> getById(ServiceContext sc, Long id) throws BaseException;
    InvocationContext<List<Address>> getAll(ServiceContext sc) throws BaseException;
    InvocationContext<List<Address>> getByState(ServiceContext sc, String state) throws BaseException;

}
