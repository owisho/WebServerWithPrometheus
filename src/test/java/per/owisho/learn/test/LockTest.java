package per.owisho.learn.test;
import java.util.LinkedHashMap;

public class LockTest {

	private Object object =  new Object();
	
	public void add() {
		synchronized (object) {
			System.out.println("进入add方法");
		}
	}
	
	public void lockAdd() {
		synchronized (object) {
			System.out.println("进入锁住的add方法");
			add();
		}
	}
	
	public static void main(String[] args) {
		
		LockTest test = new LockTest();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.lockAdd();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.add();
			}
		});
		
		t1.start();
		t2.start();
	}
	
}
