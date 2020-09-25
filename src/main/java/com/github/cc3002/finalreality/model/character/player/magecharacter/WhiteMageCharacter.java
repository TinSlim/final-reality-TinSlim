package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacter;
import com.github.cc3002.finalreality.model.weapon.StaffWeapon;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMageCharacter extends AbstractMageCharacter {

    int mana = 0;
    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public WhiteMageCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass) {
        super(name, turnsQueue, characterClass);
    }

    public void cure(PlayerCharacter target) {
        int life = target.getMaxHp();
        target.receiveLife((int) (life * 0.3));
    }

    public void venom(Enemy target) {
        StaffWeapon weapon = (StaffWeapon) this.getEquippedWeapon();
        int damage = weapon.getMagicDamage() / 3;
        target.setPoisonDamage(damage);
    }

    public void paralyze(Enemy target) {
    }

    /**
    public boolean equipWeapon(Weapon weapon) {
        if (weapon.getType() == WeaponType.STAFF) {
            this.equip(weapon);
            return true;
        } else {
            return false;
        }
    }**/

    public void equip(Weapon weapon) {
        if (weapon.getType() == WeaponType.STAFF) {
            this.setEquippedWeapon(weapon);
        }
    }

    boolean cast(int cost) {
        Weapon weapon = getEquippedWeapon();
        if (this.mana - cost < 0 || weapon.getType() != WeaponType.STAFF) {
            return false;
        } else {
            return true;
        }
    }
}
