package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.phases.PlayerPhase;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Controller class, phases and listeners.
 */
public class ControllerTest {
  Controller testController;

  /**
   * This method set up the controller.
   */
  @BeforeEach
  public void setUp () {
    testController = new Controller(new Random(4));
  }

  /**
   * Tests the inventory movement.
   */
  @Test
  public void testInventoryMovement () {
    assertEquals(0,testController.getInventoryLength());
    for (int i = 0; i < 15; i++) {
      String number = String.valueOf(i);
      testController.makeSword("TestSword"+number,50,60);
    }
    assertEquals(12,testController.getInventoryLength());
    KnightCharacter testKnight1 = new KnightCharacter(testController.getQueue(),
            "TestKnight1",1,1);
    testKnight1.equipWeapon(new Sword("DummySword",9,9));

    testController.setPhase(new PlayerPhase());

    assertEquals(0,testController.getEquipmentPointer());
    testController.rightMoveInventory();
    assertEquals(1,testController.getEquipmentPointer());
    testController.rightMoveInventory();
    assertEquals(2,testController.getEquipmentPointer());
    testController.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword2",50,60) ,testKnight1.getEquippedWeapon());

    testController.downMoveInventory();
    assertEquals(6,testController.getEquipmentPointer());
    testController.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword6",50,60) ,testKnight1.getEquippedWeapon());

    testController.upMoveInventory();
    assertEquals(2,testController.getEquipmentPointer());
    testController.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword2",50,60) ,testKnight1.getEquippedWeapon());

    testController.leftMoveInventory();
    assertEquals(1,testController.getEquipmentPointer());
    testController.equipWeaponTo(testKnight1);
    assertEquals(new Sword("TestSword1",50,60) ,testKnight1.getEquippedWeapon());
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
            testController.getInventory().getWeaponsInventory().get(0));

    assertEquals(new Bow("TestBow",4,4),
            testController.getInventory().getWeaponsInventory().get(1));

    assertEquals(new Knife("TestKnife",5,5),
            testController.getInventory().getWeaponsInventory().get(2));

    assertEquals(new Axe("TestAxe",6,6),
            testController.getInventory().getWeaponsInventory().get(3));

