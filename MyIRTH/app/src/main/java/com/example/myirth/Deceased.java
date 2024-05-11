package com.example.myirth;

public class Deceased extends Person {

    private String gender = Person.MALE;
    private double legacy = 0.0;
    private int sonsno = 0;
    private int daughtersno = 0;
    private int wivesno = 0;
    private int brothersno = 0;
    private int sistersno = 0;
    private boolean hasafather = false;
    private boolean hasamother = false;
    private boolean hasahusband = false;
    private boolean hasagrandfather = false;
    private boolean hasagrandmother = false;

    public boolean isHasagrandfather() {
        return hasagrandfather;
    }

    public void setHasagrandfather(boolean hasagrandfather) {
        this.hasagrandfather = hasagrandfather;
    }

    public boolean isHasagrandmother() {
        return hasagrandmother;
    }

    public void setHasagrandmother(boolean hasagrandmother) {
        this.hasagrandmother = hasagrandmother;
    }

    public boolean isHasahusband() {
        return hasahusband;
    }

    public void setHasahusband(boolean hasahusband) {
        this.hasahusband = hasahusband;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getLegacy() {
        return legacy;
    }

    public void setLegacy(double legacy) {
        this.legacy = legacy;
    }

    public int getSonsno() {
        return sonsno;
    }

    public void setSonsno(int sonsno) {
        this.sonsno = sonsno;
    }

    public int getDaughtersno() {
        return daughtersno;
    }

    public void setDaughtersno(int daughtersno) {
        this.daughtersno = daughtersno;
    }

    public int getWivesno() {
        return wivesno;
    }

    public void setWivesno(int wivesno) {
        this.wivesno = wivesno;
    }

    public int getBrothersno() {
        return brothersno;
    }

    public void setBrothersno(int brothersno) {
        this.brothersno = brothersno;
    }

    public int getSistersno() {
        return sistersno;
    }

    public void setSistersno(int sistersno) {
        this.sistersno = sistersno;
    }

    public boolean Hasafather() {
        return hasafather;
    }

    public void setHasafather(boolean hasafather) {
        this.hasafather = hasafather;
    }

    public boolean Hasamother() {
        return hasamother;
    }

    public void setHasamother(boolean hasamother) {
        this.hasamother = hasamother;
    }

    public boolean hasMultipleSiblings(){
        if (this.getBrothersno() + this.getSistersno() > 1){
            return true;
        }
        return false;
    }
}
