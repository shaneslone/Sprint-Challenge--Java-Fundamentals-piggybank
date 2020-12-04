package com.lambdaschool.piggybank.models;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long coinid;

    private String name;
    private String nameplural;
    private double value;
    private int quantity;

    public Coin() {
    }

    public Coin(String name, String nameplural, double value, int numberofcoins) {
        this.coinid = coinid;
        this.name = name;
        this.nameplural = nameplural;
        this.value = value;
        this.quantity = numberofcoins;
    }

    public long getCoinid() {
        return coinid;
    }

    public void setCoinid(long coinid) {
        this.coinid = coinid;
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

    public double getValue() {
        return value;
    }

    public void setValue(double Value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int numberofcoins) {
        this.quantity = numberofcoins;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinid=" + coinid +
                ", numberofcoins=" + quantity +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", nameplural='" + nameplural + '\'' +
                '}';
    }
}
