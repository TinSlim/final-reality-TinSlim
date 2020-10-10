package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.cc3002.finalreality.model.weapon.Bow;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThiefCharacterTest extends AbstractPlayerCharacterTest {

  protected ThiefCharacter testThiefA;
  protected ThiefCharacter testThiefB;


  public void setTestCharacter(){
    setEnemies();

    testCharacterA = new ThiefCharacter(turnsQueue,"ThiefA",100,100);
    testCharacterB = new ThiefCharacter(turnsQueue,"ThiefB",50,50);
    testCharacterC = new ThiefCharacter(turnsQueue,"ThiefC",0,0);
    testCharacterD = new ThiefCharacter(turnsQueue,"ThiefD",-10,-10);

    testPlayerCharacter = new ThiefCharacter(turnsQueue,"ThiefE",100,100);

    testClassWeaponA = new Sword("TestSwordAttack",100,100);
    testClassWeaponB = new Bow("TestBowAttack",50,20);
    testClassWeaponC = new Bow("TestBowAttack",0,42);

    testThiefA = new ThiefCharacter(turnsQueue,"testThiefA",100,100);
    testThiefB = new ThiefCharacter(turnsQueue,"testThiefB",1,1);

    testTurnsCharacterA = new ThiefCharacter(turnsQueue,"TestTurnsThiefA",100,100);
    ((ThiefCharacter) testTurnsCharacterA).equip(testClassWeaponA);
    testTurnsCharacterB = new ThiefCharacter(turnsQueue,"TestTurnsThiefB",100,100);
    ((ThiefCharacter) testTurnsCharacterB).equip(testClassWeaponB);
  }


  public void testEquipWeapons() {
    testPlayerCharacter.equip(testWeaponKnife);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponAxe);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponSword);
    assertEquals(testWeaponSword, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponBow);
    assertEquals(testWeaponBow, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponStaff);
    assertEquals(testWeaponStaff, testPlayerCharacter.getEquippedWeapon());
  }

  @Test
  public void testEquals() {
    assertEquals(testThiefA, testThiefA);
    assertNotEquals(testThiefA, testThiefB);
    assertNotEquals(testThiefA, new EngineerCharacter(turnsQueue, "EngineerA", 100, 100));
    assertEquals(testThiefA, new ThiefCharacter(turnsQueue,"testThiefA",100,100));

    assertNotEquals(testThiefA, new ThiefCharacter(turnsQueue, "DiffName", 100, 100));
    assertNotEquals(testThiefA, new ThiefCharacter(turnsQueue, "testThiefA", 1, 100));
    assertNotEquals(testThiefA, new ThiefCharacter(turnsQueue, "testThiefA", 100, 1));
  }

  public void hashSetUp(){
    testHashA = new ThiefCharacter(turnsQueue,"testThiefA",100,100);
    testHashB = new ThiefCharacter(turnsQueue,"testThiefA",100,100);
    testHashC = new KnightCharacter(turnsQueue,"testThiefA",100,100);
  }
}