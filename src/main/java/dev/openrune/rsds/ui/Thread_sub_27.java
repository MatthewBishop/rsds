/* Thread_sub_27 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package dev.openrune.rsds.ui;

import dev.openrune.rsds.GUI;

class Thread_sub_27 extends Thread {

    public Thread_sub_27() {
        /* empty */
    }

    public void run() {
        for (; ; ) {
            if (GUI.modelViewerFrame.model != null) {
                try {
                    if (GUI.modelViewerFrame != null) {
                        /* empty */
                    }
                    ModelViewerFrame.graphicsBuffer.method90(
                            GUI.modelViewerFrame.model, 0,
                            GUI.modelViewerFrame.an_int_101, 0,
                            GUI.modelViewerFrame.an_int_103,
                            GUI.modelViewerFrame.an_int_105);
                    if (GUI.modelViewerFrame != null) {
                        /* empty */
                    }
                    ModelViewerFrame.graphicsBuffer.redrawImage(0, 0,
                            GUI.modelViewerFrame.an_JPanel_98.getGraphics());
                    if (GUI.modelViewerFrame != null) {
                        /* empty */
                    }
                    ModelViewerFrame.graphicsBuffer.initToClear();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
            long l = System.currentTimeMillis();
            if (GUI.modelViewerFrame != null) {
                /* empty */
            }
            if (l - ModelViewerFrame.aLong111 > 60000L) {
                System.gc();
                if (GUI.modelViewerFrame != null) {
                    /* empty */
                }
                ModelViewerFrame.aLong111 = System.currentTimeMillis();
            }
        }
    }
}
