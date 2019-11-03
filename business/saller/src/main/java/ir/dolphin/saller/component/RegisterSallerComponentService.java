package ir.dolphin.saller.component;

import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.saller.SallerProfile;
import ir.dolphin.model.entity.Address;

import java.util.List;

public interface RegisterSallerComponentService {
    InvocationContext<SallerProfile> insert(ServiceContext sc, SallerProfile sallerProfile) throws BaseException;
    InvocationContext<Address> update(ServiceContext sc, Address address) throws BaseException;
    InvocationContext delete(ServiceContext sc, Address address) throws BaseException;
    InvocationContext<Address> getById(ServiceContext sc, Long id) throws BaseException;
    InvocationContext<List<SallerProfile>> getAll(ServiceContext sc) throws BaseException;
    InvocationContext<SallerProfile> getByState(ServiceContext sc, String state) throws BaseException;

}
