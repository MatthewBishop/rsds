package dev.openrune.rsds.client;

public class Rasterizer3D extends Rasterizer {

    private static int[][] anIntArrayArray_127;
    private static int[][] anIntArrayArray_138;
    private static int[][] anIntArrayArray_143;
    private static boolean[] aBooleanArray_142;
    private static int[] anIntArray_120;
    public static int[] anIntArray_121;
    private static int[] anIntArray_124;
    public static int[] anIntArray_129;
    public static int[] anIntArray_131;
    public static final int[] anIntArray_133;
    public static int[] anIntArray_134;
    public static int[] anIntArray_136;
    public static int[] anIntArray_137;
    public static boolean aBoolean_123;
    public static boolean aBoolean_125 = true;
    static boolean aBoolean_128;
    public static boolean aBoolean_130;
    private static boolean aBoolean_139;
    public static final int anInt_119 = -477;
    public static int anInt_126;
    public static int anInt_132;
    public static int anInt_135;
    private static int anInt_140;
    public static int anInt_141;

    static {
        aBoolean_123 = true;
        aBoolean_130 = true;
        aBooleanArray_142 = new boolean[50];
        anIntArray_120 = new int[50];
        anIntArrayArray_127 = new int[50][];
        anIntArray_131 = new int[50];
        anIntArray_129 = new int[65536];
        anIntArrayArray_143 = new int[50][];
        anIntArray_124 = new int[512];
        anIntArray_133 = new int[2048];
        anIntArray_137 = new int[2048];
        anIntArray_121 = new int[2048];
        int i_27_;
        int i = i_27_ = 1;
        while (i < 512) {
            anIntArray_124[i_27_] = 32768 / i_27_;
            i = ++i_27_;
        }
        int i_28_ = i_27_ = 1;
        while (i_28_ < 2048) {
            anIntArray_133[i_27_] = 65536 / i_27_;
            i_28_ = ++i_27_;
        }
        int i_29_ = i_27_ = 0;
        while (i_29_ < 2048) {
            anIntArray_137[i_27_] = (int) (Math
                    .sin((double) i_27_ * 0.0030679615) * 65536.0);
            anIntArray_121[i_27_] = (int) (Math
                    .cos((double) i_27_ * 0.0030679615) * 65536.0);
            i_29_ = ++i_27_;
        }
    }

    private static int[] method52(int i) {
        return null;
    }

    public static int method51(int i) {
        if (anIntArray_120[i] != 0) {
            return anIntArray_120[i];
        }
        int i_21_ = 0;
        int i_22_ = 0;
        int i_23_ = 0;
        int i_24_ = anIntArrayArray_143[i].length;
        int i_26_;
        int i_25_ = i_26_ = 0;
        while (i_25_ < i_24_) {
            i_21_ += anIntArrayArray_143[i][i_26_] >> 16 & 0xff;
            i_22_ += anIntArrayArray_143[i][i_26_] >> 8 & 0xff;
            i_23_ += anIntArrayArray_143[i][i_26_] & 0xff;
            i_25_ = ++i_26_;
        }
        if ((i_26_ = int_method53(i_26_ = (i_21_ / i_24_ << 16)
                + (i_22_ / i_24_ << 8) + i_23_ / i_24_, 1.4)) == 0) {
            i_26_ = 1;
        }
        anIntArray_120[i] = i_26_;
        return i_26_;
    }

    private static int int_method53(int i, double d) {
        double d_30_ = (double) (i >> 16) / 256.0;
        double d_31_ = (double) (i >> 8 & 0xff) / 256.0;
        double d_32_ = (double) (i & 0xff) / 256.0;
        d_30_ = Math.pow(d_30_, d);
        d_31_ = Math.pow(d_31_, d);
        d_32_ = Math.pow(d_32_, d);
        int i_33_ = (int) (d_30_ * 256.0);
        int i_34_ = (int) (d_31_ * 256.0);
        int i_35_ = (int) (d_32_ * 256.0);
        return (i_33_ << 16) + (i_34_ << 8) + i_35_;
    }

    public static void method50(double d) {
        d += Math.random() * 0.03 - 0.015;
        int i = 0;
        int i_1_;
        int i_0_ = i_1_ = 0;
        while (i_0_ < 512) {
            double d_2_ = (double) (i_1_ / 8) / 64.0 + 0.0078125;
            double d_3_ = (double) (i_1_ & 0x7) / 8.0 + 0.0625;
            int i_5_;
            int i_4_ = i_5_ = 0;
            while (i_4_ < 128) {
                double d_7_;
                double d_6_ = d_7_ = (double) i_5_ / 128.0;
                double d_8_ = d_7_;
                double d_9_ = d_7_;
                if (d_3_ != 0.0) {
                    double d_10_;
                    if (d_7_ < 0.5) {
                        d_10_ = d_7_ * (d_3_ + 1.0);
                    } else {
                        d_10_ = d_7_ + d_3_ - d_7_ * d_3_;
                    }
                    double d_11_ = d_7_ * 2.0 - d_10_;
                    double d_12_;
                    if ((d_12_ = d_2_ + 0.3333333333333333) > 1.0) {
                        d_12_--;
                    }
                    double d_13_ = d_2_;
                    double d_14_;
                    if ((d_14_ = d_2_ - 0.3333333333333333) < 0.0) {
                        d_14_++;
                    }
                    if (d_12_ * 6.0 < 1.0) {
                        d_6_ = d_11_ + (d_10_ - d_11_) * 6.0 * d_12_;
                    } else if (d_12_ * 2.0 < 1.0) {
                        d_6_ = d_10_;
                    } else if (d_12_ * 3.0 < 2.0) {
                        d_6_ = d_11_ + (d_10_ - d_11_)
                                * (0.6666666666666666 - d_12_) * 6.0;
                    } else {
                        d_6_ = d_11_;
                    }
                    if (d_13_ * 6.0 < 1.0) {
                        d_8_ = d_11_ + (d_10_ - d_11_) * 6.0 * d_13_;
                    } else if (d_13_ * 2.0 < 1.0) {
                        d_8_ = d_10_;
                    } else if (d_13_ * 3.0 < 2.0) {
                        d_8_ = d_11_ + (d_10_ - d_11_)
                                * (0.6666666666666666 - d_13_) * 6.0;
                    } else {
                        d_8_ = d_11_;
                    }
                    if (d_14_ * 6.0 < 1.0) {
                        d_9_ = d_11_ + (d_10_ - d_11_) * 6.0 * d_14_;
                    } else if (d_14_ * 2.0 < 1.0) {
                        d_9_ = d_10_;
                    } else if (d_14_ * 3.0 < 2.0) {
                        d_9_ = d_11_ + (d_10_ - d_11_)
                                * (0.6666666666666666 - d_14_) * 6.0;
                    } else {
                        d_9_ = d_11_;
                    }
                }
                int i_15_ = (int) (d_6_ * 256.0);
                int i_16_ = (int) (d_8_ * 256.0);
                int i_17_ = (int) (d_9_ * 256.0);
                int i_18_;
                if ((i_18_ = int_method53(i_18_ = (i_15_ << 16) + (i_16_ << 8)
                        + i_17_, d)) == 0) {
                    i_18_ = 1;
                }
                anIntArray_129[i++] = i_18_;
                i_4_ = ++i_5_;
            }
            i_0_ = ++i_1_;
        }
        int i_19_ = i_1_ = 0;
        while (i_19_ < 50) {
            i_19_ = ++i_1_;
        }
        int i_20_ = i_1_ = 0;
        while (i_20_ < 50) {
            void_method54(i_1_);
            i_20_ = ++i_1_;
        }
    }

    public static void void_method54(int i) {
        if (anIntArrayArray_127[i] != null) {
            anIntArrayArray_138[anInt_140++] = anIntArrayArray_127[i];
            anIntArrayArray_127[i] = null;
        }
    }

    public static void method55(int width, int height) {
        anIntArray_134 = new int[height];
        int i_38_;
        int i_37_ = i_38_ = 0;
        while (i_37_ < height) {
            anIntArray_134[i_38_] = width * i_38_;
            i_37_ = ++i_38_;
        }
        anInt_132 = width / 2;
        anInt_135 = height / 2 + height / 5;
    }

