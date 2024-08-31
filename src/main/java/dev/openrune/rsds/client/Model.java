package dev.openrune.rsds.client;

import dev.openrune.rsds.fs.def.Animation;
import dev.openrune.rsds.fs.def.Skins;
import dev.openrune.rsds.io.Buffer;

public final class Model extends Renderable {

    private static int[][] anIntArrayArray_177;
    private static int[][] anIntArrayArray_194;
    private static boolean[] aBooleanArray_152;
    private static boolean[] aBooleanArray_198;
    private static ModelHeader[] modelHeaders;
    private static int[] anIntArray_148;
    public static int[] anIntArray_150;
    static int[] anIntArray_151;
    static int[] anIntArray_154;
    private static int[] anIntArray_158;
    private static int[] anIntArray_160;
    private static int[] anIntArray_161;
    public static int[] anIntArray_164;
    private static int[] anIntArray_169;
    private static int[] anIntArray_175;
    private static int[] anIntArray_179;
    private static final int[] anIntArray_180;
    private static final int[] anIntArray_187;
    private static int[] anIntArray_188;
    private static int[] anIntArray_193 = new int[2000];
    private static int[] anIntArray_195;
    private static int[] anIntArray_199;
    private static int[] anIntArray_200;
    private static int[] anIntArray_202 = new int[2000];
    private static int[] anIntArray_203;
    public static final int[] anIntArray_206;
    private static int[] anIntArray_207;
    private static final int[] anIntArray_214;
    public static boolean aBoolean_212;
    private static int anInt_157;
    public static int anInt_162;
    private static int anInt_167;
    public static int anInt_176;
    public static int anInt_184;
    private static int anInt_192;
    public static final Model model = new Model();

    static {
        anIntArray_169 = new int[2000];
        anIntArray_161 = new int[2000];
        aBooleanArray_152 = new boolean[4096];
        aBooleanArray_198 = new boolean[4096];
        anIntArray_148 = new int[4096];
        anIntArray_199 = new int[4096];
        anIntArray_207 = new int[4096];
        anIntArray_188 = new int[4096];
        anIntArray_160 = new int[4096];
        anIntArray_195 = new int[4096];
        anIntArray_200 = new int[1500];
        anIntArrayArray_177 = new int[1500][512];
        anIntArray_158 = new int[12];
        anIntArrayArray_194 = new int[12][2000];
        anIntArray_203 = new int[2000];
        anIntArray_179 = new int[2000];
        anIntArray_175 = new int[12];
        anIntArray_214 = new int[10];
        anIntArray_180 = new int[10];
        anIntArray_187 = new int[10];
        anIntArray_206 = new int[1000];
        anIntArray_150 = Rasterizer3D.anIntArray_137;
        anIntArray_164 = Rasterizer3D.anIntArray_121;
        anIntArray_154 = Rasterizer3D.anIntArray_129;
        anIntArray_151 = Rasterizer3D.anIntArray_133;
    }

    public static boolean boolean_method74(int i) {
        if (modelHeaders == null) {
            return false;
        }
        return true;
    }

    private static int int_method85(int i, int i_547_, int i_548_) {
        if ((i_548_ & 0x2) == 2) {
            if (i_547_ < 0) {
                i_547_ = 0;
            } else if (i_547_ > 127) {
                i_547_ = 127;
            }
            return i_547_ = 127 - i_547_;
        }
        if ((i_547_ = i_547_ * (i & 0x7f) >> 7) < 2) {
            i_547_ = 2;
        } else if (i_547_ > 126) {
            i_547_ = 126;
        }
        return (i & 0xff80) + i_547_;
    }

    public static Model createModel(byte[] is) {
        return new Model(is);
    }

    public static Model createModel(int i) {
        if (modelHeaders == null) {
            return null;
        }
        return new Model(i);
    }

    public static void resetModelHeaders(int i) {
        modelHeaders = new ModelHeader[i];
    }

    public static void clearFields() {
        modelHeaders = null;
        aBooleanArray_152 = null;
        aBooleanArray_198 = null;
        anIntArray_148 = null;
        anIntArray_199 = null;
        anIntArray_207 = null;
        anIntArray_188 = null;
        anIntArray_160 = null;
        anIntArray_195 = null;
        anIntArray_200 = null;
        anIntArrayArray_177 = null;
        anIntArray_158 = null;
        anIntArrayArray_194 = null;
        anIntArray_203 = null;
        anIntArray_179 = null;
        anIntArray_175 = null;
        anIntArray_150 = null;
        anIntArray_164 = null;
        anIntArray_154 = null;
        anIntArray_151 = null;
    }

    public static void void_method70(int i) {
        modelHeaders[i] = null;
    }

    public static void method83(byte[] is, int i) {
        if (is == null) {
            ModelHeader class_i;
            (class_i = modelHeaders[i] = new ModelHeader()).an_int_436 = 0;
            class_i.an_int_440 = 0;
            class_i.an_int_445 = 0;
        } else {
            Buffer class_k;
            (class_k = new Buffer(is)).offset = is.length - 18;
            if (modelHeaders == null) {
                resetModelHeaders(1);
            }
            ModelHeader class_i;
            (class_i = modelHeaders[i] = new ModelHeader()).aByteArray_442 = is;
            class_i.an_int_436 = class_k.readUShort4();
            class_i.an_int_440 = class_k.readUShort4();
            class_i.an_int_445 = class_k.readUByte2();
            int i_484_ = class_k.readUByte2();
            int i_485_ = class_k.readUByte2();
            int i_486_ = class_k.readUByte2();
            int i_487_ = class_k.readUByte2();
            int i_488_ = class_k.readUByte2();
            int i_489_ = class_k.readUShort4();
            int i_490_ = class_k.readUShort4();
            int i_491_ = class_k.readUShort4();
            int i_492_ = class_k.readUShort4();
            int i_493_ = 0;
            class_i.an_int_444 = i_493_;
            i_493_ += class_i.an_int_436;
            class_i.an_int_450 = i_493_;
            i_493_ += class_i.an_int_440;
            class_i.an_int_446 = i_493_;
            if (i_485_ == 255) {
                i_493_ += class_i.an_int_440;
            } else {
                class_i.an_int_446 = -i_485_ - 1;
            }
            class_i.an_int_449 = i_493_;
            if (i_487_ == 1) {
                i_493_ += class_i.an_int_440;
            } else {
                class_i.an_int_449 = -1;
            }
            class_i.an_int_438 = i_493_;
            if (i_484_ == 1) {
                i_493_ += class_i.an_int_440;
            } else {
                class_i.an_int_438 = -1;
            }
            class_i.an_int_451 = i_493_;
            if (i_488_ == 1) {
                i_493_ += class_i.an_int_436;
            } else {
                class_i.an_int_451 = -1;
            }
            class_i.an_int_447 = i_493_;
            if (i_486_ == 1) {
                i_493_ += class_i.an_int_440;
            } else {
                class_i.an_int_447 = -1;
            }
            class_i.an_int_437 = i_493_;
            i_493_ += i_492_;
            class_i.an_int_443 = i_493_;
            i_493_ += class_i.an_int_440 * 2;
            class_i.an_int_452 = i_493_;
            i_493_ += class_i.an_int_445 * 6;
            class_i.an_int_439 = i_493_;
            i_493_ += i_489_;
            class_i.an_int_441 = i_493_;
            i_493_ += i_490_;
            class_i.an_int_448 = i_493_;
            i_493_ += i_491_;
        }
    }

    public int[][] anIntArrayArray_173;
    public int[][] anIntArrayArray_209;
    public int[] anIntArray_146;
    private int[] anIntArray_153;
    private int[] anIntArray_155;
    private int[] anIntArray_156;
    private int[] anIntArray_163;
    public int[] anIntArray_165;
    public int[] modelColors;
    public int[] anIntArray_168;
    private int[] anIntArray_171;
    private int[] anIntArray_178;
    private int[] anIntArray_182;
    private int[] anIntArray_185;
    public int[] anIntArray_189;
    public int[] anIntArray_190;
    public int[] anIntArray_191;
    public int[] anIntArray_204;
    public int[] anIntArray_205;
    private int[] anIntArray_208;
    VertexNormal[] aVertexNormaArray;
    public boolean aBoolean_211 = false;
    public boolean aBoolean_217;
    public int vertexCount;
    public int anInt_149;
    public int anInt_159;
    public int anInt_170;
    private int anInt_172;
    public int anInt_181;
    private int anInt_186;
    private int anInt_196;
    public int modelCount;
    public int anInt_201;
    public int anInt_210;
    private int anInt_213;
    public int anInt_216;

    private Model() {
        aBoolean_217 = false;
    }

    public Model(Model[] models) {
        int i = 2;
        aBoolean_217 = false;
        boolean bool = false;
        boolean bool_349_ = false;
        boolean bool_350_ = false;
        boolean bool_351_ = false;
        vertexCount = 0;
        modelCount = 0;
        anInt_186 = 0;
        anInt_213 = -1;
        int i_353_;
        int i_352_ = i_353_ = 0;
        while (i_352_ < i) {
            Model var_a_sub_46_354_;
            if ((var_a_sub_46_354_ = models[i_353_]) != null) {
                vertexCount += var_a_sub_46_354_.vertexCount;
                modelCount += var_a_sub_46_354_.modelCount;
                anInt_186 += var_a_sub_46_354_.anInt_186;
                bool = bool | var_a_sub_46_354_.anIntArray_168 != null;
                if (var_a_sub_46_354_.anIntArray_165 != null) {
                    bool_349_ = true;
                } else {
                    if (anInt_213 == -1) {
                        anInt_213 = var_a_sub_46_354_.anInt_213;
                    }
                    if (anInt_213 != var_a_sub_46_354_.anInt_213) {
                        bool_349_ = true;
                    }
                }
                bool_350_ = bool_350_
                        | var_a_sub_46_354_.anIntArray_185 != null;
                bool_351_ = bool_351_ | var_a_sub_46_354_.modelColors != null;
            }
            i_352_ = ++i_353_;
        }
        anIntArray_205 = new int[vertexCount];
        anIntArray_191 = new int[vertexCount];
        anIntArray_189 = new int[vertexCount];
        anIntArray_204 = new int[modelCount];
        anIntArray_146 = new int[modelCount];
        anIntArray_190 = new int[modelCount];
        anIntArray_182 = new int[modelCount];
        anIntArray_156 = new int[modelCount];
        anIntArray_171 = new int[modelCount];
        anIntArray_163 = new int[anInt_186];
        anIntArray_155 = new int[anInt_186];
        anIntArray_208 = new int[anInt_186];
        if (bool) {
            anIntArray_168 = new int[modelCount];
        }
        if (bool_349_) {
            anIntArray_165 = new int[modelCount];
        }
        if (bool_350_) {
            anIntArray_185 = new int[modelCount];
        }
        if (bool_351_) {
            modelColors = new int[modelCount];
        }
        vertexCount = 0;
        modelCount = 0;
        anInt_186 = 0;
        i_353_ = 0;
        int i_356_;
        int i_355_ = i_356_ = 0;
        while (i_355_ < i) {
            Model var_a_sub_46_357_;
            if ((var_a_sub_46_357_ = models[i_356_]) != null) {
                int i_358_ = vertexCount;
                int i_360_;
                int i_359_ = i_360_ = 0;
                while (i_359_ < var_a_sub_46_357_.vertexCount) {
                    anIntArray_205[vertexCount] = var_a_sub_46_357_.anIntArray_205[i_360_];
                    anIntArray_191[vertexCount] = var_a_sub_46_357_.anIntArray_191[i_360_];
                    anIntArray_189[vertexCount] = var_a_sub_46_357_.anIntArray_189[i_360_];
                    vertexCount++;
                    i_359_ = ++i_360_;
                }
                int i_361_ = i_360_ = 0;
                while (i_361_ < var_a_sub_46_357_.modelCount) {
                    anIntArray_204[modelCount] = var_a_sub_46_357_.anIntArray_204[i_360_]
                            + i_358_;
                    anIntArray_146[modelCount] = var_a_sub_46_357_.anIntArray_146[i_360_]
                            + i_358_;
                    anIntArray_190[modelCount] = var_a_sub_46_357_.anIntArray_190[i_360_]
                            + i_358_;
                    anIntArray_182[modelCount] = var_a_sub_46_357_.anIntArray_182[i_360_];
                    anIntArray_156[modelCount] = var_a_sub_46_357_.anIntArray_156[i_360_];
                    anIntArray_171[modelCount] = var_a_sub_46_357_.anIntArray_171[i_360_];
                    if (bool) {
                        if (var_a_sub_46_357_.anIntArray_168 == null) {
                            anIntArray_168[modelCount] = 0;
                        } else {
                            int i_362_;
                            if (((i_362_ = var_a_sub_46_357_.anIntArray_168[i_360_]) & 0x2) == 2) {
                                i_362_ += i_353_ << 2;
                            }
                            anIntArray_168[modelCount] = i_362_;
                        }
                    }
                    if (bool_349_) {
                        if (var_a_sub_46_357_.anIntArray_165 == null) {
                            anIntArray_165[modelCount] = var_a_sub_46_357_.anInt_213;
                        } else {
                            anIntArray_165[modelCount] = var_a_sub_46_357_.anIntArray_165[i_360_];
                        }
                    }
                    if (bool_350_) {
                        if (var_a_sub_46_357_.anIntArray_185 == null) {
                            anIntArray_185[modelCount] = 0;
                        } else {
                            anIntArray_185[modelCount] = var_a_sub_46_357_.anIntArray_185[i_360_];
                        }
                    }
                    if (bool_351_ && var_a_sub_46_357_.modelColors != null) {
                        modelColors[modelCount] = var_a_sub_46_357_.modelColors[i_360_];
                    }
                    modelCount++;
                    i_361_ = ++i_360_;
                }
                int i_363_ = i_360_ = 0;
                while (i_363_ < var_a_sub_46_357_.anInt_186) {
                    anIntArray_163[anInt_186] = var_a_sub_46_357_.anIntArray_163[i_360_]
                            + i_358_;
                    anIntArray_155[anInt_186] = var_a_sub_46_357_.anIntArray_155[i_360_]
                            + i_358_;
                    anIntArray_208[anInt_186] = var_a_sub_46_357_.anIntArray_208[i_360_]
                            + i_358_;
                    anInt_186++;
                    i_363_ = ++i_360_;
                }
                i_353_ += var_a_sub_46_357_.anInt_186;
            }
            i_355_ = ++i_356_;
        }
        void_method38();
    }

