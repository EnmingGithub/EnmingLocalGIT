package com.testingproject.cctesting.externalquery;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.*;
@Component
public class NodeQuery {

    final String uri = "https://jsonplaceholder.typicode.com/posts";
	RestTemplate restTemplate = new RestTemplate();
	Node[] result = restTemplate.getForObject(uri, Node[].class);
	
	public Node[] getAll(){
		return result;
	}
	
	public List<Node> get(Long id){
		List<Node> getresult = new ArrayList<>();
		for(int i = 0;i<result.length;i++){
			Node curr = result[i];
			if (curr.getUserId() == id){
				getresult.add(curr);
			}
		}
		return getresult;
	}
}
