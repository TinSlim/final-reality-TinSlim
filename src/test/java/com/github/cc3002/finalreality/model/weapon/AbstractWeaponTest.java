package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains common tests for weapons.
 */
public abstract class AbstractWeaponTest {

  IWeapon testWeaponA;
  IWeapon testWeaponB;
  IWeapon testWeaponC;
  IWeapon testWeaponD;

  IWeapon testWeaponF1;
  IWeapon testWeaponF2;
  IWeapon testWeaponF3;
  IWeapon testWeaponF4;

  /**
   * Sets weapons depending on the class, to test.
   */
  protected abstract void setWeapons();

  /**
   * SetUp, called before each test.
   */
  @BeforeEach
  public void setUp() {
    this.setWeapons();
  }

  /**
   * Test Construction for weapons classes.
   */
  @Test
  public void testConstruction() {
    assertEquals(testWeaponA,testWeaponA);
    assertNotEquals(testWeaponA,testWeaponB);
    assertNotEquals(testWeaponA,testWeaponC);
    assertEquals(testWeaponA,testWeaponD);

    assertNotEquals(testWeaponA,testWeaponF1);
    assertNotEquals(testWeaponA,testWeaponF2);
    assertNotEquals(testWeaponA,testWeaponF3);
    assertNotEquals(testWeaponA,testWeaponF4);
  }

  /**
   * Tests hash for weapons classes.
   */
  @Test
  public void testHash() {
    assertEquals(testWeaponA.hashCode(),testWeaponA.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponB.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponC.hashCode());
    assertEquals(testWeaponA.hashCode(),testWeaponD.hashCode());

    assertNotEquals(testWeaponA.hashCode(),testWeaponF1.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponF2.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponF3.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponF4.hashCode());
  }

  @Test
  public void testGetMagicDamage () {
    boolean shouldPassMagicDamage = false;
    try {
      testWeaponA.getMagicDamage();
    } catch (AssertionError e) {
      shouldPassMagicDamage = true;
    }
    assertTrue(shouldPassMagicDamage);
  }

  @Test
  public void testCastMagic () {
    assertFalse(testWeaponA.castMagic());
  }
}
