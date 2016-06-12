package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        int distanceparam=(int)(this.distance-o.distance);
        int qualityparam = this.quality-o.quality;
        return  1000 * this.name.compareTo(o.name)+100*distanceparam+10*qualityparam;

    }

    public static void main(String[] args)
    {
        Beach beach1 = new Beach("first",1,2);
        Beach beach2 = new Beach("second",2,1);
        Beach beach3 = new Beach("third",4,5);

        System.out.println(beach2.compareTo(beach1));

    }
}
