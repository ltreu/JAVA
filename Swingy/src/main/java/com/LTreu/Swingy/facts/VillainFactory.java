package com.LTreu.Swingy.facts;

import com.LTreu.Swingy.mods.map.Coordinates;
import com.LTreu.Swingy.mods.playables.Villain;

import java.util.Random;

public class VillainFactory
{
    public static Villain newVillain(String name, String phrase, Coordinates coordinates)
    {
        int level, exp, atk, def, hp;
        Random rand = new Random();
        level = rand.nextInt(10) + 1;
        exp = 0;
        atk = rand.nextInt(10 - level + 1) * 10;
        def = rand.nextInt(10 - level  + 1) * 10;
        hp = rand.nextInt(10 - level + 1) * 30;
        Villain villain = new Villain(name, "Villain", level, exp, atk, def, hp, coordinates);
        villain.setCatchPhrase(phrase);

        return (villain);
    }
}
