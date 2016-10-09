package thread;

public class RunnableThread implements Runnable{
	private int i = 0;
	public void run() {
		// TODO Auto-generated method stub
		for ( i = 0 ; i < 20 ; i ++)
        {
        	System.out.println(Thread.currentThread().getName() + ":" + i);
        	if (i == 10)
        	{
        		try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
	}
	
}
