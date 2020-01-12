package mbasak;

import dnd.models.Exit;
import dnd.models.Monster;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import mbasak.*;


public class PassageSectionTest {

    private PassageSection section1;
    
/* set up similar to the sample in PassageTest.java */
    public PassageSectionTest() {
    }

   @Before
    public void setup() {
       section1 = new PassageSection("");
   }

   @Test
    public void testConstructor() {
       System.out.println("test Constructor");
        assertNotNull(section1.getDescription());
        section1 = new PassageSection("This is a passage section");
        assertEquals("This is a passage section", section1.getDescription());
   }

    @Test
    public void testGetDoor() {
        System.out.println("test getDoor");
        assertNull(section1.getDoor());

        Door door = new Door(1);
        section1.setDoor(door);
        assertEquals(door, section1.getDoor());
    }

    @Test
    public void testGetMonster() {
        System.out.println("test getMonster");
        assertNull(section1.getMonster());

        Monster monster = new Monster();
        monster.setType(13);
        section1.setMonster(monster);
        assertEquals(monster, section1.getMonster());
    }

    @Test
    public void testGetDescription() {
        System.out.println("test getDescription");
        assertEquals("", section1.getDescription());
    }

    @Test
    public void testSetMonster() {
        System.out.println("test setMonster");
        assertNull(section1.getMonster());

        Monster monster = new Monster();
        monster.setType(15);
        section1.setMonster(monster);
        assertNotNull(section1.getMonster());
        assertEquals(monster, section1.getMonster());
        System.out.println(section1.getMonster().getDescription());
    }

    @Test
    public void testSetDoor() {
        System.out.println("test setDoor");
        assertNull(section1.getDoor());

        Door door = new Door(1);
        section1.setDoor(door);
        assertNotNull(section1.getDoor());
        assertEquals(door, section1.getDoor());
        System.out.println(section1.getDoor().getDescription());
    }


    
}
