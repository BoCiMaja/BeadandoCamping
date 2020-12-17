package hu.uni.eku.tzs.service;


import hu.uni.eku.tzs.model.Foglalas;
import hu.uni.eku.tzs.service.exceptions.FoglalasAlreadyExistsExeptions;
import hu.uni.eku.tzs.service.exceptions.FoglalasNotFoundException;

import java.util.Collection;
import java.util.UUID;

public interface FoglalasService {

    void create(Foglalas foglalas)throws FoglalasAlreadyExistsExeptions;

    Collection<Foglalas>fetchAll();

    void update(UUID Foglalas_Id, Foglalas updatedFoglalas)throws FoglalasNotFoundException;

    void  delete(UUID Foglalas_Id)throws FoglalasNotFoundException;
}
