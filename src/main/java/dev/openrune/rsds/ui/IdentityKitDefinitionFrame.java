package dev.openrune.rsds.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.fs.def.IdentityKit;
import dev.openrune.rsds.GUI;
import dev.openrune.rsds.client.Model;
import dev.openrune.rsds.client.ProducingGraphicsBuffer;
import dev.openrune.rsds.client.Renderable_Sub;

@SuppressWarnings("serial")
public class IdentityKitDefinitionFrame extends JFrame {

    public static int totalDefinitions;
    public static long aLong_274 = 0L;
    public static ProducingGraphicsBuffer graphicsBuffer;

    static void method100(IdentityKitDefinitionFrame frame,
                          ActionEvent actionevent) {
        frame.method5(actionevent);
    }

    static void method101(IdentityKitDefinitionFrame frame,
                          ActionEvent actionevent) {
        frame.method9(actionevent);
    }

    static void method103(IdentityKitDefinitionFrame frame,
                          ActionEvent actionevent) {
        frame.method20(actionevent);
    }

    static void method104(IdentityKitDefinitionFrame frame,
                          WindowEvent windowevent) {
        frame.method33(windowevent);
    }

    static void method106(IdentityKitDefinitionFrame frame,
                          ActionEvent actionevent) {
        frame.method14(actionevent);
    }

    static void method107(IdentityKitDefinitionFrame frame,
                          ActionEvent actionevent) {
        frame.method15(actionevent);
    }

    static void method108(IdentityKitDefinitionFrame frame,
                          MouseEvent mouseevent) {
        frame.method36(mouseevent);
    }

    static void method109(IdentityKitDefinitionFrame frame,
                          ActionEvent actionevent) {
        frame.method19(actionevent);
    }

    static void method110(IdentityKitDefinitionFrame frame,
                          ActionEvent actionevent) {
        frame.method12(actionevent);
    }

    static void method111(IdentityKitDefinitionFrame frame,
                          ActionEvent actionevent) {
        frame.method10(actionevent);
    }

    static void method112(IdentityKitDefinitionFrame frame, KeyEvent keyevent) {
        frame.method113(keyevent);
    }

    static void method114(IdentityKitDefinitionFrame frame,
                          MouseEvent mouseevent) {
        frame.method35(mouseevent);
    }

    static void method115(IdentityKitDefinitionFrame frame,
                          ComponentEvent componentevent) {
        frame.method37(componentevent);
    }

    static void method116(IdentityKitDefinitionFrame frame,
                          MouseWheelEvent mousewheelevent) {
        frame.method39(mousewheelevent);
    }

    static void method117(IdentityKitDefinitionFrame frame,
                          MouseEvent mouseevent) {
        frame.method45(mouseevent);
    }

    static void void_method94(IdentityKitDefinitionFrame frame,
                              KeyEvent keyevent) {
        frame.method96(keyevent);
    }

    static void method95(IdentityKitDefinitionFrame frame, KeyEvent keyevent) {
        frame.method102(keyevent);
    }

    static void method98(IdentityKitDefinitionFrame frame,
                         ActionEvent actionevent) {
        frame.method4(actionevent);
    }

    static void method99(IdentityKitDefinitionFrame frame,
                         ListSelectionEvent listselectionevent) {
        frame.method25(listselectionevent);
    }

