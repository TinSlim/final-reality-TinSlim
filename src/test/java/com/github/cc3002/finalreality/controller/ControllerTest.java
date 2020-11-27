package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.IMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;
import com.github.cc3002.finalreality.model.inventory.Inventory;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
  Controller testControler;

  @BeforeEach
  public void setUp () {
    testControler = new Controller();
  }


  @Test
  public void testInventoryMovement () {
    for (int i = 0; i < 15; i++) {
      String number = String.valueOf(i);
      testControler.makeSword("TestSword"+number,50,60);
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

  @Test
  public void testCharactersMakerAndGetCharacters () {
    boolean isPlayerCharactersEmpty = false;
    boolean isEnemyCharactersEmpty = false;

    try {
      testControler.getPlayerCharacter(0);
    } catch (IndexOutOfBoundsException e) {
      isPlayerCharactersEmpty = true;
    }

    try {
      testControler.getEnemy(0);
    } catch (IndexOutOfBoundsException e) {
      isEnemyCharactersEmpty = true;
    }

    assertTrue(isPlayerCharactersEmpty);
    assertTrue(isEnemyCharactersEmpty);


    testControler.makeKnight("TestKnight",1,1);
    testControler.makeEngineer("TestEngineer",2,2);
    testControler.makeThief("TestThief",3,3);
    testControler.makeBlackMage("TestBlackMage",4,4,4);
    testControler.makeWhiteMage("TestWhiteMage",5,5,5);

    testControler.makeEnemy("TestEnemy1",6,6,6,6);
    testControler.makeEnemy("TestEnemy2",7,7,7,7);

    assertEquals(new KnightCharacter(testControler.getQueue(),"TestKnight",1,1),
            testControler.getPlayerCharacter(0));

    assertEquals(new EngineerCharacter(testControler.getQueue(),"TestEngineer",2,2),
            testControler.getPlayerCharacter(1));

    assertEquals(new ThiefCharacter(testControler.getQueue(),"TestThief",3,3),
            testControler.getPlayerCharacter(2));

    assertEquals(new BlackMageCharacter(testControler.getQueue(),"TestBlackMage",4,4,4),
            testControler.getPlayerCharacter(3));

    assertEquals(new WhiteMageCharacter(testControler.getQueue(),"TestWhiteMage",5,5,5),
            testControler.getPlayerCharacter(4));

    assertEquals(new Enemy(testControler.getQueue(),"TestEnemy1",6,6,6,6),
            testControler.getEnemy(0));

    assertEquals(new Enemy(testControler.getQueue(),"TestEnemy2",7,7,7,7),
            testControler.getEnemy(1));

  }

  @Test
  public void testWeaponsMaker () {
    testControler.makeSword("TestSword",3,3);
    testControler.makeBow("TestBow",4,4);
    testControler.makeKnife("TestKnife",5,5);
    testControler.makeAxe("TestAxe",6,6);
    testControler.makeStaff("TestStaff",7,7,7);

    assertEquals(new Sword("TestSword",3,3),
            testControler.inventory.getWeaponsInventory().get(1));

    assertEquals(new Bow("TestBow",4,4),
            testControler.inventory.getWeaponsInventory().get(2));

    assertEquals(new Knife("TestKnife",5,5),
            testControler.inventory.getWeaponsInventory().get(3));

    assertEquals(new Axe("TestAxe",6,6),
            testControler.inventory.getWeaponsInventory().get(4));

    assertEquals(new Staff("TestStaff",7,7,7),
            testControler.inventory.getWeaponsInventory().get(5));
  }

  @Test
  public void testAttackAndEquip () {
    testControler.makeSword("TestSword",1,3);
    testControler.makeAxe("TestAxe",1,6);
    testControler.makeBow("TestBow",1,4);
    testControler.makeKnife("TestKnife",1,5);
    testControler.makeStaff("TestStaff",1,7,7);

    testControler.makeKnight("TestKnight",50,0);
    testControler.makeEngineer("TestEngineer",50,0);
    testControler.makeThief("TestThief",50,0);
    testControler.makeBlackMage("TestBlackMage",50,0,4);
    testControler.makeWhiteMage("TestWhiteMage",50,0,5);

    testControler.makeEnemy("TestEnemy1",50,0,6,3);
    testControler.makeEnemy("TestEnemy2",50,0,7,4);

    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testControler.getPlayerCharacter(0));
    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testControler.getPlayerCharacter(1));
    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testControler.getPlayerCharacter(2));
    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testControler.getPlayerCharacter(3));
    testControler.rightMoveInventory();
    testControler.equipWeaponTo(testControler.getPlayerCharacter(4));

    testControler.enemyAttacks(testControler.getEnemy(0)
            ,testControler.getPlayerCharacter(0));
    assertEquals(47,testControler.getPlayerCharacter(0).getHp());

    testControler.playerCharacterCommonAttack(testControler.getPlayerCharacter(0),
            testControler.getEnemy(0));
    assertEquals(49,testControler.getEnemy(0).getHp());

    testControler.playerCharacterCommonAttack(testControler.getPlayerCharacter(1),
            testControler.getEnemy(0));
    assertEquals(48,testControler.getEnemy(0).getHp());

    testControler.playerCharacterCommonAttack(testControler.getPlayerCharacter(2),
            testControler.getEnemy(0));
    assertEquals(47,testControler.getEnemy(0).getHp());

    testControler.playerCharacterCommonAttack(testControler.getPlayerCharacter(3),
            testControler.getEnemy(0));
    assertEquals(46,testControler.getEnemy(0).getHp());

    testControler.playerCharacterCommonAttack(testControler.getPlayerCharacter(4),
            testControler.getEnemy(0));
    assertEquals(45,testControler.getEnemy(0).getHp());
  }

  @Test
  public void testDataGet () {
    IPlayerCharacter testPlayerCharacter;
    IMageCharacter testMage;
    ICharacter testCharacter;
    Enemy testEnemy;

    testCharacter = new ThiefCharacter(testControler.getQueue(),
            "TestCharacter",15,7);
    testCharacter.receiveDamage(15);

    testPlayerCharacter = new KnightCharacter(testControler.getQueue(),
            "TestPC", 10,8);
    testPlayerCharacter.equip(new Sword("TestSword",13,3));

    //RestarMana TODO
    testMage = new WhiteMageCharacter(testControler.getQueue(),
            "TestMage",12,12,17);
    testMage.equip(new Staff("TestStaff",2,22,2));

    testEnemy = new Enemy(testControler.getQueue(),
            "TestEnemy",20,35,20,32);

    assertEquals("TestCharacter",testControler.getCharacterName(testCharacter));
    assertEquals(15,testControler.getCharacterMaxHp(testCharacter));
    assertEquals(7,testControler.getCharacterHp(testCharacter));
    assertEquals(7,testControler.getCharacterDefense(testCharacter));

    assertEquals(3,testControler.getPlayerCharacterWeight(testPlayerCharacter));
    assertEquals(13,testControler.getPlayerCharacterDamage(testPlayerCharacter));
    assertEquals("TestSword",testControler.getWeaponName(testPlayerCharacter));

    assertEquals(17,testControler.getMageMaxMana(testMage));

    assertEquals(32,testControler.getEnemyDamage(testEnemy));
    assertEquals(35,testControler.getEnemyWeight(testEnemy));
  }

  @Test
  public void testPlayerCharacterDeathListenerAndLoss () {
    for (int i = 0 ; i < 4; i++) {
      testControler.makeThief("TestThief" + String.valueOf(i),1,1);
    }
    assertEquals(4,testControler.getPlayersAlive());
    testControler.getPlayerCharacter(0).receiveDamage(2);
    assertEquals(3,testControler.getPlayersAlive());
    testControler.getPlayerCharacter(1).receiveDamage(2);
    assertEquals(2,testControler.getPlayersAlive());
    testControler.getPlayerCharacter(2).receiveDamage(2);
    assertEquals(1,testControler.getPlayersAlive());
    testControler.getPlayerCharacter(3).receiveDamage(2);
    assertEquals(0,testControler.getPlayersAlive());

  }

  @Test
  public void testEnemyDeathListenerAndWin () {
    for (int i = 0 ; i < 4; i++) {
      testControler.makeEnemy("TestEnemy" + String.valueOf(i),1,1,2,2);
    }
    assertEquals(4,testControler.getEnemiesAlive());
    testControler.getEnemy(0).receiveDamage(2);
    assertEquals(3,testControler.getEnemiesAlive());
    testControler.getEnemy(1).receiveDamage(2);
    assertEquals(2,testControler.getEnemiesAlive());
    testControler.getEnemy(2).receiveDamage(2);
    assertEquals(1,testControler.getEnemiesAlive());
    testControler.getEnemy(3).receiveDamage(2);
    assertEquals(0,testControler.getEnemiesAlive());

  }
}
