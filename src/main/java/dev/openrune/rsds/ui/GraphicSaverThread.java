/* Thread_sub_64 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package dev.openrune.rsds.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import dev.openrune.rsds.fs.def.GraphicDefinition;
import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.io.FileUtils;
import dev.openrune.rsds.GUI;

class GraphicSaverThread extends Thread {

    File file;
    int saveType;

    public GraphicSaverThread(File file, int type) {
        this.file = file;
        saveType = type;
    }

    public void run() {
        if (saveType == 0) {
            int completed;
            int i = completed = 0;
            for (; ; ) {
                if (GUI.graphicDefinitionFrame != null) {
                    /* empty */
                }
                if (i >= GraphicDefinitionFrame.totalGraphicCount) {
                    break;
                }
                try {
                    int tmp = completed * 100;
                    if (GUI.graphicDefinitionFrame != null) {
                        /* empty */
                    }
                    int percentage = tmp
                            / (GraphicDefinitionFrame.totalGraphicCount - 1);
                    GUI.graphicDefinitionFrame.updateProgessBar(
                            new StringBuilder()
                                    .append("Dumping all graphics - ")
                                    .append(percentage).append("%").toString(),
                            percentage);
                    String string = GUI.graphicDefinitionFrame
                            .getDefinitionAsCode(completed);
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
            GUI.graphicDefinitionFrame.updateProgessBar("Packing spotanim.dat - 0%",
                    0);
            Buffer buffer = new Buffer(new byte[3000000]);
            if (GUI.graphicDefinitionFrame != null) {
                /* empty */
            }
            int i = GraphicDefinitionFrame.totalGraphicCount;
            buffer.writeShort2(i);
            int id;
            int i_3_ = id = 0;
            while (i_3_ < i) {
                int completed = id * 100 / (i - 1);
                GUI.graphicDefinitionFrame.updateProgessBar(new StringBuilder()
                        .append("Packing spotanim.dat - ").append(completed)
                        .append("%").toString(), completed);
                GraphicDefinition.getDefinition(GUI.cache, id, true)
                        .writeValues(buffer);
                i_3_ = ++id;
            }
            byte[] bytes = new byte[buffer.offset];
            System.arraycopy(buffer.payload, 0, bytes, 0, buffer.offset);
            System.out.println(new StringBuilder()
                    .append("spotanim.dat size: ").append(buffer.offset / 1024)
                    .append("KB").toString());
            FileUtils.write(file.getAbsolutePath(), bytes);
        }
        file = null;
        System.gc();
    }

}