package thread;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Ignore;
import org.junit.Test;

public class ThreadPoolTest {
	@Ignore
	@Test
	public void testThreadPool() {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		Runnable st = ()->{
			for (int i = 0 ; i < 10; i ++)
			{
				System.out.println(Thread.currentThread().getName() + " : " + i);
			}
		};
		pool.submit(st);
		pool.submit(st);
		pool.shutdown();
	}

}
