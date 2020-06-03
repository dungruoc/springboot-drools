package ifi.edu.rsc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifi.edu.rsc.demo.rules.RuleRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

    String rules = "package com.rule\n" +
    "import ifi.edu.rsc.demo.model.Product\n" +
    "rule \"Offer for Diamond\"\n" +
    "  when\n" + 
    "    productObject: Product(type==\"diamond\")\n" +
    "  then" +
    "    productObject.setDiscount(15);\n" +
    "  end\n" +
    "rule \"Offer for Gold\"\n" +
    "  when\n" +
    "    productObject: Product(type==\"gold\")\n" +
    "  then\n" +
    "    productObject.setDiscount(25);\n" +
		"  end";
		
		RuleRepository.BuildRules(rules);

		SpringApplication.run(DemoApplication.class, args);
	}

}
