package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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

  KnightCharacter testKnight;
  ThiefCharacter testThief;
  EngineerCharacter testEngineer;
  BlackMageCharacter testBlackMage;
  WhiteMageCharacter testWhiteMage;
  protected String imgFileName;

  /**
   * Sets weapons depending on the class, to test.
   */
  protected abstract void setWeapons();

  /**
   * SetUp, called before each test.
   */
  @BeforeEach
  public void setUp() {
    setWeapons();
    setCharacters();
  }

  public void setCharacters () {
    BlockingQueue<ICharacter> testTurnsQueue = new LinkedBlockingQueue<>();;
    testKnight = new KnightCharacter(testTurnsQueue,"TestKnight",1,1);
    testThief = new ThiefCharacter(testTurnsQueue,"TestThief",1,1);
    testEngineer = new EngineerCharacter(testTurnsQueue,"TestEngineer",1,1);
    testBlackMage = new BlackMageCharacter(testTurnsQueue,"TestBlackMage",1,1,1);
    testWhiteMage = new WhiteMageCharacter(testTurnsQueue,"TestWhiteMage",1,1,1);
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

  @Test
  public void imageFileNameGetter () {
    assertEquals(imgFileName, testWeaponA.getImage());
  }
}
