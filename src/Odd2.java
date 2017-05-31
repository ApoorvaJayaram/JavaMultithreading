class Odd {
	private int num;
	private Semaphore s;
	Odd(int n){
		s = new Semaphore(1);
		num = n;
	}
	
	int next()
	{
		s.down();
			++num;
			try
			{
				//System.out.println("Thread: "+Thread.currentThread().getName());
				Thread.sleep(10);
			}
			catch(Exception e)
			{
			}
			++num;
		s.up();
		return num;
	}
}
public class Odd2 extends Thread{
	private Odd e;
	Odd2(Odd e)
	{
		this.e = e;
	}
	
	public void run()
	{
		for(int i=1;i<=10;i++)
			System.out.println("result: "+e.next());
	}
	
	public static void main(String[] args)
	{
		Odd e = new Odd(1);
		Odd2 o1 = new Odd2(e);
		Odd2 o2 = new Odd2(e);
		
		o1.start();
		o2.start();
		
	}
}