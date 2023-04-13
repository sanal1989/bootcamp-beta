package ru.faang.school.hashmap.task_4;

import java.util.Map;
import java.util.Random;

public class MockCity {
    private static Random random = new Random();
    private String city = new String("MockCIty" + random.nextInt(50));
    private int temperature = random.nextInt(50);
    private int humidity = random.nextInt(50);

    public String getCity() {
        return city;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "MockCity{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
