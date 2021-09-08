package com.practice.practicedyusov;

public class Light {
    private int id; // идентификатор
    private String hue; // цветовой тон 
    private int power; // потребляемая мощность 
    private int lux; // освещенность в люксах (lux)
    private int lifeTime; // срок службы в часах

    Light() {} // конструктор по умолчанию
    Light(int id, String hue, int power, int lux, int lifeTime) {
        this.setId(id);
        this.setHue(hue);
        this.setPower(power);
        this.setLux(lux);
        this.setLifeTime(lifeTime);
    }
    public int getId() {
        return id;
    }
    public String getHue() {
        return hue;
    }
    public int getPower() {
        return power;
    }
    public int getLux() {
        return lux;
    }
    public int getLifeTime() {
        return lifeTime;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setHue(String hue) {
        this.hue = hue;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public void setLux(int lux) {
        this.lux = lux;
    }
    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }
}
