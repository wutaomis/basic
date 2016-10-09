package zookeeper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class Client implements Watcher{
	private ZooKeeper zk = null;
	public static String url = "192.168.12.112:2181";
	public static String config = "/config";
	public static String username = config + "/username";
	public static String password = config + "/password";
	public void initZK()
	{
		try {
			zk = new ZooKeeper(url,3000,this);
			while (zk.getState() != ZooKeeper.States.CONNECTED)
			{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		if (zk != null)
		{
			try {
				zk.close();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception
	{
		Client ct = new Client();
		ct.initZK();
		
		int i = 0;
		while (true)
		{
			Thread.sleep(10000);
			if (i == 5)
			{
				break;
			}
			else
			{
				System.out.println(i);
				i ++;
			}
		}
		
	}
	@Override
	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event);
		if (zk != null)
		{
			try {
				zk.addAuthInfo("digest", "password".getBytes());
				byte[] data = zk.getData(username, true, null);
				try {
					System.out.println(new String(data,"GBK"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (KeeperException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