    public Model(boolean bool, boolean bool_142_, Model var_a_sub_46_143_) {
        aBoolean_217 = false;
        vertexCount = var_a_sub_46_143_.vertexCount;
        modelCount = var_a_sub_46_143_.modelCount;
        anInt_186 = var_a_sub_46_143_.anInt_186;
        if (bool) {
            anIntArray_191 = new int[vertexCount];
            System.arraycopy(var_a_sub_46_143_.anIntArray_191, 0,
                    anIntArray_191, 0, vertexCount);
        } else {
            anIntArray_191 = var_a_sub_46_143_.anIntArray_191;
        }
        if (bool_142_) {
            anIntArray_182 = new int[modelCount];
            anIntArray_156 = new int[modelCount];
            anIntArray_171 = new int[modelCount];
            int i_144_;
            int i = i_144_ = 0;
            while (i < modelCount) {
                anIntArray_182[i_144_] = var_a_sub_46_143_.anIntArray_182[i_144_];
                anIntArray_156[i_144_] = var_a_sub_46_143_.anIntArray_156[i_144_];
                anIntArray_171[i_144_] = var_a_sub_46_143_.anIntArray_171[i_144_];
                i = ++i_144_;
            }
            anIntArray_168 = new int[modelCount];
            if (var_a_sub_46_143_.anIntArray_168 == null) {
                int i_145_ = i_144_ = 0;
                while (i_145_ < modelCount) {
                    anIntArray_168[i_144_] = 0;
                    i_145_ = ++i_144_;
                }
            } else {
                System.arraycopy(var_a_sub_46_143_.anIntArray_168, 0,
                        anIntArray_168, 0, modelCount);
            }
            vertexNormals = new VertexNormal[vertexCount];
            int i_146_ = i_144_ = 0;
            while (i_146_ < vertexCount) {
                VertexNormal class_w = vertexNormals[i_144_] = new VertexNormal();
                VertexNormal class_w_147_ = var_a_sub_46_143_.aVertexNormaArray[i_144_];
                class_w.an_int_116 = class_w_147_.an_int_116;
                class_w.an_int_118 = class_w_147_.an_int_118;
                class_w.an_int_115 = class_w_147_.an_int_115;
                class_w.an_int_117 = class_w_147_.an_int_117;
                i_146_ = ++i_144_;
            }
            aVertexNormaArray = var_a_sub_46_143_.aVertexNormaArray;
        } else {
            anIntArray_182 = var_a_sub_46_143_.anIntArray_182;
            anIntArray_156 = var_a_sub_46_143_.anIntArray_156;
            anIntArray_171 = var_a_sub_46_143_.anIntArray_171;
            anIntArray_168 = var_a_sub_46_143_.anIntArray_168;
        }
        anIntArray_205 = var_a_sub_46_143_.anIntArray_205;
        anIntArray_189 = var_a_sub_46_143_.anIntArray_189;
        modelColors = var_a_sub_46_143_.modelColors;
        anIntArray_185 = var_a_sub_46_143_.anIntArray_185;
        anIntArray_165 = var_a_sub_46_143_.anIntArray_165;
        anInt_213 = var_a_sub_46_143_.anInt_213;
        anIntArray_204 = var_a_sub_46_143_.anIntArray_204;
        anIntArray_146 = var_a_sub_46_143_.anIntArray_146;
        anIntArray_190 = var_a_sub_46_143_.anIntArray_190;
        anIntArray_163 = var_a_sub_46_143_.anIntArray_163;
        anIntArray_155 = var_a_sub_46_143_.anIntArray_155;
        anIntArray_208 = var_a_sub_46_143_.anIntArray_208;
        modelHeight = var_a_sub_46_143_.modelHeight;
        anInt_181 = var_a_sub_46_143_.anInt_181;
        anInt_170 = var_a_sub_46_143_.anInt_170;
        anInt_172 = var_a_sub_46_143_.anInt_172;
        anInt_196 = var_a_sub_46_143_.anInt_196;
        anInt_201 = var_a_sub_46_143_.anInt_201;
        anInt_210 = var_a_sub_46_143_.anInt_210;
        anInt_149 = var_a_sub_46_143_.anInt_149;
        anInt_159 = var_a_sub_46_143_.anInt_159;
    }

    public Model(boolean bool, boolean bool_327_, boolean bool_328_,
                 Model var_a_sub_46_329_) {
        aBoolean_217 = false;
        vertexCount = var_a_sub_46_329_.vertexCount;
        modelCount = var_a_sub_46_329_.modelCount;
        anInt_186 = var_a_sub_46_329_.anInt_186;
        if (bool_328_) {
            anIntArray_205 = var_a_sub_46_329_.anIntArray_205;
            anIntArray_191 = var_a_sub_46_329_.anIntArray_191;
            anIntArray_189 = var_a_sub_46_329_.anIntArray_189;
        } else {
            anIntArray_205 = new int[vertexCount];
            anIntArray_191 = new int[vertexCount];
            anIntArray_189 = new int[vertexCount];
            int i_330_;
            int i = i_330_ = 0;
            while (i < vertexCount) {
                anIntArray_205[i_330_] = var_a_sub_46_329_.anIntArray_205[i_330_];
                anIntArray_191[i_330_] = var_a_sub_46_329_.anIntArray_191[i_330_];
                anIntArray_189[i_330_] = var_a_sub_46_329_.anIntArray_189[i_330_];
                i = ++i_330_;
            }
        }
        if (bool) {
            modelColors = var_a_sub_46_329_.modelColors;
        } else {
            modelColors = new int[modelCount];
            System.arraycopy(var_a_sub_46_329_.modelColors, 0, modelColors, 0,
                    modelCount);
        }
        if (bool_327_) {
            anIntArray_185 = var_a_sub_46_329_.anIntArray_185;
        } else {
            anIntArray_185 = new int[modelCount];
            if (var_a_sub_46_329_.anIntArray_185 == null) {
                int i_331_;
                int i = i_331_ = 0;
                while (i < modelCount) {
                    anIntArray_185[i_331_] = 0;
                    i = ++i_331_;
                }
            } else {
                System.arraycopy(var_a_sub_46_329_.anIntArray_185, 0,
                        anIntArray_185, 0, modelCount);
            }
        }
        anIntArray_178 = var_a_sub_46_329_.anIntArray_178;
        anIntArray_153 = var_a_sub_46_329_.anIntArray_153;
        anIntArray_168 = var_a_sub_46_329_.anIntArray_168;
        anIntArray_204 = var_a_sub_46_329_.anIntArray_204;
        anIntArray_146 = var_a_sub_46_329_.anIntArray_146;
        anIntArray_190 = var_a_sub_46_329_.anIntArray_190;
        anIntArray_165 = var_a_sub_46_329_.anIntArray_165;
        anInt_213 = var_a_sub_46_329_.anInt_213;
        anIntArray_163 = var_a_sub_46_329_.anIntArray_163;
        anIntArray_155 = var_a_sub_46_329_.anIntArray_155;
        anIntArray_208 = var_a_sub_46_329_.anIntArray_208;
    }

    public Model(byte[] is) {
        Buffer class_k = new Buffer(is);
        Buffer class_k_167_ = new Buffer(is);
        Buffer class_k_168_ = new Buffer(is);
        Buffer class_k_169_ = new Buffer(is);
        Buffer class_k_170_ = new Buffer(is);
        Buffer class_k_171_ = new Buffer(is);
        Buffer class_k_172_ = new Buffer(is);
        class_k.offset = is.length - 23;
        int i = class_k.readUShort3();
        int i_173_ = class_k.readUShort3();
        int i_174_ = class_k.readUByte2();
        if (modelHeaders == null) {
            resetModelHeaders(1);
        }
        ModelHeader class_i;
        (class_i = modelHeaders[0] = new ModelHeader()).aByteArray_442 = is;
        class_i.an_int_436 = i;
        class_i.an_int_440 = i_173_;
        class_i.an_int_445 = i_174_;
        int i_175_ = class_k.readUByte2();
        boolean bool = (i_175_ & 0x1) == 1;
        boolean bool_178_ = (i_175_ & 0x8) == 8;
        if (!bool_178_) {
            method66(is, 0);
        } else {
            int i_179_ = 0;
            if (bool_178_) {
                class_k.offset -= 7;
                i_179_ = class_k.readUByte2();
                class_k.offset += 6;
            }
            if (i_179_ == 15) {
                aBoolean_211 = true;
            }
            int i_180_ = class_k.readUByte2();
            int i_181_ = class_k.readUByte2();
            int i_182_ = class_k.readUByte2();
            int i_183_ = class_k.readUByte2();
            int i_184_ = class_k.readUByte2();
            int i_185_ = class_k.readUShort3();
            int i_186_ = class_k.readUShort3();
            int i_187_ = class_k.readUShort3();
            int i_188_ = class_k.readUShort3();
            int i_189_ = class_k.readUShort3();
            int i_190_ = 0;
            int i_191_ = 0;
            int i_192_ = 0;
            byte[] is_197_ = null;
            byte[] is_198_ = null;
            byte[] is_199_ = null;
            byte[] is_200_ = null;
            byte[] is_201_ = null;
            byte[] is_202_ = null;
            byte[] is_203_ = null;
            int[] is_204_ = null;
            int[] is_205_ = null;
            int[] is_206_ = null;
            short[] is_207_ = null;
            int[] is_208_ = new int[i_173_];
            if (i_174_ > 0) {
                is_198_ = new byte[i_174_];
                class_k.offset = 0;
                int i_210_;
                int i_209_ = i_210_ = 0;
                while (i_209_ < i_174_) {
                    int i_211_;
                    if ((i_211_ = is_198_[i_210_] = class_k.readByte2()) == 0) {
                        i_190_++;
                    }
                    if (i_211_ >= 1 && i_211_ <= 3) {
                        i_191_++;
                    }
                    if (i_211_ == 2) {
                        i_192_++;
                    }
                    i_209_ = ++i_210_;
                }
            }
            int i_213_;
            int i_212_ = i_213_ = i_174_;
            int i_214_ = i_213_ += i;
            if (bool) {
                i_213_ += i_173_;
            }
            if (i_175_ == 1) {
                i_213_ += i_173_;
            }
            int i_215_ = i_213_;
            int i_216_ = i_213_ += i_173_;
            if (i_180_ == 255) {
                i_213_ += i_173_;
            }
            int i_217_ = i_213_;
            if (i_182_ == 1) {
                i_213_ += i_173_;
            }
            int i_218_ = i_213_;
            if (i_184_ == 1) {
                i_213_ += i;
            }
            int i_219_ = i_213_;
            if (i_181_ == 1) {
                i_213_ += i_173_;
            }
            int i_220_ = i_213_;
            int i_221_ = i_213_ += i_188_;
            if (i_183_ == 1) {
                i_213_ += i_173_ * 2;
            }
            int i_222_ = i_213_;
            int i_223_ = i_213_ += i_189_;
            int i_224_ = i_213_ += i_173_ * 2;
            int i_225_ = i_213_ += i_185_;
            int i_226_ = i_213_ += i_186_;
            int i_227_ = i_213_ += i_187_;
            int i_228_ = i_213_ += i_190_ * 6;
            i_213_ += i_191_ * 6;
            int i_229_ = 6;
            if (i_179_ != 14) {
                if (i_179_ >= 15) {
                    i_229_ = 9;
                }
            } else {
                i_229_ = 7;
            }
            int i_230_ = i_213_;
            int i_231_ = i_213_ += i_229_ * i_191_;
            int i_232_ = i_213_ += i_191_;
            int i_233_ = i_213_ += i_191_;
            i_213_ += i_191_ + i_192_ * 2;
            int[] is_237_ = new int[i];
            int[] is_238_ = new int[i];
            int[] is_239_ = new int[i];
            int[] is_240_ = new int[i_173_];
            int[] is_241_ = new int[i_173_];
            int[] is_242_ = new int[i_173_];
            anIntArray_178 = new int[i];
            anIntArray_168 = new int[i_173_];
            anIntArray_165 = new int[i_173_];
            anIntArray_185 = new int[i_173_];
            anIntArray_153 = new int[i_173_];
            if (i_184_ == 1) {
                anIntArray_178 = new int[i];
            }
            if (bool) {
                anIntArray_168 = new int[i_173_];
            }
            if (i_180_ == 255) {
                anIntArray_165 = new int[i_173_];
            } else {
            }
            if (i_181_ == 1) {
                anIntArray_185 = new int[i_173_];
            }
            if (i_182_ == 1) {
                anIntArray_153 = new int[i_173_];
            }
            if (i_183_ == 1) {
                is_207_ = new short[i_173_];
            }
            if (i_183_ == 1 && i_174_ > 0) {
                is_197_ = new byte[i_173_];
            }
            is_208_ = new int[i_173_];
            int[] is_245_ = null;
            int[] is_246_ = null;
            int[] is_247_ = null;
            if (i_174_ > 0) {
                is_245_ = new int[i_174_];
                is_246_ = new int[i_174_];
                is_247_ = new int[i_174_];
                if (i_191_ > 0) {
                    is_204_ = new int[i_191_];
                    is_206_ = new int[i_191_];
                    is_205_ = new int[i_191_];
                    is_202_ = new byte[i_191_];
                    is_203_ = new byte[i_191_];
                    is_200_ = new byte[i_191_];
                }
                if (i_192_ > 0) {
                    is_201_ = new byte[i_192_];
                    is_199_ = new byte[i_192_];
                }
            }
            class_k.offset = i_212_;
            class_k_167_.offset = i_224_;
            class_k_168_.offset = i_225_;
            class_k_169_.offset = i_226_;
            class_k_170_.offset = i_218_;
            int i_248_ = 0;
            int i_249_ = 0;
            int i_250_ = 0;
            int i_252_;
            int i_251_ = i_252_ = 0;
            while (i_251_ < i) {
                int i_253_ = class_k.readUByte2();
                int i_254_ = 0;
                if ((i_253_ & 0x1) != 0) {
                    i_254_ = class_k_167_.readSmarts();
                }
                int i_255_ = 0;
                if ((i_253_ & 0x2) != 0) {
                    i_255_ = class_k_168_.readSmarts();
                }
                int i_256_ = 0;
                if ((i_253_ & 0x4) != 0) {
                    i_256_ = class_k_169_.readSmarts();
                }
                is_237_[i_252_] = i_248_ + i_254_;
                is_238_[i_252_] = i_249_ + i_255_;
                is_239_[i_252_] = i_250_ + i_256_;
                i_248_ = is_237_[i_252_];
                i_249_ = is_238_[i_252_];
                i_250_ = is_239_[i_252_];
                if (anIntArray_178 != null) {
                    anIntArray_178[i_252_] = class_k_170_.readUByte2();
                }
                i_251_ = ++i_252_;
            }
            class_k.offset = i_223_;
            class_k_167_.offset = i_214_;
            class_k_168_.offset = i_216_;
            class_k_169_.offset = i_219_;
            class_k_170_.offset = i_217_;
            class_k_171_.offset = i_221_;
            class_k_172_.offset = i_222_;
            int i_257_ = i_252_ = 0;
            while (i_257_ < i_173_) {
                is_208_[i_252_] = class_k.readUShort3();
                if (i_175_ == 1) {
                    anIntArray_168[i_252_] = class_k_167_.readByte2();
                    if (anIntArray_168[i_252_] == 2) {
                        is_208_[i_252_] = 65535;
                    }
                    anIntArray_168[i_252_] = 0;
                }
                if (i_180_ == 255) {
                    anIntArray_165[i_252_] = class_k_168_.readByte2();
                }
                if (i_181_ == 1) {
                    anIntArray_185[i_252_] = class_k_169_.readByte2();
                    if (anIntArray_185[i_252_] < 0) {
                        anIntArray_185[i_252_] = anIntArray_185[i_252_] + 256;
                    }
                }
                if (i_182_ == 1) {
                    anIntArray_153[i_252_] = class_k_170_.readUByte2();
                }
                if (i_183_ == 1) {
                    is_207_[i_252_] = (short) (class_k_171_.readUShort3() - 1);
                }
                if (is_197_ != null) {
                    if (is_207_[i_252_] != -1) {
                        is_197_[i_252_] = (byte) (class_k_172_.readUByte2() - 1);
                    } else {
                        is_197_[i_252_] = (byte) -1;
                    }
                }
                i_257_ = ++i_252_;
            }
            class_k.offset = i_220_;
            class_k_167_.offset = i_215_;
            i_252_ = 0;
            int i_258_ = 0;
            int i_259_ = 0;
            int i_260_ = 0;
            int i_262_;
            int i_261_ = i_262_ = 0;
            while (i_261_ < i_173_) {
                int i_263_;
                if ((i_263_ = class_k_167_.readUByte2()) == 1) {
                    i_260_ = i_252_ = class_k.readSmarts() + i_260_;
                    i_260_ = i_258_ = class_k.readSmarts() + i_260_;
                    i_260_ = i_259_ = class_k.readSmarts() + i_260_;
                    is_240_[i_262_] = i_252_;
                    is_241_[i_262_] = i_258_;
                    is_242_[i_262_] = i_259_;
                }
                if (i_263_ == 2) {
                    i_258_ = i_259_;
                    i_260_ = i_259_ = class_k.readSmarts() + i_260_;
                    is_240_[i_262_] = i_252_;
                    is_241_[i_262_] = i_258_;
                    is_242_[i_262_] = i_259_;
                }
                if (i_263_ == 3) {
                    i_252_ = i_259_;
                    i_260_ = i_259_ = class_k.readSmarts() + i_260_;
                    is_240_[i_262_] = i_252_;
                    is_241_[i_262_] = i_258_;
                    is_242_[i_262_] = i_259_;
                }
                if (i_263_ == 4) {
                    int i_264_ = i_252_;
                    i_252_ = i_258_;
                    i_258_ = i_264_;
                    i_260_ = i_259_ = class_k.readSmarts() + i_260_;
                    is_240_[i_262_] = i_252_;
                    is_241_[i_262_] = i_258_;
                    is_242_[i_262_] = i_259_;
                }
                i_261_ = ++i_262_;
            }
            class_k.offset = i_227_;
            class_k_167_.offset = i_228_;
            class_k_168_.offset = i_230_;
            class_k_169_.offset = i_231_;
            class_k_170_.offset = i_232_;
            class_k_171_.offset = i_233_;
            int i_265_ = i_262_ = 0;
            while (i_265_ < i_174_) {
                int i_266_;
                if ((i_266_ = is_198_[i_262_] & 0xff) == 0) {
                    is_245_[i_262_] = class_k.readUShort3();
                    is_246_[i_262_] = class_k.readUShort3();
                    is_247_[i_262_] = class_k.readUShort3();
                }
                if (i_266_ == 1) {
                    is_245_[i_262_] = class_k_167_.readUShort3();
                    is_246_[i_262_] = class_k_167_.readUShort3();
                    is_247_[i_262_] = class_k_167_.readUShort3();
                    if (i_179_ < 15) {
                        is_204_[i_262_] = class_k_168_.readUShort3();
                        if (i_179_ >= 14) {
                            is_206_[i_262_] = class_k_168_.readMediumInt4();
                        } else {
                            is_206_[i_262_] = class_k_168_.readUShort3();
                        }
                        is_205_[i_262_] = class_k_168_.readUShort3();
                    } else {
                        is_204_[i_262_] = class_k_168_.readMediumInt4();
                        is_206_[i_262_] = class_k_168_.readMediumInt4();
                        is_205_[i_262_] = class_k_168_.readMediumInt4();
                    }
                    is_202_[i_262_] = class_k_169_.readByte2();
                    is_203_[i_262_] = class_k_170_.readByte2();
                    is_200_[i_262_] = class_k_171_.readByte2();
                }
                if (i_266_ == 2) {
                    is_245_[i_262_] = class_k_167_.readUShort3();
                    is_246_[i_262_] = class_k_167_.readUShort3();
                    is_247_[i_262_] = class_k_167_.readUShort3();
                    if (i_179_ >= 15) {
                        is_204_[i_262_] = class_k_168_.readMediumInt4();
                        is_206_[i_262_] = class_k_168_.readMediumInt4();
                        is_205_[i_262_] = class_k_168_.readMediumInt4();
                    } else {
                        is_204_[i_262_] = class_k_168_.readUShort3();
                        if (i_179_ < 14) {
                            is_206_[i_262_] = class_k_168_.readUShort3();
                        } else {
                            is_206_[i_262_] = class_k_168_.readMediumInt4();
                        }
                        is_205_[i_262_] = class_k_168_.readUShort3();
                    }
                    is_202_[i_262_] = class_k_169_.readByte2();
                    is_203_[i_262_] = class_k_170_.readByte2();
                    is_200_[i_262_] = class_k_171_.readByte2();
                    is_201_[i_262_] = class_k_171_.readByte2();
                    is_199_[i_262_] = class_k_171_.readByte2();
                }
                if (i_266_ == 3) {
                    is_245_[i_262_] = class_k_167_.readUShort3();
                    is_246_[i_262_] = class_k_167_.readUShort3();
                    is_247_[i_262_] = class_k_167_.readUShort3();
                    if (i_179_ < 15) {
                        is_204_[i_262_] = class_k_168_.readUShort3();
                        if (i_179_ < 14) {
                            is_206_[i_262_] = class_k_168_.readUShort3();
                        } else {
                            is_206_[i_262_] = class_k_168_.readMediumInt4();
                        }
                        is_205_[i_262_] = class_k_168_.readUShort3();
                    } else {
                        is_204_[i_262_] = class_k_168_.readMediumInt4();
                        is_206_[i_262_] = class_k_168_.readMediumInt4();
                        is_205_[i_262_] = class_k_168_.readMediumInt4();
                    }
                    is_202_[i_262_] = class_k_169_.readByte2();
                    is_203_[i_262_] = class_k_170_.readByte2();
                    is_200_[i_262_] = class_k_171_.readByte2();
                }
                i_265_ = ++i_262_;
            }
            if (i_180_ != 255) {
                int i_267_ = i_262_ = 0;
                while (i_267_ < i_173_) {
                    anIntArray_165[i_262_] = i_180_;
                    i_267_ = ++i_262_;
                }
            }
            modelColors = is_208_;
            vertexCount = i;
            modelCount = i_173_;
            anIntArray_205 = is_237_;
            anIntArray_191 = is_238_;
            anIntArray_189 = is_239_;
            anIntArray_204 = is_240_;
            anIntArray_146 = is_241_;
            anIntArray_190 = is_242_;
            if (anIntArray_165 != null) {
                int i_268_ = i_262_ = 0;
                while (i_268_ < anIntArray_165.length) {
                    anIntArray_165[i_262_] = 10;
                    i_268_ = ++i_262_;
                }
            }
            if (vertexCount > 4096) {
                System.out
                        .println("Too many vertices for this poor 317 rendering engine.");
            }
        }
    }

