package factory.factoryMethod.impl;

import factory.base.IRuleConfigParser;
import factory.factoryMethod.inter.IRuleConfigParserFactory;
import factory.base.impl.XmlRuleConfigParser;

/**
 * @author kinden
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
