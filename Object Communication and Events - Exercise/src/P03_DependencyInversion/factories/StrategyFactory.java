package P03_DependencyInversion.factories;

import P03_DependencyInversion.strategies.*;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class StrategyFactory {
    public static Strategy create(String character) {
        switch (character) {
            case "+": return new AdditionStrategy();
            case "-": return new SubtractionStrategy();
            case "/": return new DelenieStrategy();
            case "*": return new MultipStrategy();
        }

        throw new IllegalArgumentException("Invalid mode passed");
    }
}
