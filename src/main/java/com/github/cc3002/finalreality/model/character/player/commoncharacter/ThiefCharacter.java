package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class ThiefCharacter extends AbstractPlayerCharacter {


    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     */
    public ThiefCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,@NotNull String name,
                          final int maxHp,final int defense) {
        super(turnsQueue, name, CharacterClass.THIEF, maxHp, defense);
    }

    @Override
    public void equip(IWeapon weapon) {
        weapon.equipToThief(this);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ThiefCharacter)) {
            return false;
        }
        final ThiefCharacter character = (ThiefCharacter) o;
        return this.getName() == character.getName() && this.getDefense() == character.getDefense() &&
                this.getMaxHp() == character.getMaxHp();
    }
}

