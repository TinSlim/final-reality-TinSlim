package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import javafx.scene.Group;

public abstract class View implements IView {
  Group root;
  Controller controller;
  FinalReality aGame;

  public void setRoot(Group newRoot) {
    root = newRoot;
  }

  @Override
  public void setController(Controller newController) {
    controller = newController;
  }

  @Override
  public void setGame(FinalReality game) {
    aGame = game;
  }

  public abstract void initialize ();

  public abstract void update ();

  @Override
  public Group getRoot() {
    return root;
  }
}
