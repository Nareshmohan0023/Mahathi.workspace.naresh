package tasks;

public class Welcome extends Thread {
	@Override
	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println(getName()+" :Welcome");
			try {
				Thread.sleep(1500);
			}catch(InterruptedException e){
				System.err.println(e.getMessage());
			}
		}
		
	}

}
