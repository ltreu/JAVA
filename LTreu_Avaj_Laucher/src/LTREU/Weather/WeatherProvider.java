package LTREU.Weather;

import java.util.Random;
import LTREU.Transport.Coordinates;

public class WeatherProvider
{
    private static WeatherProvider _weatherProvider = null;
    private String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider()
    {

    }

    public static WeatherProvider getProvider()
    {
        if (_weatherProvider == null)
            _weatherProvider = new WeatherProvider();
        return _weatherProvider;
    }

    ///Getters

    public String getCurrentWeather(Coordinates coordinates)
    {
        int randomGenerator = new Random().nextInt(weather.length);
        String randomWeather = (weather[randomGenerator]);

        return randomWeather;
    }
}
