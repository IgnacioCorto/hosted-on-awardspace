package com.example.web;

import java.io.*;

public class Dog implements Serializable {

	private String breed;
	
	public Dog(String breed) {
		this.breed = breed;
	}
	
	public String getBreed() {
		return breed;
	}

}