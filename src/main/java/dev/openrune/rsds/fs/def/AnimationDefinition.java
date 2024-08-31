package dev.openrune.rsds.fs.def;

import java.util.HashMap;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.GUI;

public class AnimationDefinition {

    @SuppressWarnings("rawtypes")
    public static HashMap caches = new HashMap();

    public static int getChildFile(int i) {
        return i & 0x7f;
    }

    public static int getParentFile(int i) {
        if (GUI.revision >= 652 && GUI.revision < 667) {
            return i >>> 39;
        }
        return i >>> 7;
    }

    public static AnimationDefinition getDefinition(Cache cache, int id) {
        return getDefinition(cache, id, true);
    }

    @SuppressWarnings("unchecked")
    public static AnimationDefinition getDefinition(Cache cache,
                                                    int key, boolean bool) {
        if (caches.containsKey(Integer.valueOf(key))) {
            return (AnimationDefinition) caches.get(Integer.valueOf(key));
        }
        AnimationDefinition definition = new AnimationDefinition(cache, key,
                bool);
        caches.put(Integer.valueOf(key), definition);
        return definition;
    }

    public int[][] anIntArrayArray_459;
    public int[] anIntArray_456;
    public int[] anIntArray_461;
    public int[] anIntArray_468;
    public int[] anIntArray_469;
    public int[] client_anIntArray357;
    public int[] delays;
    public int[] frames;
    public boolean client_aBoolean358;
    public boolean aBoolean_465;
    private boolean initialized;
    public int rightHandEquip;
    public int client_anInt365;
    public int leftHandEquip;
    public int file;
    public int client_anInt364;
    public int loopCycles = 99;
    public int priority;
    public int client_anInt363;
    public int loopDelay;
    public int frameCount;

    public AnimationDefinition(Cache cache, int file) {
        this(cache, file, true);
    }

    public AnimationDefinition(Cache cache, int file,
                               boolean loadingRequired) {
        aBoolean_465 = false;
        this.file = file;
        resetValues();
        if (loadingRequired) {
            loadAnimationDefinitions(cache);
        }
    }

    public boolean isInitialized() {
        return initialized;
    }

    public int getDelay(int i) {
        if (delays == null || i < 0) {
            return 1;
        }
        int delay = delays[i];
        if (delay == 0) {
            delay = 1;
        }
        return delay;
    }

    private void init(Buffer buffer) {
        int opcode;
        while ((opcode = buffer.readUByte()) != 0) {
            readValues(buffer, opcode);
        }
    }

    public void void_method157(Buffer buffer) {
        if (frames != null) {
            buffer.writeByte(1);
            buffer.writeShort2(frameCount);
            int i_27_;
            int i = i_27_ = 0;
            while (i < frameCount) {
                buffer.writeInt2(frames[i_27_]);
                i = ++i_27_;
            }
            int i_28_ = i_27_ = 0;
            while (i_28_ < frameCount) {
                buffer.writeByte(delays[i_27_]);
                i_28_ = ++i_27_;
            }
        }
        if (loopDelay != -1) {
            buffer.writeByte(2);
            buffer.writeShort2(loopDelay);
        }
        if (client_anIntArray357 != null) {
            buffer.writeByte(3);
            buffer.writeByte(client_anIntArray357.length - 1);
            int i_29_;
            int i = i_29_ = 0;
            while (i < client_anIntArray357.length - 1) {
                buffer.writeByte(client_anIntArray357[i_29_]);
                i = ++i_29_;
            }
        }
        if (client_aBoolean358) {
            buffer.writeByte(4);
        }
        if (priority != 5) {
            buffer.writeByte(5);
            buffer.writeByte(priority);
        }
        if (rightHandEquip != -1) {
            buffer.writeByte(6);
            buffer.writeShort2(rightHandEquip);
        }
        if (leftHandEquip != -1) {
            buffer.writeByte(7);
            buffer.writeShort2(leftHandEquip);
        }
        if (loopCycles != 99) {
            buffer.writeByte(8);
            buffer.writeByte(loopCycles);
        }
        if (client_anInt363 != -1) {
            buffer.writeByte(9);
            buffer.writeByte(client_anInt363);
        }
        if (client_anInt364 != -1) {
            buffer.writeByte(10);
            buffer.writeByte(client_anInt364);
        }
        if (client_anInt365 != 2) {
            buffer.writeByte(11);
            buffer.writeByte(client_anInt365);
        }
        buffer.writeByte(0);
    }

