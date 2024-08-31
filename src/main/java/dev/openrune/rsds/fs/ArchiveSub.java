package dev.openrune.rsds.fs;

public class ArchiveSub extends Archive {

    // wrong - might be child file or something?

    private Archive[] archives;
    private int[] anIntArray454;

    public void method171(int[] is) {
        anIntArray454 = is;
    }

    public void setArchives(Archive[] archives) {
        this.archives = archives;
    }

    public Archive[] getArchives() {
        return archives;
    }

    public int[] method174() {
        return anIntArray454;
    }

}