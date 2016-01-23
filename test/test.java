import javassist.expr.NewArray;

import com.opensymphony.xwork2.util.finder.Test;


public class test implements Runnable {
	Timer timer=new Timer();
	public static void main(String[] args) {
		test test=new test();
		Thread t1=new Thread(test);
		Thread t2=new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		//t2.start();
	}

	@Override
	public void run() {
		timer.add(Thread.currentThread().getName());
	}

}
class Timer{
	private static int num=0;
	
	public void add(String name) {
		num++;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
			System.out.println(name+num);
		}
	}
