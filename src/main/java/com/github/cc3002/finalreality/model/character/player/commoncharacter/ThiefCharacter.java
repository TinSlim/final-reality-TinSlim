package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * The class that holds the information and methods of Thief type.
 */
public class ThiefCharacter extends AbstractCommonCharacter {

  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   */
  public ThiefCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,@NotNull String name,
                        final int maxHp,final int defense) {
    super(turnsQueue, name, maxHp, defense);
  }

  @Override
  public void equipWeapon(IWeapon weapon) {
    weapon.equipToThief(this);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ThiefCharacter)) {
      return false;
    }
    final ThiefCharacter character = (ThiefCharacter) o;
    return this.getName().equals(character.getName()) && this.getDefense() == character.getDefense() &&
            this.getMaxHp() == character.getMaxHp();
  }
}

