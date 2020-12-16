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
    testController = new Controller(4);
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
  public void testAttackAndEquip () throws InterruptedException {
    testController.makeSword("TestSword",9,40);
    testController.makeAxe("TestAxe",2,60);
    testController.makeBow("TestBow",4,120);
    testController.makeKnife("TestKnife",10,100);
    testController.makeStaff("TestStaff",15,160,7);

    testController.makeKnight("TestKnight",50,0);
    testController.makeEngineer("TestEngineer",50,0);
    testController.makeThief("TestThief",50,0);
    testController.makeBlackMage("TestBlackMage",50,0,4);
    testController.makeWhiteMage("TestWhiteMage",50,0,5);

    testController.makeEnemy("TestEnemy1",10,0,140,3);
    testController.makeEnemy("TestEnemy2",2,0,80,4);
    testController.makeEnemy("TestEnemy3",10,0,20,50);

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

    testController.startGame();

    Thread.sleep(2500);
    testController.executePhase();

    Thread.sleep(2500);
    testController.executePhase();
    testController.getPhase().moveTargetRight();
    testController.getPhase().moveTargetRight();
    testController.getPhase().moveTargetRight();
    testController.getPhase().moveTargetRight();
    testController.getPhase().moveTargetLeft();
    testController.getPhase().doAttack();

    Thread.sleep(2500);
    testController.executePhase();
    testController.getPhase().doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.moveTargetRight();
    testController.moveTargetRight();
    testController.moveTargetRight();
    testController.getPhase().doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.getPhase().doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.moveTargetLeft();
    testController.moveTargetLeft();
    testController.moveTargetLeft();
    testController.getPhase().doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.getPhase().doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.getPhase().doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.getPhase().doAttack();
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

  @Test
  public void testLoseGame () throws InterruptedException {
    testController.makeSword("TestSword",9,300);
    testController.makeKnight("TestKnight",20,3);

    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(0));

    testController.makeEnemy("TestEnemy1",10,0,30,100);
    testController.makeEnemy("TestEnemy2",10,0,70,100);
    testController.startGame();

    Thread.sleep(2000);
    testController.executePhase();

    Thread.sleep(2000);
    testController.executePhase();

    Thread.sleep(2000);
    testController.executePhase();

    System.out.println("a");
  }

  @Test
  public void testWinGame () throws InterruptedException {
    testController.makeSword("TestSword",100,10);
    testController.makeKnight("TestKnight",20,3);

    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(0));

    testController.makeEnemy("TestEnemy1",10,5,300,2);
    testController.startGame();
    Thread.sleep(2000);
    testController.executePhase();
    testController.getPhase().doAttack();
  }

  @Test
  public void testChangeEquipment () throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      testController.makeSword("TestSword"+String.valueOf(i),3,20);
    }
    testController.makeKnight("TestKnight",100,60);
    testController.makeEnemy("TestEnemy",100,100,40,100);

    testController.rightMoveInventory();
    testController.equipWeaponTo(testController.getPlayerCharacter(0));
    assertEquals(new Sword("TestSword0",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

    testController.startGame();
    Thread.sleep(4000);
    testController.executePhase();
    testController.getPhase().moveRightInventory();
    testController.getPhase().moveRightInventory();
    testController.getPhase().equipWeapon();
    assertEquals(new Sword("TestSword2",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

    testController.getPhase().moveUpInventory();
    testController.getPhase().equipWeapon();
    assertEquals(new Sword("TestSword7",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

    testController.getPhase().moveDownInventory();
    testController.getPhase().equipWeapon();
    assertEquals(new Sword("TestSword2",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

    testController.getPhase().moveLeftInventory();
    testController.getPhase().equipWeapon();
    assertEquals(new Sword("TestSword1",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

  }
}
