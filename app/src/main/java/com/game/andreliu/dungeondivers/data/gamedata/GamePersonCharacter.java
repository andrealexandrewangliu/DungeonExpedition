package com.game.andreliu.dungeondivers.data.gamedata;

import com.game.andreliu.dungeondivers.data.CurrentGameData;
import com.game.andreliu.dungeondivers.data.gamedata.CharacterStats.GameCharacterStats;

/**
 * Created by xmyx on 15/03/16.
 */
public class GamePersonCharacter extends GameCharacter {
    private byte gender;   //0 - it, 1 - he, 2 - she (for flavour text) anything else is it
    private String race = "Human";
    private GameEquipment headgear = null;
    private GameEquipment torso = null;
    private GameEquipment pants = null;
    private GameEquipment shoes = null;
    private GameEquipment gloves = null;

    //Weapon Slots
    private GameEquipment belt1 = null;
    private GameEquipment belt2 = null;
    private GameEquipment back = null;

    //Current Weapon
    private GameEquipment mainHand = null;
    private GameEquipment offHand = null;

    private GameCharacterStats postStatsEquipment; //status with all equipment applied

    protected void setPostStatsEquipment(GameCharacterStats stats){
        postStatsEquipment = stats;
    }

    public GameCharacterStats getPostStatsEquipment() {
        return postStatsEquipment;
    }


    public void generatePostStats(){
        this.setPostStatsFinal(postStatsEquipment.clone());
        applyStatusToStatsFinal();
    }

    public void generatePostEquipmentStats(){
        GameCharacterStats stats = getBaseStats().clone();
        stats.addEquipmentEffect(headgear);
        stats.addEquipmentEffect(torso);
        stats.addEquipmentEffect(pants);
        stats.addEquipmentEffect(shoes);
        stats.addEquipmentEffect(gloves);
        stats.addEquipmentEffect(mainHand);
        stats.addEquipmentEffect(offHand);
        setPostStatsEquipment(stats);
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Override
    public float remainingCapacity(){
        return carryCapacity() - getTotalWeight();
    }

    @Override
    public float getTotalWeight(){
        float w = 0;
        if (headgear != null)
            w += headgear.getWeight();
        if (torso != null)
            w += torso.getWeight();
        if (pants != null)
            w += pants.getWeight();
        if (shoes != null)
            w += shoes.getWeight();
        if (gloves != null)
            w += gloves.getWeight();
        if (belt1 != null)
            w += belt1.getWeight();
        if (belt2 != null)
            w += belt2.getWeight();
        if (back != null)
            w += back.getWeight();
        return w;
    }
}
