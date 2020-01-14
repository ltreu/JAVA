package com.LTreu.Swingy.mods.playables;

import com.LTreu.Swingy.mods.map.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KungFuMaster extends Player
{
    public KungFuMaster(String name, String type, int level, int exp, int atk, int def, int hp,
                        Coordinates coordinates)
    {
        super(name, type, level, exp, atk, def, hp, coordinates);
    }

    public KungFuMaster(String name, Coordinates coordinates)
    {
        super(name, "KungFuMaster",1, 1000, 40, 25, 300, coordinates);
    }
}
