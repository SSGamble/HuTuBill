package com.td.service;

import com.td.dao.ConfigDAO;
import com.td.entity.Config;

/**
 * ConfigService 设置业务类，这个类是监听器直接调用的类，然后再通过 ConfigService 去调用 ConfigDAO
 */
public class ConfigService {

    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";

    static ConfigDAO dao = new ConfigDAO();

    static {
        init();
    }

    /**
     * 因为设置信息里有两个数据，一个是预算，一个是 Mysql 路径。
     * 这两个信息，无论如何都应该是存在数据库中的，所以会调用 init 把他们俩初始化。
     */
    public static void init() {
        init(budget, default_budget);
        init(mysqlPath, "");
    }

    /**
     * 首先根据 key 去查找，如果不存在，就使用 value 的值插入一条数据
     * @param key
     * @param value
     */
    private static void init(String key, String value) {
        Config config = dao.getByKey(key);
        if (config == null) {
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);
        }
    }

    /**
     * 根据键获取相应的值
     * @param key
     * @return
     */
    public String get(String key) {
        Config config = dao.getByKey(key);
        return config.getValue();
    }

    /**
     * 更新键对应的值
     * @param key
     * @param value
     */
    public void update(String key, String value) {
        Config config = dao.getByKey(key);
        config.setValue(value);
        dao.update(config);
    }

    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }

}