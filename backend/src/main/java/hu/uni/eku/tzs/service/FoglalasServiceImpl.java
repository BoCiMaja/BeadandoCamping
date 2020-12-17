package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.FoglalasDao;
import hu.uni.eku.tzs.model.Foglalas;
import hu.uni.eku.tzs.service.exceptions.FoglalasAlreadyExistsExeptions;
import hu.uni.eku.tzs.service.exceptions.FoglalasNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FoglalasServiceImpl implements FoglalasService {
    private final FoglalasDao dao;

    @Override
    public void create(Foglalas foglalas)throws FoglalasAlreadyExistsExeptions{
        final boolean alreadyExists = dao.fetchAll()
                .stream()
                .anyMatch(foglal -> foglal.getFoglalas_Id() == foglalas.getFoglalas_Id());
        if (alreadyExists){
            throw new FoglalasAlreadyExistsExeptions(String.format("Foglalás (%s) már van!",foglalas.toString()));
        }
        dao.create(foglalas);

    }

    @Override
    public  Collection<Foglalas>fetchAll(){
        return dao.fetchAll();
    }

    @Override
    public void update(UUID Foglalas_Id, Foglalas updatedFoglalas)throws FoglalasNotFoundException{
        dao.update(Foglalas_Id, updatedFoglalas);
    }

    @Override
    public  void delete(UUID Foglalas_Id)throws  FoglalasNotFoundException{
        dao.delete(Foglalas_Id);
    }
}
