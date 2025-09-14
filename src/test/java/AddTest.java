package tp1;

import org.junit.Test;
import static org.junit.Assert.*;

public class AddTest {

    @Test
    public void testAddPositifs() {
        Add add = new Add();
        assertEquals(5, add.add(2, 3));
    }

    @Test
    public void testAddNegatifs() {
        Add add = new Add();
        assertEquals(-1, add.add(2, -3));
    }

    @Test
    public void testAddZeros() {
        Add add = new Add();
        assertEquals(0, add.add(0, 0));
    }
}

