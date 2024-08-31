package dev.openrune.rsds.compression.bzip;

public class BZip2Decompressor {

    private static int[] ll8;
    private static BZip2Block block = new BZip2Block();

    private static final byte readUChar(BZip2Block block) {
        return (byte) getBits(8, block);
    }

    private static final byte readBit(BZip2Block block) {
        return (byte) getBits(1, block);
    }

    private static final int getBits(int numBits, BZip2Block block) {
        int dest;
        for (; ; ) {
            if (block.bsLive >= numBits) {
                int tmp = block.bsBuffer >> block.bsLive - numBits
                        & (1 << numBits) - 1;
                block.bsLive -= numBits;
                dest = tmp;
                break;
            }
            block.bsBuffer = block.bsBuffer << 8
                    | block.aByteArray671[block.nextIn] & 0xff;
            block.bsLive += 8;
            block.nextIn++;
            block.anInt687++;
        }
        return dest;
    }

    private static final void getNextFileHeader(BZip2Block block) {
        byte stateOutCh = block.stateOutCh;
        int stateOutLength = block.stateOutLength;
        int nextBlockUsed = block.nextBlockUsed;
        int k0 = block.k0;
        int[] out = ll8;
        int i_3_ = block.nextOut;
        byte[] outBuffer = block.outputBuffer;
        int availOut = block.availableOut;
        int decompressedSize;
        int decompSize = decompressedSize = block.decompressedSize;
        int nextBlockPP = block.nextBlockPP + 1;
        outer:
        for (; ; ) {
            if (stateOutLength > 0) {
                for (; ; ) {
                    if (decompressedSize == 0) {
                        break outer;
                    }
                    if (stateOutLength == 1) {
                        break;
                    }
                    outBuffer[availOut] = stateOutCh;
                    stateOutLength--;
                    availOut++;
                    decompressedSize--;
                }
                if (decompressedSize == 0) {
                    stateOutLength = 1;
                    break;
                }
                outBuffer[availOut] = stateOutCh;
                availOut++;
                decompressedSize--;
            }
            boolean bool_9_;
            boolean bool = bool_9_ = true;
            while (bool) {
                bool_9_ = false;
                if (nextBlockUsed == nextBlockPP) {
                    stateOutLength = 0;
                    break outer;
                }
                stateOutCh = (byte) k0;
                int i_10_ = (byte) ((i_3_ = out[i_3_]) & 0xff);
                i_3_ >>= 8;
                nextBlockUsed++;
                if (i_10_ != k0) {
                    k0 = i_10_;
                    if (decompressedSize == 0) {
                        stateOutLength = 1;
                        break outer;
                    }
                    outBuffer[availOut] = stateOutCh;
                    availOut++;
                    decompressedSize--;
                    bool = bool_9_ = true;
                } else if (nextBlockUsed != nextBlockPP) {
                    bool = bool_9_;
                } else {
                    if (decompressedSize == 0) {
                        stateOutLength = 1;
                        break outer;
                    }
                    outBuffer[availOut] = stateOutCh;
                    availOut++;
                    decompressedSize--;
                    bool = bool_9_ = true;
                }
            }
            stateOutLength = 2;
            int i_11_ = (byte) ((i_3_ = out[i_3_]) & 0xff);
            i_3_ >>= 8;
            if (++nextBlockUsed != nextBlockPP) {
                if (i_11_ != k0) {
                    k0 = i_11_;
                } else {
                    stateOutLength = 3;
                    int i_12_ = (byte) ((i_3_ = out[i_3_]) & 0xff);
                    i_3_ >>= 8;
                    if (++nextBlockUsed != nextBlockPP) {
                        if (i_12_ != k0) {
                            k0 = i_12_;
                        } else {
                            int i_13_ = (byte) ((i_3_ = out[i_3_]) & 0xff);
                            i_3_ >>= 8;
                            nextBlockUsed++;
                            stateOutLength = (i_13_ & 0xff) + 4;
                            k0 = (byte) ((i_3_ = out[i_3_]) & 0xff);
                            i_3_ >>= 8;
                            nextBlockUsed++;
                        }
                    }
                }
            }
        }
        block.anInt674 += decompSize - decompressedSize;
        block.stateOutCh = stateOutCh;
        block.stateOutLength = stateOutLength;
        block.nextBlockUsed = nextBlockUsed;
        block.k0 = k0;
        ll8 = out;
        block.nextOut = i_3_;
        block.outputBuffer = outBuffer;
        block.availableOut = availOut;
        block.decompressedSize = decompressedSize;
    }

