package adapter.exampleC;

/**
 * @author louis.yu
 *
 * 在我们的项目中，外部系统A的使用示例
 */
public class Demo {

    private IA a;

    public Demo(IA a) {
        this.a = a;
    }


    // 借助BAdaptor，Demo的代码中，调用IA接口的地方都无需改动，只需要将BAdaptor如下注入到Demo即可。
    public static void main(String[] args) {

        Demo d = new Demo(new A());

        Demo e = new Demo(new BAdaptor(new B()));
    }
}
