package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/*h public class TasksApplication extends SpringBootServletInitializer{*/
	public class TasksApplication {
	public static void main(String[] args) {

		SpringApplication.run(TasksApplication.class, args);
	}

/*//h	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(TasksApplication.class);
		}*/

}
