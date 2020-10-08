package com.learn.blog.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.blog.POJO.Account;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper extends BaseMapper<Account>{}
