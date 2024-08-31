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
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.fs.def.GraphicDefinition;
import dev.openrune.rsds.GUI;
import dev.openrune.rsds.client.AnimableObject;
import dev.openrune.rsds.client.Model;
import dev.openrune.rsds.client.ProducingGraphicsBuffer;

@SuppressWarnings("serial")
public class GraphicDefinitionFrame extends JFrame {

    public static int totalGraphicCount;
    public static long aLong_710 = 0L;
    public static ProducingGraphicsBuffer graphicsBuffer;

    static void method291(GraphicDefinitionFrame frame, KeyEvent keyevent) {
        frame.method102(keyevent);
    }

    static void method292(GraphicDefinitionFrame frame, MouseEvent mouseevent) {
        frame.resetMouseEventCoords(mouseevent);
    }

    static void method293(GraphicDefinitionFrame frame, ActionEvent actionevent) {
        frame.save(actionevent);
    }

    static void method294(GraphicDefinitionFrame frame, KeyEvent keyevent) {
        frame.method113(keyevent);
    }

    static void method295(GraphicDefinitionFrame frame, MouseEvent mouseevent) {
        frame.method36(mouseevent);
    }

    static void method296(GraphicDefinitionFrame frame, ActionEvent actionevent) {
        frame.void_method20(actionevent);
    }

    static void method297(GraphicDefinitionFrame frame,
                          MouseWheelEvent mousewheelevent) {
        frame.handleMouseWheelEvent(mousewheelevent);
    }

    static void method298(GraphicDefinitionFrame frame, WindowEvent windowevent) {
        frame.clear(windowevent);
    }

    static void method299(GraphicDefinitionFrame frame,
                          ListSelectionEvent listselectionevent) {
        frame.updateValues(listselectionevent);
    }

    static void method300(GraphicDefinitionFrame frame, ActionEvent actionevent) {
        frame.saveGraphics(actionevent);
    }

    static void void_method301(GraphicDefinitionFrame frame, KeyEvent keyevent) {
        frame.void_method96(keyevent);
    }

    static void method302(GraphicDefinitionFrame frame,
                          ComponentEvent componentevent) {
        frame.method37(componentevent);
    }

    static void method303(GraphicDefinitionFrame frame, MouseEvent mouseevent) {
        frame.method45(mouseevent);
    }

    public int anInt_701;
    public int anInt_702;
    public int graphicId;
    public int mouseEventX;
    public int anInt_729 = 0;
    public int mouseEventY;
    private JButton packSpotAnim;
    private JButton saveDump;
    private JButton saveFullDumpButton;
    private JButton saveGfxModels;
    JFileChooser fileChooser;
    private JLabel end;
    private JLabel dump;
    private JLabel selectedGfxId;
    private JLabel graphicLabel;
    private JLabel animFrameIdLabel;
    private JLabel prefixLabel;
    private JLabel graphicsList;
    private JLabel aJLabel_732;
    private JLabel start;
    private JLabel previewLabel;
    private JLabel totalGfxs;
    public JLabel aJLabel_738;
    private JList<Object> aJList_725;
    public JPanel aJPanel_716;
    private JProgressBar progessBar;
    private JScrollPane aJScrollPane_712;
    private JScrollPane aJScrollPane_728;
    private JTextArea aJTextArea_720;
    private JTextField aJTextField_707;
    private JTextField aJTextField_709;
    private JTextField aJTextField_724;
    public GraphicDefinition definition;
    GraphicDefinition graphicDefinition;
    public Model model;
    public AnimableObject animableObject;
    public Thread thread;

    public GraphicDefinitionFrame() {
        anInt_701 = 0;
        anInt_702 = 1000;
        mouseEventX = -1;
        mouseEventY = -1;
        method3();
        fileChooser = new JFileChooser();
    }

