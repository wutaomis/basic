package thread;

public class MultiThread extends Thread{
	private int i = 0;
	@Override
    public void run() {
        for ( i = 0 ; i < 20 ; i ++)
        {
        	System.out.println(this.getName() + ":" + i);
        	if (i == 10)
        	{
        		try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
    }
	
}
