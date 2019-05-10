package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {

	private Thread[] threads;
	private ConcurrentLinkedQueue<Task> taskQueue;
	
	public ThreadPool(int totalThreads){
		taskQueue = new ConcurrentLinkedQueue<Task>();
		threads = new Thread[totalThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(()->new Worker(taskQueue));
		}
	}
	
	public void addTask(Task task) {
		taskQueue.add(task);
	}
	
	public void start() {
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
