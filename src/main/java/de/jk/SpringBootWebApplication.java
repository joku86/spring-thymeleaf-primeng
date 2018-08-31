package de.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import de.jk.fileupload.StorageProperties;


//http://www.thymeleaf.org/doc/articles/layouts.html
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringBootWebApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
//dieses projekt braucht noch die jpa einstellungen 
}