    private static void void_method56(int[] is, int[] is_39_, int i, int i_40_,
                                      int i_41_, int i_42_, int i_43_, int i_44_, int i_45_, int i_46_,
                                      int i_47_, int i_48_, int i_49_) {
        int i_50_ = 0;
        int i_51_ = 0;
        if (i_40_ < i_41_) {
            int i_52_;
            int i_53_;
            if (aBoolean_128) {
                i_53_ = (i_43_ - i_42_) / (i_41_ - i_40_);
                if (i_41_ > anInt_434) {
                    i_41_ = anInt_434;
                }
                if (i_40_ < 0) {
                    i_42_ -= i_40_ * i_53_;
                    i_40_ = 0;
                }
                if (i_40_ >= i_41_) {
                    return;
                }
                i_52_ = i_41_ - i_40_ >> 3;
                i_53_ <<= 12;
                i_42_ <<= 9;
            } else {
                if (i_41_ - i_40_ > 7) {
                    i_52_ = i_41_ - i_40_ >> 3;
                    i_53_ = (i_43_ - i_42_) * anIntArray_124[i_52_] >> 6;
                } else {
                    i_52_ = 0;
                    i_53_ = 0;
                }
                i_42_ <<= 9;
            }
            i += i_40_;
            if (aBoolean_123) {
                int i_54_ = 0;
                int i_55_ = 0;
                int i_56_ = i_40_ - anInt_132;
                i_44_ += (i_47_ >> 3) * i_56_;
                i_45_ += (i_48_ >> 3) * i_56_;
                int i_57_;
                if ((i_57_ = (i_46_ += (i_49_ >> 3) * i_56_) >> 12) != 0) {
                    i_50_ = i_44_ / i_57_;
                    i_51_ = i_45_ / i_57_;
                    if (i_50_ < 0) {
                        i_50_ = 0;
                    } else if (i_50_ > 4032) {
                        i_50_ = 4032;
                    }
                }
                i_44_ += i_47_;
                i_45_ += i_48_;
                if ((i_57_ = (i_46_ += i_49_) >> 12) != 0) {
                    i_54_ = i_44_ / i_57_;
                    i_55_ = i_45_ / i_57_;
                    if (i_54_ < 7) {
                        i_54_ = 7;
                    } else if (i_54_ > 4032) {
                        i_54_ = 4032;
                    }
                }
                int i_58_ = i_54_ - i_50_ >> 3;
                int i_59_ = i_55_ - i_51_ >> 3;
                i_50_ += (i_42_ & 0x600000) >> 3;
                int i_60_ = i_42_ >> 23;
                if (aBoolean_139) {
                    int i_61_ = i_52_;
                    for (; ; ) {
                        i_52_--;
                        if (i_61_ <= 0) {
                            break;
                        }
                        is[i++] = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        is[i++] = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        is[i++] = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        is[i++] = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        is[i++] = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        is[i++] = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        is[i++] = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        is[i++] = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_;
                        i_50_ = i_54_;
                        i_51_ = i_55_;
                        i_44_ += i_47_;
                        i_45_ += i_48_;
                        int i_62_;
                        if ((i_62_ = (i_46_ += i_49_) >> 12) != 0) {
                            i_54_ = i_44_ / i_62_;
                            i_55_ = i_45_ / i_62_;
                            if (i_54_ < 7) {
                                i_54_ = 7;
                            } else if (i_54_ > 4032) {
                                i_54_ = 4032;
                            }
                        }
                        i_58_ = i_54_ - i_50_ >> 3;
                        i_59_ = i_55_ - i_51_ >> 3;
                        i_42_ += i_53_;
                        i_50_ += (i_42_ & 0x600000) >> 3;
                        i_60_ = i_42_ >> 23;
                        i_61_ = i_52_;
                    }
                    int i_63_ = i_52_ = i_41_ - i_40_ & 0x7;
                    for (; ; ) {
                        i_52_--;
                        if (i_63_ <= 0) {
                            break;
                        }
                        is[i++] = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        i_63_ = i_52_;
                    }
                } else {
                    int i_64_ = i_52_;
                    for (; ; ) {
                        i_52_--;
                        if (i_64_ <= 0) {
                            break;
                        }
                        int i_65_;
                        if ((i_65_ = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_) != 0) {
                            is[i] = i_65_;
                        }
                        i++;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        if ((i_65_ = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_) != 0) {
                            is[i] = i_65_;
                        }
                        i++;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        if ((i_65_ = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_) != 0) {
                            is[i] = i_65_;
                        }
                        i++;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        if ((i_65_ = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_) != 0) {
                            is[i] = i_65_;
                        }
                        i++;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        if ((i_65_ = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_) != 0) {
                            is[i] = i_65_;
                        }
                        i++;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        if ((i_65_ = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_) != 0) {
                            is[i] = i_65_;
                        }
                        i++;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        if ((i_65_ = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_) != 0) {
                            is[i] = i_65_;
                        }
                        i++;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        if ((i_65_ = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_) != 0) {
                            is[i] = i_65_;
                        }
                        i++;
                        i_50_ = i_54_;
                        i_51_ = i_55_;
                        i_44_ += i_47_;
                        i_45_ += i_48_;
                        int i_66_;
                        if ((i_66_ = (i_46_ += i_49_) >> 12) != 0) {
                            i_54_ = i_44_ / i_66_;
                            i_55_ = i_45_ / i_66_;
                            if (i_54_ < 7) {
                                i_54_ = 7;
                            } else if (i_54_ > 4032) {
                                i_54_ = 4032;
                            }
                        }
                        i_58_ = i_54_ - i_50_ >> 3;
                        i_59_ = i_55_ - i_51_ >> 3;
                        i_42_ += i_53_;
                        i_50_ += (i_42_ & 0x600000) >> 3;
                        i_60_ = i_42_ >> 23;
                        i_64_ = i_52_;
                    }
                    int i_67_ = i_52_ = i_41_ - i_40_ & 0x7;
                    for (; ; ) {
                        i_52_--;
                        if (i_67_ <= 0) {
                            break;
                        }
                        int i_68_;
                        if ((i_68_ = is_39_[(i_51_ & 0xfc0) + (i_50_ >> 6)] >>> i_60_) != 0) {
                            is[i] = i_68_;
                        }
                        i++;
                        i_50_ += i_58_;
                        i_51_ += i_59_;
                        i_67_ = i_52_;
                    }
                }
            } else {
                int i_69_ = 0;
                int i_70_ = 0;
                int i_71_ = i_40_ - anInt_132;
                i_44_ += (i_47_ >> 3) * i_71_;
                i_45_ += (i_48_ >> 3) * i_71_;
                int i_72_;
                if ((i_72_ = (i_46_ += (i_49_ >> 3) * i_71_) >> 14) != 0) {
                    i_50_ = i_44_ / i_72_;
                    i_51_ = i_45_ / i_72_;
                    if (i_50_ < 0) {
                        i_50_ = 0;
                    } else if (i_50_ > 16256) {
                        i_50_ = 16256;
                    }
                }
                i_44_ += i_47_;
                i_45_ += i_48_;
                if ((i_72_ = (i_46_ += i_49_) >> 14) != 0) {
                    i_69_ = i_44_ / i_72_;
                    i_70_ = i_45_ / i_72_;
                    if (i_69_ < 7) {
                        i_69_ = 7;
                    } else if (i_69_ > 16256) {
                        i_69_ = 16256;
                    }
                }
                int i_73_ = i_69_ - i_50_ >> 3;
                int i_74_ = i_70_ - i_51_ >> 3;
                i_50_ += i_42_ & 0x600000;
                int i_75_ = i_42_ >> 23;
                if (aBoolean_139) {
                    int i_76_ = i_52_;
                    for (; ; ) {
                        i_52_--;
                        if (i_76_ <= 0) {
                            break;
                        }
                        is[i++] = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        is[i++] = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        is[i++] = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        is[i++] = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        is[i++] = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        is[i++] = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        is[i++] = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        is[i++] = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_;
                        i_50_ = i_69_;
                        i_51_ = i_70_;
                        i_44_ += i_47_;
                        i_45_ += i_48_;
                        int i_77_;
                        if ((i_77_ = (i_46_ += i_49_) >> 14) != 0) {
                            i_69_ = i_44_ / i_77_;
                            i_70_ = i_45_ / i_77_;
                            if (i_69_ < 7) {
                                i_69_ = 7;
                            } else if (i_69_ > 16256) {
                                i_69_ = 16256;
                            }
                        }
                        i_73_ = i_69_ - i_50_ >> 3;
                        i_74_ = i_70_ - i_51_ >> 3;
                        i_42_ += i_53_;
                        i_50_ += i_42_ & 0x600000;
                        i_75_ = i_42_ >> 23;
                        i_76_ = i_52_;
                    }
                    int i_78_ = i_52_ = i_41_ - i_40_ & 0x7;
                    for (; ; ) {
                        i_52_--;
                        if (i_78_ <= 0) {
                            break;
                        }
                        is[i++] = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        i_78_ = i_52_;
                    }
                } else {
                    int i_79_ = i_52_;
                    for (; ; ) {
                        i_52_--;
                        if (i_79_ <= 0) {
                            break;
                        }
                        int i_80_;
                        if ((i_80_ = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_) != 0) {
                            is[i] = i_80_;
                        }
                        i++;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        if ((i_80_ = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_) != 0) {
                            is[i] = i_80_;
                        }
                        i++;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        if ((i_80_ = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_) != 0) {
                            is[i] = i_80_;
                        }
                        i++;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        if ((i_80_ = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_) != 0) {
                            is[i] = i_80_;
                        }
                        i++;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        if ((i_80_ = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_) != 0) {
                            is[i] = i_80_;
                        }
                        i++;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        if ((i_80_ = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_) != 0) {
                            is[i] = i_80_;
                        }
                        i++;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        if ((i_80_ = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_) != 0) {
                            is[i] = i_80_;
                        }
                        i++;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        if ((i_80_ = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_) != 0) {
                            is[i] = i_80_;
                        }
                        i++;
                        i_50_ = i_69_;
                        i_51_ = i_70_;
                        i_44_ += i_47_;
                        i_45_ += i_48_;
                        int i_81_;
                        if ((i_81_ = (i_46_ += i_49_) >> 14) != 0) {
                            i_69_ = i_44_ / i_81_;
                            i_70_ = i_45_ / i_81_;
                            if (i_69_ < 7) {
                                i_69_ = 7;
                            } else if (i_69_ > 16256) {
                                i_69_ = 16256;
                            }
                        }
                        i_73_ = i_69_ - i_50_ >> 3;
                        i_74_ = i_70_ - i_51_ >> 3;
                        i_42_ += i_53_;
                        i_50_ += i_42_ & 0x600000;
                        i_75_ = i_42_ >> 23;
                        i_79_ = i_52_;
                    }
                    int i_83_;
                    int i_82_ = i_83_ = i_41_ - i_40_ & 0x7;
                    for (; ; ) {
                        i_83_--;
                        if (i_82_ <= 0) {
                            break;
                        }
                        int i_84_;
                        if ((i_84_ = is_39_[(i_51_ & 0x3f80) + (i_50_ >> 7)] >>> i_75_) != 0) {
                            is[i] = i_84_;
                        }
                        i++;
                        i_50_ += i_73_;
                        i_51_ += i_74_;
                        i_82_ = i_83_;
                    }
                }
            }
        }
    }

