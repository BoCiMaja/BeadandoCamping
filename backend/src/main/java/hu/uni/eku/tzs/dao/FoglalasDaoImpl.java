package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Foglalas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RequiredArgsConstructor
@Service
public class FoglalasDaoImpl implements FoglalasDao {
    private final FoglalasRepository repository;

    @Override
    public void create(Foglalas foglalas) {
        repository.save(FoglalasEntityModelConverter.model2entity(foglalas));
    }

    @Override
    public Collection<Foglalas> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> FoglalasEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer Foglalas_Id, Foglalas updated) {
        hu.uni.eku.tzs.dao.entity.Foglalas temp = repository.findByFoglalas_Id(Foglalas_Id);
        temp.setFoglalas_Id(updated.getFoglalas_Id());
        temp.setCellaSzam(updated.getCellaSzam());
        temp.setErkezes(updated.getErkezes());
        temp.setTavozas(updated.getTavozas());
        temp.setVezeteknev(updated.getVezeteknev());
        temp.setKeresztnev(updated.getKeresztnev());
        temp.setTelefonszam(updated.getTelefonszam());
        temp.setTipus(updated.getTipus());
        temp.setAram(updated.isAram());
        repository.save(temp);
    }

    @Override
    public void delete(Integer Foglalas_Id) {
        hu.uni.eku.tzs.dao.entity.Foglalas temp = repository.findByFoglalas_Id(Foglalas_Id);
        if(temp != null)
            repository.delete(temp);
    }

    private static class FoglalasEntityModelConverter{

        private static Foglalas entity2model(hu.uni.eku.tzs.dao.entity.Foglalas entity){
            return new Foglalas(
                    entity.getFoglalas_Id(),
                    entity.getCellaSzam(),
                    entity.getErkezes(),
                    entity.getTavozas(),
                    entity.getVezeteknev(),
                    entity.getKeresztnev(),
                    entity.getTelefonszam(),
                    entity.getTipus(),
                    entity.isAram()

            );
        }

        private static hu.uni.eku.tzs.dao.entity.Foglalas model2entity(Foglalas model){
            return hu.uni.eku.tzs.dao.entity.Foglalas.builder()
                    .Foglalas_Id(model.getFoglalas_Id())
                    .cellaSzam(model.getCellaSzam())
                    .erkezes(model.getErkezes())
                    .tavozas(model.getTavozas())
                    .vezeteknev(model.getVezeteknev())
                    .keresztnev(model.getKeresztnev())
                    .telefonszam(model.getTelefonszam())
                    .tipus(model.getTipus())
                    .aram(model.isAram())
                    .build();
        }

    }
}