package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMageCharacter extends PlayerCharacter{
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

    public void cure(PlayerCharacter target) {
        int life = target.getMaxHp();
        target.receiveLife((int) (life * 0.3));
    }

    public void venom(Enemy target) {

    }

    public void paralyze(Enemy target) {

    }

}
