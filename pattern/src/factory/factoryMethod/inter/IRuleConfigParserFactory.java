package factory.factoryMethod.inter;

import factory.base.IRuleConfigParser;

/**
 * @author kinden
 */
public interface IRuleConfigParserFactory {

    IRuleConfigParser createParser();
}
