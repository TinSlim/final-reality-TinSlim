package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMageCharacter extends AbstractMageCharacter {

    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     */
    public WhiteMageCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                              final int maxHp, final int defense, final int maxMana) {
        super(turnsQueue, name, maxHp, defense,maxMana);
    }

    /**
     * This WhiteMageCharacter cures a target (IPlayerCharacter).
     * @param target PlayerCharacter that will receive health points.
     */
    public void cure(IPlayerCharacter target) {
        if ((this.getMana() - 15) >= 0) {
            this.reduceMana(15);
            int life = target.getMaxHp();
            target.receiveLife((life * 3) / 10 );
        }
    }

    /**
     * This WhiteMageCharacter venom a target (Enemy).
     * @param target Enemy that will receive venom attack.
     */
    public void venom(Enemy target) {
        if ((this.getMana() - 40) >= 0) {
            this.reduceMana(40);
            Staff weaponStaff = (Staff) this.getEquippedWeapon();
            int damage = weaponStaff.getMagicDamage() / 3;
            target.setPoisonDamage(damage);
        }
    }

    /**
     * This WhiteMageCharacter paralyzes a target (Enemy).
     * @param target Enemy that will receive paralysis.
     */
    public void paralyze(Enemy target) {
        if ((this.getMana() - 25) >= 0) {
            this.reduceMana(25);
            target.setParalyze(true);
        }
    }

    @Override
    public void equipWeapon(IWeapon weapon) {
        weapon.equipToWhiteMage(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WhiteMageCharacter)) {
            return false;
        }
        final WhiteMageCharacter character = (WhiteMageCharacter) o;
        return this.getName().equals(character.getName()) && this.getDefense() == character.getDefense() &&
                this.getMaxHp() == character.getMaxHp() && this.getMaxMana() == character.getMaxMana();
    }
}
