package edu.imu.display.service;
import edu.imu.display.bean.Kline;
import edu.imu.display.dao.KlineDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class KlineService {
    @Resource
    public KlineDAO dao;
    public List<List<Float>> findK(){
        List<Kline> list = dao.findK();
        List<List<Float>> lists = new ArrayList<List<Float>>();
        for(Kline kline : list)
        {
            List<Float> temp = new ArrayList<>();
            temp.add(kline.getDate());
            temp.add(kline.getOpen());
            temp.add(kline.getClose());
            temp.add(kline.getLowest());
            temp.add(kline.getHighest());
            lists.add(temp);
        }
        return lists;
    }

}