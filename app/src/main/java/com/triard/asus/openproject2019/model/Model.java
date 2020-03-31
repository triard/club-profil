package com.triard.asus.openproject2019.model;

import java.util.Comparator;

public class Model {
    private String nama, asal,coach,stadion,desc;
    private String img;

    public Model(String nama, String asal, String coach,String stadion, String desc, String img) {
        this.nama = nama;
        this.asal = asal;
        this.coach = coach;
        this.stadion =stadion;
        this.desc = desc;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStadion() {
        return stadion;
    }

    public void setStadion(String stadion) {
        this.stadion = stadion;
    }

    public  static final Comparator<Model> BY_TITTLE_ASCENDING = new Comparator<Model> ( ) {

        @Override
        public int compare(Model o1, Model o2) {
            return o1.getNama ().compareTo ( o2.getNama () );
        }
    };

    public  static final Comparator<Model> BY_TITTLE_DESCENDING = new Comparator<Model> ( ) {

        @Override
        public int compare(Model o1, Model o2) {
            return o2.getNama ().compareTo ( o1.getNama () );
        }
    };
}
