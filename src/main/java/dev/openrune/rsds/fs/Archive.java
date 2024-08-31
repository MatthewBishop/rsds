package dev.openrune.rsds.fs;

public class Archive {

    // This isn't right but whatever. It represents some sort of file.

    private boolean aBoolean351;
    private int crcValue;
    private int anInt352;
    private int anInt353 = -1;

    public Archive() {
        anInt352 = -1;
        crcValue = -1;
    }

    public boolean method141() {
        return aBoolean351;
    }

    public int method138() {
        return anInt352;
    }

    public int getCRCValue() {
        return crcValue;
    }

    public int method140() {
        return anInt353;
    }

    public int method142() {
        return aBoolean351 ? anInt352 : anInt352 + 1;
    }

    public void setCRCValue(int crcValue) {
        this.crcValue = crcValue;
    }

    public void method54(int i) {
        anInt353 = i;
    }

    public void method61() {
        anInt352++;
        aBoolean351 = true;
    }

    public void method88(int i) {
        anInt352 = i;
    }

}