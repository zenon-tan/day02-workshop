package revision.implementschallenge;

import java.util.LinkedList;
import java.util.List;

public class Monster implements ISavable {

    private String name;
    private int hitPoints;
    private int strength;

    // Getters
    public String getName() {
        return name;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public int getStrength() {
        return strength;
    }

    // Constructors
    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Monster [name=" + name + ", hitPoints=" + hitPoints + ", strength=" + strength + "]";
    }
    @Override
    public List<String> write() {
        List<String> returnList = new LinkedList<String>();
        returnList.add(name);
        returnList.add(Integer.toString(hitPoints));
        returnList.add(Integer.toString(strength));

        return returnList;
    }

    @Override
    public void read(List<String> stringList) {

        if(stringList != null && stringList.size() > 0) {

            stringList.add(name);
            stringList.add(Integer.toString(hitPoints));
            stringList.add(Integer.toString(strength));


        }
        
    }



    

    

    
    
}
