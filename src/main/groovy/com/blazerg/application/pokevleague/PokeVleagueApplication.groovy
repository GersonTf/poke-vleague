package com.blazerg.application.pokevleague

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@SpringBootApplication
@EnableAutoConfiguration
class PokeVleagueApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World2!"
	}

	static void main(String[] args) {
		SpringApplication.run PokeVleagueApplication, args
	}
}
