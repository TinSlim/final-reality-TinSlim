package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import javafx.scene.Group;

public interface IView {
  void setRoot(Group grupo);

  void setController(Controller controller);

  void setGame(FinalReality finalReality);

  void initialize();

  void update();

  Group getRoot();
}
