package dev.openrune.rsds.ui;

import dev.openrune.rsds.io.FileUtils;
import dev.openrune.rsds.GUI;

class ModelSaverThread extends Thread {

    int saveFlag;
    String mainPath;

    public ModelSaverThread(String string, int flag) {
        mainPath = string;
        saveFlag = flag;
    }

    public void run() {
        do {
            if (saveFlag == 0) {
                int i_0_;
                int i = i_0_ = 0;
                while (i < GUI.modelViewerFrame.an_int_93) {
                    try {
                        int completed = i_0_ * 100
                                / (GUI.modelViewerFrame.an_int_93 - 1);
                        GUI.modelViewerFrame.void_method23(
                                new StringBuilder()
                                        .append("Saving all models - ")
                                        .append(completed).append("&")
                                        .toString(), completed);
                        byte[] buffer = GUI.cache.getFileSystems()[7]
                                .getFile(i_0_, 0);
                        FileUtils.write(new StringBuilder().append(mainPath)
                                .append("/").append(i_0_).append(".dat")
                                .toString(), buffer);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if (i_0_ % 10000 == 0) {
                        System.gc();
                    }
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException interruptedexception) {
                        /* empty */
                    }
                    i = ++i_0_;
                }
                System.gc();
            } else if (saveFlag == 1) {
                break;
            }
        } while (false);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        System.gc();
    }

}