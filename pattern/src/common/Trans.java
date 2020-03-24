package common;

/**
 * @author louis.yu
 */
public class Trans {

    //交易的唯一标识
    private long transNo;

    private long createTime;
    private long transTime;
    private String avatarUrl;
    private Address address;
    // ...
}

class Address{
    private String provinceOfAddress; // 省
    private String cityOfAddress; // 市
    private String regionOfAddress; // 区
    private String detailedAddress; // 详细地址
}

