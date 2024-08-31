package dev.openrune.rsds.ui;

import dev.openrune.rsds.GUI;

class Thread_sub_105 extends Thread {

    public Thread_sub_105() {
        /* empty */
    }

    public void run() {
        while (GUI.graphicDefinitionFrame != null) {
            if (GUI.graphicDefinitionFrame.animableObject != null
                    && GUI.graphicDefinitionFrame.animableObject != null) {
                try {
                    GUI.graphicDefinitionFrame.animableObject.method38();
                    GUI.graphicDefinitionFrame.model = GUI.graphicDefinitionFrame.animableObject
                            .getRotatedModel();
                    GUI.graphicDefinitionFrame.aJLabel_738
                            .setText(new StringBuilder()
                                    .append("")
                                    .append(GUI.graphicDefinitionFrame.animableObject.elapsedFrames)
                                    .toString());
                    if (GUI.graphicDefinitionFrame != null) {
                        /* empty */
                    }
                    GraphicDefinitionFrame.graphicsBuffer.method90(
                            GUI.graphicDefinitionFrame.model, 0,
                            GUI.graphicDefinitionFrame.anInt_701, 0,
                            GUI.graphicDefinitionFrame.anInt_729,
                            GUI.graphicDefinitionFrame.anInt_702);
                    if (GUI.graphicDefinitionFrame != null) {
                        /* empty */
                    }
                    GraphicDefinitionFrame.graphicsBuffer.redrawImage(0, 0,
                            GUI.graphicDefinitionFrame.aJPanel_716
                                    .getGraphics());
                    if (GUI.graphicDefinitionFrame != null) {
                        /* empty */
                    }
                    GraphicDefinitionFrame.graphicsBuffer.initToClear();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            try {
                Thread.sleep(50L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
            long l = System.currentTimeMillis();
            if (GUI.graphicDefinitionFrame != null) {
                /* empty */
            }
            if (l - GraphicDefinitionFrame.aLong_710 > 60000L) {
                System.gc();
                if (GUI.graphicDefinitionFrame != null) {
                    /* empty */
                }
                GraphicDefinitionFrame.aLong_710 = System.currentTimeMillis();
            }
        }
    }

}