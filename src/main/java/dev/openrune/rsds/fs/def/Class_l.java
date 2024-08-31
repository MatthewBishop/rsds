package dev.openrune.rsds.fs.def;

import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.GUI;

public class Class_l {

    public static short[] aShortArray_542;
    public static short[] aShortArray_543;
    public static short[] aShortArray_444 = new short[500];
    public static short[] aShortArray_548 = new short[500];
    public static short[] aShortArray_550;

    static {
        aShortArray_542 = new short[500];
        aShortArray_550 = new short[500];
        aShortArray_543 = new short[500];
    }

    public short[] aShortArray_540;
    public short[] aShortArray_546;
    public short[] aShortArray_547;
    public short[] aShortArray_549;
    public short[] aShortArray_551;
    public boolean aBoolean_540;
    public int anInt_541 = -1;

    public Class_y anClass_y_552 = null;

    public Class_l(byte[] is, Class_y class_y, int i, boolean bool,
                   Buffer buffer) {
        aBoolean_540 = false;
        anClass_y_552 = class_y;
        Buffer buffer_2 = new Buffer(is);
        Buffer bffer_3 = new Buffer(is);
        if (GUI.revision >= 605) {
            buffer_2.readUByte2();
            buffer_2.offset += 2;
        } else {
            buffer_2.offset = 2;
        }
        int i_2_ = buffer_2.readUByte2();
        if (bool) {
            buffer.writeByte(i_2_);
        }
        int i_3_ = 0;
        int i_4_ = -1;
        int i_5_ = -1;
        bffer_3.offset = buffer_2.offset + i_2_;
        int i_7_;
        int i_6_ = i_7_ = 0;
        while (i_6_ < i_2_) {
            int i_8_;
            if ((i_8_ = anClass_y_552.anIntArray_335[i_7_]) == 0) {
                i_4_ = i_7_;
            }
            int i_9_ = buffer_2.readUByte2();
            if (bool) {
                buffer.writeByte(i_9_);
            }
            if (i_9_ > 0) {
                if (i_8_ == 0) {
                    i_5_ = i_7_;
                }
                aShortArray_444[i_3_] = (short) i_7_;
                short i_10_ = 0;
                if (i_8_ == 3 || i_8_ == 10) {
                    i_10_ = (short) 128;
                }
                if ((i_9_ & 0x1) != 0) {
                    aShortArray_542[i_3_] = (short) bffer_3.readSmarts2();
                    if (GUI.revision >= 605) {
                        if (i_8_ == 1) {
                            aShortArray_542[i_3_] = (short) (aShortArray_542[i_3_] / 4);
                        } else if (i_8_ == 2 || i_8_ == 9) {
                            aShortArray_542[i_3_] = (short) (aShortArray_542[i_3_] / 16);
                        }
                    }
                    if (bool) {
                        buffer.writeShort2(aShortArray_542[i_3_]);
                    }
                } else {
                    aShortArray_542[i_3_] = i_10_;
                }
                if ((i_9_ & 0x2) != 0) {
                    aShortArray_548[i_3_] = (short) bffer_3.readSmarts2();
                    if (GUI.revision >= 605) {
                        if (i_8_ == 1) {
                            aShortArray_548[i_3_] = (short) (aShortArray_548[i_3_] / 4);
                        } else if (i_8_ == 2 || i_8_ == 9) {
                            aShortArray_548[i_3_] = (short) (aShortArray_548[i_3_] / 16);
                        }
                    }
                    if (bool) {
                        buffer.writeShort2(aShortArray_548[i_3_]);
                    }
                } else {
                    aShortArray_548[i_3_] = i_10_;
                }
                if ((i_9_ & 0x4) != 0) {
                    aShortArray_550[i_3_] = (short) bffer_3.readSmarts2();
                    if (GUI.revision >= 605) {
                        if (i_8_ == 1) {
                            aShortArray_550[i_3_] = (short) (aShortArray_550[i_3_] / 4);
                        } else if (i_8_ == 2 || i_8_ == 9) {
                            aShortArray_550[i_3_] = (short) (aShortArray_550[i_3_] / 16);
                        }
                    }
                    if (bool) {
                        buffer.writeShort2(aShortArray_550[i_3_]);
                    }
                } else {
                    aShortArray_550[i_3_] = i_10_;
                }
                if (i_8_ == 2 || i_8_ == 9) {
                    aShortArray_542[i_3_] = (short) (((aShortArray_542[i_3_] & 0xff) << 3) + (aShortArray_542[i_3_] >> 8 & 0x7));
                    aShortArray_548[i_3_] = (short) (((aShortArray_548[i_3_] & 0xff) << 3) + (aShortArray_548[i_3_] >> 8 & 0x7));
                    aShortArray_550[i_3_] = (short) (((aShortArray_550[i_3_] & 0xff) << 3) + (aShortArray_550[i_3_] >> 8 & 0x7));
                    aShortArray_542[i_3_] <<= 3;
                    aShortArray_548[i_3_] <<= 3;
                    aShortArray_550[i_3_] <<= 3;
                }
                aShortArray_543[i_3_] = (short) -1;
                if (i_8_ == 1 || i_8_ == 2 || i_8_ == 3) {
                    if (i_4_ > i_5_) {
                        aShortArray_543[i_3_] = (short) i_4_;
                        i_5_ = i_4_;
                    }
                } else if (i_8_ == 5) {
                    aBoolean_540 = true;
                }
                i_3_++;
            }
            i_6_ = ++i_7_;
        }
        if (bffer_3.offset != is.length) {
            throw new RuntimeException();
        }
    }
}