    private Model(int i) {
        aBoolean_217 = false;
        ModelHeader class_i = modelHeaders[i];
        vertexCount = class_i.an_int_436;
        modelCount = class_i.an_int_440;
        anInt_186 = class_i.an_int_445;
        anIntArray_205 = new int[vertexCount];
        anIntArray_191 = new int[vertexCount];
        anIntArray_189 = new int[vertexCount];
        anIntArray_204 = new int[modelCount];
        anIntArray_146 = new int[modelCount];
        anIntArray_190 = new int[modelCount];
        anIntArray_163 = new int[anInt_186];
        anIntArray_155 = new int[anInt_186];
        anIntArray_208 = new int[anInt_186];
        if (class_i.an_int_451 >= 0) {
            anIntArray_178 = new int[vertexCount];
        }
        if (class_i.an_int_438 >= 0) {
            anIntArray_168 = new int[modelCount];
        }
        if (class_i.an_int_446 >= 0) {
            anIntArray_165 = new int[modelCount];
        } else {
            anInt_213 = -class_i.an_int_446 - 1;
        }
        if (class_i.an_int_447 >= 0) {
            anIntArray_185 = new int[modelCount];
        }
        if (class_i.an_int_449 >= 0) {
            anIntArray_153 = new int[modelCount];
        }
        modelColors = new int[modelCount];
        Buffer class_k;
        (class_k = new Buffer(class_i.aByteArray_442)).offset = class_i.an_int_444;
        Buffer class_k_549_;
        (class_k_549_ = new Buffer(class_i.aByteArray_442)).offset = class_i.an_int_439;
        Buffer class_k_550_;
        (class_k_550_ = new Buffer(class_i.aByteArray_442)).offset = class_i.an_int_441;
        Buffer class_k_551_;
        (class_k_551_ = new Buffer(class_i.aByteArray_442)).offset = class_i.an_int_448;
        Buffer class_k_552_;
        (class_k_552_ = new Buffer(class_i.aByteArray_442)).offset = class_i.an_int_451;
        int i_553_ = 0;
        int i_554_ = 0;
        int i_555_ = 0;
        int i_557_;
        int i_556_ = i_557_ = 0;
        while (i_556_ < vertexCount) {
            int i_558_ = class_k.readUByte2();
            int i_559_ = 0;
            if ((i_558_ & 0x1) != 0) {
                i_559_ = class_k_549_.readSmarts();
            }
            int i_560_ = 0;
            if ((i_558_ & 0x2) != 0) {
                i_560_ = class_k_550_.readSmarts();
            }
            int i_561_ = 0;
            if ((i_558_ & 0x4) != 0) {
                i_561_ = class_k_551_.readSmarts();
            }
            anIntArray_205[i_557_] = i_553_ + i_559_;
            anIntArray_191[i_557_] = i_554_ + i_560_;
            anIntArray_189[i_557_] = i_555_ + i_561_;
            i_553_ = anIntArray_205[i_557_];
            i_554_ = anIntArray_191[i_557_];
            i_555_ = anIntArray_189[i_557_];
            if (anIntArray_178 != null) {
                anIntArray_178[i_557_] = class_k_552_.readUByte2();
            }
            i_556_ = ++i_557_;
        }
        class_k.offset = class_i.an_int_443;
        class_k_549_.offset = class_i.an_int_438;
        class_k_550_.offset = class_i.an_int_446;
        class_k_551_.offset = class_i.an_int_447;
        class_k_552_.offset = class_i.an_int_449;
        int i_562_ = i_557_ = 0;
        while (i_562_ < modelCount) {
            modelColors[i_557_] = class_k.readUShort4();
            if (anIntArray_168 != null) {
                anIntArray_168[i_557_] = class_k_549_.readUByte2();
            }
            if (anIntArray_165 != null) {
                anIntArray_165[i_557_] = class_k_550_.readUByte2();
            }
            if (anIntArray_185 != null) {
                anIntArray_185[i_557_] = class_k_551_.readUByte2();
            }
            if (anIntArray_153 != null) {
                anIntArray_153[i_557_] = class_k_552_.readUByte2();
            }
            i_562_ = ++i_557_;
        }
        class_k.offset = class_i.an_int_437;
        class_k_549_.offset = class_i.an_int_450;
        i_557_ = 0;
        int i_563_ = 0;
        int i_564_ = 0;
        int i_565_ = 0;
        int i_567_;
        int i_566_ = i_567_ = 0;
        while (i_566_ < modelCount) {
            int i_568_;
            if ((i_568_ = class_k_549_.readUByte2()) == 1) {
                i_565_ = i_557_ = class_k.readSmarts() + i_565_;
                i_565_ = i_563_ = class_k.readSmarts() + i_565_;
                i_565_ = i_564_ = class_k.readSmarts() + i_565_;
                anIntArray_204[i_567_] = i_557_;
                anIntArray_146[i_567_] = i_563_;
                anIntArray_190[i_567_] = i_564_;
            }
            if (i_568_ == 2) {
                i_563_ = i_564_;
                i_565_ = i_564_ = class_k.readSmarts() + i_565_;
                anIntArray_204[i_567_] = i_557_;
                anIntArray_146[i_567_] = i_563_;
                anIntArray_190[i_567_] = i_564_;
            }
            if (i_568_ == 3) {
                i_557_ = i_564_;
                i_565_ = i_564_ = class_k.readSmarts() + i_565_;
                anIntArray_204[i_567_] = i_557_;
                anIntArray_146[i_567_] = i_563_;
                anIntArray_190[i_567_] = i_564_;
            }
            if (i_568_ == 4) {
                int i_569_ = i_557_;
                i_557_ = i_563_;
                i_563_ = i_569_;
                i_565_ = i_564_ = class_k.readSmarts() + i_565_;
                anIntArray_204[i_567_] = i_557_;
                anIntArray_146[i_567_] = i_563_;
                anIntArray_190[i_567_] = i_564_;
            }
            i_566_ = ++i_567_;
        }
        class_k.offset = class_i.an_int_452;
        int i_570_ = i_567_ = 0;
        while (i_570_ < anInt_186) {
            anIntArray_163[i_567_] = class_k.readUShort4();
            anIntArray_155[i_567_] = class_k.readUShort4();
            anIntArray_208[i_567_] = class_k.readUShort4();
            i_570_ = ++i_567_;
        }
    }

