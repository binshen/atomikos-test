package com.giant.mapper;

import com.giant.model.Wallet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface WalletMapper {

    @Insert("INSERT INTO wallet (uid, money) VALUES (#{uid}, #{money})")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", keyColumn="id", resultType=int.class, before=false)
    int insertWallet(Wallet wallet);
}
