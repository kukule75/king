package adapter.exampleB;

/**
 * @author louis.yu
 */
public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter{

    private CSensitiveWordsFilter filter;

    @Override
    public String filter(String text) {

        return filter.filter(text, "2");
    }
}
