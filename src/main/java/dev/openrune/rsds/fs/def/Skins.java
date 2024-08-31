package dev.openrune.rsds.fs.def;

import dev.openrune.rsds.io.Buffer;

public final class Skins {

    public int[][] anIntArrayArray_582;
    public int[] opcodes = null;

    public Skins(Buffer buffer) {
        int length = buffer.readUShort3();
        opcodes = new int[length];
        anIntArrayArray_582 = new int[length][];
        int opcode;
        int i_0_ = opcode = 0;
        while (i_0_ < length) {
            opcodes[opcode] = buffer.readUShort3();
            i_0_ = ++opcode;
        }
        int i_2_ = opcode = 0;
        while (i_2_ < length) {
            anIntArrayArray_582[opcode] = new int[buffer.readUShort3()];
            i_2_ = ++opcode;
        }
        int i_3_ = opcode = 0;
        while (i_3_ < length) {
            int i_5_;
            int i_4_ = i_5_ = 0;
            while (i_4_ < anIntArrayArray_582[opcode].length) {
                anIntArrayArray_582[opcode][i_5_] = buffer.readUShort3();
                i_4_ = ++i_5_;
            }
            i_3_ = ++opcode;
        }
    }

}