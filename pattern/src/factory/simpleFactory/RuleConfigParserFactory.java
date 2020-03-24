package factory.simpleFactory;

import factory.base.impl.JsonRuleConfigParser;
import factory.base.impl.PropertiesRuleConfigParser;
import factory.base.impl.XmlRuleConfigParser;
import factory.base.impl.YamlRuleConfigParser;
import factory.base.IRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kinden
 */

public class RuleConfigParserFactory {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;//返回null还是IllegalArgumentException全凭你自己说了算
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}
