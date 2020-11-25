package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;

public class BlackMageMakerTest extends CharacterMakerTest {

  public void setTestMaker() {
    testCharacterMaker = new BlackMageMaker();
    testController = new Controller();

    testCharacterMaker.setController(testController);
    testController.setCharacterMaker(testCharacterMaker);

    expectedRightMaker = new KnightMaker();
    expectedLeftMaker = new WhiteMageMaker();
    expectedNewCharacter = new BlackMageCharacter(testController.getQueue(),"TestCharacter",
            200,100,100);

    notEqualsMaker = new KnightMaker();
    equalsMaker = new BlackMageMaker();
    equalsMaker.setController(testController);
  }
}
