package com.ex.learnspring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.fluentd.logger.FluentLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;

@EnableAutoConfiguration
@RestController
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	private static FluentLogger LOG = FluentLogger.getLogger("fluentd.test");
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@GetMapping("/hello")
	public String sayHello()
	{
	    logger.debug("Debug log message from say hello without id...");
	    logger.info("Info log message from say hello without id...");
	    logger.error("Error log message from say hello without id...");
		return "Hello";
	}
	
	@GetMapping("hello/{id}")
	public String sayInput(@PathVariable("id") String id)
	{
		logger.debug("Debug log message from say hello with id...");
		logger.info("Info log message from say hello with id...");
		logger.error("Error log message from say hello with id...");
		return "Hello " + id;
	}
	
	@GetMapping("hello/log/{fluentd}")
	public String logInput(@PathVariable("fluentd") String fluentd)
	{
		logger.debug("Debug log message from log input with id...");
		logger.info("Info log message from log input with id...");
		logger.error("Error log message from log input with id...");
		
		Map<String, Object> data = new HashMap<String, Object>();
        data.put("from", "userA");
        data.put("to", "userB");
        LOG.log("follow", data);
		
		return "Hello " + fluentd;
	}
}
