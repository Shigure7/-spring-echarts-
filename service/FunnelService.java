package edu.imu.display.service;
import edu.imu.display.bean.FunnelData;
import edu.imu.display.dao.FunnelDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class FunnelService {
    @Resource
    public FunnelDAO dao;
    public List<FunnelData> findF(){
        List<FunnelData> list = dao.findFunnel();
        return list;
    }

}
