package factory.factoryMethod.impl;

import factory.base.IRuleConfigParser;
import factory.factoryMethod.inter.IRuleConfigParserFactory;
import factory.base.impl.YamlRuleConfigParser;

/**
 * @author kinden
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
