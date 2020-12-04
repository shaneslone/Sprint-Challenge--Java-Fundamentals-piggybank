package com.lambdaschool.piggybank.models;

import javax.persistence.*;

@Entity
@Table(name = "Coins")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long coinid;

    private int numberofcoins;
    private double facevalue;
    private String name;
    private String nameplural;

    public Coin() {
    }

    public Coin(int numberofcoins, double facevalue, String name, String nameplural) {
        this.numberofcoins = numberofcoins;
        this.facevalue = facevalue;
        this.name = name;
        this.nameplural = nameplural;
    }

    public long getCoinid() {
        return coinid;
    }

    public void setCoinid(long coinid) {
        this.coinid = coinid;
    }

    public int getNumberofcoins() {
        return numberofcoins;
    }

    public void setNumberofcoins(int numberofcoins) {
        this.numberofcoins = numberofcoins;
    }

    public double getFacevalue() {
        return facevalue;
    }

    public void setFacevalue(double facevalue) {
        this.facevalue = facevalue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameplural() {
        return nameplural;
    }

    public void setNameplural(String nameplural) {
        this.nameplural = nameplural;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinid=" + coinid +
                ", numberofcoins=" + numberofcoins +
                ", facevalue=" + facevalue +
                ", name='" + name + '\'' +
                ", nameplural='" + nameplural + '\'' +
                '}';
    }
}
