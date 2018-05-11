package org.ocelot.musiclibrary.song;


import java.beans.Transient;
import java.io.File;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
@Document
public class Song  {
	
	@Id
	private String id;
	
	private byte[] artWork;
	
	private String artMimeType;
	
	private String path;
	
	private String fileName;
	
	private String artist;
	
	private String title;
	
	private String album;
	
	private String trackNumber;
	
	private String genre;
	
	private String author;
	
	private String year;
	
	@Transient
	public File getSongFile() {
		String filePath = getPath() + File.separator + getFileName();
		File songFile = new File(filePath);
		return songFile;
	}

}
