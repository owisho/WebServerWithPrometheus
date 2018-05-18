package per.owisho.learn.test;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkBlockingQueueTest {

	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
		QueueConsumer consumer = new QueueConsumer(queue);
		consumer.start();
		int num = 0;
		while (true) {
			num++;
			queue.add("s"+num);
		}
	}
	
}

class QueueConsumer extends Thread{
	
	private LinkedBlockingQueue<String> queue;
	
	public QueueConsumer(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(200);
				queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