    public Model(int i, Model[] var_a_sub_46s) {
        aBoolean_217 = false;
        boolean bool = false;
        boolean bool_148_ = false;
        boolean bool_149_ = false;
        boolean bool_150_ = false;
        vertexCount = 0;
        modelCount = 0;
        anInt_186 = 0;
        anInt_213 = -1;
        int i_152_;
        int i_151_ = i_152_ = 0;
        while (i_151_ < i) {
            Model var_a_sub_46_153_;
            if ((var_a_sub_46_153_ = var_a_sub_46s[i_152_]) != null) {
                vertexCount += var_a_sub_46_153_.vertexCount;
                modelCount += var_a_sub_46_153_.modelCount;
                anInt_186 += var_a_sub_46_153_.anInt_186;
                bool = bool | var_a_sub_46_153_.anIntArray_168 != null;
                if (var_a_sub_46_153_.anIntArray_165 != null) {
                    bool_148_ = true;
                } else {
                    if (anInt_213 == -1) {
                        anInt_213 = var_a_sub_46_153_.anInt_213;
                    }
                    if (anInt_213 != var_a_sub_46_153_.anInt_213) {
                        bool_148_ = true;
                    }
                }
                bool_149_ = bool_149_
                        | var_a_sub_46_153_.anIntArray_185 != null;
                bool_150_ = bool_150_
                        | var_a_sub_46_153_.anIntArray_153 != null;
            }
            i_151_ = ++i_152_;
        }
        anIntArray_205 = new int[vertexCount];
        anIntArray_191 = new int[vertexCount];
        anIntArray_189 = new int[vertexCount];
        anIntArray_178 = new int[vertexCount];
        anIntArray_204 = new int[modelCount];
        anIntArray_146 = new int[modelCount];
        anIntArray_190 = new int[modelCount];
        anIntArray_163 = new int[anInt_186];
        anIntArray_155 = new int[anInt_186];
        anIntArray_208 = new int[anInt_186];
        if (bool) {
            anIntArray_168 = new int[modelCount];
        }
        if (bool_148_) {
            anIntArray_165 = new int[modelCount];
        }
        if (bool_149_) {
            anIntArray_185 = new int[modelCount];
        }
        if (bool_150_) {
            anIntArray_153 = new int[modelCount];
        }
        modelColors = new int[modelCount];
        vertexCount = 0;
        modelCount = 0;
        anInt_186 = 0;
        i_152_ = 0;
        int i_155_;
        int i_154_ = i_155_ = 0;
        while (i_154_ < i) {
            Model var_a_sub_46_156_;
            if ((var_a_sub_46_156_ = var_a_sub_46s[i_155_]) != null) {
                int i_158_;
                int i_157_ = i_158_ = 0;
                while (i_157_ < var_a_sub_46_156_.modelCount) {
                    if (bool) {
                        if (var_a_sub_46_156_.anIntArray_168 == null) {
                            anIntArray_168[modelCount] = 0;
                        } else {
                            int i_159_;
                            if (((i_159_ = var_a_sub_46_156_.anIntArray_168[i_158_]) & 0x2) == 2) {
                                i_159_ += i_152_ << 2;
                            }
                            anIntArray_168[modelCount] = i_159_;
                        }
                    }
                    if (bool_148_) {
                        if (var_a_sub_46_156_.anIntArray_165 == null) {
                            anIntArray_165[modelCount] = var_a_sub_46_156_.anInt_213;
                        } else {
                            anIntArray_165[modelCount] = var_a_sub_46_156_.anIntArray_165[i_158_];
                        }
                    }
                    if (bool_149_) {
                        if (var_a_sub_46_156_.anIntArray_185 == null) {
                            anIntArray_185[modelCount] = 0;
                        } else {
                            anIntArray_185[modelCount] = var_a_sub_46_156_.anIntArray_185[i_158_];
                        }
                    }
                    if (bool_150_ && var_a_sub_46_156_.anIntArray_153 != null) {
                        anIntArray_153[modelCount] = var_a_sub_46_156_.anIntArray_153[i_158_];
                    }
                    modelColors[modelCount] = var_a_sub_46_156_.modelColors[i_158_];
                    anIntArray_204[modelCount] = int_method72(
                            var_a_sub_46_156_,
                            var_a_sub_46_156_.anIntArray_204[i_158_]);
                    anIntArray_146[modelCount] = int_method72(
                            var_a_sub_46_156_,
                            var_a_sub_46_156_.anIntArray_146[i_158_]);
                    anIntArray_190[modelCount] = int_method72(
                            var_a_sub_46_156_,
                            var_a_sub_46_156_.anIntArray_190[i_158_]);
                    modelCount++;
                    i_157_ = ++i_158_;
                }
                int i_160_ = i_158_ = 0;
                while (i_160_ < var_a_sub_46_156_.anInt_186) {
                    anIntArray_163[anInt_186] = int_method72(var_a_sub_46_156_,
                            var_a_sub_46_156_.anIntArray_163[i_158_]);
                    anIntArray_155[anInt_186] = int_method72(var_a_sub_46_156_,
                            var_a_sub_46_156_.anIntArray_155[i_158_]);
                    anIntArray_208[anInt_186] = int_method72(var_a_sub_46_156_,
                            var_a_sub_46_156_.anIntArray_208[i_158_]);
                    anInt_186++;
                    i_160_ = ++i_158_;
                }
                i_152_ += var_a_sub_46_156_.anInt_186;
            }
            i_154_ = ++i_155_;
        }
    }

    private boolean boolean_method76(int i, int i_364_, int i_365_, int i_366_,
                                     int i_367_, int i_368_, int i_369_, int i_370_) {
        if (i_364_ < i_365_ && i_364_ < i_366_ && i_364_ < i_367_) {
            return false;
        }
        if (i_364_ > i_365_ && i_364_ > i_366_ && i_364_ > i_367_) {
            return false;
        }
        return (i >= i_368_ || i >= i_369_ || i >= i_370_)
                && (i <= i_368_ || i <= i_369_ || i <= i_370_);
    }

    private int int_method72(Model var_a_sub_46_272_, int i) {
        int i_273_ = -1;
        int i_274_ = var_a_sub_46_272_.anIntArray_205[i];
        int i_275_ = var_a_sub_46_272_.anIntArray_191[i];
        int i_276_ = var_a_sub_46_272_.anIntArray_189[i];
        for (int i_277_ = 0; i_277_ < vertexCount; i_277_++) {
            if (i_274_ == anIntArray_205[i_277_]
                    && i_275_ == anIntArray_191[i_277_]
                    && i_276_ == anIntArray_189[i_277_]) {
                i_273_ = i_277_;
                break;
            }
        }
        if (i_273_ == -1) {
            anIntArray_205[vertexCount] = i_274_;
            anIntArray_191[vertexCount] = i_275_;
            anIntArray_189[vertexCount] = i_276_;
            if (var_a_sub_46_272_.anIntArray_178 != null) {
                anIntArray_178[vertexCount] = var_a_sub_46_272_.anIntArray_178[i];
            }
            i_273_ = vertexCount++;
        }
        return i_273_;
    }

    public void void_method38() {
        modelHeight = 0;
        anInt_170 = 0;
        anInt_181 = 0;
        int i_593_;
        int i = i_593_ = 0;
        while (i < vertexCount) {
            int i_594_ = anIntArray_205[i_593_];
            int i_595_ = anIntArray_191[i_593_];
            int i_596_ = anIntArray_189[i_593_];
            if (-i_595_ > modelHeight) {
                modelHeight = -i_595_;
            }
            if (i_595_ > anInt_181) {
                anInt_181 = i_595_;
            }
            int i_597_;
            if ((i_597_ = i_594_ * i_594_ + i_596_ * i_596_) > anInt_170) {
                anInt_170 = i_597_;
            }
            i = ++i_593_;
        }
        anInt_170 = (int) (Math.sqrt((double) anInt_170) + 0.99);
        anInt_172 = (int) (Math
                .sqrt((double) (anInt_170 * anInt_170 + modelHeight
                        * modelHeight)) + 0.99);
        anInt_196 = anInt_172
                + (int) (Math.sqrt((double) (anInt_170 * anInt_170 + anInt_181
                * anInt_181)) + 0.99);
    }

    public void recolor(int oldColor, int newColor) {
        int color;
        int i_162_ = color = 0;
        while (i_162_ < modelCount) {
            if (modelColors[color] == oldColor) {
                modelColors[color] = newColor;
            }
            i_162_ = ++color;
        }
    }

    public void render(int i, int i_371_, int i_372_, int i_373_, int i_374_,
                       int i_375_, int i_376_, int i_377_, int i_378_) {
        int i_379_ = i_377_ * i_374_ - i_375_ * i_373_ >> 16;
        int i_380_ = i_376_ * i_371_ + i_379_ * i_372_ >> 16;
        int i_381_ = anInt_170 * i_372_ >> 16;
        int i_382_;
        int i_383_;
        int i_384_;
        int i_385_;
        if ((i_382_ = i_380_ + i_381_) > 50
                && i_380_ < 3500
                && (i_383_ = (i_384_ = i_377_ * i_373_ + i_375_ * i_374_ >> 16)
                - anInt_170 << 9)
                / i_382_ < Rasterizer.anInt_430
                && (i_385_ = i_384_ + anInt_170 << 9) / i_382_ > -Rasterizer.anInt_430) {
            int i_386_ = i_376_ * i_372_ - i_379_ * i_371_ >> 16;
            int i_387_ = anInt_170 * i_371_ >> 16;
            int i_388_;
            if ((i_388_ = i_386_ + i_387_ << 9) / i_382_ > -Rasterizer.anInt_432) {
                int i_389_ = i_387_ + (modelHeight * i_372_ >> 16);
                int i_390_;
                if ((i_390_ = i_386_ - i_389_ << 9) / i_382_ < Rasterizer.anInt_432) {
                    int i_391_ = i_381_ + (modelHeight * i_371_ >> 16);
                    boolean bool = false;
                    if (i_380_ - i_391_ <= 50) {
                        bool = true;
                    }
                    boolean bool_392_ = false;
                    if (i_378_ > 0 && aBoolean_212) {
                        int i_393_;
                        if ((i_393_ = i_380_ - i_381_) <= 50) {
                            i_393_ = 50;
                        }
                        if (i_384_ > 0) {
                            i_383_ /= i_382_;
                            i_385_ /= i_393_;
                        } else {
                            i_385_ /= i_382_;
                            i_383_ /= i_393_;
                        }
                        if (i_386_ > 0) {
                            i_390_ /= i_382_;
                            i_388_ /= i_393_;
                        } else {
                            i_388_ /= i_382_;
                            i_390_ /= i_393_;
                        }
                        int i_394_ = anInt_162 - Rasterizer3D.anInt_132;
                        int i_395_ = anInt_176 - Rasterizer3D.anInt_135;
                        if (i_394_ > i_383_ && i_394_ < i_385_
                                && i_395_ > i_390_ && i_395_ < i_388_) {
                            if (aBoolean_217) {
                                anIntArray_206[anInt_184++] = i_378_;
                            } else {
                                bool_392_ = true;
                            }
                        }
                    }
                    int i_396_ = Rasterizer3D.anInt_132;
                    int i_397_ = Rasterizer3D.anInt_135;
                    int i_398_ = 0;
                    int i_399_ = 0;
                    if (i != 0) {
                        i_398_ = anIntArray_150[i];
                        i_399_ = anIntArray_164[i];
                    }
                    int i_401_;
                    int i_400_ = i_401_ = 0;
                    while (i_400_ < vertexCount) {
                        int i_402_ = anIntArray_205[i_401_];
                        int i_403_ = anIntArray_191[i_401_];
                        int i_404_ = anIntArray_189[i_401_];
                        if (i != 0) {
                            int i_405_ = i_404_ * i_398_ + i_402_ * i_399_ >> 16;
                            i_404_ = i_404_ * i_399_ - i_402_ * i_398_ >> 16;
                            i_402_ = i_405_;
                        }
                        i_402_ += i_375_;
                        i_403_ += i_376_;
                        int i_406_ = (i_404_ += i_377_) * i_373_ + i_402_
                                * i_374_ >> 16;
                        i_404_ = i_404_ * i_374_ - i_402_ * i_373_ >> 16;
                        i_402_ = i_406_;
                        i_406_ = i_403_ * i_372_ - i_404_ * i_371_ >> 16;
                        i_404_ = i_403_ * i_371_ + i_404_ * i_372_ >> 16;
                        i_403_ = i_406_;
                        anIntArray_207[i_401_] = i_404_ - i_380_;
                        if (i_404_ >= 50) {
                            anIntArray_148[i_401_] = i_396_ + (i_402_ << 9)
                                    / i_404_;
                            anIntArray_199[i_401_] = i_397_ + (i_403_ << 9)
                                    / i_404_;
                        } else {
                            anIntArray_148[i_401_] = -5000;
                            bool = true;
                        }
                        if (bool || anInt_186 > 0) {
                            anIntArray_188[i_401_] = i_402_;
                            anIntArray_160[i_401_] = i_403_;
                            anIntArray_195[i_401_] = i_404_;
                        }
                        i_400_ = ++i_401_;
                    }
                    try {
                        method68(bool, bool_392_, i_378_);
                    } catch (Exception exception) {
                        /* empty */
                    }
                }
            }
        }
    }

    public void method60(int i, int i_452_, int i_453_, int i_454_, int i_455_,
                         int i_456_, int i_457_) {
        int i_458_ = Rasterizer3D.anInt_132;
        int i_459_ = Rasterizer3D.anInt_135;
        int i_460_ = anIntArray_150[i];
        int i_461_ = anIntArray_164[i];
        int i_462_ = anIntArray_150[i_452_];
        int i_463_ = anIntArray_164[i_452_];
        int i_464_ = anIntArray_150[i_453_];
        int i_465_ = anIntArray_164[i_453_];
        int i_466_ = anIntArray_150[i_454_];
        int i_467_ = anIntArray_164[i_454_];
        int i_468_ = i_456_ * i_466_ + i_457_ * i_467_ >> 16;
        int i_469_ = vertexCount > 4096 ? 4096 : vertexCount;
        int i_471_;
        int i_470_ = i_471_ = 0;
        while (i_470_ < i_469_) {
            int i_472_ = anIntArray_205[i_471_];
            int i_473_ = anIntArray_191[i_471_];
            int i_474_ = anIntArray_189[i_471_];
            if (i_453_ != 0) {
                int i_475_ = i_473_ * i_464_ + i_472_ * i_465_ >> 16;
                i_473_ = i_473_ * i_465_ - i_472_ * i_464_ >> 16;
                i_472_ = i_475_;
            }
            if (i != 0) {
                int i_476_ = i_473_ * i_461_ - i_474_ * i_460_ >> 16;
                i_474_ = i_473_ * i_460_ + i_474_ * i_461_ >> 16;
                i_473_ = i_476_;
            }
            if (i_452_ != 0) {
                int i_477_ = i_474_ * i_462_ + i_472_ * i_463_ >> 16;
                i_474_ = i_474_ * i_463_ - i_472_ * i_462_ >> 16;
                i_472_ = i_477_;
            }
            i_472_ += i_455_;
            i_473_ += i_456_;
            i_474_ += i_457_;
            int i_478_ = i_473_ * i_467_ - i_474_ * i_466_ >> 16;
            i_474_ = i_473_ * i_466_ + i_474_ * i_467_ >> 16;
            i_473_ = i_478_;
            anIntArray_207[i_471_] = i_474_ - i_468_;
            anIntArray_148[i_471_] = i_458_ + (i_472_ << 9) / i_474_;
            anIntArray_199[i_471_] = i_459_ + (i_473_ << 9) / i_474_;
            if (anInt_186 > 0) {
                anIntArray_188[i_471_] = i_472_;
                anIntArray_160[i_471_] = i_473_;
                anIntArray_195[i_471_] = i_474_;
            }
            i_470_ = ++i_471_;
        }
        try {
            method68(false, false, 0);
        } catch (Exception exception) {
            /* empty */
        }
    }

    public void createBones() {
        if (anIntArray_178 != null) {
            int[] is = new int[256];
            int i = 0;
            int i_333_;
            int i_332_ = i_333_ = 0;
            while (i_332_ < vertexCount) {
                int i_334_ = anIntArray_178[i_333_];
                is[i_334_]++;
                if (i_334_ > i) {
                    i = i_334_;
                }
                i_332_ = ++i_333_;
            }
            anIntArrayArray_209 = new int[i + 1][];
            int i_335_ = i_333_ = 0;
            while (i_335_ <= i) {
                anIntArrayArray_209[i_333_] = new int[is[i_333_]];
                is[i_333_] = 0;
                i_335_ = ++i_333_;
            }
            int i_336_ = i_333_ = 0;
            while (i_336_ < vertexCount) {
                int i_337_ = anIntArray_178[i_333_];
                anIntArrayArray_209[i_337_][is[i_337_]++] = i_333_;
                i_336_ = ++i_333_;
            }
            anIntArray_178 = null;
        }
        if (anIntArray_153 != null) {
            int[] is = new int[256];
            int i = 0;
            int i_339_;
            int i_338_ = i_339_ = 0;
            while (i_338_ < modelCount) {
                int i_340_ = anIntArray_153[i_339_];
                is[i_340_]++;
                if (i_340_ > i) {
                    i = i_340_;
                }
                i_338_ = ++i_339_;
            }
            anIntArrayArray_173 = new int[i + 1][];
            int i_341_ = i_339_ = 0;
            while (i_341_ <= i) {
                anIntArrayArray_173[i_339_] = new int[is[i_339_]];
                is[i_339_] = 0;
                i_341_ = ++i_339_;
            }
            int i_342_ = i_339_ = 0;
            while (i_342_ < modelCount) {
                int i_343_ = anIntArray_153[i_339_];
                anIntArrayArray_173[i_343_][is[i_343_]++] = i_339_;
                i_342_ = ++i_339_;
            }
            anIntArray_153 = null;
        }
    }

