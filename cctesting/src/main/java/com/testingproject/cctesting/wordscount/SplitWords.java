package com.testingproject.cctesting.wordscount;
import java.util.*;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
@Component
public class SplitWords {

	public Object[] splitwords(Entry<String,String> words){
		Map<String,Integer> wordsMap = new TreeMap<>();
		String[] wordsarray = words.getValue().split(" ");
		for (int i = 0;i < wordsarray.length;i++){
			if (wordsMap.containsKey(wordsarray[i])){
				wordsMap.put(wordsarray[i], wordsMap.get(wordsarray[i])+1);
			}else{
				wordsMap.put(wordsarray[i], 1);
			}
			
		}
		Object[] result = new Object[wordsMap.size()];
		Iterator i = wordsMap.entrySet().iterator();
		int idx = 0;
		while(i.hasNext()){
			Map.Entry entry = (Entry) i.next();
			result[idx++] = entry;
		}
		return result;
			
		}
		
	
}
