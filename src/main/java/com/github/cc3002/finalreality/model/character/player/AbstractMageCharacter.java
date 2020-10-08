package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractMageCharacter extends AbstractPlayerCharacter implements IMageCharacter{
    private int mana;
    Random adverseEffectProbability = new Random();

    /**
     * Creates a new character.
     *
     * @param name           the character's name
     * @param turnsQueue     the queue with the characters waiting for their turn
     * @param characterClass
     */
    public AbstractMageCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                                 CharacterClass characterClass, final int maxHp, final int defense, final int maxMana){
        super(turnsQueue, name, characterClass, maxHp, defense);
        this.mana = maxMana;
    }

    public void setSeed(long i){
        this.adverseEffectProbability = new Random(i);
    }

    public Random getRandom(){
        return this.adverseEffectProbability;
    }

    /**
     * Gets this MageCharacter's mana.
     */
    public int getMana() {
        return this.mana;
    }

    /**
     * Sets this MageCharacter's mana.
     */
    public void setMana(int mana) {
        this.mana = mana;
    }


    public void reduceMana(int mana){
        this.mana = this.mana - mana;
    }
}
