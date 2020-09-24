package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class ThiefCharacter extends PlayerCharacter{

    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public ThiefCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass) {
        super(name, turnsQueue, characterClass);
    }

    public boolean equipWeapon(Weapon weapon) {
        if (weapon.getType() == WeaponType.SWORD  || weapon.getType() == WeaponType.BOW || weapon.getType() == WeaponType.STAFF) {
            this.equip(weapon);
            return true;
        } else {
            return false;
        }
    }
}

