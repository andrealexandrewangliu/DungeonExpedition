package com.game.andreliu.dungeondivers.data.gamedata;

import com.game.andreliu.dungeondivers.data.gamedata.CharacterStats.GameCharacterAIBehavior;
import com.game.andreliu.dungeondivers.data.gamedata.CharacterStats.GameCharacterClass;
import com.game.andreliu.dungeondivers.data.gamedata.CharacterStats.GameCharacterStats;
import com.game.andreliu.dungeondivers.data.gamedata.CharacterStats.GameCharacterSkillValues;
import com.game.andreliu.dungeondivers.data.gamedata.CharacterStats.GameCharacterStatusEffect;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by xmyx on 15/03/16.
 */
public class GameCharacter {
    private GameCharacterStats baseStats = new GameCharacterStats();
    private GameCharacterStats postStatsFinal; //status with status effect applied;
    private String name;
    private Map<String, GameCharacterSkillValues> masteries = new TreeMap<String, GameCharacterSkillValues>();
    private Map<String, GameCharacterStatusEffect> statusEffects = new TreeMap<String, GameCharacterStatusEffect>();
    private Set<String> traits = new TreeSet<String>();
    private GameCharacterAIBehavior behavior = null;
    private GameCharacterClass characterClass = GameCharacterClass.getGameClass(GameCharacterClass.classIndex.PREDATOR);
    private int level;

    public GameCharacterStats getBaseStats() {
        return baseStats;
    }

    //TO-DO INCOMPLETE
    public void generatePostStats(){
        postStatsFinal = baseStats.clone();
        applyStatusToStatsFinal();
    }

    public void setPostStatsFinal(GameCharacterStats postStatsFinal) {
        this.postStatsFinal = postStatsFinal;
    }

    protected void applyStatusToStatsFinal(){

    }

    public int getMasteryLevel(String mastery){
        GameCharacterSkillValues skill = masteries.get(mastery);
        if (skill != null)
            return  skill.getLevel();
        return  0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //TO-DO INCOMPLETE
    public GameCharacterAIBehavior getBehavior() {
        return behavior;
    }

    //TO-DO INCOMPLETE
    public void setBehavior(GameCharacterAIBehavior behavior) {
        this.behavior = behavior;
    }

    public float carryCapacity(){
        return (10 * getBaseStats().getStrength());
    }

    public float remainingCapacity(){
        return (10 * getBaseStats().getStrength());
    }

    public float getTotalWeight(){
        return 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
