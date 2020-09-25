package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class EngineerCharacter extends AbstractCommonCharacter {
    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public EngineerCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass) {
        super(name, turnsQueue, characterClass);
    }

    public void equip(Weapon weapon) {
        if (weapon.getType() == WeaponType.AXE || weapon.getType() == WeaponType.BOW) {
            this.setEquippedWeapon(weapon);
        }
    }

    /**Todo
    public boolean equipWeapon(Weapon weapon) {
        if (weapon.getType() == WeaponType.AXE  || weapon.getType() == WeaponType.BOW) {
            this.equip(weapon);
            return true;
        } else {
            return false;
        }
    }**/
}

