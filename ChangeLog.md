ChangeLog
=========

Version 6.0
-----------
- (B.10) Code clean and added doc.
- (B.9) Added connections between model and controller.
- (B.8) Fixed phases.
- (B.7) Fixed tests.
- (B.6) Added WaitingPhase and Decision phase.
- (B.5) Fixed handlers.
- (B.4) Phases now are separated from the controller.
- (B.3) Start doing phases in the controller.
- (B.2) Added a way to play in the controller.
- (B.1) Added tests.

Version 5.0
-----------
- (B.14) Added doc to all methods.
- (B.13) Added more tests and fixed the others.
- (B.12) Added all getters for Controller class.
- (B.11) Added test for getMana and getMaxMana.
- (B.10) Added mana and maxMana getters to IPlayerCharacter. 
- (B.9) Made a listener to alert when a turn finishes.
- (B.8) Added methods to get data from characters.
- (B.7) Added methods to equip weapons and lists to save characters.
- (B.6) Fixed methods to make characters and weapons (added to Controller).
- (B.5) Added listeners to know if a character dies.
- (B.4) Fixed tests for Controller class.
- (B.3) Added methods to Controller to make characters and weapons with another class.
- (B.2) Added tests for Controller class.
- (B.1) Controller class added.

Version 4.0
-----------
- (B.4) More code clean.
- (B.3) Code clean on tests.
- (B.2) A character who died can't receive damage or equip weapons.
- (B.1) Now the defense attribute appears when a character receives damage.

Version 3.0
-----------
- (RC.1) Finished test classes. 
- (B.13) Code clean.
- (B.12) Added inventory tests.
- (B.11) Added Hash and Equals methods and their tests.
- (B.10) Improved inheritance in all tests.
- (B.9) Added tests to mage character classes.
- (B.8) Added tests to common character classes.
- (B.7) Minor fixes to magic attacks (damage and probability). 
- (B.6) Improved inheritance between test classes. 
- (B.5) Added tests to Enemy class. 
- (B.4) Fixed magic attacks, now cast comes with magic attack.
- (B.3) Added inheritance between PlayerCharacter classes.
- (B.2) Added tests to all PlayerCharacter classes.
- (B.1) Fixed wait turn method.

Version 2.0
-----------
- (RC.1) Finished the order of classes, improved a lot o methods and added description to the methods. 
- (B.8) Now the inventory can storage weapons.
- (B.7) Fixed attacks, now the characters can fight.
- (B.6) Now the weapons can be equipped to PlayerCharacters. 
- (B.5) Fixed and improved the magic attacks.
- (B.4) Added inventory.
- (B.3) Added weapon classes.
- (B.2) Added magic to mages.
- (B.1) Added mages and common characters.

Version 1.0
-----------
- (RC.1) Implemented missing tests
- (B.5) Updated License
- (B.4) Implementation and testing of Enemy class (ensured 100% branch coverage)
- (B.3) Created .gitignore
- (B.2) Implementation of most base elements of the model
- (B.1) Created project

A note on the version naming
----------------------------
- B.n: Version ``x.y`` _beta x_, alternative to ``x.y-b.n``.
  For example: ``v1.0-b.3``.
- RC.n: Release candidate x, alternative to ``x.y-rc.n``.
  For example: ``v1.0-rc.2``.