/* This is a stub for the Cafe class */

import java.util.ArrayList;

public class Cafe extends Building implements CafeRequirements {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    private ArrayList<Integer> inventory;

    /**
     * Constructor, sets default inventory
     * @param name string, the name of the building
     * @param address string, the address of the building
     * @param nFloors int, the number of floors of the building
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 20000;
        this.nSugarPackets = 1500;
        this.nCreams = 1500;
        this.nCups = 2000;
        this.inventory = new ArrayList<>();
        this.inventory.add(nCoffeeOunces);
        this.inventory.add(nSugarPackets);
        this.inventory.add(nCreams);
        this.inventory.add(nCups);
    }
    
    /**
     * Decreases inventory by amount specified for each paramter and by one cup
     * @param size int, number of ounces of coffee in order
     * @param nSugarPackets, int number of sugar packets in order
     * @param nCreams int, number of creams in order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        for(int i = 0; i < inventory.size(); i++){
            if (inventory.get(i) < 50){
                this.restock(20000, 1500, 1500, 2000);
            }
        }
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - 1;
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }    
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "1 Chapin Way", 3);
    }
    
}
