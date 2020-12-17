package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.CellaDao;
import hu.uni.eku.tzs.model.Cella;
import hu.uni.eku.tzs.service.exceptions.CellaAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.CellaNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CellaServiceImpl implements CellaService {
    private final CellaDao dao;

    @Override
    public void create(Cella cella)throws CellaAlreadyExistsException {
        final boolean alreadyExists = dao.fetchAll()
                .stream()
                .anyMatch(cell -> cell.getCellaId() == cella.getCellaId());
        if (alreadyExists){
            throw new CellaAlreadyExistsException(String.format("Cella (%s) már van!",cella.toString()));
        }
        dao.create(cella);

    }

    @Override
    public  Collection<Cella>fetchAll(){
        return dao.fetchAll();
    }

    @Override
    public void update(UUID cellaId, Cella updatedCella)throws CellaNotFoundException {
        dao.update(cellaId, updatedCella);
    }

    @Override
    public void delete(UUID cellaId)throws CellaNotFoundException{
        dao.delete(cellaId);
    }
}

/*
@Slf4j
@RequiredArgsConstructor
@Service
public class CellaServiceImpl implements CellaService {

    @Override
    public void record(Cella cella) throws CellaAlreadyExistsException {
        final boolean isAlreadyRecorded = CellaDao.readAll()
                .stream()
                .anyMatch( c ->
                        c.getCellaId() == cella.getCellaId()
                                &&
                                c.getErkezes() == cella.getErkezes());
        if(isAlreadyRecorded){
            log.info("Cella {} is already recorded!", cella);
            throw new CellaAlreadyExistsException(String.format("Cella (%s) already exists!", cella.toString()));

        }
        CellaDao.create(cella);
    }

    @Override
    public Collection<Cella> readAll() {
        return CellaDao.readAll();
    }
}

 */
