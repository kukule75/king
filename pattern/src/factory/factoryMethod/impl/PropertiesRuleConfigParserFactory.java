package factory.factoryMethod.impl;

import factory.base.IRuleConfigParser;
import factory.factoryMethod.inter.IRuleConfigParserFactory;
import factory.base.impl.PropertiesRuleConfigParser;

/**
 * @author kinden
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