    public int[] anIntArray_249;
    public boolean aBoolean_286;
    public boolean aBoolean_289 = true;
    private ButtonGroup buttonGroup;
    public Renderable_Sub aRenderable_Sub_259;
    public IdentityKit an_IdentityKit_269;
    public IdentityKit an_IdentityKit_285;
    public int aInt_248;
    public int anInt_256;
    public int anInt_260;
    public int anInt_263;
    public int anInt_277;
    public int anInt_281;
    private JButton saveFullDumpButton;
    private JButton packIDKFileButton;
    private JButton aJButton_258;
    private JButton saveDumpButton;
    private JButton aJButton_265;
    private JButton aJButton_280;
    private JButton aJButton_283;
    JFileChooser fileChooser;
    private JLabel aJLabel_242;
    private JLabel aJLabel_252;
    private JLabel aJLabel_262;
    private JLabel selectedPartIdLabel;
    private JLabel totalPartsLabel;
    private JLabel endLabel;
    private JLabel aJLabel_272;
    private JLabel idkPartsListLabel;
    public JLabel aJLabel_43;
    private JLabel dumpLabel;
    private JList<?> aJList_254;
    public JPanel panel;
    private JProgressBar progessBar;
    private JRadioButton maleRadioButton;
    private JRadioButton shemaleRadioButton;
    private JScrollPane aJScrollPane_267;
    private JScrollPane aJScrollPane_275;
    private JTextArea aJTextArea_255;
    private JTextField aJTextField_245;
    private JTextField aJTextField_251;
    private JTextField aJTextField_264;
    private JTextField aJTextField_284;
    public Model model;
    public Thread thread;

    public IdentityKitDefinitionFrame() {
        anIntArray_249 = new int[7];
        anInt_281 = 0;
        anInt_263 = 0;
        anInt_277 = 450;
        anInt_260 = -1;
        anInt_256 = -1;
        method65();
        fileChooser = new JFileChooser();
    }

    public Model method97() {
        Model[] model = new Model[7];
        int i = 0;
        int i_2_;
        int i_1_ = i_2_ = 0;
        while (i_1_ < 7) {
            int i_3_;
            if ((i_3_ = anIntArray_249[i_2_]) >= 0) {
                model[i++] = IdentityKit.get(GUI.cache, i_3_).method190();
            }
            i_1_ = ++i_2_;
        }
        return new Model(i, model);
    }

