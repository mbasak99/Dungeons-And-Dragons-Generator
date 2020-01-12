package mbasak;

import dnd.die.D20;
import dnd.models.ChamberContents;
import dnd.models.ChamberShape;
import dnd.models.DnDElement;
import dnd.models.Monster;
import dnd.models.Stairs;
import dnd.models.Trap;
import dnd.models.Treasure;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChamberTest {
    private ChamberShape theShape;
    private ChamberContents theContents;

    public ChamberTest() {
    }

    @Before
    public void setup(){
    }

    @Test
    public void testConstructor() {
        System.out.println("test Constructor 1");
        Chamber chamber = new Chamber();

        assertNotNull(chamber.getDescription());
        assertNotNull(chamber.getDoors());
    }

    /*This test checks that the chamber actually generates doors when its object is created.*/
    @Test
    public void testGetDoors() {
        System.out.println("test getDoors");

        Chamber chamber = new Chamber();

        Door door1 = new Door(chamber.getDoors().size() + 1);
        chamber.setDoor(door1);

        Door door2 = new Door(chamber.getDoors().size() + 2);
        chamber.setDoor(door2);

//        assertEquals(doorsOfShape, chamber.getDoors().size());

        assertNotNull(chamber.getDoors());
    }


    /*This test checks that the chamber contains a monster IF the chamber rolls on monster.
    * If it doesn't roll a monster it checks that monster is NULL.*/
    @Test
    public void testGetMonsters() {
        System.out.println("test getMonster");

        Chamber chamber = new Chamber();
        if (chamber.getDescription().contains("(Monster)")) {
            assertNotNull(chamber.getMonster());
            System.out.println(chamber.getMonster().getDescription());
        } else {
            assertNull(chamber.getMonster());
        }

        Chamber chamber2 = new Chamber();
        if (chamber2.getDescription().contains("(Monster)")) {
            assertNotNull(chamber2.getMonster());
            System.out.println(chamber2.getMonster().getDescription());
        } else {
            assertNull(chamber2.getMonster());
        }
    }

    /*This test checks that if a chamber generates treasure it's null.
    * Otherwise it should be null.*/
    @Test
    public void testGetTreasure() {
        System.out.println("test getTreasure");

        Chamber chamber = new Chamber();
        if (chamber.getDescription().contains("(Treasure)")) {
            assertNotNull(chamber.getTreasure());
            System.out.println(chamber.getTreasure().getDescription());
        } else {
            assertNull(chamber.getTreasure());
        }

        Chamber chamber2 = new Chamber();
        if (chamber2.getDescription().contains("(Treasure)")) {
            assertNotNull(chamber2.getTreasure());
            System.out.println(chamber2.getTreasure().getDescription());
        } else {
            assertNull(chamber2.getTreasure());
        }
    }

    /*This test checks that depending on what's rolled by chamber it either contains those objects or if they aren't rolled, they're null.*/
    @Test
    public void testGetDescription() {
        System.out.println("test getDescription");

        Chamber chamber = new Chamber();

        assertNotNull(chamber.getDescription());

        if (chamber.getDescription().contains("(Monster)") && chamber.getDescription().contains("(Treasure)")) {
            assertNotNull(chamber.getMonster());
            assertNotNull(chamber.getTreasure());
            System.out.println(chamber.getMonster());
            System.out.println(chamber.getTreasure());

        } else if (chamber.getDescription().contains("(Monster)")) {
            assertNotNull(chamber.getMonster());
            System.out.println(chamber.getMonster());
        } else if (chamber.getDescription().contains("(Treasure)")) {
            assertNotNull(chamber.getTreasure());
            System.out.println(chamber.getTreasure());
        } else if (chamber.getDescription().contains("(Trap)")) {
            System.out.println("Chamber has a trap.");
        } else if (chamber.getDescription().contains("(Stairs)")) {
            System.out.println("Chamber has stairs");
        } else if (chamber.getDescription().contains("chamber is empty")){
            System.out.println("Chamber is empty");
        }
    }

    /*This test checks that the door sent in to chamber can be found meaning it set correctly.*/
    @Test
    public void testSetDoor() {
        System.out.println("test setDoor");

        Chamber chamber = new Chamber();
        Door door = new Door(chamber.getDoors().size() + 1);

        chamber.setDoor(door);
        assertEquals(door, chamber.getDoor(chamber.getDoors().size() - 1));
    }

    /*This test checks that any door sent into chamber can be retrieved and is the correct door.*/
    @Test
    public void testGetDoor() {
        System.out.println("test getDoor");

        Chamber chamber = new Chamber();
        Door door = new Door(chamber.getDoors().size() + 1);
        Door door2 = new Door(chamber.getDoors().size() + 2);

        chamber.setDoor(door);
        chamber.setDoor(door2);

        assertEquals(door, chamber.getDoor(chamber.getDoors().size() - 2));
        assertEquals(door2, chamber.getDoor(chamber.getDoors().size() - 1));
    }
    /* set up similar to the sample in PassageTest.java */

    
}