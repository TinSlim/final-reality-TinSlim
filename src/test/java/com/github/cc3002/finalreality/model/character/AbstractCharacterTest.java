package com.github.cc3002.finalreality.model.character;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Cristóbal Torres Gutiérrez.
 * @see ICharacter
 */
public abstract class AbstractCharacterTest {

  protected BlockingQueue<ICharacter> turnsQueue;

  protected ICharacter testCharacterA;
  protected ICharacter testCharacterB;
  protected ICharacter testCharacterC;
  protected ICharacter testCharacterD;


  protected ICharacter testTurnsCharacterA;
  protected ICharacter testTurnsCharacterB;


  protected ICharacter testEqCharacterA;
  protected ICharacter testEqCharacterB;
  protected ICharacter testEqCharacterC;
  protected ICharacter testEqCharacterD;

  protected ICharacter testEqCharacterF1;
  protected ICharacter testEqCharacterF2;
  protected ICharacter testEqCharacterF3;
  protected ICharacter testEqCharacterF4;
  protected ICharacter testEqCharacterF5;

  protected abstract void setTestCharacter();

  /**
   * Set up for construction and hash test.
   */
  protected abstract void setEqCharacter();

  /**
   * Set ups characters for tests.
   */
  @BeforeEach
  public void setUp() {
    turnsQueue = new LinkedBlockingQueue<>();
    setTestCharacter();
  }

  /**
   * Tests turns and queue for characters.
   * @throws InterruptedException to use Thread
   */
  @Test
  public void testQueueTurns() throws InterruptedException {
    testTurnsCharacterA.waitTurn();
    testTurnsCharacterB.waitTurn();
    assertEquals(0, turnsQueue.size());
    Thread.sleep(10500);
    assertEquals(2, turnsQueue.size());
    assertEquals(testTurnsCharacterB, turnsQueue.poll());
    assertEquals(testTurnsCharacterA, turnsQueue.poll());
  }

  /**
   * Tests reciveDamage method for characters.
   */
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

  /**
   * Tests hash method for characters.
   */
  @Test
  public void testHash() {
    setEqCharacter();
    assertEquals(testEqCharacterA.hashCode(), testEqCharacterA.hashCode());
    assertNotEquals(testEqCharacterA.hashCode(), testEqCharacterB.hashCode());
    assertNotEquals(testEqCharacterA.hashCode(), testEqCharacterC.hashCode());
    assertEquals(testEqCharacterA.hashCode(), testEqCharacterD.hashCode());

    assertNotEquals(testEqCharacterA.hashCode(), testEqCharacterF1.hashCode());
    assertNotEquals(testEqCharacterA.hashCode(), testEqCharacterF2.hashCode());
    assertNotEquals(testEqCharacterA.hashCode(), testEqCharacterF3.hashCode());
    assertNotEquals(testEqCharacterA.hashCode(), testEqCharacterF4.hashCode());
    assertNotEquals(testEqCharacterA.hashCode(), testEqCharacterF5.hashCode());
  }

  /**
   * Tests construction for characters.
   */
  @Test
  public void testConstruction() {
    this.setEqCharacter();
    assertEquals(testEqCharacterA, testEqCharacterA);
    assertNotEquals(testEqCharacterA, testEqCharacterB);
    assertNotEquals(testEqCharacterA, testEqCharacterC);
    assertEquals(testEqCharacterA, testEqCharacterD);

    assertNotEquals(testEqCharacterA, testEqCharacterF1);
    assertNotEquals(testEqCharacterA, testEqCharacterF2);
    assertNotEquals(testEqCharacterA, testEqCharacterF3);
    assertNotEquals(testEqCharacterA, testEqCharacterF4);
    assertNotEquals(testEqCharacterA, testEqCharacterF5);
  }
}