    public String method105(int i) {
        String string = aJTextField_264
                .getText()
                .replaceAll("tab/", "\t")
                .replaceAll("id/",
                        new StringBuilder().append("").append(i).toString());
        String string_4_ = aJTextField_245
                .getText()
                .replaceAll("tab/", "\t")
                .replaceAll("id/",
                        new StringBuilder().append("").append(i).toString());
        String string_5_ = aJTextField_251
                .getText()
                .replaceAll("tab/", "\t")
                .replaceAll("id/",
                        new StringBuilder().append("").append(i).toString());
        IdentityKit identityKit = IdentityKit.get(GUI.cache, i, true);
        String string_6_ = "";
        string_6_ = new StringBuilder().append(string_6_).append(string_4_)
                .append("\n").toString();
        if (an_IdentityKit_269 == null) {
            an_IdentityKit_269 = IdentityKit.get(GUI.cache, 20000, false);
        }
        if (identityKit.bodyPartId != an_IdentityKit_269.bodyPartId) {
            string_6_ = new StringBuilder().append(string_6_).append(string)
                    .append("bodyPartId = ").append(identityKit.bodyPartId)
                    .append(";\n").toString();
        }
        if (identityKit.notSelectable != an_IdentityKit_269.notSelectable) {
            string_6_ = new StringBuilder().append(string_6_).append(string)
                    .append("notSelectable = ")
                    .append(identityKit.notSelectable).append(";\n").toString();
        }
        if (identityKit.bodyModelIds != null) {
            string_6_ = new StringBuilder().append(string_6_).append(string)
                    .append("bodyModelIds = new int[]{").toString();
            int i_8_;
            int i_7_ = i_8_ = 0;
            while (i_7_ < identityKit.bodyModelIds.length - 1) {
                string_6_ = new StringBuilder().append(string_6_)
                        .append(identityKit.bodyModelIds[i_8_]).append(", ")
                        .toString();
                i_7_ = ++i_8_;
            }
            string_6_ = new StringBuilder()
                    .append(string_6_)
                    .append(identityKit.bodyModelIds[identityKit.bodyModelIds.length - 1])
                    .append("};\n").toString();
        }
        if (identityKit.client_aShortArray1234 != null) {
            string_6_ = new StringBuilder().append(string_6_).append(string)
                    .append("aShortArray1234 = new int[]{").toString();
            int i_10_;
            int i_9_ = i_10_ = 0;
            while (i_9_ < identityKit.client_aShortArray1234.length - 1) {
                string_6_ = new StringBuilder().append(string_6_)
                        .append(identityKit.client_aShortArray1234[i_10_])
                        .append(", ").toString();
                i_9_ = ++i_10_;
            }
            string_6_ = new StringBuilder()
                    .append(string_6_)
                    .append(identityKit.client_aShortArray1234[identityKit.client_aShortArray1234.length - 1])
                    .append("};\n").toString();
        }
        if (identityKit.client_aShortArray1248 != null) {
            string_6_ = new StringBuilder().append(string_6_).append(string)
                    .append("aShortArray1248 = new int[]{").toString();
            int i_12_;
            int i_11_ = i_12_ = 0;
            while (i_11_ < identityKit.client_aShortArray1248.length - 1) {
                string_6_ = new StringBuilder().append(string_6_)
                        .append(identityKit.client_aShortArray1248[i_12_])
                        .append(", ").toString();
                i_11_ = ++i_12_;
            }
            string_6_ = new StringBuilder()
                    .append(string_6_)
                    .append(identityKit.client_aShortArray1248[identityKit.client_aShortArray1248.length - 1])
                    .append("};\n").toString();
        }
        if (identityKit.client_aShortArray1230 != null) {
            string_6_ = new StringBuilder().append(string_6_).append(string)
                    .append("aShortArray1230 = new int[]{").toString();
            int i_14_;
            int i_13_ = i_14_ = 0;
            while (i_13_ < identityKit.client_aShortArray1230.length - 1) {
                string_6_ = new StringBuilder().append(string_6_)
                        .append(identityKit.client_aShortArray1230[i_14_])
                        .append(", ").toString();
                i_13_ = ++i_14_;
            }
            string_6_ = new StringBuilder()
                    .append(string_6_)
                    .append(identityKit.client_aShortArray1230[identityKit.client_aShortArray1230.length - 1])
                    .append("};\n").toString();
        }
        if (identityKit.client_aShortArray1251 != null) {
            string_6_ = new StringBuilder().append(string_6_).append(string)
                    .append("aShortArray1251 = new int[]{").toString();
            int i_16_;
            int i_15_ = i_16_ = 0;
            while (i_15_ < identityKit.client_aShortArray1251.length - 1) {
                string_6_ = new StringBuilder().append(string_6_)
                        .append(identityKit.client_aShortArray1251[i_16_])
                        .append(", ").toString();
                i_15_ = ++i_16_;
            }
            string_6_ = new StringBuilder()
                    .append(string_6_)
                    .append(identityKit.client_aShortArray1251[identityKit.client_aShortArray1251.length - 1])
                    .append("};\n").toString();
        }
        if (identityKit.headModelIds != an_IdentityKit_269.headModelIds) {
            string_6_ = new StringBuilder().append(string_6_).append(string)
                    .append("headModelIds = new int[]{").toString();
            int i_18_;
            int i_17_ = i_18_ = 0;
            while (i_17_ < identityKit.headModelIds.length - 1) {
                string_6_ = new StringBuilder().append(string_6_)
                        .append(identityKit.headModelIds[i_18_]).append(", ")
                        .toString();
                i_17_ = ++i_18_;
            }
            string_6_ = new StringBuilder()
                    .append(string_6_)
                    .append(identityKit.headModelIds[identityKit.headModelIds.length - 1])
                    .append("};\n").toString();
        }
        return string_6_ = new StringBuilder().append(string_6_)
                .append(string_5_).append("\n").toString();
    }

    private void method10(ActionEvent actionevent) {
    }

    private void method102(KeyEvent keyevent) {
        method64();
    }

    private void method113(KeyEvent keyevent) {
        method64();
    }

    private void method12(ActionEvent actionevent) {
        aBoolean_289 = false;
        method3();
        aRenderable_Sub_259 = new Renderable_Sub(method97(),
                Integer.parseInt(aJTextField_284.getText()));
    }

    private void method14(ActionEvent actionevent) {
        int i = Integer.parseInt(aJTextField_284.getText()) + 1;
        aJTextField_284.setText(new StringBuilder().append(i).append("")
                .toString());
        aRenderable_Sub_259 = new Renderable_Sub(method97(),
                Integer.parseInt(aJTextField_284.getText()));
    }

