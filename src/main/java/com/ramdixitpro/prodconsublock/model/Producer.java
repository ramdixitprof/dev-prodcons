package com.ramdixitpro.prodconsublock.model;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private BlockingQueue<Integer> blockingQueue;
	private int MAX_SIZE;

	

	public Producer(BlockingQueue<Integer> blockingQueue, int mAX_SIZE) {
		super();
		this.blockingQueue = blockingQueue;
		MAX_SIZE = mAX_SIZE;
	}

	public Producer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void produce(int item){
		try {
			blockingQueue.put(item);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		for(int i=1 ; i < MAX_SIZE ; i++){
			System.out.println("Prodcing item "+ i+" by thread "+ Thread.currentThread().getId()+"["+ Thread.currentThread().getName()+"]");
			produce(i);
		}
		
	}
}
