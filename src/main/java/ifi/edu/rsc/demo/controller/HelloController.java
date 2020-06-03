package ifi.edu.rsc.demo.controller;

import org.drools.core.StatelessSession;
import org.drools.core.WorkingMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ifi.edu.rsc.demo.model.Product;
import ifi.edu.rsc.demo.rules.RuleRepository;

@RestController
public class HelloController {

  @PostMapping("/product")
	public String executeDrools(@RequestBody Product product) {

    try {
      // WorkingMemory workingMemory = RuleRepository.ruleBase.newStatefulSession();
      StatelessSession aSession = RuleRepository.ruleBase.newStatelessSession();
      aSession.execute(product);
      // Product product = new Product();
      // product.setType("gold");
      // workingMemory.insert(product);
      // workingMemory.fireAllRules();
      // workingMemory.dispose();

      
      return "The discount for the product " + product.getType()
          + " is " + Integer.toString(product.getDiscount());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    return "Error";
	}

  @PostMapping("/rules")
	public String executeDrools(@RequestBody String rules) {
    // System.out.println(rules);
    RuleRepository.BuildRules(rules);
    return "OK";
	}

}

