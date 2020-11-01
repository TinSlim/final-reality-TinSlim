package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractCommonCharacter extends AbstractPlayerCharacter {

    /**
     * Creates a new CommonCharacter.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param maxHp          the character's max health points value
     * @param defense        the character's defense
     */
    public AbstractCommonCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                                   final int maxHp, final int defense) {
        super(turnsQueue, name, maxHp, defense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(),getName(),getMaxHp(),getDefense());
    }
}
