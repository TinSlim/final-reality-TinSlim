package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * The class that holds the information and methods of Knight type.
 */
public class KnightCharacter extends AbstractCommonCharacter {

  /**
   * Creates a new KnightCharacter.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   */
  public KnightCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue, @NotNull String name,
                         final int maxHp, final int defense) {
    super(turnsQueue, name, maxHp, defense,"src\\resources\\characters\\knight.png");
  }

  @Override
  public void equipWeapon(IWeapon weapon) {
    weapon.equipToKnight(this);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof KnightCharacter)) {
      return false;
    }
    final KnightCharacter character = (KnightCharacter) o;
    return this.getName().equals(character.getName()) && this.getDefense() == character.getDefense() &&
            this.getMaxHp() == character.getMaxHp();
  }
}
