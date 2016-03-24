package com.game.andreliu.dungeondivers.data.gamedata;

import com.game.andreliu.dungeondivers.data.gamedata.CharacterStats.GameCharacterStatusEffect;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by xmyx on 15/03/16.
 */
public class GameWeapon extends GameEquipment {
    private float ratioPhysical = 1;  //How much is physical damage
    private float ratioHeat = 0;      //How much is heat damage
    private float ratioLife = 0;      //How much is life damage
    private float ratioCold = 0;      //How much is cold damage
    private float ratioMagic = 0;     //How much is magic damage
    private float ratioStamina = 0;   //How much is sp damage

    private float ratioLifeRecovery = 0;    //How much of overall hp damage is recovered as hp
    private float ratioStaminaRecovery = 0; //How much of overall sp damage is recovered as sp

    private float ratioDefense = 0;   //How much good is at defense (bonus to intentional defend and chance to auto defend)

    private boolean offensive = true; //Is the weapon meant for offense

    private boolean ranged = false;   //Is it ranged weapon

    private int spCost = 1;     //How much sp used when used as attack (Unused in easy)
    private float ammoCost = 0;     //How much sp used when used as attack (Unused in easy)

    private boolean oneHand = true; //Can it be used as a one handed weapon
    private boolean twoHand = true; //Can it be used as a two handed weapon (two handed attacks and defenses receives + 50% bonus on strength)

    private TreeMap<GameCharacterStatusEffect, Float> statusEffects = new TreeMap<GameCharacterStatusEffect, Float>(GameCharacterStatusEffect.comparator());

    public float getRatioPhysical() {
        return ratioPhysical;
    }

    public void setRatioPhysical(float ratioPhysical) {
        this.ratioPhysical = ratioPhysical;
    }

    public float getRatioHeat() {
        return ratioHeat;
    }

    public void setRatioHeat(float ratioHeat) {
        this.ratioHeat = ratioHeat;
    }

    public float getRatioLife() {
        return ratioLife;
    }

    public void setRatioLife(float ratioLife) {
        this.ratioLife = ratioLife;
    }

    public float getRatioCold() {
        return ratioCold;
    }

    public void setRatioCold(float ratioCold) {
        this.ratioCold = ratioCold;
    }

    public float getRatioMagic() {
        return ratioMagic;
    }

    public void setRatioMagic(float ratioMagic) {
        this.ratioMagic = ratioMagic;
    }

    public float getRatioStamina() {
        return ratioStamina;
    }

    public void setRatioStamina(float ratioStamina) {
        this.ratioStamina = ratioStamina;
    }

    public float getRatioLifeRecovery() {
        return ratioLifeRecovery;
    }

    public void setRatioLifeRecovery(float ratioLifeRecovery) {
        this.ratioLifeRecovery = ratioLifeRecovery;
    }

    public float getRatioStaminaRecovery() {
        return ratioStaminaRecovery;
    }

    public void setRatioStaminaRecovery(float ratioStaminaRecovery) {
        this.ratioStaminaRecovery = ratioStaminaRecovery;
    }

    public float getRatioDefense() {
        return ratioDefense;
    }

    public void setRatioDefense(float ratioDefense) {
        this.ratioDefense = ratioDefense;
    }

    public boolean isOffensive() {
        return offensive;
    }

    public void setOffensive(boolean offensive) {
        this.offensive = offensive;
    }

    public boolean isRanged() {
        return ranged;
    }

    public void setRanged(boolean ranged) {
        this.ranged = ranged;
    }

    public int getSpCost() {
        return spCost;
    }

    public void setSpCost(int spCost) {
        this.spCost = spCost;
    }

    public float getAmmoCost() {
        return ammoCost;
    }

    public void setAmmoCost(float ammoCost) {
        this.ammoCost = ammoCost;
    }

    public boolean isOneHand() {
        return oneHand;
    }

    public void setOneHand(boolean oneHand) {
        this.oneHand = oneHand;
    }

