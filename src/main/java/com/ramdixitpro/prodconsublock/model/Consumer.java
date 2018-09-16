package com.ramdixitpro.prodconsublock.model;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private BlockingQueue<Integer> blockingQueue;
	private int MAX_SIZE;

	
	public Consumer(BlockingQueue<Integer> blockingQueue, int mAX_SIZE) {
		super();
		this.blockingQueue = blockingQueue;
		MAX_SIZE = mAX_SIZE;
	}



	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int consume(){
		int resitem=-1;
		try {
			resitem = blockingQueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resitem;
	}



	public void run() {
		for(int i=1; i <=MAX_SIZE ; i++){
			
			System.out.println("Consuming item "+ consume()+" by thread "+ Thread.currentThread().getId()+"["+ Thread.currentThread().getName()+"]");
		}
		
	}
}
