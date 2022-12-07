package revision.implementschallenge;

import java.util.LinkedList;
import java.util.List;

public class Player implements ISavable{

    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    // Constructors
    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player [name=" + name  + ", hitPoints=" + hitPoints + ", strength=" + strength
                + ", weapon=" + weapon + "]";
    }

    @Override
    public List<String> write() {

        List<String> returnList = new LinkedList<String>();
        returnList.add(name);
        returnList.add(Integer.toString(hitPoints));
        returnList.add(Integer.toString(strength));
        returnList.add(weapon);

        return returnList;

    }

    @Override
    public void read(List<String> stringList) {
        if(stringList != null && stringList.size() > 0) {

            stringList.add(name);
            stringList.add(Integer.toString(hitPoints));
            stringList.add(Integer.toString(strength));
            stringList.add(weapon);

        }


        
    }



    

    

    

    
}
