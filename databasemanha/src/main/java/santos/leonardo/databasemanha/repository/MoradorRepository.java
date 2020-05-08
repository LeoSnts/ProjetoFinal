package santos.leonardo.databasemanha.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import santos.leonardo.databasemanha.model.MoradorEntity;

@Repository
public interface MoradorRepository extends CrudRepository<MoradorEntity, Long> {



}
