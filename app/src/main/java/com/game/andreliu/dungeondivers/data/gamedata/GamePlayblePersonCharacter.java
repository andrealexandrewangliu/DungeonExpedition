package com.game.andreliu.dungeondivers.data.gamedata;

import com.game.andreliu.dungeondivers.data.CurrentGameData;

/**
 * Created by xmyx on 24/03/16.
 */
public class GamePlayblePersonCharacter extends GamePersonCharacter {

    private float ammoSupply = 0;    //Hard mode only
    private int attributePoints = 0; //Automatic in hardmode
    private int experience;
    private int experienceNext;

    public int getAttributePoints() {
        return attributePoints;
    }

    public void setAttributePoints(int attributePoints) {
        this.attributePoints = attributePoints;
    }

    public float getAmmoSupply() {
        return ammoSupply;
    }

    public void setAmmoSupply(float ammoSupply) {
        this.ammoSupply = ammoSupply;
    }

    public float getTotalWeight(){
        float w = super.getTotalWeight();
        if (CurrentGameData.isHard())
            return w + ammoSupply;
        else
            return w;
    }
}
