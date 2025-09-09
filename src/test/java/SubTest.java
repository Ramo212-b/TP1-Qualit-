import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SubTest {

	@Test
	public void subtest() {
		Sub calculator = new Sub();
		
		assertEquals(2, calculator.sub(5,3));
		assertEquals(-1, calculator.sub(2,3));
		assertEquals(-5, calculator.sub(0,5));
		assertEquals(5, calculator.sub(5,0));
		assertEquals(-1, calculator.sub(-3,-2));
		assertEquals(-5, calculator.sub(-3,2));
	}
}		
		
