package edu.imu.display.controller;

import edu.imu.display.bean.*;
import edu.imu.display.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@RestController
public class Visualization {
    @Autowired
    private RadarService service1;
    @Autowired
    private GaugeService service2;
    @Autowired
    private FunnelService service3;

    @Autowired
    private HeatService service4;

    @RequestMapping("/avgdegree")
    public Bar avgDegree() throws IOException {
        FileReader fileReader = new FileReader("D://result//avgdegree.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        Bar bar = new Bar();
        ArrayList<String> xList = new ArrayList<>();
        ArrayList<Float> yList = new ArrayList<>();
        while(!StringUtils.isEmpty(line)){
            String[] items = line.split("\t");
            xList.add(items[0]);
            yList.add(Float.parseFloat(items[1]));
            line = bufferedReader.readLine();
        }
        bar.setX(xList);
        bar.setY(yList);
        bufferedReader.close();
        fileReader.close();
        return bar;
    }

    @RequestMapping("/gauge")
    public Gauge getScore() throws IOException {
        return service2.findScore();
    }

    @RequestMapping("/radar")
    public Radar1 getdata() throws IOException {
        return service1.findData();
    }
    @RequestMapping("/funnel")
    public List<FunnelData> getFunnel() throws IOException {
        return service3.findF();
    }

    @RequestMapping("/heatmap")
    public List<List<Integer>> getH() throws IOException {
        return service4.findHeat();
    }

    @RequestMapping("/relationship")
    public RelationShip relationShip() throws IOException {
        // 读取文件
        FileReader fileReader = new FileReader("D://result.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        int nodeCount = 0;
        // 初始化返回值对象
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new TreeSet<>();
        RelationShip relationShip = new RelationShip();
        ArrayList<Node> nodeList = new ArrayList<>();
        ArrayList<Link> linkList = new ArrayList<>();
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        // 读取数据
        while(!StringUtils.isEmpty(line)){
            String[] parts = line.split("\t");
            // 读取节点数据
            String[] nodeParts = parts[0].split("#");
            Node node = new Node();
            node.setCategory(Integer.parseInt(nodeParts[0]));
            node.setName(nodeParts[1]);
            node.setValue(Math.round(Double.parseDouble(nodeParts[2]) * 10));
            map.put(node.getName(), nodeCount);
            nodeList.add(node);
            // 读取分类数据
            if(!set.contains(nodeParts[0])) {
                Category category = new Category();
                category.setBase(nodeParts[0]);
                category.setName(nodeParts[0]);
                categoryArrayList.add(category);
                set.add(nodeParts[0]);
            }
            // 读取链接数据
            String[] linkParts = parts[1].split(";");
            String source = node.getName();
            for(String linkStr : linkParts){
                String[] items = linkStr.split(":");
                Link link = new Link();
                link.setSource(map.get(source));
                Integer targetId = map.get(items[0]);
                if(targetId == null){
                    map.put(items[0], ++nodeCount);
                    targetId = nodeCount;
                }
                link.setTarget(targetId);
                link.setValue(Double.parseDouble(items[1]));
                linkList.add(link);

            }
            line = bufferedReader.readLine();
        }
        relationShip.setLinks(linkList);
        relationShip.setNodes(nodeList);
        relationShip.setCategories(categoryArrayList);
        relationShip.setLegends(new ArrayList(set));
        return relationShip;
    }
    /**
     * 大数据专利分析结果可视化展示Controller
     */
    @RequestMapping("/patent")
    public List<Patent> getPatents() throws IOException {
        // 读取文件
        FileReader fileReader = new FileReader("D://result//combiner.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        ArrayList<Patent> list = new ArrayList<>();
        int others = 0;
        while(!StringUtils.isEmpty(line)) {
            String[] parts = line.split("\t");
            String name = parts[0];
            int value = Integer.parseInt(parts[1]);
            if(value > 1000) {
                Patent patent = new Patent();
                patent.setName(name);
                patent.setValue(value);
                list.add(patent);
            }else{
                others += value;
            }
            line = bufferedReader.readLine();
        }
        Patent patent = new Patent();
        patent.setName("Others");
        patent.setValue(others);
        list.add(patent);
        bufferedReader.close();
        fileReader.close();
        return list;
    }
    @RequestMapping("/topn")
    public Bar TopN() throws IOException {
        FileReader fileReader = new FileReader("D://result//topn.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        Bar bar = new Bar();
        ArrayList<String> xList = new ArrayList<>();
        ArrayList<Float> yList = new ArrayList<>();
        while(!StringUtils.isEmpty(line)){
            String[] items = line.split("\t");
            xList.add(items[0]);
            yList.add(Float.parseFloat(items[1]));
            line = bufferedReader.readLine();
        }
        bar.setX(xList);
        bar.setY(yList);
        return bar;
    }
    @RequestMapping("/topnscatter")
    public Bar TopNScatter() throws IOException {
        FileReader fileReader = new FileReader("D://result//topn.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        Bar bar = new Bar();
        ArrayList<String> xList = new ArrayList<>();
        ArrayList<Float> yList = new ArrayList<>();
        while(!StringUtils.isEmpty(line)){
            String[] items = line.split("\t");
            xList.add(items[0]);
            yList.add(Float.parseFloat(items[1]));
            line = bufferedReader.readLine();
        }
        bar.setX(xList);
        bar.setY(yList);
        return bar;
    }
}
