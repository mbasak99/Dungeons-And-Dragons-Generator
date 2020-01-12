| Method names and signature  | Responsibility  | Instance variables used in method | Other class methods called in method  |  Objects used by method | Lines of code  |
|:-:|:-:|:-:|:-:|:-:|:-:|
|  public void setIndex | Assigns chamber its sorted number |  int index |   |   |  1 |
| public int getIndex  |  Retrieves the index number of chamber from sorted list |  int index |   |   |  1 |
|  private void setShape |  Sets passed chamber variable as instance variable for chamber | ChamberShape chamberShapeSize  |  ChamberShape |   | 1  |
|  private void setContents |  Sets passed chamber variable as instance variable for chamber |  ChamberContents myContents |  ChamberContents |   | 1  |
|  public ArrayList\<Door>getDoors | Retrieves the ArrayList of doors chamber object has  | ArrayList\<Door> myDoors  |   | Door  | 1  |
|  private void addMonster | Adds monster to the chamber  | Monster myMonster  |   | Monster  | 1  |
|  public Monster getMonster  | Retrieves the monster in the chamber  | Monster myMonster  |   | Monster  | 1  |
|  private void addTreasure |  Adds the treasure in the chamber |  Treasure myTreasure |   |  Treasure | 1  |
|  public Treasure getTreasure |  Retrieves the treasure in the chamber |  Treasure myTreasure |   |  Treasure |  1 |
|  public String getDescription |  Returns a string description of the chamber | None  |   |   |  1 |
|  public void setDoor |  Adds doors/exits to chamber's door ArrayList and set chamber as one of the connections for the door | ArrayList\<Door> myDoors  | Door setConnection\()  |  Door |  2 |
|  private void chamberContentsGen | Calls methods that generate objects depending on the description of contents  | ChamberContents myContents, String chamberContentsDescString  | ChamberContents getDescription\()  | ChamberContents  | 22  |
|  private String treasureGen |  Generates treasure string and returns the string  | D20 d20  |  D20 roll\(), Treasure chooseTreasure\(), setContainer\() |  D20, Treasure | 15  |
|  private void shapeAndSizeGen |  Generates the string of how the chamber is shaped and its length/width/area | D20 d20, ChamberShape chamberShapeSize, String shapeAndSizeGenString  |  ChamberShape setNumExits\(), getNumExits\(), getShape\(), getLength\(), getWidth\(), getArea\() |  D20, ChamberShape | 20  |
|  private void createDoors  | Generates door objects based on how many exits the chamber has set  | ChamberShape chamberShapeSize  | ChamberShape getNumExits\()  |   | 3  |
|  private String stairsGen |  Generates the string of any stairs the chamber might have | D20 d20  |  Stairs setType\() | Stairs  |  3 |
|  private String trapGen |  Generates the string of any traps the chamber might have | D20 d20  |  Trap chooseTrap\() |  Trap |  3 |
|  private String monstersGen |  Generates the string of any monster the chamber might have and calls a method to add the monster to chamber's instance | D20 d20  | Monster setType\()  | Monster  |  4 |
|  private String setDescription | Calls chamberContentsGen and shapeAndSizeGen to save the string they generate into an instance variable  |   |   |   |  2 |
|  private String getChamberContentsDescString | Returns string description of contents in chamber  |  String chamberContentsDescString |   |   | 1  |
|  private String getShapeAndSizeGenString |  Returns string description of shape and size of chamber |  String shapeAndSizeGenString  |   |   |  1 |
| public Door getDoor  |  Retrieves a specific door from the many chamber doors |  ArrayList\<Door> myDoors |   | Door  | 4  |
