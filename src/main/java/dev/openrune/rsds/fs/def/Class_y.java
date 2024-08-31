package dev.openrune.rsds.fs.def;

import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.GUI;

public class Class_y {

    public int[][] anIntArrayArray_333;
    public boolean[] aBooleanArray_336;
    public int[] anIntArray_335;
    public int[] anIntArray_338;
    public int anInt_334;
    public int anInt_337;

    public Class_y(int i, byte[] data) {
        anInt_334 = i;
        Buffer buffer = new Buffer(data);
        anInt_337 = buffer.readUByte2();
        anIntArrayArray_333 = new int[anInt_337][];
        aBooleanArray_336 = new boolean[anInt_337];
        anIntArray_335 = new int[anInt_337];
        anIntArray_338 = new int[anInt_337];
        int i_0_ = 0;
        Class_y class_y_1_ = this;
        while (class_y_1_.anInt_337 > i_0_) {
            anIntArray_335[i_0_] = buffer.readUByte2();
            if (anIntArray_335[i_0_] == 6) {
                anIntArray_335[i_0_] = 2;
            }
            i_0_++;
            class_y_1_ = this;
        }
        i_0_ = 0;
        Class_y class_y_2_ = this;
        while (class_y_2_.anInt_337 > i_0_) {
            aBooleanArray_336[i_0_] = buffer.readUByte2() == 1;
            i_0_++;
            class_y_2_ = this;
        }
        if (GUI.revision >= 569) {
            i_0_ = 0;
            Class_y class_y_3_ = this;
            while (class_y_3_.anInt_337 > i_0_) {
                anIntArray_338[i_0_] = buffer.readShort();
                i_0_++;
                class_y_3_ = this;
            }
        }
        i_0_ = 0;
        Class_y class_y_4_ = this;
        while (class_y_4_.anInt_337 > i_0_) {
            anIntArrayArray_333[i_0_] = new int[buffer.readUByte2()];
            i_0_++;
            class_y_4_ = this;
        }
        i_0_ = 0;
        Class_y class_y_5_ = this;
        while (class_y_5_.anInt_337 > i_0_) {
            int i_6_ = 0;
            Class_y class_y_7_ = this;
            while (class_y_7_.anIntArrayArray_333[i_0_].length > i_6_) {
                anIntArrayArray_333[i_0_][i_6_] = buffer.readUByte2();
                i_6_++;
                class_y_7_ = this;
            }
            i_0_++;
            class_y_5_ = this;
        }
    }

    public byte[] writeValues() {
        Buffer buffer;
        (buffer = new Buffer(new byte[20000])).writeShort2(anInt_337);
        int i_8_;
        int i = i_8_ = 0;
        while (i < anInt_337) {
            buffer.writeShort2(anIntArray_335[i_8_]);
            i = ++i_8_;
        }
        int i_9_ = i_8_ = 0;
        while (i_9_ < anInt_337) {
            buffer.writeShort2(anIntArrayArray_333[i_8_].length);
            i_9_ = ++i_8_;
        }
        int i_10_ = i_8_ = 0;
        while (i_10_ < anInt_337) {
            int i_12_;
            int i_11_ = i_12_ = 0;
            while (i_11_ < anIntArrayArray_333[i_8_].length) {
                buffer.writeShort2(anIntArrayArray_333[i_8_][i_12_]);
                i_11_ = ++i_12_;
            }
            i_10_ = ++i_8_;
        }
        byte[] is = new byte[buffer.offset];
        System.arraycopy(buffer.payload, 0, is, 0, buffer.offset);
        return is;
    }

}