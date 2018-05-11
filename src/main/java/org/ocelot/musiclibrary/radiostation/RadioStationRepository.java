package org.ocelot.musiclibrary.radiostation;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "radiostations", path = "radiostations")
public interface RadioStationRepository extends MongoRepository<RadioStation, String> { 

	public Optional<RadioStation> findById(String id);
	
}


