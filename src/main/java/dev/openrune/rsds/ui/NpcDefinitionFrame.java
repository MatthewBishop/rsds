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
import dev.openrune.rsds.fs.def.NpcDefinition;
import dev.openrune.rsds.GUI;
import dev.openrune.rsds.client.Model;
import dev.openrune.rsds.client.ProducingGraphicsBuffer;
import dev.openrune.rsds.client.Renderable_Sub;

@SuppressWarnings("serial")
public class NpcDefinitionFrame extends JFrame {

    public static int anInt_629;
    public static long aLong_594 = 0L;
    public static ProducingGraphicsBuffer aClass_n_633;

    static void void_method192(NpcDefinitionFrame jframe_sub_110,
                               ActionEvent actionevent) {
        jframe_sub_110.void_method19(actionevent);
    }

    static void void_method193(NpcDefinitionFrame jframe_sub_110,
                               MouseEvent mouseevent) {
        jframe_sub_110.void_method45(mouseevent);
    }

    static void void_method194(NpcDefinitionFrame jframe_sub_110,
                               ComponentEvent componentevent) {
        jframe_sub_110.void_method37(componentevent);
    }

    static void void_method195(NpcDefinitionFrame jframe_sub_110,
                               ActionEvent actionevent) {
        jframe_sub_110.void_method14(actionevent);
    }

    static void void_method196(NpcDefinitionFrame jframe_sub_110,
                               ActionEvent actionevent) {
        jframe_sub_110.void_method15(actionevent);
    }

    static void void_method197(NpcDefinitionFrame jframe_sub_110,
                               KeyEvent keyevent) {
        jframe_sub_110.void_method96(keyevent);
    }

    static void void_method198(NpcDefinitionFrame jframe_sub_110,
                               ListSelectionEvent listselectionevent) {
        jframe_sub_110.void_method25(listselectionevent);
    }

    static void void_method199(NpcDefinitionFrame jframe_sub_110,
                               KeyEvent keyevent) {
        jframe_sub_110.void_method102(keyevent);
    }

    static void void_method200(NpcDefinitionFrame jframe_sub_110,
                               MouseWheelEvent mousewheelevent) {
        jframe_sub_110.updateWheelRotation(mousewheelevent);
    }

    static void void_method201(NpcDefinitionFrame jframe_sub_110,
                               MouseEvent mouseevent) {
        jframe_sub_110.processMouseEvents(mouseevent);
    }

    static void void_method202(NpcDefinitionFrame jframe_sub_110,
                               MouseEvent mouseevent) {
        jframe_sub_110.resetMouseEventXY(mouseevent);
    }

    static void handleSaveFullDumpAction(NpcDefinitionFrame jframe_sub_110,
                                         ActionEvent actionevent) {
        jframe_sub_110.save(actionevent);
    }

    static void processMainWindowCloseEvent(NpcDefinitionFrame jframe_sub_110,
                                            WindowEvent windowevent) {
        jframe_sub_110.void_method33(windowevent);
    }

    static void void_method205(NpcDefinitionFrame jframe_sub_110,
                               ActionEvent actionevent) {
        jframe_sub_110.void_method9(actionevent);
    }

    static void handlePackNpcFileAction(NpcDefinitionFrame jframe_sub_110,
                                        ActionEvent actionevent) {
        jframe_sub_110.void_method12(actionevent);
    }

    static void void_method207(NpcDefinitionFrame jframe_sub_110,
                               KeyEvent keyevent) {
        jframe_sub_110.void_method113(keyevent);
    }

    static void void_method208(NpcDefinitionFrame frame, ActionEvent actionevent) {
        frame.writeNpcDefinition(actionevent);
    }

