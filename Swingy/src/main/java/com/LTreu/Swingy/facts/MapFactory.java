package com.LTreu.Swingy.facts;

import com.LTreu.Swingy.mods.map.Map;

public class MapFactory
{
    public static Map newMap(int level)
    {
        int size = ((level - 1) * 5) + 10 - (level % 2);
        Map map = new Map(size);
        return (map);
    }
}
