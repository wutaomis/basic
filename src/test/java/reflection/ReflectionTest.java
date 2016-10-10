package reflection;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class ReflectionTest {
	@Ignore
	@Test
	public void test() {
		String str = "wutao";
		str.getClass();
		System.out.println(str.getClass());
		System.out.println(ReflectionTest.class);
	}

}