    private void readValues(Buffer buffer, int opcode) {
        if (opcode == 1) {
            frameCount = buffer.readUShort2();
            delays = new int[frameCount];
            int i_2_;
            int i_1_ = i_2_ = 0;
            while (i_1_ < frameCount) {
                delays[i_2_] = buffer.readUShort2();
                i_1_ = ++i_2_;
            }
            frames = new int[frameCount];
            int i_3_ = i_2_ = 0;
            while (i_3_ < frameCount) {
                frames[i_2_] = buffer.readUShort2();
                i_3_ = ++i_2_;
            }
            int i_4_ = i_2_ = 0;
            while (i_4_ < frameCount) {
                frames[i_2_] = (buffer.readUShort2() << 16) + frames[i_2_];
                i_4_ = ++i_2_;
            }
        } else if (opcode == 2) {
            loopDelay = buffer.readUShort2();
        } else if (opcode == 3) {
            int length = buffer.readUByte2();
            client_anIntArray357 = new int[length + 1];
            int index;
            int i_6_ = index = 0;
            while (i_6_ < length) {
                client_anIntArray357[index] = buffer.readUByte2();
                i_6_ = ++index;
            }
            client_anIntArray357[length] = 9999999;
        } else if (opcode == 4) {
            client_aBoolean358 = true;
        } else if (opcode == 5) {
            priority = buffer.readUByte2();
        } else if (opcode == 6) {
            rightHandEquip = buffer.readUShort2();
            if (rightHandEquip == 65535) {
                rightHandEquip = 0;
            } else {
                rightHandEquip += 512;
            }
        } else if (opcode == 7) {
            leftHandEquip = buffer.readUShort2();
            if (leftHandEquip == 65535) {
                leftHandEquip = 0;
            } else {
                leftHandEquip += 512;
            }
        } else if (opcode == 8) {
            loopCycles = buffer.readUByte2();
        } else if (opcode == 9) {
            client_anInt363 = buffer.readUByte2();
        } else if (opcode == 10) {
            client_anInt364 = buffer.readUByte2();
        } else if (opcode == 11) {
            client_anInt365 = buffer.readUByte2();
        } else if (opcode == 12) {
            int i_8_ = buffer.readUByte2();
            anIntArray_469 = new int[i_8_];
            int i_10_;
            int i_9_ = i_10_ = 0;
            while (i_9_ < i_8_) {
                anIntArray_469[i_10_] = buffer.readUShort2();
                i_9_ = ++i_10_;
            }
            int i_11_ = i_10_ = 0;
            while (i_11_ < i_8_) {
                anIntArray_469[i_10_] = (buffer.readUShort2() << 16)
                        + anIntArray_469[i_10_];
                i_11_ = ++i_10_;
            }
        } else if (opcode == 13) {
            if (GUI.revision <= 498) {
                int i_12_;
                int[] is = new int[i_12_ = buffer.readUByte2()];
                int i_13_ = 0;
                int i_14_ = i_12_;
                while (i_14_ > i_13_) {
                    is[i_13_] = buffer.readMediumInt3();
                    i_13_++;
                    i_14_ = i_12_;
                }
            } else {
                int i_15_ = buffer.readUShort2();
                anIntArrayArray_459 = new int[i_15_][];
                int i_17_;
                int i_16_ = i_17_ = 0;
                while (i_16_ < i_15_) {
                    int i_18_;
                    if ((i_18_ = buffer.readUByte2()) > 0) {
                        anIntArrayArray_459[i_17_] = new int[i_18_];
                        anIntArrayArray_459[i_17_][0] = buffer.readMediumInt3();
                        int i_20_;
                        int i_19_ = i_20_ = 1;
                        while (i_19_ < i_18_) {
                            anIntArrayArray_459[i_17_][i_20_] = buffer
                                    .readUShort2();
                            i_19_ = ++i_20_;
                        }
                    }
                    i_16_ = ++i_17_;
                }
            }
        } else if (opcode == 14) {
            aBoolean_465 = true;
        } else if (opcode == 15) {
        } else if (opcode == 16) {
        } else if (opcode == 17) {
            buffer.readUByte2();
        } else if (opcode == 18) {
        } else if (opcode == 19) {
            if (anIntArray_461 == null) {
                anIntArray_461 = new int[anIntArrayArray_459.length];
                int i_23_;
                int i_22_ = i_23_ = 0;
                while (i_22_ < anIntArrayArray_459.length) {
                    anIntArray_461[i_23_] = 255;
                    i_22_ = ++i_23_;
                }
            }
            anIntArray_461[buffer.readUByte2()] = buffer.readUByte2();
        } else if (opcode == 20) {
            if (anIntArray_456 == null || anIntArray_468 == null) {
                anIntArray_456 = new int[anIntArrayArray_459.length];
                anIntArray_468 = new int[anIntArrayArray_459.length];
                int i_25_;
                int i_24_ = i_25_ = 0;
                while (i_24_ < anIntArrayArray_459.length) {
                    anIntArray_456[i_25_] = 256;
                    anIntArray_468[i_25_] = 256;
                    i_24_ = ++i_25_;
                }
            }
            int i_26_ = buffer.readUByte2();
            anIntArray_456[i_26_] = buffer.readUShort2();
            anIntArray_468[i_26_] = buffer.readUShort2();
        } else {
            System.out.println(new StringBuilder()
                    .append("Unrecognized AnimDef opcode: ").append(opcode)
                    .toString());
        }
    }

    private void resetValues() {
        client_aBoolean358 = false;
        client_anInt364 = -1;
        leftHandEquip = -1;
        client_anInt363 = -1;
        client_anInt365 = 2;
        loopDelay = -1;
        priority = 5;
        rightHandEquip = -1;
    }

    private void loadAnimationDefinitions(Cache cache) {
        byte[] buffer;
        if ((buffer = cache.getFileSystems()[20].getFile(getParentFile(file),
                getChildFile(file))) == null) {
            System.out.println(new StringBuilder()
                    .append("FAILED LOADING ANIMDEF ").append(file).toString());
        } else {
            init(new Buffer(buffer));
            initialized = true;
        }
    }

    public void void_method65() {
        if (client_anInt364 == -1) {
            if (client_anIntArray357 == null) {
                client_anInt364 = 0;
            } else {
                client_anInt364 = 2;
            }
        }
        if (client_anInt363 == -1) {
            if (client_anIntArray357 != null) {
                client_anInt363 = 2;
            } else {
                client_anInt363 = 0;
            }
        }
    }

}