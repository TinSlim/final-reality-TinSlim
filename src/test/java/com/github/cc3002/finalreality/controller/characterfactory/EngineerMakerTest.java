package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;

public class EngineerMakerTest extends CharacterMakerTest {

  public void setTestMaker() {
    testCharacterMaker = new EngineerMaker();
    testController = new Controller();

    testCharacterMaker.setController(testController);
    testController.setCharacterMaker(testCharacterMaker);

    expectedRightMaker = new WhiteMageMaker();
    expectedLeftMaker = new ThiefMaker();
    expectedNewCharacter = new EngineerCharacter(testController.getQueue(),"TestCharacter",
            200,100);

    notEqualsMaker = new WhiteMageMaker();
    equalsMaker = new EngineerMaker();
    equalsMaker.setController(testController);
  }
}
