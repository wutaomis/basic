package reflection;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectionTest {

	@Test
	public void test() {
		String str = "wutao";
		str.getClass();
		System.out.println(str.getClass());
		System.out.println(ReflectionTest.class);
	}

}
