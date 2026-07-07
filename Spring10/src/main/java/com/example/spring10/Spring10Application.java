package com.example.spring10;

import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring10Application extends JFrame{
	public Spring10Application() {
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SpringApplication.run(Spring10Application.class, args);
	}

}
