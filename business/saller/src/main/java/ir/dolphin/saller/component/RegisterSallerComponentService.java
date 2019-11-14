package ir.dolphin.saller.component;

import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.Address;
import ir.dolphin.model.entity.saller.SallerProfile;

import java.util.List;

public interface RegisterSallerComponentService {
    InvocationContext<SallerProfile> insert(ServiceContext sc, SallerProfile sallerProfile) throws BaseException;
    InvocationContext<SallerProfile> update(ServiceContext sc, SallerProfile sallerProfile) throws BaseException;
    InvocationContext delete(ServiceContext sc, SallerProfile sallerProfile) throws BaseException;
    InvocationContext<Address> getById(ServiceContext sc, Long id) throws BaseException;
    InvocationContext<List<SallerProfile>> getAll(ServiceContext sc) throws BaseException;
    InvocationContext<SallerProfile> getSallerByNationalCode(ServiceContext sc, String state) throws BaseException;

}
