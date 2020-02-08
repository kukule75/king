package singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kinden
 *
 * 枚举
 */
public enum  IdGeneratorE {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() { return id.incrementAndGet(); }
}
