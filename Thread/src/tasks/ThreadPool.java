package tasks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	
	public static void main(String[] args) {
		

		ExecutorService pool = Executors.newFixedThreadPool(4);	 
		 Runnable t1=new MessagePrinter("t1");
		 Runnable t2=new MessagePrinter("t2");
		 Runnable t3=new MessagePrinter("t3");
		 Runnable t4=new MessagePrinter("t4");
		 
		 Thread th=new Thread(t1);

		 
		 pool.execute(t1);
	     pool.execute(t2);
	     pool.execute(t3);
	     pool.execute(t4);
	     pool.execute(th);
	     
	     pool.shutdown();
	}
	
	

}
