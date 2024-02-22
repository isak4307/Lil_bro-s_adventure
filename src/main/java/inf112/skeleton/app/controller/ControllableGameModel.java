package inf112.skeleton.app.controller;

import inf112.skeleton.app.model.GameState;
import inf112.skeleton.app.model.GameStateGettable;
import inf112.skeleton.app.model.Stepable;

public interface ControllableGameModel extends GameStateGettable, Stepable {
    /**
     * @return {@link ControllablePlayerModel} of the model
     */
    ControllablePlayerModel getControllablePlayer();

    /**
     * Sets the current {@link GameState}
     * @param state the new {@link GameState}
     */
    void setState(GameState state);
}
