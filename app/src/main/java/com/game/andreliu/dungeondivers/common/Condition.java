package com.game.andreliu.dungeondivers.common;

/**
 * Created by xmyx on 24/03/16.
 */
public interface Condition<Type> {
    public abstract boolean parseCondition(Type parameter);

}
