package adapter.exampleA;

/**
 * @author louis.yu
 *
 * 使用适配器模式进行重构, 封装有缺陷的接口设计
 *
 * 假设我们依赖的外部系统在接口设计方面有缺陷（比如包含大量静态方法），
 * 引入之后会影响到我们自身代码的可测试性。为了隔离设计上的缺陷，
 * 我们希望对外部系统提供的接口进行二次封装，抽象出更好的接口设计，
 * 这个时候就可以使用适配器模式了
 */
public interface ITarget {

    void function1();
    void function2();
    void fucntion3(ParamsWrapperDefinition paramsWrapper);
    void function4();
}
