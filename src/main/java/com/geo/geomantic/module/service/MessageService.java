package com.geo.geomantic.module.service;

import java.util.List;

import com.geo.geomantic.module.pojo.Message;
import com.github.pagehelper.PageInfo;

/**
 * 反馈管理Service
 * @author zyz
 * @version 2018-12-16
 */
public interface MessageService {

	Message get(String id);

    Message get(Message message);

    List<Message> findList(Message message);

    PageInfo<Message> findPage(Message message);

    void save(Message message);

    void delete(Message message);
		
}