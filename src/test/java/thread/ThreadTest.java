package thread;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreadTest {

	@Test
	public void testRun(){
		Thread st = new MultiThread();
		st.start();
		for (int i = 0 ; i < 20 ; i ++)
		{
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
