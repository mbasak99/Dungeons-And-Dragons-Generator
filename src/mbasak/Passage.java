package mbasak;

import dnd.models.Monster;

import java.util.ArrayList;
/*
A passage begins at a door and ends at a door.  It may have many other doors along
the way

You will need to keep track of which door is the "beginning" of the passage
so that you know how to
*/

public class Passage extends Space {
    //these instance variables are suggestions only
    //you can change them if you wish.
    /**Stores all the passages that will be displayed.*/
    private ArrayList<PassageSection> thePassage;
    /**Stores all the doors that are generated.*/
    private ArrayList<Door> myDoors;
    /**Stores all the monsters that are generated.*/
    private ArrayList<Monster> passageMonsters;
    /**This stores the string for the entire passage description.*/
    private StringBuilder passageDesc;


    /*-----------------------------
     Required Methods for that we will test during grading
    ------------------------------*/
    /* note:  Some of these methods would normally be protected or private, but because we
    don't want to dictate how you set up your packages we need them to be public
    for the purposes of running an automated test suite (junit) on your code.  */
    /**This constructor is sets up all the instance variables needed when generating a new passage.*/
    public Passage() {
        thePassage = new ArrayList<>();
        passageDesc = new StringBuilder(); // Old section description
        myDoors = new ArrayList<>(); // List of door objects
        passageMonsters = new ArrayList<>();

        createPassageSections();
    }

    /**This function gets all the doors in this passage.
     * @return Returns an array of doors.*/
    public ArrayList<Door> getDoors() {
    //gets all of the doors in the entire passage
        return myDoors;
    }

    /**This function returns a passage section door within the passage.
     * @param i Index of passage section.
     * @return Returns a door object that belongs to passage section i.*/
    private Door getDoor(int i) {
        //returns the door in section 'i'. If there is no door, returns null
        try {
            return thePassage.get(i).getDoor();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**This function adds all the monsters that are generated.
     * @param theMonster This parameter is the monster that is generated for the passage section.
     * @param i This parameter is the index of the passage section to which the monster belongs to.*/
    private void addMonster(Monster theMonster, int i) {
        // adds a monster to section 'i' of the passage

        thePassage.get(i).setMonster(theMonster);
        passageMonsters.add(theMonster);
    }

    /**This function gets the monster from a specific passage section.
     * @param i This parameter is the index of the passage section in the passage.
     * @return Returns a monster object that is located at passage section i.*/
    private Monster getMonster(int i) {
        //returns Monster door in section 'i'. If there is no Monster, returns null

        try {
            if (thePassage.get(i).getMonster() != null) {
                return thePassage.get(i).getMonster();
            } else {
                return null;
            }
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**This function adds passage section that was generated to an array.
     * @param toAdd Passage section that was generated.*/
    private void addPassageSection(PassageSection toAdd) {
        //adds the passage section to the passageway
        thePassage.add(toAdd);
    }

    /**This function adds the door that's passed from chamber into door array of passage.
     * @param newDoor This is the door that sent from chamber.*/
    @Override
    public void setDoor(Door newDoor) {
        //should add a door connection to the current Passage Section
        myDoors.add(newDoor);
        thePassage.get(myDoors.size() - 1).setDoor(newDoor); // Goes to section based on how many doors have been sent in
        newDoor.setConnection(this);

    }

    /**This function gets the description of the entire passage.
     * @return Returns the string description of the passage.*/
    @Override
    public String getDescription() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < thePassage.size(); i++) {
            output.append(thePassage.get(i).getDescription());
            if (getDoor(i) != null) {
                output.append(getDoor(i).getDescription());
            }
        }

        return output.toString();
    }
    /*-----------
    You can write your own methods too, you aren't limited to the required ones
    ------------*/

    /**This function generates passages sections until a chamber or dead end is found.*/
    private void createPassageSections() {

        PassageSection section1 = new PassageSection("The door behind you is from the previous chamber.\n");
        addPassageSection(section1);

        PassageSection section2 = new PassageSection("The door in front of you leads to the next chamber.\n");
        addPassageSection(section2);
    }
}
