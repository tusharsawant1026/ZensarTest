package com.zensar;

import java.io.File;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.Model.Posts;

@SpringBootApplication
public class ZensarTestApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ZensarTestApplication.class, args);
	}


}
