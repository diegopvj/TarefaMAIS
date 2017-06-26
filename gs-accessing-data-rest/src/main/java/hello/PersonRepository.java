package hello;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);
	List<Person> findByActive(@Param("active") boolean active); //Para encontrar todas Person com active=false por um endpoint RESTful:
																//(GET http://localhost:8080/people/search/findByActive?active=false) assumindo que existe Person previamente criada
}