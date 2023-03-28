package edu.imu.display.service;


import edu.imu.display.bean.Radar;
import edu.imu.display.bean.Radar1;
import edu.imu.display.dao.radarDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RadarService {
    @Resource
    public radarDAO dao;

    public Radar1 findData(){
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        List<Radar> list = dao.findRadar();
        for(Radar radar : list){
            radar.set();
            aList.addAll(radar.geta());
            bList.addAll(radar.getb());
        }
        Radar1 R = new Radar1();
        R.setA(aList);
        R.setB(bList);
        return R;
    }
}
