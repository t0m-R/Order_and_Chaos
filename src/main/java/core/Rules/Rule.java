package core.Rules;

import core.Entities.StateManager;


public interface Rule {

    boolean isValid(StateManager gameState);

}
