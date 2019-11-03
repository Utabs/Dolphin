package ir.dolphin.saller.business;


import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.saller.SallerProfile;

import java.util.List;

public interface RegisterSallerBusinessService {
    InvocationContext<SallerProfile> insert(ServiceContext sc, SallerProfile sallerProfile) throws BaseException;
    InvocationContext<List<SallerProfile>> getAllSallers(ServiceContext sc) throws BaseException;
    InvocationContext<SallerProfile> getSallerByNationalCode(ServiceContext sc, String nationalCode) throws BaseException;

}
