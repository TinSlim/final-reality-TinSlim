package com.github.cc3002.finalreality.model.character;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see ICharacter
 */
public abstract class AbstractCharacterTest implements ICharacterTest{
  ICharacter testCharacterA;
  ICharacter testCharacterB;
  ICharacter testCharacterC;
  ICharacter testCharacterD;
  int h;

  @BeforeEach
  void setUp() {
    testCharacterA.setMaxHp(100);
    testCharacterB.setMaxHp(40);
    testCharacterC.setMaxHp(0);
    testCharacterD.setMaxHp(-10);
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  public void testReceiveDamage() {
    testCharacterA.receiveDamage(40);
    assertEquals(testCharacterA.getHp(),60);
  }
}