    private static void void_method57(int[] is, int i, int i_85_, int i_86_,
                                      int i_87_, int i_88_) {
        if (aBoolean_130) {
            int i_89_;
            int i_90_;
            if (aBoolean_128) {
                if (i_86_ - i_85_ > 3) {
                    i_90_ = (i_88_ - i_87_) / (i_86_ - i_85_);
                } else {
                    i_90_ = 0;
                }
                if (i_86_ > anInt_434) {
                    i_86_ = anInt_434;
                }
                if (i_85_ < 0) {
                    i_87_ -= i_85_ * i_90_;
                    i_85_ = 0;
                }
                if (i_85_ >= i_86_) {
                    return;
                }
                i += i_85_;
                i_89_ = i_86_ - i_85_ >> 2;
                i_90_ <<= 2;
            } else {
                if (i_85_ >= i_86_) {
                    return;
                }
                i += i_85_;
                if ((i_89_ = i_86_ - i_85_ >> 2) > 0) {
                    i_90_ = (i_88_ - i_87_) * anIntArray_124[i_89_] >> 15;
                } else {
                    i_90_ = 0;
                }
            }
            if (anInt_126 == 0) {
                for (i_89_--; i_89_ >= 0; i_89_--) {
                    int i_91_ = anIntArray_129[i_87_ >> 8];
                    i_87_ += i_90_;
                    is[i++] = i_91_;
                    is[i++] = i_91_;
                    is[i++] = i_91_;
                    is[i++] = i_91_;
                }
                if ((i_89_ = i_86_ - i_85_ & 0x3) > 0) {
                    int i_92_ = anIntArray_129[i_87_ >> 8];
                    do {
                        is[i++] = i_92_;
                    } while (--i_89_ > 0);
                }
            } else {
                int i_93_ = anInt_126;
                int i_94_ = 256 - anInt_126;
                while (--i_89_ >= 0) {
                    int i_95_ = anIntArray_129[i_87_ >> 8];
                    i_87_ += i_90_;
                    i_95_ = ((i_95_ & 0xff00ff) * i_94_ >> 8 & 0xff00ff)
                            + ((i_95_ & 0xff00) * i_94_ >> 8 & 0xff00);
                    if (aBoolean_125) {
                        is[i] = i_95_
                                + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                        i++;
                        is[i] = i_95_
                                + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                        i++;
                        is[i] = i_95_
                                + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                        i++;
                        is[i] = i_95_
                                + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                        i++;
                    } else {
                        is[i++] = i_95_
                                + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                        is[i++] = i_95_
                                + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                        is[i++] = i_95_
                                + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                        is[i++] = i_95_
                                + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                    }
                }
                if ((i_89_ = i_86_ - i_85_ & 0x3) > 0) {
                    int i_96_ = (((i_96_ = anIntArray_129[i_87_ >> 8]) & 0xff00ff)
                            * i_94_ >> 8 & 0xff00ff)
                            + ((i_96_ & 0xff00) * i_94_ >> 8 & 0xff00);
                    if (aBoolean_125) {
                        do {
                            is[i] = i_96_
                                    + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                    + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                            i++;
                        } while (--i_89_ > 0);
                    } else {
                        do {
                            is[i++] = i_96_
                                    + ((is[i] & 0xff00ff) * i_93_ >> 8 & 0xff00ff)
                                    + ((is[i] & 0xff00) * i_93_ >> 8 & 0xff00);
                        } while (--i_89_ > 0);
                    }
                }
            }
        } else if (i_85_ < i_86_) {
            int i_97_ = (i_88_ - i_87_) / (i_86_ - i_85_);
            if (aBoolean_128) {
                if (i_86_ > anInt_434) {
                    i_86_ = anInt_434;
                }
                if (i_85_ < 0) {
                    i_87_ -= i_85_ * i_97_;
                    i_85_ = 0;
                }
                if (i_85_ >= i_86_) {
                    return;
                }
            }
            i += i_85_;
            int i_98_ = i_86_ - i_85_;
            if (anInt_126 == 0) {
                do {
                    is[i++] = anIntArray_129[i_87_ >> 8];
                    i_87_ += i_97_;
                } while (--i_98_ > 0);
            } else {
                int i_99_ = anInt_126;
                int i_100_ = 256 - anInt_126;
                do {
                    int i_101_ = anIntArray_129[i_87_ >> 8];
                    i_87_ += i_97_;
                    i_101_ = ((i_101_ & 0xff00ff) * i_100_ >> 8 & 0xff00ff)
                            + ((i_101_ & 0xff00) * i_100_ >> 8 & 0xff00);
                    if (aBoolean_125) {
                        is[i] = i_101_
                                + ((is[i] & 0xff00ff) * i_99_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_99_ >> 8 & 0xff00);
                        i++;
                    } else {
                        is[i++] = i_101_
                                + ((is[i] & 0xff00ff) * i_99_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_99_ >> 8 & 0xff00);
                    }
                } while (--i_98_ > 0);
            }
        }
    }

