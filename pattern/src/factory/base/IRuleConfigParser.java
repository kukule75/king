package factory.base;

import factory.base.RuleConfig;

/**
 * @author kinden
 */
public interface IRuleConfigParser{

    RuleConfig parse(String configText);
}
