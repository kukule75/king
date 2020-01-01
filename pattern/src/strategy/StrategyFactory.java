package strategy;

import strategy.impl.GoldStrategy;
import strategy.impl.OrdinaryStrategy;
import strategy.impl.PlatinumStrategy;
import strategy.impl.SilverStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kinden
 */
public class StrategyFactory {

    private Map<Integer, Strategy> strategyMap;

    private StrategyFactory() {

        List<Strategy> strategies = new ArrayList<>();

        strategies.add(new OrdinaryStrategy());
        strategies.add(new SilverStrategy());
        strategies.add(new GoldStrategy());
        strategies.add(new PlatinumStrategy());

        strategyMap = strategies.stream().collect(Collectors.toMap(Strategy::getType, strategy -> strategy));
    }

    private static class Holder{
        private static StrategyFactory instance = new StrategyFactory();
    }

    public static StrategyFactory getInstance() {
        return Holder.instance;
    }

    public Strategy get(int type) {
        Strategy strategy = strategyMap.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("none user type discount strategy");
        }

        return strategy;
    }
}
