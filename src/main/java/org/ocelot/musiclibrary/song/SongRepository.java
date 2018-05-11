package org.ocelot.musiclibrary.song;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "songs", path = "songs")
public interface SongRepository extends MongoRepository<Song, String> { 

	public Optional<Song> findById(String id);
	
}


