package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public abstract class AbstractMageCharacter extends AbstractPlayerCharacter implements IMageCharacter {
    private int mana;
    private int maxMana;

    Random adverseEffectProbability = new Random();

    /**
     * Creates a new MageCharacter.
     * @param turnsQueue       the queue with the characters waiting for their turn
     * @param name             the character's name
     * @param characterClass   the character's class
     * @param maxHp            the character's max health points value
     * @param defense          the character's defense
     * @param maxMana          the character's max mana value
     */
    public AbstractMageCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                                 CharacterClass characterClass, final int maxHp, final int defense, final int maxMana){
        super(turnsQueue, name, characterClass, maxHp, defense);
        this.mana = maxMana;
        this.maxMana = maxMana;
    }

    /**
     * Sets the seed for attacks with random factor.
     * @param seed value to repeat random numbers.
     */
    public void setSeed(long seed){
        this.adverseEffectProbability = new Random(seed);
    }

    /**
     * Gets Random parameter for for adverse effects.
     * @return Random parameter for adverse effects.
     */
    public Random getRandom(){
        return this.adverseEffectProbability;
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public int getMaxMana() {
        return this.maxMana;
    }

    /**
     * Sets this MageCharacter's mana.
     * @param mana new mana.
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Reduces actual mana.
     * @param mana quantity to reduce.
     */
    public void reduceMana(int mana){
        this.setMana(this.mana - mana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(),getName(),getMaxHp(),getDefense(),getMaxMana());
    }
}
