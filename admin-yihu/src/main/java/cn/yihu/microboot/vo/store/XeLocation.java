package cn.yihu.microboot.vo.store;

public class XeLocation {
    private String id;

    private String lname;

    private Integer pid;

    private Integer sort;

    private Integer display;

    public XeLocation(String id, String lname, Integer pid, Integer sort, Integer display) {
        this.id = id;
        this.lname = lname;
        this.pid = pid;
        this.sort = sort;
        this.display = display;
    }

    public XeLocation() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }
}