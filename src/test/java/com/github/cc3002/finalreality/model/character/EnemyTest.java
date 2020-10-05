package com.github.cc3002.finalreality.model.character;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnemyTest extends AbstractCharacterTest {
  int h;
  BlockingQueue<ICharacter> turnsQueue;

  /**
   * Checks that the class' constructor and equals method works properly.
   */



  public void setTestCharacter(){
    testCharacterA = new Enemy(turnsQueue,"EnemyA",100,100,100);
    testCharacterB = new Enemy(turnsQueue,"EnemyB",50,50,50);
    testCharacterC = new Enemy(turnsQueue,"EnemyC",0,0,0);
    testCharacterD = new Enemy(turnsQueue,"EnemyD",-10,-10,-10);
  }
  @Override
  public void setMaxHp(int i) {

  }


  @Override
  public int getHp() {
    return 0;
  }
}