package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacterTest;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Bow;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlackMageCharacterTest extends AbstractMageCharacterTest {

  protected Enemy testEnemyD;

  protected BlackMageCharacter testBlackMageA;
  protected BlackMageCharacter testBlackMageB;

  protected BlackMageCharacter testEqualsA;
  protected ThiefCharacter testDifferentA;

  public void setTestCharacter(){
    setEnemies();

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

    testTurnsCharacterA = new BlackMageCharacter(turnsQueue,"BlackMageC",100,100,5);
    testTurnsCharacterB = new BlackMageCharacter(turnsQueue,"BlackMageC",100,100,5);

    testEnemyD = new Enemy(turnsQueue,"testEnemyC",10,100,100,40);

    testClassWeaponA = new Knife("TestKnifeAttack",100,100);
    testClassWeaponB = new Staff("TestStaffAttackA",50,42,20);
    testClassWeaponC = new Staff("TestStaffAttackB",0,42,42);

    testTurnsCharacterA = new BlackMageCharacter(turnsQueue,"TestTurnsMageA",100,100,5);
    ((BlackMageCharacter) testTurnsCharacterA).equip(testClassWeaponA);
    testTurnsCharacterB = new BlackMageCharacter(turnsQueue,"TestTurnsMageB",100,100,5);
    ((BlackMageCharacter) testTurnsCharacterB).equip(testClassWeaponB);

    testMaxManaMageA = new BlackMageCharacter(turnsQueue,"MaxManaA",100,100,100);
    testMaxManaMageB = new BlackMageCharacter(turnsQueue,"MaxManaB",100,100,15);
    testMaxManaMageC = new BlackMageCharacter(turnsQueue,"MaxManaC",100,100,0);

    testEqualsA = new BlackMageCharacter(turnsQueue,"BlackMageA",100,100,100);
    testDifferentA = new ThiefCharacter(turnsQueue,"BlackMageA",100,100);
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
    testBlackMageA.setSeed(8);
    testBlackMageB.setSeed(22);

    testBlackMageA.equip(testWeaponStaffA);
    testBlackMageA.fire(testEnemyA);
    assertEquals(40,testEnemyA.getBurnDamage());
    assertEquals(0,testEnemyA.getHp());

    testBlackMageA.equip(testWeaponStaffB);
    testBlackMageA.fire(testEnemyB);
    assertEquals(0,testEnemyB.getBurnDamage());
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
    testBlackMageA.setSeed(44213);
    testBlackMageB.setSeed(22);

    testBlackMageA.equip(testWeaponStaffA);
    testBlackMageA.thunder(testEnemyA);
    assertEquals(true,testEnemyA.getParalyze());
    assertEquals(0,testEnemyA.getHp());

    testBlackMageA.equip(testWeaponStaffB);
    testBlackMageA.thunder(testEnemyB);
    assertEquals(false,testEnemyB.getParalyze());
    assertEquals(60,testEnemyB.getHp());

    testBlackMageA.equip(testWeaponStaffC);
    testBlackMageA.thunder(testEnemyC);
    assertEquals(false,testEnemyC.getParalyze());
    assertEquals(10,testEnemyC.getHp());

    testBlackMageA.equip(testWeaponKnife);
    testBlackMageA.thunder(testEnemyC);
    assertEquals(false,testEnemyC.getParalyze());
    assertEquals(10,testEnemyC.getHp());

    testBlackMageB.equip(testWeaponStaffA);
    testBlackMageB.thunder(testEnemyD);
    assertEquals(false,testEnemyD.getParalyze());
    assertEquals(10,testEnemyD.getHp());
  }

  @Test
  public void testEquals(){
    assertEquals(testBlackMageA,testBlackMageA);
    assertNotEquals(testBlackMageA,testBlackMageB);
    assertNotEquals(testBlackMageA,new ThiefCharacter(turnsQueue,"BlackMageA",100,100));
    assertEquals(testBlackMageA,new BlackMageCharacter(turnsQueue,"testBlackMageA",100,100,60));

    assertNotEquals(testBlackMageA,new BlackMageCharacter(turnsQueue,"DiffName",100,100,60));
    assertNotEquals(testBlackMageA,new BlackMageCharacter(turnsQueue,"testBlackMageA",1,100,60));
    assertNotEquals(testBlackMageA,new BlackMageCharacter(turnsQueue,"testBlackMageA",100,1,60));
    assertNotEquals(testBlackMageA,new BlackMageCharacter(turnsQueue,"testBlackMageA",100,100,1));

  }
}
