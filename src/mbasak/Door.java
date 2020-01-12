package mbasak;
import dnd.die.D10;
import dnd.die.D20;
import dnd.die.D6;
import dnd.models.Trap;

import java.util.ArrayList;

public class Door {
    /**Contains the trap for a door, if it's trapped.*/
    private Trap doorTrap;
    /**Stores if door is trapped or not.*/
    private boolean trapDoor;
    /**Stores if door is open or closed.*/
    private boolean openDoor;
    /**Stores if door is an archway, making it open and free of traps.*/
    private boolean doorArchway;
    /**Contains the spaces (chamber/passage) that the door is connected by.*/
    private ArrayList<Space> theSpaces;
    /**20 sided dice for setting attributes.*/
    private D20 d20;
    /**6 sided dice for setting attributes.*/
    private D6 d6;
    /**10 sided dice for setting attributes.*/
    private D10 d10;

    private int index;

    private ArrayList<Chamber> connectionToChambers;

    /**Default constructor for door, initializes the spaces and description it will contain.
     * @param i This represents the position number of the door in some list.
     * @param flag This sets whether the door will be an archway or not.*/
    public Door(int i, boolean...flag) {
        //needs to set defaults
        theSpaces = new ArrayList<>();
        d20 = new D20();
        d6 = new D6();
        d10 = new D10();

        index = i;

        connectionToChambers = new ArrayList<>();

        setAttributes(flag);
    }

    /*-----------------------------
     Required Methods for that we will test during grading
    ------------------------------*/
    /* note:  Some of these methods would normally be protected or private, but because we
    don't want to dictate how you set up your packages we need them to be public
    for the purposes of running an automated test suite (junit) on your code.  */

    /**This function applies traps from trap table (if true) to a door object.
     * @param flag Whether the door is trapped (true) or not (false).
     * @param roll Can either have a roll passed to the function or generate it's own from 1-20.
     * */

    private void setTrapped(boolean flag, int... roll) {
        // true == trapped.  Trap must be rolled if no integer is given
        if (flag) { // Only rolls for trap if door is the 1/20
            int rollVal;

            if (roll.length == 0) { // No roll passed
                d20 = new D20();
                rollVal = d20.roll();
            } else {
                rollVal = roll[0];
            }

            doorTrap = new Trap();
            doorTrap.chooseTrap(rollVal);
        }

        trapDoor = flag;
    }
    /**
     * @param flag Whether the door is open (true) or closed (false). */
    private void setOpen(boolean flag) {
        //true == open
        if (!isArchway()) {
            openDoor = flag;
        }
    }

    /** This function will make the door open and free of traps if the door object created was an archway.
     * @param flag Whether the door is am archway (true) or a regular door (false). */
    private void setArchway(boolean flag) {
        //true == is archway
        doorArchway = flag;
        if (flag) {
            openDoor = true;
            trapDoor = false;
        }
    }

    /** This function checks if a door object is set as trapped.
     * @return isTrapped Returns if the value is trapped (true) or not (false).*/
    public boolean isTrapped() {

        return trapDoor;
    }
    /** This function checks if a door object is set as open.
     * @return isOpen Returns if the value is unlocked (true) or locked (false).*/
    public boolean isOpen() {

        return openDoor;
    }
    /** This function checks if the door object is an archway.
     * @return isArchway Returns if value is an archway (true) or a regular door (false).*/
    public boolean isArchway() {

        return doorArchway;
    }
    /** This function checks what traps are placed, if any.
     * @return Returns door object's trap description.*/
    private String getTrapDescription() {

        return doorTrap.getDescription() + "\n";
    }

    /**This function returns the chamber and passage connected by the door.
     * @return Returns array that contains a chamber and passage.*/
    public ArrayList<Space> getSpaces() {
        //returns the two spaces that are connected by the door
        return theSpaces;
    }

//    /**This function sets chamber and passage to be connected together through this door.
//     * @param spaceOne Chamber or Passage.
//     * @param spaceTwo Chamber or Passage.*/
//    private void setSpaces(Space spaceOne, Space spaceTwo) {
//        //identifies the two spaces with the door
//        // this method should also call the setDoor method from Space
//
//        spaceOne.setDoor(this);
//        spaceTwo.setDoor(this);
//    }

    /**This function gets the description of the door.
     * @return Returns a string describing details about the door.*/
    public String getDescription() {
        StringBuilder doorDesc = new StringBuilder();

        if (isTrapped()) {
            doorDesc.append("(Trapped): ");
            doorDesc.append(getTrapDescription() + "\n");
        }

        if (!isArchway()) { // Door isn't archway

            if (isOpen()) {
                doorDesc.append("(Open)\n");
            } else {
                doorDesc.append("(Locked)\n");
            }
        } else { // Door is archway
            doorDesc.append("(Archway)\n");
            doorDesc.append("(Open)\n");
        }

        return doorDesc.toString();
    }
/*------------
You can write your own methods too, you aren't limited to the required ones
-------------*/

    /**This function connects a passage or chamber to a door without needing both passage and chamber objects at the same time.
     * @param space This either the chamber or passage passed to the function.*/
    public void setConnection(Space space) {

        theSpaces.add(space);
    }

    /**This method retrieves the position number of the door.
     * @return Returns an integer that represents what position it is.*/
    public int getIndex() {

        return index;
    }

    /**This method sets the target chamber for a door.
     * @param chamber This the target chamber the door is getting set to.*/
    public void setConnectionToOther(Chamber chamber) {

        connectionToChambers.add(chamber);
    }

    /**This method retrieves an arraylist of chamber targets since a door may have 1 or more.
     * @return Returns an arraylist of chamber targets.*/
    public ArrayList<Chamber> getConnectionToChambers() {

        return connectionToChambers;
    }

    /**This method decides the description the door will have based on the roll for its attributes.
     * @param flag Whether the door is going to be archway (true for archway).*/
    private void setAttributes(boolean... flag) {
        if (d10.roll() == 1 || (flag.length != 0 && flag[0])) { // Door rolled to archway
            setArchway(true);
            setOpen(true);
            setTrapped(false);
        } else { // Didn't become an archway

            if (d20.roll() == 1) { // Roll for trapped
                setTrapped(true);
            } else {
                setTrapped(false);
            }

            if (d6.roll() == 1) { // Roll for open or locked
                setOpen(false); // 1/10 locked
            } else {
                setOpen(true); // 9/10 open
            }

            setArchway(false);
        }
    }
}
