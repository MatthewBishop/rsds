package dev.openrune.rsds.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import dev.openrune.rsds.GUI;

class NpcSaverThread extends Thread {

    File an_File_740;
    int an_int_741;

    public NpcSaverThread(File file, int i) {
        an_File_740 = file;
        an_int_741 = i;
    }

    public void run() {
        do {
            if (an_int_741 == 0) {
                int i_0_;
                int i = i_0_ = 0;
                for (; ; ) {
                    if (GUI.npcDefinitionFrame != null) {
                        /* empty */
                    }
                    if (i >= NpcDefinitionFrame.anInt_629) {
                        break;
                    }
                    try {
                        int i_1_ = i_0_ * 100;
                        if (GUI.npcDefinitionFrame != null) {
                            /* empty */
                        }
                        int completed = i_1_ / (NpcDefinitionFrame.anInt_629 - 1);
                        GUI.npcDefinitionFrame.setProgressBarValues(
                                new StringBuilder()
                                        .append("Dumping all npcs - ")
                                        .append(completed).append("%")
                                        .toString(), completed);
                        String string = GUI.npcDefinitionFrame
                                .getNpcDefinitionAsString(i_0_);
                        BufferedWriter bufferedwriter;
                        (bufferedwriter = new BufferedWriter(new FileWriter(
                                an_File_740, true))).write(string);
                        bufferedwriter.flush();
                        bufferedwriter.close();
                    } catch (Exception exception) {
                        /* empty */
                    }
                    i = ++i_0_;
                }
            } else if (an_int_741 == 1) {
                break;
            }
        } while (false);
        an_File_740 = null;
        System.gc();
    }
}
