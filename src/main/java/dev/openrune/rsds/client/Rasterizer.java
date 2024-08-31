/* Class_k - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package dev.openrune.rsds.client;

public class Rasterizer {

    public static int[] pixels;
    public static int height;
    public static int width;
    public static int anInt_429;
    public static int anInt_430;
    public static int anInt_431;
    public static int anInt_432;
    public static int anInt_433;
    public static int anInt_434;
    public static int anInt_435;

    private static void void_method162(int i, int i_0_, int i_1_, int i_2_,
                                       int i_3_) {
        if (i_0_ >= anInt_433 && i_0_ < anInt_435) {
            if (i_2_ < anInt_431) {
                i_3_ -= anInt_431 - i_2_;
                i_2_ = anInt_431;
            }
            if (i_2_ + i_3_ > anInt_429) {
                i_3_ = anInt_429 - i_2_;
            }
            int i_4_ = 256 - i_1_;
            int i_5_ = (i >> 16 & 0xff) * i_1_;
            int i_6_ = (i >> 8 & 0xff) * i_1_;
            int i_7_ = (i & 0xff) * i_1_;
            int i_8_ = i_0_ + i_2_ * width;
            int i_10_;
            int i_9_ = i_10_ = 0;
            while (i_9_ < i_3_) {
                int i_11_ = (pixels[i_8_] >> 16 & 0xff) * i_4_;
                int i_12_ = (pixels[i_8_] >> 8 & 0xff) * i_4_;
                int i_13_ = (pixels[i_8_] & 0xff) * i_4_;
                int i_14_ = (i_5_ + i_11_ >> 8 << 16)
                        + (i_6_ + i_12_ >> 8 << 8) + (i_7_ + i_13_ >> 8);
                pixels[i_8_] = i_14_;
                i_8_ += width;
                i_9_ = ++i_10_;
            }
        }
    }

    public static void method163(int height, int i_15_, int width, int i_17_) {
        if (i_15_ < 0) {
            i_15_ = 0;
        }
        if (i_17_ < 0) {
            i_17_ = 0;
        }
        if (width > Rasterizer.width) {
            width = Rasterizer.width;
        }
        if (height > Rasterizer.height) {
            height = Rasterizer.height;
        }
        anInt_433 = i_15_;
        anInt_431 = i_17_;
        anInt_435 = width;
        anInt_429 = height;
        anInt_434 = anInt_435 - 1;
        anInt_430 = anInt_435 / 2;
        anInt_432 = anInt_429 / 2;
    }

    public static void void_method164(int i, int i_20_, int i_21_, int i_22_,
                                      int i_23_) {
        if (i_21_ < anInt_433) {
            i_23_ -= anInt_433 - i_21_;
            i_21_ = anInt_433;
        }
        if (i_20_ < anInt_431) {
            i -= anInt_431 - i_20_;
            i_20_ = anInt_431;
        }
        if (i_21_ + i_23_ > anInt_435) {
            i_23_ = anInt_435 - i_21_;
        }
        if (i_20_ + i > anInt_429) {
            i = anInt_429 - i_20_;
        }
        int i_24_ = width - i_23_;
        int i_25_ = i_21_ + i_20_ * width;
        int i_27_;
        int i_26_ = i_27_ = -i;
        while (i_26_ < 0) {
            int i_29_;
            int i_28_ = i_29_ = -i_23_;
            while (i_28_ < 0) {
                pixels[i_25_++] = i_22_;
                i_28_ = ++i_29_;
            }
            i_25_ += i_24_;
            i_26_ = ++i_27_;
        }
    }

    public static void void_method165(int i, int i_30_, int i_31_, int i_32_) {
        if (i >= anInt_431 && i < anInt_429) {
            if (i_32_ < anInt_433) {
                i_31_ -= anInt_433 - i_32_;
                i_32_ = anInt_433;
            }
            if (i_32_ + i_31_ > anInt_435) {
                i_31_ = anInt_435 - i_32_;
            }
            int i_33_ = i_32_ + i * width;
            int i_35_;
            int i_34_ = i_35_ = 0;
            while (i_34_ < i_31_) {
                pixels[i_33_ + i_35_] = i_30_;
                i_34_ = ++i_35_;
            }
        }
    }

    public static void void_method166(int i, int i_36_, int i_37_, int i_38_,
                                      int i_39_) {
        void_method165(i_39_, i_38_, i_36_, i);
        void_method165(i_39_ + i_37_ - 1, i_38_, i_36_, i);
        void_method167(i_39_, i_38_, i_37_, i);
        void_method167(i_39_, i_38_, i_37_, i + i_36_ - 1);
    }

    public static void void_method167(int i, int i_43_, int i_44_, int i_45_) {
        if (i_45_ >= anInt_433 && i_45_ < anInt_435) {
            if (i < anInt_431) {
                i_44_ -= anInt_431 - i;
                i = anInt_431;
            }
            if (i + i_44_ > anInt_429) {
                i_44_ = anInt_429 - i;
            }
            int i_46_ = i_45_ + i * width;
            int i_48_;
            int i_47_ = i_48_ = 0;
            while (i_47_ < i_44_) {
                pixels[i_46_ + i_48_ * width] = i_43_;
                i_47_ = ++i_48_;
            }
        }
    }

    public static void init(int height, int width, int[] is) {
        Rasterizer.pixels = is;
        Rasterizer.width = width;
        Rasterizer.height = height;
        method163(height, 0, width, 0);
    }

    public static void void_method169(int i, int i_65_, int i_66_, int i_67_,
                                      int i_68_, int i_69_) {
        void_method86(i_67_, i_68_, i, i_66_, i_69_);
        void_method86(i_67_, i_68_, i + i_65_ - 1, i_66_, i_69_);
        if (i_65_ >= 3) {
            void_method162(i_67_, i_69_, i_66_, i + 1, i_65_ - 2);
            void_method162(i_67_, i_69_ + i_68_ - 1, i_66_, i + 1, i_65_ - 2);
        }
    }

    public static void void_method170(int i, int i_70_, int i_71_, int i_72_,
                                      int i_73_, int i_74_) {
        if (i_74_ < anInt_433) {
            i_71_ -= anInt_433 - i_74_;
            i_74_ = anInt_433;
        }
        if (i_70_ < anInt_431) {
            i_72_ -= anInt_431 - i_70_;
            i_70_ = anInt_431;
        }
        if (i_74_ + i_71_ > anInt_435) {
            i_71_ = anInt_435 - i_74_;
        }
        if (i_70_ + i_72_ > anInt_429) {
            i_72_ = anInt_429 - i_70_;
        }
        int i_75_ = 256 - i_73_;
        int i_76_ = (i >> 16 & 0xff) * i_73_;
        int i_77_ = (i >> 8 & 0xff) * i_73_;
        int i_78_ = (i & 0xff) * i_73_;
        int i_79_ = width - i_71_;
        int i_80_ = i_74_ + i_70_ * width;
        int i_82_;
        int i_81_ = i_82_ = 0;
        while (i_81_ < i_72_) {
            int i_84_;
            int i_83_ = i_84_ = -i_71_;
            while (i_83_ < 0) {
                int i_85_ = (pixels[i_80_] >> 16 & 0xff) * i_75_;
                int i_86_ = (pixels[i_80_] >> 8 & 0xff) * i_75_;
                int i_87_ = (pixels[i_80_] & 0xff) * i_75_;
                int i_88_ = (i_76_ + i_85_ >> 8 << 16)
                        + (i_77_ + i_86_ >> 8 << 8) + (i_78_ + i_87_ >> 8);
                pixels[i_80_++] = i_88_;
                i_83_ = ++i_84_;
            }
            i_80_ += i_79_;
            i_81_ = ++i_82_;
        }
    }

    public static void void_method3() {
        anInt_433 = 0;
        anInt_431 = 0;
        anInt_435 = width;
        anInt_429 = height;
        anInt_434 = anInt_435 - 1;
        anInt_430 = anInt_435 / 2;
    }

    public static void clearPixels() {
        int count = width * height;
        int pixel;
        int i_18_ = pixel = 0;
        while (i_18_ < count) {
            pixels[pixel] = 0;
            i_18_ = ++pixel;
        }
    }

    private static void void_method86(int i, int i_49_, int i_50_, int i_51_,
                                      int i_52_) {
        if (i_50_ >= anInt_431 && i_50_ < anInt_429) {
            if (i_52_ < anInt_433) {
                i_49_ -= anInt_433 - i_52_;
                i_52_ = anInt_433;
            }
            if (i_52_ + i_49_ > anInt_435) {
                i_49_ = anInt_435 - i_52_;
            }
            int i_53_ = 256 - i_51_;
            int i_54_ = (i >> 16 & 0xff) * i_51_;
            int i_55_ = (i >> 8 & 0xff) * i_51_;
            int i_56_ = (i & 0xff) * i_51_;
            int i_57_ = i_52_ + i_50_ * width;
            int i_59_;
            int i_58_ = i_59_ = 0;
            while (i_58_ < i_49_) {
                int i_60_ = (pixels[i_57_] >> 16 & 0xff) * i_53_;
                int i_61_ = (pixels[i_57_] >> 8 & 0xff) * i_53_;
                int i_62_ = (pixels[i_57_] & 0xff) * i_53_;
                int i_63_ = (i_54_ + i_60_ >> 8 << 16)
                        + (i_55_ + i_61_ >> 8 << 8) + (i_56_ + i_62_ >> 8);
                pixels[i_57_++] = i_63_;
                i_58_ = ++i_59_;
            }
        }
    }

    public static void method88(int i) {
        int i_40_ = width * height;
        int i_42_;
        int i_41_ = i_42_ = 0;
        while (i_41_ < i_40_) {
            pixels[i_42_] = i;
            i_41_ = ++i_42_;
        }
    }

    Rasterizer() {
        /* empty */
    }
}
