package adapter.exampleB;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author louis.yu
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{

    @Autowired
    private ASensitiveWordsFilter aFilter;

    @Override
    public String filter(String text) {

        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(maskedText);

        return maskedText;
    }
}
