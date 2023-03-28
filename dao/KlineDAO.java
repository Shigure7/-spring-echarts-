package edu.imu.display.dao;

import edu.imu.display.bean.Kline;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KlineDAO {
    @Select("select * from stock")
    List<Kline> findK();
}
