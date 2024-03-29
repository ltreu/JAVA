package com.LTreu.Swingy.views;

import com.LTreu.Swingy.mods.map.Map;
import com.LTreu.Swingy.mods.playables.Player;

import java.util.ArrayList;

public interface IDisplay
{
    public abstract void displayStartView();
    public abstract void displayPlayerSelectionView(ArrayList<Player> heroes);
    public abstract void displayCreatePlayerView();
    public abstract void displayBattleReport(String report);
    public abstract void displayErrors(ArrayList<String> errors);
    public abstract void displayGameOver(boolean heroWon);
    public abstract void displayQuitDialogue();
    public abstract void displayMap(final Map map);
    public abstract void displayFightOrRunPrompt();
    public abstract void displayForcedFightNotice();
    public abstract void displayPlayView();
    public abstract void displayRenderGame();
}