    public boolean isTwoHand() {
        return twoHand;
    }

    public void setTwoHand(boolean twoHand) {
        this.twoHand = twoHand;
    }

    public TreeMap<GameCharacterStatusEffect, Float> getStatusEffectsMap() {
        return statusEffects;
    }

    public void putStatusEffects(GameCharacterStatusEffect[] statusEffects, float[] statusEffectsChance) {
        for (int i = 0; i < statusEffects.length; i++) {
            this.statusEffects.put(statusEffects[i], statusEffectsChance[i]);
        }
    }

    @Override
    public int compare(GameEquipment that){
        float r = super.compare(that);
        if (r == 0) {
            GameWeapon thatW = (GameWeapon) that;
            r = ratioPhysical - thatW.getRatioPhysical();
            if (r == 0) {
                r = ratioMagic - thatW.getRatioMagic();
                if (r == 0) {
                    r = ratioHeat - thatW.getRatioHeat();
                    if (r == 0) {
                        r = ratioCold - thatW.getRatioCold();
                        if (r == 0) {
                            r = ratioLife - thatW.getRatioLife();
                            if (r == 0) {
                                r = ratioStamina - thatW.getRatioStamina();
                                if (r == 0) {
                                    r = ratioDefense - thatW.getRatioDefense();
                                    if (r == 0) {
                                        r = ratioLifeRecovery - thatW.getRatioLifeRecovery();
                                        if (r == 0) {
                                            r = ratioStaminaRecovery - thatW.getRatioStaminaRecovery();
                                            if (r == 0) {
                                                if (offensive == thatW.isOffensive())
                                                    r = 0;
                                                else if(offensive)
                                                    r = -1;
                                                else
                                                    r = 1;
                                                if (r == 0) {
                                                    if (ranged == thatW.isRanged())
                                                        r = 0;
                                                    else if(ranged)
                                                        r = -1;
                                                    else
                                                        r = 1;
                                                    if (r == 0) {
                                                        r = thatW.getAmmoCost() - ammoCost;
                                                        if (r == 0) {
                                                            r = thatW.getSpCost() - spCost;
                                                            if (r == 0) {
                                                                if (oneHand == thatW.isOneHand())
                                                                    r = 0;
                                                                else if(oneHand)
                                                                    r = -1;
                                                                else
                                                                    r = 1;
                                                                if (r == 0) {
                                                                    if (twoHand == thatW.isTwoHand())
                                                                        r = 0;
                                                                    else if(twoHand)
                                                                        r = -1;
                                                                    else
                                                                        r = 1;

                                                                    if (r == 0){
                                                                        TreeMap<GameCharacterStatusEffect, Float> thatStatusEffects = thatW.getStatusEffectsMap();
                                                                        if (statusEffects != thatStatusEffects){
                                                                            if (statusEffects == null)
                                                                                r = -1;
                                                                            else if (thatStatusEffects == null)
                                                                                r = 1;
                                                                            r = statusEffects.size() - thatStatusEffects.size();
                                                                            if (r == 0) {
                                                                                Iterator<GameCharacterStatusEffect> thisIt = statusEffects.keySet().iterator();
                                                                                Iterator<GameCharacterStatusEffect> thatIt = thatStatusEffects.keySet().iterator();
                                                                                while (thisIt.hasNext()){
                                                                                    GameCharacterStatusEffect thisEffect = thisIt.next();
                                                                                    GameCharacterStatusEffect thatEffect = thatIt.next();
                                                                                    r = thisEffect.compare(thatEffect);
                                                                                    if (r != 0)
                                                                                        break;
                                                                                    else {
                                                                                        r = statusEffects.get(thisEffect) - thatStatusEffects.get(thatEffect);
                                                                                        if (r != 0)
                                                                                            break;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }

                                                            }
                                                        }
                                                    }

                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (r > 0)
            return 1;
        else if (r < 0)
            return  -1;
        return 0;
    }
}
