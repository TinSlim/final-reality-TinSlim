package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacterTest;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackMageCharacterTest extends AbstractMageCharacterTest {

  protected IWeapon testWeaponStaffA = new Staff("TestStaff",0,80,90);
  protected IWeapon testWeaponStaffB = new Staff("TestStaff",0,10,90);
  protected IWeapon testWeaponStaffC = new Staff("TestStaff",0,0,90);

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
    testCharacterE = new BlackMageCharacter(turnsQueue,"BlackMageE",100,100,100);
    testCharacterF = new BlackMageCharacter(turnsQueue,"BlackMageF",100,100,100);

    testEnemyA = new Enemy(turnsQueue,"testEnemyA",80,100,100);
    testEnemyB = new Enemy(turnsQueue,"testEnemyB",70,100,100);
    testEnemyC = new Enemy(turnsQueue,"testEnemyC",10,100,100);
    testEnemyD = new Enemy(turnsQueue,"testEnemyC",10,100,100);

  }

  public void testEquipWeapons() {
    testCharacterE.equip(testWeaponSword);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponAxe);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponBow);
    assertNull(testCharacterE.getEquippedWeapon());


    testCharacterE.equip(testWeaponKnife);
    assertEquals(testWeaponKnife,testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponStaff);
    assertEquals(testWeaponStaff,testCharacterE.getEquippedWeapon());
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
}
