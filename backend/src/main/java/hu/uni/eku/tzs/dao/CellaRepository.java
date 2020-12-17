package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Cella;
import hu.uni.eku.tzs.dao.entity.Foglalas;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CellaRepository extends CrudRepository<Cella, Integer>
{
    Cella findByCellaId (int cellaId);
}