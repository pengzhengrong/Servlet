package util;

import java.util.HashMap;

public class Cat2 {

	
	public static void main(String[] args) {
		
		T1 t1 = new T1();
		T2 t2 = new T2();
		t1.run();
		t2.run();
	}
}


class CatGoods{
	
	private CatGoods(){
		System.out.println("Cat goods created!");
	}
	
	private static HashMap map = null;
	
	public static HashMap getCat(){
		if( map == null){
			map = new HashMap();
		}
		return map;
	}
	
}


class T1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		HashMap map = CatGoods.getCat();
		map.put("T1", "T1");
		System.out.println(map.get("T1")+"  "+map.get("T2"));
	}
	
	
	
	
}

class T2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		HashMap map = CatGoods.getCat();
		map.put("T2", "T2");
		System.out.println(map.get("T1")+"  "+map.get("T2"));
	}
	
}






