package cn.yihu.microboot.vo;

public class Reward {
    private String id;

    private String rewardname;

    private Integer value;

    private Integer day;

    public Reward(String id, String rewardname, Integer value, Integer day) {
        this.id = id;
        this.rewardname = rewardname;
        this.value = value;
        this.day = day;
    }

    public Reward() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRewardname() {
        return rewardname;
    }

    public void setRewardname(String rewardname) {
        this.rewardname = rewardname == null ? null : rewardname.trim();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}