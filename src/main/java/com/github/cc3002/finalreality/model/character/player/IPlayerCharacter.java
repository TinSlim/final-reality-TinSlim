package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;

public interface IPlayerCharacter {

    /**
     * Sets weapon to this character's equipped weapon, only if the character's class can use it.
     */
    void equip(AbstractWeapon abstractWeapon);

    /**
     * Returns this character's equipped weapon.
     */
    AbstractWeapon getEquippedWeapon();

    /**
     * Sets weapon to this character's equipped weapon.
     */
    void setEquippedWeapon(AbstractWeapon abstractWeapon);
}
