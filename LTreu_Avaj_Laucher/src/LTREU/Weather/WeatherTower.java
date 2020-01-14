package LTREU.Weather;

import LTREU.Tower.Tower;
import LTREU.Transport.Coordinates;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates)
    {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }
}
