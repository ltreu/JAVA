package com.LTreu.Swingy.mods.playables;

import com.LTreu.Swingy.mods.map.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MasterMage extends Player
{
    public MasterMage(String name, String type, int level, int exp, int atk, int def, int hp,
                      Coordinates coordinates)
    {
        super(name, type, level, exp, atk, def, hp, coordinates);
    }

    public MasterMage(String name, Coordinates coordinates)
    {
        super(name, "MasterMage", 1, 1000, 40, 25, 300, coordinates);
    }
}
