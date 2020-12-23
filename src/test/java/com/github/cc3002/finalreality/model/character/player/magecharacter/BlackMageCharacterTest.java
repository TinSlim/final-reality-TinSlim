package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class with BlackMageCharacterTest, contains set ups for weapons and characters
 * and tests for magic attacks methods (fire and thunder)
 */
public class BlackMageCharacterTest extends AbstractMageCharacterTest {

  protected Enemy testEnemyD;

  protected BlackMageCharacter testBlackMageA;
  protected BlackMageCharacter testBlackMageB;


  public void setTestCharacter() {
    setEnemies();

    testCharacterA = new BlackMageCharacter(turnsQueue,"BlackMageA",100,0,100);
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

    testEnemyD = new Enemy(turnsQueue,"testEffectsC",10,100,100,40);

    testAttackWeaponA = new Knife("TestKnifeAttack",100,100);
    testAttackWeaponB = new Staff("TestStaffAttackA",50,42,20);
    testAttackWeaponC = new Staff("TestStaffAttackB",0,42,42);

    testEquipableWeaponA = testWeaponStaff;
    testEquipableWeaponB = testWeaponStaff;
    testEquipableWeaponC = testWeaponKnife;

    testNoEquipableWeaponA = testWeaponSword;
    testNoEquipableWeaponB = testWeaponAxe;
    testNoEquipableWeaponC = testWeaponBow;
    testNoEquipableWeaponD = testWeaponBow;

    testTurnsCharacterA = new BlackMageCharacter(turnsQueue,"TestTurnsMageA",100,100,5);
    ((BlackMageCharacter) testTurnsCharacterA).equip(testAttackWeaponA);
    testTurnsCharacterB = new BlackMageCharacter(turnsQueue,"TestTurnsMageB",100,100,5);
    ((BlackMageCharacter) testTurnsCharacterB).equip(testAttackWeaponB);

    testMaxManaMageA = new BlackMageCharacter(turnsQueue,"MaxManaA",100,100,100);
    testMaxManaMageB = new BlackMageCharacter(turnsQueue,"MaxManaB",100,100,15);
    testMaxManaMageC = new BlackMageCharacter(turnsQueue,"MaxManaC",100,100,0);

    imgFileName = "src\\resources\\characters\\blackMage.png";
  }

  @Test
  public void testFire() {
    testBlackMageA.setSeed(8);
    testBlackMageB.setSeed(22);

    testBlackMageA.equip(testWeaponStaffA);
    testBlackMageA.fire(testEnemyA);
    assertEquals(15,testEnemyA.getBurnDamage());
    assertEquals(50,testEnemyA.getHp());

    testBlackMageA.equip(testWeaponStaffB);
    testBlackMageA.fire(testEnemyB);
    assertEquals(0,testEnemyB.getBurnDamage());
    assertEquals(70,testEnemyB.getHp());

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
  /*
  Set ups enemies to test common attacks.
   */
  public void testThunder() {
    testBlackMageA.setSeed(44213);
    testBlackMageB.setSeed(22);

    testBlackMageA.equip(testWeaponStaffA);
    testBlackMageA.thunder(testEnemyA);
    assertTrue(testEnemyA.getParalyze());
    assertEquals(50,testEnemyA.getHp());

    testBlackMageA.equip(testWeaponStaffB);
    testBlackMageA.thunder(testEnemyB);
    assertFalse(testEnemyB.getParalyze());
    assertEquals(70,testEnemyB.getHp());

    testBlackMageA.equip(testWeaponStaffC);
    testBlackMageA.thunder(testEnemyC);
    assertFalse(testEnemyC.getParalyze());
    assertEquals(10,testEnemyC.getHp());

    testBlackMageA.equip(testWeaponKnife);
    testBlackMageA.thunder(testEnemyC);
    assertFalse(testEnemyC.getParalyze());
    assertEquals(10,testEnemyC.getHp());

    testBlackMageB.equip(testWeaponStaffA);
    testBlackMageB.thunder(testEnemyD);
    assertFalse(testEnemyD.getParalyze());
    assertEquals(10,testEnemyD.getHp());
  }

  public void setEqCharacter() {
    testConstructionCharacter = new BlackMageCharacter(turnsQueue,"testBlackMageA",100,100,60);
    testDiffCharacterSameClass = new BlackMageCharacter(turnsQueue,"testBlackMageB",100,100,14);
    testDiffCharacterDiffClass = new ThiefCharacter(turnsQueue,"BlackMageA",100,100);
    testSameCharacterSameClass = new BlackMageCharacter(turnsQueue,"testBlackMageA",100,100,60);

    testOnlyDiffName = new BlackMageCharacter(turnsQueue,"DiffName",100,100,60);
    testOnlyDiffMaxHp = new BlackMageCharacter(turnsQueue,"testBlackMageA",1,100,60);
    testOnlyDiffDefense = new BlackMageCharacter(turnsQueue,"testBlackMageA",100,1,60);
    testOnlyDiffManaOrWeightOrOther = new BlackMageCharacter(turnsQueue,"testBlackMageA",100,100,1);
    testOnlyDiffDamageOrOther = new BlackMageCharacter(turnsQueue,"test",1,1,1);
  }
}
