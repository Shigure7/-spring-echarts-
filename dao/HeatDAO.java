package edu.imu.display.dao;

import edu.imu.display.bean.Heat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HeatDAO {
    @Select("select * from heat")
    List<Heat> findH();
}
