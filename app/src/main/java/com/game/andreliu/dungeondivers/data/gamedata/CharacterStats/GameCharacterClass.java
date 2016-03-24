package com.game.andreliu.dungeondivers.data.gamedata.CharacterStats;

import android.telephony.CellSignalStrength;

import com.game.andreliu.dungeondivers.common.Action;
import com.game.andreliu.dungeondivers.common.Condition;
import com.game.andreliu.dungeondivers.data.gamedata.GamePersonCharacter;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by xmyx on 18/03/16.
 */
public class GameCharacterClass {
    private String name;
    //private static GameCharacterClass[] staticGameClassList;
    private static EnumMap<classIndex,GameCharacterClass> staticGameClassList;
    private GameCharacterClass[] jobAdvances;

    public enum classIndex{
        PREDATOR,
        MCNOVICE,
        TACTICIAN,
        LEADER,
        LORD,
        CHIEFTAIN,
        STRATEGIST,
        MASTERMIND,
        SUPREME_COMMANDER,
        MCADVENTURER,
        MCWARRIOR,
        HERO,
        MCSKIRMISHER,
        SHARPSHOOTER,
        RANGER,
        MCSCOUT,
        SEEKER,
        ASSASSIN,
        MCMAGE,
        SAGE,
        WARLOCK,
        MCACOLYTE,
        CHAMPION,
        SAINT,
        NOVICE,
        ADVENTURER,
        WARRIOR,
        KNIGHT,
        WEAPONMASTER,
        SKIRMISHER,
        SNIPER,
        HUNTER,
        ARCHER,
        SCOUT,
        EXPLORER,
        ROGUE,
        BOUNTY_HUNTER,
        MAGE,
        ELEMENTALIST,
        WIZARD,
        SORCERER,
        HEXER,
        ACOLYTE,
        PALADIN,
        INQUISITOR,
        PRIEST,
        APPRENTICE,
        ARTISAN,
        BLACKSMITH,
        CARPENTER,
        TAILOR,
        SCHOLAR,
        ALCHEMIST,
        JEWELER,
        ENCHANTER
    }

    // 00 - HP
    // 01 - SP
    // 02 - HP Regeneration
    // 03 - SP Regeneration
    // 04 - strength
    // 05 - intelligence
    // 06 - dexterity
    // 07 - reflex
    // 08 - mind
    // 09 - attack
    // 10 - defense
    // 11 - resistancema
    // 12 - resistancehe
    // 13 - resistanceli
    // 14 - resistancecd
    private Condition<GamePersonCharacter> requirements;
    private Action<GamePersonCharacter> bonus;

