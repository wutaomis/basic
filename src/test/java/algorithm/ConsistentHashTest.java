package algorithm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ConsistentHashTest {

	class Node
	{
		private String name;
		private int count;

		public Node(String name)
		{
			this.name = name;
			this.count = 0;
		}
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		public int getCount() {
			return count;
		}

		public void incCount() {
			this.count ++;
		}
		
		public void decCount() {
			this.count --;
		}
	}
	
	@Test
	public void testGetShardInfo() {
		List<Node> ln = new ArrayList<Node>();
		for (int i = 0 ; i < 8 ; i ++)
		{
			ln.add(new Node("SHARD-" + i));
		}
		ConsistentHash<Node> sn = new ConsistentHash<Node>(ln);
		
		for (int j =  0 ; j < 100000 ; j ++)
		{
			Node node = sn.getShardInfo("Random" + j);
			node.incCount();
		}
		
		for( Node n : ln)
		{
			System.out.println(n.getName() + ":" + n.getCount());
		}
	}

}
