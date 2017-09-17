package com.blazerg.application.pokevleague

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@ComponentScan(basePackages = 'com.blazerg.application.pokevleague')
@EnableJpaRepositories(basePackages = 'com.blazerg.application.pokevleague.domain.repository')
@EnableAutoConfiguration
@SpringBootApplication
class PokeVleagueApplication {

	static void main(String[] args) {
		SpringApplication.run PokeVleagueApplication, args
	}
}