    public Renderable_Sub an_g_601;
    public int npcId;
    public int mouseEventX;
    public int mouseEventYTotal;
    public int mouseEventY;
    public int an_int_624;
    public int mouseEventXTotal = 0;
    private JButton an_JButton_590;
    private JButton saveDefinitionDumpLabel;
    private JButton an_JButton_597;
    private JButton packNpcFileButton;
    private JButton an_JButton_613;
    private JButton an_JButton_618;
    private JButton an_JButton_622;
    private JButton saveDumpLabel;
    JFileChooser fileChooser;
    private JLabel prefixLabel;
    private JLabel statusLabel;
    private JLabel endLabel;
    private JLabel dumpLabel;
    private JLabel selectedNpcIdLabel;
    private JLabel totalNpcsLabel;
    public JLabel an_JLabel_615;
    private JLabel an_JLabel_617;
    private JLabel npcListLabel;
    private JLabel an_JLabel_631;
    @SuppressWarnings("rawtypes")
    private JList an_JList_619;
    public JPanel an_JPanel_595;
    private JProgressBar progressBar;
    private JScrollPane an_JScrollPane_593;
    private JScrollPane an_JScrollPane_600;
    private JScrollPane an_JScrollPane_610;
    private JTextArea definitionDisplayTextArea;
    private JTextArea an_JTextArea_627;
    private JTextField prefixTextField;
    private JTextField startTextField;
    private JTextField an_JTextField_628;
    private JTextField endTextField;
    public NpcDefinition definition;
    public Model an_o_632;
    public Thread thread;

    public NpcDefinitionFrame() {
        mouseEventYTotal = 0;
        an_int_624 = 450;
        mouseEventX = -1;
        mouseEventY = -1;
        init();
        fileChooser = new JFileChooser();
    }

