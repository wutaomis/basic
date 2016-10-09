package thread;

import static org.junit.Assert.*;

import org.junit.Test;

public class RunnableThreadTest {

	@Test
	public void testRun() {
		
		new Thread(new RunnableThread()).start();
		for (int i = 0 ; i < 20 ; i ++)
		{
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
	@Test
	public void testJoin() throws Exception {
		Thread st = new Thread(new RunnableThread());
		st.start();
		st.join();
		for (int i = 0 ; i < 20 ; i ++)
		{
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		StringBuilder sb = new StringBuilder();
		StringBuffer sbu = new StringBuffer();
		
	}
}
