package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractMageCharacter extends PlayerCharacter {
    int mana = 0;

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

    public void equip(Weapon weapon) {
    }

    public void setMana(int newMana) {
        this.mana = newMana;
    }

    boolean cast(int cost) {
        Weapon weapon = getEquippedWeapon();
        if (this.getMana() - cost < 0 || weapon.getType() != WeaponType.STAFF) {
            return false;
        } else {
            return true;
        }
    }
    
}
