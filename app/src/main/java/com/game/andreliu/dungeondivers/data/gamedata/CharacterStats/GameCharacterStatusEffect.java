package com.game.andreliu.dungeondivers.data.gamedata.CharacterStats;

import java.util.Comparator;

/**
 * Created by xmyx on 15/03/16.
 */
public abstract class GameCharacterStatusEffect {
    public abstract String statusEffectName();

    public int compare(GameCharacterStatusEffect t2){
        return this.statusEffectName().compareTo(t2.statusEffectName());
    }

    public static Comparator comparator(){
        return new Comparator<GameCharacterStatusEffect>() {
            @Override
            public int compare(GameCharacterStatusEffect t1, GameCharacterStatusEffect t2) {
                return t1.compare(t2);
            }
        };
    }
}
