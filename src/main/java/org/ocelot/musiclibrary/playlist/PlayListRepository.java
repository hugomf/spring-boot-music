package org.ocelot.musiclibrary.playlist;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "playlist", path = "playlist")
public interface PlayListRepository extends MongoRepository<PlayList, String>{

	public Optional<PlayList> findById(String id);
	
}
