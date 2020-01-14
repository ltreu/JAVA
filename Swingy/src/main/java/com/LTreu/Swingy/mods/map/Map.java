package com.LTreu.Swingy.mods.map;

import com.LTreu.Swingy.annotations.ValidateMapGrid;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Map
{
    @NotNull
    @Min(value = 5, message = "A map's dimensions must be at least 5.")
    @Max(value = 55, message = "A map's dimensions cannot exceed MAX map size i.e 55.")
    private int size;

    @ValidateMapGrid
    private int[][] grid;

    public Map(int size)
    {
        this.setSize(size);
        this.setGrid(new int[size][size]);
    }
}