    assertEquals(new Staff("TestStaff",7,7,7),
            testController.getInventory().getWeaponsInventory().get(4));
  }

  /**
   * Tests common attacks and weapon equip.
   * @throws InterruptedException thread exception.
   */
  @Test
  public void testAttack() throws InterruptedException {
    assertFalse(testController.gameCanStart());

    testController.makeKnight("TestKnight",50,0);
    testController.makeEngineer("TestEngineer",50,0);
    testController.makeThief("TestThief",50,0);
    testController.makeBlackMage("TestBlackMage",50,0,4);

    assertFalse(testController.gameCanStart());

    testController.makeEnemy("TestEnemy1",10,0,140,3);
    testController.makeEnemy("TestEnemy2",2,0,80,4);
    testController.makeEnemy("TestEnemy3",10,0,20,50);

    assertFalse(testController.gameCanStart());

    testController.getPlayerCharacter(0).equip(new Sword("TestSword",9,40));
    testController.getPlayerCharacter(1).equip(new Axe("TestAxe",2,60));
    testController.getPlayerCharacter(2).equip(new Bow("TestBow",4,120));
    testController.getPlayerCharacter(3).equip(new Knife("TestKnife",10,100));

    testController.makeSword("TestSword",10,10);

    assertTrue(testController.gameCanStart());

    boolean outOfBoundCharacterList = false;
    try {
      testController.getPlayerCharacter(4).equip(new Staff("TestStaff",15,160,7));
    } catch (IndexOutOfBoundsException e) {
      outOfBoundCharacterList = true;
    }
    assertTrue(outOfBoundCharacterList);

    testController.startGame();
    assertEquals(100,testController.getActualTargetPointer());

    Thread.sleep(2500);
    testController.executePhase();
    testController.executePhase();

    Thread.sleep(2500);
    testController.executePhase();
    assertEquals(0,testController.getPlayerAttackingPointer());
    assertEquals(0,testController.getActualTargetPointer());
    testController.getPhase().moveTargetRight();
    assertEquals(1,testController.getActualTargetPointer());
    testController.getPhase().moveTargetRight();
    assertEquals(2,testController.getActualTargetPointer());
    testController.getPhase().moveTargetRight();
    assertEquals(2,testController.getActualTargetPointer());
    testController.getPhase().moveTargetRight();
    testController.getPhase().moveTargetLeft();
    assertEquals(1,testController.getActualTargetPointer());
    testController.getPhase().doAttack();

    Thread.sleep(2500);
    testController.executePhase();
    testController.executePhase();

    Thread.sleep(2500);
    testController.executePhase();
    assertEquals(1,testController.getPlayerAttackingPointer());
    testController.getPhase().doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    assertEquals(1,testController.getPlayerAttackingPointer());
    testController.moveTargetRight();
    testController.moveTargetRight();
    testController.getPhase().doAttack();
    //
    Thread.sleep(2000);
    testController.executePhase();
    testController.getPhase().doAttack();

    Thread.sleep(2000);
    testController.executePhase();

    Thread.sleep(2000);
    testController.executePhase();
    testController.executePhase();
    assertEquals(0,testController.getPlayerAttackingPointer());
    testController.moveTargetLeft();
    testController.moveTargetLeft();
    assertEquals(0,testController.getActualTargetPointer());
    testController.moveTargetLeft();
    assertEquals(0,testController.getActualTargetPointer());
    testController.moveTargetLeft();
    assertEquals(0,testController.getActualTargetPointer());
    testController.moveTargetLeft();
    testController.getPhase().doAttack();

    testController.moveTargetRight();
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
    testController.makeKnight("TestPC",10,8);
    testController.getPlayerCharacter(0).receiveDamage(12);
    testController.getPlayerCharacter(0).equip(new Sword("TestSword",13,3));


    testController.makeWhiteMage("TestMage",12,12,17);
    testController.getPlayerCharacter(1).equip(new Staff("TestStaff",2,22,2));

    testController.makeEnemy("TestEnemy",20,20,35,32);
    testController.getEnemy(0).receiveDamage(25);

    assertEquals("TestPC", testController.getPlayerCharacterName(0));
    assertEquals(10, testController.getPlayerCharacterMaxHp(0));
    assertEquals(6, testController.getPlayerCharacterHp(0));
    assertEquals(8, testController.getPlayerCharacterDefense(0));
    assertEquals(3, testController.getPlayerCharacterWeight(0));
    assertEquals(13, testController.getPlayerCharacterDamage(0));


    assertEquals("TestEnemy", testController.getEnemyName(0));
    assertEquals(20, testController.getEnemyMaxHp(0));
    assertEquals(15, testController.getEnemyHp(0));
    assertEquals(20, testController.getEnemyDefense(0));
    assertEquals(35, testController.getEnemyWeight(0));
    assertEquals(32, testController.getEnemyDamage(0));

    assertEquals(17, testController.getMaxMana(1));
    assertEquals(17, testController.getMana(1));

    boolean shouldPassMaxMana = false;
    try {
      testController.getMaxMana(0);
    } catch (AssertionError e) {
      shouldPassMaxMana = true;
    }
    assertTrue(shouldPassMaxMana);

    boolean shouldPassMana = false;
    try {
      testController.getMana(0);
    } catch (AssertionError e) {
      shouldPassMana = true;
    }
    assertTrue(shouldPassMana);

  }

  /**
   * Tests the method lose, when the user loses the game.
   * @throws InterruptedException thread exception.
   */
  @Test
  public void testLoseGame () throws InterruptedException {
    testController.makeKnight("TestKnightA",20,3);
    testController.makeKnight("TestKnightB",20,3);

    testController.getPlayerCharacter(0).equip(new Sword("TestSword",9,300));
    testController.getPlayerCharacter(1).equip(new Sword("TestSword",9,30));

    testController.makeEnemy("TestEnemy1",10,0,10,100);
    testController.makeEnemy("TestEnemy2",10,0,50,100);
    testController.makeEnemy("TestEnemy3",10,0,70,100);
    testController.makeEnemy("TestEnemy4",10,0,90,100);
    testController.makeEnemy("TestEnemy5",10,0,110,100);
    testController.makeEnemy("TestEnemy6",10,0,130,100);
    testController.makeEnemy("TestEnemy7",10,0,150,100);
    testController.makeEnemy("TestEnemy8",10,0,180,100);
    testController.makeEnemy("TestEnemy9",10,0,200,100);

    assertTrue(testController.getEnemiesQuantity() < 9);

    testController.startGame();

    Thread.sleep(2000);
    testController.executePhase();
    testController.executePhase();

    Thread.sleep(2000);
    testController.executePhase();
    testController.executePhase();
    testController.doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.executePhase();

    Thread.sleep(2000);
    testController.executePhase();
    testController.executePhase();

    Thread.sleep(2000);
    testController.executePhase();
    testController.executePhase();

    Thread.sleep(2000);
    testController.executePhase();
    testController.executePhase();

    assertEquals("GameOver, you lose",testController.getGameEnd());
  }

  /**
   * Tests the method win, when the user wins the game.
   * @throws InterruptedException thread exception.
   */
  @Test
  public void testWinGame () throws InterruptedException {
    testController.makeKnight("TestKnight",20,3);

    testController.getPlayerCharacter(0).equip(new Sword("TestSword",50,20));

    testController.makeEnemy("TestEnemy1",10,5,50,2);
    testController.makeEnemy("TestEnemy1",45,5,80,2);

    testController.startGame();

    Thread.sleep(2000);
    testController.executePhase();
    testController.doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.doAttack();

    Thread.sleep(2000);
    testController.executePhase();
    testController.moveTargetRight();
    testController.doAttack();

    assertEquals("Congratulations, you won!!!",testController.getGameEnd());
  }

  /**
   * Tests the equipment change in a player's turn.
   * @throws InterruptedException thread exception.
   */
  @Test
  public void testChangeEquipment () throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      testController.makeSword("TestSword"+ i,3,20);
    }
    testController.makeKnight("TestKnight",100,60);
    testController.makeEnemy("TestEnemy",100,100,100,100);

    testController.startGame();
    Thread.sleep(4000);
    testController.executePhase();
    testController.rightMoveInventory();
    testController.equipWeapon();
    assertEquals(new Sword("TestSword1",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

    testController.rightMoveInventory();
    testController.rightMoveInventory();
    testController.equipWeapon();
    assertEquals(new Sword("TestSword3",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

    testController.upMoveInventory();
    testController.equipWeapon();
    assertEquals(new Sword("TestSword0",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

    testController.downMoveInventory();
    testController.equipWeapon();
    assertEquals(new Sword("TestSword4",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

    testController.leftMoveInventory();
    testController.equipWeapon();
    assertEquals(new Sword("TestSword3",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

    testController.downMoveInventory();
    testController.downMoveInventory();
    testController.equipWeapon();
    assertEquals(new Sword("TestSword9",3,20),
            testController.getPlayerCharacter(0).getEquippedWeapon());

  }

  /**
   * Tests image path getters.
   */
  @Test
  public void testImageFiles () {
    testController.makeKnight("TestPlayerCharacter",10,10);
    assertEquals("src\\resources\\characters\\knight.png",testController.getPlayerImage(0));

    testController.makeSword("TestSword",10,10);
    assertEquals("src\\resources\\weapons\\sword.png",testController.getWeaponImage(0));

    testController.makeKnife("TestKnife",12,12);
    assertEquals("src\\resources\\weapons\\knife.png",testController.getWeaponImage(1));

  }

  /**
   * Tests weapon getters.
   */
  @Test
  public void testWeaponGetters () {
    testController.makeSword("TestSword",1,2);
    testController.makeKnife("TestKnife",3,4);
    testController.makeAxe("TestAxe",5,6);
    testController.makeBow("TestBow",7,8);

    assertEquals(new Sword("TestSword",1,2),testController.getWeapon(0));
    assertEquals("TestSword",testController.getWeaponName(0));
    assertEquals(1,testController.getWeaponDamage(0));
    assertEquals(2,testController.getWeaponWeight(0));

    assertEquals(new Knife("TestKnife",3,4),testController.getWeapon(1));
    assertEquals("TestKnife",testController.getWeaponName(1));
    assertEquals(3,testController.getWeaponDamage(1));
    assertEquals(4,testController.getWeaponWeight(1));

    assertEquals(new Bow("TestBow",7,8),testController.getWeapon(3));
    assertEquals("TestBow",testController.getWeaponName(3));
    assertEquals(7,testController.getWeaponDamage(3));
    assertEquals(8,testController.getWeaponWeight(3));
  }
}
