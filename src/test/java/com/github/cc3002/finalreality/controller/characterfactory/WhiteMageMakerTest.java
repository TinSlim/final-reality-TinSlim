package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;

public class WhiteMageMakerTest extends CharacterMakerTest {

  public void setTestMaker() {
    testCharacterMaker = new WhiteMageMaker();
    testController = new Controller();

    testCharacterMaker.setController(testController);
    testController.setCharacterMaker(testCharacterMaker);

    expectedRightMaker = new BlackMageMaker();
    expectedLeftMaker = new EngineerMaker();
    expectedNewCharacter = new WhiteMageCharacter(testController.getQueue(),"TestCharacter",
            200,100,100);

    notEqualsMaker = new ThiefMaker();
    equalsMaker = new WhiteMageMaker();
    equalsMaker.setController(testController);
  }
}
