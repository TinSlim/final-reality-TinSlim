package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacterTest;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackMageCharacterTest extends AbstractMageCharacterTest {
  protected Enemy testEnemyA;
  protected Enemy testEnemyB;
  protected Enemy testEnemyC;
  protected Enemy testEnemyD;

  protected BlackMageCharacter testBlackMageA;
  protected BlackMageCharacter testBlackMageB;

  public void setTestCharacter(){
    testCharacterA = new BlackMageCharacter(turnsQueue,"BlackMageA",100,100,100);
    testCharacterB = new BlackMageCharacter(turnsQueue,"BlackMageB",50,50,50);
    testCharacterC = new BlackMageCharacter(turnsQueue,"BlackMageC",0,0,0);
    testCharacterD = new BlackMageCharacter(turnsQueue,"BlackMageD",-10,-10,-10);
    testPlayerCharacter = new BlackMageCharacter(turnsQueue,"BlackMageE",100,100,100);

    testBlackMageA = new BlackMageCharacter(turnsQueue,"testBlackMageA",100,100,60);
    testBlackMageB = new BlackMageCharacter(turnsQueue,"testBlackMageB",100,100,14);

    testMageA = new BlackMageCharacter(turnsQueue,"BlackMageA",100,100,100);
    testMageB = new BlackMageCharacter(turnsQueue,"BlackMageB",100,100,15);
    testMageC = new BlackMageCharacter(turnsQueue,"BlackMageC",100,100,5);

    testEnemyA = new Enemy(turnsQueue,"testEnemyA",80,100,100);
    testEnemyB = new Enemy(turnsQueue,"testEnemyB",70,100,100);
    testEnemyC = new Enemy(turnsQueue,"testEnemyC",10,100,100);
    testEnemyD = new Enemy(turnsQueue,"testEnemyC",10,100,100);

  }

  public void testEquipWeapons() {
    testPlayerCharacter.equip(testWeaponSword);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponAxe);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponBow);
    assertNull(testPlayerCharacter.getEquippedWeapon());


    testPlayerCharacter.equip(testWeaponKnife);
    assertEquals(testWeaponKnife, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponStaff);
    assertEquals(testWeaponStaff, testPlayerCharacter.getEquippedWeapon());
  }

  @Test
  public void testFire(){
    testBlackMageA.setSeed(23);
    testBlackMageB.setSeed(22);

    testBlackMageA.equip(testWeaponStaffA);
    testBlackMageA.fire(testEnemyA);
    assertEquals(0,testEnemyA.getBurnDamage());
    assertEquals(0,testEnemyA.getHp());

    testBlackMageA.equip(testWeaponStaffB);
    testBlackMageA.fire(testEnemyB);
    assertEquals(3,testEnemyB.getBurnDamage());
    assertEquals(60,testEnemyB.getHp());

    testBlackMageA.equip(testWeaponStaffC);
    testBlackMageA.fire(testEnemyC);
    assertEquals(0,testEnemyC.getBurnDamage());
    assertEquals(10,testEnemyC.getHp());

    testBlackMageA.equip(testWeaponKnife);
    testBlackMageA.fire(testEnemyC);
    assertEquals(0,testEnemyC.getBurnDamage());
    assertEquals(10,testEnemyC.getHp());

    testBlackMageB.equip(testWeaponStaffA);
    testBlackMageB.fire(testEnemyD);
    assertEquals(0,testEnemyD.getBurnDamage());
    assertEquals(10,testEnemyD.getHp());
  }

  @Test
  public void testThunder(){
    testBlackMageA.setSeed(23);
    testBlackMageB.setSeed(22);

    testBlackMageA.equip(testWeaponStaffA);
    testBlackMageA.thunder(testEnemyA);
    assertEquals(false,testEnemyA.getParalyze());
    assertEquals(0,testEnemyA.getHp());

    testBlackMageA.equip(testWeaponStaffB);
    testBlackMageA.thunder(testEnemyB);
    assertEquals(true,testEnemyB.getParalyze());
    assertEquals(60,testEnemyB.getHp());

    testBlackMageA.equip(testWeaponStaffC);
    testBlackMageA.thunder(testEnemyC);
    assertEquals(true,testEnemyC.getParalyze());
    assertEquals(10,testEnemyC.getHp());

    testBlackMageB.equip(testWeaponStaffA);
    testBlackMageB.thunder(testEnemyD);
    assertEquals(false,testEnemyD.getParalyze());
    assertEquals(10,testEnemyD.getHp());
  }

}
