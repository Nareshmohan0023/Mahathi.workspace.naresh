package tasks;

public class Hello implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println(Thread.currentThread().getName()+" :Hello");
			try {
				Thread.sleep(1500);
			}catch(InterruptedException e){
				System.err.println(e.getMessage());
			}
		}
		
	}

}
