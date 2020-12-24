package com.github.cc3002.finalreality.gui.views;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.gui.FinalReality;
import javafx.scene.Group;

/**
 * Common methods for all views.
 */
public abstract class AbstractView implements IView {
  protected Group root;
  protected Controller controller;
  protected FinalReality aGame;

  @Override
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

  @Override
  public abstract void initialize ();

  @Override
  public abstract void update ();

  @Override
  public Group getRoot() {
    return root;
  }
}