    public static final void decompress(byte[] out, byte[] is, int next) {
        synchronized (block) {
            block.aByteArray671 = is;
            block.nextIn = next;
            block.outputBuffer = out;
            block.availableOut = 0;
            block.decompressedSize = out.length;
            block.bsLive = 0;
            block.bsBuffer = 0;
            block.anInt687 = 0;
            block.anInt674 = 0;
            void_method216(block);
            block.aByteArray671 = null;
            block.outputBuffer = null;
        }
    }

    private static final void makeMaps(BZip2Block block) {
        block.nInUse = 0;
        int j;
        int i = j = 0;
        while (i < 256) {
            if (block.inUse[j]) {
                block.seqToUnseq[block.nInUse] = (byte) j;
                block.nInUse++;
            }
            i = ++j;
        }
    }

    private static final void void_method214(int[] is, int[] is_19_,
                                             int[] is_20_, byte[] is_21_, int i, int i_22_, int i_23_) {
        int i_24_ = 0;
        int i_26_;
        int i_25_ = i_26_ = i;
        while (i_25_ <= i_22_) {
            int i_28_;
            int i_27_ = i_28_ = 0;
            while (i_27_ < i_23_) {
                if (is_21_[i_28_] == i_26_) {
                    is_20_[i_24_] = i_28_;
                    i_24_++;
                }
                i_27_ = ++i_28_;
            }
            i_25_ = ++i_26_;
        }
        int i_29_ = i_26_ = 0;
        while (i_29_ < 23) {
            is_19_[i_26_] = 0;
            i_29_ = ++i_26_;
        }
        int i_30_ = i_26_ = 0;
        while (i_30_ < i_23_) {
            is_19_[is_21_[i_26_] + 1]++;
            i_30_ = ++i_26_;
        }
        int i_31_ = i_26_ = 1;
        while (i_31_ < 23) {
            is_19_[i_26_] += is_19_[i_26_ - 1];
            i_31_ = ++i_26_;
        }
        int i_32_ = i_26_ = 0;
        while (i_32_ < 23) {
            is[i_26_] = 0;
            i_32_ = ++i_26_;
        }
        i_26_ = 0;
        int i_34_;
        int i_33_ = i_34_ = i;
        while (i_33_ <= i_22_) {
            i_26_ += is_19_[i_34_ + 1] - is_19_[i_34_];
            is[i_34_] = i_26_ - 1;
            i_26_ <<= 1;
            i_33_ = ++i_34_;
        }
        int i_35_ = i_34_ = i + 1;
        while (i_35_ <= i_22_) {
            is_19_[i_34_] = (is[i_34_ - 1] + 1 << 1) - is_19_[i_34_];
            i_35_ = ++i_34_;
        }
    }

