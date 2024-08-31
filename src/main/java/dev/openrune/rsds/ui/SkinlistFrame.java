package dev.openrune.rsds.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.fs.def.Class_n;
import dev.openrune.rsds.io.FileUtils;
import dev.openrune.rsds.GUI;

@SuppressWarnings("serial")
public class SkinlistFrame extends JFrame {

    public static int anInt_82;

    static void method24(SkinlistFrame frame, ActionEvent actionevent) {
        frame.packAllFrames(actionevent);
    }

    static void method26(SkinlistFrame frame, ActionEvent actionevent) {
        frame.packSkinLists(actionevent);
    }

    static void method27(SkinlistFrame frame, ActionEvent actionevent) {
        frame.method12(actionevent);
    }

    static void method28(SkinlistFrame frame, ActionEvent actionevent) {
        frame.method10(actionevent);
    }

    static void void_method29(SkinlistFrame frame,
                              ListSelectionEvent listselectionevent) {
        frame.method25(listselectionevent);
    }

    static void void_method31(SkinlistFrame frame, ActionEvent actionevent) {
        frame.packAllFiles(actionevent);
    }

    static void method32(SkinlistFrame frame, ActionEvent actionevent) {
        frame.method15(actionevent);
    }

    public int anInt_69;
    private JButton aJButton_71;
    private JButton packAllSkinlistFilesButton;
    private JButton packAllAnimFilesButton;
    private JButton packAllFrameFilesButton;
    private JButton packFrameFileLabel;
    private JButton aJButton_85;
    JFileChooser fileChooser;
    private JLabel totalFilesLabel;
    private JLabel aJLabel_73;
    private JLabel selectedFileIdLabel;
    private JLabel fileListLabel;
    private JLabel aJLabel_80;
    private JList<?> aJList_72;
    private JProgressBar progressBar;
    private JScrollPane scrollPane;

    public SkinlistFrame() {
        init();
        fileChooser = new JFileChooser();
    }

