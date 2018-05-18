package per.owisho.learn.test;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {

	public static void main(String[] args) {
		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
		try {
			queue.put(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Iterator<Integer> iterator = queue.iterator();
		try {
			queue.put(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
	
}
