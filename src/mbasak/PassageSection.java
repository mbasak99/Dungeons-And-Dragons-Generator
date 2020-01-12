package mbasak;

import dnd.models.Monster;

/* Represents a 10 ft section of passageway */

public class PassageSection {

    /*-----------------------------
     Required Methods for that we will test during grading
    ------------------------------*/
    /* note:  Some of these methods would normally be protected or private, but because we
    don't want to dictate how you set up your packages we need them to be public
    for the purposes of running an automated test suite (junit) on your code.  */
    /**Contains the description of the passage section.*/
    private StringBuilder desc;
    /**Contains the monster object if there is one in this passage section.*/
    private Monster monster;
    /**Contains the door object if there is one in this passage section.*/
    private Door passageDoor;

//    /**This constructor calls class Level and saves the description it rolled for the current passage section.*/
//    public PassageSection() {
//        Level newSection = new Level();
//        desc = new StringBuilder();
//        desc.append(newSection.getLvlDesc());
//
//    }

    /**This constructor is if the user/DM wanted to pass a custom string for the current passage section.
     * @param description The custom string the user/DM wants passed.*/
    public PassageSection(String description) {
        desc = new StringBuilder();
        //sets up a specific passage based on the values sent in from
        //modified table 1
        desc.append(description);
    }

    /**This function returns the door in the passage section.
    * @return Returns door if section has one.*/
    public Door getDoor() {
        //returns the door that is in the passage section, if there is one

        return passageDoor;
    }

    /**This function returns the monster in the passage section.
    * @return Returns monster if section has one*/
    public Monster getMonster() {
        //returns the monster that is in the passage section, if there is one
        return monster;
    }

    /**This function returns the description of section.
     * @return Returns string of section description.*/
    public String getDescription() {

        return desc.toString();
    }

    /* My functions */

    /**This function sets the monster that is generated for the current passage section.
     * @param addMonster Monster object that was generated.*/
    public void setMonster(Monster addMonster) {
        monster = addMonster;
        desc.append("Monster: ").append(monster.getDescription()).append(".\n");
    }

    /**This function sets the door that is generated for the current passage section.
     * @param addDoor Door object that was generated.*/
    public void setDoor(Door addDoor) {

        passageDoor = addDoor;
    }
}
