package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class EngineerCharacterCommonCharacter extends AbstractCommonCharacter {

    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public EngineerCharacterCommonCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                                            final int maxHp, final int defense) {
        super(turnsQueue, name, CharacterClass.ENGINEER, maxHp, defense);
    }

    @Override
    public void equip(IWeapon weapon) {
        weapon.equipToEngineer(this);
    }
}

