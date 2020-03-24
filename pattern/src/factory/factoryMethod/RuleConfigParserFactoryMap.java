package factory.factoryMethod;

import factory.factoryMethod.impl.JsonRuleConfigParserFactory;
import factory.factoryMethod.impl.PropertiesRuleConfigParserFactory;
import factory.factoryMethod.impl.XmlRuleConfigParserFactory;
import factory.factoryMethod.impl.YamlRuleConfigParserFactory;
import factory.factoryMethod.inter.IRuleConfigParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kinden
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }
}
