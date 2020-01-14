package com.LTreu.Swingy.mods.playables;

import com.LTreu.Swingy.annotations.ValidateType;
import com.LTreu.Swingy.mods.artefacts.Artefact;
import com.LTreu.Swingy.mods.map.Coordinates;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Getter
@Setter
public class Player
{
    @NotNull
    @Valid
    protected ArrayList<Artefact> artefacts;

    @NotNull
    @Size(min = 1, max = 15, message = "The length of a player's name must be between 1 and 15.")
    protected String name;

    @NotNull
    @ValidateType(types = {"Gunman", "Swordsman", "KungFuMaster", "Villain", "MasterMage"}, message = "Invalid class")
    protected String type;

    @NotNull
    @Min(value = 1, message = "Player level cannot be lower than 1.")
    @Max(value = 7, message = "Player level cannot exceed 7.")
    protected int level;

    @NotNull
    @Min(value = 0, message = "Player exp cannot be lower than 0.")
    protected int exp;

    @NotNull
    @Min(value = 0, message = "Player atk cannot be lower than 0.")
    protected int atk;

    @NotNull
    @Min(value = 0, message = "Player def cannot be lower than 0.")
    protected int def;

    @NotNull
    @Min(value = 0, message = "Player hp should be greater than 0.")
    protected int hp;

    @NotNull
    @Valid
    protected Coordinates coordinates;

    public Player(String name, String type, int level, int exp, int atk, int def, int hp, Coordinates coordinates)
    {
        this.setName(name);
        this.setType(type);
        this.setLevel(level);
        this.setExp(exp);
        this.setAtk(atk);
        this.setDef(def);
        this.setHp(hp);
        this.setCoordinates(coordinates);
        this.artefacts = new ArrayList<>();
    }
}
