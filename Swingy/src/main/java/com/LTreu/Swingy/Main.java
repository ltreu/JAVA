package com.LTreu.Swingy;

import com.LTreu.Swingy.conts.GameCont;

public class Main
{
    public static void main(String[] args)
    {
        GameCont controller = new GameCont(args[0]);
        controller.renderGame();
    }
}