    public String getNpcDefinitionAsString(int id) {
        String prefix = prefixTextField
                .getText()
                .replaceAll("tab/", "\t")
                .replaceAll("id/",
                        new StringBuilder().append("").append(id).toString());
        String start = startTextField
                .getText()
                .replaceAll("tab/", "\t")
                .replaceAll("id/",
                        new StringBuilder().append("").append(id).toString());
        String end = endTextField
                .getText()
                .replaceAll("tab/", "\t")
                .replaceAll("id/",
                        new StringBuilder().append("").append(id).toString());
        NpcDefinition definition = NpcDefinition
                .getDefinition(GUI.cache, id, true);
        String toWrite = "";
        toWrite = new StringBuilder().append(toWrite).append(start)
                .append("\n").toString();
        if (definition.name != null) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("name = \"").append(definition.name)
                    .append("\";\n").toString();
        }
        if (definition.componentModels != null) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("componentModels = new int[]{").toString();
            int model;
            int i_3_ = model = 0;
            while (i_3_ < definition.componentModels.length - 1) {
                toWrite = new StringBuilder().append(toWrite)
                        .append(definition.componentModels[model]).append(", ")
                        .toString();
                i_3_ = ++model;
            }
            toWrite = new StringBuilder()
                    .append(toWrite)
                    .append(definition.componentModels[definition.componentModels.length - 1])
                    .append("};\n").toString();
        }
        if (definition.client_aByte68 != 1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("aByte68 = ").append(definition.client_aByte68)
                    .append(";\n").toString();
        }
        if (definition.standingAnimation != -1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("standAnimation = ")
                    .append(definition.standingAnimation).append(";\n")
                    .toString();
        }
        if (definition.walkingAnimation != -1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("walkAnimation = ")
                    .append(definition.walkingAnimation).append(";\n")
                    .toString();
        }
        if (definition.client_anInt58 != -1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt58 = ").append(definition.client_anInt58)
                    .append(";\n").toString();
        }
        if (definition.client_anInt83 != -1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt83 = ").append(definition.client_anInt83)
                    .append(";\n").toString();
        }
        if (definition.client_anInt55 != -1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt55 = ").append(definition.client_anInt55)
                    .append(";\n").toString();
        }
        if (definition.actions != null) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("actions = new String[]{").toString();
            int action;
            int i_5_ = action = 0;
            while (i_5_ < definition.actions.length - 1) {
                toWrite = new StringBuilder()
                        .append(toWrite)
                        .append(definition.actions[action] == null ? "null"
                                : new StringBuilder().append("\"")
                                .append(definition.actions[action])
                                .append("\"").toString()).append(", ")
                        .toString();
                i_5_ = ++action;
            }
            toWrite = new StringBuilder().append(toWrite)
                    .append(definition.actions[definition.actions.length - 1])
                    .append("};\n").toString();
        }
        if (definition.colour1 != null) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("colour1 = new int[]{").toString();
            int colour;
            int i_7_ = colour = 0;
            while (i_7_ < definition.colour1.length - 1) {
                toWrite = new StringBuilder().append(toWrite)
                        .append(definition.colour1[colour]).append(", ")
                        .toString();
                i_7_ = ++colour;
            }
            toWrite = new StringBuilder().append(toWrite)
                    .append(definition.colour1[definition.colour1.length - 1])
                    .append("};\n").toString();
        }
        if (definition.colour2 != null) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("colour2 = new int[]{").toString();
            int colour;
            int i_9_ = colour = 0;
            while (i_9_ < definition.colour2.length - 1) {
                toWrite = new StringBuilder().append(toWrite)
                        .append(definition.colour2[colour]).append(", ")
                        .toString();
                i_9_ = ++colour;
            }
            toWrite = new StringBuilder().append(toWrite)
                    .append(definition.colour2[definition.colour2.length - 1])
                    .append("};\n").toString();
        }
        if (definition.client_anIntArray73 != null) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anIntArray73 = new int[]{").toString();
            int index;
            int i_11_ = index = 0;
            while (i_11_ < definition.client_anIntArray73.length - 1) {
                toWrite = new StringBuilder().append(toWrite)
                        .append(definition.client_anIntArray73[index])
                        .append(", ").toString();
                i_11_ = ++index;
            }
            toWrite = new StringBuilder()
                    .append(toWrite)
                    .append(definition.client_anIntArray73[definition.client_anIntArray73.length - 1])
                    .append(";\n").toString();
        }
        if (!definition.client_aBoolean87) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("aBoolean87 = ")
                    .append(definition.client_aBoolean87).append(";\n")
                    .toString();
        }
        if (definition.combatLevel != -1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("combatLevel = ").append(definition.combatLevel)
                    .append(";\n").toString();
        }
        if (definition.client_anInt91 != 128) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt91 = ").append(definition.client_anInt91)
                    .append(";\n").toString();
        }
        if (definition.client_anInt86 != 128) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt86 = ").append(definition.client_anInt86)
                    .append(";\n").toString();
        }
        if (definition.client_aBoolean93) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("aBoolean93 = ")
                    .append(definition.client_aBoolean93).append(";\n")
                    .toString();
        }
        if (definition.client_anInt85 != 0) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt85 = ").append(definition.client_anInt85)
                    .append(";\n").toString();
        }
        if (definition.client_anInt92 != 0) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt92 = ").append(definition.client_anInt92)
                    .append(";\n").toString();
        }
        if (definition.client_anInt75 != -1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt75 = ").append(definition.client_anInt75)
                    .append(";\n").toString();
        }
        if (definition.client_anInt79 != 32) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt79 = ").append(definition.client_anInt79)
                    .append(";\n").toString();
        }
        if (definition.client_anInt57 != -1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt57 = ").append(definition.client_anInt57)
                    .append(";\n").toString();
        }
        if (definition.client_anInt59 != -1) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("anInt59 = ").append(definition.client_anInt59)
                    .append(";\n").toString();
        }
        if (definition.childrenIDs != null) {
            toWrite = new StringBuilder().append(toWrite).append(prefix)
                    .append("childrenIDs = new int[]{").toString();
            int childId;
            int i_13_ = childId = 0;
            while (i_13_ < definition.childrenIDs.length - 1) {
                toWrite = new StringBuilder().append(toWrite)
                        .append(definition.childrenIDs[childId]).append(", ")
                        .toString();
                i_13_ = ++childId;
            }
            toWrite = new StringBuilder()
                    .append(toWrite)
                    .append(definition.childrenIDs[definition.childrenIDs.length - 1])
                    .append("};\n").toString();
            if (!definition.client_aBoolean84) {
                toWrite = new StringBuilder().append(toWrite).append(prefix)
                        .append("aBoolean84 = ")
                        .append(definition.client_aBoolean84).append(";\n")
                        .toString();
            }
        }
        return toWrite = new StringBuilder().append(toWrite).append(end)
                .append("\n").toString();
    }

    private void writeNpcDefinition(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                try {
                    String string = getNpcDefinitionAsString(npcId);
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

    private void void_method102(KeyEvent keyevent) {
        displayDefinitionOnScreen();
    }

    private void void_method113(KeyEvent keyevent) {
        displayDefinitionOnScreen();
    }

    private void void_method12(ActionEvent actionevent) {
        /* empty */
    }

    private void void_method14(ActionEvent actionevent) {
        try {
            an_g_601 = new Renderable_Sub(definition.o_method159(),
                    Integer.parseInt(an_JTextField_628.getText()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void void_method15(ActionEvent actionevent) {
        int i = Integer.parseInt(an_JTextField_628.getText()) - 1;
        an_JTextField_628.setText(new StringBuilder().append(i).append("")
                .toString());
        an_g_601 = new Renderable_Sub(definition.o_method159(),
                Integer.parseInt(an_JTextField_628.getText()));
    }

    private void void_method19(ActionEvent actionevent) {
        /* empty */
    }

    private void save(ActionEvent actionevent) {
        fileChooser.setFileSelectionMode(0);
        fileChooser.setDialogTitle("Save");
        fileChooser.setApproveButtonText("Save");
        if (fileChooser.showOpenDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists() || file.isFile()) {
                NpcSaverThread thread = new NpcSaverThread(file, 0);
                thread.start();
            }
        }
    }

    public void setProgressBarValues(String string, int val) {
        progressBar.setString(string);
        progressBar.setValue(val);
    }

    private void void_method25(ListSelectionEvent listselectionevent) {
        if (!listselectionevent.getValueIsAdjusting()) {
            String string = an_JList_619.getModel()
                    .getElementAt(an_JList_619.getAnchorSelectionIndex())
                    .toString();
            npcId = Integer.parseInt(string);
            an_JLabel_631.setText(new StringBuilder().append("").append(npcId)
                    .toString());
            definition = NpcDefinition.getDefinition(GUI.cache,
                    npcId, true);
            an_JTextField_628.setText(new StringBuilder().append("")
                    .append(definition.standingAnimation).toString());
            displayDefinitionOnScreen();
            an_g_601 = new Renderable_Sub(definition.o_method159(),
                    Integer.parseInt(an_JTextField_628.getText()));
            an_o_632 = an_g_601.getRotatedModel();
        }
    }

    public void displayDefinitionOnScreen() {
        String string = getNpcDefinitionAsString(npcId);
        definitionDisplayTextArea.setText(string);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void method30(Cache cache) {
        anInt_629 = cache.getFileSystems()[18].getFileCount();
        statusLabel.setText(new StringBuilder().append("").append(anInt_629)
                .toString());
        final int i;
        final String[] strings = new String[i = anInt_629];
        int i_35_;
        int i_34_ = i_35_ = 0;
        while (i_34_ < i) {
            strings[i_35_] = new StringBuilder().append("").append(i_35_)
                    .toString();
            i_34_ = ++i_35_;
        }
        an_JList_619.setModel(new AbstractListModel() {

            String[] an_an_String_array650_650;
            final String[] an_an_String_array651_651;

            {
                an_an_String_array651_651 = strings;

                an_an_String_array650_650 = an_an_String_array651_651;
            }

            public Object getElementAt(int i_39_) {
                return an_an_String_array650_650[i_39_];
            }

            public int getSize() {
                return an_an_String_array650_650.length;
            }
        });
        npcId = 0;
        an_JList_619.setSelectedIndex(npcId);
        an_JLabel_631.setText(new StringBuilder().append("").append(npcId)
                .toString());
        NpcDefinition.definitionMap = new HashMap();
        void_method65();
        Model.resetModelHeaders(1);
        thread = new Thread_sub_19();
        thread.start();
    }

    private void void_method33(WindowEvent windowevent) {
        an_g_601 = null;
    }

    private void processMouseEvents(MouseEvent mouseevent) {
        int x = mouseevent.getX();
        int y = mouseevent.getY();
        if (mouseEventX == -1 && mouseEventY == -1) {
            mouseEventX = x;
            mouseEventY = y;
        } else {
            mouseEventXTotal += mouseEventX - x;
            if (mouseEventXTotal < 0) {
                mouseEventXTotal = mouseEventXTotal + 2048;
            } else if (mouseEventXTotal >= 2048) {
                mouseEventXTotal = 2048 - mouseEventXTotal;
            }
            mouseEventYTotal -= mouseEventY - y;
            if (mouseEventYTotal < 0) {
                mouseEventYTotal = mouseEventYTotal + 2048;
            } else if (mouseEventYTotal >= 2048) {
                mouseEventYTotal = 2048 - mouseEventYTotal;
            }
            mouseEventX = x;
            mouseEventY = y;
        }
    }

    private void resetMouseEventXY(MouseEvent mouseevent) {
        mouseEventY = mouseEventX = -1;
    }

    private void void_method37(ComponentEvent componentevent) {
        if (an_JPanel_595.getWidth() >= 1 && an_JPanel_595.getHeight() >= 1) {
            void_method65();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void init() {
        statusLabel = new JLabel();
        saveDefinitionDumpLabel = new JButton();
        npcListLabel = new JLabel();
        packNpcFileButton = new JButton();
        selectedNpcIdLabel = new JLabel();
        totalNpcsLabel = new JLabel();
        endLabel = new JLabel();
        an_JLabel_631 = new JLabel();
        saveDumpLabel = new JButton();
        an_JScrollPane_610 = new JScrollPane();
        definitionDisplayTextArea = new JTextArea();
        dumpLabel = new JLabel();
        progressBar = new JProgressBar();
        prefixLabel = new JLabel();
        prefixTextField = new JTextField();
        an_JScrollPane_600 = new JScrollPane();
        an_JList_619 = new JList();
        startTextField = new JTextField();
        endTextField = new JTextField();
        an_JLabel_617 = new JLabel();
        an_JButton_590 = new JButton();
        an_JPanel_595 = new JPanel();
        an_JLabel_615 = new JLabel();
        an_JTextField_628 = new JTextField();
        an_JButton_597 = new JButton();
        an_JButton_618 = new JButton();
        an_JButton_622 = new JButton();
        an_JButton_613 = new JButton();
        an_JScrollPane_593 = new JScrollPane();
        an_JTextArea_627 = new JTextArea();
        setDefaultCloseOperation(2);
        setTitle("RSDS - NPC Definitions");
        setResizable(false);
        addWindowListener(new WindowAdapter() {

            final NpcDefinitionFrame frame = NpcDefinitionFrame.this;

            public void windowClosing(WindowEvent windowevent) {
                processMainWindowCloseEvent(frame, windowevent);
            }
        });
        statusLabel.setText("loading...");
        saveDefinitionDumpLabel.setText("Save Full Dump");
        saveDefinitionDumpLabel.setFocusable(false);
        saveDefinitionDumpLabel.addActionListener(new ActionListener() {

            final NpcDefinitionFrame dumpFrame = NpcDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                handleSaveFullDumpAction(dumpFrame, actionevent);
            }
        });
        npcListLabel.setFont(new Font("Tahoma", 1, 11));
        npcListLabel.setText("NPC List:");
        packNpcFileButton.setText("Pack npc.dat/idx");
        packNpcFileButton.setEnabled(false);
        packNpcFileButton.setFocusable(false);
        packNpcFileButton.addActionListener(new ActionListener() {

            final NpcDefinitionFrame packFrame = NpcDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                handlePackNpcFileAction(packFrame, actionevent);
            }
        });
        selectedNpcIdLabel.setFont(new Font("Tahoma", 1, 11));
        selectedNpcIdLabel.setText("Selected NPC Id:");
        totalNpcsLabel.setFont(new Font("Tahoma", 1, 11));
        totalNpcsLabel.setText("Total NPCs:");
        endLabel.setFont(new Font("Tahoma", 1, 11));
        endLabel.setText("End:");
        an_JLabel_631.setText("loading...");
        saveDumpLabel.setText("Save Dump");
        saveDumpLabel.setFocusable(false);
        saveDumpLabel.addActionListener(new ActionListener() {

            final NpcDefinitionFrame saveDump = NpcDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                void_method208(saveDump, actionevent);
            }
        });
        definitionDisplayTextArea.setColumns(20);
        definitionDisplayTextArea.setEditable(false);
        definitionDisplayTextArea.setFont(new Font("Monospaced", 0, 11));
        definitionDisplayTextArea.setRows(5);
        an_JScrollPane_610.setViewportView(definitionDisplayTextArea);
        dumpLabel.setFont(new Font("Tahoma", 1, 11));
        dumpLabel.setText("Dump:");
        progressBar.setString("");
        progressBar.setStringPainted(true);
        prefixLabel.setFont(new Font("Tahoma", 1, 11));
        prefixLabel.setText("Var. prefix:");
        prefixTextField.setText("tab/tab/cache[j].");
        prefixTextField.addKeyListener(new KeyAdapter() {

            final NpcDefinitionFrame prefixFrame = NpcDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                void_method207(prefixFrame, keyevent);
            }
        });
        an_JList_619.setModel(new AbstractListModel() {

            String[] info;

            {

                info = new String[]{"tab/case id/:"};
            }

            public Object getElementAt(int i) {
                return info[i];
            }

            public int getSize() {
                return info.length;
            }
        });
        an_JList_619.addListSelectionListener(new ListSelectionListener() {

            final NpcDefinitionFrame caseIdFrame = NpcDefinitionFrame.this;

            public void valueChanged(ListSelectionEvent listselectionevent) {
                void_method198(caseIdFrame, listselectionevent);
            }
        });
        an_JScrollPane_600.setViewportView(an_JList_619);
        startTextField.setText("tab/case id/:");
        startTextField.addKeyListener(new KeyAdapter() {

            final NpcDefinitionFrame caseIdFrame = NpcDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                void_method197(caseIdFrame, keyevent);
            }
        });
        endTextField.setText("tab/break;");
        endTextField.addKeyListener(new KeyAdapter() {

            final NpcDefinitionFrame breakFrame = NpcDefinitionFrame.this;

            public void keyReleased(KeyEvent keyevent) {
                void_method199(breakFrame, keyevent);
            }
        });
        an_JLabel_617.setFont(new Font("Tahoma", 1, 11));
        an_JLabel_617.setText("Var. prefix:");
        an_JButton_590.setText("tab/tab/cache[j].");
        an_JButton_590.setEnabled(false);
        an_JButton_590.setFocusable(false);
        an_JButton_590.addActionListener(new ActionListener() {

            final NpcDefinitionFrame prefixFrame = NpcDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                void_method192(prefixFrame, actionevent);
            }
        });
        an_JPanel_595.setBorder(BorderFactory.createLineBorder(new Color(204,
                204, 204)));
        an_JPanel_595.setForeground(new Color(244, 244, 244));
        an_JPanel_595.addMouseWheelListener(new MouseWheelListener() {

            final NpcDefinitionFrame frame = NpcDefinitionFrame.this;

            public void mouseWheelMoved(MouseWheelEvent mousewheelevent) {
                void_method200(frame, mousewheelevent);
            }
        });
        an_JPanel_595.addMouseListener(new MouseAdapter() {

            final NpcDefinitionFrame frame = NpcDefinitionFrame.this;

            public void mousePressed(MouseEvent mouseevent) {
                void_method193(frame, mouseevent);
            }

            public void mouseReleased(MouseEvent mouseevent) {
                void_method202(frame, mouseevent);
            }
        });
        an_JPanel_595.addComponentListener(new ComponentAdapter() {

            final NpcDefinitionFrame frame = NpcDefinitionFrame.this;

            public void componentResized(ComponentEvent componentevent) {
                void_method194(frame, componentevent);
            }
        });
        an_JPanel_595.addMouseMotionListener(new MouseMotionAdapter() {

            final NpcDefinitionFrame frame = NpcDefinitionFrame.this;

            public void mouseDragged(MouseEvent mouseevent) {
                void_method201(frame, mouseevent);
            }
        });
        GroupLayout grouplayout = new GroupLayout(an_JPanel_595);
        an_JPanel_595.setLayout(grouplayout);
        grouplayout.setHorizontalGroup(grouplayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 232, 32767));
        grouplayout.setVerticalGroup(grouplayout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGap(0, 285, 32767));
        an_JLabel_615.setText(".....");
        an_JTextField_628.setText("808");
        an_JButton_597.setText("Set");
        an_JButton_597.setFocusable(false);
        an_JButton_597.addActionListener(new ActionListener() {

            final NpcDefinitionFrame frame = NpcDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                void_method195(frame, actionevent);
            }
        });
        an_JButton_618.setText("+");
        an_JButton_618.setBorder(null);
        an_JButton_618.addActionListener(new ActionListener() {

            final NpcDefinitionFrame frame = NpcDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                void_method205(frame, actionevent);
            }
        });
        an_JButton_622.setText("-");
        an_JButton_622.setBorder(null);
        an_JButton_622.addActionListener(new ActionListener() {

            final NpcDefinitionFrame frame = NpcDefinitionFrame.this;

            public void actionPerformed(ActionEvent actionevent) {
                void_method196(frame, actionevent);
            }
        });
        an_JButton_613.setText("Check anims");
        an_JButton_613.setFocusable(false);
        an_JTextArea_627.setColumns(20);
        an_JTextArea_627.setRows(5);
        an_JScrollPane_593.setViewportView(an_JTextArea_627);
        GroupLayout grouplayout_32_ = new GroupLayout(getContentPane());
        getContentPane().setLayout(grouplayout_32_);
        grouplayout_32_
                .setHorizontalGroup(grouplayout_32_
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                grouplayout_32_
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                grouplayout_32_
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                grouplayout_32_
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                totalNpcsLabel)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                statusLabel)
                                                                        .addGap(45,
                                                                                45,
                                                                                45)
                                                                        .addComponent(
                                                                                selectedNpcIdLabel)
                                                                        .addGap(6,
                                                                                6,
                                                                                6)
                                                                        .addComponent(
                                                                                an_JLabel_631)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                524,
                                                                                32767)
                                                                        .addComponent(
                                                                                an_JLabel_615)
                                                                        .addGap(23,
                                                                                23,
                                                                                23))
                                                        .addGroup(
                                                                grouplayout_32_
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                grouplayout_32_
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                npcListLabel)
                                                                                        .addComponent(
                                                                                                an_JScrollPane_600,
                                                                                                -2,
                                                                                                93,
                                                                                                -2))
                                                                        .addGap(10,
                                                                                10,
                                                                                10)
                                                                        .addGroup(
                                                                                grouplayout_32_
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                grouplayout_32_
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                dumpLabel)
                                                                                                        .addContainerGap(
                                                                                                                730,
                                                                                                                32767))
                                                                                        .addGroup(
                                                                                                GroupLayout.Alignment.TRAILING,
                                                                                                grouplayout_32_
                                                                                                        .createSequentialGroup()
                                                                                                        .addGroup(
                                                                                                                grouplayout_32_
                                                                                                                        .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                        .addGroup(
                                                                                                                                grouplayout_32_
                                                                                                                                        .createSequentialGroup()
                                                                                                                                        .addComponent(
                                                                                                                                                prefixLabel)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(
                                                                                                                                                prefixTextField,
                                                                                                                                                -2,
                                                                                                                                                99,
                                                                                                                                                -2)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(
                                                                                                                                                an_JLabel_617)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(
                                                                                                                                                startTextField,
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
                                                                                                                                                endTextField,
                                                                                                                                                -2,
                                                                                                                                                99,
                                                                                                                                                -2))
                                                                                                                        .addGroup(
                                                                                                                                grouplayout_32_
                                                                                                                                        .createSequentialGroup()
                                                                                                                                        .addComponent(
                                                                                                                                                saveDumpLabel)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(
                                                                                                                                                saveDefinitionDumpLabel,
                                                                                                                                                -2,
                                                                                                                                                105,
                                                                                                                                                -2)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(
                                                                                                                                                packNpcFileButton)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(
                                                                                                                                                an_JButton_590))
                                                                                                                        .addComponent(
                                                                                                                                an_JScrollPane_610,
                                                                                                                                -2,
                                                                                                                                436,
                                                                                                                                -2)
                                                                                                                        .addComponent(
                                                                                                                                progressBar,
                                                                                                                                -2,
                                                                                                                                436,
                                                                                                                                -2))
                                                                                                        .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                45,
                                                                                                                32767)
                                                                                                        .addGroup(
                                                                                                                grouplayout_32_
                                                                                                                        .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                        .addComponent(
                                                                                                                                an_JScrollPane_593)
                                                                                                                        .addComponent(
                                                                                                                                an_JButton_613)
                                                                                                                        .addComponent(
                                                                                                                                an_JPanel_595,
                                                                                                                                -1,
                                                                                                                                -1,
                                                                                                                                32767)
                                                                                                                        .addGroup(
                                                                                                                                grouplayout_32_
                                                                                                                                        .createSequentialGroup()
                                                                                                                                        .addGap(36,
                                                                                                                                                36,
                                                                                                                                                36)
                                                                                                                                        .addComponent(
                                                                                                                                                an_JButton_622,
                                                                                                                                                -2,
                                                                                                                                                17,
                                                                                                                                                -2)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(
                                                                                                                                                an_JButton_618,
                                                                                                                                                -2,
                                                                                                                                                17,
                                                                                                                                                -2)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(
                                                                                                                                                an_JTextField_628,
                                                                                                                                                -2,
                                                                                                                                                60,
                                                                                                                                                -2)
                                                                                                                                        .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(
                                                                                                                                                an_JButton_597,
                                                                                                                                                -2,
                                                                                                                                                61,
                                                                                                                                                -2)))
                                                                                                        .addGap(49,
                                                                                                                49,
                                                                                                                49)))))));
        grouplayout_32_
                .setVerticalGroup(grouplayout_32_
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                grouplayout_32_
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                grouplayout_32_
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                totalNpcsLabel)
                                                        .addComponent(
                                                                statusLabel)
                                                        .addComponent(
                                                                selectedNpcIdLabel)
                                                        .addComponent(
                                                                an_JLabel_631)
                                                        .addComponent(
                                                                an_JLabel_615))
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(
                                                grouplayout_32_
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                grouplayout_32_
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                npcListLabel)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(
                                                                GroupLayout.Alignment.TRAILING,
                                                                grouplayout_32_
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                dumpLabel)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(
                                                grouplayout_32_
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                grouplayout_32_
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                an_JPanel_595,
                                                                                -2,
                                                                                -1,
                                                                                -2)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(
                                                                                grouplayout_32_
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                an_JTextField_628,
                                                                                                -2,
                                                                                                -1,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                an_JButton_597)
                                                                                        .addComponent(
                                                                                                an_JButton_618)
                                                                                        .addComponent(
                                                                                                an_JButton_622))
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                an_JButton_613)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                an_JScrollPane_593,
                                                                                -1,
                                                                                100,
                                                                                32767))
                                                        .addComponent(
                                                                an_JScrollPane_600,
                                                                -1, 456, 32767)
                                                        .addGroup(
                                                                grouplayout_32_
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                an_JScrollPane_610,
                                                                                -2,
                                                                                260,
                                                                                -2)
                                                                        .addGap(18,
                                                                                18,
                                                                                18)
                                                                        .addGroup(
                                                                                grouplayout_32_
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                prefixLabel)
                                                                                        .addComponent(
                                                                                                prefixTextField,
                                                                                                -2,
                                                                                                -1,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                an_JLabel_617)
                                                                                        .addComponent(
                                                                                                startTextField,
                                                                                                -2,
                                                                                                -1,
                                                                                                -2)
                                                                                        .addComponent(
                                                                                                endLabel)
                                                                                        .addComponent(
                                                                                                endTextField,
                                                                                                -2,
                                                                                                -1,
                                                                                                -2))
                                                                        .addGap(18,
                                                                                18,
                                                                                18)
                                                                        .addGroup(
                                                                                grouplayout_32_
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(
                                                                                                saveDumpLabel,
                                                                                                -1,
                                                                                                40,
                                                                                                32767)
                                                                                        .addComponent(
                                                                                                saveDefinitionDumpLabel,
                                                                                                -1,
                                                                                                40,
                                                                                                32767)
                                                                                        .addComponent(
                                                                                                packNpcFileButton,
                                                                                                -1,
                                                                                                40,
                                                                                                32767)
                                                                                        .addComponent(
                                                                                                an_JButton_590,
                                                                                                -2,
                                                                                                40,
                                                                                                -2))
                                                                        .addGap(35,
                                                                                35,
                                                                                35)
                                                                        .addComponent(
                                                                                progressBar,
                                                                                -2,
                                                                                -1,
                                                                                -2)
                                                                        .addGap(15,
                                                                                15,
                                                                                15)))
                                        .addContainerGap()));
        pack();
    }

    private void updateWheelRotation(MouseWheelEvent mousewheelevent) {
        int rotation = mousewheelevent.getWheelRotation();
        an_int_624 += rotation * 15;
    }

    private void void_method45(MouseEvent mouseevent) {
        /* empty */
    }

    public void void_method65() {
        aClass_n_633 = new ProducingGraphicsBuffer(an_JPanel_595.getWidth(),
                an_JPanel_595.getHeight(), an_JPanel_595);
        aClass_n_633.method88(20);
    }

    private void void_method9(ActionEvent actionevent) {
        int i = Integer.parseInt(an_JTextField_628.getText()) + 1;
        an_JTextField_628.setText(new StringBuilder().append(i).append("")
                .toString());
        an_g_601 = new Renderable_Sub(definition.o_method159(),
                Integer.parseInt(an_JTextField_628.getText()));
    }

    private void void_method96(KeyEvent keyevent) {
        displayDefinitionOnScreen();
    }

}