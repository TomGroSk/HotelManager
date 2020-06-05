package pl.gromadzki.manager.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gromadzki.manager.Entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