    private void void_method64() {
        modelHeight = 0;
        anInt_170 = 0;
        anInt_181 = 0;
        anInt_201 = 999999;
        anInt_159 = -999999;
        anInt_210 = -99999;
        anInt_149 = 99999;
        int i_479_;
        int i = i_479_ = 0;
        while (i < vertexCount) {
            int i_480_ = anIntArray_205[i_479_];
            int i_481_ = anIntArray_191[i_479_];
            int i_482_ = anIntArray_189[i_479_];
            if (i_480_ < anInt_201) {
                anInt_201 = i_480_;
            }
            if (i_480_ > anInt_159) {
                anInt_159 = i_480_;
            }
            if (i_482_ < anInt_149) {
                anInt_149 = i_482_;
            }
            if (i_482_ > anInt_210) {
                anInt_210 = i_482_;
            }
            if (-i_481_ > modelHeight) {
                modelHeight = -i_481_;
            }
            if (i_481_ > anInt_181) {
                anInt_181 = i_481_;
            }
            int i_483_;
            if ((i_483_ = i_480_ * i_480_ + i_482_ * i_482_) > anInt_170) {
                anInt_170 = i_483_;
            }
            i = ++i_479_;
        }
        anInt_170 = (int) Math.sqrt((double) anInt_170);
        anInt_172 = (int) Math
                .sqrt((double) (anInt_170 * anInt_170 + modelHeight
                        * modelHeight));
        anInt_196 = anInt_172
                + (int) Math.sqrt((double) (anInt_170 * anInt_170 + anInt_181
                * anInt_181));
    }

    public void rotate90Degrees() {
        int i_545_;
        int i = i_545_ = 0;
        while (i < vertexCount) {
            int i_546_ = anIntArray_205[i_545_];
            anIntArray_205[i_545_] = anIntArray_189[i_545_];
            anIntArray_189[i_545_] = -i_546_;
            i = ++i_545_;
        }
    }

    public void method66(byte[] data, int i) {
        Buffer buffer = new Buffer(data);
        Buffer buffer_1 = new Buffer(data);
        Buffer buffer_2 = new Buffer(data);
        Buffer buffer_3 = new Buffer(data);
        Buffer buffer_4 = new Buffer(data);
        Buffer buffer_5 = new Buffer(data);
        Buffer buffer_6 = new Buffer(data);
        buffer.offset = data.length - 23;
        int i_6_ = buffer.readUShort3();
        int i_7_ = buffer.readUShort3();
        int i_8_ = buffer.readUByte2();
        ModelHeader header;
        (header = modelHeaders[0] = new ModelHeader()).aByteArray_442 = data;
        header.an_int_436 = i_6_;
        header.an_int_440 = i_7_;
        header.an_int_445 = i_8_;
        int i_9_ = buffer.readUByte2();
        boolean bool = (i_9_ & 0x1) == 1;
        int i_11_ = buffer.readUByte2();
        int i_12_ = buffer.readUByte2();
        int i_13_ = buffer.readUByte2();
        int i_14_ = buffer.readUByte2();
        int i_15_ = buffer.readUByte2();
        int i_16_ = buffer.readUShort3();
        int i_17_ = buffer.readUShort3();
        int i_18_ = buffer.readUShort3();
        int i_19_ = buffer.readUShort3();
        int i_20_ = buffer.readUShort3();
        int i_21_ = 0;
        int i_22_ = 0;
        int i_23_ = 0;
        byte[] is_28_ = null;
        byte[] is_29_ = null;
        byte[] is_30_ = null;
        byte[] is_31_ = null;
        byte[] is_32_ = null;
        byte[] is_33_ = null;
        byte[] is_34_ = null;
        int[] is_35_ = null;
        int[] is_36_ = null;
        int[] is_37_ = null;
        short[] is_38_ = null;
        int[] is_39_ = new int[i_7_];
        if (i_8_ > 0) {
            is_29_ = new byte[i_8_];
            buffer.offset = 0;
            int i_41_;
            int i_40_ = i_41_ = 0;
            while (i_40_ < i_8_) {
                int i_42_;
                if ((i_42_ = is_29_[i_41_] = buffer.readByte2()) == 0) {
                    i_21_++;
                }
                if (i_42_ >= 1 && i_42_ <= 3) {
                    i_22_++;
                }
                if (i_42_ == 2) {
                    i_23_++;
                }
                i_40_ = ++i_41_;
            }
        }
        int i_44_;
        int i_43_ = i_44_ = i_8_;
        int i_45_ = i_44_ += i_6_;
        if (i_9_ == 1) {
            i_44_ += i_7_;
        }
        int i_46_ = i_44_;
        int i_47_ = i_44_ += i_7_;
        if (i_11_ == 255) {
            i_44_ += i_7_;
        }
        int i_48_ = i_44_;
        if (i_13_ == 1) {
            i_44_ += i_7_;
        }
        int i_49_ = i_44_;
        if (i_15_ == 1) {
            i_44_ += i_6_;
        }
        int i_50_ = i_44_;
        if (i_12_ == 1) {
            i_44_ += i_7_;
        }
        int i_51_ = i_44_;
        int i_52_ = i_44_ += i_19_;
        if (i_14_ == 1) {
            i_44_ += i_7_ * 2;
        }
        int i_53_ = i_44_;
        int i_54_ = i_44_ += i_20_;
        int i_55_ = i_44_ += i_7_ * 2;
        int i_56_ = i_44_ += i_16_;
        int i_57_ = i_44_ += i_17_;
        int i_58_ = i_44_ += i_18_;
        int i_59_ = i_44_ += i_21_ * 6;
        int i_60_ = i_44_ += i_22_ * 6;
        int i_61_ = i_44_ += i_22_ * 6;
        int i_62_ = i_44_ += i_22_;
        int i_63_ = i_44_ += i_22_;
        i_44_ += i_22_ + i_23_ * 2;
        int[] is_67_ = new int[i_6_];
        int[] is_68_ = new int[i_6_];
        int[] is_69_ = new int[i_6_];
        int[] is_70_ = new int[i_7_];
        int[] is_71_ = new int[i_7_];
        int[] is_72_ = new int[i_7_];
        anIntArray_178 = new int[i_6_];
        anIntArray_168 = new int[i_7_];
        anIntArray_165 = new int[i_7_];
        anIntArray_185 = new int[i_7_];
        anIntArray_153 = new int[i_7_];
        if (i_15_ == 1) {
            anIntArray_178 = new int[i_6_];
        }
        if (bool) {
            anIntArray_168 = new int[i_7_];
        }
        if (i_11_ == 255) {
            anIntArray_165 = new int[i_7_];
        } else {
        }
        if (i_12_ == 1) {
            anIntArray_185 = new int[i_7_];
        }
        if (i_13_ == 1) {
            anIntArray_153 = new int[i_7_];
        }
        if (i_14_ == 1) {
            is_38_ = new short[i_7_];
        }
        if (i_14_ == 1 && i_8_ > 0) {
            is_28_ = new byte[i_7_];
        }
        is_39_ = new int[i_7_];
        int[] is_75_ = null;
        int[] is_76_ = null;
        int[] is_77_ = null;
        if (i_8_ > 0) {
            is_75_ = new int[i_8_];
            is_76_ = new int[i_8_];
            is_77_ = new int[i_8_];
            if (i_22_ > 0) {
                is_35_ = new int[i_22_];
                is_37_ = new int[i_22_];
                is_36_ = new int[i_22_];
                is_33_ = new byte[i_22_];
                is_34_ = new byte[i_22_];
                is_31_ = new byte[i_22_];
            }
            if (i_23_ > 0) {
                is_32_ = new byte[i_23_];
                is_30_ = new byte[i_23_];
            }
        }
        buffer.offset = i_43_;
        buffer_1.offset = i_55_;
        buffer_2.offset = i_56_;
        buffer_3.offset = i_57_;
        buffer_4.offset = i_49_;
        int i_78_ = 0;
        int i_79_ = 0;
        int i_80_ = 0;
        int i_82_;
        int i_81_ = i_82_ = 0;
        while (i_81_ < i_6_) {
            int i_83_ = buffer.readUByte2();
            int i_84_ = 0;
            if ((i_83_ & 0x1) != 0) {
                i_84_ = buffer_1.readSmarts();
            }
            int i_85_ = 0;
            if ((i_83_ & 0x2) != 0) {
                i_85_ = buffer_2.readSmarts();
            }
            int i_86_ = 0;
            if ((i_83_ & 0x4) != 0) {
                i_86_ = buffer_3.readSmarts();
            }
            is_67_[i_82_] = i_78_ + i_84_;
            is_68_[i_82_] = i_79_ + i_85_;
            is_69_[i_82_] = i_80_ + i_86_;
            i_78_ = is_67_[i_82_];
            i_79_ = is_68_[i_82_];
            i_80_ = is_69_[i_82_];
            if (anIntArray_178 != null) {
                anIntArray_178[i_82_] = buffer_4.readUByte2();
            }
            i_81_ = ++i_82_;
        }
        buffer.offset = i_54_;
        buffer_1.offset = i_45_;
        buffer_2.offset = i_47_;
        buffer_3.offset = i_50_;
        buffer_4.offset = i_48_;
        buffer_5.offset = i_52_;
        buffer_6.offset = i_53_;
        int i_87_ = i_82_ = 0;
        while (i_87_ < i_7_) {
            is_39_[i_82_] = buffer.readUShort3();
            if (i_9_ == 1) {
                anIntArray_168[i_82_] = buffer_1.readByte2();
                if (anIntArray_168[i_82_] == 2) {
                    is_39_[i_82_] = 65535;
                }
                anIntArray_168[i_82_] = 0;
            }
            if (i_11_ == 255) {
                anIntArray_165[i_82_] = buffer_2.readByte2();
            }
            if (i_12_ == 1) {
                anIntArray_185[i_82_] = buffer_3.readByte2();
                if (anIntArray_185[i_82_] < 0) {
                    anIntArray_185[i_82_] = anIntArray_185[i_82_] + 256;
                }
            }
            if (i_13_ == 1) {
                anIntArray_153[i_82_] = buffer_4.readUByte2();
            }
            if (i_14_ == 1) {
                is_38_[i_82_] = (short) (buffer_5.readUShort3() - 1);
            }
            if (is_28_ != null) {
                if (is_38_[i_82_] != -1) {
                    is_28_[i_82_] = (byte) (buffer_6.readUByte2() - 1);
                } else {
                    is_28_[i_82_] = (byte) -1;
                }
            }
            i_87_ = ++i_82_;
        }
        buffer.offset = i_51_;
        buffer_1.offset = i_46_;
        i_82_ = 0;
        int i_88_ = 0;
        int i_89_ = 0;
        int i_90_ = 0;
        int i_92_;
        int i_91_ = i_92_ = 0;
        while (i_91_ < i_7_) {
            int i_93_;
            if ((i_93_ = buffer_1.readUByte2()) == 1) {
                i_90_ = i_82_ = buffer.readSmarts() + i_90_;
                i_90_ = i_88_ = buffer.readSmarts() + i_90_;
                i_90_ = i_89_ = buffer.readSmarts() + i_90_;
                is_70_[i_92_] = i_82_;
                is_71_[i_92_] = i_88_;
                is_72_[i_92_] = i_89_;
            }
            if (i_93_ == 2) {
                i_88_ = i_89_;
                i_90_ = i_89_ = buffer.readSmarts() + i_90_;
                is_70_[i_92_] = i_82_;
                is_71_[i_92_] = i_88_;
                is_72_[i_92_] = i_89_;
            }
            if (i_93_ == 3) {
                i_82_ = i_89_;
                i_90_ = i_89_ = buffer.readSmarts() + i_90_;
                is_70_[i_92_] = i_82_;
                is_71_[i_92_] = i_88_;
                is_72_[i_92_] = i_89_;
            }
            if (i_93_ == 4) {
                int i_94_ = i_82_;
                i_82_ = i_88_;
                i_88_ = i_94_;
                i_90_ = i_89_ = buffer.readSmarts() + i_90_;
                is_70_[i_92_] = i_82_;
                is_71_[i_92_] = i_88_;
                is_72_[i_92_] = i_89_;
            }
            i_91_ = ++i_92_;
        }
        buffer.offset = i_58_;
        buffer_1.offset = i_59_;
        buffer_2.offset = i_60_;
        buffer_3.offset = i_61_;
        buffer_4.offset = i_62_;
        buffer_5.offset = i_63_;
        int i_95_ = i_92_ = 0;
        while (i_95_ < i_8_) {
            int i_96_;
            if ((i_96_ = is_29_[i_92_] & 0xff) == 0) {
                is_75_[i_92_] = buffer.readUShort3();
                is_76_[i_92_] = buffer.readUShort3();
                is_77_[i_92_] = buffer.readUShort3();
            }
            if (i_96_ == 1) {
                is_75_[i_92_] = buffer_1.readUShort3();
                is_76_[i_92_] = buffer_1.readUShort3();
                is_77_[i_92_] = buffer_1.readUShort3();
                is_35_[i_92_] = buffer_2.readUShort3();
                is_37_[i_92_] = buffer_2.readUShort3();
                is_36_[i_92_] = buffer_2.readUShort3();
                is_33_[i_92_] = buffer_3.readByte2();
                is_34_[i_92_] = buffer_4.readByte2();
                is_31_[i_92_] = buffer_5.readByte2();
            }
            if (i_96_ == 2) {
                is_75_[i_92_] = buffer_1.readUShort3();
                is_76_[i_92_] = buffer_1.readUShort3();
                is_77_[i_92_] = buffer_1.readUShort3();
                is_35_[i_92_] = buffer_2.readUShort3();
                is_37_[i_92_] = buffer_2.readUShort3();
                is_36_[i_92_] = buffer_2.readUShort3();
                is_33_[i_92_] = buffer_3.readByte2();
                is_34_[i_92_] = buffer_4.readByte2();
                is_31_[i_92_] = buffer_5.readByte2();
                is_32_[i_92_] = buffer_5.readByte2();
                is_30_[i_92_] = buffer_5.readByte2();
            }
            if (i_96_ == 3) {
                is_75_[i_92_] = buffer_1.readUShort3();
                is_76_[i_92_] = buffer_1.readUShort3();
                is_77_[i_92_] = buffer_1.readUShort3();
                is_35_[i_92_] = buffer_2.readUShort3();
                is_37_[i_92_] = buffer_2.readUShort3();
                is_36_[i_92_] = buffer_2.readUShort3();
                is_33_[i_92_] = buffer_3.readByte2();
                is_34_[i_92_] = buffer_4.readByte2();
                is_31_[i_92_] = buffer_5.readByte2();
            }
            i_95_ = ++i_92_;
        }
        if (i_11_ != 255) {
            int i_97_ = i_92_ = 0;
            while (i_97_ < i_7_) {
                anIntArray_165[i_92_] = i_11_;
                i_97_ = ++i_92_;
            }
        }
        modelColors = is_39_;
        vertexCount = i_6_;
        modelCount = i_7_;
        anIntArray_205 = is_67_;
        anIntArray_191 = is_68_;
        anIntArray_189 = is_69_;
        anIntArray_204 = is_70_;
        anIntArray_146 = is_71_;
        anIntArray_190 = is_72_;
    }

