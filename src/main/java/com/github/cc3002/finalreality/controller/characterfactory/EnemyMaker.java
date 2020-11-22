package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.model.character.Enemy;

public class EnemyMaker extends CharacterMaker {
  int weight;
  int damage;

  public EnemyMaker () {
    defense = 100;
    maxHp = 200;
    weight = 100;
    damage = 20;
  }

  @Override
  public void makeCharacter(String name) {
    Enemy newCharacter = new Enemy(getController().getQueue(),name,maxHp,weight,defense,damage);
    this.getController().getEnemyCharacters().add(newCharacter);
    this.getController().changeEnemyQuantity(1);
  }
}
