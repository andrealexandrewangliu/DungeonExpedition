package com.game.andreliu.dungeondivers.data.gamedata.CharacterStats;

/**
 * Created by xmyx on 15/03/16.
 */
public class GameCharacterSkillValues {
    private int level;
    private int experience;

    public int requireExp(){
        if (level >= 100)
            return -1;
        return requireExpTotal() - experience;
    }

    public int requireExpTotal(){
        return 10 * (int) Math.pow(2, level);
    }

    public int experienceTotal(){
        return  experience;
    }

    public int experience(){
        return  experience - (requireExpTotal() / 2);
    }

    public void addExperience(int exp) {
        experience += exp;
        autoLevelUp();
    }

    private void autoLevelUp(){
        while (level < 100 && requireExpTotal() <= experience){
            level++;
        }
    }

    private void autoLevelDown(){
        while (level > 0 && (requireExpTotal()/2) > experience){
            level--;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (this.level > level) {
            this.level = level;
            experience = requireExpTotal();
        }
        else {
            this.level = level;
            int required = requireExpTotal();
            if (required > experience)
                experience = required;
        }
    }
}
