package com.practice.patterns.builder;

/**
 * Created by shankark on 22/12/16.
 */
public class House {

    private int size;
    private String facing;
    private int cost;

    private String houseWiring;
    private String tiles;
    private String paint;

    public String getHouseWiring() {
        return houseWiring;
    }

    public void setHouseWiring(String houseWiring) {
        this.houseWiring = houseWiring;
    }

    public String getTiles() {
        return tiles;
    }

    public void setTiles(String tiles) {
        this.tiles = tiles;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }
}
