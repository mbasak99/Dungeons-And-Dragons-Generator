package mbasak;

import dnd.models.Exit;
import dnd.models.Monster;
import dnd.models.Stairs;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;


public class PassageTest {
    //you don't have to use instance variables but it is easier
    // in many cases to have them and use them in each test
    private Passage passage1;
    private Passage passage2;
    private Door door1;
    private Door door2;

    public PassageTest() {
    }

    @Before
    public void setup(){
        //set up any instance variables here so that they have fresh values for every test
        passage1 = new Passage();
        passage2 = new Passage();
        door1 = new Door(1);
        door2 = new Door(2);
    }

    @Test
    public void testConstructor() {
        System.out.println("test constructor");
        assertNotNull(passage1.getDoors());
        assertNotNull(passage2.getDoors());

        assertNotNull(passage1.getDescription());
        assertNotNull(passage2.getDescription());
    }

    @Test
    public void testGetDoors() {
        System.out.println("test getDoors");
        assertNotNull(passage1.getDoors());
        assertNotNull(passage2.getDoors());

        assertEquals(0, passage1.getDoors().size());
        assertEquals(0, passage2.getDoors().size());

//        Door door1 = new Door(1);
//        Door door2 = new Door(2);
        passage1.setDoor(door1);
        passage1.setDoor(door2);

        passage2.setDoor(door1);
        passage2.setDoor(door2);

        assertEquals(2, passage1.getDoors().size());
        assertEquals(2, passage2.getDoors().size());
    }

    @Test
    public void testSetDoor() {
        System.out.println("test setDoor");

//        Door door1 = new Door(1);
//        Door door2 = new Door(2);
        passage1.setDoor(door1);
        passage1.setDoor(door2);

        passage2.setDoor(door1);

        assertEquals(2, passage1.getDoors().size());
        assertEquals(1, passage2.getDoors().size());
    }

    @Test
    public void testGetDescription() {
        System.out.println("test getDescription");
        assertNotNull(passage1.getDescription());
        assertNotNull(passage2.getDescription());

        System.out.println(passage1.getDescription());
        System.out.println(passage2.getDescription());

        passage1.setDoor(door1);
        passage1.setDoor(door2);

        passage2.setDoor(door1);
        passage2.setDoor(door2);

        System.out.println(passage1.getDescription());
        System.out.println(passage2.getDescription());
    }
  
}
