package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<String, House> house = new HashMap<>();
    public static void main(String[] args) {
        Main main = new Main();
        House stark = new House("Stark","wolf");
        House barateon = new House("Barateon", "horns");
        House lannister = new House("Lannister", "lion");
        System.out.println("---add houses---");
        main.addHouse(stark);
        main.addHouse(barateon);
        main.addHouse(lannister);
        main.printHouses();
        System.out.println("---remove Stark---");
        main.removeHouse("Stark");
        main.printHouses();
        System.out.println("---Find Lannister---");
        System.out.println(main.findHouse("Lannister").getName());
    }

    public void addHouse(House house){
        this.house.put(house.getName(),house);
    }

    public void removeHouse(String name){
        house.remove(name);
    }

    public House findHouse(String name){
        return house.get(name);
    }

    public void printHouses(){
        for (Map.Entry<String, House> i: house.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue().getSigil());
        }
    }
}
