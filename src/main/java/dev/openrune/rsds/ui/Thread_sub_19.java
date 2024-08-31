/* Thread_sub_19 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package dev.openrune.rsds.ui;

import dev.openrune.rsds.GUI;

class Thread_sub_19 extends Thread {

    public Thread_sub_19() {
        /* empty */
    }

    public void run() {
        while (GUI.npcDefinitionFrame != null) {
            if (GUI.npcDefinitionFrame.an_g_601 != null) {
                try {
                    GUI.npcDefinitionFrame.an_g_601.method38();
                    GUI.npcDefinitionFrame.an_o_632 = GUI.npcDefinitionFrame.an_g_601.getRotatedModel();
                    GUI.npcDefinitionFrame.an_JLabel_615.setText(new StringBuilder()
                            .append("").append(GUI.npcDefinitionFrame.an_g_601.frameId)
                            .toString());
                    if (GUI.npcDefinitionFrame != null) {
                        /* empty */
                    }
                    NpcDefinitionFrame.aClass_n_633.method90(GUI.npcDefinitionFrame.an_o_632,
                            0, GUI.npcDefinitionFrame.mouseEventYTotal, 0,
                            GUI.npcDefinitionFrame.mouseEventXTotal, GUI.npcDefinitionFrame.an_int_624);
                    if (GUI.npcDefinitionFrame != null) {
                        /* empty */
                    }
                    NpcDefinitionFrame.aClass_n_633.redrawImage(0, 0,
                            GUI.npcDefinitionFrame.an_JPanel_595.getGraphics());
                    if (GUI.npcDefinitionFrame != null) {
                        /* empty */
                    }
                    NpcDefinitionFrame.aClass_n_633.initToClear();
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
            if (GUI.npcDefinitionFrame != null) {
                /* empty */
            }
            if (l - NpcDefinitionFrame.aLong_594 > 60000L) {
                System.gc();
                if (GUI.npcDefinitionFrame != null) {
                    /* empty */
                }
                NpcDefinitionFrame.aLong_594 = System.currentTimeMillis();
            }
        }
    }
}