    public String getDefinitionAsCode(int id) {
        String string = this.aJTextField_707.getText().replaceAll("tab/", "\t")
                .replaceAll("id/", "" + id);
        String string_2 = this.aJTextField_724.getText()
                .replaceAll("tab/", "\t").replaceAll("id/", "" + id);
        String string_4 = this.aJTextField_709.getText()
                .replaceAll("tab/", "\t").replaceAll("id/", "" + id);
        GraphicDefinition definition = GraphicDefinition
                .getDefinition(GUI.cache, id, true);
        String string_2_ = "";
        string_2_ = new StringBuilder().append(string_2_).append(string_2)
                .append("\n").toString();
        if (graphicDefinition == null) {
            graphicDefinition = GraphicDefinition.getDefinition(
                    GUI.cache, 20000, false);
        }
        if (definition.client_anInt405 != graphicDefinition.client_anInt405) {
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("anInt405 = ").append(definition.client_anInt405)
                    .append(";\n").toString();
        }
        if (definition.client_anInt406 != graphicDefinition.client_anInt406) {
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("anInt406 = ").append(definition.client_anInt406)
                    .append(";\n").toString();
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("aAnimation_407 = Animation.anims[")
                    .append(definition.client_anInt406).append("];\n")
                    .toString();
        }
        if (definition.client_anInt410 != graphicDefinition.client_anInt410) {
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("anInt410 = ").append(definition.client_anInt410)
                    .append(";\n").toString();
        }
        if (definition.client_anInt411 != graphicDefinition.client_anInt411) {
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("anInt411 = ").append(definition.client_anInt411)
                    .append(";\n").toString();
        }
        if (definition.rotation != graphicDefinition.rotation) {
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("anInt412 = ").append(definition.rotation)
                    .append(";\n").toString();
        }
        if (definition.client_anInt413 != graphicDefinition.client_anInt413) {
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("anInt413 = ").append(definition.client_anInt413)
                    .append(";\n").toString();
        }
        if (definition.client_anInt414 != graphicDefinition.client_anInt414) {
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("anInt414 = ").append(definition.client_anInt414)
                    .append(";\n").toString();
        }
        if (definition.originalModelColors != null) {
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("anIntArray408 = new int[]{").toString();
            int i_4_;
            int i_3_ = i_4_ = 0;
            while (i_3_ < definition.originalModelColors.length - 1) {
                string_2_ = new StringBuilder().append(string_2_)
                        .append(definition.originalModelColors[i_4_])
                        .append(", ").toString();
                i_3_ = ++i_4_;
            }
            string_2_ = new StringBuilder()
                    .append(string_2_)
                    .append(definition.originalModelColors[definition.originalModelColors.length - 1])
                    .append("};\n").toString();
        }
        if (definition.modifiedModelColors != null) {
            string_2_ = new StringBuilder().append(string_2_).append(string)
                    .append("anIntArray409 = new int[]{").toString();
            int color;
            int i_5_ = color = 0;
            while (i_5_ < definition.modifiedModelColors.length - 1) {
                string_2_ = new StringBuilder().append(string_2_)
                        .append(definition.modifiedModelColors[color])
                        .append(", ").toString();
                i_5_ = ++color;
            }
            string_2_ = new StringBuilder()
                    .append(string_2_)
                    .append(definition.modifiedModelColors[definition.modifiedModelColors.length - 1])
                    .append("};\n").toString();
        }
        return string_2_ = new StringBuilder().append(string_2_)
                .append(string_4).append("\n").toString();
    }

    private void method102(KeyEvent keyevent) {
        displayDefinitionAsJavaCode();
    }

    private void method113(KeyEvent keyevent) {
        displayDefinitionAsJavaCode();
    }

