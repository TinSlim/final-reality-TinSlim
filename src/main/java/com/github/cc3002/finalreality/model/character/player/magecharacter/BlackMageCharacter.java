package com.github.cc3002.finalreality.model.character.player.magecharacter;

import java.util.Random;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class BlackMageCharacter extends AbstractMageCharacter {
    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     */
    public BlackMageCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                              final int maxHp, final int defense, final int maxMana) {
        super(turnsQueue, name, CharacterClass.BLACK_MAGE, maxHp, defense,maxMana);
    }

    /**
     * This BlackMageCharacter attacks a target (Enemy) with thunder magic with a chance to paralize
     * the target.
     */
    public void thunder(Enemy target) {
        if ((this.getMana() - 15) < 0 || !this.getEquippedWeapon().castMagic()) {
            return;
        }
        else {
            this.reduceMana(15);
            Staff weapon = (Staff) this.getEquippedWeapon();
            int magicDamage = weapon.getMagicDamage();
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
     */
    public void fire(Enemy target) {
        if ((this.getMana() - 15) < 0 || !this.getEquippedWeapon().castMagic()) {
            return;
        }
        else{
            this.reduceMana(15);
            Staff weapon = (Staff) this.getEquippedWeapon();
            int magicDamage = weapon.getMagicDamage();
            target.receiveDamage(magicDamage);
            Random rng = this.getRandom();
            int burnRandom = rng.nextInt(9);
            if (burnRandom < 2) {
                target.setBurnDamage(magicDamage / 3);
            }
        }
    }

    @Override
    public void equip(IWeapon weapon) {
        weapon.equipToBlackMage(this);
    }

}
