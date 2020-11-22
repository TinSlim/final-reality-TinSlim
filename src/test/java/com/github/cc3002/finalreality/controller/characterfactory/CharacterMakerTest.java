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

  Controller testController;
  ICharacter expectedNewCharacter;

  @BeforeEach
  public void setUp () {
    setTestMaker();
  }

  protected abstract void setTestMaker();

  @Test
  public void moveRightTest () {
    testController.setCharacterMaker(testCharacterMaker);
    assertEquals(testCharacterMaker,testController.getCharacterMaker());
    testCharacterMaker.changeRight();
    expectedRightMaker.setController(testController);
    assertEquals(expectedRightMaker,testController.getCharacterMaker());;
  }

  @Test
  public void moveLeftTest () {
    testController.setCharacterMaker(testCharacterMaker);
    assertEquals(testCharacterMaker,testController.getCharacterMaker());
    testCharacterMaker.changeLeft();
    expectedLeftMaker.setController(testController);
    assertEquals(expectedLeftMaker,testController.getCharacterMaker());
    notEqualsMaker.setController(testController);
    assertNotEquals(notEqualsMaker,testController.getCharacterMaker());
  }

  @Test
  public void makeCharacterTest () {
    testCharacterMaker.makeCharacter("TestCharacter");
    assertEquals(1,testController.getPlayersAlive());
    assertEquals(expectedNewCharacter,testController.getAlivePlayerCharacters().get(0));
    notEqualsMaker.setController(testController);
    assertNotEquals(notEqualsMaker,testController.getCharacterMaker());
  }
}
