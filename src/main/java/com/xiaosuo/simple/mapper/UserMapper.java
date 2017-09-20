package com.xiaosuo.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xiaosuo.simple.bean.TUser;

/**
 * user表的数据库操作
 * 
 * @author suozhaoyu
 * @since  0.0.1
 */
@Mapper
public interface UserMapper {

	/**
	 * 获取所有的用户
	 * 
	 * @return
	 */
	List<TUser> getTUserL();
	
	/**
	 * 添加数据
	 * 
	 * @return
	 */
	int insert(TUser user);
}
