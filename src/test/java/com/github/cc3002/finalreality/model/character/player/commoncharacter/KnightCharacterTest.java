package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacterTest;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KnightCharacterTest extends AbstractCommonCharacterTest {

  public void setTestCharacter(){
    testCharacterA = new KnightCharacter(turnsQueue,"KnightA",100,100);
    testCharacterB = new KnightCharacter(turnsQueue,"KnightB",50,50);
    testCharacterC = new KnightCharacter(turnsQueue,"KnightC",0,0);
    testCharacterD = new KnightCharacter(turnsQueue,"KnightD",-10,-10);
  }


  @Test
  public void testEquipWeapons() {
    testCharacterA.equip(testWeaponBow);
    assertNull(testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponStaff);
    assertNull(testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponAxe);
    assertEquals(testWeaponAxe,testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponSword);
    assertEquals(testWeaponSword,testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponKnife);
    assertEquals(testWeaponKnife,testCharacterA.getEquippedWeapon());
  }
}
