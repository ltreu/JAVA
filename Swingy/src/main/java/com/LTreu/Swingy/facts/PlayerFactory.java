package com.LTreu.Swingy.facts;

import com.LTreu.Swingy.conts.GameCont;
import com.LTreu.Swingy.mods.map.Coordinates;
import com.LTreu.Swingy.mods.playables.Gunman;
import com.LTreu.Swingy.mods.playables.KungFuMaster;
import com.LTreu.Swingy.mods.playables.Player;
import com.LTreu.Swingy.mods.playables.Swordsman;
import com.LTreu.Swingy.mods.playables.MasterMage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Setter
@Getter
public class PlayerFactory
{
    private static Player validatePlayer(Player player, GameCont controller)
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Player>> constraintViolations = validator.validate(player);
        if (constraintViolations.size() > 0 )
        {
            for (ConstraintViolation<Player> constraints : constraintViolations)
                controller.getErrors().add("Error :" + constraints.getMessage());
            return (null);
        }
        return (player);
    }

    public static Player customPlayer(String name, String type, int lvl, int exp, int atk, int def, int hp,
                                      Coordinates coordinates, GameCont controller)
    {
        Player player;

        if (type.equals("Gunman"))
            player = new Gunman(name, type, lvl, exp, atk, def, hp, coordinates);
        else if (type.equals("KungFuMaster"))
            player = new KungFuMaster(name, type, lvl, exp, atk, def, hp, coordinates);
        else if (type.equals("Swordsman"))
            player = new Swordsman(name, type, lvl, exp, atk, def, hp, coordinates);
        else if (type.equals("MasterMage"))
            player = new MasterMage(name, type, lvl, exp, atk, def, hp, coordinates);
        else
            player = null;
        return (validatePlayer(player, controller));
    }

    public static Player defaultPlayer(String name, String type, Coordinates coordinates, GameCont controller)
    {
        Player player;
        if (type.equals("Gunman"))
            player = new Gunman(name, coordinates);
        else if (type.equals("KungFuMaster"))
            player = new KungFuMaster(name, coordinates);
        else if (type.equals("Swordsman"))
            player = new Swordsman(name, coordinates);
        else if (type.equals("MasterMage"))
            player = new MasterMage(name, coordinates);
        else
            player = null;
        return (validatePlayer(player, controller));
    }
}
