/* This is a stub for the Cafe class */

import java.util.ArrayList;

public class Cafe extends Building implements CafeRequirements {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

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
    }

    private ArrayList<Integer> getOrder(int size, int nSugarPackets, int nCreams){
        ArrayList<Integer> order = new ArrayList<Integer>();
        order.add(size);
        order.add(nSugarPackets);
        order.add(nCreams);
        int cups = 1;
        order.add(cups);
        return order;
    }

    private ArrayList<Integer> getInventory(){
        ArrayList<Integer> inventory = new ArrayList<Integer>();
        inventory.add(this.nCoffeeOunces);
        inventory.add(this.nSugarPackets);
        inventory.add(this.nCreams);
        inventory.add(this.nCups);
        return inventory;
    }
    
    /**
     * Decreases inventory by amount specified for each paramter and by one cup
     * @param size int, number of ounces of coffee in order
     * @param nSugarPackets, int number of sugar packets in order
     * @param nCreams int, number of creams in order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        ArrayList<Integer> order = getOrder(size, nSugarPackets, nCreams);
        ArrayList<Integer> inventory = getInventory();
        for(int i = 0; i < inventory.size(); i++){
            int stock = inventory.get(i);
            int request = order.get(i);
            System.out.println(stock+" in relation to "+request);
            if (stock - request < 0){
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
        compass.sellCoffee(19000, 0, 0);
        System.out.println(compass.nCoffeeOunces);
        compass.sellCoffee(3000, 0, 0);
        System.out.println(compass.nCoffeeOunces);
        System.out.println(compass.nCups);
    }
    
}
