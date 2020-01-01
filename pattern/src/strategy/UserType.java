package strategy;

/**
 * @author kinden
 */
public enum UserType {

    ORDINARY_VIP(0),
    SILVER_VI(1),
    GOLD_VIP(2),
    PLATINUM_VIP(3);

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    UserType(int code) {
        this.code = code;
    }

}
