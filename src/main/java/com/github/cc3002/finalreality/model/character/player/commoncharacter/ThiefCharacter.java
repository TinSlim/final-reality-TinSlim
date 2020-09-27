package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class ThiefCharacter extends PlayerCharacter {

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

    /* Todo delet this
    public void equip(Weapon weapon) {
        if (weapon.getType() == WeaponType.SWORD  || weapon.getType() == WeaponType.BOW || weapon.getType() == WeaponType.STAFF) {
            this.setEquippedWeapon(weapon);
        }
    }*/

    //public void equip(IThiefWeapon weapon) {
    //    this.setEquippedWeapon((Weapon) weapon);
    //}

    public void equip(Weapon weapon) {
        weapon.equipToThief(this);
    }
    /**public void equip(Sword weapon) {
        this.setEquippedWeapon(weapon);
    }

    public void equip(Bow weapon) {
        this.setEquippedWeapon(weapon);
    }

    public void equip(Staff weapon) {
        this.setEquippedWeapon(weapon);
    }
    /**public void equip(Weapon weapon) {
        WeaponType typeEquippingWeapon = weapon.getType();
        switch (typeEquippingWeapon) {
            case SWORD:
                this.setEquippedWeapon(weapon);
            case BOW:
                this.setEquippedWeapon(weapon);
            case STAFF:
                this.setEquippedWeapon(weapon);
            default:
                break;
        }
    }

    /**
    public boolean equipWeapon(Weapon weapon) {
        if (weapon.getType() == WeaponType.SWORD  || weapon.getType() == WeaponType.BOW || weapon.getType() == WeaponType.STAFF) {
            this.equip(weapon);
            return true;
        } else {
            return false;
        }
    }**/
}

