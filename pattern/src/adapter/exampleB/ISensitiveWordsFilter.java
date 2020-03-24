package adapter.exampleB;

/**
 * @author louis.yu
 *
 * 使用适配器模式进行改造
 *
 * 某个功能的实现依赖多个外部系统（或者说类）。通过适配器模式，将它们的接口适配为统一的接口定义，
 * 然后我们就可以使用多态的特性来复用代码逻辑。具体我还是举个例子来解释一下。
 */
public interface ISensitiveWordsFilter {

    String filter(String text);
}
