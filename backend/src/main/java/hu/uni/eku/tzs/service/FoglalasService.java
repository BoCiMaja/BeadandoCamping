package hu.uni.eku.tzs.service;


import hu.uni.eku.tzs.model.Foglalas;
import hu.uni.eku.tzs.service.exceptions.FoglalasAlreadyExistsExeptions;
import hu.uni.eku.tzs.service.exceptions.FoglalasNotFoundException;

import java.util.Collection;
import java.util.UUID;

public interface FoglalasService {

    void record(Foglalas foglalas)throws FoglalasAlreadyExistsExeptions;

    //void update(Integer Foglalas_Id, Foglalas updatedFoglalas)throws FoglalasNotFoundException;

    void  delete(Integer Foglalas_Id)throws FoglalasNotFoundException;

    Collection<Foglalas>readAll();
}
