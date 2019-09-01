package cn.yihu.microboot.vo.store;

public class XeUserAddress {
    private String id;

    private String userId;

    private String consignee;

    private String province;

    private String city;

    private String county;

    private String street;

    private String tel;

    private String postcode;

    public XeUserAddress(String id, String userId, String consignee, String province, String city, String county, String street, String tel, String postcode) {
        this.id = id;
        this.userId = userId;
        this.consignee = consignee;
        this.province = province;
        this.city = city;
        this.county = county;
        this.street = street;
        this.tel = tel;
        this.postcode = postcode;
    }

    public XeUserAddress() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }
}