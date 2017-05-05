package app;

import app.annotations.Burnable;
import app.annotations.Recyclable;
import app.annotations.Storable;
import app.core.DefaultProcessSystem;
import app.core.ProcessorSystem;
import app.engines.Engine;
import app.interpreters.CommandInterpreter;
import app.interpreters.Interpreter;
import app.io.readers.ConsoleReader;
import app.io.readers.Reader;
import app.io.writers.ConsoleWriter;
import app.io.writers.Writer;
import app.strategies.StrategyBurnable;
import app.strategies.StrategyRecycleable;
import app.strategies.StrategyStorable;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.StrategyHolder;


public class Main {
    public static void main(String[] args) {
        StrategyHolder holder = new DefaultStrategyHolder();
        holder.addStrategy(Burnable.class, new StrategyBurnable());
        holder.addStrategy(Recyclable.class, new StrategyRecycleable());
        holder.addStrategy(Storable.class, new StrategyStorable());


        GarbageProcessor processor = new DefaultGarbageProcessor(holder);
        ProcessorSystem system = new DefaultProcessSystem(processor);
        Interpreter interpreter = new CommandInterpreter(system);
        Writer writer = new ConsoleWriter();
        Reader reader = new ConsoleReader();
        Runnable engine = new Engine(interpreter, reader, writer);
        engine.run();
    }
}
