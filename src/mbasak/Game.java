package mbasak;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    /**Main constructor.*/
    protected Game() {

    }

    /**This is the main function that contains the algorithm to sort and connect passages and chambers then print them out.
     * @param args Run commands passed before executing the program.*/
    public static void main(String[] args) {

        ArrayList<Chamber> genChambers = new ArrayList<>(); // Will be used to swap into another Chamber if need be
        ArrayList<Passage> genPassages = new ArrayList<>(); // Will be used to swap into another Chamber if need be
        HashMap<Door, ArrayList<Chamber>> doorTargets = new HashMap<>();
        boolean sort;
        Chamber swapCurrChamber;

        // Generate 5 different chambers
        for (int i = 0; i < 5; i++) {
            genChambers.add(new Chamber());
        }


        /* BUBBLE SORT START*/
        sort = false;
        while (!sort) {
            sort = true; // Sorted unless a swap occurs
            for (int index = 0; index < genChambers.size() - 1; index++) {
                if (genChambers.get(index).getDoors().size() < genChambers.get(index + 1).getDoors().size()) { // Swap current chamber with next chamber
                    swapCurrChamber = genChambers.get(index);
                    genChambers.set(index, genChambers.get(index + 1)); // Sets next chamber as current index's chamber
                    genChambers.set(index + 1, swapCurrChamber);
                    sort = false; // Since a swap occurred it's not sorted yet
                }
            }
        }

        /* BUBBLE SORT END*/

        for (int i = 0; i < 5; i++) {
            genChambers.get(i).setIndex(i + 1); // Adds the index of chamber
        }

        // MAIN ALGORITHM START
        for (int i = 0; i < genChambers.get(0).getDoors().size(); i++) { // this loop connects first chamber (one w/ the most amount of doors
            genChambers.get(0).getDoor(i).setConnectionToOther(genChambers.get(i + 1));
            genChambers.get(i + 1).getDoor(0).setConnectionToOther(genChambers.get(0));

            doorTargets.put(genChambers.get(0).getDoor(i), genChambers.get(0).getDoor(i).getConnectionToChambers());
        }

        boolean noConnectionsForDoor;
        boolean refToCurrChamber;
        int doubleUp = 0; // Will contain the index of door to double up on
        for (int currChamberIndex = 1; currChamberIndex < genChambers.size(); currChamberIndex++) { // Current Chamber

            for (int currChamberDoor = 0; currChamberDoor < genChambers.get(currChamberIndex).getDoors().size(); currChamberDoor++) { // Current Chamber's doors

                if (genChambers.get(currChamberIndex).getDoor(currChamberDoor).getConnectionToChambers().size() == 0) { // No connections
                    noConnectionsForDoor = false; // this door is free to make a connection to

                    for (int nextChamber = currChamberIndex + 1; !noConnectionsForDoor && (nextChamber < genChambers.size()); nextChamber++) { // Chamber after current chamber
                        refToCurrChamber = false; // Next chamber's door doesn't have a reference to Current chamber

                        for (int nextChamberCurrDoor = 0; !refToCurrChamber && (nextChamberCurrDoor < genChambers.get(nextChamber).getDoors().size()); nextChamberCurrDoor++) { // Next chamber's doors

                            if (genChambers.get(nextChamber).getDoor(nextChamberCurrDoor).getConnectionToChambers().contains(genChambers.get(currChamberIndex))) {
                                refToCurrChamber = true; // This chamber has a reference to current chamber

                            }


                            if (genChambers.get(nextChamber).getDoor(nextChamberCurrDoor).getConnectionToChambers().size() == 0) { // Door free to connect to any place
                                genChambers.get(nextChamber).getDoor(nextChamberCurrDoor).setConnectionToOther(genChambers.get(currChamberIndex));
                                genChambers.get(currChamberIndex).getDoor(currChamberDoor).setConnectionToOther(genChambers.get(nextChamber));

                                doorTargets.put(genChambers.get(currChamberIndex).getDoor(currChamberDoor), genChambers.get(currChamberIndex).getDoor(currChamberDoor).getConnectionToChambers());
                                noConnectionsForDoor = true;
                                refToCurrChamber = true; // The door now has a reference to the current chamber
                            }

                        }

                    }

                    if (!noConnectionsForDoor) { // All doors had a connection
                        for (int nextChamber = 0; !noConnectionsForDoor && nextChamber < genChambers.size(); nextChamber++) {
                            if (nextChamber == currChamberDoor) {
                                nextChamber++; // Prevents setting itself as a target
                            }

                            refToCurrChamber = false;

                            for (int nextChamberCurrDoor = 0; nextChamberCurrDoor < genChambers.get(nextChamber).getDoors().size() && !refToCurrChamber; nextChamberCurrDoor++) {

                                if (genChambers.get(nextChamber).getDoor(nextChamberCurrDoor).getConnectionToChambers().contains(genChambers.get(currChamberIndex))) {
                                    refToCurrChamber = true;
                                } else {
                                    doubleUp = nextChamberCurrDoor;
                                }
                            }

                            if (!refToCurrChamber) {
                                genChambers.get(currChamberIndex).getDoor(currChamberDoor).setConnectionToOther(genChambers.get(nextChamber));
                                doorTargets.put(genChambers.get(currChamberIndex).getDoor(currChamberDoor), genChambers.get(currChamberIndex).getDoor(currChamberDoor).getConnectionToChambers());
                                genChambers.get(nextChamber).getDoor(doubleUp).setConnectionToOther(genChambers.get(currChamberIndex));
                                noConnectionsForDoor = true;
                            }
                        }

                    }

                } else {
                    doorTargets.put(genChambers.get(currChamberIndex).getDoor(currChamberDoor), genChambers.get(currChamberIndex).getDoor(currChamberDoor).getConnectionToChambers());
                }

            }
        }

        ArrayList<Chamber> displayChambers;

        outputLevel(genChambers, doorTargets);

    }

    private static void outputLevel(ArrayList<Chamber> genChambers, HashMap<Door, ArrayList<Chamber>> doorTargets) {
        ArrayList<Chamber> chamberTarget;
        ArrayList<Door> chamberTargetDoor;
        Passage newPassage;

        for (Chamber c : genChambers) {
            System.out.println("Chamber #" + c.getIndex() + ":");
            System.out.println(c.getDescription());
            System.out.println("~~~~Chamber #" + c.getIndex() + "'s doors~~~~");
            for (Door d : c.getDoors()) {
                System.out.println("Door #" + d.getIndex());
                System.out.println(d.getDescription());

                System.out.println("Door #" + d.getIndex() + "'s passage");

                chamberTarget = doorTargets.get(d); // Gets the chamber(s) door is connected to

                if (chamberTarget.size() == 1) { // Only one connection
                    newPassage = new Passage();
                    newPassage.setDoor(d); // Sends in entry door for passage
                    chamberTargetDoor = chamberTarget.get(0).getDoors();
                    for (Door cTD : chamberTargetDoor) { // Cycle through the doors in the target chamber

                        if (doorTargets.get(cTD).contains(c)) { // The door with current chamber as a target is found
                            newPassage.setDoor(cTD); // Sends in exit door for passage
                            System.out.println(newPassage.getDescription());
                            System.out.println("The next chamber is Chamber " + chamberTarget.get(0).getIndex() + "\n"); // TODO Need to display next chamber being door's target chamber index
                        }
                    }
                } else {
                    int i = 0; // Match the passage num to door num
                    for (Chamber cT : chamberTarget) {
                        System.out.println("Passage " + (i + 1));
                        newPassage = new Passage();
                        newPassage.setDoor(d);
                        chamberTargetDoor = cT.getDoors();
                        for (Door cTD : chamberTargetDoor) { // Cycle through the doors in the target chamber

                            if (doorTargets.get(cTD).contains(c)) { // The door with current chamber as a target is found
                                newPassage.setDoor(cTD); // Sends in exit door for passage
                                System.out.println(newPassage.getDescription());
                                System.out.println("The next chamber is Chamber " + chamberTarget.get(0).getIndex() + "\n"); // TODO Need to display next chamber being door's target chamber index
                            }
                        }
                        i++;
                    }
                }
            }
        }
    }
}
