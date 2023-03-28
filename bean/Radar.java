package edu.imu.display.bean;

import java.util.ArrayList;
import java.util.List;

public class Radar {
    private int a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6;
    private List<Integer> lista=new ArrayList<>();
    private List<Integer> listb=new ArrayList<>();
    public void set()
    {
        this.lista.add(a1);
        this.lista.add(a2);
        this.lista.add(a3);
        this.lista.add(a4);
        this.lista.add(a5);
        this.lista.add(a6);
        this.listb.add(b1);
        this.listb.add(b2);
        this.listb.add(b3);
        this.listb.add(b4);
        this.listb.add(b5);
        this.listb.add(b6);
    }

    public List<Integer> geta() {
        return lista;
    }
    public List<Integer> getb() {
        return listb;
    }
}
