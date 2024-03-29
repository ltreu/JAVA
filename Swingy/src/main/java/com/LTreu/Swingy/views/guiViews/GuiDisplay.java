package com.LTreu.Swingy.views.guiViews;

import com.LTreu.Swingy.conts.GameCont;
import com.LTreu.Swingy.mods.map.Map;
import com.LTreu.Swingy.mods.playables.Player;
import com.LTreu.Swingy.views.IDisplay;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

@Getter
@Setter
public class GuiDisplay implements IDisplay
{
    private GameCont controller;

    private GuiPlayView playView;

    private JFrame errorFrame;


    public GuiDisplay(GameCont controller)
    {
        this.controller = controller;
        playView = new GuiPlayView(controller);
    }

    public void displayStartView()
    {
        new GuiStartView(controller).displayStartView();
    }

    public void displayPlayerSelectionView(ArrayList<Player> heroes)
    {
        new GuiPlayerSelectionView(controller).displaySelectionView(heroes);
    }

    public void displayCreatePlayerView()
    {
        new GuiCreatePlayerView(controller).displayCreatePlayerView();
    }

    public void displayPlayView()
    {
        playView.displayPlayView();
    }

    public void displayMap(final Map map)
    {
        playView.drawMap(controller.getMap());
    }

    public void setRedrawMap(boolean value)
    {
        playView.setReDrawMap(value);
    }

    public void displayFightOrRunPrompt()
    {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (playView.getFrame(), "Do you want to do battle?","Enemy encountered",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION)
            controller.receiveUserInput("1");
        else
            controller.receiveUserInput("2");
        controller.displayStage();
    }

    public void displayBattleReport(String report)
    {
        playView.displayBattle(report);
    }

    public void displayErrors(ArrayList<String> errors)
    {
        String message = "";
        for (String error : errors)
            message+= "\t" + error + "\n";
        JOptionPane.showMessageDialog(errorFrame, message);
        errorFrame.dispose();
        controller.receiveUserInput("b");
        controller.displayStage();
    }

    public void displayGameOver(boolean heroWon)
    {
        String result = heroWon? "Won!" : "Lost!";

        Object[] options1 = { "Main menu", "Quit" };

        int dialogResult = JOptionPane.showOptionDialog(playView.getFrame(), "You " + result,"Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            controller.receiveUserInput("1");
            playView.getFrame().dispose();
            controller.displayStage();
        }
        else
        {
            controller.receiveUserInput("2");
            playView.getFrame().dispose();
        }
    }

    public void displayQuitDialogue()
    {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (playView.getFrame(), "Are you sure you want to quit?","Exiting game",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            controller.receiveUserInput("1");
            playView.getFrame().dispose();
        }
        else
        {
            controller.receiveUserInput("2");
            controller.displayStage();
        }
    }

    public void displayForcedFightNotice()
    {
        String message = "You are forced to do battle";
        JOptionPane.showMessageDialog(playView.getFrame(), message);
        controller.receiveUserInput("c");
        controller.displayStage();
    }

    public void displayRenderGame()
    {
        controller.displayStage();
    }
}