    private GameCharacterClass(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameCharacterClass[] getJobAdvances() {
        return jobAdvances;
    }

    public void setJobAdvances(GameCharacterClass[] jobAdvances) {
        this.jobAdvances = jobAdvances;
    }

    protected void setBonus(Action<GamePersonCharacter> bonus) {
        this.bonus = bonus;
    }

    protected void setRequirements(Condition<GamePersonCharacter> requirements) {
        this.requirements = requirements;
    }

    public boolean hasRequirement(GamePersonCharacter character){
        return requirements.parseCondition(character);
    }

    public void addBonus(GamePersonCharacter character){
        bonus.action(character);
    }

    //public static GameCharacterClass getGameClass(int i){
    //    return staticGameClassList.put(classIndex.i];
    //}

    public static GameCharacterClass getGameClass(classIndex i){
        return staticGameClassList.get(i);
    }
    public static void initClasses(){
        if (staticGameClassList == null) {
            staticGameClassList = new EnumMap<classIndex, GameCharacterClass>(classIndex.class);
            /**Beasts**/
            staticGameClassList.put(classIndex.PREDATOR, new GameCharacterClass("Predator"));

            /**Main character**/
            staticGameClassList.put(classIndex.MCNOVICE, new GameCharacterClass("Novice")); //Main character Basic

            staticGameClassList.put(classIndex.TACTICIAN, new GameCharacterClass("Tactician")); //Main character Strategy Path
            staticGameClassList.put(classIndex.LEADER, new GameCharacterClass("Leader")); //Main character Strategy Buff Path
            staticGameClassList.put(classIndex.LORD, new GameCharacterClass("Lord")); //Main character Strategy Aura Path
            staticGameClassList.put(classIndex.CHIEFTAIN, new GameCharacterClass("Chieftain")); //Main character Strategy Debuff Path
            staticGameClassList.put(classIndex.STRATEGIST, new GameCharacterClass("Strategist")); //Main character Strategy Control Path
            staticGameClassList.put(classIndex.MASTERMIND, new GameCharacterClass("Mastermind")); //Main character Strategy Trap Path
            staticGameClassList.put(classIndex.SUPREME_COMMANDER, new GameCharacterClass("Supreme Commander")); //Main character Strategy Micro Path


            staticGameClassList.put(classIndex.MCADVENTURER, new GameCharacterClass("Adventurer")); //Main character Combatant Path
            staticGameClassList.put(classIndex.MCWARRIOR, new GameCharacterClass("Warrior")); //Main character close quarters Path
            staticGameClassList.put(classIndex.HERO, new GameCharacterClass("Hero")); //Main character melee magic path
            staticGameClassList.put(classIndex.MCSKIRMISHER, new GameCharacterClass("Slayer")); //Main character melee damage path
            staticGameClassList.put(classIndex.MCSKIRMISHER, new GameCharacterClass("Skirmisher")); //Main character rogue Path
            staticGameClassList.put(classIndex.SHARPSHOOTER, new GameCharacterClass("Sharpshooter")); //Main character sniper path
            staticGameClassList.put(classIndex.RANGER, new GameCharacterClass("Ranger")); //Main character fast shooter path
            staticGameClassList.put(classIndex.MCSCOUT, new GameCharacterClass("Scout")); //Main character rogue Path
            staticGameClassList.put(classIndex.SEEKER, new GameCharacterClass("Seeker")); //Main character scout path
            staticGameClassList.put(classIndex.ASSASSIN, new GameCharacterClass("Assassin")); //Main character assassin path
            staticGameClassList.put(classIndex.MCMAGE, new GameCharacterClass("Mage")); //Main character magic Path
            staticGameClassList.put(classIndex.SAGE, new GameCharacterClass("Sage")); //Main character magic path
            staticGameClassList.put(classIndex.WARLOCK, new GameCharacterClass("Warlock")); //Main character debuffer path
            staticGameClassList.put(classIndex.MCACOLYTE, new GameCharacterClass("Acolyte")); //Main character holy Path
            staticGameClassList.put(classIndex.CHAMPION, new GameCharacterClass("Champion")); //Main character tank path
            staticGameClassList.put(classIndex.SAINT, new GameCharacterClass("Saint")); //Main character healer path

            staticGameClassList.get(classIndex.MCNOVICE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.TACTICIAN), staticGameClassList.get(classIndex.MCADVENTURER)});
            staticGameClassList.get(classIndex.TACTICIAN).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.LEADER), staticGameClassList.get(classIndex.STRATEGIST)});
            staticGameClassList.get(classIndex.LEADER).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.LORD), staticGameClassList.get(classIndex.CHIEFTAIN)});
            staticGameClassList.get(classIndex.STRATEGIST).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.MASTERMIND), staticGameClassList.get(classIndex.SUPREME_COMMANDER)});
            staticGameClassList.get(classIndex.MCADVENTURER).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.MCWARRIOR), staticGameClassList.get(classIndex.MCSKIRMISHER), staticGameClassList.get(classIndex.MCSCOUT), staticGameClassList.get(classIndex.MCMAGE), staticGameClassList.get(classIndex.MCACOLYTE)});
            staticGameClassList.get(classIndex.MCWARRIOR).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.HERO), staticGameClassList.get(classIndex.MCSKIRMISHER)});
            staticGameClassList.get(classIndex.MCSKIRMISHER).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.SHARPSHOOTER), staticGameClassList.get(classIndex.RANGER)});
            staticGameClassList.get(classIndex.MCSCOUT).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.SEEKER), staticGameClassList.get(classIndex.ASSASSIN)});
            staticGameClassList.get(classIndex.MCMAGE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.SAGE), staticGameClassList.get(classIndex.WARLOCK)});
            staticGameClassList.get(classIndex.MCACOLYTE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.CHAMPION), staticGameClassList.get(classIndex.SAINT)});

            /**Adventurers**/
            staticGameClassList.put(classIndex.NOVICE, new GameCharacterClass("Novice")); //Adventurer Basic
            staticGameClassList.put(classIndex.ADVENTURER, new GameCharacterClass("Adventurer"));
            staticGameClassList.put(classIndex.WARRIOR, new GameCharacterClass("Warrior"));
            staticGameClassList.put(classIndex.KNIGHT, new GameCharacterClass("Knight"));
            staticGameClassList.put(classIndex.WEAPONMASTER, new GameCharacterClass("Weaponmaster"));
            staticGameClassList.put(classIndex.SKIRMISHER, new GameCharacterClass("Skirmisher"));
            staticGameClassList.put(classIndex.SNIPER, new GameCharacterClass("Sniper"));
            staticGameClassList.put(classIndex.HUNTER, new GameCharacterClass("Hunter"));
            staticGameClassList.put(classIndex.ARCHER, new GameCharacterClass("Archer"));
            staticGameClassList.put(classIndex.SCOUT, new GameCharacterClass("Scout"));
            staticGameClassList.put(classIndex.EXPLORER, new GameCharacterClass("Explorer"));
            staticGameClassList.put(classIndex.ROGUE, new GameCharacterClass("Rogue"));
            staticGameClassList.put(classIndex.BOUNTY_HUNTER, new GameCharacterClass("Bounty Hunter"));
            staticGameClassList.put(classIndex.MAGE, new GameCharacterClass("Mage"));
            staticGameClassList.put(classIndex.ELEMENTALIST, new GameCharacterClass("Elementalist"));
            staticGameClassList.put(classIndex.WIZARD, new GameCharacterClass("Wizard"));
            staticGameClassList.put(classIndex.SORCERER, new GameCharacterClass("Sorcerer"));
            staticGameClassList.put(classIndex.HEXER, new GameCharacterClass("Hexer"));
            staticGameClassList.put(classIndex.ACOLYTE, new GameCharacterClass("Acolyte"));
            staticGameClassList.put(classIndex.PALADIN, new GameCharacterClass("Paladin"));
            staticGameClassList.put(classIndex.INQUISITOR, new GameCharacterClass("Inquisitor"));
            staticGameClassList.put(classIndex.PRIEST, new GameCharacterClass("Priest"));

            staticGameClassList.put(classIndex.APPRENTICE, new GameCharacterClass("Apprentice"));
            staticGameClassList.put(classIndex.ARTISAN, new GameCharacterClass("Artisan"));
            staticGameClassList.put(classIndex.BLACKSMITH, new GameCharacterClass("Blacksmith"));
            staticGameClassList.put(classIndex.CARPENTER, new GameCharacterClass("Carpenter"));
            staticGameClassList.put(classIndex.TAILOR, new GameCharacterClass("Tailor"));
            staticGameClassList.put(classIndex.SCHOLAR, new GameCharacterClass("Scholar"));
            staticGameClassList.put(classIndex.ALCHEMIST, new GameCharacterClass("Alchemist"));
            staticGameClassList.put(classIndex.JEWELER, new GameCharacterClass("Jeweler"));
            staticGameClassList.put(classIndex.ENCHANTER, new GameCharacterClass("Enchanter"));

            staticGameClassList.get(classIndex.NOVICE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.ADVENTURER), staticGameClassList.get(classIndex.APPRENTICE)});
            staticGameClassList.get(classIndex.ADVENTURER).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.WARRIOR), staticGameClassList.get(classIndex.SKIRMISHER), staticGameClassList.get(classIndex.SCOUT), staticGameClassList.get(classIndex.MAGE), staticGameClassList.get(classIndex.ACOLYTE)});
            staticGameClassList.get(classIndex.WARRIOR).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.KNIGHT), staticGameClassList.get(classIndex.WEAPONMASTER)});
            staticGameClassList.get(classIndex.SKIRMISHER).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.SNIPER), staticGameClassList.get(classIndex.HUNTER), staticGameClassList.get(classIndex.ARCHER)});
            staticGameClassList.get(classIndex.SCOUT).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.EXPLORER), staticGameClassList.get(classIndex.ROGUE), staticGameClassList.get(classIndex.BOUNTY_HUNTER)});
            staticGameClassList.get(classIndex.MAGE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.ELEMENTALIST), staticGameClassList.get(classIndex.WIZARD), staticGameClassList.get(classIndex.SORCERER), staticGameClassList.get(classIndex.HEXER)});
            staticGameClassList.get(classIndex.ACOLYTE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.PALADIN), staticGameClassList.get(classIndex.INQUISITOR), staticGameClassList.get(classIndex.PRIEST)});
            staticGameClassList.get(classIndex.APPRENTICE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.ARTISAN), staticGameClassList.get(classIndex.SCHOLAR)});
            staticGameClassList.get(classIndex.ARTISAN).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.BLACKSMITH), staticGameClassList.get(classIndex.CARPENTER), staticGameClassList.get(classIndex.TAILOR)});
            staticGameClassList.get(classIndex.SCHOLAR).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.ALCHEMIST), staticGameClassList.get(classIndex.JEWELER), staticGameClassList.get(classIndex.ENCHANTER)});

        }
    }
}