    private void method15(ActionEvent actionevent) {
        int i = Integer.parseInt(aJTextField_284.getText()) - 1;
        aJTextField_284.setText(new StringBuilder().append(i).append("")
                .toString());
        aRenderable_Sub_259 = new Renderable_Sub(method97(),
                Integer.parseInt(aJTextField_284.getText()));
    }

    private void method19(ActionEvent actionevent) {
        aBoolean_289 = true;
        method3();
        aRenderable_Sub_259 = new Renderable_Sub(method97(),
                Integer.parseInt(aJTextField_284.getText()));
    }

    private void method20(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                try {
                    String string = method105(aInt_248);
                    BufferedWriter writer = new BufferedWriter(new FileWriter(
                            file, false));
                    writer.write(string);
                    writer.flush();
                    writer.close();
                } catch (Exception exception) {
                    /* empty */
                }
            }
        }
    }

    public void updateProgressBar(String string, int val) {
        progessBar.setString(string);
        progessBar.setValue(val);
    }

    private void method25(ListSelectionEvent listselectionevent) {
        if (!listselectionevent.getValueIsAdjusting()) {
            String string = aJList_254.getModel()
                    .getElementAt(aJList_254.getAnchorSelectionIndex())
                    .toString();
            aInt_248 = Integer.parseInt(string);
            aJLabel_272.setText(new StringBuilder().append("").append(aInt_248)
                    .toString());
            an_IdentityKit_285 = IdentityKit.get(GUI.cache, aInt_248, true);
            method64();
            method3();
            aRenderable_Sub_259 = new Renderable_Sub(method97(),
                    Integer.parseInt(aJTextField_284.getText()));
        }
    }

    private void method3() {
        int i;
        if ((i = an_IdentityKit_285.bodyPartId) >= 7) {
            i -= 7;
            aBoolean_289 = false;
        } else {
            aBoolean_289 = true;
        }
        int i_46_;
        int i_45_ = i_46_ = 0;
        while (i_45_ < 7) {
            anIntArray_249[i_46_] = -1;
            int i_48_;
            int i_47_ = i_48_ = 0;
            while (i_47_ < totalDefinitions) {
                if (!IdentityKit.get(GUI.cache, i_48_).notSelectable
                        && IdentityKit.get(GUI.cache, i_48_).bodyPartId == i_46_
                        + (aBoolean_289 ? 0 : 7)) {
                    anIntArray_249[i_46_] = i_48_;
                    break;
                }
                i_47_ = ++i_48_;
            }
            i_45_ = ++i_46_;
        }
        anIntArray_249[i] = aInt_248;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void method30(Cache cache) {
        totalDefinitions = cache.getFileSystems()[2].getChildCount(3);
        aJLabel_252.setText(new StringBuilder().append("")
                .append(totalDefinitions).toString());
        final int count;
        final String[] strings = new String[count = totalDefinitions];
        int i_20_;
        int i_19_ = i_20_ = 0;
        while (i_19_ < count) {
            strings[i_20_] = new StringBuilder().append("").append(i_20_)
                    .toString();
            i_19_ = ++i_20_;
        }
        aJList_254.setModel(new AbstractListModel() {

            String[] aStringArray_425 = strings;

            public Object getElementAt(int index) {
                return aStringArray_425[index];
            }

            public int getSize() {
                return aStringArray_425.length;
            }
        });
        aInt_248 = 0;
        aJList_254.setSelectedIndex(aInt_248);
        aJLabel_272.setText(new StringBuilder().append("").append(aInt_248)
                .toString());
        IdentityKit.caches = new HashMap();
        an_IdentityKit_269 = IdentityKit.get(GUI.cache, 20000, false);
        void_method38();
        Model.resetModelHeaders(1);
        method3();
        thread = new Thread_sub_130();
        thread.start();
    }

    private void method33(WindowEvent windowevent) {
        aRenderable_Sub_259 = null;
    }

    private void method35(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int i_0_ = mouseevent.getY();
        if (anInt_260 == -1 && anInt_256 == -1) {
            anInt_260 = i;
            anInt_256 = i_0_;
        } else {
            anInt_281 += anInt_260 - i;
            if (anInt_281 < 0) {
                anInt_281 = anInt_281 + 2048;
            } else if (anInt_281 >= 2048) {
                anInt_281 = 2048 - anInt_281;
            }
            anInt_263 -= anInt_256 - i_0_;
            if (anInt_263 < 0) {
                anInt_263 = anInt_263 + 2048;
            } else if (anInt_263 >= 2048) {
                anInt_263 = 2048 - anInt_263;
            }
            anInt_260 = i;
            anInt_256 = i_0_;
        }
    }

    private void method36(MouseEvent mouseevent) {
        anInt_256 = anInt_260 = -1;
    }

    private void method37(ComponentEvent componentevent) {
        if (panel.getWidth() >= 1 && panel.getHeight() >= 1) {
            void_method38();
        }
    }

    public void void_method38() {
        graphicsBuffer = new ProducingGraphicsBuffer(panel.getWidth(),
                panel.getHeight(), panel);
        graphicsBuffer.method88(20);
    }

    private void method39(MouseWheelEvent mousewheelevent) {
        int i = mousewheelevent.getWheelRotation();
        anInt_277 += i * 10;
    }

    private void method4(ActionEvent actionevent) {
        try {
            aRenderable_Sub_259 = new Renderable_Sub(method97(),
                    Integer.parseInt(aJTextField_284.getText()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void method45(MouseEvent mouseevent) {
        /* empty */
    }

    private void method5(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                IdentityKitSaverThread thread = new IdentityKitSaverThread(
                        file, 1);
                thread.start();
            }
        }
    }

    public void method64() {
        String string = method105(aInt_248);
        aJTextArea_255.setText(string);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void method65() {
        buttonGroup = new ButtonGroup();
        aJLabel_252 = new JLabel();
        saveFullDumpButton = new JButton();
        idkPartsListLabel = new JLabel();
        packIDKFileButton = new JButton();
        selectedPartIdLabel = new JLabel();
        totalPartsLabel = new JLabel();
        endLabel = new JLabel();
        aJLabel_272 = new JLabel();
        saveDumpButton = new JButton();
        aJScrollPane_275 = new JScrollPane();
        aJTextArea_255 = new JTextArea();
        dumpLabel = new JLabel();
        progessBar = new JProgressBar();
        aJLabel_242 = new JLabel();
        aJTextField_264 = new JTextField();
        aJScrollPane_267 = new JScrollPane();
        aJList_254 = new JList<Object>();
        aJTextField_245 = new JTextField();
        aJTextField_251 = new JTextField();
        aJLabel_262 = new JLabel();
        aJButton_280 = new JButton();
        panel = new JPanel();
        aJLabel_43 = new JLabel();
        maleRadioButton = new JRadioButton();
        shemaleRadioButton = new JRadioButton();
        aJTextField_284 = new JTextField();
        aJButton_258 = new JButton();
        aJButton_265 = new JButton();
        aJButton_283 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("RSDS - Identity Kit Definitions");
        setResizable(false);
        addWindowListener(new WindowAdapter() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void windowClosing(WindowEvent windowevent) {
                method104(frame, windowevent);
            }
        });
        aJLabel_252.setText("loading...");
        saveFullDumpButton.setText("Save Full Dump");
        saveFullDumpButton.setFocusable(false);
        saveFullDumpButton.addActionListener(new ActionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method101(frame, actionevent);
            }
        });
        idkPartsListLabel.setFont(new Font("Tahoma", 1, 11));
        idkPartsListLabel.setText("IDK parts List:");
        packIDKFileButton.setText("Pack idk.dat");
        packIDKFileButton.setFocusable(false);
        packIDKFileButton.addActionListener(new ActionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method100(frame, actionevent);
            }
        });
        selectedPartIdLabel.setFont(new Font("Tahoma", 1, 11));
        selectedPartIdLabel.setText("Selected IDK part Id:");
        totalPartsLabel.setFont(new Font("Tahoma", 1, 11));
        totalPartsLabel.setText("Total IDK parts:");
        endLabel.setFont(new Font("Tahoma", 1, 11));
        endLabel.setText("End:");
        aJLabel_272.setText("loading...");
        saveDumpButton.setText("Save Dump");
        saveDumpButton.setFocusable(false);
        saveDumpButton.addActionListener(new ActionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method103(frame, actionevent);
            }
        });
        aJTextArea_255.setColumns(20);
        aJTextArea_255.setEditable(false);
        aJTextArea_255.setFont(new Font("Monospaced", 0, 11));
        aJTextArea_255.setRows(5);
        aJScrollPane_275.setViewportView(aJTextArea_255);
        dumpLabel.setFont(new Font("Tahoma", 1, 11));
        dumpLabel.setText("Dump:");
        progessBar.setString("");
        progessBar.setStringPainted(true);
        aJLabel_242.setFont(new Font("Tahoma", 1, 11));
        aJLabel_242.setText("Var. prefix:");
        aJTextField_264.setText("tab/tab/cache[j].");
        aJTextField_264.addKeyListener(new KeyAdapter() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                method95(frame, keyevent);
            }
        });
        aJList_254.setModel(new AbstractListModel() {

            String[] aStringArray_291;

            {
                aStringArray_291 = new String[]{"loading..."};
            }

            public Object getElementAt(int index) {
                return aStringArray_291[index];
            }

            public int getSize() {
                return aStringArray_291.length;
            }
        });
        aJList_254.addListSelectionListener(new ListSelectionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void valueChanged(ListSelectionEvent listselectionevent) {
                method99(frame, listselectionevent);
            }
        });
        aJScrollPane_267.setViewportView(aJList_254);
        aJTextField_245.setText("tab/case id/:");
        aJTextField_245.addKeyListener(new KeyAdapter() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                method112(frame, keyevent);
            }
        });
        aJTextField_251.setText("tab/break;");
        aJTextField_251.addKeyListener(new KeyAdapter() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                void_method94(frame, keyevent);
            }
        });
        aJLabel_262.setFont(new Font("Tahoma", 1, 11));
        aJLabel_262.setText("Start:");
        aJButton_280.setText("Save IDK Models");
        aJButton_280.setEnabled(false);
        aJButton_280.setFocusable(false);
        aJButton_280.addActionListener(new ActionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method111(frame, actionevent);
            }
        });
        panel.setBorder(BorderFactory
                .createLineBorder(new Color(204, 204, 204)));
        panel.setForeground(new Color(244, 244, 244));
        panel.addMouseWheelListener(new MouseWheelListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void mouseWheelMoved(MouseWheelEvent mousewheelevent) {
                method116(frame, mousewheelevent);
            }
        });
        panel.addMouseListener(new MouseAdapter() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void mousePressed(MouseEvent mouseevent) {
                method117(frame, mouseevent);
            }

            public void mouseReleased(MouseEvent mouseevent) {
                method108(frame, mouseevent);
            }
        });
        panel.addComponentListener(new ComponentAdapter() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void componentResized(ComponentEvent componentevent) {
                method115(frame, componentevent);
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void mouseDragged(MouseEvent mouseevent) {
                method114(frame, mouseevent);
            }
        });
        GroupLayout grouplayout = new GroupLayout(panel);
        panel.setLayout(grouplayout);
        grouplayout.setHorizontalGroup(grouplayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 200, 32767));
        grouplayout.setVerticalGroup(grouplayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 301, 32767));
        aJLabel_43.setText(".....");
        buttonGroup.add(maleRadioButton);
        maleRadioButton.setSelected(true);
        maleRadioButton.setText("Male");
        maleRadioButton.setBorder(null);
        maleRadioButton.addActionListener(new ActionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method109(frame, actionevent);
            }
        });
        buttonGroup.add(shemaleRadioButton);
        shemaleRadioButton.setText("Shemale");
        shemaleRadioButton.setBorder(null);
        shemaleRadioButton.addActionListener(new ActionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method110(frame, actionevent);
            }
        });
        aJTextField_284.setText("808");
        aJButton_258.setText("Set");
        aJButton_258.addActionListener(new ActionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method98(frame, actionevent);
            }
        });
        aJButton_265.setText("+");
        aJButton_265.setBorder(null);
        aJButton_265.addActionListener(new ActionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method106(frame, actionevent);
            }
        });
        aJButton_283.setText("-");
        aJButton_283.setBorder(null);
        aJButton_283.addActionListener(new ActionListener() {

            final IdentityKitDefinitionFrame frame = IdentityKitDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method107(frame, actionevent);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        totalPartsLabel)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        aJLabel_252)
                                                                .addGap(45, 45,
                                                                        45)
                                                                .addComponent(
                                                                        selectedPartIdLabel)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(
                                                                        aJLabel_272))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        idkPartsListLabel)
                                                                                .addComponent(
                                                                                        aJScrollPane_267,
                                                                                        -2,
                                                                                        93,
                                                                                        -2))
                                                                .addGap(10, 10,
                                                                        10)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        dumpLabel)
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(
                                                                                                                        layout.createParallelGroup(
                                                                                                                                        GroupLayout.Alignment.LEADING,
                                                                                                                                        false)
                                                                                                                                .addGroup(
                                                                                                                                        layout.createSequentialGroup()
                                                                                                                                                .addComponent(
                                                                                                                                                        aJLabel_242)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(
                                                                                                                                                        aJTextField_264,
                                                                                                                                                        -2,
                                                                                                                                                        99,
                                                                                                                                                        -2)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(
                                                                                                                                                        aJLabel_262)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(
                                                                                                                                                        aJTextField_245,
                                                                                                                                                        -2,
                                                                                                                                                        99,
                                                                                                                                                        -2)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(
                                                                                                                                                        endLabel)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(
                                                                                                                                                        aJTextField_251,
                                                                                                                                                        -2,
                                                                                                                                                        99,
                                                                                                                                                        -2))
                                                                                                                                .addComponent(
                                                                                                                                        aJScrollPane_275,
                                                                                                                                        -2,
                                                                                                                                        436,
                                                                                                                                        -2)
                                                                                                                                .addGroup(
                                                                                                                                        layout.createSequentialGroup()
                                                                                                                                                .addComponent(
                                                                                                                                                        saveDumpButton,
                                                                                                                                                        -2,
                                                                                                                                                        105,
                                                                                                                                                        -2)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(
                                                                                                                                                        saveFullDumpButton,
                                                                                                                                                        -2,
                                                                                                                                                        105,
                                                                                                                                                        -2)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(
                                                                                                                                                        packIDKFileButton)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(
                                                                                                                                                        aJButton_280,
                                                                                                                                                        -1,
                                                                                                                                                        -1,
                                                                                                                                                        32767)))
                                                                                                                .addComponent(
                                                                                                                        progessBar,
                                                                                                                        -2,
                                                                                                                        436,
                                                                                                                        -2))
                                                                                                .addGap(46,
                                                                                                        46,
                                                                                                        46)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(
                                                                                                                        layout.createSequentialGroup()
                                                                                                                                .addComponent(
                                                                                                                                        aJButton_283,
                                                                                                                                        -2,
                                                                                                                                        17,
                                                                                                                                        -2)
                                                                                                                                .addPreferredGap(
                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addGroup(
                                                                                                                                        layout.createParallelGroup(
                                                                                                                                                        GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(
                                                                                                                                                        layout.createSequentialGroup()
                                                                                                                                                                .addGap(8,
                                                                                                                                                                        8,
                                                                                                                                                                        8)
                                                                                                                                                                .addComponent(
                                                                                                                                                                        maleRadioButton)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(
                                                                                                                                                                        shemaleRadioButton)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                        49,
                                                                                                                                                                        32767)
                                                                                                                                                                .addComponent(
                                                                                                                                                                        aJLabel_43))
                                                                                                                                                .addGroup(
                                                                                                                                                        layout.createSequentialGroup()
                                                                                                                                                                .addComponent(
                                                                                                                                                                        aJButton_265,
                                                                                                                                                                        -2,
                                                                                                                                                                        17,
                                                                                                                                                                        -2)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(
                                                                                                                                                                        aJTextField_284,
                                                                                                                                                                        -2,
                                                                                                                                                                        60,
                                                                                                                                                                        -2)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(
                                                                                                                                                                        aJButton_258,
                                                                                                                                                                        -2,
                                                                                                                                                                        61,
                                                                                                                                                                        -2))))
                                                                                                                .addComponent(
                                                                                                                        panel,
                                                                                                                        -2,
                                                                                                                        -1,
                                                                                                                        -2))))
                                                                .addGap(35, 35,
                                                                        35)))
                                .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                        GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.BASELINE)
                                                .addComponent(totalPartsLabel)
                                                .addComponent(aJLabel_252)
                                                .addComponent(
                                                        selectedPartIdLabel)
                                                .addComponent(aJLabel_272))
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        idkPartsListLabel)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED))
                                                .addGroup(
                                                        GroupLayout.Alignment.TRAILING,
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        dumpLabel)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                .addComponent(aJScrollPane_267,
                                                        -1, 361, 32767)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.LEADING)
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        aJScrollPane_275,
                                                                                                        -2,
                                                                                                        219,
                                                                                                        -2)
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(
                                                                                                                        aJLabel_242)
                                                                                                                .addComponent(
                                                                                                                        aJTextField_264,
                                                                                                                        -2,
                                                                                                                        -1,
                                                                                                                        -2)
                                                                                                                .addComponent(
                                                                                                                        aJLabel_262)
                                                                                                                .addComponent(
                                                                                                                        aJTextField_245,
                                                                                                                        -2,
                                                                                                                        -1,
                                                                                                                        -2)
                                                                                                                .addComponent(
                                                                                                                        endLabel)
                                                                                                                .addComponent(
                                                                                                                        aJTextField_251,
                                                                                                                        -2,
                                                                                                                        -1,
                                                                                                                        -2))
                                                                                                .addGap(18,
                                                                                                        18,
                                                                                                        18)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.LEADING,
                                                                                                                        false)
                                                                                                                .addComponent(
                                                                                                                        saveDumpButton,
                                                                                                                        -1,
                                                                                                                        40,
                                                                                                                        32767)
                                                                                                                .addComponent(
                                                                                                                        saveFullDumpButton,
                                                                                                                        -1,
                                                                                                                        40,
                                                                                                                        32767)
                                                                                                                .addComponent(
                                                                                                                        packIDKFileButton,
                                                                                                                        -1,
                                                                                                                        40,
                                                                                                                        32767)
                                                                                                                .addComponent(
                                                                                                                        aJButton_280,
                                                                                                                        -1,
                                                                                                                        40,
                                                                                                                        32767)))
                                                                                .addComponent(
                                                                                        panel,
                                                                                        -1,
                                                                                        -1,
                                                                                        32767))
                                                                .addGap(12, 12,
                                                                        12)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        progessBar,
                                                                                                        -2,
                                                                                                        -1,
                                                                                                        -2)
                                                                                                .addGap(15,
                                                                                                        15,
                                                                                                        15))
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(
                                                                                                                        aJTextField_284,
                                                                                                                        -2,
                                                                                                                        -1,
                                                                                                                        -2)
                                                                                                                .addComponent(
                                                                                                                        aJButton_258)
                                                                                                                .addComponent(
                                                                                                                        aJButton_265)
                                                                                                                .addComponent(
                                                                                                                        aJButton_283))
                                                                                                .addGap(8,
                                                                                                        8,
                                                                                                        8)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(
                                                                                                                        aJLabel_43)
                                                                                                                .addComponent(
                                                                                                                        maleRadioButton)
                                                                                                                .addComponent(
                                                                                                                        shemaleRadioButton))))))
                                .addContainerGap()));
        pack();
    }

    private void method9(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                IdentityKitSaverThread thread_sub_31 = new IdentityKitSaverThread(
                        file, 0);
                thread_sub_31.start();
            }
        }
    }

    private void method96(KeyEvent keyevent) {
        method64();
    }

}