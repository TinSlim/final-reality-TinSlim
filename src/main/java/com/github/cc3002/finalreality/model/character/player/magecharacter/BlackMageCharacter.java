package com.github.cc3002.finalreality.model.character.player.magecharacter;

import java.util.Random;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * The class that holds the information and methods of BlackMage type.
 */
public class BlackMageCharacter extends AbstractMageCharacter {

    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     */
    public BlackMageCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                              final int maxHp, final int defense, final int maxMana) {
        super(turnsQueue, name, maxHp, defense,maxMana);
    }

    /**
     * This BlackMageCharacter attacks a target (Enemy) with thunder magic with a chance to paralize
     * the target.
     * @param target Enemy that will receive thunder attack.
     */
    public void thunder(Enemy target) {
        IMageWeapons weapon = (IMageWeapons) this.getEquippedWeapon();
        if ((this.getMana() - 15) >= 0 && weapon.castMagic()) {
            this.reduceMana(15);
            Staff weaponStaff = (Staff) this.getEquippedWeapon();
            int magicDamage = weaponStaff.getMagicDamage();
            target.receiveDamage(magicDamage);
            Random rng = this.getRandom();
            int posibilityToParalize = rng.nextInt(9);
            if (posibilityToParalize < 3) {
                target.setParalyze(true);
            }
        }
    }

    /**
     * This BlackMageCharacter attacks a target (Enemy) with fire magic with a chance to burn
     * the target.
     * @param target Enemy that will receive fire attack.
     */
    public void fire(Enemy target) {
        IMageWeapons weapon = (IMageWeapons) this.getEquippedWeapon();
        if ((this.getMana() - 15) >= 0 && weapon.castMagic()) {
            this.reduceMana(15);
            Staff weaponStaff = (Staff) this.getEquippedWeapon();
            int magicDamage = weaponStaff.getMagicDamage();
            target.receiveDamage(magicDamage);
            Random rng = this.getRandom();
            int burnRandom = rng.nextInt(9);
            if (burnRandom < 2) {
                target.setBurnDamage(magicDamage / 2);
            }
        }
    }

    @Override
    public void equipWeapon(IWeapon weapon) {
        weapon.equipToBlackMage(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BlackMageCharacter)) {
            return false;
        }
        final BlackMageCharacter character = (BlackMageCharacter) o;
        return this.getName().equals(character.getName()) && this.getDefense() == character.getDefense() &&
                this.getMaxHp() == character.getMaxHp() && this.getMaxMana() == character.getMaxMana();
    }
}

