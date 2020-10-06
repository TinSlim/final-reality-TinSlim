package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMageCharacterMageCharacter extends AbstractMageCharacter {

    int mana = 0;
    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public WhiteMageCharacterMageCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                                           final int maxHp, final int defense, final int maxMana) {
        super(turnsQueue, name, CharacterClass.WHITE_MAGE, maxHp, defense,maxMana);
    }

    /**
     * This WhiteMageCharacterMageCharacter cures a target (IPlayerCharacter).
     */
    public void cure(IPlayerCharacter target) {
        int life = target.getMaxHp();
        target.receiveLife((int) (life * 0.3));
    }

    /**
     * This WhiteMageCharacterMageCharacter venom a target (Enemy).
     */
    public void venom(Enemy target) {
        Staff weapon = (Staff) this.getEquippedWeapon();
        int damage = weapon.getMagicDamage() / 3;
        target.setPoisonDamage(damage);
    }

    /**
     * This WhiteMageCharacterMageCharacter paralyzes a target (Enemy).
     */
    public void paralyze(Enemy target) {
    }

    @Override
    public void equip(IWeapon weapon) {
        weapon.equipToWhiteMage(this);
    }
}
