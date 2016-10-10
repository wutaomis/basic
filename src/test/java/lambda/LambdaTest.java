package lambda;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class LambdaTest {
	@Ignore
	@Test
	public void testLambda() {
		Lambda fi = src->Integer.valueOf(src);
		System.out.println(fi.convert("12"));
	}

}
