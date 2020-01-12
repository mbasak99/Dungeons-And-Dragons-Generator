package mbasak;

import dnd.models.Trap;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoorTest {

    private Door door1;
    
    public DoorTest() {
    }

    @Before
    public void setup() {

        door1 = new Door(1);
    }

    /*This checks that */
    @Test
    public void testConstructor() {
        System.out.println("test Constructor");
        assertNotNull(door1.getConnectionToChambers());
        assertTrue(door1.getIndex() > 0);

    }

    @Test
    public void testIsTrapped() {
        System.out.println("test isTrapped");
        if (door1.isTrapped()) {
            assertTrue(door1.isTrapped());
        } else {
            assertFalse(door1.isTrapped());
        }
     }

    @Test
    public void testIsOpen() {
        System.out.println("test isOpen");
        if (door1.isOpen()) {
            assertTrue(door1.isOpen());
        } else {
            assertFalse(door1.isOpen());
        }
    }

    @Test
    public void testIsArchway() {
        System.out.println("test isArchway");
        if (door1.isArchway()) {
            assertTrue(door1.isArchway());
            assertTrue(door1.isOpen());
            assertFalse(door1.isTrapped());
        } else {
            assertFalse(door1.isArchway());
        }
    }

    @Test
    public void testGetSpaces() {
        System.out.println("test getSpaces");
        assertNotNull(door1.getSpaces());

        Chamber chamber = new Chamber();
        chamber.setDoor(door1);

        assertEquals(1, door1.getSpaces().size());
    }

    @Test
    public void testGetDescription() {
        System.out.println("test getDescription");
        assertNotNull(door1.getDescription());
        System.out.println(door1.getDescription());
    }

    @Test
    public void testSetConnection() {
        System.out.println("test setConnection");
        assertEquals(0, door1.getSpaces().size());
//        ArrayList<Space> test = new ArrayList<>();
        Chamber chamber = new Chamber();
//        test.add(chamber);

        door1.setConnection(chamber);
        assertEquals(1, door1.getSpaces().size());
    }

    @Test
    public void testGetIndex() {
        System.out.println("test getIndex");
        assertEquals(1, door1.getIndex());

        Door door2 = new Door(2);
        assertEquals(2, door2.getIndex());
    }

    @Test
    public void testSetConnectionToOther() {
        System.out.println("test setConnectionToOther");
        Chamber chamber1 = new Chamber();
        Chamber chamber2 = new Chamber();
        Chamber chamber3 = new Chamber();

        door1.setConnectionToOther(chamber1);
        door1.setConnectionToOther(chamber2);
        door1.setConnectionToOther(chamber3);

        assertEquals(3, door1.getConnectionToChambers().size());
    }

    @Test
    public void testGetConnectionToChambers() {
        System.out.println("test getConnectionToChambers");
        Chamber chamber1 = new Chamber();
        door1.setConnectionToOther(chamber1);
        assertEquals(1, door1.getConnectionToChambers().size());
        assertSame(chamber1, door1.getConnectionToChambers().get(0));
    }
   
    
/* set up similar to the sample in PassageTest.java */
    
}
