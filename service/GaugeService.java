package edu.imu.display.service;
import edu.imu.display.bean.Gauge;
import edu.imu.display.dao.GaugeDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class GaugeService {
    @Resource
    public GaugeDAO dao;

    public Gauge findScore(){
        int p = dao.findScore();
        Gauge gauge = new Gauge();
        gauge.setId(p);
        return gauge;
    }
}