    private void save(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("save");
        fileChooser.setApproveButtonText("save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                GraphicSaverThread thread = new GraphicSaverThread(file, 1);
                thread.start();
            }
        }
    }

    private void saveGraphics(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                GraphicSaverThread thread = new GraphicSaverThread(file, 0);
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
                try {
                    String string = getDefinitionAsCode(graphicId);
                    BufferedWriter writer = new BufferedWriter(new FileWriter(
                            file, false));
                    writer.write(string);
                    writer.flush();
                    writer.close();
                } catch (Exception exception) {
                }
            }
        }
    }

    public void updateProgessBar(String string, int ival) {
        progessBar.setString(string);
        progessBar.setValue(ival);
    }

    private void updateValues(ListSelectionEvent listselectionevent) {
        if (!listselectionevent.getValueIsAdjusting()) {
            String string = aJList_725.getModel()
                    .getElementAt(aJList_725.getAnchorSelectionIndex())
                    .toString();
            graphicId = Integer.parseInt(string);
            graphicLabel.setText(new StringBuilder().append("")
                    .append(graphicId).toString());
            definition = GraphicDefinition.getDefinition(GUI.cache,
                    graphicId, true);
            displayDefinitionAsJavaCode();
            animableObject = new AnimableObject(0, 0, 0, graphicId, 0, 0, 0);
        }
    }

    private void method3() {
        aJLabel_732 = new JLabel();
        saveFullDumpButton = new JButton();
        graphicsList = new JLabel();
        packSpotAnim = new JButton();
        selectedGfxId = new JLabel();
        totalGfxs = new JLabel();
        end = new JLabel();
        graphicLabel = new JLabel();
        saveDump = new JButton();
        aJScrollPane_712 = new JScrollPane();
        aJTextArea_720 = new JTextArea();
        dump = new JLabel();
        progessBar = new JProgressBar();
        prefixLabel = new JLabel();
        aJTextField_707 = new JTextField();
        aJScrollPane_728 = new JScrollPane();
        aJList_725 = new JList<Object>();
        aJTextField_724 = new JTextField();
        aJTextField_709 = new JTextField();
        start = new JLabel();
        saveGfxModels = new JButton();
        aJPanel_716 = new JPanel();
        previewLabel = new JLabel();
        animFrameIdLabel = new JLabel();
        aJLabel_738 = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("RSDS - Graphics/SpotAnim Definitions");
        setResizable(false);
        addWindowListener(new WindowAdapter() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void windowClosing(WindowEvent windowevent) {
                method298(frame, windowevent);
            }
        });
        aJLabel_732.setText("loading...");
        saveFullDumpButton.setText("Save Full Dump");
        saveFullDumpButton.setFocusable(false);
        saveFullDumpButton.addActionListener(new ActionListener() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method300(frame, actionevent);
            }
        });
        graphicsList.setFont(new Font("Tahoma", 1, 11));
        graphicsList.setText("Graphics List:");
        packSpotAnim.setText("Pack spotanim.dat");
        packSpotAnim.setFocusable(false);
        packSpotAnim.addActionListener(new ActionListener() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method293(frame, actionevent);
            }
        });
        selectedGfxId.setFont(new Font("Tahoma", 1, 11));
        selectedGfxId.setText("Selected GFX Id:");
        totalGfxs.setFont(new Font("Tahoma", 1, 11));
        totalGfxs.setText("Total gfxs:");
        end.setFont(new Font("Tahoma", 1, 11));
        end.setText("End:");
        graphicLabel.setText("loading...");
        saveDump.setText("Save Dump");
        saveDump.setFocusable(false);
        saveDump.addActionListener(new ActionListener() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                method296(frame, actionevent);
            }
        });
        aJTextArea_720.setColumns(20);
        aJTextArea_720.setEditable(false);
        aJTextArea_720.setFont(new Font("Monospaced", 0, 11));
        aJTextArea_720.setRows(5);
        aJScrollPane_712.setViewportView(aJTextArea_720);
        dump.setFont(new Font("Tahoma", 1, 11));
        dump.setText("Dump:");
        progessBar.setString("");
        progessBar.setStringPainted(true);
        prefixLabel.setFont(new Font("Tahoma", 1, 11));
        prefixLabel.setText("Var. prefix:");
        aJTextField_707.setText("tab/tab/cache[j].");
        aJTextField_707.addKeyListener(new KeyAdapter() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                void_method301(frame, keyevent);
            }
        });
        aJList_725.setModel(new AbstractListModel<Object>() {

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
        aJList_725.addListSelectionListener(new ListSelectionListener() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void valueChanged(ListSelectionEvent listselectionevent) {
                method299(frame, listselectionevent);
            }
        });
        aJScrollPane_728.setViewportView(aJList_725);
        aJTextField_724.setText("tab/case id/:");
        aJTextField_724.addKeyListener(new KeyAdapter() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                method294(frame, keyevent);
            }
        });
        aJTextField_709.setText("tab/break;");
        aJTextField_709.addKeyListener(new KeyAdapter() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                method291(frame, keyevent);
            }
        });
        start.setFont(new Font("Tahoma", 1, 11));
        start.setText("Start:");
        saveGfxModels.setText("Save GXF Models");
        saveGfxModels.setEnabled(false);
        saveGfxModels.setFocusable(false);
        saveGfxModels.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aJPanel_716.setBorder(BorderFactory.createLineBorder(new Color(204,
                204, 204)));
        aJPanel_716.setForeground(new Color(244, 244, 244));
        aJPanel_716.addMouseWheelListener(new MouseWheelListener() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void mouseWheelMoved(MouseWheelEvent mousewheelevent) {
                method297(frame, mousewheelevent);
            }
        });
        aJPanel_716.addMouseListener(new MouseAdapter() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void mousePressed(MouseEvent mouseevent) {
                method295(frame, mouseevent);
            }

            public void mouseReleased(MouseEvent mouseevent) {
                method292(frame, mouseevent);
            }
        });
        aJPanel_716.addComponentListener(new ComponentAdapter() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void componentResized(ComponentEvent componentevent) {
                method302(frame, componentevent);
            }
        });
        aJPanel_716.addMouseMotionListener(new MouseMotionAdapter() {

            final GraphicDefinitionFrame frame = GraphicDefinitionFrame.this;

            public void mouseDragged(MouseEvent mouseevent) {
                method303(frame, mouseevent);
            }
        });
        GroupLayout grouplayout = new GroupLayout(aJPanel_716);
        aJPanel_716.setLayout(grouplayout);
        grouplayout.setHorizontalGroup(grouplayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 234, 32767));
        grouplayout.setVerticalGroup(grouplayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 217, 32767));
        previewLabel.setFont(new Font("Tahoma", 1, 11));
        previewLabel.setText("Preview:");
        animFrameIdLabel.setFont(new Font("Tahoma", 1, 11));
        animFrameIdLabel.setText("anim frame id:");
        aJLabel_738.setText(".....");
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
                                                                        totalGfxs)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        aJLabel_732))
                                                .addComponent(graphicsList)
                                                .addComponent(aJScrollPane_728,
                                                        -2, 93, -2))
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(24, 24,
                                                                        24)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.LEADING)
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        prefixLabel)
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        aJTextField_707,
                                                                                                        -2,
                                                                                                        99,
                                                                                                        -2)
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        start)
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        aJTextField_724,
                                                                                                        -2,
                                                                                                        99,
                                                                                                        -2)
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        end)
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(
                                                                                                        aJTextField_709,
                                                                                                        -2,
                                                                                                        99,
                                                                                                        -2))
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        selectedGfxId)
                                                                                                .addGap(6,
                                                                                                        6,
                                                                                                        6)
                                                                                                .addComponent(
                                                                                                        graphicLabel))
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(
                                                                                                                        aJScrollPane_712,
                                                                                                                        -2,
                                                                                                                        436,
                                                                                                                        -2)
                                                                                                                .addComponent(
                                                                                                                        dump))
                                                                                                .addGap(56,
                                                                                                        56,
                                                                                                        56)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(
                                                                                                                        previewLabel)
                                                                                                                .addComponent(
                                                                                                                        aJPanel_716,
                                                                                                                        -2,
                                                                                                                        -1,
                                                                                                                        -2)))))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        saveDump,
                                                                        -2,
                                                                        117, -2)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        saveFullDumpButton,
                                                                        -2,
                                                                        117, -2)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        packSpotAnim)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        saveGfxModels)
                                                                .addGap(64, 64,
                                                                        64)
                                                                .addComponent(
                                                                        animFrameIdLabel)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        aJLabel_738))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(23, 23,
                                                                        23)
                                                                .addComponent(
                                                                        progessBar,
                                                                        -2,
                                                                        436, -2)))
                                .addContainerGap(31, 32767)));
        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.TRAILING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(
                                                                                        totalGfxs)
                                                                                .addComponent(
                                                                                        aJLabel_732))
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        graphicsList)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        aJScrollPane_728,
                                                                        -1,
                                                                        344,
                                                                        32767))
                                                .addGroup(
                                                        GroupLayout.Alignment.LEADING,
                                                        layout.createSequentialGroup()
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(
                                                                                        selectedGfxId)
                                                                                .addComponent(
                                                                                        graphicLabel))
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(
                                                                                        dump)
                                                                                .addComponent(
                                                                                        previewLabel))
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(
                                                                                        aJPanel_716,
                                                                                        GroupLayout.Alignment.LEADING,
                                                                                        -1,
                                                                                        -1,
                                                                                        32767)
                                                                                .addComponent(
                                                                                        aJScrollPane_712,
                                                                                        GroupLayout.Alignment.LEADING,
                                                                                        -2,
                                                                                        219,
                                                                                        -2))
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                        GroupLayout.Alignment.LEADING)
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addPreferredGap(
                                                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(
                                                                                                                        prefixLabel)
                                                                                                                .addComponent(
                                                                                                                        aJTextField_707,
                                                                                                                        -2,
                                                                                                                        -1,
                                                                                                                        -2)
                                                                                                                .addComponent(
                                                                                                                        start)
                                                                                                                .addComponent(
                                                                                                                        aJTextField_724,
                                                                                                                        -2,
                                                                                                                        -1,
                                                                                                                        -2)
                                                                                                                .addComponent(
                                                                                                                        end)
                                                                                                                .addComponent(
                                                                                                                        aJTextField_709,
                                                                                                                        -2,
                                                                                                                        -1,
                                                                                                                        -2))
                                                                                                .addGap(22,
                                                                                                        22,
                                                                                                        22)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(
                                                                                                                        saveDump,
                                                                                                                        -2,
                                                                                                                        40,
                                                                                                                        -2)
                                                                                                                .addComponent(
                                                                                                                        saveFullDumpButton,
                                                                                                                        -2,
                                                                                                                        40,
                                                                                                                        -2)
                                                                                                                .addComponent(
                                                                                                                        packSpotAnim,
                                                                                                                        -2,
                                                                                                                        40,
                                                                                                                        -2)
                                                                                                                .addComponent(
                                                                                                                        saveGfxModels,
                                                                                                                        -2,
                                                                                                                        40,
                                                                                                                        -2))
                                                                                                .addGap(18,
                                                                                                        18,
                                                                                                        18)
                                                                                                .addComponent(
                                                                                                        progessBar,
                                                                                                        -1,
                                                                                                        19,
                                                                                                        32767))
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addGap(39,
                                                                                                        39,
                                                                                                        39)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                        GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(
                                                                                                                        animFrameIdLabel)
                                                                                                                .addComponent(
                                                                                                                        aJLabel_738))))))
                                .addContainerGap()));
        pack();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void method30(Cache cache) {
        totalGraphicCount = cache.getFileSystems()[21].getFileCount();
        aJLabel_732.setText(new StringBuilder().append("")
                .append(totalGraphicCount).toString());
        final int count;
        final String[] strings = new String[count = totalGraphicCount];
        int index;
        int i = index = 0;
        while (i < count) {
            strings[index] = new StringBuilder().append("").append(index)
                    .toString();
            i = ++index;
        }
        aJList_725.setModel(new AbstractListModel() {

            String[] aStringArray_65;

            {
                aStringArray_65 = strings;
            }

            public Object getElementAt(int index) {
                return aStringArray_65[index];
            }

            public int getSize() {
                return aStringArray_65.length;
            }
        });
        graphicId = 0;
        aJList_725.setSelectedIndex(graphicId);
        graphicLabel.setText(new StringBuilder().append("").append(graphicId)
                .toString());
        GraphicDefinition.graphicDefinitions = new HashMap();
        graphicDefinition = GraphicDefinition.getDefinition(
                GUI.cache, 20000, false);
        method38();
        Model.resetModelHeaders(1);
        thread = new Thread_sub_105();
        thread.start();
    }

    private void clear(WindowEvent windowevent) {
        model = null;
        animableObject = null;
    }

    private void resetMouseEventCoords(MouseEvent mouseevent) {
        mouseEventY = mouseEventX = -1;
    }

    private void method36(MouseEvent mouseevent) {
        /* empty */
    }

    private void method37(ComponentEvent componentevent) {
        if (aJPanel_716.getWidth() >= 1 && aJPanel_716.getHeight() >= 1) {
            method38();
        }
    }

    public void method38() {
        graphicsBuffer = new ProducingGraphicsBuffer(aJPanel_716.getWidth(),
                aJPanel_716.getHeight(), aJPanel_716);
    }

    private void handleMouseWheelEvent(MouseWheelEvent mouseWheelEvent) {
        int rotation = mouseWheelEvent.getWheelRotation();
        anInt_702 += rotation * 10;
    }

    private void method45(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        if (mouseEventX == -1 && mouseEventY == -1) {
            mouseEventX = x;
            mouseEventY = y;
        } else {
            anInt_729 += mouseEventX - x;
            if (anInt_729 < 0) {
                anInt_729 = anInt_729 + 2048;
            } else if (anInt_729 >= 2048) {
                anInt_729 = 2048 - anInt_729;
            }
            anInt_701 -= mouseEventY - y;
            if (anInt_701 < 0) {
                anInt_701 = anInt_701 + 2048;
            } else if (anInt_701 >= 2048) {
                anInt_701 = 2048 - anInt_701;
            }
            mouseEventX = x;
            mouseEventY = y;
        }
    }

    public void displayDefinitionAsJavaCode() {
        String string = getDefinitionAsCode(graphicId);
        aJTextArea_720.setText(string);
    }

    private void void_method96(KeyEvent keyevent) {
        displayDefinitionAsJavaCode();
    }

}