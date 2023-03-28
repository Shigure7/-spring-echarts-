package edu.imu.display.dao;

import edu.imu.display.bean.Radar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface radarDAO {
    @Select("select a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6 from radar ORDER BY RAND() LIMIT 1")
    List<Radar> findRadar();
}
