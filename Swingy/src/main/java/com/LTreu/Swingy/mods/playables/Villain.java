package com.LTreu.Swingy.mods.playables;

import com.LTreu.Swingy.mods.map.Coordinates;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Villain extends Player
{
    @NotNull
    @Size(min = 5, max = 50, message = "A villain's catchphrase must be  5-50 characters long.")
    private String catchPhrase;

    public Villain(String name, String type, int level, int exp, int atk, int def, int hp, Coordinates pos)
    {
        super(name,type, level, exp, atk, def, hp, pos);
    }
}
