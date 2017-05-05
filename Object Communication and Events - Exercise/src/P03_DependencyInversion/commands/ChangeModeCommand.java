package P03_DependencyInversion.commands;

import P03_DependencyInversion.PrimitiveCalculator;
import P03_DependencyInversion.factories.StrategyFactory;
import P03_DependencyInversion.strategies.Strategy;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class ChangeModeCommand implements Command {
    private String[] data;
    private PrimitiveCalculator calculator;

    public ChangeModeCommand(String[] data, PrimitiveCalculator calculator) {
        this.data = data;
        this.calculator = calculator;
    }

    @Override
    public String execute() {
        Strategy strategy = StrategyFactory.create(this.data[1]);
        this.calculator.changeStrategy(strategy);
        return "";
    }
}
