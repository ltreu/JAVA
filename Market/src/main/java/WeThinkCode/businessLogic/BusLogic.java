package WeThinkCode.businessLogic;

import WeThinkCode.model.InstruMod;
import WeThinkCode.utilities.DispMarkData;

import java.util.List;

public class BusLogic
{
    private String[] _response = {"Executed","Rejected"};
    private String _messageType, _instrumentName;
    private int _quantity, _price;
    private List<InstruMod> _instruList;

    public BusLogic(String messageType,String instrumentName, int quantity, int price, List<InstruMod> instruList)
    {
        this._instruList = instruList;
        this._messageType = messageType;
        this._instrumentName = instrumentName;
        this._quantity = quantity;
        this._price = price;
    }

    public String LogicInitialization(String message)
    {
        //This line below is for the checksum, its a function that is required by the core module.
        //as such, you need it from whoever was assigned the core to do
//        message = generatechecksum.generateChecksum(message);
        String[] array = message.split("\\|");
        String response = null;

        if(this._messageType.equalsIgnoreCase("buy"))
        {
            response = this.BuyLogic();
        }
        else if (this._messageType.equalsIgnoreCase("sell"))
        {
            response = this.SellLogic();
        }
        DispMarkData.Print(this._instruList);
        response = array[0] + " | " + response + " | " + array[2];
        return response;
    }

    private String BuyLogic()
    {
        boolean Success = false;
        for (InstruMod item : this._instruList)
        {
            int FinPrice = item.get_price() * this._quantity;
            if(item.get_Name().equalsIgnoreCase(this._instrumentName) && FinPrice == this._price)
            {
                item.set_quantity(item.get_quantity() - this._quantity);
                Success = true;
                if(item.get_quantity() <= 0)
                {
                    this._instruList.remove(item);
                }
            }
        }
        if(!Success)
        {
            return _response[1];
        }
        else
        {
            return _response[0];
        }
    }

    private String SellLogic()
    {
        boolean Success = false;
        for(InstruMod item : this._instruList)
        {
            int FinPrice = item.get_price() * this._quantity;
            if(item.get_Name().equalsIgnoreCase(this._instrumentName) && FinPrice >= this._price)
            {
                item.set_quantity(item.get_quantity() + this._quantity);
                Success = true;
            }
        }
        if(!Success)
        {
            return _response[1];
        }
        else
        {
            return _response[0];
        }
    }
}
