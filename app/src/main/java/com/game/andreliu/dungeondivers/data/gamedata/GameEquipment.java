package com.game.andreliu.dungeondivers.data.gamedata;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by xmyx on 15/03/16.
 */
public class GameEquipment {
    private String name;
    private float hpr = 0;       //health points regeneration
    private float spr = 0;       //stamina points regeneration

    private int strength = 0;     //phys atk
    private int intelligence = 0; //skill efficiency, magic speed
    private int dexterity = 0;    //accuracy
    private int reflex = 0;       //dodge
    private int mind = 0;         //magic attack

    private float defense = 0;       //overall standard defense
    private float resistancema = 0;  //overall standard magic resistance
    private float resistancehe = 0;  //overall standard heat resistance
    private float resistancecd = 0;  //overall standard cold resistance
    private float resistanceli = 0;  //overall standard life resistance
    private float attack = 0;        //overall standard attack factor

    private float weight = 0;        //equipment weight (unavailable in easy mode)

    private int durability = Integer.MAX_VALUE; //When equipment breaks (unavailable in easy mode)

    private TreeMap<String, Float> statusResistance = new TreeMap<String, Float>();

    public float getDefense() {
        return defense;
    }

    public float getResistanceMagic() {
        return resistancema;
    }

    public float getResistanceHeat() {
        return resistancehe;
    }

    public float getResistanceLife() {
        return resistanceli;
    }

    public float getResistanceCold() {
        return resistancecd;
    }

    public float getAttack() {
        return attack;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public void setResistanceMagic(float resistancema) {
        this.resistancema = resistancema;
    }

    public void setResistanceHeat(float resistancehe) {
        this.resistancehe = resistancehe;
    }

    public void setResistanceLife(float resistanceli) {
        this.resistanceli = resistanceli;
    }

    public void setResistanceCold(float resistancecd) {
        this.resistancecd = resistancecd;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public float getHpr() {
        return hpr;
    }

    public void setHpr(float hpr) {
        this.hpr = hpr;
    }

    public float getSpr() {
        return spr;
    }

    public void setSpr(float spr) {
        this.spr = spr;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getReflex() {
        return reflex;
    }

    public void setReflex(int reflex) {
        this.reflex = reflex;
    }

    public int getMind() {
        return mind;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeMap<String, Float> getStatusResistanceMap() {
        return statusResistance;
    }

    public void putStatusResistance(String[] status, float[] chances) {
        for (int i = 0; i < status.length; i++) {
            this.statusResistance.put(status[i], chances[i]);
        }
    }

    public int compare(GameEquipment that){
        float r = name.compareTo(that.getName());
        if (r == 0) {
            r = weight - that.getWeight();
            if (r == 0) {
                r = that.getDurability() - durability;
                if (r == 0) {
                    r = that.getAttack() - attack;
                    if (r == 0) {
                        r = that.getDefense() - defense;
                        if (r == 0) {
                            r = that.getStrength() - strength;
                            if (r == 0) {
                                r = that.getIntelligence() - intelligence;
                                if (r == 0) {
                                    r = that.getDexterity() - dexterity;
                                    if (r == 0) {
                                        r = that.getMind() - mind;
                                        if (r == 0) {
                                            r = that.getReflex() - reflex;
                                            if (r == 0) {
                                                r = that.getResistanceMagic() - resistancema;
                                                if (r == 0) {
                                                    r = that.getResistanceHeat() - resistancehe;
                                                    if (r == 0) {
                                                        r = that.getResistanceCold() - resistancecd;
                                                        if (r == 0) {
                                                            r = that.getResistanceLife() - resistanceli;
                                                            if (r == 0) {
                                                                r = that.getHpr() - hpr;
                                                                if (r == 0) {
                                                                    r = that.getSpr() - spr;
                                                                    if (r == 0){
                                                                        TreeMap<String, Float> thatStatusResistance = that.getStatusResistanceMap();
                                                                        if (statusResistance != thatStatusResistance){
                                                                            if (statusResistance == null)
                                                                                r = -1;
                                                                            else if (thatStatusResistance == null)
                                                                                r = 1;
                                                                            r = statusResistance.size() - thatStatusResistance.size();
                                                                            if (r == 0) {
                                                                                Iterator<String> thisIt = statusResistance.keySet().iterator();
                                                                                Iterator<String> thatIt = thatStatusResistance.keySet().iterator();
                                                                                while (thisIt.hasNext()){
                                                                                    String thisEffect = thisIt.next();
                                                                                    String thatEffect = thatIt.next();
                                                                                    r = thisEffect.compareTo(thatEffect);
                                                                                    if (r != 0)
                                                                                        break;
                                                                                    else {
                                                                                        r = statusResistance.get(thisEffect) - thatStatusResistance.get(thatEffect);
                                                                                        if (r != 0)
                                                                                            break;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        if (r == 0) {
                                                                            if (!this.getClass().equals(that.getClass())) {
                                                                                if (that instanceof GameWeapon){
                                                                                    return -1;
                                                                                }
                                                                                else {
                                                                                    return 1;
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


    public static int compare(GameEquipment gameEquipment, GameEquipment t1) {
        return gameEquipment.compare(t1);
    }

    public static Comparator comparator(){
        return new Comparator<GameEquipment>() {
            @Override
            public int compare(GameEquipment gameEquipment, GameEquipment t1) {
                return gameEquipment.compare(t1);
            }
        };
    }
}
