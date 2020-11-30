package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
  Controller testController;

  /**
   * This method set up the controller.
   */
  @BeforeEach
  public void setUp () {
    testController = new Controller();
  }

  /**
   * Tests the inventory movement.
   */
  @Test
  public void testInventoryMovement () {
    for (int i = 0; i < 15; i++) {
      String number = String.valueOf(i);
      testController.makeSword("TestSword"+number,50,60);
    }
    KnightCharacter testKnight1 = new KnightCharacter(testController.getQueue(),
            "TestKnight1",1,1);

    testController.rightMoveInventory();
    testController.rightMoveInventory();
    testController.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword1",50,60) ,testKnight1.getEquippedWeapon());

    testController.upMoveInventory();
    testController.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword6",50,60) ,testKnight1.getEquippedWeapon());

    testController.downMoveInventory();
    testController.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword1",50,60) ,testKnight1.getEquippedWeapon());

    testController.leftMoveInventory();
    testController.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword0",50,60) ,testKnight1.getEquippedWeapon());


  }

  /**
   * Tests all character makers and character getters (player characters and enemies).
   */
  @Test
  public void testCharactersMakerAndGetCharacters () {
    boolean isPlayerCharactersEmpty = false;
    boolean isEnemyCharactersEmpty = false;

    try {
      testController.getPlayerCharacter(0);
    } catch (IndexOutOfBoundsException e) {
      isPlayerCharactersEmpty = true;
    }

    try {
      testController.getEnemy(0);
    } catch (IndexOutOfBoundsException e) {
      isEnemyCharactersEmpty = true;
    }

    assertTrue(isPlayerCharactersEmpty);
    assertTrue(isEnemyCharactersEmpty);


    testController.makeKnight("TestKnight",1,1);
    testController.makeEngineer("TestEngineer",2,2);
    testController.makeThief("TestThief",3,3);
    testController.makeBlackMage("TestBlackMage",4,4,4);
    testController.makeWhiteMage("TestWhiteMage",5,5,5);

    testController.makeEnemy("TestEnemy1",6,6,6,6);
    testController.makeEnemy("TestEnemy2",7,7,7,7);

    assertEquals(new KnightCharacter(testController.getQueue(),"TestKnight",1,1),
            testController.getPlayerCharacter(0));

    assertEquals(new EngineerCharacter(testController.getQueue(),"TestEngineer",2,2),
            testController.getPlayerCharacter(1));

    assertEquals(new ThiefCharacter(testController.getQueue(),"TestThief",3,3),
            testController.getPlayerCharacter(2));

    assertEquals(new BlackMageCharacter(testController.getQueue(),"TestBlackMage",4,4,4),
            testController.getPlayerCharacter(3));

    assertEquals(new WhiteMageCharacter(testController.getQueue(),"TestWhiteMage",5,5,5),
            testController.getPlayerCharacter(4));

    assertEquals(new Enemy(testController.getQueue(),"TestEnemy1",6,6,6,6),
            testController.getEnemy(0));

    assertEquals(new Enemy(testController.getQueue(),"TestEnemy2",7,7,7,7),
            testController.getEnemy(1));

  }

  /**
   * Tests weapon makers.
   */
  @Test
  public void testWeaponsMaker () {
    testController.makeSword("TestSword",3,3);
    testController.makeBow("TestBow",4,4);
    testController.makeKnife("TestKnife",5,5);
    testController.makeAxe("TestAxe",6,6);
    testController.makeStaff("TestStaff",7,7,7);

    assertEquals(new Sword("TestSword",3,3),
            testController.getInventory().getWeaponsInventory().get(1));

    assertEquals(new Bow("TestBow",4,4),
            testController.getInventory().getWeaponsInventory().get(2));

    assertEquals(new Knife("TestKnife",5,5),
            testController.getInventory().getWeaponsInventory().get(3));

    assertEquals(new Axe("TestAxe",6,6),
            testController.getInventory().getWeaponsInventory().get(4));

    assertEquals(new Staff("TestStaff",7,7,7),
            testController.getInventory().getWeaponsInventory().get(5));
  }

  /**
   * Tests common attacks and weapon equip.
   */
  @Test
  public void testAttackAndEquip () {
    testController.makeSword("TestSword",1,3);
    testController.makeAxe("TestAxe",1,6);
    testController.makeBow("TestBow",1,4);
    testController.makeKnife("TestKnife",1,5);
    testController.makeStaff("TestStaff",1,7,7);

    testController.makeKnight("TestKnight",50,0);
    testController.makeEngineer("TestEngineer",50,0);
    testController.makeThief("TestThief",50,0);
    testController.makeBlackMage("TestBlackMage",50,0,4);
    testController.makeWhiteMage("TestWhiteMage",50,0,5);

    testController.makeEnemy("TestEnemy1",50,0,6,3);
    testController.makeEnemy("TestEnemy2",50,0,7,4);

    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(0));
    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(1));
    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(2));
    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(3));
    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(4));

    testController.enemyAttacks(testController.getEnemy(0)
            , testController.getPlayerCharacter(0));
    assertEquals(47, testController.getPlayerCharacter(0).getHp());

    testController.playerCharacterCommonAttack(testController.getPlayerCharacter(0),
            testController.getEnemy(0));
    assertEquals(49, testController.getEnemy(0).getHp());

    testController.playerCharacterCommonAttack(testController.getPlayerCharacter(1),
            testController.getEnemy(0));
    assertEquals(48, testController.getEnemy(0).getHp());

    testController.playerCharacterCommonAttack(testController.getPlayerCharacter(2),
            testController.getEnemy(0));
    assertEquals(47, testController.getEnemy(0).getHp());

    testController.playerCharacterCommonAttack(testController.getPlayerCharacter(3),
            testController.getEnemy(0));
    assertEquals(46, testController.getEnemy(0).getHp());

    testController.playerCharacterCommonAttack(testController.getPlayerCharacter(4),
            testController.getEnemy(0));
    assertEquals(45, testController.getEnemy(0).getHp());
  }

  /**
   * Tests data getters.
   */
  @Test
  public void testDataGet () {
    IPlayerCharacter testPlayerCharacter;
    IPlayerCharacter testMage;
    Enemy testEnemy;

    testPlayerCharacter = new KnightCharacter(testController.getQueue(),
            "TestPC", 10,8);
    testPlayerCharacter.receiveDamage(12);
    testPlayerCharacter.equip(new Sword("TestSword",13,3));


    testMage = new WhiteMageCharacter(testController.getQueue(),
            "TestMage",12,12,17);
    testMage.equip(new Staff("TestStaff",2,22,2));

    testEnemy = new Enemy(testController.getQueue(),
            "TestEnemy",20,35,20,32);
    testEnemy.receiveDamage(25);

    assertEquals("TestPC", testController.getPlayerCharacterName(testPlayerCharacter));
    assertEquals(10, testController.getPlayerCharacterMaxHp(testPlayerCharacter));
    assertEquals(6, testController.getPlayerCharacterHp(testPlayerCharacter));
    assertEquals(8, testController.getPlayerCharacterDefense(testPlayerCharacter));
    assertEquals(3, testController.getPlayerCharacterWeight(testPlayerCharacter));
    assertEquals(13, testController.getPlayerCharacterDamage(testPlayerCharacter));
    assertEquals("TestSword", testController.getWeaponName(testPlayerCharacter));

    assertEquals("TestEnemy", testController.getEnemyName(testEnemy));
    assertEquals(20, testController.getEnemyMaxHp(testEnemy));
    assertEquals(15, testController.getEnemyHp(testEnemy));
    assertEquals(20, testController.getEnemyDefense(testEnemy));
    assertEquals(35, testController.getEnemyWeight(testEnemy));
    assertEquals(32, testController.getEnemyDamage(testEnemy));

    assertEquals(17, testController.getMaxMana(testMage));
    assertEquals(17, testController.getMana(testMage));

    boolean shouldPassMaxMana = false;
    try {
      testPlayerCharacter.getMaxMana();
    } catch (AssertionError e) {
      shouldPassMaxMana = true;
    }
    assertTrue(shouldPassMaxMana);

    boolean shouldPassMana = false;
    try {
      testPlayerCharacter.getMana();
    } catch (AssertionError e) {
      shouldPassMana = true;
    }
    assertTrue(shouldPassMana);

  }

  /**
   * Tests player death listeners and lose method.
   */
  @Test
  public void testPlayerCharacterDeathListenerAndLose() {
    for (int i = 0 ; i < 4; i++) {
      testController.makeThief("TestThief" + String.valueOf(i),1,1);
    }
    assertEquals(4, testController.getPlayersAlive());
    testController.getPlayerCharacter(0).receiveDamage(2);
    assertEquals(3, testController.getPlayersAlive());
    testController.getPlayerCharacter(1).receiveDamage(2);
    assertEquals(2, testController.getPlayersAlive());
    testController.getPlayerCharacter(2).receiveDamage(2);
    assertEquals(1, testController.getPlayersAlive());
    testController.getPlayerCharacter(3).receiveDamage(2);
    assertEquals(0, testController.getPlayersAlive());

  }

  /**
   * Tests enemy death listeners and win method.
   */
  @Test
  public void testEnemyDeathListenerAndWin () {
    for (int i = 0 ; i < 4; i++) {
      testController.makeEnemy("TestEnemy" + String.valueOf(i),1,1,2,2);
    }
    assertEquals(4, testController.getEnemiesAlive());
    testController.getEnemy(0).receiveDamage(2);
    assertEquals(3, testController.getEnemiesAlive());
    testController.getEnemy(1).receiveDamage(2);
    assertEquals(2, testController.getEnemiesAlive());
    testController.getEnemy(2).receiveDamage(2);
    assertEquals(1, testController.getEnemiesAlive());
    testController.getEnemy(3).receiveDamage(2);
    assertEquals(0, testController.getEnemiesAlive());

  }

  /**
   * Tests the turns.
   * @throws InterruptedException thread error.
   */
  @Test
  public void testStartTurn () throws InterruptedException {
    testController.makeSword("TestSword",1,12);
    testController.makeAxe("TestAxe",1,19);

    testController.makeKnight("TestKnight",50,0);
    testController.makeEngineer("TestEngineer",50,0);

    testController.makeEnemy("TestEnemy1",50,0,25,3);
    testController.makeEnemy("TestEnemy2",50,0,29,4);

    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(0));
    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(1));

    assertEquals(0, testController.getQueue().size());
    testController.getEnemy(0).waitTurn();
    testController.getEnemy(1).waitTurn();
    testController.getPlayerCharacter(0).waitTurn();
    testController.getPlayerCharacter(1).waitTurn();
    assertEquals(0, testController.getQueue().size());

    Thread.sleep(3000);
    Thread.sleep(2000);
  }
}
