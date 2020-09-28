package com.github.cc3002.finalreality.model.character.player.magecharacter;

import java.util.Random;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacterAbstract;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class BlackMageCharacter extends AbstractMageCharacterAbstract {
    int mana = 0;

    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public BlackMageCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, CharacterClass characterClass) {
        super(name, turnsQueue, characterClass);
    }

    public void thunder(Enemy target) {
        Staff weapon = (Staff) this.getEquippedWeapon();
        int damage = weapon.getMagicDamage();
        target.receiveDamage(damage);
        Random rng = new Random();
        int posibilityToParalize = rng.nextInt(9);
        if (posibilityToParalize <= 3) {
            
        }

    }

    public void fire(Enemy target) {
        Staff weapon = (Staff) this.getEquippedWeapon();
        int magicDamage = weapon.getMagicDamage();
        target.receiveDamage(magicDamage);

        Random rng = new Random();
        int burnRandom = rng.nextInt(9);
        if (burnRandom <= 2) {
            target.setBurnDamage(magicDamage/3);
        }
    }


    //public void equip(IBlackMageWeapon weapon) {
    //    this.setEquippedWeapon((Weapon) weapon);
    //}



    public void equip(IWeapon weapon) {
        weapon.equipToBlackMage(this);
    }





    /**
    public void equip(Weapon weapon) {
        WeaponType typeEquippingWeapon = weapon.getType();
        switch (typeEquippingWeapon) {
            case STAFF:
                this.setEquippedWeapon(weapon);
            case KNIFE:
                this.setEquippedWeapon(weapon);
            default:
                break;
        }
    }

    /* Todo delet this
    public boolean equipWeapon(Weapon weapon) {
        if (weapon.getType() == WeaponType.STAFF || weapon.getType() == WeaponType.KNIFE) {
            this.equip(weapon);
            return true;
        } else {
            return false;
        }
    }
    */

}
