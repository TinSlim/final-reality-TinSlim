package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractCommonCharacter extends PlayerCharacter{
    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public AbstractCommonCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass) {
        super(name, turnsQueue, characterClass);
    }


}
