package WeThinkCode.utilities;

import WeThinkCode.model.InstruMod;

import java.util.ArrayList;
import java.util.List;

public class InstruCreate
{
    public static List<InstruMod> _instrumentList = new ArrayList<InstruMod>();
    private static InstruMod instrument;

    public static List<InstruMod> createInstrumentList()
    {
        String[] _instrumentNames = {}; // This is where you can add the different instrument/ commodities/ items. Please put some in
        int[] _prices = {160, 140, 115, 110, 80, 40};
        int[] _quantity = {10, 30, 22, 35, 45, 60};

        for (int cout = 0; cout <= 5; cout++)
        {
            instrument = new InstruMod(_instrumentNames[cout], _quantity[cout], _prices[cout]);
            _instrumentList.add(instrument);
        }
        return _instrumentList;
    }
}
