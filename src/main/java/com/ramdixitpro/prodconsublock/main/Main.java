package com.ramdixitpro.prodconsublock.main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.ramdixitpro.prodconsublock.model.Consumer;
import com.ramdixitpro.prodconsublock.model.Producer;

public class Main {

	public static void main(String[] args) {
	
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>();
		Producer producer = new Producer(blockingQueue,1000);
		Consumer cosnumer = new Consumer(blockingQueue,1000);
		
		/*Thread t1 = new Thread(producer);
		Thread t2 = new Thread(cosnumer);
		
		t1.start();
		t2.start();*/
		
		Executor executor = Executors.newCachedThreadPool();
		Executor executorConsumer = Executors.newCachedThreadPool();
		
		executor.execute(producer);
		executorConsumer.execute(cosnumer);
		

	}

}
