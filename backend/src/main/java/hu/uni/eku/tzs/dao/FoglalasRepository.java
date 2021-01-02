package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Foglalas;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface FoglalasRepository extends CrudRepository<Foglalas, Integer>
{
    Foglalas findByFoglalasId (Integer FoglalasId);
}