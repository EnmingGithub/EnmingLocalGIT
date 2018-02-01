package com.testingproject.cctesting.wordscount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.Map.Entry;
@RestController		
public class WordsCountController {

	@Autowired
	private SplitWords splitwords;
	
	@PostMapping(path="/wordscount")
	@ResponseStatus(HttpStatus.OK)
	public List<Object[]> wordscount(@RequestBody Map<String, String> words) throws Exception{
		Iterator i = words.entrySet().iterator();
		List<Object[]> r = new ArrayList<>();
		while(i.hasNext()){
			Map.Entry entry = (Entry) i.next();
			r.add(splitwords.splitwords(entry));
		}
		
		
		return r;
	}
}
