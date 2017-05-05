package tests;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.contracts.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.fakes.DisposableAnnotation;
import tests.fakes.DisposableWaste;
import tests.fakes.NonDisposableWaste;
import tests.fakes.NotAnnotatedWaste;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Andrian on 22.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class DefaultGarbageProcessorTest {
    private final Map<Class, GarbageDisposalStrategy> strategyMap = new LinkedHashMap<>();

    private StrategyHolder holder;
    private GarbageProcessor processor;
    private GarbageDisposalStrategy strategy;
    private ProcessingData data;

    @Before
    public void setUp() throws Exception {
        this.holder = Mockito.mock(StrategyHolder.class);
        this.strategy = Mockito.mock(GarbageDisposalStrategy.class);
        this.strategyMap.put(DisposableAnnotation.class, this.strategy);
        this.processor = new DefaultGarbageProcessor(this.holder);
        this.data = Mockito.mock(ProcessingData.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void initializeGarbageProcessorWithNullShouldThrowException() {
        this.processor = new DefaultGarbageProcessor(null);
    }

    @Test
    public void getStrategyHolderShouldGetTheRightStrategy() {
        StrategyHolder result = this.processor.getStrategyHolder();
        Assert.assertEquals("Invalid holder returnded", this.holder, result);
    }

    @Test
    public void processDisposableWaste() {
        Mockito.when(this.holder.getDisposalStrategies())
                .thenReturn(this.strategyMap);
        Mockito.when(this.strategy.processGarbage(Mockito.isA(DisposableWaste.class)))
                .thenReturn(this.data);
        ProcessingData result =
                this.processor.processWaste(new DisposableWaste());
        Assert.assertEquals("Invalid data returned",this.data, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void processNotAnnotatedWasteShouldProduceException() {
        Mockito.when(this.holder.getDisposalStrategies())
                .thenReturn(this.strategyMap);
        ProcessingData result =
                this.processor.processWaste(new NotAnnotatedWaste());
        Assert.assertEquals(this.data, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void processNonDisposableWasteShouldProduceException() {
        Mockito.when(this.holder.getDisposalStrategies())
                .thenReturn(this.strategyMap);
        ProcessingData result =
                this.processor.processWaste(new NonDisposableWaste());
        Assert.assertEquals(this.data, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void processNullWasteShouldProduceException() {
        Mockito.when(this.holder.getDisposalStrategies())
                .thenReturn(this.strategyMap);
        ProcessingData result =
                this.processor.processWaste(new NonDisposableWaste());
        Assert.assertEquals(this.data, result);
    }
}