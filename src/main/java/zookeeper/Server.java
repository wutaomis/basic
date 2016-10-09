package zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class Server {

	public static String url = "192.168.12.112:2181";
	public static String config = "/config";
	public static String username = config + "/username";
	public static String password = config + "/password";
	public static void main(String[] args) throws Exception
	{
		ZooKeeper zk = new ZooKeeper(url,3000,new Watcher()
		{
			@Override
			public void process(WatchedEvent event) {
				// TODO Auto-generated method stub
				System.out.println(event);
			}
		});
		while (zk.getState() != ZooKeeper.States.CONNECTED)
		{
			Thread.sleep(3000);
		}
		zk.addAuthInfo("digest", "password".getBytes());
		if (zk.exists(config, true) == null)
		{
			zk.create(config,"".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		if (zk.exists(username, true) == null)
		{
			zk.create(username,"admin".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		if (zk.exists(password, true) == null)
		{
			zk.create(password,"123456".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		zk.close();
	}
}
