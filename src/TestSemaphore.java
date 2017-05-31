
public class TestSemaphore {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(1);
		for(int i=0;i<10;i++)
		{
			new MutexThread(s,"thread"+i);
		}
	}
}

class MutexThread extends Thread{
	private Semaphore mutex;
	MutexThread(Semaphore mutex, String name)
	{
		super(name);
		this.mutex = mutex;
		start();
	}
	
	public void run()
	{
		while(true)
		{
			//System.out.println("Inside Run while");
			mutex.down();
			System.out.println("Enter critical section "+getName());
			try {
				sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Leaving the critical section "+getName());
			mutex.up();
		}
	}
}

class Semaphore{
	private int value;
	
	Semaphore(int v)
	{
		//System.out.println("Semaphore constructor"+value);
		if(v<0)
		{
			v = 0;
		}
		value = v;
		//System.out.println("value "+this.value);
	}
	
	public synchronized void down()
	{
		//System.out.println("down "+value+" current thread "+Thread.currentThread().getName());
		while(value==0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value--;
	}
	
	public synchronized void up()
	{
		value++;
		notify();
	}
}

