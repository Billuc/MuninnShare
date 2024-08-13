package com.muninn.share;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.muninn.share.controllers.Controllers;
import com.muninn.share.exceptions.Exceptions;
import com.muninn.share.models.Models;
import com.muninn.share.repositories.Repositories;

@SpringBootApplication(scanBasePackageClasses = {
		Models.class,
		Repositories.class,
		Exceptions.class,
		Controllers.class,
})
public class ShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareApplication.class, args);
	}

}
