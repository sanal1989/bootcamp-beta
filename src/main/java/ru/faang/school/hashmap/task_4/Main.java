package ru.faang.school.hashmap.task_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<String, WeatherData> cities = new HashMap<>();
    MockService mockService = new MockService();
    public static void main(String[] args) {
        Main main = new Main();
        WeatherData weatherData1 = new WeatherData("city1", 10,10);
        WeatherData weatherData2 = new WeatherData("city2", 20,20);
        WeatherData weatherData3 = new WeatherData("city3", 30,30);
        main.cities.put(weatherData1.getCity(),weatherData1);
        main.cities.put(weatherData2.getCity(),weatherData2);
        main.cities.put(weatherData3.getCity(),weatherData3);
        System.out.println("---print cities---");
        main.print();
        System.out.println("---find city---");
        System.out.println(main.get("city1"));
        WeatherData weatherData4 = new WeatherData("city4", 40,40);
        main.cities.put(weatherData4.getCity(), weatherData4);
        main.print();
        System.out.println("---remove city----");
        main.remove("city1");
        main.print();
        System.out.println("---add mock city");
        WeatherData mockCity = main.mockService.getMockCity();
        main.put(mockCity.getCity(), mockCity);
        main.print();
    }

    public void put(String city, WeatherData weatherData){
        cities.put(weatherData.getCity(), weatherData);
    }

    public void remove(String city){
        cities.remove(city);
    }

    public void print(){
        for (Map.Entry<String, WeatherData> i: cities.entrySet()) {
            System.out.println( i.getValue().getCity()
                                + " " + i.getValue().getTemperature()
                                + " " + i.getValue().getHumidity());
        }
    }

    public WeatherData get(String city){
        if(!cities.containsKey(city)){
            cities.put(city, mockService.getMockCity());
        }
        return cities.get(city);
    }
}
