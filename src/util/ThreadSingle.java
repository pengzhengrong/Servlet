package util;

public class ThreadSingle {

	public static void main(String[] args) {
		new thread1().start();
		
		new thread2().start();
		
	}
}


class thread1 extends Thread{
	
	public void run(){
		SingletonHolder s1 = SingletonHolder.getInstance();
		System.out.println(" this is t1");
	}
	
}

class thread2 extends Thread{
	
	public void run(){
		SingletonHolder s2 = SingletonHolder.getInstance();
		System.out.println(" this is t2");
		s2.createString();
	}
	
}

