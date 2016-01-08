package util;

import listen.context;

public class TestSingle {

	
	public static void main(String[] args) {
		//相同
		SingletonHolder s1 = SingletonHolder.getInstance();
		SingletonHolder s2 = SingletonHolder.getInstance();
		if( s1 == s2 ){
			System.out.println( "true" );
		}
		
		LazySingleton l1 = LazySingleton.getInstance();
		LazySingleton l2 = LazySingleton.getInstance();
		if( l1 == l2){
			System.out.println("true");
		}
		
		//不同
		context c1 = new context();
		context c2 = new context();
		if( c1 == c2 ){
			System.out.println("true");
		}
		
	}
}
