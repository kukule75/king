package singleton;

/**
 * @author kinden
 *
 * 懒汉式，并发低
 */
public class IdGeneratorB {

    private IdGeneratorB(){}

    private static IdGeneratorB instance;

    public static synchronized IdGeneratorB getInstance() {
        if (instance == null) {
            instance = new IdGeneratorB();
        }

        return instance;
    }
}
