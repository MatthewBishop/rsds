package dev.openrune.rsds.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.fs.def.AnimationDefinition;
import dev.openrune.rsds.GUI;

@SuppressWarnings("serial")
public class AnimationDefinitionFrame extends JFrame {

    public static int totalAnimationCount;

    static void method118(AnimationDefinitionFrame jframe_sub_67,
                          KeyEvent keyevent) {
        jframe_sub_67.processScrollPaneKeyEvent(keyevent);
    }

    static void void_method119(AnimationDefinitionFrame jframe_sub_67,
                               ActionEvent actionevent) {
        jframe_sub_67.writeDefinitionsToFile(actionevent);
    }

    static void method120(AnimationDefinitionFrame jframe_sub_67,
                          ActionEvent actionevent) {
        jframe_sub_67.packDefinitionsToSeq(actionevent);
    }

    static void void_method121(AnimationDefinitionFrame jframe_sub_67,
                               ListSelectionEvent listselectionevent) {
        jframe_sub_67.method25(listselectionevent);
    }

    static void void_method122(AnimationDefinitionFrame jframe_sub_67,
                               KeyEvent keyevent) {
        jframe_sub_67.method113(keyevent);
    }

    static void void_method123(AnimationDefinitionFrame jframe_sub_67,
                               KeyEvent keyevent) {
        jframe_sub_67.void_method102(keyevent);
    }

    static void method124(AnimationDefinitionFrame jframe_sub_67,
                          ActionEvent actionevent) {
        jframe_sub_67.dumpDefinitions(actionevent);
    }

    public int anInt_313;
    private JButton saveDumpLabel;
    private JButton packSeqDatButton;
    private JButton saveFullDumpButton;
    JFileChooser fileChooser;
    private JLabel animationListLabel;
    private JLabel selectedAnimationLabel;
    private JLabel prefixLabel;
    private JLabel an_JLabel_308;
    private JLabel startLabel;
    private JLabel dumpLabel;
    private JLabel totalAnimationsLabel;
    private JLabel endLabel;
    private JLabel an_JLabel_322;
    private JList<?> an_JList_320;
    private JProgressBar progressBar;
    private JScrollPane mainScrollPane;
    private JScrollPane an_JScrollPane_311;
    private JTextArea scrollPaneView;
    private JTextField animsTextField;
    private JTextField idTextField;
    private JTextField breakTextField;
    AnimationDefinition animationDefinition;

    public AnimationDefinitionFrame() {
        init();
        fileChooser = new JFileChooser();
    }

