package datashare;

public class ThreadLocalExample {
	/*
	 * Using ThreadLocal we can create and retreive data by the same thread
	 * If we have multiple classes running in parallel with a thread count of 2,
	 * without threadlocal any thread can access any classes 
	 * but by using threadlocal, only one thread can create and retreive at a time
	 */
	public static void main(String[] args) {
		ThreadLocal thread=new ThreadLocal<>();
		thread.set("Magesh");
		String value=(String) thread.get();
		System.out.println(value);
		thread.remove();
		System.out.println(thread.get());
		
		//Setting an initial value using ThreadLocal
		//withInitial method takes an supplier interface so we can make use of lambda expression
		ThreadLocal thread2=ThreadLocal.withInitial(()->1);
		
		System.out.println(thread2.get());
		
		//If we provide proper generic, it will suppress the warning message and avoid explicit casting
		ThreadLocal<Integer> thread3=new ThreadLocal<>();
		thread3.set(5);
		System.out.println(thread3.get());
	}
	

}
