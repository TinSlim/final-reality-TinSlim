package com.github.cc3002.finalreality.model.character;

class EnemyTest extends AbstractCharacterTest {
  public void setTestCharacter(){
    testCharacterA = new Enemy(turnsQueue,"EnemyA",100,100,100);
    testCharacterB = new Enemy(turnsQueue,"EnemyB",50,50,50);
    testCharacterC = new Enemy(turnsQueue,"EnemyC",0,0,0);
    testCharacterD = new Enemy(turnsQueue,"EnemyD",-10,-10,-10);
  }
}