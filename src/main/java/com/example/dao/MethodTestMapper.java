package com.example.dao;

import org.apache.ibatis.annotations.Param;

public interface MethodTestMapper {

    void insertTest(@Param("content") String content);
}
