package mbasak;

import dnd.die.D20;

public class Level {

    /**Stores the section description.*/
    private String lvlDesc;

    /**This is the constructor that rolls and then stores a string for passage section description.*/
    public Level() {
            D20 d20 = new D20();

            if (1 <= d20.roll() && d20.roll() <= 2) { // Roll = 1-2
                // passage straight 10ft
                lvlDesc = "The passage goes straight for 10 ft.\n";
            } else if (3 <= d20.roll() && d20.roll() <= 5) { // Roll = 3-5
                // passage ends w/ Door to Chamber
                lvlDesc = "The passage ends with a door to a chamber.\n";
            } else if (6 <= d20.roll() && d20.roll() <= 7) { // Roll = 6-7
                // door (right) passage continues
                lvlDesc = "Archway (door) to right, passage continues forward for 10 ft.\n";
            } else if (8 <= d20.roll() && d20.roll() <= 9) { // Roll = 8-9
                // door (left) passage continues
                lvlDesc = "Archway (door) to left, passage continues straight for 10 ft.\n";
            } else if (10 <= d20.roll() && d20.roll() <= 11) { // Roll = 10-11
                // left - passage continues
                lvlDesc = "The passage turns to the left, and continues for 10 ft.\n";
            } else if (12 <= d20.roll() && d20.roll() <= 13) { // Roll = 12-13
                // right - passage continues
                lvlDesc = "The passage turns to the right, and continues for 10 ft.\n";
            } else if (14 <= d20.roll() && d20.roll() <= 16) { // Roll = 14-16
                // passage ends w/ door to chamber
                lvlDesc = "The passage ends in the archway (door) to a chamber.\n";
            } else if (d20.roll() == 17) { // Roll = 17
                // stairs then passage continues
                lvlDesc = "There are stairs, then a passage that continues straight for 10 ft.\n";
            } else if (18 <= d20.roll() && d20.roll() <= 19) { // Roll = 18-19
                // dead end
                lvlDesc = "This path is a dead end.\n";
            } else { // Roll = 20
                // wandering monster passage continues
                lvlDesc = "There is a wandering monster in the passage then continues straight for 10 ft.\n";
            }
//        }
    }

    /**This function returns the instance variable.
     * @return String of description that's based on roll*/
    public String getLvlDesc() {

        return lvlDesc;
    }

}
