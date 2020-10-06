package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacterTest;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteMageCharacterTest extends AbstractMageCharacterTest {

  public void setTestCharacter(){
    testCharacterA = new WhiteMageCharacter(turnsQueue,"WhiteMageA",100,100,100);
    testCharacterB = new WhiteMageCharacter(turnsQueue,"WhiteMageB",50,50,50);
    testCharacterC = new WhiteMageCharacter(turnsQueue,"WhiteMageC",0,0,0);
    testCharacterD = new WhiteMageCharacter(turnsQueue,"WhiteMageD",-10,-10,-10);
    testCharacterE = new WhiteMageCharacter(turnsQueue,"WhiteMageE",100,100,100);
  }

  public void testEquipWeapons() {
    testCharacterE.equip(testWeaponSword);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponAxe);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponBow);
    assertNull(testCharacterE.getEquippedWeapon());


    testCharacterE.equip(testWeaponKnife);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponStaff);
    assertEquals(testWeaponStaff,testCharacterE.getEquippedWeapon());
  }
}
