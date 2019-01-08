package com.geo.geomantic.common.web;

import com.geo.geomantic.common.constant.RedisEnum;
import com.geo.geomantic.common.utils.RedisUtil;
import com.geo.geomantic.module.pojo.Dict;
import com.geo.geomantic.module.pojo.User;
import com.geo.geomantic.module.service.DictService;
import com.geo.geomantic.module.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @date 2019/1/7
 * 封装的redis方法Service
 */
@Component
public class RedisRepository {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private DictService dictService;

    @Autowired
    private UserService userService;

    /**
     * 输入类型和数据值匹配对应的标签名
     *
     * @param type
     * @param value
     * @return
     */
    public String getDictLabelByTypeAndValue(String type, String value) {
        String label = "";
        List<Dict> dictList = (List<Dict>) redisUtil.get(RedisEnum.REDIS_DICT.getKey() + type);
        if (dictList != null) {
            for (Dict dict : dictList) {
                if (dict.getValue().equals(value)) {
                    label = dict.getLabel();
                }
            }
        }
        return label;
    }

    /**
     * 根据类型查找对应的数据
     *
     * @param type
     * @return
     */
    public List<Dict> getDictLabelByType(String type) {
        List<Dict> dictList;
        Object dictRedis = redisUtil.get(RedisEnum.REDIS_DICT.getKey() + type);
        if (dictRedis != null) {
            dictList = (List<Dict>) dictRedis;
        } else {
            Dict dict = new Dict();
            dict.setType(type);
            dictList = dictService.findList(dict);
            redisUtil.set(RedisEnum.REDIS_DICT.getKey() + type, dictList);
        }
        return dictList;
    }

    public User getUserById(String id) {
        User user = userService.get(id);
        return user;
    }

}
