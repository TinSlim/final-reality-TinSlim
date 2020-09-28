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

    /**
     * This BlackMageCharacter attacks a target (Enemy) with thunder magic with a chance to paralize
     * the target.
     */
    public void thunder(Enemy target) {
        Staff weapon = (Staff) this.getEquippedWeapon();
        int damage = weapon.getMagicDamage();
        target.receiveDamage(damage);
        Random rng = new Random();
        int posibilityToParalize = rng.nextInt(9);
        if (posibilityToParalize <= 3) {
            
        }

    }

    /**
     * This BlackMageCharacter attacks a target (Enemy) with fire magic with a chance to burn
     * the target.
     */
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

    @Override
    public void equip(IWeapon weapon) {
        weapon.equipToBlackMage(this);
    }

}
