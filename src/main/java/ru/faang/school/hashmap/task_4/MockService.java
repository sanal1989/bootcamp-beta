package ru.faang.school.hashmap.task_4;

public class MockService {
    public WeatherData getMockCity(){
        MockCity mockCity = new MockCity();
        return new WeatherData(mockCity.getCity(), mockCity.getTemperature(), mockCity.getHumidity());
    }
}
