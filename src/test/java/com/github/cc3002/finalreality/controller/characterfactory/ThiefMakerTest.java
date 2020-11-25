package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;

public class ThiefMakerTest extends CharacterMakerTest {

  public void setTestMaker() {
    testCharacterMaker = new ThiefMaker();
    testController = new Controller();

    testCharacterMaker.setController(testController);
    testController.setCharacterMaker(testCharacterMaker);

    expectedRightMaker = new EngineerMaker();
    expectedLeftMaker = new KnightMaker();
    expectedNewCharacter = new ThiefCharacter(testController.getQueue(),"TestCharacter",
            200,100);

    notEqualsMaker = new WhiteMageMaker();
    equalsMaker = new ThiefMaker();
    equalsMaker.setController(testController);
  }
}
