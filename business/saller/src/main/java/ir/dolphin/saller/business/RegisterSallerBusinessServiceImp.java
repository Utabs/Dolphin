package ir.dolphin.saller.business;

import ir.dolphin.base.*;
import ir.dolphin.model.entity.saller.SallerProfile;
import ir.dolphin.saller.component.RegisterSallerComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("RegisterSallerBusinessService")
@Transactional
public class RegisterSallerBusinessServiceImp implements RegisterSallerBusinessService {
    @Autowired
    RegisterSallerComponentService registerSallerComponentService;


    public InvocationContext<SallerProfile> insert(ServiceContext sc, SallerProfile sallerProfile) throws BaseException {
        try {
            InvocationContext<SallerProfile> sallerProfileDtoInvocationContext = new InvocationContext<SallerProfile>();
            sallerProfileDtoInvocationContext = registerSallerComponentService.insert(sc, sallerProfile);
            return sallerProfileDtoInvocationContext;

        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<List<SallerProfile>> getAllSallers(ServiceContext sc) throws BaseException {
        try {
            InvocationContext<List<SallerProfile>> sallerProfileDtoInvocationContext = new InvocationContext<List<SallerProfile>>();
            sallerProfileDtoInvocationContext = registerSallerComponentService.getAll(sc);
            return sallerProfileDtoInvocationContext;

        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<SallerProfile> getSallerByNationalCode(ServiceContext sc, String nationalCode) throws BaseException {
        InvocationContext<SallerProfile> sallerProfileDtoInvocationContext = new InvocationContext<SallerProfile>();
        try {
            sallerProfileDtoInvocationContext = registerSallerComponentService.getSallerByNationalCode(sc, nationalCode);
            return sallerProfileDtoInvocationContext;

        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<SallerProfile> editSallerInfo(ServiceContext sc, SallerProfile sallerProfile) throws BaseException {
        InvocationContext<SallerProfile> editSallerProfileInvocationContext = new InvocationContext<SallerProfile>();
        try {
            editSallerProfileInvocationContext = registerSallerComponentService.update(sc, sallerProfile);
            return editSallerProfileInvocationContext;
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

    @Override
    public InvocationContext<SallerProfile> delete(ServiceContext sc, SallerProfile sallerProfile) throws BaseException {
        InvocationContext<SallerProfile> deleteSallerProfileInvocationContext = new InvocationContext<SallerProfile>();
        try {
            deleteSallerProfileInvocationContext = registerSallerComponentService.delete(sc, sallerProfile);
            return deleteSallerProfileInvocationContext;
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw new BaseException(null, e.getMessage(), Layer.BUSINESS, Module.SALLER);
        }
    }

}

