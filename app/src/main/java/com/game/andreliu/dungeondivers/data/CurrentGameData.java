package com.game.andreliu.dungeondivers.data;

import com.game.andreliu.dungeondivers.data.gamedata.GameCharacter;
import com.game.andreliu.dungeondivers.data.gamedata.GameEquipment;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by xmyx on 14/03/16.
 */
public class CurrentGameData {
    private static CurrentGameData currentGame;

    private byte difficulty = 0; //0 = EASY, 1 = NORMAL, 2 = HARD
    private int money = 0;          //Total gold
    private String guildName = "";

    private TreeSet<GameEquipment> equipment = new TreeSet<GameEquipment>(GameEquipment.comparator());

    private GameCharacter[] guild = new GameCharacter[100]; //Character rooster can only have 100
    private GameCharacter[] party = new GameCharacter[30];  //Can only take up to 30 party members at maximum

    public CurrentGameData(){
        guild[0] = new GameCharacter(); //Main Character
    }

    public static void newGameInstance(){
        currentGame = new CurrentGameData();
    }

    public static CurrentGameData getCurrentGame() {
        return currentGame;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public static boolean isInit(){
        return currentGame != null;
    }

    public static float partyTotalWeight(){
        if (!isInit())
            return 0;
        float w = 0;
        for (int i = 0; i < currentGame.party.length; i++) {
            if (currentGame.party[i] == null)
                break;
            w += currentGame.party[i].getTotalWeight();
        }
        return w;
    }

    public static float partyTotalCapacity(){
        if (!isInit())
            return 0;
        float w = 0;
        for (int i = 0; i < currentGame.party.length; i++) {
            if (currentGame.party[i] == null)
                break;
            w += currentGame.party[i].carryCapacity();
        }
        return w;
    }

    public static boolean isEasy(){
        if (!isInit())
            return false;
        return currentGame.difficulty == 0;
    }
    public static boolean isNormal(){
        if (!isInit())
            return false;
        return currentGame.difficulty == 1;
    }
    public static boolean isHard(){
        if (!isInit())
            return false;
        return currentGame.difficulty == 2;
    }
}
