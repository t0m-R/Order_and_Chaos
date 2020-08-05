package core.Entities;

import core.Rules.Rule;
import java.util.function.Supplier;

public class Rulebook {

    private Rulebook() {}

    public static boolean queryRule(StateManager gameManager, Supplier<Rule> ruleSupplier) {
        return ruleSupplier.get().isValid(gameManager);
    }

}
