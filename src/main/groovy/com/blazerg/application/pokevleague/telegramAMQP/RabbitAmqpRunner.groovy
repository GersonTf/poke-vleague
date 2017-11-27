package com.blazerg.application.pokevleague.telegramAMQP

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ConfigurableApplicationContext

class RabbitAmqpRunner implements CommandLineRunner {

    @Value(/$[lineRunnerTest.client.duration:0]/)
    private int duration

    @Autowired
    private ConfigurableApplicationContext ctx

    @Override
    void run(String... arg0) throws Exception {
        println("Ready ... running for " + duration + "ms")
        Thread.sleep(duration)
        ctx.close()
    }
}