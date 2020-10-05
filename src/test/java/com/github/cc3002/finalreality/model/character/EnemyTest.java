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

  @BeforeEach
  public void setUp(){
    testCharacterA = new Enemy("EnemyA",100,turnsQueue);
    testCharacterB = new Enemy("EnemyB",50,turnsQueue);
    testCharacterC = new Enemy("EnemyC",0,turnsQueue);
    testCharacterD = new Enemy("EnemyD",-10,turnsQueue);
  }
  @Test
  public void testReceiveDamage() {

  }

  @Override
  public void setMaxHp(int i) {

  }

  @Override
  public void receiveDamage(int i) {

  }

  @Override
  public int getHp() {
    return 0;
  }
}