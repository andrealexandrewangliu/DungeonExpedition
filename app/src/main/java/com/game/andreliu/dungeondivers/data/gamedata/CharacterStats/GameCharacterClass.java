package com.game.andreliu.dungeondivers.data.gamedata.CharacterStats;

import android.telephony.CellSignalStrength;

import com.game.andreliu.dungeondivers.common.Action;
import com.game.andreliu.dungeondivers.common.Condition;
import com.game.andreliu.dungeondivers.data.CurrentGameData;
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
        CHIEF,
        STRATEGIST,
        MASTERMIND,
        SUPREME_COMMANDER,
        MCADVENTURER,
        MCWARRIOR,
        HERO,
        SLAYER,
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
        EXORCIST,
        PRIEST,
        APPRENTICE,
        ARTISAN,
        WEAPONSMITH,
        ARMORER,
        SCHOLAR,
        ALCHEMIST,
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
        if (requirements != null)
            return requirements.parseCondition(character);
        return true;
    }

    public void addBonus(GamePersonCharacter character){
        if (bonus != null)
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
            staticGameClassList.put(classIndex.LORD, new GameCharacterClass("Lord")); //Main character Strategy defense Path
            staticGameClassList.put(classIndex.CHIEF, new GameCharacterClass("Chief")); //Main character Strategy offense Path
            staticGameClassList.put(classIndex.STRATEGIST, new GameCharacterClass("Strategist")); //Main character Strategy Control Path
            staticGameClassList.put(classIndex.MASTERMIND, new GameCharacterClass("Mastermind")); //Main character Strategy Trap Path
            staticGameClassList.put(classIndex.SUPREME_COMMANDER, new GameCharacterClass("Supreme Commander")); //Main character Strategy Micro Path


            staticGameClassList.put(classIndex.MCADVENTURER, new GameCharacterClass("Adventurer")); //Main character Combatant Path
            staticGameClassList.put(classIndex.MCWARRIOR, new GameCharacterClass("Warrior")); //Main character close quarters Path
            staticGameClassList.put(classIndex.HERO, new GameCharacterClass("Hero")); //Main character melee magic path
            staticGameClassList.put(classIndex.SLAYER, new GameCharacterClass("Slayer")); //Main character melee damage path
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
            staticGameClassList.get(classIndex.LEADER).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.LORD), staticGameClassList.get(classIndex.CHIEF)});
            staticGameClassList.get(classIndex.STRATEGIST).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.MASTERMIND), staticGameClassList.get(classIndex.SUPREME_COMMANDER)});
            staticGameClassList.get(classIndex.MCADVENTURER).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.MCWARRIOR), staticGameClassList.get(classIndex.MCSKIRMISHER), staticGameClassList.get(classIndex.MCSCOUT), staticGameClassList.get(classIndex.MCMAGE), staticGameClassList.get(classIndex.MCACOLYTE)});
            staticGameClassList.get(classIndex.MCWARRIOR).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.HERO), staticGameClassList.get(classIndex.SLAYER)});
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
            staticGameClassList.put(classIndex.EXORCIST, new GameCharacterClass("Exorcist"));
            staticGameClassList.put(classIndex.PRIEST, new GameCharacterClass("Priest"));

            staticGameClassList.put(classIndex.APPRENTICE, new GameCharacterClass("Apprentice"));
            staticGameClassList.put(classIndex.ARTISAN, new GameCharacterClass("Artisan"));
            staticGameClassList.put(classIndex.WEAPONSMITH, new GameCharacterClass("Blacksmith"));
            staticGameClassList.put(classIndex.ARMORER, new GameCharacterClass("Tailor"));
            staticGameClassList.put(classIndex.SCHOLAR, new GameCharacterClass("Scholar"));
            staticGameClassList.put(classIndex.ALCHEMIST, new GameCharacterClass("Alchemist"));
            staticGameClassList.put(classIndex.ENCHANTER, new GameCharacterClass("Enchanter"));

            staticGameClassList.get(classIndex.NOVICE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.ADVENTURER), staticGameClassList.get(classIndex.APPRENTICE)});
            staticGameClassList.get(classIndex.ADVENTURER).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.WARRIOR), staticGameClassList.get(classIndex.SKIRMISHER), staticGameClassList.get(classIndex.SCOUT), staticGameClassList.get(classIndex.MAGE), staticGameClassList.get(classIndex.ACOLYTE)});
            staticGameClassList.get(classIndex.WARRIOR).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.KNIGHT), staticGameClassList.get(classIndex.WEAPONMASTER)});
            staticGameClassList.get(classIndex.SKIRMISHER).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.SNIPER), staticGameClassList.get(classIndex.HUNTER), staticGameClassList.get(classIndex.ARCHER)});
            staticGameClassList.get(classIndex.SCOUT).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.EXPLORER), staticGameClassList.get(classIndex.ROGUE), staticGameClassList.get(classIndex.BOUNTY_HUNTER)});
            staticGameClassList.get(classIndex.MAGE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.ELEMENTALIST), staticGameClassList.get(classIndex.WIZARD), staticGameClassList.get(classIndex.SORCERER), staticGameClassList.get(classIndex.HEXER)});
            staticGameClassList.get(classIndex.ACOLYTE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.PALADIN), staticGameClassList.get(classIndex.EXORCIST), staticGameClassList.get(classIndex.PRIEST)});
            staticGameClassList.get(classIndex.APPRENTICE).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.ARTISAN), staticGameClassList.get(classIndex.SCHOLAR)});
            staticGameClassList.get(classIndex.ARTISAN).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.WEAPONSMITH), staticGameClassList.get(classIndex.ARMORER)});
            staticGameClassList.get(classIndex.SCHOLAR).setJobAdvances(new GameCharacterClass[]{staticGameClassList.get(classIndex.ALCHEMIST), staticGameClassList.get(classIndex.ENCHANTER)});

            initClassesRequirements();
        }
    }

    private static void initClassesRequirements(){
        Condition<GamePersonCharacter> temp;

        temp = new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 5;
            }
        };

        /** TIER 1 **/
        staticGameClassList.get(classIndex.MCADVENTURER).setRequirements(temp);
        staticGameClassList.get(classIndex.ADVENTURER).setRequirements(temp);
        staticGameClassList.get(classIndex.TACTICIAN).setRequirements(temp);
        staticGameClassList.get(classIndex.APPRENTICE).setRequirements(temp);

        /** TIER 2 **/
        staticGameClassList.get(classIndex.LEADER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 15 && parameter.getBaseStats().getIntelligence() >= 7 && parameter.getBaseStats().getMind() >= 7;
            }
        });
        staticGameClassList.get(classIndex.STRATEGIST).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 15 && parameter.getBaseStats().getIntelligence() >= 10;
            }
        });

        temp = new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 15 && parameter.getBaseStats().getStrength() >= 10;
            }
        };
        staticGameClassList.get(classIndex.MCWARRIOR).setRequirements(temp);
        staticGameClassList.get(classIndex.WARRIOR).setRequirements(temp);


        temp = new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 15 && parameter.getBaseStats().getDexterity() >= 10;
            }
        };
        staticGameClassList.get(classIndex.MCSKIRMISHER).setRequirements(temp);
        staticGameClassList.get(classIndex.SKIRMISHER).setRequirements(temp);


        temp = new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 15 && parameter.getBaseStats().getReflex() >= 10;
            }
        };
        staticGameClassList.get(classIndex.MCSCOUT).setRequirements(temp);
        staticGameClassList.get(classIndex.SCOUT).setRequirements(temp);


        temp = new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 15 && parameter.getBaseStats().getIntelligence() >= 10;
            }
        };
        staticGameClassList.get(classIndex.MCMAGE).setRequirements(temp);
        staticGameClassList.get(classIndex.MAGE).setRequirements(temp);


        temp = new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 15 && parameter.getBaseStats().getMind() >= 10;
            }
        };
        staticGameClassList.get(classIndex.MCACOLYTE).setRequirements(temp);
        staticGameClassList.get(classIndex.ACOLYTE).setRequirements(temp);

        staticGameClassList.get(classIndex.ARTISAN).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 15 && parameter.getBaseStats().getDexterity() >= 8;
            }
        });
        staticGameClassList.get(classIndex.SCHOLAR).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 15 && parameter.getBaseStats().getIntelligence() >= 8;
            }
        });

        /** TIER 3 **/

        /* Main Character*/
        staticGameClassList.get(classIndex.LORD).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && CurrentGameData.getCurrentGame().guildSize() >= 15 && parameter.getBaseStats().getIntelligence() >= 15 && parameter.getBaseStats().getMind() >= 10;
            }
        });
        staticGameClassList.get(classIndex.CHIEF).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getIntelligence() >= 15 && parameter.getBaseStats().getStrength() >= 15;
            }
        });
        staticGameClassList.get(classIndex.MASTERMIND).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getIntelligence() >= 30;
            }
        });
        staticGameClassList.get(classIndex.SUPREME_COMMANDER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getIntelligence() >= 15 && parameter.getBaseStats().getReflex() >= 15;
            }
        });

        staticGameClassList.get(classIndex.HERO).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getStrength() >= 15 && parameter.getBaseStats().getMind() >= 10 && parameter.getBaseStats().getReflex() >= 10;
            }
        });

        staticGameClassList.get(classIndex.SLAYER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getStrength() >= 20 && parameter.getBaseStats().getReflex() >= 10;
            }
        });

        staticGameClassList.get(classIndex.SHARPSHOOTER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getReflex() >= 15 && parameter.getBaseStats().getDexterity() >= 15;
            }
        });

        staticGameClassList.get(classIndex.RANGER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getReflex() >= 15 && parameter.getBaseStats().getDexterity() >= 10;
            }
        });

        staticGameClassList.get(classIndex.SEEKER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getReflex() >= 15 && parameter.getBaseStats().getIntelligence() >= 10;
            }
        });

        staticGameClassList.get(classIndex.ASSASSIN).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getReflex() >= 20 && parameter.getBaseStats().getDexterity() >= 10;
            }
        });

        staticGameClassList.get(classIndex.SAGE).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getIntelligence() >= 15 && parameter.getBaseStats().getMind() >= 10;
            }
        });

        staticGameClassList.get(classIndex.WARLOCK).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getIntelligence() >= 10 && parameter.getBaseStats().getMind() >= 20;
            }
        });

        staticGameClassList.get(classIndex.CHAMPION).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getStrength() >= 20 && parameter.getBaseStats().getMind() >= 10;
            }
        });

        staticGameClassList.get(classIndex.SAINT).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getMind() >= 20;
            }
        });

        /* Basic Character*/
        staticGameClassList.get(classIndex.KNIGHT).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getStrength() >= 15;
            }
        });

        staticGameClassList.get(classIndex.WEAPONMASTER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = parameter.getMasteryLevel("Blade".toLowerCase()) >= 30; //All swords
                if (!skillCheck){
                    skillCheck = parameter.getMasteryLevel("Heavy".toLowerCase()) >= 30; //All axes and maces
                    if (!skillCheck){
                        skillCheck = parameter.getMasteryLevel("Pole".toLowerCase()) >= 30; //All polearms
                    }
                }
                return skillCheck && parameter.getLevel() >= 30;
            }
        });

        staticGameClassList.get(classIndex.SNIPER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getDexterity() >= 20;
            }
        });

        staticGameClassList.get(classIndex.HUNTER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getDexterity() >= 15;
            }
        });

        staticGameClassList.get(classIndex.ARCHER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getDexterity() >= 10 && parameter.getBaseStats().getStrength() >= 10;
            }
        });

        staticGameClassList.get(classIndex.EXPLORER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getReflex() >= 15;
            }
        });

        staticGameClassList.get(classIndex.ROGUE).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getDexterity() >= 10 && parameter.getBaseStats().getReflex() >= 10;
            }
        });

        staticGameClassList.get(classIndex.BOUNTY_HUNTER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getReflex() >= 10 && parameter.getBaseStats().getStrength() >= 10;
            }
        });

        staticGameClassList.get(classIndex.ELEMENTALIST).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = (parameter.getMasteryLevel("Fire".toLowerCase()) +
                        parameter.getMasteryLevel("Thunder".toLowerCase()) +
                        parameter.getMasteryLevel("Ice".toLowerCase())
                )>= 30;

                return skillCheck && parameter.getLevel() >= 30;
            }
        });

        staticGameClassList.get(classIndex.WIZARD).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = parameter.getMasteryLevel("Magic".toLowerCase())>= 20;

                return skillCheck && parameter.getLevel() >= 30 && parameter.getBaseStats().getIntelligence() >= 15;
            }
        });

        staticGameClassList.get(classIndex.SORCERER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = parameter.getMasteryLevel("Magic".toLowerCase())>= 20;

                return skillCheck && parameter.getLevel() >= 30 && parameter.getBaseStats().getMind() >= 15;
            }
        });

        staticGameClassList.get(classIndex.HEXER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = parameter.getMasteryLevel("Death".toLowerCase())>= 20;

                return skillCheck && parameter.getLevel() >= 30;
            }
        });

        staticGameClassList.get(classIndex.PALADIN).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getStrength() >= 10 && parameter.getBaseStats().getMind() >= 10;
            }
        });

        staticGameClassList.get(classIndex.EXORCIST).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = parameter.getMasteryLevel("Holy".toLowerCase())>= 20;

                return skillCheck && parameter.getLevel() >= 30 && parameter.getBaseStats().getMind() >= 10;
            }
        });

        staticGameClassList.get(classIndex.PRIEST).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                return parameter.getLevel() >= 30 && parameter.getBaseStats().getMind() >= 15;
            }
        });

        staticGameClassList.get(classIndex.WEAPONSMITH).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = parameter.getMasteryLevel("Smithing".toLowerCase()) >= 20; //Metal equipment
                if (!skillCheck){
                    skillCheck = parameter.getMasteryLevel("Carpentry".toLowerCase()) >= 20; //Wood equipment
                }

                return skillCheck && parameter.getLevel() >= 30;
            }
        });

        staticGameClassList.get(classIndex.ARMORER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = parameter.getMasteryLevel("Smithing".toLowerCase()) >= 20; //Metal equipment
                if (!skillCheck){
                    skillCheck = parameter.getMasteryLevel("Tailoring".toLowerCase()) >= 20; //Cloth/leather equipment
                }

                return skillCheck && parameter.getLevel() >= 30;
            }
        });

        staticGameClassList.get(classIndex.ALCHEMIST).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = parameter.getMasteryLevel("Medicine".toLowerCase())>= 20;
                if (!skillCheck){
                    skillCheck = parameter.getMasteryLevel("Explosives".toLowerCase()) >= 20;
                }

                return skillCheck && parameter.getLevel() >= 30;
            }
        });

        staticGameClassList.get(classIndex.ENCHANTER).setRequirements(new Condition<GamePersonCharacter>() {
            @Override
            public boolean parseCondition(GamePersonCharacter parameter) {
                boolean skillCheck = false;

                skillCheck = parameter.getMasteryLevel("Enchanting".toLowerCase())>= 20;
                if (!skillCheck){
                    skillCheck = parameter.getMasteryLevel("Writing".toLowerCase()) >= 20;
                }

                return skillCheck && parameter.getLevel() >= 30;
            }
        });
    }


}
