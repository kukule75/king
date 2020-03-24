package ocp;

/**
 * @author louis.yu
 */
public class Demo {

    public static void main(String[] args) {

        ApiStatInfo apiStatInfo = new ApiStatInfo();
        apiStatInfo.setTimeoutCount(289);
        // ...省略设置apiStatInfo数据值的代码
        AlertContext.getInstance().getAlert().check(apiStatInfo);
    }
}
