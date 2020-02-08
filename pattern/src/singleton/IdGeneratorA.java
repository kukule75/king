package singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kinden
 *
 * 饿汉式
 *
 * 加载时长比较长的场景，比如从数据库加载配置信息
 * 或者怀疑占用资源大的场景，提早暴露问题，fail-fast
 */
public class IdGeneratorA {

    private IdGeneratorA(){ }

    private AtomicInteger id = new AtomicInteger(0);

    private static final IdGeneratorA instance = new IdGeneratorA();

    public static IdGeneratorA getInstance() {
        return instance;
    }

    public Integer getId() {
        return id.incrementAndGet();
    }
}
