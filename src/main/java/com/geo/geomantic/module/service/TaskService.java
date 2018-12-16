package com.geo.geomantic.module.service;

import java.util.List;

import com.geo.geomantic.module.pojo.Task;
import com.github.pagehelper.PageInfo;

/**
 * 测算管理Service
 * @author zyz
 * @version 2018-12-16
 */
public interface TaskService {

	Task get(String id);

    Task get(Task task);

    List<Task> findList(Task task);

    PageInfo<Task> findPage(Task task);

    void save(Task task);

    void delete(Task task);
		
}