package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyMakerTest extends CharacterMakerTest {

  public void setTestMaker() {
    enemies = 1;
    testCharacterMaker = new EnemyMaker();
    testController = new Controller();

    testCharacterMaker.setController(testController);
    testController.setCharacterMaker(testCharacterMaker);

    expectedNewCharacter = new Enemy(testController.getQueue(),"TestCharacter",200,100,100,20);

    notEqualsMaker = new KnightMaker();
    equalsMaker = new EnemyMaker();
    equalsMaker.setController(testController);
  }

  @Override
  @Test
  public void moveLeftTest() {
    boolean shouldPass = false;
    testController.setCharacterMaker(testCharacterMaker);
    try {
      testCharacterMaker.changeLeft();
    } catch (AssertionError e) {
      shouldPass = true;
    }
    assertTrue(shouldPass);
  }

  @Override
  @Test
  public void moveRightTest() {
    boolean shouldPass = false;
    testController.setCharacterMaker(testCharacterMaker);
    try {
      testCharacterMaker.changeRight();
    } catch (AssertionError e) {
      shouldPass = true;
    }
    assertTrue(shouldPass);
  }

  @Override
  @Test
  public void makeCharacterTest () {
    testController.setCharacterMaker(testCharacterMaker);
    testCharacterMaker.makeCharacter("TestCharacter");
    assertEquals(1,testController.getEnemiesAlive());
    assertEquals(expectedNewCharacter,testController.getEnemyCharacters().get(0));
    notEqualsMaker.setController(testController);
    assertNotEquals(notEqualsMaker,testController.getCharacterMaker());
  }
}
