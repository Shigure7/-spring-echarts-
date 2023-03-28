package edu.imu.display.service;
import edu.imu.display.bean.Heat;
import edu.imu.display.bean.Kline;
import edu.imu.display.dao.HeatDAO;
import edu.imu.display.dao.KlineDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class HeatService {
    @Resource
    public HeatDAO dao;
    public List<List<Integer>> findHeat(){
        List<Heat> list = dao.findH();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(Heat heat : list)
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(heat.getA());
            temp.add(heat.getB());
            temp.add(heat.getC());
            lists.add(temp);
        }
        return lists;
    }

}
