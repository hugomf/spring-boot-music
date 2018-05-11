package org.ocelot.musiclibrary.playlist;


import java.util.List;

import org.ocelot.musiclibrary.song.Song;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@Document
public class PlayList {
	
	@Id
	private String id;
	
	
	private String name;
	
	@DBRef
	private List<Song> songs;

	public PlayList(String name) {
		this.name = name;
	}
	
}
