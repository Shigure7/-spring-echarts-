package edu.imu.display.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GaugeDAO {
    @Select("SELECT * FROM gauge ORDER BY RAND() LIMIT 1")
    int findScore();
}
