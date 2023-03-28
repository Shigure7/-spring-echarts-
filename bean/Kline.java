package edu.imu.display.bean;

public class Kline {
    private float date,open,close,lowest,highest;

    public float getDate() {
        return date;
    }

    public void setDate(float date) { this.date= date;}

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getClose() {return close;}

    public void setClose(float close) {
        this.close = close;
    }

    public float getLowest() {
        return lowest;
    }

    public void setLowest(float lowest) {
        this.lowest = lowest;
    }

    public float getHighest() {
        return highest;
    }

    public void setHighest(float highest) {
        this.highest = highest;
    }
}
