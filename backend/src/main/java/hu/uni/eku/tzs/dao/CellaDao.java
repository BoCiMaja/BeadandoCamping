package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Cella;

import java.util.Collection;
import java.util.UUID;

public interface CellaDao {

    void create(Cella cella);

    Collection<Cella> readAll();

    void update(int celladId, Cella updated);

    void delete(int cellaId);
}