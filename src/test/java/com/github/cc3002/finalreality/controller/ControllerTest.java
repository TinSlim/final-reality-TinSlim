package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.inventory.Inventory;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {
  Controller testControler;

  @BeforeEach
  public void setUp () {
    testControler = new Controller();
  }

  @Test
  public void testWeaponMaker () {
    testControler.makeAxe("TestAxe");
    KnightCharacter testKnight1 = new KnightCharacter(testControler.getQueue(),"TestKnight1",1,1);
    testControler.makeSword("TestSword");
    KnightCharacter testKnight2 = new KnightCharacter(testControler.getQueue(),"TestKnight2",1,1);
    testControler.makeStaff("TestStaff");
    BlackMageCharacter testMage = new BlackMageCharacter(testControler.getQueue(),"TestMage1",1,1,1);
    testControler.makeKnife("TestKnife");
    KnightCharacter testKnight3 = new KnightCharacter(testControler.getQueue(),"TestKnight3",1,1);
    testControler.makeBow("TestBow");
    ThiefCharacter testThief = new ThiefCharacter(testControler.getQueue(),"TestThief",1,1);

    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testKnight1);
    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testKnight2);
    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testMage);
    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testKnight3);
    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testThief);
  }

  @Test
  public void inventoryMovement () {
    for (int i = 0; i < 15; i++) {
      String number = String.valueOf(i);
      testControler.makeSword("TestSword"+number);
    }
    KnightCharacter testKnight1 = new KnightCharacter(testControler.getQueue(),
            "TestKnight1",1,1);

    testControler.rightMoveInventory();
    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword1",50,60) ,testKnight1.getEquippedWeapon());

    testControler.upMoveInventory();
    testControler.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword6",50,60) ,testKnight1.getEquippedWeapon());

    testControler.downMoveInventory();
    testControler.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword1",50,60) ,testKnight1.getEquippedWeapon());

    testControler.leftMoveInventory();
    testControler.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword0",50,60) ,testKnight1.getEquippedWeapon());


  }
}
