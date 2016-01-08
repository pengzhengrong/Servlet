package util;

import java.util.HashMap;

/**
 * 购物车
 * @author pzr
 * 单例模式
 */
public class Cat {

	private static HashMap map = new HashMap();
	
	private Cat(){
		System.out.println("cat is created!");
	}
	
	private static class init{
		private static Cat cat = new Cat();
	}
	
	public static Cat getInstance(){
		return init.cat;
	}	
	
	
	private static class initCat{
		private static HashMap hash = new HashMap();
	}
	
	public static HashMap getCat(){
//		return initCat.hash;
		return init.cat.map;
	}
	
	private HashMap readResolve(){
		return initCat.hash;
	}

}

class TestCat{
	
	
	public static void main(String[] args) {
/*		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();*/
		Thread3 t1 = new Thread3();
		Thread4 t2 = new Thread4();
		t1.run();
		t2.run();
		
	}
	
}


class Thread1 extends Thread{
	
	public void run(){
		Cat.getCat().put("T1", "shoes");
		System.out.println(Cat.getCat().get("T1"));
	}
}

class Thread2 extends Thread{
	
	public void run(){
		Cat.getCat().put("T2", "flowers");
		System.out.println(Cat.getCat().get("T1"));
	}
}

class Thread3 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		Cat cat = Cat.getInstance();
		HashMap map = Cat.getCat();
		map.put("T3", "T3");
	}
	
}

class Thread4 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		Cat cat = Cat.getInstance();
		HashMap map = Cat.getCat();
		map.put("T4", "T4");
		System.out.println(map.get("T3"));
	}
	
}




