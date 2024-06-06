package com.yeshu.web.app.QuizApp;

import com.yeshu.web.app.QuizApp.controller.MarkLogicConnectionController;
import com.yeshu.web.app.QuizApp.service.MarkLogicConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class QuizAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(QuizAppApplication.class, args);
	}
}
