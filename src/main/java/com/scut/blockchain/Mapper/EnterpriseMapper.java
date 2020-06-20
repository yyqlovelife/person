package com.scut.blockchain.Mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnterpriseMapper {
    public String getPassword(String id) throws Exception;
}
