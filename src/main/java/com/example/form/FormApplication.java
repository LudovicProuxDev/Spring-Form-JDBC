package com.example.form;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;

@SpringBootApplication
public class FormApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(FormApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FormApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {
		log.info("Creating Database");
		log.info("Creating tables");
		try {
			// Use ScriptUtils to execute the SQL script
			ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(),
					new ClassPathResource("sql/script.sql"));
			log.info("Tables created");
		} catch (SQLException e) {
			log.error("Error creating tables");
			log.error("Show error: ", e);
			throw e;
		}
	}
}
