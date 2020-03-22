package com.ex.learnspring;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@ComponentScan("com.ex")
public class SleuthSampleApplication { 
  
  private static final Logger LOG = Logger.getLogger(SleuthSampleApplication.class.getName());
	
  @RequestMapping("/sleuth") 
  public String home() { 
    LOG.log(Level.INFO, "you called home"); 
    return "Hello World"; 
    
  } 
  
}