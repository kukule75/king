package factory.factoryMethod.impl;

import factory.base.IRuleConfigParser;
import factory.factoryMethod.inter.IRuleConfigParserFactory;
import factory.base.impl.JsonRuleConfigParser;

/**
 * @author kinden
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
