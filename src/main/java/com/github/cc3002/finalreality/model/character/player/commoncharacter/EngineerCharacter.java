package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class EngineerCharacter extends AbstractCommonCharacter {

    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     */
    public EngineerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                             final int maxHp, final int defense) {
        super(turnsQueue, name, CharacterClass.ENGINEER, maxHp, defense);
    }

    @Override
    public void equip(IWeapon weapon) {
        weapon.equipToEngineer(this);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EngineerCharacter)) {
            return false;
        }
        final EngineerCharacter character = (EngineerCharacter) o;
        return this.getName() == character.getName() && this.getDefense() == character.getDefense() &&
                this.getMaxHp() == character.getMaxHp();
    }
}

