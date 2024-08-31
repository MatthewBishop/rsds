package dev.openrune.rsds.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.io.FileUtils;
import dev.openrune.rsds.GUI;
import dev.openrune.rsds.client.Model;
import dev.openrune.rsds.client.ProducingGraphicsBuffer;

@SuppressWarnings("serial")
public class ModelViewerFrame extends JFrame {

    public static long aLong111 = 0L;
    public static ProducingGraphicsBuffer graphicsBuffer;

    public static Model getModelFromCache(int file) { // lol naming
        byte[] buffer;
        Model model;
        if ((buffer = GUI.cache.getFileSystems()[7].getFile(file, 0))[buffer.length - 1] == -1
                && buffer[buffer.length - 2] == -1) {
            if ((model = Model.createModel(buffer)).aBoolean_211) {
                model.void_method79(4);
            }
        } else {
            Model.method83(buffer, 0);
            model = Model.createModel(0);
        }
        return model;
    }

    static void processWindowEvent(ModelViewerFrame modelViewerFrame,
                                   WindowEvent windowevent) {
        modelViewerFrame.method33(windowevent);
    }

    static void void_method40(ModelViewerFrame jframe_sub_38,
                              MouseWheelEvent mousewheelevent) {
        jframe_sub_38.processMouseWheelMovement(mousewheelevent);
    }

    static void void_method41(ModelViewerFrame jframe_sub_38,
                              MouseEvent mouseevent) {
        jframe_sub_38.void_method35(mouseevent);
    }

    static void void_method42(ModelViewerFrame jframe_sub_38,
                              MouseEvent mouseevent) {
        jframe_sub_38.void_method45(mouseevent);
    }

    static void void_method43(ModelViewerFrame jframe_sub_38,
                              ListSelectionEvent listselectionevent) {
        jframe_sub_38.void_method25(listselectionevent);
    }

    static void void_method44(ModelViewerFrame jframe_sub_38,
                              ComponentEvent componentevent) {
        jframe_sub_38.void_method37(componentevent);
    }

    static void void_method46(ModelViewerFrame jframe_sub_38,
                              ActionEvent actionevent) {
        jframe_sub_38.void_method20(actionevent);
    }

    static void method47(ModelViewerFrame jframe_sub_38, ActionEvent actionevent) {
        jframe_sub_38.void_method19(actionevent);
    }

    static void void_method48(ModelViewerFrame jframe_sub_38,
                              MouseEvent mouseevent) {
        jframe_sub_38.void_method36(mouseevent);
    }

    public int an_int_101;
    public int an_int_103 = 0;
    public int an_int_105;
    public int an_int_107;
    public int an_int_109;
    public int an_int_93;
    public int an_int_94;
    private JButton an_JButton_106;
    private JButton an_JButton_88;
    private JButton an_JButton_95;
    JFileChooser fileChooser;
    private JLabel an_JLabel_108;
    private JLabel an_JLabel_110;
    private JLabel an_JLabel_89;
    private JLabel an_JLabel_91;
    private JLabel an_JLabel_96;
    @SuppressWarnings("rawtypes")
    private JList an_JList_87;
    public JPanel an_JPanel_98;
    private JProgressBar modelProgressBar;
    private JScrollPane scrollPane;
    public Model model;
    public String an_String_97;
    public Thread thread;

    public ModelViewerFrame() {
        an_int_101 = 0;
        an_int_105 = 500;
        an_int_107 = -1;
        an_int_94 = -1;
        an_String_97 = "";
        method3();
        fileChooser = new JFileChooser();
    }

