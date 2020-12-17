package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Cella;
import hu.uni.eku.tzs.service.exceptions.CellaAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.CellaNotFoundException;

import java.util.Collection;
import java.util.UUID;

public interface CellaService {

    void create(Cella cella)throws CellaAlreadyExistsException;

    Collection<Cella>fetchAll();

    void update(UUID cellaId, Cella updatedCella)throws CellaNotFoundException;

    void  delete(UUID cellaId)throws CellaNotFoundException;
}