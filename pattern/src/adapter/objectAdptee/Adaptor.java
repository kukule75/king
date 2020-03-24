package adapter.objectAdptee;

/**
 * @author louis.yu
 */
public class Adaptor implements ITarget{

    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa(); //委托给Adaptee
    }

    @Override
    public void f2() {
        //...重新实现f2()...
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