    private void void_method19(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(1);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (file.isDirectory()) {
                ModelSaverThread thread = new ModelSaverThread(
                        file.getAbsolutePath(), 0);
                thread.start();
            }
        }
    }

    private void void_method20(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                byte[] is = GUI.cache.getFileSystems()[7]
                        .getFile(an_int_109, 0);
                FileUtils.write(file.getAbsolutePath(), is);
            }
        }
    }

    public void void_method23(String string, int value) {
        modelProgressBar.setString(string);
        modelProgressBar.setValue(value);
    }

    private void void_method25(ListSelectionEvent listselectionevent) {
        if (!listselectionevent.getValueIsAdjusting()) {
            String string = an_JList_87.getModel()
                    .getElementAt(an_JList_87.getAnchorSelectionIndex())
                    .toString();
            an_int_109 = Integer.parseInt(string);
            an_JLabel_96.setText(new StringBuilder().append("")
                    .append(an_int_109).toString());
            byte[] is;
            if ((is = GUI.cache.getFileSystems()[7].getFile(an_int_109, 0)) == null) {
                System.out.println(new StringBuilder().append("model")
                        .append(an_int_109).append(" data is null").toString());
            }
            Model var_a_sub_46;
            if (is[is.length - 1] == -1 && is[is.length - 2] == -1) {
                if ((var_a_sub_46 = Model.createModel(is)).aBoolean_211) {
                    var_a_sub_46.void_method79(4);
                }
            } else {
                Model.method83(is, 0);
                var_a_sub_46 = Model.createModel(0);
            }
            var_a_sub_46.light(84, 1000, -90, -580, -90, true);
            model = var_a_sub_46;
        }
    }

    @SuppressWarnings("rawtypes")
    private void method3() {
        an_JPanel_98 = new JPanel();
        scrollPane = new JScrollPane();
        an_JList_87 = new JList();
        an_JLabel_108 = new JLabel();
        an_JLabel_89 = new JLabel();
        an_JLabel_91 = new JLabel();
        an_JLabel_96 = new JLabel();
        an_JLabel_110 = new JLabel();
        an_JButton_95 = new JButton();
        an_JButton_106 = new JButton();
        an_JButton_88 = new JButton();
        modelProgressBar = new JProgressBar();
        setDefaultCloseOperation(2);
        setTitle("RSDS - Model Viewer");
        addWindowListener(new WindowAdapter() {

            final ModelViewerFrame frame = ModelViewerFrame.this;

            public void windowClosing(WindowEvent windowevent) {
                processWindowEvent(frame, windowevent);
            }
        });
        an_JPanel_98.setBorder(BorderFactory.createLineBorder(new Color(204,
                204, 204)));
        an_JPanel_98.setForeground(new Color(244, 244, 244));
        an_JPanel_98.addMouseWheelListener(new MouseWheelListener() {

            final ModelViewerFrame an_lb_744 = ModelViewerFrame.this;

            public void mouseWheelMoved(MouseWheelEvent mousewheelevent) {
                void_method40(an_lb_744, mousewheelevent);
            }
        });
        an_JPanel_98.addMouseListener(new MouseAdapter() {

            final ModelViewerFrame an_lb_114 = ModelViewerFrame.this;

            public void mousePressed(MouseEvent mouseevent) {
                void_method41(an_lb_114, mouseevent);
            }

            public void mouseReleased(MouseEvent mouseevent) {
                void_method42(an_lb_114, mouseevent);
            }
        });
        an_JPanel_98.addComponentListener(new ComponentAdapter() {

            final ModelViewerFrame an_lb_63 = ModelViewerFrame.this;

            public void componentResized(ComponentEvent componentevent) {
                void_method44(an_lb_63, componentevent);
            }
        });
        an_JPanel_98.addMouseMotionListener(new MouseMotionAdapter() {

            final ModelViewerFrame an_lb_640 = ModelViewerFrame.this;

            public void mouseDragged(MouseEvent mouseevent) {
                void_method48(an_lb_640, mouseevent);
            }
        });
        GroupLayout grouplayout = new GroupLayout(an_JPanel_98);
        an_JPanel_98.setLayout(grouplayout);
        grouplayout.setHorizontalGroup(grouplayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 543, 32767));
        grouplayout.setVerticalGroup(grouplayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 314, 32767));
        an_JList_87.addListSelectionListener(new ListSelectionListener() {

            final ModelViewerFrame an_lb_635 = ModelViewerFrame.this;

            public void valueChanged(ListSelectionEvent listselectionevent) {
                void_method43(an_lb_635, listselectionevent);
            }
        });
        scrollPane.setViewportView(an_JList_87);
        an_JLabel_108.setFont(new Font("Tahoma", 1, 11));
        an_JLabel_108.setText("Total Models:");
        an_JLabel_89.setText("loading..");
        an_JLabel_91.setFont(new Font("Tahoma", 1, 11));
        an_JLabel_91.setText("Selected Model Id:");
        an_JLabel_96.setText("loading..");
        an_JLabel_110.setFont(new Font("Tahoma", 1, 11));
        an_JLabel_110.setText("Model list:");
        an_JButton_95.setText("Save Model");
        an_JButton_95.setFocusable(false);
        an_JButton_95.addActionListener(new ActionListener() {

            final ModelViewerFrame an_lb_40 = ModelViewerFrame.this;

            {

            }

            public void actionPerformed(ActionEvent actionevent) {
                void_method46(an_lb_40, actionevent);
            }
        });
        an_JButton_106.setText("Save All Models");
        an_JButton_106.setFocusable(false);
        an_JButton_106.addActionListener(new ActionListener() {

            final ModelViewerFrame frame = ModelViewerFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method47(frame, actionevent);
            }
        });
        an_JButton_88.setText("Find Usages");
        an_JButton_88.setEnabled(false);
        an_JButton_88.setFocusable(false);
        GroupLayout grouplayout_9_ = new GroupLayout(getContentPane());
        getContentPane().setLayout(grouplayout_9_);
        grouplayout_9_
                .setHorizontalGroup(grouplayout_9_
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                grouplayout_9_
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                grouplayout_9_
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                grouplayout_9_
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                scrollPane,
                                                                                -2,
                                                                                133,
                                                                                -2)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(
                                                                                grouplayout_9_
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                an_JPanel_98,
                                                                                                -2,
                                                                                                -1,
                                                                                                -2)
                                                                                        .addGroup(
                                                                                                grouplayout_9_
                                                                                                        .createParallelGroup(
                                                                                                                GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                        .addComponent(
                                                                                                                modelProgressBar,
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                -1,
                                                                                                                -1,
                                                                                                                32767)
                                                                                                        .addGroup(
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                grouplayout_9_
                                                                                                                        .createSequentialGroup()
                                                                                                                        .addComponent(
                                                                                                                                an_JButton_95,
                                                                                                                                -2,
                                                                                                                                93,
                                                                                                                                -2)
                                                                                                                        .addPreferredGap(
                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(
                                                                                                                                an_JButton_106)
                                                                                                                        .addPreferredGap(
                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(
                                                                                                                                an_JButton_88)))))
                                                        .addGroup(
                                                                grouplayout_9_
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                an_JLabel_108)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                an_JLabel_89)
                                                                        .addGap(18,
                                                                                18,
                                                                                18)
                                                                        .addComponent(
                                                                                an_JLabel_91)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                an_JLabel_96,
                                                                                -2,
                                                                                44,
                                                                                -2))
                                                        .addComponent(
                                                                an_JLabel_110))
                                        .addContainerGap(14, 32767)));
        grouplayout_9_
                .setVerticalGroup(grouplayout_9_
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                GroupLayout.Alignment.TRAILING,
                                grouplayout_9_
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                grouplayout_9_
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                an_JLabel_108)
                                                        .addComponent(
                                                                an_JLabel_89)
                                                        .addComponent(
                                                                an_JLabel_91)
                                                        .addComponent(
                                                                an_JLabel_96))
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(an_JLabel_110)
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                grouplayout_9_
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.TRAILING)
                                                        .addGroup(
                                                                grouplayout_9_
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                an_JPanel_98,
                                                                                -1,
                                                                                -1,
                                                                                32767)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(
                                                                                grouplayout_9_
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                an_JButton_95,
                                                                                                -2,
                                                                                                38,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                an_JButton_106,
                                                                                                -2,
                                                                                                38,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                an_JButton_88,
                                                                                                -2,
                                                                                                38,
                                                                                                -2))
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                modelProgressBar,
                                                                                -2,
                                                                                -1,
                                                                                -2))
                                                        .addComponent(
                                                                scrollPane, -1,
                                                                390, 32767))
                                        .addContainerGap()));
        pack();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void void_method30(Cache class_n) {
        an_int_93 = class_n.getFileSystems()[7].method139();
        an_JLabel_89.setText(new StringBuilder().append("").append(an_int_93)
                .toString());
        final int i;
        final String[] strings = new String[i = an_int_93];
        int i_11_;
        int i_10_ = i_11_ = 0;
        while (i_10_ < i) {
            strings[i_11_] = new StringBuilder().append("").append(i_11_)
                    .toString();
            i_10_ = ++i_11_;
        }
        an_JList_87.setModel(new AbstractListModel() {

            String[] an_an_String_array583_583;
            final String[] an_an_String_array586_586;

            {
                an_an_String_array586_586 = strings;

                an_an_String_array583_583 = an_an_String_array586_586;
            }

            public Object getElementAt(int i_15_) {
                return an_an_String_array583_583[i_15_];
            }

            public int getSize() {
                return an_an_String_array583_583.length;
            }
        });
        an_int_109 = 0;
        an_JList_87.setSelectedIndex(an_int_109);
        an_JLabel_96.setText(new StringBuilder().append("").append(an_int_109)
                .toString());
        void_method38();
        Model.resetModelHeaders(1);
        thread = new Thread_sub_27();
        thread.start();
    }

    private void method33(WindowEvent windowevent) {
        model = null;
    }

    private void void_method35(MouseEvent mouseevent) {
        /* empty */
    }

    private void void_method36(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int i_0_ = mouseevent.getY();
        if (an_int_107 == -1 && an_int_94 == -1) {
            an_int_107 = i;
            an_int_94 = i_0_;
        } else {
            an_int_103 += an_int_107 - i;
            if (an_int_103 < 0) {
                an_int_103 = an_int_103 + 2048;
            } else if (an_int_103 >= 2048) {
                an_int_103 = 2048 - an_int_103;
            }
            an_int_101 -= an_int_94 - i_0_;
            if (an_int_101 < 0) {
                an_int_101 = an_int_101 + 2048;
            } else if (an_int_101 >= 2048) {
                an_int_101 = 2048 - an_int_101;
            }
            an_int_107 = i;
            an_int_94 = i_0_;
        }
    }

    private void void_method37(ComponentEvent componentevent) {
        if (an_JPanel_98.getWidth() >= 1 && an_JPanel_98.getHeight() >= 1) {
            void_method38();
        }
    }

    public void void_method38() {
        graphicsBuffer = new ProducingGraphicsBuffer(an_JPanel_98.getWidth(),
                an_JPanel_98.getHeight(), an_JPanel_98);
    }

    private void processMouseWheelMovement(MouseWheelEvent mousewheelevent) {
        int rotation = mousewheelevent.getWheelRotation();
        an_int_105 += rotation * 10;
    }

    private void void_method45(MouseEvent mouseevent) {
        an_int_94 = an_int_107 = -1;
    }

}