package com.testingproject.cctesting.externalquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.*;
@RestController
public class ExternalQueryController {
    
	@Autowired
	NodeQuery nodequery;
	@GetMapping(path="/extservice")
	public Node[] getall(){

		return nodequery.getAll();
	}
	
	@GetMapping(path="/extservice/{id}")
	public List<Node> get(@PathVariable Long id ){
		return nodequery.get(id);
	}
}
