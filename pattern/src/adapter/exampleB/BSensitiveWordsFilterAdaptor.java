package adapter.exampleB;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author louis.yu
 */
public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{

    @Autowired
    private BSensitiveWordsFilter filter;

    @Override
    public String filter(String text) {

        return filter.filter(text);
    }
}
