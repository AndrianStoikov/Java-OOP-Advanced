package app.waste_disposal;

import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {

    private Map<Class<?>, GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder() {
        this.strategies = new LinkedHashMap<>();
    }

    private boolean isDisposable(Class annotationClass) {
        Annotation[] garbageAnnotations = annotationClass.getAnnotations();
        for (Annotation annotation : garbageAnnotations) {
            if (annotation.annotationType().equals(Disposable.class)) {
                return true;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        if (strategy == null)
            throw new IllegalArgumentException("Null strategy passed");
        if (annotationClass == null)
            throw new IllegalArgumentException("Null annotation class passed");
        if(this.strategies.containsKey(annotationClass))
            return false;

        if (this.isDisposable(annotationClass)) {
            this.strategies.put(annotationClass, strategy);
            return true;
        }

        return false;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        if (this.strategies.containsKey(annotationClass)) {
            this.strategies.remove(annotationClass);
            return true;
        }

        return false;
    }
}
