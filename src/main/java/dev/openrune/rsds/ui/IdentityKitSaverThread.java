package dev.openrune.rsds.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import dev.openrune.rsds.fs.def.IdentityKit;
import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.io.FileUtils;
import dev.openrune.rsds.GUI;

class IdentityKitSaverThread extends Thread {

    File file;
    int saveType;

    public IdentityKitSaverThread(File file, int type) {
        this.file = file;
        saveType = type;
    }

    public void run() {
        if (saveType == 0) {
            int completed;
            int i = completed = 0;
            for (; ; ) {
                if (GUI.identityKitDefinitionFrame != null) {

                }
                if (i >= IdentityKitDefinitionFrame.totalDefinitions) {
                    break;
                }
                try {
                    int tmp = completed * 100;
                    if (GUI.identityKitDefinitionFrame != null) {

                    }
                    int percentage = tmp
                            / (IdentityKitDefinitionFrame.totalDefinitions - 1);
                    GUI.identityKitDefinitionFrame.updateProgressBar(
                            new StringBuilder().append("Dumping all idk - ")
                                    .append(percentage).append("%").toString(),
                            percentage);
                    String string = GUI.identityKitDefinitionFrame
                            .method105(completed);
                    BufferedWriter bufferedwriter;
                    (bufferedwriter = new BufferedWriter(new FileWriter(file,
                            true))).write(string);
                    bufferedwriter.flush();
                    bufferedwriter.close();
                } catch (Exception exception) {
                    /* empty */
                }
                i = ++completed;
            }
        } else if (saveType == 1) {
            GUI.identityKitDefinitionFrame.updateProgressBar(
                    "Packing idk.dat - 0%", 0);
            Buffer buffer = new Buffer(new byte[3000000]);
            if (GUI.identityKitDefinitionFrame != null) {
                /* empty */
            }
            int total = IdentityKitDefinitionFrame.totalDefinitions;
            buffer.writeShort2(total);
            int completed;
            int i_3_ = completed = 0;
            while (i_3_ < total) {
                int percentage = completed * 100 / (total - 1);
                GUI.identityKitDefinitionFrame.updateProgressBar(
                        new StringBuilder().append("Packing idk.dat - ")
                                .append(percentage).append("%").toString(),
                        percentage);
                IdentityKit.get(GUI.cache, completed, true).writeValues(buffer);
                i_3_ = ++completed;
            }
            byte[] is = new byte[buffer.offset];
            System.arraycopy(buffer.payload, 0, is, 0, buffer.offset);
            System.out.println(new StringBuilder().append("idk.dat size: ")
                    .append(buffer.offset / 1024).append("KB").toString());
            FileUtils.write(file.getAbsolutePath(), is);
        }
        file = null;
        System.gc();
    }

}