    private void method10(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                Class_n class_n = new Class_n();
                class_n.method183(GUI.cache, anInt_69, false);
                byte[] is = class_n.an_y_532.writeValues();
                FileUtils.write(file.getAbsolutePath(), is);
                System.gc();
            }
        }
    }

    private void method12(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                Class_n class_n = new Class_n();
                class_n.method183(GUI.cache, anInt_69, true);
                byte[] is = new byte[class_n.buffer.offset];
                System.arraycopy(class_n.buffer.payload, 0, is, 0,
                        class_n.buffer.offset);
                byte[] vals = class_n.an_y_532.writeValues();
                try {
                    RandomAccessFile raf = new RandomAccessFile(
                            file.getAbsolutePath(), "rw");
                    raf.write(vals);
                    raf.write(is);
                    raf.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.gc();
            }
        }
    }

    private void packAllFrames(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(1);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (file.isDirectory()) {
                SkinSaverThread thread = new SkinSaverThread(
                        file.getAbsolutePath(), 1);
                thread.start();
            }
        }
    }

    private void method15(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                Class_n class_n = new Class_n();
                class_n.method183(GUI.cache, anInt_69, true);
                byte[] vals = new byte[class_n.buffer.offset];
                System.arraycopy(class_n.buffer.payload, 0, vals, 0,
                        class_n.buffer.offset);
                FileUtils.write(file.getAbsolutePath(), vals);
                System.gc();
            }
        }
    }

    private void packSkinLists(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(1);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (file.isDirectory()) {
                SkinSaverThread thread = new SkinSaverThread(
                        file.getAbsolutePath(), 0);
                thread.start();
            }
        }
    }

    private void packAllFiles(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(1);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (file.isDirectory()) {
                SkinSaverThread thread = new SkinSaverThread(
                        file.getAbsolutePath(), 2);
                thread.start();
            }
        }
    }

    public void updateProgressBar(String string, int val) {
        progressBar.setString(string);
        progressBar.setValue(val);
    }

    private void method25(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting()) {
            String string = aJList_72.getModel()
                    .getElementAt(aJList_72.getAnchorSelectionIndex())
                    .toString();
            anInt_69 = Integer.parseInt(string);
            aJLabel_80.setText(new StringBuilder().append("").append(anInt_69)
                    .toString());
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void init() {
        selectedFileIdLabel = new JLabel();
        fileListLabel = new JLabel();
        scrollPane = new JScrollPane();
        aJList_72 = new JList<Object>();
        aJLabel_73 = new JLabel();
        packFrameFileLabel = new JButton();
        aJButton_71 = new JButton();
        aJButton_85 = new JButton();
        totalFilesLabel = new JLabel();
        progressBar = new JProgressBar();
        aJLabel_80 = new JLabel();
        packAllSkinlistFilesButton = new JButton();
        packAllAnimFilesButton = new JButton();
        packAllFrameFilesButton = new JButton();
        setDefaultCloseOperation(2);
        setTitle("RSDS - Anim Files (Frames|Skinlists)");
        setResizable(false);
        selectedFileIdLabel.setFont(new Font("Tahoma", 1, 11));
        selectedFileIdLabel.setText("Selected File Id:");
        fileListLabel.setFont(new Font("Tahoma", 1, 11));
        fileListLabel.setText("File List:");
        aJList_72.setModel(new AbstractListModel() {

            String[] strings;

            {

                strings = new String[]{"loading..."};
            }

            public Object getElementAt(int index) {
                return strings[index];
            }

            public int getSize() {
                return strings.length;
            }
        });
        aJList_72.addListSelectionListener(new ListSelectionListener() {

            final SkinlistFrame frame = SkinlistFrame.this;

            public void valueChanged(ListSelectionEvent listselectionevent) {
                void_method29(frame, listselectionevent);
            }
        });
        scrollPane.setViewportView(aJList_72);
        aJLabel_73.setText("loading...");
        packFrameFileLabel.setText("Pack Frame File");
        packFrameFileLabel.setFocusable(false);
        packFrameFileLabel.addActionListener(new ActionListener() {

            final SkinlistFrame frame = SkinlistFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method32(frame, actionevent);
            }
        });
        aJButton_71.setText("Pack Skinlist File");
        aJButton_71.setFocusable(false);
        aJButton_71.addActionListener(new ActionListener() {

            final SkinlistFrame frame = SkinlistFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method28(frame, actionevent);
            }
        });
        aJButton_85.setText("Pack Anim File");
        aJButton_85.setFocusable(false);
        aJButton_85.addActionListener(new ActionListener() {

            final SkinlistFrame frame = SkinlistFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method27(frame, actionevent);
            }
        });
        totalFilesLabel.setFont(new Font("Tahoma", 1, 11));
        totalFilesLabel.setText("Total files:");
        progressBar.setString("");
        progressBar.setStringPainted(true);
        aJLabel_80.setText("loading...");
        packAllSkinlistFilesButton.setText("Pack All Skinlist Files");
        packAllSkinlistFilesButton.setFocusable(false);
        packAllSkinlistFilesButton.addActionListener(new ActionListener() {

            final SkinlistFrame frame = SkinlistFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method26(frame, actionevent);
            }
        });
        packAllAnimFilesButton.setText("Pack All Anim Files");
        packAllAnimFilesButton.setFocusable(false);
        packAllAnimFilesButton.addActionListener(new ActionListener() {

            final SkinlistFrame frame = SkinlistFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                void_method31(frame, actionevent);
            }
        });
        packAllFrameFilesButton.setText("Pack All Frame Files");
        packAllFrameFilesButton.setFocusable(false);
        packAllFrameFilesButton.addActionListener(new ActionListener() {

            final SkinlistFrame frame = SkinlistFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method24(frame, actionevent);
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
                                                .addComponent(fileListLabel)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.LEADING)
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        totalFilesLabel)
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        aJLabel_73)
                                                                                                .addGap(22,
                                                                                                        22,
                                                                                                        22)
                                                                                                .addComponent(
                                                                                                        selectedFileIdLabel)
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        aJLabel_80))
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addGap(10,
                                                                                                        10,
                                                                                                        10)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(
                                                                                                                        progressBar,
                                                                                                                        -1,
                                                                                                                        273,
                                                                                                                        32767)
                                                                                                                .addGroup(
                                                                                                                        layout.createSequentialGroup()
                                                                                                                                .addComponent(
                                                                                                                                        scrollPane,
                                                                                                                                        -2,
                                                                                                                                        91,
                                                                                                                                        -2)
                                                                                                                                .addGap(34,
                                                                                                                                        34,
                                                                                                                                        34)
                                                                                                                                .addGroup(
                                                                                                                                        layout.createParallelGroup(
                                                                                                                                                        GroupLayout.Alignment.LEADING,
                                                                                                                                                        false)
                                                                                                                                                .addComponent(
                                                                                                                                                        packFrameFileLabel,
                                                                                                                                                        -1,
                                                                                                                                                        -1,
                                                                                                                                                        32767)
                                                                                                                                                .addComponent(
                                                                                                                                                        aJButton_71,
                                                                                                                                                        -1,
                                                                                                                                                        -1,
                                                                                                                                                        32767)
                                                                                                                                                .addComponent(
                                                                                                                                                        aJButton_85,
                                                                                                                                                        -1,
                                                                                                                                                        -1,
                                                                                                                                                        32767)
                                                                                                                                                .addComponent(
                                                                                                                                                        packAllFrameFilesButton,
                                                                                                                                                        -1,
                                                                                                                                                        -1,
                                                                                                                                                        32767)
                                                                                                                                                .addComponent(
                                                                                                                                                        packAllSkinlistFilesButton,
                                                                                                                                                        -1,
                                                                                                                                                        -1,
                                                                                                                                                        32767)
                                                                                                                                                .addComponent(
                                                                                                                                                        packAllAnimFilesButton,
                                                                                                                                                        -1,
                                                                                                                                                        132,
                                                                                                                                                        32767))
                                                                                                                                .addPreferredGap(
                                                                                                                                        LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                        16,
                                                                                                                                        32767)))))
                                                                .addGap(15, 15,
                                                                        15)))
                                .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.BASELINE)
                                                .addComponent(totalFilesLabel)
                                                .addComponent(aJLabel_73)
                                                .addComponent(
                                                        selectedFileIdLabel)
                                                .addComponent(aJLabel_80))
                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        fileListLabel)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        scrollPane,
                                                                        -2,
                                                                        312, -2))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(40, 40,
                                                                        40)
                                                                .addComponent(
                                                                        packFrameFileLabel,
                                                                        -2, 40,
                                                                        -2)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        aJButton_71,
                                                                        -2, 40,
                                                                        -2)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        aJButton_85,
                                                                        -2, 40,
                                                                        -2)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        packAllFrameFilesButton,
                                                                        -2, 40,
                                                                        -2)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        packAllSkinlistFilesButton,
                                                                        -2, 40,
                                                                        -2)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        packAllAnimFilesButton,
                                                                        -2, 40,
                                                                        -2)))
                                .addGap(13, 13, 13)
                                .addComponent(progressBar, -2, -1, -2)
                                .addContainerGap()));
        pack();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void method30(Cache class_n) {
        anInt_82 = class_n.getFileSystems()[0].method139();
        aJLabel_73.setText(new StringBuilder().append("").append(anInt_82)
                .toString());
        final int i;
        final String[] strings = new String[i = anInt_82];
        int i_10_;
        int i_9_ = i_10_ = 0;
        while (i_9_ < i) {
            strings[i_10_] = new StringBuilder().append("").append(i_10_)
                    .toString();
            i_9_ = ++i_10_;
        }
        aJList_72.setModel(new AbstractListModel() {

            final String[] an_an_String_array27_27;
            String[] an_an_String_array29_29;

            {
                an_an_String_array27_27 = strings;

                an_an_String_array29_29 = an_an_String_array27_27;
            }

            public Object getElementAt(int i_14_) {
                return an_an_String_array29_29[i_14_];
            }

            public int getSize() {
                return an_an_String_array29_29.length;
            }
        });
        anInt_69 = 0;
        aJList_72.setSelectedIndex(anInt_69);
        aJLabel_80.setText(new StringBuilder().append("").append(anInt_69)
                .toString());
    }
}
