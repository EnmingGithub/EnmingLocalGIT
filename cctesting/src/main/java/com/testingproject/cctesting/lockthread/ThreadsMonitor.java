package com.testingproject.cctesting.lockthread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import org.springframework.stereotype.Component;

@Component
public class ThreadsMonitor {
	public long[] monitor() {
	    ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
	    long[] threadIds = threadBean.findDeadlockedThreads();
	    return threadIds;
	}
}
