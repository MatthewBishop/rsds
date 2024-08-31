/* GUI - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package dev.openrune.rsds;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.ui.AnimationDefinitionFrame;
import dev.openrune.rsds.ui.GraphicDefinitionFrame;
import dev.openrune.rsds.ui.IdentityKitDefinitionFrame;
import dev.openrune.rsds.ui.ModelViewerFrame;
import dev.openrune.rsds.ui.NpcDefinitionFrame;
import dev.openrune.rsds.ui.SkinlistFrame;

@SuppressWarnings("serial")
public class GUI extends JFrame {

    public static NpcDefinitionFrame npcDefinitionFrame;
    public static IdentityKitDefinitionFrame identityKitDefinitionFrame;
    public static GraphicDefinitionFrame graphicDefinitionFrame;
    public static int revision = 474;
    public static ModelViewerFrame modelViewerFrame;
    public static SkinlistFrame skinlistFrame;
    public static Cache cache;
    public static AnimationDefinitionFrame animationDefinitionFrame;

    public static void main(String[] strings) {
        // Useless String Found And Removed - match:
        // "Obfuscation by Allatori Obfuscator v3.2 DEMO"

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    static void method0(GUI gui, ActionEvent actionevent) {
        gui.method14(actionevent);
    }

    static void method11(GUI gui, ActionEvent actionevent) {
        gui.method10(actionevent);
    }

    static void method13(GUI gui, ActionEvent actionevent) {
        gui.method20(actionevent);
    }

    static void method16(GUI gui, ActionEvent actionevent) {
        gui.method5(actionevent);
    }

    static void method17(GUI gui, ActionEvent actionevent) {
        gui.method15(actionevent);
    }

    static void method18(GUI gui, ActionEvent actionevent) {
    }

    static void method2(GUI gui, ActionEvent actionevent) {
        gui.method9(actionevent);
    }

    static void method6(GUI gui, ActionEvent actionevent) {
        gui.method12(actionevent);
    }

    static void method7(GUI gui, ActionEvent actionevent) {
        gui.method4(actionevent);
    }

    static void method8(GUI gui, ActionEvent actionevent) {
    }

    private JButton animationFilesButton;
    private JButton objectDefButton;
    private JButton identityKitDefButton;
    private JButton loadCacheButton;
    private JButton npcDefButton;
    private JButton animationDefButton;
    private JButton setCacheBuildButton;
    private JButton modelsButton;
    private JButton itemDefButton;
    private JButton graphicsDefButton;
    public JFileChooser fileChooser;
    private JLabel logoJLabel;
    private JLabel managersTypeLabel;
    private JLabel buildTypeLabel;
    private JLabel versionLabel;
    private JLabel buildLabel;
    private JLabel managersLabel;

    public GUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exception) {

        }
        fileChooser = new JFileChooser();
        init();
        setTitle("RSDS v1.2.2 by Xaves/Xavier (pokenation.org)");
    }

    private void method10(ActionEvent actionevent) {
        String string;
        if ((string = JOptionPane
                .showInputDialog("Enter the cache build which you are using.")) != null
                && !string.equals("")) {
            int revision;
            try {
                revision = Integer.parseInt(string);
            } catch (Exception exception) {
                return;
            }
            GUI.revision = revision;
            buildTypeLabel.setText(new StringBuilder().append("")
                    .append(GUI.revision).toString());
        }
    }

    private void method12(ActionEvent actionevent) {
        if (animationDefinitionFrame == null) {
            animationDefinitionFrame = new AnimationDefinitionFrame();
            animationDefinitionFrame.method30(cache);
        }
        if (!animationDefinitionFrame.isVisible()) {
            animationDefinitionFrame.setVisible(true);
        } else {
            animationDefinitionFrame.dispose();
        }
    }

    private void method14(ActionEvent actionevent) {
        if (skinlistFrame == null) {
            skinlistFrame = new SkinlistFrame();
            skinlistFrame.method30(cache);
        }
        if (!skinlistFrame.isVisible()) {
            skinlistFrame.setVisible(true);
        } else {
            skinlistFrame.dispose();
        }
    }

    private void method15(ActionEvent actionevent) {
        if (graphicDefinitionFrame == null) {
            graphicDefinitionFrame = new GraphicDefinitionFrame();
            graphicDefinitionFrame.method30(cache);
        }
        if (!graphicDefinitionFrame.isVisible()) {
            graphicDefinitionFrame.setVisible(true);
            graphicDefinitionFrame.method38();
            if (modelViewerFrame != null) {
                modelViewerFrame.model = null;
                modelViewerFrame.dispose();
            }
            if (identityKitDefinitionFrame != null) {
                identityKitDefinitionFrame.aRenderable_Sub_259 = null;
                identityKitDefinitionFrame.dispose();
            }
            if (npcDefinitionFrame != null) {
                npcDefinitionFrame.an_g_601 = null;
                npcDefinitionFrame.dispose();
            }
        } else {
            graphicDefinitionFrame.dispose();
        }
    }

    private void method20(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(1);
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (file.isDirectory()) {
                cache = new Cache(file.getAbsolutePath());
                managersTypeLabel.setText(new StringBuilder().append("")
                        .append(cache.getFileSystems().length).toString());
                int i = 400;
                int i_10_ = i;
                while (i_10_ < 900) {
                    if (file.getAbsolutePath()
                            .contains(
                                    new StringBuilder().append("").append(i)
                                            .toString())) {
                        revision = i;
                        buildTypeLabel.setText(new StringBuilder().append("")
                                .append(revision).toString());
                    }
                    i_10_ = ++i;
                }
                identityKitDefinitionFrame = null;
                identityKitDefButton.setEnabled(true);
                modelViewerFrame = null;
                modelsButton.setEnabled(true);
                graphicDefinitionFrame = null;
                graphicsDefButton.setEnabled(true);
                animationDefinitionFrame = null;
                animationDefButton.setEnabled(true);
                skinlistFrame = null;
                animationFilesButton.setEnabled(true);
                npcDefinitionFrame = null;
                npcDefButton.setEnabled(true);
            }
        }
    }

    private void init() {
        loadCacheButton = new JButton();
        logoJLabel = new JLabel();
        setCacheBuildButton = new JButton();
        buildLabel = new JLabel();
        buildTypeLabel = new JLabel();
        managersLabel = new JLabel();
        managersTypeLabel = new JLabel();
        animationDefButton = new JButton();
        animationFilesButton = new JButton();
        graphicsDefButton = new JButton();
        itemDefButton = new JButton();
        objectDefButton = new JButton();
        npcDefButton = new JButton();
        modelsButton = new JButton();
        identityKitDefButton = new JButton();
        versionLabel = new JLabel();
        setDefaultCloseOperation(3);
        setTitle("RSDS by Xaves");
        setResizable(false);
        loadCacheButton.setText("Load Cache");
        loadCacheButton.setFocusPainted(false);
        loadCacheButton.setFocusable(false);
        loadCacheButton.addActionListener(new ActionListener() {

            final GUI loadCacheGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method13(loadCacheGUI, actionevent);
            }
        });
        logoJLabel.setIcon(new ImageIcon(this.getClass().getResource(
                "/dev/openrune/rsds/logo.png")));
        setCacheBuildButton.setText("Set Cache Build");
        setCacheBuildButton.setFocusPainted(false);
        setCacheBuildButton.setFocusable(false);
        setCacheBuildButton.addActionListener(new ActionListener() {

            final GUI setCacheBuildGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method11(setCacheBuildGUI, actionevent);
            }
        });
        buildLabel.setFont(new Font("Tahoma", 1, 11));
        buildLabel.setText("Build: ");
        buildTypeLabel.setText("unknown");
        managersLabel.setFont(new Font("Tahoma", 1, 11));
        managersLabel.setText("Managers:");
        managersTypeLabel.setText("unknown");
        animationDefButton.setText("Animation Def.");
        animationDefButton.setEnabled(false);
        animationDefButton.setFocusPainted(false);
        animationDefButton.setFocusable(false);
        animationDefButton.addActionListener(new ActionListener() {

            final GUI animationDefGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method6(animationDefGUI, actionevent);
            }
        });
        animationFilesButton.setText("Animation Files");
        animationFilesButton.setEnabled(false);
        animationFilesButton.setFocusPainted(false);
        animationFilesButton.setFocusable(false);
        animationFilesButton.addActionListener(new ActionListener() {

            final GUI animationFilesGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method0(animationFilesGUI, actionevent);
            }
        });
        graphicsDefButton.setText("Graphics Def.");
        graphicsDefButton.setEnabled(false);
        graphicsDefButton.setFocusPainted(false);
        graphicsDefButton.setFocusable(false);
        graphicsDefButton.addActionListener(new ActionListener() {

            final GUI graphicsDefGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method17(graphicsDefGUI, actionevent);
            }
        });
        itemDefButton.setText("Item Def.");
        itemDefButton.setEnabled(false);
        itemDefButton.setFocusPainted(false);
        itemDefButton.setFocusable(false);
        itemDefButton.addActionListener(new ActionListener() {

            final GUI itemDefGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method8(itemDefGUI, actionevent);
            }
        });
        objectDefButton.setText("Object Def.");
        objectDefButton.setEnabled(false);
        objectDefButton.setFocusPainted(false);
        objectDefButton.setFocusable(false);
        objectDefButton.addActionListener(new ActionListener() {

            final GUI objectDefGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method18(objectDefGUI, actionevent);
            }
        });
        npcDefButton.setText("NPC Def.");
        npcDefButton.setEnabled(false);
        npcDefButton.setFocusPainted(false);
        npcDefButton.setFocusable(false);
        npcDefButton.addActionListener(new ActionListener() {

            final GUI npcDefGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method16(npcDefGUI, actionevent);
            }
        });
        modelsButton.setText("Models");
        modelsButton.setEnabled(false);
        modelsButton.setFocusPainted(false);
        modelsButton.setFocusable(false);
        modelsButton.addActionListener(new ActionListener() {

            final GUI modelGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method7(modelGUI, actionevent);
            }
        });
        identityKitDefButton.setText("IDK Def.");
        identityKitDefButton.setEnabled(false);
        identityKitDefButton.setFocusPainted(false);
        identityKitDefButton.setFocusable(false);
        identityKitDefButton.addActionListener(new ActionListener() {

            final GUI idkGUI = GUI.this;

            public void actionPerformed(ActionEvent actionevent) {
                method2(idkGUI, actionevent);
            }
        });
        versionLabel.setText("v1.2.2");
        GroupLayout grouplayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(grouplayout);
        grouplayout
                .setHorizontalGroup(grouplayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                grouplayout
                                        .createSequentialGroup()
                                        .addGroup(
                                                grouplayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addGap(39,
                                                                                39,
                                                                                39)
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                loadCacheButton,
                                                                                                -2,
                                                                                                114,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                setCacheBuildButton,
                                                                                                -2,
                                                                                                114,
                                                                                                -2))
                                                                        .addGap(83,
                                                                                83,
                                                                                83)
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                grouplayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                animationDefButton,
                                                                                                                -2,
                                                                                                                114,
                                                                                                                -2)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                graphicsDefButton,
                                                                                                                -2,
                                                                                                                114,
                                                                                                                -2)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                itemDefButton,
                                                                                                                -2,
                                                                                                                114,
                                                                                                                -2))
                                                                                        .addGroup(
                                                                                                grouplayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                npcDefButton,
                                                                                                                -2,
                                                                                                                114,
                                                                                                                -2)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                objectDefButton,
                                                                                                                -2,
                                                                                                                114,
                                                                                                                -2)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                animationFilesButton,
                                                                                                                -2,
                                                                                                                114,
                                                                                                                -2))
                                                                                        .addGroup(
                                                                                                grouplayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                modelsButton,
                                                                                                                -2,
                                                                                                                114,
                                                                                                                -2)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                identityKitDefButton,
                                                                                                                -2,
                                                                                                                114,
                                                                                                                -2))))
                                                        .addGroup(
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addGap(30,
                                                                                30,
                                                                                30)
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                grouplayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                buildLabel)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                buildTypeLabel))
                                                                                        .addGroup(
                                                                                                grouplayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                managersLabel)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                managersTypeLabel))))
                                                        .addGroup(
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addGap(136,
                                                                                136,
                                                                                136)
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(
                                                                                                versionLabel)
                                                                                        .addComponent(
                                                                                                logoJLabel))))
                                        .addContainerGap(40, 32767)));
        grouplayout
                .setVerticalGroup(grouplayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                grouplayout
                                        .createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(logoJLabel)
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(versionLabel)
                                        .addGap(22, 22, 22)
                                        .addGroup(
                                                grouplayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.TRAILING)
                                                        .addGroup(
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                buildLabel)
                                                                                        .addComponent(
                                                                                                buildTypeLabel))
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                managersLabel)
                                                                                        .addComponent(
                                                                                                managersTypeLabel))
                                                                        .addGap(18,
                                                                                18,
                                                                                18)
                                                                        .addComponent(
                                                                                loadCacheButton,
                                                                                -2,
                                                                                39,
                                                                                -2)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                setCacheBuildButton,
                                                                                -2,
                                                                                39,
                                                                                -2))
                                                        .addGroup(
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                animationDefButton,
                                                                                                -2,
                                                                                                39,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                graphicsDefButton,
                                                                                                -2,
                                                                                                39,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                itemDefButton,
                                                                                                -2,
                                                                                                39,
                                                                                                -2))
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                objectDefButton,
                                                                                                -2,
                                                                                                39,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                npcDefButton,
                                                                                                -2,
                                                                                                39,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                animationFilesButton,
                                                                                                -2,
                                                                                                39,
                                                                                                -2))
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                modelsButton,
                                                                                                -2,
                                                                                                39,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                identityKitDefButton,
                                                                                                -2,
                                                                                                39,
                                                                                                -2))))
                                        .addContainerGap(60, 32767)));
        pack();
    }

    private void method4(ActionEvent actionevent) {
        if (modelViewerFrame == null) {
            modelViewerFrame = new ModelViewerFrame();
            modelViewerFrame.void_method30(cache);
        }
        if (!modelViewerFrame.isVisible()) {
            modelViewerFrame.setVisible(true);
            modelViewerFrame.void_method38();
            if (identityKitDefinitionFrame != null) {
                identityKitDefinitionFrame.aRenderable_Sub_259 = null;
                identityKitDefinitionFrame.dispose();
            }
            if (graphicDefinitionFrame != null) {
                graphicDefinitionFrame.animableObject = null;
                graphicDefinitionFrame.dispose();
            }
            if (npcDefinitionFrame != null) {
                npcDefinitionFrame.an_g_601 = null;
                npcDefinitionFrame.dispose();
            }
        } else {
            modelViewerFrame.dispose();
        }
    }

    private void method5(ActionEvent actionevent) {
        if (npcDefinitionFrame == null) {
            npcDefinitionFrame = new NpcDefinitionFrame();
            npcDefinitionFrame.method30(cache);
        }
        if (!npcDefinitionFrame.isVisible()) {
            npcDefinitionFrame.setVisible(true);
            npcDefinitionFrame.void_method65();
            if (modelViewerFrame != null) {
                modelViewerFrame.model = null;
                modelViewerFrame.dispose();
            }
            if (identityKitDefinitionFrame != null) {
                identityKitDefinitionFrame.aRenderable_Sub_259 = null;
                identityKitDefinitionFrame.dispose();
            }
            if (graphicDefinitionFrame != null) {
                graphicDefinitionFrame.animableObject = null;
                graphicDefinitionFrame.dispose();
            }
        } else {
            npcDefinitionFrame.dispose();
        }
    }

    private void method9(ActionEvent actionevent) {
        if (identityKitDefinitionFrame == null) {
            identityKitDefinitionFrame = new IdentityKitDefinitionFrame();
            identityKitDefinitionFrame.method30(cache);
        }
        if (!identityKitDefinitionFrame.isVisible()) {
            identityKitDefinitionFrame.setVisible(true);
            identityKitDefinitionFrame.void_method38();
            if (modelViewerFrame != null) {
                modelViewerFrame.model = null;
                modelViewerFrame.dispose();
            }
            if (graphicDefinitionFrame != null) {
                graphicDefinitionFrame.animableObject = null;
                graphicDefinitionFrame.dispose();
            }
            if (npcDefinitionFrame != null) {
                npcDefinitionFrame.an_g_601 = null;
                npcDefinitionFrame.dispose();
            }
        } else {
            identityKitDefinitionFrame.dispose();
        }
    }

}