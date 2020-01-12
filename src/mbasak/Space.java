package mbasak;

public abstract class Space {

    /**This function returns a string that describes the space it belongs to.
     * @return Returns a string description of chamber/passage depending on the instance.*/
    public abstract String getDescription();

    /**This function is used to connect a door to chamber/passage.
     * @param theDoor The door that's generated.*/
    public abstract void setDoor(Door theDoor);

}
