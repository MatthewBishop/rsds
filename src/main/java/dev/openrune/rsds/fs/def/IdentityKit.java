package dev.openrune.rsds.fs.def;

import java.util.HashMap;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.GUI;
import dev.openrune.rsds.client.Model;
import dev.openrune.rsds.ui.ModelViewerFrame;

public class IdentityKit {

    @SuppressWarnings("rawtypes")
    public static HashMap caches = new HashMap();

    @SuppressWarnings("unchecked")
    public static IdentityKit get(Cache cache, int id, boolean bool) {
        if (caches.containsKey(Integer.valueOf(id))) {
            return (IdentityKit) caches.get(Integer.valueOf(id));
        }
        IdentityKit class_i = new IdentityKit(cache, id, bool);
        caches.put(Integer.valueOf(id), class_i);
        return class_i;
    }

    public static IdentityKit get(Cache cache, int file) {
        return get(cache, file, true);
    }

    public int[] headModelIds;
    public int[] bodyModelIds;
    public short[] client_aShortArray1251;
    public short[] client_aShortArray1234;
    public short[] client_aShortArray1248;
    public short[] client_aShortArray1230;
    private boolean loaded;
    public boolean notSelectable = false;
    public int file;
    public int bodyPartId;

    public IdentityKit(Cache cache, int file) {
        this(cache, file, true);
    }

    public IdentityKit(Cache cache, int file, boolean loadingRequired) {
        this.file = file;
        method3();
        if (loadingRequired) {
            load(cache);
        }
    }

    public boolean loaded() {
        return loaded;
    }

    public Model method190() {
        if (bodyModelIds == null) {
            return null;
        }
        Model[] models = new Model[bodyModelIds.length];
        int modelId;
        int i = modelId = 0;
        while (i < bodyModelIds.length) {
            Model[] models_2 = models;
            if (GUI.modelViewerFrame != null) {
                /* empty */
            }
            models_2[modelId] = ModelViewerFrame
                    .getModelFromCache(bodyModelIds[modelId]);
            i = ++modelId;
        }
        Model model;
        if (models.length == 1) {
            model = models[0];
        } else {
            model = new Model(models.length, models);
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
        if (bodyPartId != -1) {
            buffer.writeByte(1);
            buffer.writeByte(bodyPartId);
        }
        if (bodyModelIds != null) {
            buffer.writeByte(2);
            buffer.writeByte(bodyModelIds.length);
            int i_9_;
            int i = i_9_ = 0;
            while (i < bodyModelIds.length) {
                if (GUI.revision > 696) {
                    buffer.writeInt(bodyModelIds[i_9_]);
                } else {
                    buffer.writeShort(bodyModelIds[i_9_]);
                }
                i = ++i_9_;
            }
        }
        if (notSelectable) {
            buffer.writeByte(3);
        }
        if (headModelIds != null) {
            int i_10_;
            int i = i_10_ = 0;
            while (i < headModelIds.length) {
                if (headModelIds[i_10_] != -1) {
                    buffer.writeByte(i_10_ + 60);
                    if (GUI.revision > 696) {
                        buffer.writeInt(headModelIds[i_10_]);
                    } else {
                        buffer.writeShort(headModelIds[i_10_]);
                    }
                }
                i = ++i_10_;
            }
        }
        buffer.writeByte(0);
    }

    private void readValue(Buffer buffer, int opcode) {
        if (opcode == 1) {
            bodyPartId = buffer.readUByte2();
        } else if (opcode == 2) {
            int i_0_ = buffer.readUByte2();
            bodyModelIds = new int[i_0_];
            int i_2_;
            int i_1_ = i_2_ = 0;
            while (i_1_ < i_0_) {
                if (GUI.revision >= 696) {
                    bodyModelIds[i_2_] = buffer.method229();
                } else {
                    bodyModelIds[i_2_] = buffer.readUShort();
                }
                i_1_ = ++i_2_;
            }
        } else if (opcode == 3) {
            notSelectable = true;
        } else if (opcode == 40) {
            int i_3_ = buffer.readUByte2();
            client_aShortArray1234 = new short[i_3_];
            client_aShortArray1248 = new short[i_3_];
            int i_5_;
            int i_4_ = i_5_ = 0;
            while (i_4_ < i_3_) {
                client_aShortArray1234[i_5_] = (short) buffer.readUShort();
                client_aShortArray1248[i_5_] = (short) buffer.readUShort();
                i_4_ = ++i_5_;
            }
        } else if (opcode == 41) {
            int i_6_ = buffer.readUByte2();
            client_aShortArray1230 = new short[i_6_];
            client_aShortArray1251 = new short[i_6_];
            int i_8_;
            int i_7_ = i_8_ = 0;
            while (i_7_ < i_6_) {
                client_aShortArray1230[i_8_] = (short) buffer.readUShort();
                client_aShortArray1251[i_8_] = (short) buffer.readUShort();
                i_7_ = ++i_8_;
            }
        } else if (opcode >= 60 && opcode < 70) {
            if (GUI.revision >= 696) {
                headModelIds[opcode - 60] = buffer.method229();
            } else {
                headModelIds[opcode - 60] = buffer.readUShort();
            }
        } else {
            System.out.println(new StringBuilder()
                    .append("Unrecognized IDKdef opcode: ").append(opcode)
                    .toString());
        }
    }

    private void method3() {
        bodyPartId = -1;
        headModelIds = new int[]{-1, -1, -1, -1, -1};
    }

    private void load(Cache cache) {
        byte[] data;
        if ((data = cache.getFileSystems()[2].getFile(3, file)) == null) {
            System.out.println(new StringBuilder()
                    .append("FAILED LOADING IDKDEF ").append(file).toString());
        } else {
            readValues(new Buffer(data));
            loaded = true;
        }
    }

}