    public static void void_method58(int i, int i_102_, int i_103_, int i_104_,
                                     int i_105_, int i_106_, int i_107_, int i_108_, int i_109_) {
        int i_110_ = 0;
        int i_111_ = 0;
        if (i_102_ != i) {
            i_110_ = (i_105_ - i_104_ << 16) / (i_102_ - i);
            i_111_ = (i_108_ - i_107_ << 15) / (i_102_ - i);
        }
        int i_112_ = 0;
        int i_113_ = 0;
        if (i_103_ != i_102_) {
            i_112_ = (i_106_ - i_105_ << 16) / (i_103_ - i_102_);
            i_113_ = (i_109_ - i_108_ << 15) / (i_103_ - i_102_);
        }
        int i_114_ = 0;
        int i_115_ = 0;
        if (i_103_ != i) {
            i_114_ = (i_104_ - i_106_ << 16) / (i - i_103_);
            i_115_ = (i_107_ - i_109_ << 15) / (i - i_103_);
        }
        if (i <= i_102_ && i <= i_103_) {
            if (i < anInt_429) {
                if (i_102_ > anInt_429) {
                    i_102_ = anInt_429;
                }
                if (i_103_ > anInt_429) {
                    i_103_ = anInt_429;
                }
                if (i_102_ < i_103_) {
                    i_106_ = i_104_ <<= 16;
                    i_109_ = i_107_ <<= 15;
                    if (i < 0) {
                        i_106_ -= i_114_ * i;
                        i_104_ -= i_110_ * i;
                        i_109_ -= i_115_ * i;
                        i_107_ -= i_111_ * i;
                        i = 0;
                    }
                    i_105_ <<= 16;
                    i_108_ <<= 15;
                    if (i_102_ < 0) {
                        i_105_ -= i_112_ * i_102_;
                        i_108_ -= i_113_ * i_102_;
                        i_102_ = 0;
                    }
                    if (i != i_102_ && i_114_ < i_110_ || i == i_102_
                            && i_114_ > i_112_) {
                        i_103_ -= i_102_;
                        i_102_ -= i;
                        i = anIntArray_134[i];
                        for (i_102_--; i_102_ >= 0; i_102_--) {
                            void_method57(pixels, i, i_106_ >> 16,
                                    i_104_ >> 16, i_109_ >> 7, i_107_ >> 7);
                            i_106_ += i_114_;
                            i_104_ += i_110_;
                            i_109_ += i_115_;
                            i_107_ += i_111_;
                            i += width;
                        }
                        for (i_103_--; i_103_ >= 0; i_103_--) {
                            void_method57(pixels, i, i_106_ >> 16,
                                    i_105_ >> 16, i_109_ >> 7, i_108_ >> 7);
                            i_106_ += i_114_;
                            i_105_ += i_112_;
                            i_109_ += i_115_;
                            i_108_ += i_113_;
                            i += width;
                        }
                    } else {
                        i_103_ -= i_102_;
                        i_102_ -= i;
                        i = anIntArray_134[i];
                        for (i_102_--; i_102_ >= 0; i_102_--) {
                            void_method57(pixels, i, i_104_ >> 16,
                                    i_106_ >> 16, i_107_ >> 7, i_109_ >> 7);
                            i_106_ += i_114_;
                            i_104_ += i_110_;
                            i_109_ += i_115_;
                            i_107_ += i_111_;
                            i += width;
                        }
                        for (i_103_--; i_103_ >= 0; i_103_--) {
                            void_method57(pixels, i, i_105_ >> 16,
                                    i_106_ >> 16, i_108_ >> 7, i_109_ >> 7);
                            i_106_ += i_114_;
                            i_105_ += i_112_;
                            i_109_ += i_115_;
                            i_108_ += i_113_;
                            i += width;
                        }
                    }
                } else {
                    i_105_ = i_104_ <<= 16;
                    i_108_ = i_107_ <<= 15;
                    if (i < 0) {
                        i_105_ -= i_114_ * i;
                        i_104_ -= i_110_ * i;
                        i_108_ -= i_115_ * i;
                        i_107_ -= i_111_ * i;
                        i = 0;
                    }
                    i_106_ <<= 16;
                    i_109_ <<= 15;
                    if (i_103_ < 0) {
                        i_106_ -= i_112_ * i_103_;
                        i_109_ -= i_113_ * i_103_;
                        i_103_ = 0;
                    }
                    if (i != i_103_ && i_114_ < i_110_ || i == i_103_
                            && i_112_ > i_110_) {
                        i_102_ -= i_103_;
                        i_103_ -= i;
                        i = anIntArray_134[i];
                        for (i_103_--; i_103_ >= 0; i_103_--) {
                            void_method57(pixels, i, i_105_ >> 16,
                                    i_104_ >> 16, i_108_ >> 7, i_107_ >> 7);
                            i_105_ += i_114_;
                            i_104_ += i_110_;
                            i_108_ += i_115_;
                            i_107_ += i_111_;
                            i += width;
                        }
                        for (i_102_--; i_102_ >= 0; i_102_--) {
                            void_method57(pixels, i, i_106_ >> 16,
                                    i_104_ >> 16, i_109_ >> 7, i_107_ >> 7);
                            i_106_ += i_112_;
                            i_104_ += i_110_;
                            i_109_ += i_113_;
                            i_107_ += i_111_;
                            i += width;
                        }
                    } else {
                        i_102_ -= i_103_;
                        i_103_ -= i;
                        i = anIntArray_134[i];
                        for (i_103_--; i_103_ >= 0; i_103_--) {
                            void_method57(pixels, i, i_104_ >> 16,
                                    i_105_ >> 16, i_107_ >> 7, i_108_ >> 7);
                            i_105_ += i_114_;
                            i_104_ += i_110_;
                            i_108_ += i_115_;
                            i_107_ += i_111_;
                            i += width;
                        }
                        for (i_102_--; i_102_ >= 0; i_102_--) {
                            void_method57(pixels, i, i_104_ >> 16,
                                    i_106_ >> 16, i_107_ >> 7, i_109_ >> 7);
                            i_106_ += i_112_;
                            i_104_ += i_110_;
                            i_109_ += i_113_;
                            i_107_ += i_111_;
                            i += width;
                        }
                    }
                }
            }
        } else if (i_102_ <= i_103_) {
            if (i_102_ < anInt_429) {
                if (i_103_ > anInt_429) {
                    i_103_ = anInt_429;
                }
                if (i > anInt_429) {
                    i = anInt_429;
                }
                if (i_103_ < i) {
                    i_104_ = i_105_ <<= 16;
                    i_107_ = i_108_ <<= 15;
                    if (i_102_ < 0) {
                        i_104_ -= i_110_ * i_102_;
                        i_105_ -= i_112_ * i_102_;
                        i_107_ -= i_111_ * i_102_;
                        i_108_ -= i_113_ * i_102_;
                        i_102_ = 0;
                    }
                    i_106_ <<= 16;
                    i_109_ <<= 15;
                    if (i_103_ < 0) {
                        i_106_ -= i_114_ * i_103_;
                        i_109_ -= i_115_ * i_103_;
                        i_103_ = 0;
                    }
                    if (i_102_ != i_103_ && i_110_ < i_112_ || i_102_ == i_103_
                            && i_110_ > i_114_) {
                        i -= i_103_;
                        i_103_ -= i_102_;
                        i_102_ = anIntArray_134[i_102_];
                        for (i_103_--; i_103_ >= 0; i_103_--) {
                            void_method57(pixels, i_102_,
                                    i_104_ >> 16, i_105_ >> 16, i_107_ >> 7,
                                    i_108_ >> 7);
                            i_104_ += i_110_;
                            i_105_ += i_112_;
                            i_107_ += i_111_;
                            i_108_ += i_113_;
                            i_102_ += width;
                        }
                        for (i--; i >= 0; i--) {
                            void_method57(pixels, i_102_,
                                    i_104_ >> 16, i_106_ >> 16, i_107_ >> 7,
                                    i_109_ >> 7);
                            i_104_ += i_110_;
                            i_106_ += i_114_;
                            i_107_ += i_111_;
                            i_109_ += i_115_;
                            i_102_ += width;
                        }
                    } else {
                        i -= i_103_;
                        i_103_ -= i_102_;
                        i_102_ = anIntArray_134[i_102_];
                        for (i_103_--; i_103_ >= 0; i_103_--) {
                            void_method57(pixels, i_102_,
                                    i_105_ >> 16, i_104_ >> 16, i_108_ >> 7,
                                    i_107_ >> 7);
                            i_104_ += i_110_;
                            i_105_ += i_112_;
                            i_107_ += i_111_;
                            i_108_ += i_113_;
                            i_102_ += width;
                        }
                        for (i--; i >= 0; i--) {
                            void_method57(pixels, i_102_,
                                    i_106_ >> 16, i_104_ >> 16, i_109_ >> 7,
                                    i_107_ >> 7);
                            i_104_ += i_110_;
                            i_106_ += i_114_;
                            i_107_ += i_111_;
                            i_109_ += i_115_;
                            i_102_ += width;
                        }
                    }
                } else {
                    i_106_ = i_105_ <<= 16;
                    i_109_ = i_108_ <<= 15;
                    if (i_102_ < 0) {
                        i_106_ -= i_110_ * i_102_;
                        i_105_ -= i_112_ * i_102_;
                        i_109_ -= i_111_ * i_102_;
                        i_108_ -= i_113_ * i_102_;
                        i_102_ = 0;
                    }
                    i_104_ <<= 16;
                    i_107_ <<= 15;
                    if (i < 0) {
                        i_104_ -= i_114_ * i;
                        i_107_ -= i_115_ * i;
                        i = 0;
                    }
                    if (i_110_ < i_112_) {
                        i_103_ -= i;
                        i -= i_102_;
                        i_102_ = anIntArray_134[i_102_];
                        for (i--; i >= 0; i--) {
                            void_method57(pixels, i_102_,
                                    i_106_ >> 16, i_105_ >> 16, i_109_ >> 7,
                                    i_108_ >> 7);
                            i_106_ += i_110_;
                            i_105_ += i_112_;
                            i_109_ += i_111_;
                            i_108_ += i_113_;
                            i_102_ += width;
                        }
                        for (i_103_--; i_103_ >= 0; i_103_--) {
                            void_method57(pixels, i_102_,
                                    i_104_ >> 16, i_105_ >> 16, i_107_ >> 7,
                                    i_108_ >> 7);
                            i_104_ += i_114_;
                            i_105_ += i_112_;
                            i_107_ += i_115_;
                            i_108_ += i_113_;
                            i_102_ += width;
                        }
                    } else {
                        i_103_ -= i;
                        i -= i_102_;
                        i_102_ = anIntArray_134[i_102_];
                        for (i--; i >= 0; i--) {
                            void_method57(pixels, i_102_,
                                    i_105_ >> 16, i_106_ >> 16, i_108_ >> 7,
                                    i_109_ >> 7);
                            i_106_ += i_110_;
                            i_105_ += i_112_;
                            i_109_ += i_111_;
                            i_108_ += i_113_;
                            i_102_ += width;
                        }
                        for (i_103_--; i_103_ >= 0; i_103_--) {
                            void_method57(pixels, i_102_,
                                    i_105_ >> 16, i_104_ >> 16, i_108_ >> 7,
                                    i_107_ >> 7);
                            i_104_ += i_114_;
                            i_105_ += i_112_;
                            i_107_ += i_115_;
                            i_108_ += i_113_;
                            i_102_ += width;
                        }
                    }
                }
            }
        } else if (i_103_ < anInt_429) {
            if (i > anInt_429) {
                i = anInt_429;
            }
            if (i_102_ > anInt_429) {
                i_102_ = anInt_429;
            }
            if (i < i_102_) {
                i_105_ = i_106_ <<= 16;
                i_108_ = i_109_ <<= 15;
                if (i_103_ < 0) {
                    i_105_ -= i_112_ * i_103_;
                    i_106_ -= i_114_ * i_103_;
                    i_108_ -= i_113_ * i_103_;
                    i_109_ -= i_115_ * i_103_;
                    i_103_ = 0;
                }
                i_104_ <<= 16;
                i_107_ <<= 15;
                if (i < 0) {
                    i_104_ -= i_110_ * i;
                    i_107_ -= i_111_ * i;
                    i = 0;
                }
                if (i_112_ < i_114_) {
                    i_102_ -= i;
                    i -= i_103_;
                    i_103_ = anIntArray_134[i_103_];
                    for (i--; i >= 0; i--) {
                        void_method57(pixels, i_103_, i_105_ >> 16,
                                i_106_ >> 16, i_108_ >> 7, i_109_ >> 7);
                        i_105_ += i_112_;
                        i_106_ += i_114_;
                        i_108_ += i_113_;
                        i_109_ += i_115_;
                        i_103_ += width;
                    }
                    for (i_102_--; i_102_ >= 0; i_102_--) {
                        void_method57(pixels, i_103_, i_105_ >> 16,
                                i_104_ >> 16, i_108_ >> 7, i_107_ >> 7);
                        i_105_ += i_112_;
                        i_104_ += i_110_;
                        i_108_ += i_113_;
                        i_107_ += i_111_;
                        i_103_ += width;
                    }
                } else {
                    i_102_ -= i;
                    i -= i_103_;
                    i_103_ = anIntArray_134[i_103_];
                    for (i--; i >= 0; i--) {
                        void_method57(pixels, i_103_, i_106_ >> 16,
                                i_105_ >> 16, i_109_ >> 7, i_108_ >> 7);
                        i_105_ += i_112_;
                        i_106_ += i_114_;
                        i_108_ += i_113_;
                        i_109_ += i_115_;
                        i_103_ += width;
                    }
                    for (i_102_--; i_102_ >= 0; i_102_--) {
                        void_method57(pixels, i_103_, i_104_ >> 16,
                                i_105_ >> 16, i_107_ >> 7, i_108_ >> 7);
                        i_105_ += i_112_;
                        i_104_ += i_110_;
                        i_108_ += i_113_;
                        i_107_ += i_111_;
                        i_103_ += width;
                    }
                }
            } else {
                i_104_ = i_106_ <<= 16;
                i_107_ = i_109_ <<= 15;
                if (i_103_ < 0) {
                    i_104_ -= i_112_ * i_103_;
                    i_106_ -= i_114_ * i_103_;
                    i_107_ -= i_113_ * i_103_;
                    i_109_ -= i_115_ * i_103_;
                    i_103_ = 0;
                }
                i_105_ <<= 16;
                i_108_ <<= 15;
                if (i_102_ < 0) {
                    i_105_ -= i_110_ * i_102_;
                    i_108_ -= i_111_ * i_102_;
                    i_102_ = 0;
                }
                if (i_112_ < i_114_) {
                    i -= i_102_;
                    i_102_ -= i_103_;
                    i_103_ = anIntArray_134[i_103_];
                    for (i_102_--; i_102_ >= 0; i_102_--) {
                        void_method57(pixels, i_103_, i_104_ >> 16,
                                i_106_ >> 16, i_107_ >> 7, i_109_ >> 7);
                        i_104_ += i_112_;
                        i_106_ += i_114_;
                        i_107_ += i_113_;
                        i_109_ += i_115_;
                        i_103_ += width;
                    }
                    for (i--; i >= 0; i--) {
                        void_method57(pixels, i_103_, i_105_ >> 16,
                                i_106_ >> 16, i_108_ >> 7, i_109_ >> 7);
                        i_105_ += i_110_;
                        i_106_ += i_114_;
                        i_108_ += i_111_;
                        i_109_ += i_115_;
                        i_103_ += width;
                    }
                } else {
                    i -= i_102_;
                    i_102_ -= i_103_;
                    i_103_ = anIntArray_134[i_103_];
                    for (i_102_--; i_102_ >= 0; i_102_--) {
                        void_method57(pixels, i_103_, i_106_ >> 16,
                                i_104_ >> 16, i_109_ >> 7, i_107_ >> 7);
                        i_104_ += i_112_;
                        i_106_ += i_114_;
                        i_107_ += i_113_;
                        i_109_ += i_115_;
                        i_103_ += width;
                    }
                    for (i--; i >= 0; i--) {
                        void_method57(pixels, i_103_, i_106_ >> 16,
                                i_105_ >> 16, i_109_ >> 7, i_108_ >> 7);
                        i_105_ += i_110_;
                        i_106_ += i_114_;
                        i_108_ += i_111_;
                        i_109_ += i_115_;
                        i_103_ += width;
                    }
                }
            }
        }
    }