    public void void_method67() {
        modelHeight = 0;
        anInt_181 = 0;
        int i_98_;
        int i = i_98_ = 0;
        while (i < vertexCount) {
            int i_99_;
            if (-(i_99_ = anIntArray_191[i_98_]) > modelHeight) {
                modelHeight = -i_99_;
            }
            if (i_99_ > anInt_181) {
                anInt_181 = i_99_;
            }
            i = ++i_98_;
        }
        anInt_172 = (int) (Math
                .sqrt((double) (anInt_170 * anInt_170 + modelHeight
                        * modelHeight)) + 0.99);
        anInt_196 = anInt_172
                + (int) (Math.sqrt((double) (anInt_170 * anInt_170 + anInt_181
                * anInt_181)) + 0.99);
    }

    private void method68(boolean bool, boolean bool_100_, int i) {
        int i_102_;
        int i_101_ = i_102_ = 0;
        while (i_101_ < anInt_196) {
            anIntArray_200[i_102_] = 0;
            i_101_ = ++i_102_;
        }
        int i_103_ = i_102_ = 0;
        while (i_103_ < modelCount) {
            if (anIntArray_168 == null || anIntArray_168[i_102_] != -1) {
                int i_104_ = anIntArray_204[i_102_];
                int i_105_ = anIntArray_146[i_102_];
                int i_106_ = anIntArray_190[i_102_];
                int i_107_ = anIntArray_148[i_104_];
                int i_108_ = anIntArray_148[i_105_];
                int i_109_ = anIntArray_148[i_106_];
                if (bool
                        && (i_107_ == -5000 || i_108_ == -5000 || i_109_ == -5000)) {
                    aBooleanArray_198[i_102_] = true;
                    int i_110_ = (anIntArray_207[i_104_]
                            + anIntArray_207[i_105_] + anIntArray_207[i_106_])
                            / 3 + anInt_172;
                    anIntArrayArray_177[i_110_][anIntArray_200[i_110_]++] = i_102_;
                } else {
                    if (bool_100_
                            && boolean_method76(anInt_162, anInt_176,
                            anIntArray_199[i_104_],
                            anIntArray_199[i_105_],
                            anIntArray_199[i_106_], i_107_, i_108_,
                            i_109_)) {
                        anIntArray_206[anInt_184++] = i;
                        bool_100_ = false;
                    }
                    if ((i_107_ - i_108_)
                            * (anIntArray_199[i_106_] - anIntArray_199[i_105_])
                            - (anIntArray_199[i_104_] - anIntArray_199[i_105_])
                            * (i_109_ - i_108_) > 0) {
                        aBooleanArray_198[i_102_] = false;
                        aBooleanArray_152[i_102_] = i_107_ < 0 || i_108_ < 0
                                || i_109_ < 0 || i_107_ > Rasterizer.anInt_434
                                || i_108_ > Rasterizer.anInt_434
                                || i_109_ > Rasterizer.anInt_434;
                        int i_111_ = (anIntArray_207[i_104_]
                                + anIntArray_207[i_105_] + anIntArray_207[i_106_])
                                / 3 + anInt_172;
                        anIntArrayArray_177[i_111_][anIntArray_200[i_111_]++] = i_102_;
                    }
                }
            }
            i_103_ = ++i_102_;
        }
        if (anIntArray_165 == null) {
            int i_112_ = i_102_ = anInt_196 - 1;
            while (i_112_ >= 0) {
                int i_113_;
                if ((i_113_ = anIntArray_200[i_102_]) > 0) {
                    int[] is = anIntArrayArray_177[i_102_];
                    int i_115_;
                    int i_114_ = i_115_ = 0;
                    while (i_114_ < i_113_) {
                        void_method78(is[i_115_]);
                        i_114_ = ++i_115_;
                    }
                }
                i_112_ = --i_102_;
            }
        } else {
            int i_116_ = i_102_ = 0;
            while (i_116_ < 12) {
                anIntArray_158[i_102_] = 0;
                anIntArray_175[i_102_] = 0;
                i_116_ = ++i_102_;
            }
            int i_117_ = i_102_ = anInt_196 - 1;
            while (i_117_ >= 0) {
                int i_118_;
                if ((i_118_ = anIntArray_200[i_102_]) > 0) {
                    int[] is = anIntArrayArray_177[i_102_];
                    int i_120_;
                    int i_119_ = i_120_ = 0;
                    while (i_119_ < i_118_) {
                        int i_121_ = is[i_120_];
                        int i_122_ = anIntArray_165[i_121_];
                        int i_123_ = anIntArray_158[i_122_]++;
                        anIntArrayArray_194[i_122_][i_123_] = i_121_;
                        if (i_122_ < 10) {
                            anIntArray_175[i_122_] += i_102_;
                        } else if (i_122_ == 10) {
                            anIntArray_203[i_123_] = i_102_;
                        } else {
                            anIntArray_179[i_123_] = i_102_;
                        }
                        i_119_ = ++i_120_;
                    }
                }
                i_117_ = --i_102_;
            }
            i_102_ = 0;
            if (anIntArray_158[1] > 0 || anIntArray_158[2] > 0) {
                i_102_ = (anIntArray_175[1] + anIntArray_175[2])
                        / (anIntArray_158[1] + anIntArray_158[2]);
            }
            int i_124_ = 0;
            if (anIntArray_158[3] > 0 || anIntArray_158[4] > 0) {
                i_124_ = (anIntArray_175[3] + anIntArray_175[4])
                        / (anIntArray_158[3] + anIntArray_158[4]);
            }
            int i_125_ = 0;
            if (anIntArray_158[6] > 0 || anIntArray_158[8] > 0) {
                i_125_ = (anIntArray_175[6] + anIntArray_175[8])
                        / (anIntArray_158[6] + anIntArray_158[8]);
            }
            int i_126_ = 0;
            int i_127_ = anIntArray_158[10];
            int[] is = anIntArrayArray_194[10];
            int[] is_128_ = anIntArray_203;
            if (i_126_ == i_127_) {
                i_126_ = 0;
                i_127_ = anIntArray_158[11];
                is = anIntArrayArray_194[11];
                is_128_ = anIntArray_179;
            }
            int i_129_;
            if (i_126_ < i_127_) {
                i_129_ = is_128_[i_126_];
            } else {
                i_129_ = -1000;
            }
            int i_131_;
            int i_130_ = i_131_ = 0;
            while (i_130_ < 10) {
                int i_132_ = i_131_;
                while (i_132_ == 0 && i_129_ > i_102_) {
                    void_method78(is[i_126_++]);
                    if (i_126_ == i_127_ && is != anIntArrayArray_194[11]) {
                        i_126_ = 0;
                        i_127_ = anIntArray_158[11];
                        is = anIntArrayArray_194[11];
                        is_128_ = anIntArray_179;
                    }
                    if (i_126_ < i_127_) {
                        i_129_ = is_128_[i_126_];
                        i_132_ = i_131_;
                    } else {
                        i_129_ = -1000;
                        i_132_ = i_131_;
                    }
                }
                int i_133_ = i_131_;
                while_0_:
                for (; ; ) {
                    int i_134_ = 3;
                    for (; ; ) {
                        if (i_133_ != i_134_ || i_129_ <= i_124_) {
                            break while_0_;
                        }
                        void_method78(is[i_126_++]);
                        if (i_126_ == i_127_ && is != anIntArrayArray_194[11]) {
                            i_126_ = 0;
                            i_127_ = anIntArray_158[11];
                            is = anIntArrayArray_194[11];
                            is_128_ = anIntArray_179;
                        }
                        if (i_126_ < i_127_) {
                            i_129_ = is_128_[i_126_];
                            i_133_ = i_131_;
                            break;
                        }
                        i_129_ = -1000;
                        i_133_ = i_131_;
                        i_134_ = 3;
                    }
                }
                int i_135_ = i_131_;
                while_1_:
                for (; ; ) {
                    int i_136_ = 5;
                    for (; ; ) {
                        if (i_135_ != i_136_ || i_129_ <= i_125_) {
                            break while_1_;
                        }
                        void_method78(is[i_126_++]);
                        if (i_126_ == i_127_ && is != anIntArrayArray_194[11]) {
                            i_126_ = 0;
                            i_127_ = anIntArray_158[11];
                            is = anIntArrayArray_194[11];
                            is_128_ = anIntArray_179;
                        }
                        if (i_126_ < i_127_) {
                            i_129_ = is_128_[i_126_];
                            i_135_ = i_131_;
                            break;
                        }
                        i_129_ = -1000;
                        i_135_ = i_131_;
                        i_136_ = 5;
                    }
                }
                int i_137_ = anIntArray_158[i_131_];
                int[] is_138_ = anIntArrayArray_194[i_131_];
                int i_140_;
                int i_139_ = i_140_ = 0;
                while (i_139_ < i_137_) {
                    void_method78(is_138_[i_140_]);
                    i_139_ = ++i_140_;
                }
                i_130_ = ++i_131_;
            }
            int i_141_ = i_129_;
            while (i_141_ != -1000) {
                void_method78(is[i_126_++]);
                if (i_126_ == i_127_ && is != anIntArrayArray_194[11]) {
                    i_126_ = 0;
                    is = anIntArrayArray_194[11];
                    i_127_ = anIntArray_158[11];
                    is_128_ = anIntArray_179;
                }
                i_141_ = i_126_ < i_127_ ? i_129_ = is_128_[i_126_]
                        : (i_129_ = -1000);
            }
        }
    }

    public void void_method69(Model var_a_sub_46_164_, boolean bool) {
        vertexCount = var_a_sub_46_164_.vertexCount;
        modelCount = var_a_sub_46_164_.modelCount;
        anInt_186 = var_a_sub_46_164_.anInt_186;
        if (anIntArray_193.length < vertexCount) {
            anIntArray_193 = new int[vertexCount + 100];
            anIntArray_202 = new int[vertexCount + 100];
            anIntArray_169 = new int[vertexCount + 100];
        }
        anIntArray_205 = anIntArray_193;
        anIntArray_191 = anIntArray_202;
        anIntArray_189 = anIntArray_169;
        int i_165_;
        int i = i_165_ = 0;
        while (i < vertexCount) {
            anIntArray_205[i_165_] = var_a_sub_46_164_.anIntArray_205[i_165_];
            anIntArray_191[i_165_] = var_a_sub_46_164_.anIntArray_191[i_165_];
            anIntArray_189[i_165_] = var_a_sub_46_164_.anIntArray_189[i_165_];
            i = ++i_165_;
        }
        if (bool) {
            anIntArray_185 = var_a_sub_46_164_.anIntArray_185;
        } else {
            if (anIntArray_161.length < modelCount) {
                anIntArray_161 = new int[modelCount + 100];
            }
            anIntArray_185 = anIntArray_161;
            if (var_a_sub_46_164_.anIntArray_185 == null) {
                int i_166_ = i_165_ = 0;
                while (i_166_ < modelCount) {
                    anIntArray_185[i_165_] = 0;
                    i_166_ = ++i_165_;
                }
            } else {
                System.arraycopy(var_a_sub_46_164_.anIntArray_185, 0,
                        anIntArray_185, 0, modelCount);
            }
        }
        anIntArray_168 = var_a_sub_46_164_.anIntArray_168;
        modelColors = var_a_sub_46_164_.modelColors;
        anIntArray_165 = var_a_sub_46_164_.anIntArray_165;
        anInt_213 = var_a_sub_46_164_.anInt_213;
        anIntArrayArray_173 = var_a_sub_46_164_.anIntArrayArray_173;
        anIntArrayArray_209 = var_a_sub_46_164_.anIntArrayArray_209;
        anIntArray_204 = var_a_sub_46_164_.anIntArray_204;
        anIntArray_146 = var_a_sub_46_164_.anIntArray_146;
        anIntArray_190 = var_a_sub_46_164_.anIntArray_190;
        anIntArray_182 = var_a_sub_46_164_.anIntArray_182;
        anIntArray_156 = var_a_sub_46_164_.anIntArray_156;
        anIntArray_171 = var_a_sub_46_164_.anIntArray_171;
        anIntArray_163 = var_a_sub_46_164_.anIntArray_163;
        anIntArray_155 = var_a_sub_46_164_.anIntArray_155;
        anIntArray_208 = var_a_sub_46_164_.anIntArray_208;
    }

    public void void_method71() {
        int i_269_;
        int i = i_269_ = 0;
        while (i < vertexCount) {
            anIntArray_189[i_269_] = -anIntArray_189[i_269_];
            i = ++i_269_;
        }
        int i_270_ = i_269_ = 0;
        while (i_270_ < modelCount) {
            int i_271_ = anIntArray_204[i_269_];
            anIntArray_204[i_269_] = anIntArray_190[i_269_];
            anIntArray_190[i_269_] = i_271_;
            i_270_ = ++i_269_;
        }
    }