    private static final void void_method216(BZip2Block class_y) {
        int i = 0;
        int[] is = null;
        int[] is_36_ = null;
        int[] is_37_ = null;
        class_y.anInt662 = 1;
        if (ll8 == null) {
            ll8 = new int[class_y.anInt662 * 100000];
        }
        boolean bool = true;
        while (bool) {
            if (readUChar(class_y) == 23) {
                break;
            }
            readUChar(class_y);
            readUChar(class_y);
            readUChar(class_y);
            readUChar(class_y);
            readUChar(class_y);
            readUChar(class_y);
            readUChar(class_y);
            readUChar(class_y);
            readUChar(class_y);
            readBit(class_y);
            class_y.anInt683 = 0;
            int i_39_ = readUChar(class_y);
            class_y.anInt683 = class_y.anInt683 << 8 | i_39_ & 0xff;
            i_39_ = readUChar(class_y);
            class_y.anInt683 = class_y.anInt683 << 8 | i_39_ & 0xff;
            i_39_ = readUChar(class_y);
            class_y.anInt683 = class_y.anInt683 << 8 | i_39_ & 0xff;
            int i_41_;
            int i_40_ = i_41_ = 0;
            while (i_40_ < 16) {
                if (readBit(class_y) == 1) {
                    class_y.aBooleanArray665[i_41_] = true;
                } else {
                    class_y.aBooleanArray665[i_41_] = false;
                }
                i_40_ = ++i_41_;
            }
            int i_43_ = i_41_ = 0;
            while (i_43_ < 256) {
                class_y.inUse[i_41_] = false;
                i_43_ = ++i_41_;
            }
            int i_44_ = i_41_ = 0;
            while (i_44_ < 16) {
                if (class_y.aBooleanArray665[i_41_]) {
                    int i_46_;
                    int i_45_ = i_46_ = 0;
                    while (i_45_ < 16) {
                        if (readBit(class_y) == 1) {
                            class_y.inUse[i_41_ * 16 + i_46_] = true;
                        }
                        i_45_ = ++i_46_;
                    }
                }
                i_44_ = ++i_41_;
            }
            makeMaps(class_y);
            i_41_ = class_y.nInUse + 2;
            int i_48_ = getBits(3, class_y);
            int i_49_ = getBits(15, class_y);
            int i_51_;
            int i_50_ = i_51_ = 0;
            while (i_50_ < i_49_) {
                int i_52_ = 0;
                while (readBit(class_y) != 0) {
                    i_52_++;
                }
                class_y.aByteArray688[i_51_] = (byte) i_52_;
                i_50_ = ++i_51_;
            }
            byte[] is_54_ = new byte[6];
            byte i_56_;
            byte i_55_ = i_56_ = (byte) 0;
            while (i_55_ < i_48_) {
                is_54_[i_56_] = i_56_;
                i_55_ = ++i_56_;
            }
            int i_58_;
            int i_57_ = i_58_ = 0;
            while (i_57_ < i_49_) {
                byte i_59_ = class_y.aByteArray688[i_58_];
                byte i_60_ = is_54_[i_59_];
                byte i_61_ = i_59_;
                while (i_61_ > 0) {
                    is_54_[i_59_] = is_54_[i_59_ - 1];
                    i_61_ = --i_59_;
                }
                is_54_[0] = i_60_;
                class_y.aByteArray679[i_58_] = i_60_;
                i_57_ = ++i_58_;
            }
            int i_62_ = i_58_ = 0;
            while (i_62_ < i_48_) {
                int i_63_ = getBits(5, class_y);
                int i_65_;
                int i_64_ = i_65_ = 0;
                while (i_64_ < i_41_) {
                    while (readBit(class_y) != 0) {
                        if (readBit(class_y) == 0) {
                            i_63_++;
                        } else {
                            i_63_--;
                        }
                    }
                    class_y.anByteArrayArray664[i_58_][i_65_] = (byte) i_63_;
                    i_64_ = ++i_65_;
                }
                i_62_ = ++i_58_;
            }
            int i_67_ = i_58_ = 0;
            while (i_67_ < i_48_) {
                int i_68_ = 32;
                byte i_69_ = 0;
                int i_71_;
                int i_70_ = i_71_ = 0;
                while (i_70_ < i_41_) {
                    if (class_y.anByteArrayArray664[i_58_][i_71_] > i_69_) {
                        i_69_ = class_y.anByteArrayArray664[i_58_][i_71_];
                    }
                    if (class_y.anByteArrayArray664[i_58_][i_71_] < i_68_) {
                        i_68_ = class_y.anByteArrayArray664[i_58_][i_71_];
                    }
                    i_70_ = ++i_71_;
                }
                void_method214(class_y.anIntArrayArray677[i_58_],
                        class_y.anIntArray660[i_58_],
                        class_y.anIntArrayArray668[i_58_],
                        class_y.anByteArrayArray664[i_58_], i_68_, i_69_, i_41_);
                class_y.anIntArray680[i_58_] = i_68_;
                i_67_ = ++i_58_;
            }
            i_58_ = class_y.nInUse + 1;
            int i_72_ = -1;
            int i_73_ = 0;
            int i_75_;
            int i_74_ = i_75_ = 0;
            while (i_74_ <= 255) {
                class_y.anIntArray682[i_75_] = 0;
                i_74_ = ++i_75_;
            }
            i_75_ = 4095;
            int i_77_;
            int i_76_ = i_77_ = 15;
            while (i_76_ >= 0) {
                int i_79_;
                int i_78_ = i_79_ = 15;
                while (i_78_ >= 0) {
                    class_y.aByteArray684[i_75_] = (byte) (i_77_ * 16 + i_79_);
                    i_75_--;
                    i_78_ = --i_79_;
                }
                class_y.anInt670[i_77_] = i_75_ + 1;
                i_76_ = --i_77_;
            }
            i_77_ = 0;
            if (i_73_ == 0) {
                i_72_++;
                i_73_ = 50;
                byte i_80_ = class_y.aByteArray679[i_72_];
                i = class_y.anIntArray680[i_80_];
                is = class_y.anIntArrayArray677[i_80_];
                is_37_ = class_y.anIntArrayArray668[i_80_];
                is_36_ = class_y.anIntArray660[i_80_];
            }
            i_73_--;
            int i_82_;
            int i_83_;
            int i_81_ = i_82_ = getBits(i_83_ = i, class_y);
            while (i_81_ > is[i_83_]) {
                i_83_++;
                int i_84_ = readBit(class_y);
                i_81_ = i_82_ = i_82_ << 1 | i_84_;
            }
            int i_85_ = is_37_[i_82_ - is_36_[i_83_]];
            while_4_:
            for (; ; ) {
                int i_86_ = i_85_;
                for (; ; ) {
                    if (i_86_ == i_58_) {
                        break while_4_;
                    }
                    if (i_85_ == 0 || i_85_ == 1) {
                        int i_87_ = -1;
                        int i_88_ = 1;
                        int i_89_;
                        int i_90_;
                        do {
                            if (i_85_ == 0) {
                                i_87_ += i_88_;
                            } else if (i_85_ == 1) {
                                i_87_ += i_88_ * 2;
                            }
                            i_88_ *= 2;
                            if (i_73_ == 0) {
                                i_72_++;
                                i_73_ = 50;
                                byte i_91_ = class_y.aByteArray679[i_72_];
                                i = class_y.anIntArray680[i_91_];
                                is = class_y.anIntArrayArray677[i_91_];
                                is_37_ = class_y.anIntArrayArray668[i_91_];
                                is_36_ = class_y.anIntArray660[i_91_];
                            }
                            i_73_--;
                            int i_92_ = i_89_ = getBits(i_90_ = i, class_y);
                            while (i_92_ > is[i_90_]) {
                                i_90_++;
                                int i_93_ = readBit(class_y);
                                i_92_ = i_89_ = i_89_ << 1 | i_93_;
                            }
                        } while ((i_85_ = is_37_[i_89_ - is_36_[i_90_]]) == 0
                                || i_85_ == 1);
                        i_87_++;
                        i_90_ = class_y.seqToUnseq[class_y.aByteArray684[class_y.anInt670[0]] & 0xff];
                        class_y.anIntArray682[i_90_ & 0xff] += i_87_;
                        int i_94_ = i_87_;
                        while (i_94_ > 0) {
                            ll8[i_77_] = i_90_ & 0xff;
                            i_77_++;
                            i_94_ = --i_87_;
                        }
                        break;
                    }
                    int i_95_;
                    byte i_96_;
                    if ((i_95_ = i_85_ - 1) < 16) {
                        int i_97_ = class_y.anInt670[0];
                        i_96_ = class_y.aByteArray684[i_97_ + i_95_];
                        int i_98_ = i_95_;
                        while (i_98_ > 3) {
                            int i_99_ = i_97_ + i_95_;
                            class_y.aByteArray684[i_99_] = class_y.aByteArray684[i_99_ - 1];
                            class_y.aByteArray684[i_99_ - 1] = class_y.aByteArray684[i_99_ - 2];
                            class_y.aByteArray684[i_99_ - 2] = class_y.aByteArray684[i_99_ - 3];
                            class_y.aByteArray684[i_99_ - 3] = class_y.aByteArray684[i_99_ - 4];
                            i_95_ -= 4;
                            i_98_ = i_95_;
                        }
                        int i_100_ = i_95_;
                        while (i_100_ > 0) {
                            class_y.aByteArray684[i_97_ + i_95_] = class_y.aByteArray684[i_97_
                                    + i_95_ - 1];
                            i_100_ = --i_95_;
                        }
                        class_y.aByteArray684[i_97_] = i_96_;
                    } else {
                        int i_101_ = i_95_ / 16;
                        int i_102_ = i_95_ % 16;
                        int i_103_ = class_y.anInt670[i_101_] + i_102_;
                        i_96_ = class_y.aByteArray684[i_103_];
                        int i_104_ = i_103_;
                        while (i_104_ > class_y.anInt670[i_101_]) {
                            class_y.aByteArray684[i_103_] = class_y.aByteArray684[i_103_ - 1];
                            i_104_ = --i_103_;
                        }
                        class_y.anInt670[i_101_]++;
                        int i_105_ = i_101_;
                        while (i_105_ > 0) {
                            class_y.anInt670[i_101_]--;
                            class_y.aByteArray684[class_y.anInt670[i_101_]] = class_y.aByteArray684[class_y.anInt670[i_101_ - 1] + 16 - 1];
                            i_105_ = --i_101_;
                        }
                        class_y.anInt670[0]--;
                        class_y.aByteArray684[class_y.anInt670[0]] = i_96_;
                        if (class_y.anInt670[0] == 0) {
                            int i_106_ = 4095;
                            int i_108_;
                            int i_107_ = i_108_ = 15;
                            while (i_107_ >= 0) {
                                int i_110_;
                                int i_109_ = i_110_ = 15;
                                while (i_109_ >= 0) {
                                    class_y.aByteArray684[i_106_] = class_y.aByteArray684[class_y.anInt670[i_108_]
                                            + i_110_];
                                    i_106_--;
                                    i_109_ = --i_110_;
                                }
                                class_y.anInt670[i_108_] = i_106_ + 1;
                                i_107_ = --i_108_;
                            }
                        }
                    }
                    class_y.anIntArray682[class_y.seqToUnseq[i_96_ & 0xff] & 0xff]++;
                    ll8[i_77_] = class_y.seqToUnseq[i_96_ & 0xff] & 0xff;
                    i_77_++;
                    if (i_73_ == 0) {
                        i_72_++;
                        i_73_ = 50;
                        byte i_111_ = class_y.aByteArray679[i_72_];
                        i = class_y.anIntArray680[i_111_];
                        is = class_y.anIntArrayArray677[i_111_];
                        is_37_ = class_y.anIntArrayArray668[i_111_];
                        is_36_ = class_y.anIntArray660[i_111_];
                    }
                    i_73_--;
                    int i_113_;
                    int i_114_;
                    int i_112_ = i_113_ = getBits(i_114_ = i, class_y);
                    while (i_112_ > is[i_114_]) {
                        i_114_++;
                        int i_115_ = readBit(class_y);
                        i_112_ = i_113_ = i_113_ << 1 | i_115_;
                    }
                    i_86_ = i_85_ = is_37_[i_113_ - is_36_[i_114_]];
                }
            }
            class_y.stateOutLength = 0;
            class_y.stateOutCh = (byte) 0;
            class_y.anIntArray666[0] = 0;
            int i_116_ = i_85_ = 1;
            while (i_116_ <= 256) {
                class_y.anIntArray666[i_85_] = class_y.anIntArray682[i_85_ - 1];
                i_116_ = ++i_85_;
            }
            int i_117_ = i_85_ = 1;
            while (i_117_ <= 256) {
                class_y.anIntArray666[i_85_] += class_y.anIntArray666[i_85_ - 1];
                i_117_ = ++i_85_;
            }
            int i_118_ = i_85_ = 0;
            while (i_118_ < i_77_) {
                int i_119_ = (byte) (ll8[i_85_] & 0xff);
                ll8[class_y.anIntArray666[i_119_ & 0xff]] |= i_85_ << 8;
                class_y.anIntArray666[i_119_ & 0xff]++;
                i_118_ = ++i_85_;
            }
            class_y.nextOut = ll8[class_y.anInt683] >> 8;
            class_y.nextBlockUsed = 0;
            class_y.nextOut = ll8[class_y.nextOut];
            class_y.k0 = (byte) (class_y.nextOut & 0xff);
            class_y.nextOut >>= 8;
            class_y.nextBlockUsed++;
            class_y.nextBlockPP = i_77_;
            getNextFileHeader(class_y);
            if (class_y.nextBlockUsed == class_y.nextBlockPP + 1
                    && class_y.stateOutLength == 0) {
                bool = true;
            } else {
                bool = false;
            }
        }
    }

    public static void clearBlock() {
        block = null;
    }

}