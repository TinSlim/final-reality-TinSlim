package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class CharacterMakerTest {
  CharacterMaker testCharacterMaker;
  CharacterMaker expectedRightMaker;
  CharacterMaker expectedLeftMaker;
  CharacterMaker notEqualsMaker;
  CharacterMaker equalsMaker;
  CharacterMaker enemyMaker;

  int players;
  int enemies;

  Controller testController;
  ICharacter expectedNewCharacter;

  @BeforeEach
  public void setUp () {
    players = 0;
    enemies = 0;
    enemyMaker = new EnemyMaker();
    setTestMaker();
  }

  protected abstract void setTestMaker();

  @Test
  public void moveRightTest () {
    testController.setCharacterMaker(testCharacterMaker);
    assertEquals(testCharacterMaker,testController.getCharacterMaker());
    testController.rightCharacterMaker();
    expectedRightMaker.setController(testController);
    assertEquals(expectedRightMaker,testController.getCharacterMaker());;
  }

  @Test
  public void moveLeftTest () {
    testController.setCharacterMaker(testCharacterMaker);
    assertEquals(testCharacterMaker,testController.getCharacterMaker());
    testController.leftCharacterMaker();
    expectedLeftMaker.setController(testController);
    assertEquals(expectedLeftMaker,testController.getCharacterMaker());
    notEqualsMaker.setController(testController);
    assertNotEquals(notEqualsMaker,testController.getCharacterMaker());
  }

  @Test
  public void makeCharacterTest () {
    testController.setCharacterMaker(testCharacterMaker);
    testController.makeCharacter("TestCharacter");
    assertEquals(1,testController.getPlayersAlive());
    assertEquals(expectedNewCharacter,testController.getAlivePlayerCharacters().get(0));
    notEqualsMaker.setController(testController);
    assertNotEquals(notEqualsMaker,testController.getCharacterMaker());
  }

  @Test
  public void constructionTest () {
    assertTrue(testCharacterMaker.equals(testController.getCharacterMaker()));
    assertFalse(testCharacterMaker.equals("A"));
    assertTrue(testCharacterMaker.equals(equalsMaker));
  }

  @Test
  public void changeToEnemy () {
    testController.setCharacterMaker(testCharacterMaker);
    assertEquals(testCharacterMaker,testController.getCharacterMaker());
    testController.enemyMaker();
    enemyMaker.setController(testController);
    assertEquals(enemyMaker,testController.getCharacterMaker());
  }
}
