package dev.openrune.rsds.ui;

import java.io.RandomAccessFile;

import dev.openrune.rsds.fs.def.Class_n;
import dev.openrune.rsds.io.FileUtils;
import dev.openrune.rsds.GUI;

class SkinSaverThread extends Thread {

    int saveType;
    String file;

    public SkinSaverThread(String file, int type) {
        this.file = file;
        saveType = type;
    }

    public void run() {
        if (saveType == 0) {
            int completed;
            int i = completed = 0;
            for (; ; ) {
                if (GUI.skinlistFrame != null) {
                    /* empty */
                }
                if (i >= SkinlistFrame.anInt_82) {
                    break;
                }
                try {
                    int tmp = completed * 100;
                    if (GUI.skinlistFrame != null) {
                        /* empty */
                    }
                    int percentage = tmp / (SkinlistFrame.anInt_82 - 1);
                    GUI.skinlistFrame.updateProgressBar(
                            new StringBuilder()
                                    .append("Packing All SkinLists - ")
                                    .append(percentage).append("%").toString(),
                            percentage);
                    Class_n class_n;
                    (class_n = new Class_n()).method183(GUI.cache, completed,
                            false);
                    byte[] vals = class_n.an_y_532.writeValues();
                    FileUtils.write(new StringBuilder().append(file)
                            .append("/").append(completed).append(".dat")
                            .toString(), vals);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (completed % 100 == 0) {
                    System.gc();
                }
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
                i = ++completed;
            }
            System.gc();
        } else if (saveType == 1) {
            int completed;
            int i = completed = 0;
            for (; ; ) {
                if (GUI.skinlistFrame != null) {
                    /* empty */
                }
                if (i >= SkinlistFrame.anInt_82) {
                    break;
                }
                try {
                    int tmp = completed * 100;
                    if (GUI.skinlistFrame != null) {
                        /* empty */
                    }
                    int percentage = tmp / (SkinlistFrame.anInt_82 - 1);
                    GUI.skinlistFrame.updateProgressBar(new StringBuilder()
                            .append("Packing All Frames - ").append(percentage)
                            .append("%").toString(), percentage);
                    Class_n class_n;
                    (class_n = new Class_n()).method183(GUI.cache, completed,
                            true);
                    byte[] vals = new byte[class_n.buffer.offset];
                    System.arraycopy(class_n.buffer.payload, 0, vals, 0,
                            class_n.buffer.offset);
                    FileUtils.write(new StringBuilder().append(file)
                            .append("/").append(completed).append(".dat")
                            .toString(), vals);
                    class_n.buffer = null;
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (completed % 100 == 0) {
                    System.gc();
                }
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
                i = ++completed;
            }
            System.gc();
        } else if (saveType == 2) {
            int completed;
            int i = completed = 0;
            for (; ; ) {
                if (GUI.skinlistFrame != null) {
                    /* empty */
                }
                if (i >= SkinlistFrame.anInt_82) {
                    break;
                }
                try {
                    int tmp = completed * 100;
                    if (GUI.skinlistFrame != null) {
                        /* empty */
                    }
                    int percentage = tmp / (SkinlistFrame.anInt_82 - 1);
                    GUI.skinlistFrame.updateProgressBar(new StringBuilder()
                            .append("Packing All Files - ").append(percentage)
                            .append("%").toString(), percentage);
                    Class_n class_n;
                    (class_n = new Class_n()).method183(GUI.cache, completed,
                            true);
                    byte[] is = new byte[class_n.buffer.offset];
                    System.arraycopy(class_n.buffer.payload, 0, is, 0,
                            class_n.buffer.offset);
                    byte[] vals = class_n.an_y_532.writeValues();
                    try {
                        RandomAccessFile file;
                        (file = new RandomAccessFile(new StringBuilder()
                                .append(this.file).append("/")
                                .append(completed).append(".dat").toString(),
                                "rw")).write(vals);
                        file.write(is);
                        file.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    class_n.buffer = null;
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (completed % 100 == 0) {
                    System.gc();
                }
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException interruptedexception) {
                }
                i = ++completed;
            }
            System.gc();
        }
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException interruptedexception) {
        }
        System.gc();
    }

}