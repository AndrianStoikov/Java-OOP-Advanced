package tests;

import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.fakes.DisposableAnnotation;
import tests.fakes.DisposableStrategy;
import tests.fakes.NonDisposableAnnotation;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Andrian on 22.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class DefaultStrategyHolderTest {

    private StrategyHolder holder;
    private GarbageDisposalStrategy mockedStrategy;

    @Before
    public void setUp() {
        this.holder = new DefaultStrategyHolder();
        this.mockedStrategy = Mockito.mock(GarbageDisposalStrategy.class);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void returnAReadOnlyCollection() {
        Map<Class,GarbageDisposalStrategy> strategies = this.holder.getDisposalStrategies();
        strategies.put(DisposableAnnotation.class, new DisposableStrategy());
        strategies.remove(DisposableAnnotation.class);
    }

    @Test
    public void getDisposableStrategiesShouldReturnZeroSizeMap() {
        Assert.assertEquals("Map with different than 0 size returned.", 0,
                this.holder.getDisposalStrategies().size());
    }

    @Test
    public void addValidDisposableAnnotationShouldReturnTrue() {
        Assert.assertEquals("Invalid false value returned", true,
                this.holder.addStrategy(DisposableAnnotation.class, new DisposableStrategy()));
    }

    @Test
    public void addValidDisposableAnnotationShouldIncreaseSize() {

        Assert.assertEquals("Should start with zero size",
                0,
                this.holder.getDisposalStrategies().size());

        this.holder.addStrategy(DisposableAnnotation.class, new DisposableStrategy());

        Assert.assertEquals("Adding mockedStrategy should increase size.",
                1,
                this.holder.getDisposalStrategies().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addInvalidDisposableAnnotationShouldReturnFalse() {
        Assert.assertEquals("Invalid true value returned", false,
                this.holder.addStrategy(NonDisposableAnnotation.class, new DisposableStrategy()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullDisposableAnnotationShouldReturnFalse() {
        Assert.assertEquals("Invalid true value returned", false,
                this.holder.addStrategy(null, new DisposableStrategy()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullDisposableStrategyShouldReturnFalse() {
        Assert.assertEquals("Invalid true value returned", false,
                this.holder.addStrategy(DisposableAnnotation.class, null));
    }

    @Test
    public void addValidExistingAnnotationShouldReturnFalse() {

        this.holder.addStrategy(DisposableAnnotation.class, new DisposableStrategy());

        boolean result = this.holder.addStrategy(DisposableAnnotation.class, new DisposableStrategy());

        Assert.assertEquals(false, result);
    }

    @Test
    public void addValidAnnotationShouldReturnCorrectResults() {
        this.holder.addStrategy(DisposableAnnotation.class, this.mockedStrategy);
        Map<Class, GarbageDisposalStrategy> expected = new LinkedHashMap<>();
        expected.put(DisposableAnnotation.class, new DisposableStrategy());
        GarbageDisposalStrategy result = this.holder.getDisposalStrategies().get(DisposableAnnotation.class);
        Assert.assertEquals(this.mockedStrategy, result);
    }

    @Test
    public void removeValidStrategyShouldReturnTrue() {
        this.holder.addStrategy(DisposableAnnotation.class, new DisposableStrategy());
        Assert.assertEquals("False returned", true,
                this.holder.removeStrategy(DisposableAnnotation.class));
    }

    @Test
    public void removeValidStrategyShouldDecreaseSize() {
        this.holder.addStrategy(DisposableAnnotation.class, new DisposableStrategy());
        this.holder.removeStrategy(DisposableAnnotation.class);
        Assert.assertEquals("Value didn't decrease", 0,
                this.holder.getDisposalStrategies().size());
    }

    @Test
    public void removeInvalidStrategyShouldReturnFalse() {
        this.holder.addStrategy(DisposableAnnotation.class, new DisposableStrategy());
        this.holder.removeStrategy(NonDisposableAnnotation.class);
        Assert.assertEquals("True returned", false,
                this.holder.removeStrategy(NonDisposableAnnotation.class));
    }

    @Test
    public void removeInvalidStrategyShouldntDecreaseSize() {
        this.holder.addStrategy(DisposableAnnotation.class, new DisposableStrategy());
        this.holder.removeStrategy(NonDisposableAnnotation.class);
        Assert.assertEquals("True returned", 1,
                this.holder.getDisposalStrategies().size());
    }

    @Test
    public void shouldReturnFalseWhenRemovingFromEmptyHolder() {
        boolean result = this.holder.removeStrategy(DisposableAnnotation.class);

        Assert.assertEquals("Operation returned incorrect result!", false, result);
    }
}