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


  /**
   * Checks that the class' constructor and equals method works properly.
   */
  abstract void setTestCharacter();

  @BeforeEach
  public void setUp(){
    setTestCharacter();
  }



  @Test
  public void testReceiveDamage() {
    testCharacterA.receiveDamage(40);
    assertEquals(60,testCharacterA.getHp());

    testCharacterB.receiveDamage(100);
    assertEquals(0,testCharacterB.getHp());

    testCharacterC.receiveDamage(50);
    assertEquals(0,testCharacterC.getHp());

    testCharacterD.receiveDamage(20);
    assertEquals(0,testCharacterD.getHp());
  }
}
