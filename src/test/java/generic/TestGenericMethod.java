package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import cache.CacheTest;

public class TestGenericMethod {
	private static Logger log = LogManager.getLogger(CacheTest.class);
	static <T> void fromArrayToCollection(T[] a, Collection<T> c)
	{
		for (T o : a)
		{
			c.add(o);
		}
	}
	static void printCollection(Collection<?> c)
	{
		Iterator<?> it = c.iterator();
		while (it.hasNext())
		{
			log.info(it.next());
		}
	}
	static <T> void printCollection2(Collection<T> c)
	{
		for (T item : c)
		{
			log.info(item);
		}
	}
	@Ignore
	@Test
	public void test()
	{
		String[] strArr = {"a","b"};
		List<String> strList = new ArrayList<>();
		fromArrayToCollection(strArr,strList);
		printCollection(strList);
		printCollection2(strList);
	}
}
