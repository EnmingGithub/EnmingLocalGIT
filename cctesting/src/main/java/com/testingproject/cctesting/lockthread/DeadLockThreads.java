package com.testingproject.cctesting.lockthread;

import org.springframework.stereotype.Component;

@Component
public class DeadLockThreads {
	String str1 = "Thread1";
    String str2 = "Thread2";
     
    Thread trd1 = new Thread("TestingThread 1"){
        public void run(){
            while(true){
                synchronized(str1){
                    synchronized(str2){
                        System.out.println(str2+" under "+str1);
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("TestingThread 2"){
        public void run(){
            while(true){
                synchronized(str2){
                    synchronized(str1){
                        System.out.println(str1+" under "+str2);
                    }
                }
            }
        }
    };
     
    public String[] start(){
    	String[] result = new String[2];
        trd1.start();
        result[0]= trd1.getName()+"(ID:"+trd1.getId()+")";
        trd2.start();
        result[1]= trd2.getName()+"(ID:"+trd2.getId()+")";
        return result;
    }
}
