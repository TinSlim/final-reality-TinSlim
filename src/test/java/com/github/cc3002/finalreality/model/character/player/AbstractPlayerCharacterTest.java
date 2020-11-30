package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Abstract class containing the PlayerCharacter tests for all the types of playable
 * characters.
 */
public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {

  protected IPlayerCharacter testPlayerCharacter;

  protected IWeapon testWeaponSword = new Sword("TestSword",80,42);
  protected IWeapon testWeaponKnife = new Knife("TestKnife",20,5);
  protected IWeapon testWeaponStaff = new Staff("TestStaff",10,100,90);
  protected IWeapon testWeaponBow = new Bow("TestBow",50,30);
  protected IWeapon testWeaponAxe = new Axe("TestAxe",100,50);

  protected IWeapon testAttackWeaponA;
  protected IWeapon testAttackWeaponB;
  protected IWeapon testAttackWeaponC;

  protected IWeapon testEquipableWeaponA;
  protected IWeapon testEquipableWeaponB;
  protected IWeapon testEquipableWeaponC;
  protected IWeapon testNoEquipableWeaponA;
  protected IWeapon testNoEquipableWeaponB;
  protected IWeapon testNoEquipableWeaponC;
  protected IWeapon testNoEquipableWeaponD;


  protected Enemy testEnemyA;
  protected Enemy testEnemyB;
  protected Enemy testEnemyC;


  /**
   * Set up for testEffectsA, testEffectsB and testEffectsC.
   */
  public void setEnemies() {
    testEnemyA = new Enemy(turnsQueue,"testEffectsA",80,100,0,10);
    testEnemyB = new Enemy(turnsQueue,"testEffectsB",70,100,20,20);
    testEnemyC = new Enemy(turnsQueue,"testEffectsC",10,100,100,30);
  }

  /**
   * Tests weapon equipment.
   */
  @Test
  public void testEquipWeaponsToPlayer() {
    testPlayerCharacter.equip(testNoEquipableWeaponA);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testNoEquipableWeaponB);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testNoEquipableWeaponC);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testNoEquipableWeaponD);
    assertNull(testPlayerCharacter.getEquippedWeapon());


    testPlayerCharacter.equip(testEquipableWeaponA);
    assertEquals(testEquipableWeaponA, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testEquipableWeaponB);
    assertEquals(testEquipableWeaponB, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testEquipableWeaponC);
    assertEquals(testEquipableWeaponC, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.receiveDamage(10000);
    testPlayerCharacter.equip(testEquipableWeaponA);
    assertEquals(testEquipableWeaponC, testPlayerCharacter.getEquippedWeapon());
  }

  /**
   * Tests the common attack.
   */
  @Test
  public void testCommonAttack() {
    testPlayerCharacter.equip(testAttackWeaponA);
    testPlayerCharacter.commonAttack(testEnemyA);
    assertEquals(0,testEnemyA.getHp());
    assertFalse(testEnemyA.isAlive());

    testPlayerCharacter.equip(testAttackWeaponB);
    testPlayerCharacter.commonAttack(testEnemyB);
    assertEquals(40,testEnemyB.getHp());
    assertTrue(testEnemyB.isAlive());

    testPlayerCharacter.equip(testAttackWeaponC);
    testPlayerCharacter.commonAttack(testEnemyC);
    assertEquals(10,testEnemyC.getHp());
    assertTrue(testEnemyC.isAlive());

    testPlayerCharacter.commonAttack(testEnemyA);
    assertEquals(0,testEnemyA.getHp());
    assertFalse(testEnemyA.isAlive());

    testPlayerCharacter.commonAttack(testEnemyA);
    assertEquals(0,testEnemyA.getHp());
    assertFalse(testEnemyA.isAlive());
  }
}
