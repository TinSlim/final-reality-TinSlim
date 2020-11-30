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

  protected ICharacter testConstructionCharacter;
  protected ICharacter testDiffCharacterSameClass;
  protected ICharacter testDiffCharacterDiffClass;
  protected ICharacter testSameCharacterSameClass;

  protected ICharacter testOnlyDiffName;
  protected ICharacter testOnlyDiffMaxHp;
  protected ICharacter testOnlyDiffDefense;
  protected ICharacter testOnlyDiffManaOrWeightOrOther;
  protected ICharacter testOnlyDiffDamageOrOther;

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
    assertEquals(testConstructionCharacter.hashCode(), testConstructionCharacter.hashCode());
    assertNotEquals(testConstructionCharacter.hashCode(), testDiffCharacterSameClass.hashCode());
    assertNotEquals(testConstructionCharacter.hashCode(), testDiffCharacterDiffClass.hashCode());
    assertEquals(testConstructionCharacter.hashCode(), testSameCharacterSameClass.hashCode());

    assertNotEquals(testConstructionCharacter.hashCode(), testOnlyDiffName.hashCode());
    assertNotEquals(testConstructionCharacter.hashCode(), testOnlyDiffMaxHp.hashCode());
    assertNotEquals(testConstructionCharacter.hashCode(), testOnlyDiffDefense.hashCode());
    assertNotEquals(testConstructionCharacter.hashCode(), testOnlyDiffManaOrWeightOrOther.hashCode());
    assertNotEquals(testConstructionCharacter.hashCode(), testOnlyDiffDamageOrOther.hashCode());
  }

  /**
   * Tests construction for characters.
   */
  @Test
  public void testConstruction() {
    this.setEqCharacter();
    assertEquals(testConstructionCharacter, testConstructionCharacter);
    assertNotEquals(testConstructionCharacter, testDiffCharacterSameClass);
    assertNotEquals(testConstructionCharacter, testDiffCharacterDiffClass);
    assertEquals(testConstructionCharacter, testSameCharacterSameClass);

    assertNotEquals(testConstructionCharacter, testOnlyDiffName);
    assertNotEquals(testConstructionCharacter, testOnlyDiffMaxHp);
    assertNotEquals(testConstructionCharacter, testOnlyDiffDefense);
    assertNotEquals(testConstructionCharacter, testOnlyDiffManaOrWeightOrOther);
    assertNotEquals(testConstructionCharacter, testOnlyDiffDamageOrOther);
  }
}