    private void void_method73(int i) {
        int i_278_ = Rasterizer3D.anInt_132;
        int i_279_ = Rasterizer3D.anInt_135;
        int i_280_ = 0;
        int i_281_ = anIntArray_204[i];
        int i_282_ = anIntArray_146[i];
        int i_283_ = anIntArray_190[i];
        int i_284_ = anIntArray_195[i_281_];
        int i_285_ = anIntArray_195[i_282_];
        int i_286_ = anIntArray_195[i_283_];
        if (i_284_ >= 50) {
            anIntArray_214[i_280_] = anIntArray_148[i_281_];
            anIntArray_180[i_280_] = anIntArray_199[i_281_];
            anIntArray_187[i_280_++] = anIntArray_182[i];
        } else {
            int i_287_ = anIntArray_188[i_281_];
            int i_288_ = anIntArray_160[i_281_];
            int i_289_ = anIntArray_182[i];
            if (i_286_ >= 50) {
                int i_290_ = (50 - i_284_) * anIntArray_151[i_286_ - i_284_];
                anIntArray_214[i_280_] = i_278_
                        + (i_287_
                        + ((anIntArray_188[i_283_] - i_287_) * i_290_ >> 16) << 9)
                        / 50;
                anIntArray_180[i_280_] = i_279_
                        + (i_288_
                        + ((anIntArray_160[i_283_] - i_288_) * i_290_ >> 16) << 9)
                        / 50;
                anIntArray_187[i_280_++] = i_289_
                        + ((anIntArray_171[i] - i_289_) * i_290_ >> 16);
            }
            if (i_285_ >= 50) {
                int i_291_ = (50 - i_284_) * anIntArray_151[i_285_ - i_284_];
                anIntArray_214[i_280_] = i_278_
                        + (i_287_
                        + ((anIntArray_188[i_282_] - i_287_) * i_291_ >> 16) << 9)
                        / 50;
                anIntArray_180[i_280_] = i_279_
                        + (i_288_
                        + ((anIntArray_160[i_282_] - i_288_) * i_291_ >> 16) << 9)
                        / 50;
                anIntArray_187[i_280_++] = i_289_
                        + ((anIntArray_156[i] - i_289_) * i_291_ >> 16);
            }
        }
        if (i_285_ >= 50) {
            anIntArray_214[i_280_] = anIntArray_148[i_282_];
            anIntArray_180[i_280_] = anIntArray_199[i_282_];
            anIntArray_187[i_280_++] = anIntArray_156[i];
        } else {
            int i_292_ = anIntArray_188[i_282_];
            int i_293_ = anIntArray_160[i_282_];
            int i_294_ = anIntArray_156[i];
            if (i_284_ >= 50) {
                int i_295_ = (50 - i_285_) * anIntArray_151[i_284_ - i_285_];
                anIntArray_214[i_280_] = i_278_
                        + (i_292_
                        + ((anIntArray_188[i_281_] - i_292_) * i_295_ >> 16) << 9)
                        / 50;
                anIntArray_180[i_280_] = i_279_
                        + (i_293_
                        + ((anIntArray_160[i_281_] - i_293_) * i_295_ >> 16) << 9)
                        / 50;
                anIntArray_187[i_280_++] = i_294_
                        + ((anIntArray_182[i] - i_294_) * i_295_ >> 16);
            }
            if (i_286_ >= 50) {
                int i_296_ = (50 - i_285_) * anIntArray_151[i_286_ - i_285_];
                anIntArray_214[i_280_] = i_278_
                        + (i_292_
                        + ((anIntArray_188[i_283_] - i_292_) * i_296_ >> 16) << 9)
                        / 50;
                anIntArray_180[i_280_] = i_279_
                        + (i_293_
                        + ((anIntArray_160[i_283_] - i_293_) * i_296_ >> 16) << 9)
                        / 50;
                anIntArray_187[i_280_++] = i_294_
                        + ((anIntArray_171[i] - i_294_) * i_296_ >> 16);
            }
        }
        if (i_286_ >= 50) {
            anIntArray_214[i_280_] = anIntArray_148[i_283_];
            anIntArray_180[i_280_] = anIntArray_199[i_283_];
            anIntArray_187[i_280_++] = anIntArray_171[i];
        } else {
            int i_297_ = anIntArray_188[i_283_];
            int i_298_ = anIntArray_160[i_283_];
            int i_299_ = anIntArray_171[i];
            if (i_285_ >= 50) {
                int i_300_ = (50 - i_286_) * anIntArray_151[i_285_ - i_286_];
                anIntArray_214[i_280_] = i_278_
                        + (i_297_
                        + ((anIntArray_188[i_282_] - i_297_) * i_300_ >> 16) << 9)
                        / 50;
                anIntArray_180[i_280_] = i_279_
                        + (i_298_
                        + ((anIntArray_160[i_282_] - i_298_) * i_300_ >> 16) << 9)
                        / 50;
                anIntArray_187[i_280_++] = i_299_
                        + ((anIntArray_156[i] - i_299_) * i_300_ >> 16);
            }
            if (i_284_ >= 50) {
                int i_301_ = (50 - i_286_) * anIntArray_151[i_284_ - i_286_];
                anIntArray_214[i_280_] = i_278_
                        + (i_297_
                        + ((anIntArray_188[i_281_] - i_297_) * i_301_ >> 16) << 9)
                        / 50;
                anIntArray_180[i_280_] = i_279_
                        + (i_298_
                        + ((anIntArray_160[i_281_] - i_298_) * i_301_ >> 16) << 9)
                        / 50;
                anIntArray_187[i_280_++] = i_299_
                        + ((anIntArray_182[i] - i_299_) * i_301_ >> 16);
            }
        }
        int i_302_ = anIntArray_214[0];
        int i_303_ = anIntArray_214[1];
        int i_304_ = anIntArray_214[2];
        int i_305_ = anIntArray_180[0];
        int i_306_ = anIntArray_180[1];
        int i_307_ = anIntArray_180[2];
        if ((i_302_ - i_303_) * (i_307_ - i_306_) - (i_305_ - i_306_)
                * (i_304_ - i_303_) > 0) {
            Rasterizer3D.aBoolean_128 = false;
            if (i_280_ == 3) {
                if (i_302_ < 0 || i_303_ < 0 || i_304_ < 0
                        || i_302_ > Rasterizer.anInt_434
                        || i_303_ > Rasterizer.anInt_434
                        || i_304_ > Rasterizer.anInt_434) {
                    Rasterizer3D.aBoolean_128 = true;
                }
                int i_308_;
                if (anIntArray_168 == null) {
                    i_308_ = 0;
                } else {
                    i_308_ = anIntArray_168[i] & 0x3;
                }
                if (i_308_ == 0) {
                    Rasterizer3D.void_method58(i_305_, i_306_, i_307_, i_302_,
                            i_303_, i_304_, anIntArray_187[0],
                            anIntArray_187[1], anIntArray_187[2]);
                } else if (i_308_ == 1) {
                    Rasterizer3D.method60(i_305_, i_306_, i_307_, i_302_,
                            i_303_, i_304_, anIntArray_154[anIntArray_182[i]]);
                } else if (i_308_ == 2) {
                    int i_309_ = anIntArray_168[i] >> 2;
                    int i_310_ = anIntArray_163[i_309_];
                    int i_311_ = anIntArray_155[i_309_];
                    int i_312_ = anIntArray_208[i_309_];
                    Rasterizer3D.void_method59(i_305_, i_306_, i_307_, i_302_,
                            i_303_, i_304_, anIntArray_187[0],
                            anIntArray_187[1], anIntArray_187[2],
                            anIntArray_188[i_310_], anIntArray_188[i_311_],
                            anIntArray_188[i_312_], anIntArray_160[i_310_],
                            anIntArray_160[i_311_], anIntArray_160[i_312_],
                            anIntArray_195[i_310_], anIntArray_195[i_311_],
                            anIntArray_195[i_312_], modelColors[i]);
                } else if (i_308_ == 3) {
                    int i_313_ = anIntArray_168[i] >> 2;
                    int i_314_ = anIntArray_163[i_313_];
                    int i_315_ = anIntArray_155[i_313_];
                    int i_316_ = anIntArray_208[i_313_];
                    Rasterizer3D.void_method59(i_305_, i_306_, i_307_, i_302_,
                            i_303_, i_304_, anIntArray_182[i],
                            anIntArray_182[i], anIntArray_182[i],
                            anIntArray_188[i_314_], anIntArray_188[i_315_],
                            anIntArray_188[i_316_], anIntArray_160[i_314_],
                            anIntArray_160[i_315_], anIntArray_160[i_316_],
                            anIntArray_195[i_314_], anIntArray_195[i_315_],
                            anIntArray_195[i_316_], modelColors[i]);
                }
            }
            if (i_280_ == 4) {
                if (i_302_ < 0 || i_303_ < 0 || i_304_ < 0
                        || i_302_ > Rasterizer.anInt_434
                        || i_303_ > Rasterizer.anInt_434
                        || i_304_ > Rasterizer.anInt_434
                        || anIntArray_214[3] < 0
                        || anIntArray_214[3] > Rasterizer.anInt_434) {
                    Rasterizer3D.aBoolean_128 = true;
                }
                int i_317_;
                if (anIntArray_168 == null) {
                    i_317_ = 0;
                } else {
                    i_317_ = anIntArray_168[i] & 0x3;
                }
                if (i_317_ == 0) {
                    Rasterizer3D.void_method58(i_305_, i_306_, i_307_, i_302_,
                            i_303_, i_304_, anIntArray_187[0],
                            anIntArray_187[1], anIntArray_187[2]);
                    Rasterizer3D.void_method58(i_305_, i_307_,
                            anIntArray_180[3], i_302_, i_304_,
                            anIntArray_214[3], anIntArray_187[0],
                            anIntArray_187[2], anIntArray_187[3]);
                } else if (i_317_ == 1) {
                    int i_318_ = anIntArray_154[anIntArray_182[i]];
                    Rasterizer3D.method60(i_305_, i_306_, i_307_, i_302_,
                            i_303_, i_304_, i_318_);
                    Rasterizer3D.method60(i_305_, i_307_, anIntArray_180[3],
                            i_302_, i_304_, anIntArray_214[3], i_318_);
                } else if (i_317_ == 2) {
                    int i_319_ = anIntArray_168[i] >> 2;
                    int i_320_ = anIntArray_163[i_319_];
                    int i_321_ = anIntArray_155[i_319_];
                    int i_322_ = anIntArray_208[i_319_];
                    Rasterizer3D.void_method59(i_305_, i_306_, i_307_, i_302_,
                            i_303_, i_304_, anIntArray_187[0],
                            anIntArray_187[1], anIntArray_187[2],
                            anIntArray_188[i_320_], anIntArray_188[i_321_],
                            anIntArray_188[i_322_], anIntArray_160[i_320_],
                            anIntArray_160[i_321_], anIntArray_160[i_322_],
                            anIntArray_195[i_320_], anIntArray_195[i_321_],
                            anIntArray_195[i_322_], modelColors[i]);
                    Rasterizer3D.void_method59(i_305_, i_307_,
                            anIntArray_180[3], i_302_, i_304_,
                            anIntArray_214[3], anIntArray_187[0],
                            anIntArray_187[2], anIntArray_187[3],
                            anIntArray_188[i_320_], anIntArray_188[i_321_],
                            anIntArray_188[i_322_], anIntArray_160[i_320_],
                            anIntArray_160[i_321_], anIntArray_160[i_322_],
                            anIntArray_195[i_320_], anIntArray_195[i_321_],
                            anIntArray_195[i_322_], modelColors[i]);
                } else if (i_317_ == 3) {
                    int i_323_ = anIntArray_168[i] >> 2;
                    int i_324_ = anIntArray_163[i_323_];
                    int i_325_ = anIntArray_155[i_323_];
                    int i_326_ = anIntArray_208[i_323_];
                    Rasterizer3D.void_method59(i_305_, i_306_, i_307_, i_302_,
                            i_303_, i_304_, anIntArray_182[i],
                            anIntArray_182[i], anIntArray_182[i],
                            anIntArray_188[i_324_], anIntArray_188[i_325_],
                            anIntArray_188[i_326_], anIntArray_160[i_324_],
                            anIntArray_160[i_325_], anIntArray_160[i_326_],
                            anIntArray_195[i_324_], anIntArray_195[i_325_],
                            anIntArray_195[i_326_], modelColors[i]);
                    Rasterizer3D.void_method59(i_305_, i_307_,
                            anIntArray_180[3], i_302_, i_304_,
                            anIntArray_214[3], anIntArray_182[i],
                            anIntArray_182[i], anIntArray_182[i],
                            anIntArray_188[i_324_], anIntArray_188[i_325_],
                            anIntArray_188[i_326_], anIntArray_160[i_324_],
                            anIntArray_160[i_325_], anIntArray_160[i_326_],
                            anIntArray_195[i_324_], anIntArray_195[i_325_],
                            anIntArray_195[i_326_], modelColors[i]);
                }
            }
        }
    }

    public void void_method75(int i) {
        int i_344_ = anIntArray_150[i];
        int i_345_ = anIntArray_164[i];
        int i_347_;
        int i_346_ = i_347_ = 0;
        while (i_346_ < vertexCount) {
            int i_348_ = anIntArray_191[i_347_] * i_345_
                    - anIntArray_189[i_347_] * i_344_ >> 16;
            anIntArray_189[i_347_] = anIntArray_191[i_347_] * i_344_
                    + anIntArray_189[i_347_] * i_345_ >> 16;
            anIntArray_191[i_347_] = i_348_;
            i_346_ = ++i_347_;
        }
    }

    private void void_method78(int i) {
        if (aBooleanArray_198[i]) {
            void_method73(i);
        } else {
            int i_407_ = anIntArray_204[i];
            int i_408_ = anIntArray_146[i];
            int i_409_ = anIntArray_190[i];
            Rasterizer3D.aBoolean_128 = aBooleanArray_152[i];
            if (anIntArray_185 == null) {
                Rasterizer3D.anInt_126 = 0;
            } else {
                Rasterizer3D.anInt_126 = anIntArray_185[i];
            }
            int i_410_;
            if (anIntArray_168 == null) {
                i_410_ = 0;
            } else {
                i_410_ = anIntArray_168[i] & 0x3;
            }
            if (i_410_ == 0) {
                Rasterizer3D.void_method58(anIntArray_199[i_407_],
                        anIntArray_199[i_408_], anIntArray_199[i_409_],
                        anIntArray_148[i_407_], anIntArray_148[i_408_],
                        anIntArray_148[i_409_], anIntArray_182[i],
                        anIntArray_156[i], anIntArray_171[i]);
            } else if (i_410_ == 1) {
                Rasterizer3D.method60(anIntArray_199[i_407_],
                        anIntArray_199[i_408_], anIntArray_199[i_409_],
                        anIntArray_148[i_407_], anIntArray_148[i_408_],
                        anIntArray_148[i_409_],
                        anIntArray_154[anIntArray_182[i]]);
            } else if (i_410_ == 2) {
                int i_411_ = anIntArray_168[i] >> 2;
                int i_412_ = anIntArray_163[i_411_];
                int i_413_ = anIntArray_155[i_411_];
                int i_414_ = anIntArray_208[i_411_];
                Rasterizer3D.void_method59(anIntArray_199[i_407_],
                        anIntArray_199[i_408_], anIntArray_199[i_409_],
                        anIntArray_148[i_407_], anIntArray_148[i_408_],
                        anIntArray_148[i_409_], anIntArray_182[i],
                        anIntArray_156[i], anIntArray_171[i],
                        anIntArray_188[i_412_], anIntArray_188[i_413_],
                        anIntArray_188[i_414_], anIntArray_160[i_412_],
                        anIntArray_160[i_413_], anIntArray_160[i_414_],
                        anIntArray_195[i_412_], anIntArray_195[i_413_],
                        anIntArray_195[i_414_], modelColors[i]);
            } else if (i_410_ == 3) {
                int i_415_ = anIntArray_168[i] >> 2;
                int i_416_ = anIntArray_163[i_415_];
                int i_417_ = anIntArray_155[i_415_];
                int i_418_ = anIntArray_208[i_415_];
                Rasterizer3D.void_method59(anIntArray_199[i_407_],
                        anIntArray_199[i_408_], anIntArray_199[i_409_],
                        anIntArray_148[i_407_], anIntArray_148[i_408_],
                        anIntArray_148[i_409_], anIntArray_182[i],
                        anIntArray_182[i], anIntArray_182[i],
                        anIntArray_188[i_416_], anIntArray_188[i_417_],
                        anIntArray_188[i_418_], anIntArray_160[i_416_],
                        anIntArray_160[i_417_], anIntArray_160[i_418_],
                        anIntArray_195[i_416_], anIntArray_195[i_417_],
                        anIntArray_195[i_418_], modelColors[i]);
            }
        }
    }

    public void void_method79(int i) {
        int i_420_;
        int i_419_ = i_420_ = 0;
        while (i_419_ < vertexCount) {
            anIntArray_205[i_420_] = anIntArray_205[i_420_] / i;
            anIntArray_191[i_420_] = anIntArray_191[i_420_] / i;
            anIntArray_189[i_420_] = anIntArray_189[i_420_] / i;
            i_419_ = ++i_420_;
        }
    }

