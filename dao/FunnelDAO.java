package edu.imu.display.dao;

import edu.imu.display.bean.FunnelData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FunnelDAO {
    @Select("select * from funnel order by value desc")
    List<FunnelData> findFunnel();
}
