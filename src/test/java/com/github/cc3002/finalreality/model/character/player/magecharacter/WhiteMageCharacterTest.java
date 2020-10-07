package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacterTest;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteMageCharacterTest extends AbstractMageCharacterTest {
  protected IPlayerCharacter testComradeA;
  protected IPlayerCharacter testComradeB;
  protected IPlayerCharacter testComradeC;

  protected Enemy testEnemyA;
  protected Enemy testEnemyB;

  protected WhiteMageCharacter testWhiteMage;

  public void setTestCharacter(){
    testCharacterA = new WhiteMageCharacter(turnsQueue,"WhiteMageA",100,100,100);
    testCharacterB = new WhiteMageCharacter(turnsQueue,"WhiteMageB",50,50,50);
    testCharacterC = new WhiteMageCharacter(turnsQueue,"WhiteMageC",0,0,0);
    testCharacterD = new WhiteMageCharacter(turnsQueue,"WhiteMageD",-10,-10,-10);

    testPlayerCharacter = new WhiteMageCharacter(turnsQueue,"WhiteMageE",100,100,100);

    testWhiteMage = new WhiteMageCharacter(turnsQueue,"WhiteMage",100,100,100);

    testMageA = new WhiteMageCharacter(turnsQueue,"WhiteMageA",100,100,100);
    testMageB = new WhiteMageCharacter(turnsQueue,"WhiteMageB",100,100,40);
    testMageC = new WhiteMageCharacter(turnsQueue,"WhiteMageC",100,100,30);

    testComradeA = new KnightCharacter(turnsQueue,"KnightComrade",99,100);
    testComradeB = new ThiefCharacter(turnsQueue,"ThiefComrade",99,50);
    testComradeC = new EngineerCharacter(turnsQueue,"EngineerComrade",99,50);
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
  }

  @Test
  public void testCure(){
    testWhiteMage.equip(testWeaponStaff);
    testComradeA.setHp(33);
    testWhiteMage.cure(testComradeA);
    assertEquals(66,testComradeA.getHp());

    testComradeB.setHp(66);
    testWhiteMage.cure(testComradeB);
    assertEquals(99,testComradeB.getHp());

    testComradeC.setHp(95);
    testWhiteMage.cure(testComradeC);
    assertEquals(99,testComradeC.getHp());
  }

  @Test
  public
}
