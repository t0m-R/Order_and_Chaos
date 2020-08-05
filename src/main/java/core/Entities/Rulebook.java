package core.Entities;

import core.Rules.Rule;
import java.util.function.Supplier;

public class Rulebook {

    private Rulebook() {}

    public static boolean queryRule(StateManager gameState, Supplier<Rule> ruleSupplier) {
        return ruleSupplier.get().isValid(gameState);
    }

}
