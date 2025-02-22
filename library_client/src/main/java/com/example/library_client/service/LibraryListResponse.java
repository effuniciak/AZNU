package com.example.library_client.service;

import java.io.Serializable;
import java.util.*;
import org.example.types.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;

@JsonSerialize
public class LibraryListResponse implements Serializable{
	@SerializedName("libraries")
	public List<Library> libraries;
	
	public List<Library> getLibraries() {
		return libraries;
	}
	
	
}
