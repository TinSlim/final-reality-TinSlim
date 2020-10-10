package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractCommonCharacterAbstract extends AbstractPlayerCharacter {
    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public AbstractCommonCharacterAbstract(@NotNull BlockingQueue<ICharacter> turnsQueue,@NotNull String name,
                                           CharacterClass characterClass, final int maxHp,final int defense) {
        super(turnsQueue, name, characterClass, maxHp, defense);
    }

    public int hashCode() {
        return Objects.hash(getCharacterClass(),getName(),getMaxHp(),getDefense());
    }
}
