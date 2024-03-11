import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestContainer {

    @Test
    public void testContainerInitiallyEmpty() {
        Container container = new Container();
        assertEquals(0, container.contains());
    }

    @Test
    public void testAddAmount() {
        Container container = new Container();
        container.addAmount(50);
        assertEquals(50, container.contains());
    }

    @Test
    public void testAddAmountWithOverflow() {
        Container container = new Container();
        container.addAmount(90);
        container.addAmount(20); // Adding more than capacity
        assertEquals(100, container.contains());
    }

    @Test
    public void testAddNegativeAmount() {
        Container container = new Container();
        container.addAmount(-20);
        assertEquals(0, container.contains());
    }

    @Test
    public void testRemoveAmount() {
        Container container = new Container();
        container.addAmount(50);
        container.removeAmount(30);
        assertEquals(20, container.contains());
    }

    @Test
    public void testRemoveAmountWithUnderflow() {
        Container container = new Container();
        container.addAmount(50);
        container.removeAmount(70); // Trying to remove more than available
        assertEquals(50, container.contains());
    }

    @Test
    public void testRemoveNegativeAmount() {
        Container container = new Container();
        container.addAmount(50);
        container.removeAmount(-20);
        assertEquals(50, container.contains());
    }

    @Test
    public void testMoveAmount() {
        Container container1 = new Container();
        Container container2 = new Container();
        container1.addAmount(50);
        container1.move(30, container2);
        assertEquals(20, container1.contains());
        assertEquals(30, container2.contains());
    }

    @Test
    public void testMoveAmountWithEmptyContainer() {
        Container container1 = new Container();
        Container container2 = new Container();
        container1.move(30, container2); // Trying to move from an empty container
        assertEquals(0, container1.contains());
        assertEquals(0, container2.contains());
    }

    @Test
    public void testMoveNegativeAmount() {
        Container container1 = new Container();
        Container container2 = new Container();
        container1.addAmount(50);
        container1.move(-30, container2);
        assertEquals(50, container1.contains());
        assertEquals(0, container2.contains());
    }

    @Test
    public void testToString() {
        Container container = new Container();
        container.addAmount(70);
        assertEquals("70/100", container.toString());
    }
}