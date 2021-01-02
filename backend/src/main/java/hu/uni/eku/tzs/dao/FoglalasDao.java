package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Foglalas;

import java.util.Collection;
import java.util.UUID;

public interface FoglalasDao {

    void create(Foglalas foglalas);

    Collection<Foglalas> readAll();

    void update(Integer foglalasId, Foglalas updated);

    void delete(Integer foglalasId);
}