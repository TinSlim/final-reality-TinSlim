package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacterTest;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WhiteMageCharacterTest extends AbstractMageCharacterTest {
  protected IPlayerCharacter testComradeA;
  protected IPlayerCharacter testComradeB;
  protected IPlayerCharacter testComradeC;
  protected IPlayerCharacter testComradeD;

  protected WhiteMageCharacter testWhiteMageA;
  protected WhiteMageCharacter testWhiteMageB;

  public void setTestCharacter(){
    setEnemies();

    testCharacterA = new WhiteMageCharacter(turnsQueue,"WhiteMageA",100,100,100);
    testCharacterB = new WhiteMageCharacter(turnsQueue,"WhiteMageB",50,50,50);
    testCharacterC = new WhiteMageCharacter(turnsQueue,"WhiteMageC",0,0,0);
    testCharacterD = new WhiteMageCharacter(turnsQueue,"WhiteMageD",-10,-10,-10);

    testPlayerCharacter = new WhiteMageCharacter(turnsQueue,"WhiteMageE",100,100,100);

    testWhiteMageA = new WhiteMageCharacter(turnsQueue,"WhiteMage",100,100,100);
    testWhiteMageB = new WhiteMageCharacter(turnsQueue,"WhiteMage",100,100,5);

    testMageA = new WhiteMageCharacter(turnsQueue,"WhiteMageA",100,100,100);
    testMageB = new WhiteMageCharacter(turnsQueue,"WhiteMageB",100,100,40);
    testMageC = new WhiteMageCharacter(turnsQueue,"WhiteMageC",100,100,30);

    testComradeA = new KnightCharacter(turnsQueue,"KnightComrade",99,100);
    testComradeB = new ThiefCharacter(turnsQueue,"ThiefComrade",99,50);
    testComradeC = new EngineerCharacter(turnsQueue,"EngineerComrade",99,50);
    testComradeD = new BlackMageCharacter(turnsQueue,"BlackMageComrade",100,50,10);

    testClassWeaponA = new Staff("TestStaffAttackA",100,42,42);
    testClassWeaponB = new Staff("TestStaffAttackB",50,42,42);
    testClassWeaponC = new Staff("TestStaffAttackC",0,42,42);

  }

  @Test
  public void testEquipWeapons() {
    testPlayerCharacter.equip(testWeaponSword);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponAxe);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponBow);
    assertNull(testPlayerCharacter.getEquippedWeapon());


    testPlayerCharacter.equip(testWeaponKnife);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponStaff);
    assertEquals(testWeaponStaff, testPlayerCharacter.getEquippedWeapon());
  }


  @Test
  public void testCure(){
    testWhiteMageA.equip(testWeaponStaff);
    testComradeA.setHp(33);
    testWhiteMageA.cure(testComradeA);
    assertEquals(62,testComradeA.getHp());

    testComradeB.setHp(66);
    testWhiteMageA.cure(testComradeB);
    assertEquals(95,testComradeB.getHp());

    testComradeC.setHp(95);
    testWhiteMageA.cure(testComradeC);
    assertEquals(99,testComradeC.getHp());

    testComradeD.setHp(1);
    testWhiteMageB.cure(testComradeD);
    assertEquals(1,testComradeD.getHp());
  }

  @Test
  public void testVenom(){
    testWhiteMageA.equip(testWeaponStaffA);
    testWhiteMageA.venom(testEnemyA);
    assertEquals(26,testEnemyA.getPoisonDamage());

    testWhiteMageA.equip(testWeaponStaffB);
    testWhiteMageA.venom(testEnemyB);
    assertEquals(3,testEnemyB.getPoisonDamage());

    testWhiteMageB.equip(testWeaponStaffB);
    testWhiteMageB.venom(testEnemyC);
    assertEquals(0,testEnemyC.getPoisonDamage());
  }

  @Test
  public void testParalyze(){
    testWhiteMageA.equip(testWeaponStaffA);
    testWhiteMageA.paralyze(testEnemyA);
    assertTrue(testEnemyA.getParalyze());

    testWhiteMageA.equip(testWeaponStaffB);
    testWhiteMageA.paralyze(testEnemyB);
    assertTrue(testEnemyB.getParalyze());

    testWhiteMageB.equip(testWeaponStaffB);
    testWhiteMageB.paralyze(testEnemyC);
    assertFalse(testEnemyC.getParalyze());
  }
}
