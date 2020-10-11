package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Bow;

import static org.junit.jupiter.api.Assertions.*;

public class EngineerCharacterTest extends AbstractPlayerCharacterTest {

  public void setTestCharacter(){
    setEnemies();

    testCharacterA = new EngineerCharacter(turnsQueue,"EngineerA",100,100);
    testCharacterB = new EngineerCharacter(turnsQueue,"EngineerB",50,50);
    testCharacterC = new EngineerCharacter(turnsQueue,"EngineerC",0,0);
    testCharacterD = new EngineerCharacter(turnsQueue,"EngineerD",-10,-10);
    testPlayerCharacter = new EngineerCharacter(turnsQueue,"EngineerE",100,100);

    testClassWeaponA = new Bow("TestBowAttack",100,100);
    testClassWeaponB = new Axe("TestAxeAttackA",50,20);
    testClassWeaponC = new Axe("TestAxeAttackB",0,42);

    testTurnsCharacterA = new EngineerCharacter(turnsQueue,"TestTurnsEngineerA",100,100);
    ((EngineerCharacter) testTurnsCharacterA).equip(testClassWeaponA);
    testTurnsCharacterB = new EngineerCharacter(turnsQueue,"TestTurnsEngineerB",100,100);
    ((EngineerCharacter) testTurnsCharacterB).equip(testClassWeaponB);
  }

  public void testEquipWeapons() {
    testPlayerCharacter.equip(testWeaponKnife);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponStaff);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponSword);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponAxe);
    assertEquals(testWeaponAxe, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponBow);
    assertEquals(testWeaponBow, testPlayerCharacter.getEquippedWeapon());
  }

  public void setEqCharacter() {
    testEqCharacterA = new EngineerCharacter(turnsQueue,"testEngineerA",100,100);
    testEqCharacterB = new EngineerCharacter(turnsQueue,"testEngineerB",100,1);
    testEqCharacterC = new ThiefCharacter(turnsQueue, "BlackMageA", 100, 100);
    testEqCharacterD = new EngineerCharacter(turnsQueue, "testEngineerA", 100, 100);

    testEqCharacterF1 = new EngineerCharacter(turnsQueue, "DiffName", 100, 100);
    testEqCharacterF2 = new EngineerCharacter(turnsQueue, "testEngineerA", 1, 100);
    testEqCharacterF3 = new EngineerCharacter(turnsQueue, "testEngineerA", 100, 1);
    testEqCharacterF4 = new EngineerCharacter(turnsQueue, "test", 5, 1);
    testEqCharacterF5 = new EngineerCharacter(turnsQueue, "test", 5, 1);
  }
}
