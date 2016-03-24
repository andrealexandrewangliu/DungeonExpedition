package com.game.andreliu.dungeondivers.data.gamedata.CharacterStats;

import com.game.andreliu.dungeondivers.data.gamedata.GameEquipment;

/**
 * Created by xmyx on 15/03/16.
 */
public class GameCharacterStats {
    private int mhp;    //health points max
    private int hp;     //health points
    private int msp;    //stamina points max
    private int sp;     //stamina points
    private int morale; //mental health (max at 100 min at 0)

    private float hpr;       //health points regeneration
    private float spr;       //stamina points regeneration

    private int strength;     //phys atk
    private int intelligence; //skill efficiency, magic speed
    private int dexterity;    //accuracy
    private int reflex;       //dodge
    private int mind;         //magic attack

    private float defense = 1;       //overall standard defense
    private float resistancema = 1;  //overall standard magic resistance
    private float resistancehe = 1;  //overall standard heat resistance
    private float resistanceli = 1;  //overall standard life resistance
    private float resistancecd = 1;  //overall standard cold resistance
    private float attack = 1;        //overall standard attack factor

    public int getMhp() {
        return mhp;
    }

    public int getHp() {
        return hp;
    }

    public int getMsp() {
        return msp;
    }

    public int getSp() {
        return sp;
    }

    public int getMorale() {
        return morale;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getReflex() {
        return reflex;
    }

    public int getMind() {
        return mind;
    }

    public void setMhp(int mhp) {
        this.mhp = mhp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMsp(int msp) {
        this.msp = msp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setReflex(int reflex) {
        this.reflex = reflex;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

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

    @Override
    public GameCharacterStats clone(){
        GameCharacterStats status = new GameCharacterStats();
        status.setMhp(mhp);status.setHp(hp);status.setHpr(hpr);
        status.setMsp(msp);status.setSp(sp);status.setSpr(spr);
        status.setMorale(morale);

        status.setStrength(strength);
        status.setIntelligence(intelligence);
        status.setDexterity(dexterity);
        status.setReflex(reflex);
        status.setMind(mind);

        status.setDefense(defense);
        status.setAttack(attack);
        status.setResistanceCold(resistancecd);
        status.setResistanceHeat(resistancehe);
        status.setResistanceLife(resistanceli);
        status.setResistanceMagic(resistancema);

        return status;
    }

    public void addEquipmentEffect(GameEquipment equipment){
        if (equipment != null) {
            this.hpr += equipment.getHpr();
            this.spr += equipment.getSpr();
            this.strength += equipment.getStrength();
            this.intelligence += equipment.getIntelligence();
            this.dexterity += equipment.getDexterity();
            this.reflex += equipment.getReflex();
            this.mind += equipment.getMind();
            this.attack += equipment.getAttack();
            this.defense += equipment.getDefense();
            this.resistancecd += equipment.getResistanceCold();
            this.resistancehe += equipment.getResistanceHeat();
            this.resistanceli += equipment.getResistanceLife();
            this.resistancema += equipment.getResistanceMagic();
        }
    }
}
