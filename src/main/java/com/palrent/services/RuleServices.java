package com.palrent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palrent.models.Offer;
import com.palrent.models.Rule;
import com.palrent.repositories.RuleRepositories;

@Service
public class RuleServices {
	@Autowired
	RuleRepositories rulerepositories;
	
	public List<Rule> allRules(){
		return rulerepositories.findAll();
	}
	
	public Rule createRule(Rule r) {
		return rulerepositories.save(r);
	}
	
	public Rule findRule(Long id) {
		Optional<Rule> optional = rulerepositories.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null ;
	}
	
	public Rule updateRule(Rule rule) {
		Optional<Rule> optional = rulerepositories.findById(rule.getId());
		if(optional.isPresent()) {
			return rulerepositories.save(rule);
		}
		return null ;
	}
	public void deleteRule(Long id) {
		rulerepositories.deleteById(id);
	}
	
	public List<Rule> allRulenotIn(Long ApaId){
		return rulerepositories.findAllRulwexclude(ApaId);
	}

}
