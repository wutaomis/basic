package thread;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaitTest {

	class WaitDemo
	{
		private int balance = 0;
		
		public synchronized void  add() throws InterruptedException
		{
			System.out.println("in add 1 " + balance);
			if (balance > 0)
			{
				System.out.println("in add 2");
				wait();
				System.out.println("in add 3");
			}
			
			{
				System.out.println("in add 4");
				balance ++;
				notifyAll();
			}
			System.out.println("in add 5 " + balance);
		}
		public synchronized void  del() throws InterruptedException
		{
			System.out.println("in del 1 " + balance);
			if (balance <= 0)
			{
				System.out.println("in del 2");
				wait();
				System.out.println("in del 3");
			}
			
			{
				System.out.println("in del 4");
				balance --;
				notifyAll();
			}
			System.out.println("in del 5 " + balance);
		}
	}
	class AddThread extends Thread
	{
		private WaitDemo wd;
		public AddThread(WaitDemo wd)
		{
			this.wd = wd;
		}
		@Override
		public void run()
		{
			try {
				for (int i = 0 ; i < 5;i ++)
				{
					wd.add();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class DelThread extends Thread
	{
		private WaitDemo wd;
		public DelThread(WaitDemo wd)
		{
			this.wd = wd;
		}
		@Override
		public void run()
		{
			try {
				for (int i = 0 ; i < 5;i ++)
				{
					wd.del();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Test
	public void testWait() {
		WaitDemo wd = new WaitDemo();
		Thread at = new AddThread(wd);
		Thread dt = new DelThread(wd);
		dt.start();
		at.start();
		
	}

}
