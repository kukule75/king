package singleton;

/**
 * @author kinden
 *
 * 双重检测，高版本Java不会有问题，低版本instance只要用volatile修饰，禁止重排序就可以
 */
public class IdGeneratorC {

    private IdGeneratorC(){}

    private static IdGeneratorC instance;

    public static IdGeneratorC getInstance(){

        if (instance == null) {
            synchronized (IdGeneratorC.class){
                if (instance == null) {
                    instance = new IdGeneratorC();
                }
            }
        }

        return instance;
    }
}
