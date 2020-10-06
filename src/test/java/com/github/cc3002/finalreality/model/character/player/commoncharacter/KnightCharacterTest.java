package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacterTest;
import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KnightCharacterTest extends AbstractCommonCharacterTest {

  public void setTestCharacter(){
    testCharacterA = new KnightCharacter(turnsQueue,"KnightA",100,100);
    testCharacterB = new KnightCharacter(turnsQueue,"KnightB",50,50);
    testCharacterC = new KnightCharacter(turnsQueue,"KnightC",0,0);
    testCharacterD = new KnightCharacter(turnsQueue,"KnightD",-10,-10);
    testCharacterE = new KnightCharacter(turnsQueue,"KnightE",100,100);
  }


  public void testEquipWeapons() {
    testCharacterE.equip(testWeaponBow);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponStaff);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponKnife);
    assertEquals(testWeaponKnife,testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponAxe);
    assertEquals(testWeaponAxe,testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponSword);
    assertEquals(testWeaponSword,testCharacterE.getEquippedWeapon());
  }
}
