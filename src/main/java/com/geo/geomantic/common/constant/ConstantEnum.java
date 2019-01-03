package com.geo.geomantic.common.constant;

/**
 * @author zyz
 * @date 2019/1/3
 */
public enum ConstantEnum {
    REDIS_MENU("菜单树结构", "menu-tree", 0L);

    //说明
    private String explain;
    //    键值
    private String key;
    //    过期时间，如果不需要过期时间，给0L
    private long time;

    ConstantEnum(String explain, String key, long time) {
        this.explain = explain;
        this.key = key;
        this.time = time;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
