package dev.openrune.rsds.fs.def;

import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.GUI;

public final class Animation {

    public static Animation[][] animationList;

    public static boolean frameIsNull(int frame) {
        return frame == -1;
    }

    public static void clearAnimations() {
        animationList = null;
    }

    public static void init(int i) {
        animationList = new Animation[6000][0];
    }

    public static void method79(int id) {
        try {
            Class_n class_n;
            (class_n = new Class_n()).method183(GUI.cache, id, true);
            byte[] is = class_n.an_y_532.writeValues();
            byte[] is_0_ = new byte[class_n.buffer.offset];
            System.arraycopy(class_n.buffer.payload, 0, is_0_, 0,
                    class_n.buffer.offset);
            Buffer buffer = new Buffer(is_0_);
            Skins skins = new Skins(new Buffer(is));
            int i_1_ = buffer.readUShort3();
            animationList[id] = new Animation[i_1_ * 3];
            int[] is_2_ = new int[500];
            int[] is_3_ = new int[500];
            int[] is_4_ = new int[500];
            int[] is_5_ = new int[500];
            for (int i_6_ = 0; i_6_ < i_1_; i_6_++) {
                int frame = buffer.readUShort3();
                Animation animation;
                (animation = animationList[id][frame] = new Animation()).skins = skins;
                int i_8_ = buffer.readUByte2();
                int i_9_ = 0;
                int i_10_ = -1;
                int i_12_;
                int i_11_ = i_12_ = 0;
                while (i_11_ < i_8_) {
                    int i_13_ = buffer.readUByte2();
                    if (i_13_ > 0) {
                        if (skins.opcodes[i_12_] != 0) {
                            int i_16_;
                            int i_15_ = i_16_ = i_12_ - 1;
                            while (i_15_ > i_10_) {
                                if (skins.opcodes[i_16_] == 0) {
                                    is_2_[i_9_] = i_16_;
                                    is_3_[i_9_] = 0;
                                    is_4_[i_9_] = 0;
                                    is_5_[i_9_] = 0;
                                    i_9_++;
                                    break;
                                }
                                i_15_ = --i_16_;
                            }
                        }
                        is_2_[i_9_] = i_12_;
                        int i_17_ = 0;
                        if (skins.opcodes[i_12_] == 3) {
                            i_17_ = 128;
                        }
                        if ((i_13_ & 0x1) != 0) {
                            is_3_[i_9_] = (short) buffer.readShort3();
                        } else {
                            is_3_[i_9_] = i_17_;
                        }
                        if ((i_13_ & 0x2) != 0) {
                            is_4_[i_9_] = buffer.readShort3();
                        } else {
                            is_4_[i_9_] = i_17_;
                        }
                        if ((i_13_ & 0x4) != 0) {
                            is_5_[i_9_] = buffer.readShort3();
                        } else {
                            is_5_[i_9_] = i_17_;
                        }
                        i_10_ = i_12_;
                        i_9_++;
                    }
                    i_11_ = ++i_12_;
                }
                animation.stepCount = i_9_;
                animation.opcodeLinkTable = new int[i_9_];
                animation.anIntArray_329 = new int[i_9_];
                animation.anIntArray_327 = new int[i_9_];
                animation.anIntArray_326 = new int[i_9_];
                int i_18_ = i_12_ = 0;
                while (i_18_ < i_9_) {
                    animation.opcodeLinkTable[i_12_] = is_2_[i_12_];
                    animation.anIntArray_329[i_12_] = is_3_[i_12_];
                    animation.anIntArray_327[i_12_] = is_4_[i_12_];
                    animation.anIntArray_326[i_12_] = is_5_[i_12_];
                    i_18_ = ++i_12_;
                }
            }
        } catch (Exception exception) {
            /* empty */
        }
    }

    public static Animation getAnimation(int i) {
        return getAnimationInternal(i);
    }

    public static Animation getAnimationInternal(int i) {
        if (animationList == null) {
            animationList = new Animation[6000][0];
        }
        int frame = i & 0xffff;
        int id = i >> 48;
        Animation animation;
        try {
            if (animationList[id].length == 0) {
                method79(id);
            }
            animation = animationList[id][frame];
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("animationlist[")
                    .append(id).append("].length:")
                    .append(animationList[id].length).append(", req frame:")
                    .append(frame).toString());
            return null;
        }
        return animation;
    }

    public int[] anIntArray_326;
    public int[] anIntArray_327;
    public int[] opcodeLinkTable;
    public int[] anIntArray_329;
    public Skins skins;
    public int stepCount;
    public int anInt_325;

    private Animation() {
        /* empty */
    }

}