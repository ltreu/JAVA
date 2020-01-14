package com.LTreu.Swingy.facts;

import com.LTreu.Swingy.mods.map.Coordinates;
import com.LTreu.Swingy.mods.map.Map;

public class CoordinateFactory
{
    public static Coordinates newCoordinates(int x, int y, final Map map)
    {
        Coordinates coordinates = null;
        if (map == null || map.getGrid()[y][x] == 0)
            coordinates = new Coordinates(x, y);
        return (coordinates);
    }
}
