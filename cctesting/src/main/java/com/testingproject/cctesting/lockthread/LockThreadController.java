package com.testingproject.cctesting.lockthread;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LockThreadController {

	@Autowired
	public ThreadsMonitor threadsmonitor;
	
	@Autowired
	public DeadLockThreads deadlockthreads;
	@GetMapping(path="/deadlockmonitor")
	public Map threadsmonitor(){
		Map<String,Long> result = new LinkedHashMap<>();
		long[] ids = threadsmonitor.monitor();
		if (ids != null){
			for (int i = 0;i<ids.length;i++){
				result.put("Thread"+(i+1)+" ID", ids[i]);
			}
		}
		result.put("Number of deadlocked threads", (long) (ids != null ? ids.length:0));
		return result;
	}
	
	@GetMapping(path="/threadsstart")
	public Map threadsstart(){
		String[] threadKeys = deadlockthreads.start();
		Map<String,String> result = new TreeMap<>();
		for (String key: threadKeys){
			result.put(key, "Start");
		}
		return result;
	}
}
