package com.github.cc3002.finalreality.gui.views;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.gui.FinalReality;
import javafx.scene.Group;

/**
 * View interface, views changes the actual visible things in the principal game.
 */
public interface IView {

  /**
   * Sets a root for this view.
   * @param newRoot new root for this view.
   */
  void setRoot(Group newRoot);

  /**
   * Sets a controller for this view.
   * @param controller controller used by the view.
   */
  void setController(Controller controller);

  /**
   * Sets a main game to this view.
   * @param finalReality the actual game using this view.
   */
  void setGame(FinalReality finalReality);

  /**
   * Initializes nodes and adds them to the root.
   */
  void initialize();

  /**
   * Updates values for this view.
   */
  void update();

  /**
   * Returns the root of this view.
   * @return the root of this view.
   */
  Group getRoot();
}
