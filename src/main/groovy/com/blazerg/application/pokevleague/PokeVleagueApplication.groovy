package com.blazerg.application.pokevleague

import com.blazerg.application.pokevleague.telegramAMQP.RabbitAmqpRunner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@ComponentScan(basePackages = 'com.blazerg.application.pokevleague')
@EnableJpaRepositories(basePackages = 'com.blazerg.application.pokevleague.domain.repository')
@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
class PokeVleagueApplication {

    @Profile("usage_message")
    @Bean
    CommandLineRunner usage() {
        return new CommandLineRunner() {

            @Override
            void run(String... arg0) throws Exception {
                println("This app uses Spring Profiles to control its behavior.")
            }
        }
    }

    @Profile("!usage_message")
    @Bean
    CommandLineRunner lineRunnerTest() {
        return new RabbitAmqpRunner()
    }

	static void main(String[] args) {
		SpringApplication.run PokeVleagueApplication, args
	}
}
