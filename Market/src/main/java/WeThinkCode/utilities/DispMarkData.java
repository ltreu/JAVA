package WeThinkCode.utilities;

import WeThinkCode.model.InstruMod;

import java.util.List;

public class DispMarkData
{
    public static void Print(List<InstruMod> _instrumentList)
    {
        System.out.println("\n__ Available Items Below __\n");
        for(InstruMod im : _instrumentList)
            System.out.println("Id. " + im.get_id() + " " + im.get_Name().toUpperCase() + " Quantity = " + im.get_quantity() + " Price = " + im.get_price());
    }
}
