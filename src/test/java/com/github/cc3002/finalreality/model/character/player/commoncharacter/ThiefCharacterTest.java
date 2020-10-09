package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;
import com.github.cc3002.finalreality.model.weapon.Bow;
import com.github.cc3002.finalreality.model.weapon.Sword;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ThiefCharacterTest extends AbstractPlayerCharacterTest {


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
}