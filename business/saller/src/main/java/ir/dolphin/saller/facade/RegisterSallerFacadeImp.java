package ir.dolphin.saller.facade;


import ir.dolphin.base.*;
import ir.dolphin.model.entity.saller.SallerProfile;
import ir.dolphin.saller.business.RegisterSallerBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RegisterSallerFacade")
public class RegisterSallerFacadeImp implements RegisterSallerFacade {
    @Autowired
    RegisterSallerBusinessService registerSallerBusinessService;

    @Override
    public InvocationContext<SallerProfile> insert(ServiceContext sc, SallerProfile sallerProfile) throws BaseException {
        try {
            return registerSallerBusinessService.insert(sc, sallerProfile);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.FACADE, Module.SHOP);
        }
    }

    @Override
    public InvocationContext<List<SallerProfile>> getAllSallers(ServiceContext sc) throws BaseException {
        try {

            return registerSallerBusinessService.getAllSallers(sc);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.FACADE, Module.SHOP);
        }
    }

    @Override
    public InvocationContext<SallerProfile> getSallerByNationalCode(ServiceContext sc, String nationalCode) throws BaseException {
        try {

            return registerSallerBusinessService.getSallerByNationalCode(sc,nationalCode);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.FACADE, Module.SHOP);
        }
    }


}