    public String getDefinitionAsJavaCode(int id) {
        String animFieldText = animsTextField.getText()
                .replaceAll("tab/", "\t").replaceAll("id/", "" + id);
        String idFieldText = idTextField.getText().replaceAll("tab/", "\t")
                .replaceAll("id/", "" + id);
        String breakFieldText = breakTextField.getText()
                .replaceAll("tab/", "\t").replaceAll("id/", "" + id);
        AnimationDefinition definition = AnimationDefinition
                .getDefinition(GUI.cache, id, true);
        String definitionAsString = "";
        definitionAsString = new StringBuilder().append(definitionAsString)
                .append(idFieldText).append("\n").toString();
        definitionAsString = new StringBuilder().append(definitionAsString)
                .append(animFieldText).append("id = ").append(id).append(";\n")
                .toString();
        if (definition.frames != null) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("fileId = ")
                    .append(definition.frames[0] >> 16).append(";\n")
                    .toString();
        }
        definitionAsString = new StringBuilder().append(definitionAsString)
                .append(animFieldText).append("frameCount = ")
                .append(definition.frameCount).append(";\n").toString();
        if (animationDefinition == null) {
            animationDefinition = AnimationDefinition.getDefinition(
                    GUI.cache, 20000, false);
        }
        if (definition.loopCycles != animationDefinition.loopCycles) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("loopCycles = ")
                    .append(definition.loopCycles).append(";\n").toString();
        }
        if (definition.loopDelay != animationDefinition.loopDelay) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("loopDelay = ")
                    .append(definition.loopDelay).append(";\n").toString();
        }
        if (definition.priority != animationDefinition.priority) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("priority = ")
                    .append(definition.priority).append(";\n").toString();
        }
        if (definition.rightHandEquip != animationDefinition.rightHandEquip) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("rightHandEquip = ")
                    .append(definition.rightHandEquip).append(";\n").toString();
        }
        if (definition.leftHandEquip != animationDefinition.leftHandEquip) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("leftHandEquip = ")
                    .append(definition.leftHandEquip).append(";\n").toString();
        }
        if (definition.client_aBoolean358 != animationDefinition.client_aBoolean358) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("aBoolean358 = ")
                    .append(definition.client_aBoolean358).append(";\n")
                    .toString();
        }
        if (definition.client_anInt363 != animationDefinition.client_anInt363) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("anInt363 = ")
                    .append(definition.client_anInt363).append(";\n")
                    .toString();
        }
        if (definition.client_anInt364 != animationDefinition.client_anInt364) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("anInt364 = ")
                    .append(definition.client_anInt364).append(";\n")
                    .toString();
        }
        if (definition.client_anInt365 != animationDefinition.client_anInt365) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("anInt365 = ")
                    .append(definition.client_anInt365).append(";\n")
                    .toString();
        }
        if (definition.delays != null) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("delays = new int[]{")
                    .toString();
            int delay;
            int i_17_ = delay = 0;
            while (i_17_ < definition.delays.length - 1) {
                definitionAsString = new StringBuilder()
                        .append(definitionAsString)
                        .append(definition.delays[delay]).append(", ")
                        .toString();
                i_17_ = ++delay;
            }
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(definition.delays[definition.delays.length - 1])
                    .append("};\n").toString();
        }
        if (definition.frames != null) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("frames = new int[]{")
                    .toString();
            int frame;
            int i_19_ = frame = 0;
            while (i_19_ < definition.frames.length - 1) {
                definitionAsString = new StringBuilder()
                        .append(definitionAsString)
                        .append(definition.frames[frame]).append(", ")
                        .toString();
                i_19_ = ++frame;
            }
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(definition.frames[definition.frames.length - 1])
                    .append("};\n").toString();
        }
        if (definition.client_anIntArray357 != null) {
            definitionAsString = new StringBuilder().append(definitionAsString)
                    .append(animFieldText).append("anIntArray357 = new int[]{")
                    .toString();
            int index;
            int i_21_ = index = 0;
            while (i_21_ < definition.client_anIntArray357.length - 1) {
                definitionAsString = new StringBuilder()
                        .append(definitionAsString)
                        .append(definition.client_anIntArray357[index])
                        .append(", ").toString();
                i_21_ = ++index;
            }
            definitionAsString = new StringBuilder()
                    .append(definitionAsString)
                    .append(definition.client_anIntArray357[definition.client_anIntArray357.length - 1])
                    .append("};\n").toString();
        }
        return definitionAsString = new StringBuilder()
                .append(definitionAsString).append(breakFieldText).append("\n")
                .toString();
    }

    private void void_method102(KeyEvent keyevent) {
        setViewAsCompilableCode();
    }

    private void method113(KeyEvent keyevent) {
        setViewAsCompilableCode();
    }

    private void packDefinitionsToSeq(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                AnimationDefinitionSaverThread thread = new AnimationDefinitionSaverThread(
                        file, 1);
                thread.start();
            }
        }
    }

    private void dumpDefinitions(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                AnimationDefinitionSaverThread thread = new AnimationDefinitionSaverThread(
                        file, 0);
                thread.start();
            }
        }
    }

    private void writeDefinitionsToFile(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                try {
                    String string = getDefinitionAsJavaCode(anInt_313);
                    BufferedWriter bufferedwriter = new BufferedWriter(
                            new FileWriter(file, false));
                    bufferedwriter.write(string);
                    bufferedwriter.flush();
                    bufferedwriter.close();
                } catch (Exception exception) {
                }
            }
        }
    }

    public void updateProgressBar(String string, int completion) {
        progressBar.setString(string);
        progressBar.setValue(completion);
    }

    private void method25(ListSelectionEvent listselectionevent) {
        if (!listselectionevent.getValueIsAdjusting()) {
            String string = an_JList_320.getModel()
                    .getElementAt(an_JList_320.getAnchorSelectionIndex())
                    .toString();
            anInt_313 = Integer.parseInt(string);
            an_JLabel_308.setText(new StringBuilder().append("")
                    .append(anInt_313).toString());
            setViewAsCompilableCode();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void init() {
        totalAnimationsLabel = new JLabel();
        an_JLabel_322 = new JLabel();
        an_JScrollPane_311 = new JScrollPane();
        an_JList_320 = new JList<Object>();
        animationListLabel = new JLabel();
        selectedAnimationLabel = new JLabel();
        an_JLabel_308 = new JLabel();
        mainScrollPane = new JScrollPane();
        scrollPaneView = new JTextArea();
        dumpLabel = new JLabel();
        prefixLabel = new JLabel();
        animsTextField = new JTextField();
        idTextField = new JTextField();
        startLabel = new JLabel();
        breakTextField = new JTextField();
        endLabel = new JLabel();
        saveDumpLabel = new JButton();
        saveFullDumpButton = new JButton();
        packSeqDatButton = new JButton();
        progressBar = new JProgressBar();
        setDefaultCloseOperation(2);
        setTitle("RSDS - Animation Definitions");
        setResizable(false);
        totalAnimationsLabel.setFont(new Font("Tahoma", 1, 11));
        totalAnimationsLabel.setText("Total anims.:");
        an_JLabel_322.setText("loading...");
        an_JList_320.setModel(new AbstractListModel() {

            String[] loading;

            {

                loading = new String[]{"loading..."};
            }

            public Object getElementAt(int i) {
                return loading[i];
            }

            public int getSize() {
                return loading.length;
            }
        });
        an_JList_320.addListSelectionListener(new ListSelectionListener() {

            final AnimationDefinitionFrame frame = AnimationDefinitionFrame.this;

            public void valueChanged(ListSelectionEvent listselectionevent) {
                void_method121(frame, listselectionevent);
            }
        });
        an_JScrollPane_311.setViewportView(an_JList_320);
        animationListLabel.setFont(new Font("Tahoma", 1, 11));
        animationListLabel.setText("Animation List:");
        selectedAnimationLabel.setFont(new Font("Tahoma", 1, 11));
        selectedAnimationLabel.setText("Selected Animation Id:");
        an_JLabel_308.setText("loading...");
        scrollPaneView.setColumns(20);
        scrollPaneView.setEditable(false);
        scrollPaneView.setFont(new Font("Monospaced", 0, 11));
        scrollPaneView.setRows(5);
        mainScrollPane.setViewportView(scrollPaneView);
        dumpLabel.setFont(new Font("Tahoma", 1, 11));
        dumpLabel.setText("Dump:");
        prefixLabel.setFont(new Font("Tahoma", 1, 11));
        prefixLabel.setText("Var. prefix:");
        animsTextField.setText("tab/tab/anims[j].");
        animsTextField.addKeyListener(new KeyAdapter() {

            final AnimationDefinitionFrame frame = AnimationDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                void_method122(frame, keyevent);
            }
        });
        idTextField.setText("tab/case id/:");
        idTextField.addKeyListener(new KeyAdapter() {

            final AnimationDefinitionFrame frame = AnimationDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                void_method123(frame, keyevent);
            }
        });
        startLabel.setFont(new Font("Tahoma", 1, 11));
        startLabel.setText("Start:");
        breakTextField.setText("tab/break;");
        breakTextField.addKeyListener(new KeyAdapter() {

            final AnimationDefinitionFrame frame = AnimationDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                method118(frame, keyevent);
            }
        });
        endLabel.setFont(new Font("Tahoma", 1, 11));
        endLabel.setText("End:");
        saveDumpLabel.setText("Save Dump");
        saveDumpLabel.setFocusable(false);
        saveDumpLabel.addActionListener(new ActionListener() {

            final AnimationDefinitionFrame frame = AnimationDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                void_method119(frame, actionevent);
            }
        });
        saveFullDumpButton.setText("Save Full Dump");
        saveFullDumpButton.setFocusable(false);
        saveFullDumpButton.addActionListener(new ActionListener() {

            final AnimationDefinitionFrame frame = AnimationDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method124(frame, actionevent);
            }
        });
        packSeqDatButton.setText("Pack seq.dat");
        packSeqDatButton.setFocusable(false);
        packSeqDatButton.addActionListener(new ActionListener() {

            final AnimationDefinitionFrame frame = AnimationDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method120(frame, actionevent);
            }
        });
        progressBar.setString("");
        progressBar.setStringPainted(true);
        GroupLayout grouplayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(grouplayout);
        grouplayout
                .setHorizontalGroup(grouplayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                grouplayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                grouplayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                totalAnimationsLabel)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                an_JLabel_322))
                                                        .addComponent(
                                                                animationListLabel)
                                                        .addComponent(
                                                                an_JScrollPane_311,
                                                                -2, 93, -2))
                                        .addGap(53, 53, 53)
                                        .addGroup(
                                                grouplayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                GroupLayout.Alignment.TRAILING,
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                grouplayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                selectedAnimationLabel)
                                                                                                        .addGap(6,
                                                                                                                6,
                                                                                                                6)
                                                                                                        .addComponent(
                                                                                                                an_JLabel_308))
                                                                                        .addGroup(
                                                                                                grouplayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                prefixLabel)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                animsTextField,
                                                                                                                -2,
                                                                                                                99,
                                                                                                                -2)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                startLabel)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                idTextField,
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
                                                                                                                breakTextField,
                                                                                                                -2,
                                                                                                                99,
                                                                                                                -2))
                                                                                        .addComponent(
                                                                                                dumpLabel)
                                                                                        .addComponent(
                                                                                                mainScrollPane,
                                                                                                -2,
                                                                                                436,
                                                                                                -2))
                                                                        .addGap(39,
                                                                                39,
                                                                                39))
                                                        .addGroup(
                                                                GroupLayout.Alignment.TRAILING,
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                        .addComponent(
                                                                                                progressBar,
                                                                                                GroupLayout.Alignment.TRAILING,
                                                                                                -1,
                                                                                                -1,
                                                                                                32767)
                                                                                        .addGroup(
                                                                                                GroupLayout.Alignment.TRAILING,
                                                                                                grouplayout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                saveDumpLabel,
                                                                                                                -2,
                                                                                                                117,
                                                                                                                -2)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                saveFullDumpButton,
                                                                                                                -2,
                                                                                                                117,
                                                                                                                -2)
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(
                                                                                                                packSeqDatButton,
                                                                                                                -2,
                                                                                                                117,
                                                                                                                -2)))
                                                                        .addGap(71,
                                                                                71,
                                                                                71)))));
        grouplayout
                .setVerticalGroup(grouplayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                grouplayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                grouplayout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                selectedAnimationLabel)
                                                                                        .addComponent(
                                                                                                an_JLabel_308))
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(
                                                                                dumpLabel)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                mainScrollPane,
                                                                                -2,
                                                                                219,
                                                                                -2)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                prefixLabel)
                                                                                        .addComponent(
                                                                                                animsTextField,
                                                                                                -2,
                                                                                                -1,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                startLabel)
                                                                                        .addComponent(
                                                                                                idTextField,
                                                                                                -2,
                                                                                                -1,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                endLabel)
                                                                                        .addComponent(
                                                                                                breakTextField,
                                                                                                -2,
                                                                                                -1,
                                                                                                -2))
                                                                        .addGap(29,
                                                                                29,
                                                                                29)
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                saveDumpLabel,
                                                                                                -2,
                                                                                                40,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                saveFullDumpButton,
                                                                                                -2,
                                                                                                40,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                packSeqDatButton,
                                                                                                -2,
                                                                                                40,
                                                                                                -2))
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(
                                                                                progressBar,
                                                                                -2,
                                                                                -1,
                                                                                -2))
                                                        .addGroup(
                                                                grouplayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                grouplayout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                totalAnimationsLabel)
                                                                                        .addComponent(
                                                                                                an_JLabel_322))
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(
                                                                                animationListLabel)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                an_JScrollPane_311,
                                                                                -1,
                                                                                347,
                                                                                32767)))
                                        .addContainerGap()));
        pack();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void method30(Cache cache) {
        totalAnimationCount = cache.getFileSystems()[20].getFileCount();
        an_JLabel_322.setText(new StringBuilder().append("")
                .append(totalAnimationCount).toString());
        final int count = totalAnimationCount;
        final String[] strings = new String[count];
        int index;
        int i_8_ = index = 0;
        while (i_8_ < count) {
            strings[index] = new StringBuilder().append("").append(index)
                    .toString();
            i_8_ = ++index;
        }
        an_JList_320.setModel(new AbstractListModel() {

            String[] strings;

            public Object getElementAt(int index) {
                return strings[index];
            }

            public int getSize() {
                return strings.length;
            }
        });
        anInt_313 = 0;
        an_JList_320.setSelectedIndex(anInt_313);
        an_JLabel_308.setText(new StringBuilder().append("").append(anInt_313)
                .toString());
        AnimationDefinition.caches = new HashMap();
        animationDefinition = AnimationDefinition.getDefinition(
                GUI.cache, 20000, false);
    }

    public void setViewAsCompilableCode() {
        String string = getDefinitionAsJavaCode(anInt_313);
        scrollPaneView.setText(string);
    }

    private void processScrollPaneKeyEvent(KeyEvent keyevent) {
        setViewAsCompilableCode();
    }

}