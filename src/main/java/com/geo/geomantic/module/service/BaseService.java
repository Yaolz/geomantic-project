package com.geo.geomantic.module.service;

import com.geo.geomantic.module.dao.BaseDao;
import com.geo.geomantic.module.pojo.DataEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author zyz
 * @date 2018/12/15
 */
public abstract class BaseService<D extends BaseDao<T>, T extends DataEntity> {

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public T get(String id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public T get(T entity) {
        return dao.queryBy(entity);
    }

    /**
     * 查询列表数据
     *
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return dao.queryList(entity);
    }

    /**
     * 查询分页数据
     *
     * @param entity
     * @return
     */
    public PageInfo<T> findPage(T entity) {
// 设置分页
        PageHelper.startPage(entity.getPageNo(), entity.getPageSize());
        List<T> noticeList = dao.queryList(entity);
        // 返回数据
        PageInfo<T> p = new PageInfo<>(noticeList);
        return p;
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param entity
     */
    public void save(T entity) {
        if (StringUtils.isEmpty(entity.getId())) {
            entity.setCreateDate(new Date());
            entity.setUpdateDate(new Date());
            dao.insert(entity);
        } else {
            entity.setUpdateDate(new Date());
            dao.update(entity);
        }
    }

    /**
     * 删除数据
     *
     * @param entity
     */
    public void delete(T entity) {
        dao.delete(entity);
    }

}
