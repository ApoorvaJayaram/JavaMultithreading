public class MyThreads extends Thread {

	//static ArrayList<Integer> list;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//list = new ArrayList<Integer>();
		
		MyThreads t = new MyThreads();
		//t.run();
		
		for(int i=0;i<10;i++)
		{
			Thread n = new Thread(t,"t"+i);
			n.start();
		}
	
	}
	
	public void run()
	{
		System.out.println("Running thread "+Thread.currentThread().getName());
		try {
		Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" done with execution");
	}

}
