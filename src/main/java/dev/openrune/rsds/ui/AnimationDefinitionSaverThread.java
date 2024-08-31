package dev.openrune.rsds.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import dev.openrune.rsds.fs.def.AnimationDefinition;
import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.io.FileUtils;
import dev.openrune.rsds.GUI;

class AnimationDefinitionSaverThread extends Thread {

    File outFile;
    int saveOpcode;

    public AnimationDefinitionSaverThread(File file, int saveType) {
        outFile = file;
        saveOpcode = saveType;
    }

    public void run() {
        if (saveOpcode == 0) {
            int completed;
            int i = completed = 0;
            for (; ; ) {
                if (GUI.animationDefinitionFrame != null) {
                    /* empty */
                }
                if (i >= AnimationDefinitionFrame.totalAnimationCount) {
                    break;
                }
                try {
                    int compl = completed * 100;
                    if (GUI.animationDefinitionFrame != null) {
                        /* empty */
                    }
                    int percentage = compl
                            / (AnimationDefinitionFrame.totalAnimationCount - 1);
                    GUI.animationDefinitionFrame.updateProgressBar(
                            new StringBuilder()
                                    .append("Dumping all animations - ")
                                    .append(percentage).append("%").toString(),
                            percentage);
                    String string = GUI.animationDefinitionFrame
                            .getDefinitionAsJavaCode(completed);
                    BufferedWriter bufferedwriter;
                    (bufferedwriter = new BufferedWriter(new FileWriter(
                            outFile, true))).write(string);
                    bufferedwriter.flush();
                    bufferedwriter.close();
                } catch (Exception exception) {
                    /* empty */
                }
                i = ++completed;
            }
        } else if (saveOpcode == 1) {
            GUI.animationDefinitionFrame.updateProgressBar(
                    "Packing seq.dat - 0%", 0);
            Buffer buffer = new Buffer(new byte[3000000]);
            if (GUI.animationDefinitionFrame != null) {
            }
            int count = AnimationDefinitionFrame.totalAnimationCount;
            buffer.writeShort2(count);
            int tmp;
            int completed = tmp = 0;
            while (completed < count) {
                int packed = tmp * 100 / (count - 1);
                GUI.animationDefinitionFrame.updateProgressBar(
                        new StringBuilder().append("Packing seq.dat - ")
                                .append(packed).append("%").toString(), packed);
                AnimationDefinition.getDefinition(GUI.cache, tmp, true)
                        .void_method157(buffer);
                completed = ++tmp;
            }
            byte[] bytes = new byte[buffer.offset];
            System.arraycopy(buffer.payload, 0, bytes, 0, buffer.offset);
            System.out.println(new StringBuilder().append("seq.dat size: ")
                    .append(buffer.offset / 1024).append("KB").toString());
            FileUtils.write(outFile.getAbsolutePath(), bytes);
        }
        outFile = null;
        System.gc();
    }

}