package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacterTest;
import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ThiefCharacterTest extends AbstractPlayerCharacterTest {


  public void setTestCharacter(){
    testCharacterA = new ThiefCharacter(turnsQueue,"ThiefA",100,100);
    testCharacterB = new ThiefCharacter(turnsQueue,"ThiefB",50,50);
    testCharacterC = new ThiefCharacter(turnsQueue,"ThiefC",0,0);
    testCharacterD = new ThiefCharacter(turnsQueue,"ThiefD",-10,-10);
  }

  public void setTestPlayerCharacter(){
    testCharacterE = new ThiefCharacter(turnsQueue,"ThiefE",100,100);
  }

  public void testEquipWeapons() {
    testCharacterE.equip(testWeaponKnife);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponAxe);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponSword);
    assertEquals(testWeaponSword,testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponBow);
    assertEquals(testWeaponBow,testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponStaff);
    assertEquals(testWeaponStaff,testCharacterE.getEquippedWeapon());
  }
}