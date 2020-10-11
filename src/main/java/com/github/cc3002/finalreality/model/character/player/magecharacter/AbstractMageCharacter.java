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
        this.maxMana = maxMana;
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

    public int getMaxMana() {
        return this.maxMana;
    }

    /**
     * Sets this MageCharacter's mana.
     */
    public void setMana(int mana) {
        this.mana = mana;
    }


    public void reduceMana(int mana){
        this.setMana(this.mana - mana);
    }

    public int hashCode() {
        return Objects.hash(getCharacterClass(),getName(),getMaxHp(),getDefense(),getMaxMana());
    }
}
