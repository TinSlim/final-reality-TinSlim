package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacterAbstract;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMageCharacter extends AbstractMageCharacterAbstract {

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

    public void cure(AbstractPlayerCharacter target) {
        int life = target.getMaxHp();
        target.receiveLife((int) (life * 0.3));
    }

    public void venom(Enemy target) {
        Staff weapon = (Staff) this.getEquippedWeapon();
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
    }
     * @param weapon**/
    /* Todo DELET
    public void equip(Weapon weapon) {
        if (weapon.getType() == WeaponType.STAFF) {
            this.setEquippedWeapon(weapon);
        }
    }
    */



    public void equip(IWeapon weapon) {
        weapon.equipToWhiteMage(this);
    }

    /**
    public void equip(Weapon weapon) {
        WeaponType typeEquippingWeapon = weapon.getType();
        switch (typeEquippingWeapon) {
            case STAFF:
                this.setEquippedWeapon(weapon);
            default:
                break;
        }
    }**/

}
