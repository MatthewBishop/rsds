package dev.openrune.rsds.ui;

import dev.openrune.rsds.GUI;

class Thread_sub_130 extends Thread {

    public Thread_sub_130() {

    }

    public void run() {
        while (GUI.identityKitDefinitionFrame != null) {
            if (GUI.identityKitDefinitionFrame.aRenderable_Sub_259 != null) {
                try {
                    GUI.identityKitDefinitionFrame.aRenderable_Sub_259
                            .method38();
                    GUI.identityKitDefinitionFrame.model = GUI.identityKitDefinitionFrame.aRenderable_Sub_259
                            .getRotatedModel();
                    GUI.identityKitDefinitionFrame.aJLabel_43
                            .setText(new StringBuilder()
                                    .append("")
                                    .append(GUI.identityKitDefinitionFrame.aRenderable_Sub_259.frameId)
                                    .toString());
                    if (GUI.identityKitDefinitionFrame != null) {

                    }
                    IdentityKitDefinitionFrame.graphicsBuffer.method90(
                            GUI.identityKitDefinitionFrame.model, 0,
                            GUI.identityKitDefinitionFrame.anInt_263, 0,
                            GUI.identityKitDefinitionFrame.anInt_281,
                            GUI.identityKitDefinitionFrame.anInt_277);
                    if (GUI.identityKitDefinitionFrame != null) {

                    }
                    IdentityKitDefinitionFrame.graphicsBuffer.redrawImage(0, 0,
                            GUI.identityKitDefinitionFrame.panel.getGraphics());
                    if (GUI.identityKitDefinitionFrame != null) {

                    }
                    IdentityKitDefinitionFrame.graphicsBuffer.initToClear();
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
            if (GUI.identityKitDefinitionFrame != null) {
                /* empty */
            }
            if (l - IdentityKitDefinitionFrame.aLong_274 > 60000L) {
                System.gc();
                if (GUI.identityKitDefinitionFrame != null) {
                    /* empty */
                }
                IdentityKitDefinitionFrame.aLong_274 = System
                        .currentTimeMillis();
            }
        }
    }

}