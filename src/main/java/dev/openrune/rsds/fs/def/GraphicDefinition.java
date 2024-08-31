package dev.openrune.rsds.fs.def;

import java.util.HashMap;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.GUI;
import dev.openrune.rsds.client.Model;
import dev.openrune.rsds.ui.ModelViewerFrame;

public class GraphicDefinition {

    @SuppressWarnings("rawtypes")
    public static HashMap graphicDefinitions = new HashMap();

    public static int getChild(int i) {
        return i & 0xff;
    }

    public static int getParent(int i) {
        return i >>> 8;
    }

    public static GraphicDefinition getDefinition(Cache cache, int id) {
        return getDefinition(cache, id, true);
    }

    @SuppressWarnings("unchecked")
    public static GraphicDefinition getDefinition(Cache cache, int id,
                                                  boolean bool) {
        if (graphicDefinitions.containsKey(Integer.valueOf(id))) {
            return (GraphicDefinition) graphicDefinitions.get(Integer
                    .valueOf(id));
        }
        GraphicDefinition definition = new GraphicDefinition(cache, id, bool);
        graphicDefinitions.put(Integer.valueOf(id), definition);
        return definition;
    }

    public short[] aShortArray_555;
    public short[] originalModelColors;
    public short[] aShortArray_558;
    public short[] modifiedModelColors;
    private boolean initialize;
    public int client_anInt413;
    public int client_anInt406;
    public int client_anInt410;
    public int client_anInt414;
    public int file;
    public int client_anInt405;
    public int rotation;
    public int client_anInt411 = 128;
    public AnimationDefinition animationDefinition;

    public GraphicDefinition(Cache cache, int i) {
        this(cache, i, true);
    }

    public GraphicDefinition(Cache cache, int file,
                             boolean loadingRequired) {
        this.file = file;
        setDefaultValues();
        if (loadingRequired) {
            loadGraphicDefinitions(cache);
        }
    }

    public boolean initialized() {
        return initialize;
    }

    public Model getModel() {
        if (GUI.modelViewerFrame != null) {
            /* empty */
        }
        Model model;
        if ((model = ModelViewerFrame.getModelFromCache(client_anInt405)) == null) {
            return null;
        }
        if (originalModelColors != null) {
            int color;
            int i = color = 0;
            while (i < originalModelColors.length) {
                if (originalModelColors[0] != 0) {
                    model.recolor(originalModelColors[color],
                            modifiedModelColors[color]);
                }
                i = ++color;
            }
        }
        return model;
    }

    private void readValues(Buffer buffer) {
        int opcode;
        while ((opcode = buffer.readUByte()) != 0) {
            readValue(buffer, opcode);
        }
    }

    public void writeValues(Buffer buffer) {
        if (client_anInt405 != 0) {
            buffer.writeByte(1);
            if (GUI.revision > 700) {
                buffer.writeInt(client_anInt405);
            } else {
                buffer.writeShort(client_anInt405);
            }
        }
        if (client_anInt406 != -1) {
            buffer.writeByte(2);
            if (GUI.revision > 700) {
                buffer.writeInt(client_anInt406);
            } else {
                buffer.writeShort(client_anInt406);
            }
        }
        if (client_anInt410 != 128) {
            buffer.writeByte(4);
            buffer.writeShort(client_anInt410);
        }
        if (client_anInt411 != 128) {
            buffer.writeByte(5);
            buffer.writeShort(client_anInt411);
        }
        if (rotation != 0) {
            buffer.writeByte(6);
            buffer.writeShort(rotation);
        }
        if (client_anInt413 != 0) {
            buffer.writeByte(7);
            buffer.writeByte(client_anInt413);
        }
        if (client_anInt414 != 0) {
            buffer.writeByte(7);
            buffer.writeByte(client_anInt414);
        }
        if (originalModelColors != null) {
            buffer.writeByte(40);
            buffer.writeByte(originalModelColors.length);
            int i_13_;
            int i = i_13_ = 0;
            while (i < originalModelColors.length) {
                buffer.writeShort(originalModelColors[i_13_]);
                buffer.writeShort(modifiedModelColors[i_13_]);
                i = ++i_13_;
            }
        }
        buffer.writeByte(0);
    }

    private void readValue(Buffer buffer, int opcode) {
        if (opcode == 1) {
            if (GUI.revision > 700) {
                client_anInt405 = buffer.method229();
            } else {
                client_anInt405 = buffer.readUShort();
            }
        } else if (opcode == 2) {
            if (GUI.revision > 700) {
                client_anInt406 = buffer.method229();
            } else {
                client_anInt406 = buffer.readUShort();
            }
            try {
                animationDefinition = AnimationDefinition.getDefinition(
                        GUI.cache, client_anInt406);
            } catch (Exception exception) {
            }
        } else if (opcode == 4) {
            client_anInt410 = buffer.readUShort();
        } else if (opcode == 5) {
            client_anInt411 = buffer.readUShort();
        } else if (opcode == 6) {
            rotation = buffer.readUShort();
        } else if (opcode == 7) {
            client_anInt413 = buffer.readUByte();
        } else if (opcode == 8) {
            client_anInt414 = buffer.readUByte();
        } else if (opcode != 9 && opcode != 10 && opcode != 11 && opcode != 12
                && opcode != 13) {
            if (opcode == 14) {
            } else if (opcode == 15) {
                buffer.readUShort();
            } else if (opcode == 16) {
                buffer.readInt3();
            } else if (opcode == 40) {
                int i_6_ = buffer.readUByte();
                originalModelColors = new short[i_6_];
                modifiedModelColors = new short[i_6_];
                int i_8_;
                int i_7_ = i_8_ = 0;
                while (i_7_ < i_6_) {
                    originalModelColors[i_8_] = (short) buffer.readUShort();
                    modifiedModelColors[i_8_] = (short) buffer.readUShort();
                    i_7_ = ++i_8_;
                }
            } else if (opcode == 41) {
                int i_9_ = buffer.readUByte();
                aShortArray_558 = new short[i_9_];
                aShortArray_555 = new short[i_9_];
                int i_10_ = 0;
                int i_11_ = i_9_;
                while (i_11_ > i_10_) {
                    aShortArray_555[i_10_] = (short) buffer.readUShort();
                    aShortArray_558[i_10_] = (short) buffer.readUShort();
                    i_10_++;
                    i_11_ = i_9_;
                }
            }
        }
    }

    private void loadGraphicDefinitions(Cache cache) {
        byte[] buffer;
        if ((buffer = cache.getFileSystems()[21].getFile(getParent(file),
                getChild(file))) == null) {
            System.out.println(new StringBuilder()
                    .append("FAILED LOADING GXFDEF ").append(file).toString());
        } else {
            readValues(new Buffer(buffer));
            initialize = true;
        }
    }

    private void setDefaultValues() {
        client_anInt410 = 128;
        client_anInt406 = -1;
        rotation = 0;
        client_anInt414 = 0;
        client_anInt413 = 0;
    }

}