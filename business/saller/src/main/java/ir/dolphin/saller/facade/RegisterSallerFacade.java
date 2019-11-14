package ir.dolphin.saller.facade;


import ir.dolphin.base.BaseException;
import ir.dolphin.base.InvocationContext;
import ir.dolphin.base.ServiceContext;
import ir.dolphin.model.entity.saller.SallerProfile;

import java.util.List;

public interface RegisterSallerFacade {
    public InvocationContext<SallerProfile> insert(ServiceContext serviceContext, SallerProfile sallerProfile) throws BaseException;
    public InvocationContext<List<SallerProfile>> getAllSallers(ServiceContext sc) throws BaseException;
    public InvocationContext<SallerProfile> getSallerByNationalCode(ServiceContext serviceContext, String nationalCode) throws BaseException;
    InvocationContext<SallerProfile> edit(ServiceContext sc, SallerProfile sallerProfile)throws BaseException ;
    InvocationContext<SallerProfile> delete(ServiceContext sc, SallerProfile sallerProfile) throws BaseException;
}
