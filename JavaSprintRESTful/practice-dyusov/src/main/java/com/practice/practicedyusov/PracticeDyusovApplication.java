package com.practice.practicedyusov;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeDyusovApplication {

	ArrayList<Light> listOfLight = new ArrayList<Light>();
	//добавление нового элемента в массив
	public static void main(String[] args) {
		SpringApplication.run(PracticeDyusovApplication.class, args);
	}
}
