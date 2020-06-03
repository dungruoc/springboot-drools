package ifi.edu.rsc.demo.rules;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;

public class RuleRepository {
    static public RuleBase ruleBase = null;


  static public void BuildRules(String rules) {
    try {
      // String ruleFile = "/com/rule/Rules.drl";
      // InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
      // Reader reader = new InputStreamReader(resourceAsStream);

      Reader reader = new StringReader(rules);
      PackageBuilder packageBuilder = new PackageBuilder();
      packageBuilder.addPackageFromDrl(reader);
      org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
      ruleBase = RuleBaseFactory.newRuleBase();
      ruleBase.addPackage(rulesPackage);
    } catch (Exception e) {
    }
  }

}