    public void light(int i, int i_421_, int i_422_, int i_423_, int i_424_,
                      boolean bool) {
        int i_425_ = (int) Math.sqrt((double) (i_422_ * i_422_ + i_423_
                * i_423_ + i_424_ * i_424_));
        int i_426_ = i_421_ * i_425_ >> 8;
        if (anIntArray_182 == null) {
            anIntArray_182 = new int[modelCount];
            anIntArray_156 = new int[modelCount];
            anIntArray_171 = new int[modelCount];
        }
        if (vertexNormals == null) {
            vertexNormals = new VertexNormal[vertexCount];
            int i_428_;
            int i_427_ = i_428_ = 0;
            while (i_427_ < vertexCount) {
                vertexNormals[i_428_] = new VertexNormal();
                i_427_ = ++i_428_;
            }
        }
        int i_430_;
        int i_429_ = i_430_ = 0;
        while (i_429_ < modelCount) {
            if (modelColors != null && anIntArray_185 != null
                    && modelColors[i_430_] == 55232) {
                modelColors[i_430_] = 6798;
            }
            int i_431_ = anIntArray_204[i_430_];
            int i_432_ = anIntArray_146[i_430_];
            int i_433_ = anIntArray_190[i_430_];
            int i_434_ = anIntArray_205[i_432_] - anIntArray_205[i_431_];
            int i_435_ = anIntArray_191[i_432_] - anIntArray_191[i_431_];
            int i_436_ = anIntArray_189[i_432_] - anIntArray_189[i_431_];
            int i_437_ = anIntArray_205[i_433_] - anIntArray_205[i_431_];
            int i_438_ = anIntArray_191[i_433_] - anIntArray_191[i_431_];
            int i_439_ = anIntArray_189[i_433_] - anIntArray_189[i_431_];
            int i_440_ = i_435_ * i_439_ - i_438_ * i_436_;
            int i_441_ = i_436_ * i_437_ - i_439_ * i_434_;
            int i_442_ = i_434_ * i_438_ - i_437_ * i_435_;
            int i_443_ = i_440_;
            while (i_443_ > 8192 || i_441_ > 8192 || i_442_ > 8192
                    || i_440_ < -8192 || i_441_ < -8192 || i_442_ < -8192) {
                i_440_ >>= 1;
                i_441_ >>= 1;
                i_442_ >>= 1;
                i_443_ = i_440_;
            }
            int i_444_;
            if ((i_444_ = (int) Math.sqrt((double) (i_440_ * i_440_ + i_441_
                    * i_441_ + i_442_ * i_442_))) <= 0) {
                i_444_ = 1;
            }
            i_440_ = i_440_ * 256 / i_444_;
            i_441_ = i_441_ * 256 / i_444_;
            i_442_ = i_442_ * 256 / i_444_;
            if (anIntArray_168 == null || (anIntArray_168[i_430_] & 0x1) == 0) {
                VertexNormal vertexNormal;
                (vertexNormal = vertexNormals[i_431_]).an_int_116 += i_440_;
                vertexNormal.an_int_118 += i_441_;
                vertexNormal.an_int_115 += i_442_;
                vertexNormal.an_int_117++;
                (vertexNormal = vertexNormals[i_432_]).an_int_116 += i_440_;
                vertexNormal.an_int_118 += i_441_;
                vertexNormal.an_int_115 += i_442_;
                vertexNormal.an_int_117++;
                (vertexNormal = vertexNormals[i_433_]).an_int_116 += i_440_;
                vertexNormal.an_int_118 += i_441_;
                vertexNormal.an_int_115 += i_442_;
                vertexNormal.an_int_117++;
            } else {
                int i_445_ = i
                        + (i_422_ * i_440_ + i_423_ * i_441_ + i_424_ * i_442_)
                        / (i_426_ + i_426_ / 2);
                anIntArray_182[i_430_] = int_method85(modelColors[i_430_],
                        i_445_, anIntArray_168[i_430_]);
            }
            i_429_ = ++i_430_;
        }
        if (bool) {
            void_method86(i, i_426_, i_422_, i_423_, i_424_);
        } else {
            aVertexNormaArray = new VertexNormal[vertexCount];
            int i_446_ = i_430_ = 0;
            while (i_446_ < vertexCount) {
                VertexNormal class_w = vertexNormals[i_430_];
                VertexNormal class_w_447_;
                (class_w_447_ = aVertexNormaArray[i_430_] = new VertexNormal()).an_int_116 = class_w.an_int_116;
                class_w_447_.an_int_118 = class_w.an_int_118;
                class_w_447_.an_int_115 = class_w.an_int_115;
                class_w_447_.an_int_117 = class_w.an_int_117;
                i_446_ = ++i_430_;
            }
        }
        if (bool) {
            void_method38();
        } else {
            void_method64();
        }
    }

    public void scale(int i, int i_448_, int i_449_) {
        int vertex;
        int i_450_ = vertex = 0;
        while (i_450_ < vertexCount) {
            anIntArray_205[vertex] = anIntArray_205[vertex] * i / 128;
            anIntArray_191[vertex] = anIntArray_191[vertex] * i_449_ / 128;
            anIntArray_189[vertex] = anIntArray_189[vertex] * i_448_ / 128;
            i_450_ = ++vertex;
        }
    }

    private void method84(int i, int[] is, int i_494_, int i_495_, int i_496_) {
        int i_497_ = is.length;
        if (i == 0) {
            int i_498_ = 0;
            anInt_192 = 0;
            anInt_157 = 0;
            anInt_167 = 0;
            int i_500_;
            int i_499_ = i_500_ = 0;
            while (i_499_ < i_497_) {
                int i_501_;
                if ((i_501_ = is[i_500_]) < anIntArrayArray_209.length) {
                    int[] is_502_ = anIntArrayArray_209[i_501_];
                    int i_504_;
                    int i_503_ = i_504_ = 0;
                    while (i_503_ < is_502_.length) {
                        int i_505_ = is_502_[i_504_];
                        anInt_192 += anIntArray_205[i_505_];
                        anInt_157 += anIntArray_191[i_505_];
                        anInt_167 += anIntArray_189[i_505_];
                        i_498_++;
                        i_503_ = ++i_504_;
                    }
                }
                i_499_ = ++i_500_;
            }
            if (i_498_ > 0) {
                anInt_192 = anInt_192 / i_498_ + i_494_;
                anInt_157 = anInt_157 / i_498_ + i_495_;
                anInt_167 = anInt_167 / i_498_ + i_496_;
            } else {
                anInt_192 = i_494_;
                anInt_157 = i_495_;
                anInt_167 = i_496_;
            }
        } else if (i == 1) {
            int i_507_;
            int i_506_ = i_507_ = 0;
            while (i_506_ < i_497_) {
                int i_508_;
                if ((i_508_ = is[i_507_]) < anIntArrayArray_209.length) {
                    int[] is_509_ = anIntArrayArray_209[i_508_];
                    int i_511_;
                    int i_510_ = i_511_ = 0;
                    while (i_510_ < is_509_.length) {
                        int i_512_ = is_509_[i_511_];
                        anIntArray_205[i_512_] += i_494_;
                        anIntArray_191[i_512_] += i_495_;
                        anIntArray_189[i_512_] += i_496_;
                        i_510_ = ++i_511_;
                    }
                }
                i_506_ = ++i_507_;
            }
        } else if (i == 2) {
            int i_514_;
            int i_513_ = i_514_ = 0;
            while (i_513_ < i_497_) {
                int i_515_;
                if ((i_515_ = is[i_514_]) < anIntArrayArray_209.length) {
                    int[] is_516_ = anIntArrayArray_209[i_515_];
                    for (int element : is_516_) {
                        int i_518_ = element;
                        anIntArray_205[i_518_] -= anInt_192;
                        anIntArray_191[i_518_] -= anInt_157;
                        anIntArray_189[i_518_] -= anInt_167;
                        int i_519_ = (i_494_ & 0xff) * 8;
                        int i_520_ = (i_495_ & 0xff) * 8;
                        int i_521_;
                        if ((i_521_ = (i_496_ & 0xff) * 8) != 0) {
                            int i_522_ = anIntArray_150[i_521_];
                            int i_523_ = anIntArray_164[i_521_];
                            int i_524_ = anIntArray_191[i_518_] * i_522_
                                    + anIntArray_205[i_518_] * i_523_ >> 16;
                            anIntArray_191[i_518_] = anIntArray_191[i_518_]
                                    * i_523_ - anIntArray_205[i_518_] * i_522_ >> 16;
                            anIntArray_205[i_518_] = i_524_;
                        }
                        if (i_519_ != 0) {
                            int i_525_ = anIntArray_150[i_519_];
                            int i_526_ = anIntArray_164[i_519_];
                            int i_527_ = anIntArray_191[i_518_] * i_526_
                                    - anIntArray_189[i_518_] * i_525_ >> 16;
                            anIntArray_189[i_518_] = anIntArray_191[i_518_]
                                    * i_525_ + anIntArray_189[i_518_] * i_526_ >> 16;
                            anIntArray_191[i_518_] = i_527_;
                        }
                        if (i_520_ != 0) {
                            int i_528_ = anIntArray_150[i_520_];
                            int i_529_ = anIntArray_164[i_520_];
                            int i_530_ = anIntArray_189[i_518_] * i_528_
                                    + anIntArray_205[i_518_] * i_529_ >> 16;
                            anIntArray_189[i_518_] = anIntArray_189[i_518_]
                                    * i_529_ - anIntArray_205[i_518_] * i_528_ >> 16;
                            anIntArray_205[i_518_] = i_530_;
                        }
                        anIntArray_205[i_518_] += anInt_192;
                        anIntArray_191[i_518_] += anInt_157;
                        anIntArray_189[i_518_] += anInt_167;
                    }
                }
                i_513_ = ++i_514_;
            }
        } else if (i == 3) {
            int i_532_;
            int i_531_ = i_532_ = 0;
            while (i_531_ < i_497_) {
                int i_533_;
                if ((i_533_ = is[i_532_]) < anIntArrayArray_209.length) {
                    int[] is_534_ = anIntArrayArray_209[i_533_];
                    int i_536_;
                    int i_535_ = i_536_ = 0;
                    while (i_535_ < is_534_.length) {
                        int i_537_ = is_534_[i_536_];
                        anIntArray_205[i_537_] -= anInt_192;
                        anIntArray_191[i_537_] -= anInt_157;
                        anIntArray_189[i_537_] -= anInt_167;
                        anIntArray_205[i_537_] = anIntArray_205[i_537_]
                                * i_494_ / 128;
                        anIntArray_191[i_537_] = anIntArray_191[i_537_]
                                * i_495_ / 128;
                        anIntArray_189[i_537_] = anIntArray_189[i_537_]
                                * i_496_ / 128;
                        anIntArray_205[i_537_] += anInt_192;
                        anIntArray_191[i_537_] += anInt_157;
                        anIntArray_189[i_537_] += anInt_167;
                        i_535_ = ++i_536_;
                    }
                }
                i_531_ = ++i_532_;
            }
        } else if (i == 5 && anIntArrayArray_173 != null
                && anIntArray_185 != null) {
            int i_539_;
            int i_538_ = i_539_ = 0;
            while (i_538_ < i_497_) {
                int i_540_;
                if ((i_540_ = is[i_539_]) < anIntArrayArray_173.length) {
                    int[] is_541_ = anIntArrayArray_173[i_540_];
                    int i_543_;
                    int i_542_ = i_543_ = 0;
                    while (i_542_ < is_541_.length) {
                        int i_544_ = is_541_[i_543_];
                        anIntArray_185[i_544_] += i_494_ * 8;
                        if (anIntArray_185[i_544_] < 0) {
                            anIntArray_185[i_544_] = 0;
                        }
                        if (anIntArray_185[i_544_] > 255) {
                            anIntArray_185[i_544_] = 255;
                        }
                        i_542_ = ++i_543_;
                    }
                }
                i_538_ = ++i_539_;
            }
        }
    }

    public void void_method86(int i, int i_571_, int i_572_, int i_573_,
                              int i_574_) {
        int i_576_;
        int i_575_ = i_576_ = 0;
        while (i_575_ < modelCount) {
            int i_577_ = anIntArray_204[i_576_];
            int i_578_ = anIntArray_146[i_576_];
            int i_579_ = anIntArray_190[i_576_];
            if (anIntArray_168 == null) {
                int i_580_ = modelColors[i_576_];
                VertexNormal class_w = vertexNormals[i_577_];
                int i_581_ = i
                        + (i_572_ * class_w.an_int_116 + i_573_
                        * class_w.an_int_118 + i_574_
                        * class_w.an_int_115)
                        / (i_571_ * class_w.an_int_117);
                anIntArray_182[i_576_] = int_method85(i_580_, i_581_, 0);
                class_w = vertexNormals[i_578_];
                i_581_ = i
                        + (i_572_ * class_w.an_int_116 + i_573_
                        * class_w.an_int_118 + i_574_
                        * class_w.an_int_115)
                        / (i_571_ * class_w.an_int_117);
                anIntArray_156[i_576_] = int_method85(i_580_, i_581_, 0);
                class_w = vertexNormals[i_579_];
                i_581_ = i
                        + (i_572_ * class_w.an_int_116 + i_573_
                        * class_w.an_int_118 + i_574_
                        * class_w.an_int_115)
                        / (i_571_ * class_w.an_int_117);
                anIntArray_171[i_576_] = int_method85(i_580_, i_581_, 0);
            } else if ((anIntArray_168[i_576_] & 0x1) == 0) {
                int i_582_ = modelColors[i_576_];
                int i_583_ = anIntArray_168[i_576_];
                VertexNormal class_w = vertexNormals[i_577_];
                int i_584_ = i
                        + (i_572_ * class_w.an_int_116 + i_573_
                        * class_w.an_int_118 + i_574_
                        * class_w.an_int_115)
                        / (i_571_ * class_w.an_int_117);
                anIntArray_182[i_576_] = int_method85(i_582_, i_584_, i_583_);
                class_w = vertexNormals[i_578_];
                i_584_ = i
                        + (i_572_ * class_w.an_int_116 + i_573_
                        * class_w.an_int_118 + i_574_
                        * class_w.an_int_115)
                        / (i_571_ * class_w.an_int_117);
                anIntArray_156[i_576_] = int_method85(i_582_, i_584_, i_583_);
                class_w = vertexNormals[i_579_];
                i_584_ = i
                        + (i_572_ * class_w.an_int_116 + i_573_
                        * class_w.an_int_118 + i_574_
                        * class_w.an_int_115)
                        / (i_571_ * class_w.an_int_117);
                anIntArray_171[i_576_] = int_method85(i_582_, i_584_, i_583_);
            }
            i_575_ = ++i_576_;
        }
        vertexNormals = null;
        aVertexNormaArray = null;
        anIntArray_178 = null;
        anIntArray_153 = null;
        if (anIntArray_168 != null) {
            int i_585_ = i_576_ = 0;
            while (i_585_ < modelCount) {
                if ((anIntArray_168[i_576_] & 0x2) == 2) {
                    return;
                }
                i_585_ = ++i_576_;
            }
        }
        modelColors = null;
    }

    public void void_method87(int i, int i_586_, int i_587_) {
        int i_589_;
        int i_588_ = i_589_ = 0;
        while (i_588_ < vertexCount) {
            anIntArray_205[i_589_] += i;
            anIntArray_191[i_589_] += i_586_;
            anIntArray_189[i_589_] += i_587_;
            i_588_ = ++i_589_;
        }
    }

    public void transform(int frame) {
        Animation animation;
        if (anIntArrayArray_209 != null
                && frame != -1
                && (animation = Animation.getAnimation(frame)) != null) {
            Skins skins = animation.skins;
            anInt_192 = 0;
            anInt_157 = 0;
            anInt_167 = 0;
            int linkIndex;
            int pointer = linkIndex = 0;
            while (pointer < animation.stepCount) {
                int opcode = animation.opcodeLinkTable[linkIndex];
                method84(skins.opcodes[opcode],
                        skins.anIntArrayArray_582[opcode],
                        animation.anIntArray_329[linkIndex],
                        animation.anIntArray_327[linkIndex],
                        animation.anIntArray_326[linkIndex]);
                pointer = ++linkIndex;
            }
        }
    }
}
