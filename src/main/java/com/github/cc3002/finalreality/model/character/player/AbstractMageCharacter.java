package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractMageCharacter extends PlayerCharacter {

    private int mana = 50;

    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public AbstractMageCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass) {
        super(name, turnsQueue, characterClass);
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    boolean cast(int cost) {
        AbstractWeapon abstractWeapon = getEquippedWeapon();
        if (this.getMana() - cost < 0 || abstractWeapon.getType() != WeaponType.STAFF) {
            return false;
        } else {
            return true;
        }
    }
    
}