    public static void void_method59(int i, int i_116_, int i_117_, int i_118_,
                                     int i_119_, int i_120_, int i_121_, int i_122_, int i_123_,
                                     int i_124_, int i_125_, int i_126_, int i_127_, int i_128_,
                                     int i_129_, int i_130_, int i_131_, int i_132_, int i_133_) {
        int[] is = method52(i_133_);
        aBoolean_139 = !aBooleanArray_142[i_133_];
        i_125_ = i_124_ - i_125_;
        i_128_ = i_127_ - i_128_;
        i_131_ = i_130_ - i_131_;
        i_126_ -= i_124_;
        i_129_ -= i_127_;
        i_132_ -= i_130_;
        int i_134_ = i_126_ * i_127_ - i_129_ * i_124_ << 14;
        int i_135_ = i_129_ * i_130_ - i_132_ * i_127_ << 8;
        int i_136_ = i_132_ * i_124_ - i_126_ * i_130_ << 5;
        int i_137_ = i_125_ * i_127_ - i_128_ * i_124_ << 14;
        int i_138_ = i_128_ * i_130_ - i_131_ * i_127_ << 8;
        int i_139_ = i_131_ * i_124_ - i_125_ * i_130_ << 5;
        int i_140_ = i_128_ * i_126_ - i_125_ * i_129_ << 14;
        int i_141_ = i_131_ * i_129_ - i_128_ * i_132_ << 8;
        int i_142_ = i_125_ * i_132_ - i_131_ * i_126_ << 5;
        int i_143_ = 0;
        int i_144_ = 0;
        if (i_116_ != i) {
            i_143_ = (i_119_ - i_118_ << 16) / (i_116_ - i);
            i_144_ = (i_122_ - i_121_ << 16) / (i_116_ - i);
        }
        int i_145_ = 0;
        int i_146_ = 0;
        if (i_117_ != i_116_) {
            i_145_ = (i_120_ - i_119_ << 16) / (i_117_ - i_116_);
            i_146_ = (i_123_ - i_122_ << 16) / (i_117_ - i_116_);
        }
        int i_147_ = 0;
        int i_148_ = 0;
        if (i_117_ != i) {
            i_147_ = (i_118_ - i_120_ << 16) / (i - i_117_);
            i_148_ = (i_121_ - i_123_ << 16) / (i - i_117_);
        }
        if (i <= i_116_ && i <= i_117_) {
            if (i < anInt_429) {
                if (i_116_ > anInt_429) {
                    i_116_ = anInt_429;
                }
                if (i_117_ > anInt_429) {
                    i_117_ = anInt_429;
                }
                if (i_116_ < i_117_) {
                    i_120_ = i_118_ <<= 16;
                    i_123_ = i_121_ <<= 16;
                    if (i < 0) {
                        i_120_ -= i_147_ * i;
                        i_118_ -= i_143_ * i;
                        i_123_ -= i_148_ * i;
                        i_121_ -= i_144_ * i;
                        i = 0;
                    }
                    i_119_ <<= 16;
                    i_122_ <<= 16;
                    if (i_116_ < 0) {
                        i_119_ -= i_145_ * i_116_;
                        i_122_ -= i_146_ * i_116_;
                        i_116_ = 0;
                    }
                    int i_149_ = i - anInt_135;
                    i_134_ += i_136_ * i_149_;
                    i_137_ += i_139_ * i_149_;
                    i_140_ += i_142_ * i_149_;
                    if (i != i_116_ && i_147_ < i_143_ || i == i_116_
                            && i_147_ > i_145_) {
                        i_117_ -= i_116_;
                        i_116_ -= i;
                        i = anIntArray_134[i];
                        for (i_116_--; i_116_ >= 0; i_116_--) {
                            void_method56(pixels, is, i,
                                    i_120_ >> 16, i_118_ >> 16, i_123_ >> 8,
                                    i_121_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_120_ += i_147_;
                            i_118_ += i_143_;
                            i_123_ += i_148_;
                            i_121_ += i_144_;
                            i += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                        for (i_117_--; i_117_ >= 0; i_117_--) {
                            void_method56(pixels, is, i,
                                    i_120_ >> 16, i_119_ >> 16, i_123_ >> 8,
                                    i_122_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_120_ += i_147_;
                            i_119_ += i_145_;
                            i_123_ += i_148_;
                            i_122_ += i_146_;
                            i += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                    } else {
                        i_117_ -= i_116_;
                        i_116_ -= i;
                        i = anIntArray_134[i];
                        for (i_116_--; i_116_ >= 0; i_116_--) {
                            void_method56(pixels, is, i,
                                    i_118_ >> 16, i_120_ >> 16, i_121_ >> 8,
                                    i_123_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_120_ += i_147_;
                            i_118_ += i_143_;
                            i_123_ += i_148_;
                            i_121_ += i_144_;
                            i += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                        for (i_117_--; i_117_ >= 0; i_117_--) {
                            void_method56(pixels, is, i,
                                    i_119_ >> 16, i_120_ >> 16, i_122_ >> 8,
                                    i_123_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_120_ += i_147_;
                            i_119_ += i_145_;
                            i_123_ += i_148_;
                            i_122_ += i_146_;
                            i += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                    }
                } else {
                    i_119_ = i_118_ <<= 16;
                    i_122_ = i_121_ <<= 16;
                    if (i < 0) {
                        i_119_ -= i_147_ * i;
                        i_118_ -= i_143_ * i;
                        i_122_ -= i_148_ * i;
                        i_121_ -= i_144_ * i;
                        i = 0;
                    }
                    i_120_ <<= 16;
                    i_123_ <<= 16;
                    if (i_117_ < 0) {
                        i_120_ -= i_145_ * i_117_;
                        i_123_ -= i_146_ * i_117_;
                        i_117_ = 0;
                    }
                    int i_150_ = i - anInt_135;
                    i_134_ += i_136_ * i_150_;
                    i_137_ += i_139_ * i_150_;
                    i_140_ += i_142_ * i_150_;
                    if (i != i_117_ && i_147_ < i_143_ || i == i_117_
                            && i_145_ > i_143_) {
                        i_116_ -= i_117_;
                        i_117_ -= i;
                        i = anIntArray_134[i];
                        for (i_117_--; i_117_ >= 0; i_117_--) {
                            void_method56(pixels, is, i,
                                    i_119_ >> 16, i_118_ >> 16, i_122_ >> 8,
                                    i_121_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_119_ += i_147_;
                            i_118_ += i_143_;
                            i_122_ += i_148_;
                            i_121_ += i_144_;
                            i += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                        for (i_116_--; i_116_ >= 0; i_116_--) {
                            void_method56(pixels, is, i,
                                    i_120_ >> 16, i_118_ >> 16, i_123_ >> 8,
                                    i_121_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_120_ += i_145_;
                            i_118_ += i_143_;
                            i_123_ += i_146_;
                            i_121_ += i_144_;
                            i += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                    } else {
                        i_116_ -= i_117_;
                        i_117_ -= i;
                        i = anIntArray_134[i];
                        for (i_117_--; i_117_ >= 0; i_117_--) {
                            void_method56(pixels, is, i,
                                    i_118_ >> 16, i_119_ >> 16, i_121_ >> 8,
                                    i_122_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_119_ += i_147_;
                            i_118_ += i_143_;
                            i_122_ += i_148_;
                            i_121_ += i_144_;
                            i += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                        for (i_116_--; i_116_ >= 0; i_116_--) {
                            void_method56(pixels, is, i,
                                    i_118_ >> 16, i_120_ >> 16, i_121_ >> 8,
                                    i_123_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_120_ += i_145_;
                            i_118_ += i_143_;
                            i_123_ += i_146_;
                            i_121_ += i_144_;
                            i += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                    }
                }
            }
        } else if (i_116_ <= i_117_) {
            if (i_116_ < anInt_429) {
                if (i_117_ > anInt_429) {
                    i_117_ = anInt_429;
                }
                if (i > anInt_429) {
                    i = anInt_429;
                }
                if (i_117_ < i) {
                    i_118_ = i_119_ <<= 16;
                    i_121_ = i_122_ <<= 16;
                    if (i_116_ < 0) {
                        i_118_ -= i_143_ * i_116_;
                        i_119_ -= i_145_ * i_116_;
                        i_121_ -= i_144_ * i_116_;
                        i_122_ -= i_146_ * i_116_;
                        i_116_ = 0;
                    }
                    i_120_ <<= 16;
                    i_123_ <<= 16;
                    if (i_117_ < 0) {
                        i_120_ -= i_147_ * i_117_;
                        i_123_ -= i_148_ * i_117_;
                        i_117_ = 0;
                    }
                    int i_151_ = i_116_ - anInt_135;
                    i_134_ += i_136_ * i_151_;
                    i_137_ += i_139_ * i_151_;
                    i_140_ += i_142_ * i_151_;
                    if (i_116_ != i_117_ && i_143_ < i_145_ || i_116_ == i_117_
                            && i_143_ > i_147_) {
                        i -= i_117_;
                        i_117_ -= i_116_;
                        i_116_ = anIntArray_134[i_116_];
                        for (i_117_--; i_117_ >= 0; i_117_--) {
                            void_method56(pixels, is, i_116_,
                                    i_118_ >> 16, i_119_ >> 16, i_121_ >> 8,
                                    i_122_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_118_ += i_143_;
                            i_119_ += i_145_;
                            i_121_ += i_144_;
                            i_122_ += i_146_;
                            i_116_ += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                        for (i--; i >= 0; i--) {
                            void_method56(pixels, is, i_116_,
                                    i_118_ >> 16, i_120_ >> 16, i_121_ >> 8,
                                    i_123_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_118_ += i_143_;
                            i_120_ += i_147_;
                            i_121_ += i_144_;
                            i_123_ += i_148_;
                            i_116_ += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                    } else {
                        i -= i_117_;
                        i_117_ -= i_116_;
                        i_116_ = anIntArray_134[i_116_];
                        for (i_117_--; i_117_ >= 0; i_117_--) {
                            void_method56(pixels, is, i_116_,
                                    i_119_ >> 16, i_118_ >> 16, i_122_ >> 8,
                                    i_121_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_118_ += i_143_;
                            i_119_ += i_145_;
                            i_121_ += i_144_;
                            i_122_ += i_146_;
                            i_116_ += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                        for (i--; i >= 0; i--) {
                            void_method56(pixels, is, i_116_,
                                    i_120_ >> 16, i_118_ >> 16, i_123_ >> 8,
                                    i_121_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_118_ += i_143_;
                            i_120_ += i_147_;
                            i_121_ += i_144_;
                            i_123_ += i_148_;
                            i_116_ += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                    }
                } else {
                    i_120_ = i_119_ <<= 16;
                    i_123_ = i_122_ <<= 16;
                    if (i_116_ < 0) {
                        i_120_ -= i_143_ * i_116_;
                        i_119_ -= i_145_ * i_116_;
                        i_123_ -= i_144_ * i_116_;
                        i_122_ -= i_146_ * i_116_;
                        i_116_ = 0;
                    }
                    i_118_ <<= 16;
                    i_121_ <<= 16;
                    if (i < 0) {
                        i_118_ -= i_147_ * i;
                        i_121_ -= i_148_ * i;
                        i = 0;
                    }
                    int i_152_ = i_116_ - anInt_135;
                    i_134_ += i_136_ * i_152_;
                    i_137_ += i_139_ * i_152_;
                    i_140_ += i_142_ * i_152_;
                    if (i_143_ < i_145_) {
                        i_117_ -= i;
                        i -= i_116_;
                        i_116_ = anIntArray_134[i_116_];
                        for (i--; i >= 0; i--) {
                            void_method56(pixels, is, i_116_,
                                    i_120_ >> 16, i_119_ >> 16, i_123_ >> 8,
                                    i_122_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_120_ += i_143_;
                            i_119_ += i_145_;
                            i_123_ += i_144_;
                            i_122_ += i_146_;
                            i_116_ += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                        for (i_117_--; i_117_ >= 0; i_117_--) {
                            void_method56(pixels, is, i_116_,
                                    i_118_ >> 16, i_119_ >> 16, i_121_ >> 8,
                                    i_122_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_118_ += i_147_;
                            i_119_ += i_145_;
                            i_121_ += i_148_;
                            i_122_ += i_146_;
                            i_116_ += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                    } else {
                        i_117_ -= i;
                        i -= i_116_;
                        i_116_ = anIntArray_134[i_116_];
                        for (i--; i >= 0; i--) {
                            void_method56(pixels, is, i_116_,
                                    i_119_ >> 16, i_120_ >> 16, i_122_ >> 8,
                                    i_123_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_120_ += i_143_;
                            i_119_ += i_145_;
                            i_123_ += i_144_;
                            i_122_ += i_146_;
                            i_116_ += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                        for (i_117_--; i_117_ >= 0; i_117_--) {
                            void_method56(pixels, is, i_116_,
                                    i_119_ >> 16, i_118_ >> 16, i_122_ >> 8,
                                    i_121_ >> 8, i_134_, i_137_, i_140_,
                                    i_135_, i_138_, i_141_);
                            i_118_ += i_147_;
                            i_119_ += i_145_;
                            i_121_ += i_148_;
                            i_122_ += i_146_;
                            i_116_ += width;
                            i_134_ += i_136_;
                            i_137_ += i_139_;
                            i_140_ += i_142_;
                        }
                    }
                }
            }
        } else if (i_117_ < anInt_429) {
            if (i > anInt_429) {
                i = anInt_429;
            }
            if (i_116_ > anInt_429) {
                i_116_ = anInt_429;
            }
            if (i < i_116_) {
                i_119_ = i_120_ <<= 16;
                i_122_ = i_123_ <<= 16;
                if (i_117_ < 0) {
                    i_119_ -= i_145_ * i_117_;
                    i_120_ -= i_147_ * i_117_;
                    i_122_ -= i_146_ * i_117_;
                    i_123_ -= i_148_ * i_117_;
                    i_117_ = 0;
                }
                i_118_ <<= 16;
                i_121_ <<= 16;
                if (i < 0) {
                    i_118_ -= i_143_ * i;
                    i_121_ -= i_144_ * i;
                    i = 0;
                }
                int i_153_ = i_117_ - anInt_135;
                i_134_ += i_136_ * i_153_;
                i_137_ += i_139_ * i_153_;
                i_140_ += i_142_ * i_153_;
                if (i_145_ < i_147_) {
                    i_116_ -= i;
                    i -= i_117_;
                    i_117_ = anIntArray_134[i_117_];
                    for (i--; i >= 0; i--) {
                        void_method56(pixels, is, i_117_,
                                i_119_ >> 16, i_120_ >> 16, i_122_ >> 8,
                                i_123_ >> 8, i_134_, i_137_, i_140_, i_135_,
                                i_138_, i_141_);
                        i_119_ += i_145_;
                        i_120_ += i_147_;
                        i_122_ += i_146_;
                        i_123_ += i_148_;
                        i_117_ += width;
                        i_134_ += i_136_;
                        i_137_ += i_139_;
                        i_140_ += i_142_;
                    }
                    for (i_116_--; i_116_ >= 0; i_116_--) {
                        void_method56(pixels, is, i_117_,
                                i_119_ >> 16, i_118_ >> 16, i_122_ >> 8,
                                i_121_ >> 8, i_134_, i_137_, i_140_, i_135_,
                                i_138_, i_141_);
                        i_119_ += i_145_;
                        i_118_ += i_143_;
                        i_122_ += i_146_;
                        i_121_ += i_144_;
                        i_117_ += width;
                        i_134_ += i_136_;
                        i_137_ += i_139_;
                        i_140_ += i_142_;
                    }
                } else {
                    i_116_ -= i;
                    i -= i_117_;
                    i_117_ = anIntArray_134[i_117_];
                    for (i--; i >= 0; i--) {
                        void_method56(pixels, is, i_117_,
                                i_120_ >> 16, i_119_ >> 16, i_123_ >> 8,
                                i_122_ >> 8, i_134_, i_137_, i_140_, i_135_,
                                i_138_, i_141_);
                        i_119_ += i_145_;
                        i_120_ += i_147_;
                        i_122_ += i_146_;
                        i_123_ += i_148_;
                        i_117_ += width;
                        i_134_ += i_136_;
                        i_137_ += i_139_;
                        i_140_ += i_142_;
                    }
                    for (i_116_--; i_116_ >= 0; i_116_--) {
                        void_method56(pixels, is, i_117_,
                                i_118_ >> 16, i_119_ >> 16, i_121_ >> 8,
                                i_122_ >> 8, i_134_, i_137_, i_140_, i_135_,
                                i_138_, i_141_);
                        i_119_ += i_145_;
                        i_118_ += i_143_;
                        i_122_ += i_146_;
                        i_121_ += i_144_;
                        i_117_ += width;
                        i_134_ += i_136_;
                        i_137_ += i_139_;
                        i_140_ += i_142_;
                    }
                }
            } else {
                i_118_ = i_120_ <<= 16;
                i_121_ = i_123_ <<= 16;
                if (i_117_ < 0) {
                    i_118_ -= i_145_ * i_117_;
                    i_120_ -= i_147_ * i_117_;
                    i_121_ -= i_146_ * i_117_;
                    i_123_ -= i_148_ * i_117_;
                    i_117_ = 0;
                }
                i_119_ <<= 16;
                i_122_ <<= 16;
                if (i_116_ < 0) {
                    i_119_ -= i_143_ * i_116_;
                    i_122_ -= i_144_ * i_116_;
                    i_116_ = 0;
                }
                int i_154_ = i_117_ - anInt_135;
                i_134_ += i_136_ * i_154_;
                i_137_ += i_139_ * i_154_;
                i_140_ += i_142_ * i_154_;
                if (i_145_ < i_147_) {
                    i -= i_116_;
                    i_116_ -= i_117_;
                    i_117_ = anIntArray_134[i_117_];
                    for (i_116_--; i_116_ >= 0; i_116_--) {
                        void_method56(pixels, is, i_117_,
                                i_118_ >> 16, i_120_ >> 16, i_121_ >> 8,
                                i_123_ >> 8, i_134_, i_137_, i_140_, i_135_,
                                i_138_, i_141_);
                        i_118_ += i_145_;
                        i_120_ += i_147_;
                        i_121_ += i_146_;
                        i_123_ += i_148_;
                        i_117_ += width;
                        i_134_ += i_136_;
                        i_137_ += i_139_;
                        i_140_ += i_142_;
                    }
                    for (i--; i >= 0; i--) {
                        void_method56(pixels, is, i_117_,
                                i_119_ >> 16, i_120_ >> 16, i_122_ >> 8,
                                i_123_ >> 8, i_134_, i_137_, i_140_, i_135_,
                                i_138_, i_141_);
                        i_119_ += i_143_;
                        i_120_ += i_147_;
                        i_122_ += i_144_;
                        i_123_ += i_148_;
                        i_117_ += width;
                        i_134_ += i_136_;
                        i_137_ += i_139_;
                        i_140_ += i_142_;
                    }
                } else {
                    i -= i_116_;
                    i_116_ -= i_117_;
                    i_117_ = anIntArray_134[i_117_];
                    for (i_116_--; i_116_ >= 0; i_116_--) {
                        void_method56(pixels, is, i_117_,
                                i_120_ >> 16, i_118_ >> 16, i_123_ >> 8,
                                i_121_ >> 8, i_134_, i_137_, i_140_, i_135_,
                                i_138_, i_141_);
                        i_118_ += i_145_;
                        i_120_ += i_147_;
                        i_121_ += i_146_;
                        i_123_ += i_148_;
                        i_117_ += width;
                        i_134_ += i_136_;
                        i_137_ += i_139_;
                        i_140_ += i_142_;
                    }
                    for (i--; i >= 0; i--) {
                        void_method56(pixels, is, i_117_,
                                i_120_ >> 16, i_119_ >> 16, i_123_ >> 8,
                                i_122_ >> 8, i_134_, i_137_, i_140_, i_135_,
                                i_138_, i_141_);
                        i_119_ += i_143_;
                        i_120_ += i_147_;
                        i_122_ += i_144_;
                        i_123_ += i_148_;
                        i_117_ += width;
                        i_134_ += i_136_;
                        i_137_ += i_139_;
                        i_140_ += i_142_;
                    }
                }
            }
        }
    }

    public static void method60(int i, int i_155_, int i_156_, int i_157_,
                                int i_158_, int i_159_, int i_160_) {
        int i_161_ = 0;
        if (i_155_ != i) {
            i_161_ = (i_158_ - i_157_ << 16) / (i_155_ - i);
        }
        int i_162_ = 0;
        if (i_156_ != i_155_) {
            i_162_ = (i_159_ - i_158_ << 16) / (i_156_ - i_155_);
        }
        int i_163_ = 0;
        if (i_156_ != i) {
            i_163_ = (i_157_ - i_159_ << 16) / (i - i_156_);
        }
        if (i <= i_155_ && i <= i_156_) {
            if (i < anInt_429) {
                if (i_155_ > anInt_429) {
                    i_155_ = anInt_429;
                }
                if (i_156_ > anInt_429) {
                    i_156_ = anInt_429;
                }
                if (i_155_ < i_156_) {
                    i_159_ = i_157_ <<= 16;
                    if (i < 0) {
                        i_159_ -= i_163_ * i;
                        i_157_ -= i_161_ * i;
                        i = 0;
                    }
                    i_158_ <<= 16;
                    if (i_155_ < 0) {
                        i_158_ -= i_162_ * i_155_;
                        i_155_ = 0;
                    }
                    if (i != i_155_ && i_163_ < i_161_ || i == i_155_
                            && i_163_ > i_162_) {
                        i_156_ -= i_155_;
                        i_155_ -= i;
                        i = anIntArray_134[i];
                        for (i_155_--; i_155_ >= 0; i_155_--) {
                            method62(pixels, i, i_160_,
                                    i_159_ >> 16, i_157_ >> 16);
                            i_159_ += i_163_;
                            i_157_ += i_161_;
                            i += width;
                        }
                        for (i_156_--; i_156_ >= 0; i_156_--) {
                            method62(pixels, i, i_160_,
                                    i_159_ >> 16, i_158_ >> 16);
                            i_159_ += i_163_;
                            i_158_ += i_162_;
                            i += width;
                        }
                    } else {
                        i_156_ -= i_155_;
                        i_155_ -= i;
                        i = anIntArray_134[i];
                        for (i_155_--; i_155_ >= 0; i_155_--) {
                            method62(pixels, i, i_160_,
                                    i_157_ >> 16, i_159_ >> 16);
                            i_159_ += i_163_;
                            i_157_ += i_161_;
                            i += width;
                        }
                        for (i_156_--; i_156_ >= 0; i_156_--) {
                            method62(pixels, i, i_160_,
                                    i_158_ >> 16, i_159_ >> 16);
                            i_159_ += i_163_;
                            i_158_ += i_162_;
                            i += width;
                        }
                    }
                } else {
                    i_158_ = i_157_ <<= 16;
                    if (i < 0) {
                        i_158_ -= i_163_ * i;
                        i_157_ -= i_161_ * i;
                        i = 0;
                    }
                    i_159_ <<= 16;
                    if (i_156_ < 0) {
                        i_159_ -= i_162_ * i_156_;
                        i_156_ = 0;
                    }
                    if (i != i_156_ && i_163_ < i_161_ || i == i_156_
                            && i_162_ > i_161_) {
                        i_155_ -= i_156_;
                        i_156_ -= i;
                        i = anIntArray_134[i];
                        for (i_156_--; i_156_ >= 0; i_156_--) {
                            method62(pixels, i, i_160_,
                                    i_158_ >> 16, i_157_ >> 16);
                            i_158_ += i_163_;
                            i_157_ += i_161_;
                            i += width;
                        }
                        for (i_155_--; i_155_ >= 0; i_155_--) {
                            method62(pixels, i, i_160_,
                                    i_159_ >> 16, i_157_ >> 16);
                            i_159_ += i_162_;
                            i_157_ += i_161_;
                            i += width;
                        }
                    } else {
                        i_155_ -= i_156_;
                        i_156_ -= i;
                        i = anIntArray_134[i];
                        for (i_156_--; i_156_ >= 0; i_156_--) {
                            method62(pixels, i, i_160_,
                                    i_157_ >> 16, i_158_ >> 16);
                            i_158_ += i_163_;
                            i_157_ += i_161_;
                            i += width;
                        }
                        for (i_155_--; i_155_ >= 0; i_155_--) {
                            method62(pixels, i, i_160_,
                                    i_157_ >> 16, i_159_ >> 16);
                            i_159_ += i_162_;
                            i_157_ += i_161_;
                            i += width;
                        }
                    }
                }
            }
        } else if (i_155_ <= i_156_) {
            if (i_155_ < anInt_429) {
                if (i_156_ > anInt_429) {
                    i_156_ = anInt_429;
                }
                if (i > anInt_429) {
                    i = anInt_429;
                }
                if (i_156_ < i) {
                    i_157_ = i_158_ <<= 16;
                    if (i_155_ < 0) {
                        i_157_ -= i_161_ * i_155_;
                        i_158_ -= i_162_ * i_155_;
                        i_155_ = 0;
                    }
                    i_159_ <<= 16;
                    if (i_156_ < 0) {
                        i_159_ -= i_163_ * i_156_;
                        i_156_ = 0;
                    }
                    if (i_155_ != i_156_ && i_161_ < i_162_ || i_155_ == i_156_
                            && i_161_ > i_163_) {
                        i -= i_156_;
                        i_156_ -= i_155_;
                        i_155_ = anIntArray_134[i_155_];
                        for (i_156_--; i_156_ >= 0; i_156_--) {
                            method62(pixels, i_155_, i_160_,
                                    i_157_ >> 16, i_158_ >> 16);
                            i_157_ += i_161_;
                            i_158_ += i_162_;
                            i_155_ += width;
                        }
                        for (i--; i >= 0; i--) {
                            method62(pixels, i_155_, i_160_,
                                    i_157_ >> 16, i_159_ >> 16);
                            i_157_ += i_161_;
                            i_159_ += i_163_;
                            i_155_ += width;
                        }
                    } else {
                        i -= i_156_;
                        i_156_ -= i_155_;
                        i_155_ = anIntArray_134[i_155_];
                        for (i_156_--; i_156_ >= 0; i_156_--) {
                            method62(pixels, i_155_, i_160_,
                                    i_158_ >> 16, i_157_ >> 16);
                            i_157_ += i_161_;
                            i_158_ += i_162_;
                            i_155_ += width;
                        }
                        for (i--; i >= 0; i--) {
                            method62(pixels, i_155_, i_160_,
                                    i_159_ >> 16, i_157_ >> 16);
                            i_157_ += i_161_;
                            i_159_ += i_163_;
                            i_155_ += width;
                        }
                    }
                } else {
                    i_159_ = i_158_ <<= 16;
                    if (i_155_ < 0) {
                        i_159_ -= i_161_ * i_155_;
                        i_158_ -= i_162_ * i_155_;
                        i_155_ = 0;
                    }
                    i_157_ <<= 16;
                    if (i < 0) {
                        i_157_ -= i_163_ * i;
                        i = 0;
                    }
                    if (i_161_ < i_162_) {
                        i_156_ -= i;
                        i -= i_155_;
                        i_155_ = anIntArray_134[i_155_];
                        for (i--; i >= 0; i--) {
                            method62(pixels, i_155_, i_160_,
                                    i_159_ >> 16, i_158_ >> 16);
                            i_159_ += i_161_;
                            i_158_ += i_162_;
                            i_155_ += width;
                        }
                        for (i_156_--; i_156_ >= 0; i_156_--) {
                            method62(pixels, i_155_, i_160_,
                                    i_157_ >> 16, i_158_ >> 16);
                            i_157_ += i_163_;
                            i_158_ += i_162_;
                            i_155_ += width;
                        }
                    } else {
                        i_156_ -= i;
                        i -= i_155_;
                        i_155_ = anIntArray_134[i_155_];
                        for (i--; i >= 0; i--) {
                            method62(pixels, i_155_, i_160_,
                                    i_158_ >> 16, i_159_ >> 16);
                            i_159_ += i_161_;
                            i_158_ += i_162_;
                            i_155_ += width;
                        }
                        for (i_156_--; i_156_ >= 0; i_156_--) {
                            method62(pixels, i_155_, i_160_,
                                    i_158_ >> 16, i_157_ >> 16);
                            i_157_ += i_163_;
                            i_158_ += i_162_;
                            i_155_ += width;
                        }
                    }
                }
            }
        } else if (i_156_ < anInt_429) {
            if (i > anInt_429) {
                i = anInt_429;
            }
            if (i_155_ > anInt_429) {
                i_155_ = anInt_429;
            }
            if (i < i_155_) {
                i_158_ = i_159_ <<= 16;
                if (i_156_ < 0) {
                    i_158_ -= i_162_ * i_156_;
                    i_159_ -= i_163_ * i_156_;
                    i_156_ = 0;
                }
                i_157_ <<= 16;
                if (i < 0) {
                    i_157_ -= i_161_ * i;
                    i = 0;
                }
                if (i_162_ < i_163_) {
                    i_155_ -= i;
                    i -= i_156_;
                    i_156_ = anIntArray_134[i_156_];
                    for (i--; i >= 0; i--) {
                        method62(pixels, i_156_, i_160_,
                                i_158_ >> 16, i_159_ >> 16);
                        i_158_ += i_162_;
                        i_159_ += i_163_;
                        i_156_ += width;
                    }
                    for (i_155_--; i_155_ >= 0; i_155_--) {
                        method62(pixels, i_156_, i_160_,
                                i_158_ >> 16, i_157_ >> 16);
                        i_158_ += i_162_;
                        i_157_ += i_161_;
                        i_156_ += width;
                    }
                } else {
                    i_155_ -= i;
                    i -= i_156_;
                    i_156_ = anIntArray_134[i_156_];
                    for (i--; i >= 0; i--) {
                        method62(pixels, i_156_, i_160_,
                                i_159_ >> 16, i_158_ >> 16);
                        i_158_ += i_162_;
                        i_159_ += i_163_;
                        i_156_ += width;
                    }
                    for (i_155_--; i_155_ >= 0; i_155_--) {
                        method62(pixels, i_156_, i_160_,
                                i_157_ >> 16, i_158_ >> 16);
                        i_158_ += i_162_;
                        i_157_ += i_161_;
                        i_156_ += width;
                    }
                }
            } else {
                i_157_ = i_159_ <<= 16;
                if (i_156_ < 0) {
                    i_157_ -= i_162_ * i_156_;
                    i_159_ -= i_163_ * i_156_;
                    i_156_ = 0;
                }
                i_158_ <<= 16;
                if (i_155_ < 0) {
                    i_158_ -= i_161_ * i_155_;
                    i_155_ = 0;
                }
                if (i_162_ < i_163_) {
                    i -= i_155_;
                    i_155_ -= i_156_;
                    i_156_ = anIntArray_134[i_156_];
                    for (i_155_--; i_155_ >= 0; i_155_--) {
                        method62(pixels, i_156_, i_160_,
                                i_157_ >> 16, i_159_ >> 16);
                        i_157_ += i_162_;
                        i_159_ += i_163_;
                        i_156_ += width;
                    }
                    for (i--; i >= 0; i--) {
                        method62(pixels, i_156_, i_160_,
                                i_158_ >> 16, i_159_ >> 16);
                        i_158_ += i_161_;
                        i_159_ += i_163_;
                        i_156_ += width;
                    }
                } else {
                    i -= i_155_;
                    i_155_ -= i_156_;
                    i_156_ = anIntArray_134[i_156_];
                    for (i_155_--; i_155_ >= 0; i_155_--) {
                        method62(pixels, i_156_, i_160_,
                                i_159_ >> 16, i_157_ >> 16);
                        i_157_ += i_162_;
                        i_159_ += i_163_;
                        i_156_ += width;
                    }
                    for (i--; i >= 0; i--) {
                        method62(pixels, i_156_, i_160_,
                                i_159_ >> 16, i_158_ >> 16);
                        i_158_ += i_161_;
                        i_159_ += i_163_;
                        i_156_ += width;
                    }
                }
            }
        }
    }

    public static void void_method61() {
        anIntArray_134 = new int[height];
        int i_164_;
        int i = i_164_ = 0;
        while (i < height) {
            anIntArray_134[i_164_] = width * i_164_;
            i = ++i_164_;
        }
        anInt_132 = width / 2;
        anInt_135 = height / 2;
    }

    private static void method62(int[] is, int i, int i_165_, int i_166_,
                                 int i_167_) {
        if (aBoolean_128) {
            if (i_167_ > anInt_434) {
                i_167_ = anInt_434;
            }
            if (i_166_ < 0) {
                i_166_ = 0;
            }
        }
        if (i_166_ < i_167_) {
            i += i_166_;
            int i_168_ = i_167_ - i_166_ >> 2;
            if (anInt_126 == 0) {
                for (i_168_--; i_168_ >= 0; i_168_--) {
                    is[i++] = i_165_;
                    is[i++] = i_165_;
                    is[i++] = i_165_;
                    is[i++] = i_165_;
                }
                i_168_ = i_167_ - i_166_ & 0x3;
                for (i_168_--; i_168_ >= 0; i_168_--) {
                    is[i++] = i_165_;
                }
            } else {
                int i_169_ = anInt_126;
                int i_170_ = 256 - anInt_126;
                i_165_ = ((i_165_ & 0xff00ff) * i_170_ >> 8 & 0xff00ff)
                        + ((i_165_ & 0xff00) * i_170_ >> 8 & 0xff00);
                if (aBoolean_125) {
                    for (i_168_--; i_168_ >= 0; i_168_--) {
                        is[i] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                        i++;
                        is[i] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                        i++;
                        is[i] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                        i++;
                        is[i] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                        i++;
                    }
                    i_168_ = i_167_ - i_166_ & 0x3;
                    while (--i_168_ >= 0) {
                        is[i] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                        i++;
                    }
                } else {
                    for (i_168_--; i_168_ >= 0; i_168_--) {
                        is[i++] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                        is[i++] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                        is[i++] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                        is[i++] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                    }
                    i_168_ = i_167_ - i_166_ & 0x3;
                    for (i_168_--; i_168_ >= 0; i_168_--) {
                        is[i++] = i_165_
                                + ((is[i] & 0xff00ff) * i_169_ >> 8 & 0xff00ff)
                                + ((is[i] & 0xff00) * i_169_ >> 8 & 0xff00);
                    }
                }
            }
        }
    }

    public static void method63() {
        anIntArray_124 = null;
        anIntArray_124 = null;
        anIntArray_137 = null;
        anIntArray_121 = null;
        anIntArray_134 = null;
        aBooleanArray_142 = null;
        anIntArray_120 = null;
        anIntArrayArray_138 = null;
        anIntArrayArray_127 = null;
        anIntArray_131 = null;
        anIntArray_129 = null;
        anIntArrayArray_143 = null;
    }

    public static void method64() {
        if (anIntArrayArray_138 == null) {
            anInt_140 = 20;
            if (aBoolean_123) {
                anIntArrayArray_138 = new int[anInt_140][16384];
            } else {
                anIntArrayArray_138 = new int[anInt_140][65536];
            }
            int i_171_;
            int i = i_171_ = 0;
            while (i < 50) {
                anIntArrayArray_127[i_171_] = null;
                i = ++i_171_;
            }
        }
    }

    public static void void_method65() {
        anIntArrayArray_138 = null;
        int i_172_;
        int i = i_172_ = 0;
        while (i < 50) {
            anIntArrayArray_127[i_172_] = null;
            i = ++i_172_;
        }
    }
}
