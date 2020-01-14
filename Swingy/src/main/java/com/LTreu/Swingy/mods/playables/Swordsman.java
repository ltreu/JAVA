package com.LTreu.Swingy.mods.playables;

import com.LTreu.Swingy.mods.map.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Swordsman extends Player
{
    public Swordsman(String name, String type, int level, int exp, int atk, int def, int hp,
                     Coordinates coordinates)
    {
        super(name,type, level, exp, atk, def, hp, coordinates);
    }

    public Swordsman(String name, Coordinates coordinates)
    {
        super(name, "Swordsman",1, 1000, 60, 25, 200, coordinates);
    }
}
