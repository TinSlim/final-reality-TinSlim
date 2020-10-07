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

  protected BlackMageCharacter testCharacterF;

  public void setTestCharacter(){
    testCharacterA = new BlackMageCharacter(turnsQueue,"BlackMageA",100,100,100);
    testCharacterB = new BlackMageCharacter(turnsQueue,"BlackMageB",50,50,50);
    testCharacterC = new BlackMageCharacter(turnsQueue,"BlackMageC",0,0,0);
    testCharacterD = new BlackMageCharacter(turnsQueue,"BlackMageD",-10,-10,-10);
    testPlayerCharacter = new BlackMageCharacter(turnsQueue,"BlackMageE",100,100,100);
    testCharacterF = new BlackMageCharacter(turnsQueue,"BlackMageF",100,100,100);

    testMageA = new BlackMageCharacter(turnsQueue,"BlackMageA",100,100,100);
    testMageB = new BlackMageCharacter(turnsQueue,"BlackMageB",100,100,40);
    testMageC = new BlackMageCharacter(turnsQueue,"BlackMageC",100,100,30);

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
    testCharacterF.setSeed(23);

    testCharacterF.equip(testWeaponStaffA);
    testCharacterF.fire(testEnemyA);
    assertEquals(0,testEnemyA.getBurnDamage());
    assertEquals(0,testEnemyA.getHp());

    testCharacterF.equip(testWeaponStaffB);
    testCharacterF.fire(testEnemyB);
    assertEquals(3,testEnemyB.getBurnDamage());
    assertEquals(60,testEnemyB.getHp());

    testCharacterF.equip(testWeaponStaffC);
    testCharacterF.fire(testEnemyC);
    assertEquals(0,testEnemyC.getBurnDamage());
    assertEquals(10,testEnemyC.getHp());

    testCharacterF.equip(testWeaponStaffA);
    testCharacterF.fire(testEnemyD);
    assertEquals(26,testEnemyD.getBurnDamage());
    assertEquals(0,testEnemyD.getHp());
  }

  @Test
  public void testThunder(){
    testCharacterF.setSeed(23);

    testCharacterF.equip(testWeaponStaffA);
    testCharacterF.thunder(testEnemyA);
    assertEquals(false,testEnemyA.getParalyze());
    assertEquals(0,testEnemyA.getHp());

    testCharacterF.equip(testWeaponStaffB);
    testCharacterF.thunder(testEnemyB);
    assertEquals(true,testEnemyB.getParalyze());
    assertEquals(60,testEnemyB.getHp());

    testCharacterF.equip(testWeaponStaffC);
    testCharacterF.thunder(testEnemyC);
    assertEquals(true,testEnemyC.getParalyze());
    assertEquals(10,testEnemyC.getHp());

    testCharacterF.equip(testWeaponStaffA);
    testCharacterF.thunder(testEnemyD);
    assertEquals(true,testEnemyD.getParalyze());
    assertEquals(0,testEnemyD.getHp());
  }

  @Test
  public void testCast(){
    testMageA.equip(testWeaponStaffA);
    testMageA.cast(90);
    assertEquals(10,testMageA.getMana());

    testMageB.equip(testWeaponStaffA);
    testMageB.cast(40);
    assertEquals(0,testMageB.getMana());

    testMageC.equip(testWeaponStaffA);
    testMageC.cast(38);
    assertEquals(30,testMageC.getMana());

    testMageC.equip(testWeaponKnife);
    testMageC.cast(0);
    assertEquals(30,testMageC.getMana());
  }
}
