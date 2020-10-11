package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractCommonCharacter extends AbstractPlayerCharacter {
    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public AbstractCommonCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                                   CharacterClass characterClass, final int maxHp, final int defense) {
        super(turnsQueue, name, characterClass, maxHp, defense);
    }

    public int hashCode() {
        return Objects.hash(getCharacterClass(),getName(),getMaxHp(),getDefense());
    }
}
