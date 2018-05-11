package org.ocelot.musiclibrary.radiostation;


import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class RadioStation {
	
	@Id
	private String id;
	
	private byte[] artWork;
	
	private String name;
	
	private String localFrequency;

	private String description;
	
	private String genre;

	private String contentType;

	private String country;

	private String bitRate;
	
	private String url;
	
}
