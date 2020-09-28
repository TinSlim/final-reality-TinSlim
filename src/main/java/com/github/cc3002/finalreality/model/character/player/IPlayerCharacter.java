package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IPlayerCharacter {

    /**
     * Sets weapon to this character's equipped weapon, only if the character's class can use it.
     * @param weapon
     */
    void equip(IWeapon weapon);

    /**
     * Returns this character's equipped weapon.
     * @return
     */
    IWeapon getEquippedWeapon();

    /**
     * Sets weapon to this character's equipped weapon.
     */
    void setEquippedWeapon(AbstractWeapon abstractWeapon);
}
