package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacterTest;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Bow;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KnightCharacterTest extends AbstractCommonCharacterTest {

  public void setTestCharacter(){
    setEnemies();

    testCharacterA = new KnightCharacter(turnsQueue,"KnightA",100,100);
    testCharacterB = new KnightCharacter(turnsQueue,"KnightB",50,50);
    testCharacterC = new KnightCharacter(turnsQueue,"KnightC",0,0);
    testCharacterD = new KnightCharacter(turnsQueue,"KnightD",-10,-10);
    testPlayerCharacter = new KnightCharacter(turnsQueue,"KnightE",100,100);

    testClassWeaponA = new Sword("TestSwordAttack",100,100);
    testClassWeaponB = new Axe("TestAxeAttack",50,20);
    testClassWeaponC = new Knife("TestKnifeAttack",0,42);

    testTurnsCharacterA = new KnightCharacter(turnsQueue,"TestTurnsKnightA",100,100);
    ((KnightCharacter) testTurnsCharacterA).equip(testClassWeaponA);
    testTurnsCharacterB = new KnightCharacter(turnsQueue,"TestTurnsKnightB",100,100);
    ((KnightCharacter) testTurnsCharacterB).equip(testClassWeaponB);
  }


  public void testEquipWeapons() {
    testPlayerCharacter.equip(testWeaponBow);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponStaff);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponKnife);
    assertEquals(testWeaponKnife, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponAxe);
    assertEquals(testWeaponAxe, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponSword);
    assertEquals(testWeaponSword, testPlayerCharacter.getEquippedWeapon());
  }
}
