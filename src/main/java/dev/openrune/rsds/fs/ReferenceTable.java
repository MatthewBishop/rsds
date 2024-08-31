package dev.openrune.rsds.fs;

import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.compression.CompressionUtils;

public class ReferenceTable {

    private static int method286(Buffer buffer) {
        if (buffer.readByteFromPos(buffer.offset) >= 0) {
            return buffer.readUShort();
        }
        return buffer.readInt3() & 0x7fffffff;
    }

    private boolean aBoolean691;
    private boolean aBoolean692;
    private boolean aBoolean694;
    private Archive archive = new Archive();
    private ArchiveSub[] archiveSubs;
    private int revision;
    private int protocol;
    private int[] entryIndices;

    public ReferenceTable(byte[] bytes) {
        archive.method88((bytes[bytes.length - 2] << 8 & 0xff00)
                + (bytes[bytes.length - 1] & 0xff));
        CompressionUtils.crc.reset();
        CompressionUtils.crc.update(bytes);
        archive.setCRCValue((int) CompressionUtils.crc.getValue());
        unpackTable(CompressionUtils
                .readDecompressedData(bytes));
    }

    public byte[] method284() {
        Buffer buffer;
        (buffer = new Buffer(500000)).writeByte(protocol);
        if (protocol >= 6) {
            buffer.writeInt(revision);
        }
        byte i = 0;
        if (aBoolean691) {
            i |= 0x1;
        }
        if (aBoolean694) {
            i |= 0x2;
        }
        buffer.writeByte(i);
        buffer.writeShort(entryIndices.length);
        int i_1_;
        int i_0_ = i_1_ = 0;
        while (i_0_ < entryIndices.length) {
            buffer.writeShort(entryIndices[i_1_]
                    - (i_1_ == 0 ? 0 : entryIndices[i_1_ - 1]));
            i_0_ = ++i_1_;
        }
        if (aBoolean694) {
            int i_2_ = i_1_ = 0;
            while (i_2_ < entryIndices.length) {
                int i_4_;
                int i_3_ = i_4_ = 0;
                while (i_3_ < 64) {
                    buffer.writeByte(archiveSubs[entryIndices[i_1_]]
                            .getArchives()[archiveSubs[entryIndices[i_1_]]
                            .method174()[i_4_]].method138());
                    i_3_ = ++i_4_;
                }
                i_2_ = ++i_1_;
            }
        }
        if (aBoolean691) {
            int i_5_ = i_1_ = 0;
            while (i_5_ < entryIndices.length) {
                // class_k.void_method268(aK_sub_93Array695[anIntArray697[i_1_]]
                // .C());
                i_5_ = ++i_1_;
            }
        }
        int i_6_ = i_1_ = 0;
        while (i_6_ < entryIndices.length) {
            // class_k.void_method268(aK_sub_93Array695[anIntArray697[i_1_]].l());
            i_6_ = ++i_1_;
        }
        int i_7_ = i_1_ = 0;
        while (i_7_ < entryIndices.length) {
            // class_k.void_method268(aK_sub_93Array695[anIntArray697[i_1_]].K());
            i_7_ = ++i_1_;
        }
        int i_8_ = i_1_ = 0;
        while (i_8_ < entryIndices.length) {
            buffer.writeShort(archiveSubs[entryIndices[i_1_]].method174().length);
            i_8_ = ++i_1_;
        }
        int i_9_ = i_1_ = 0;
        while (i_9_ < entryIndices.length) {
            int i_11_;
            int i_10_ = i_11_ = 0;
            while (i_10_ < archiveSubs[entryIndices[i_1_]].method174().length) {
                buffer.writeShort(archiveSubs[entryIndices[i_1_]].method174()[i_11_]
                        - (i_11_ == 0 ? 0 : archiveSubs[entryIndices[i_1_]]
                        .method174()[i_11_ - 1]));
                i_10_ = ++i_11_;
            }
            i_9_ = ++i_1_;
        }
        if (aBoolean691) {
            int i_12_ = i_1_ = 0;
            while (i_12_ < entryIndices.length) {
                int i_14_;
                int i_13_ = i_14_ = 0;
                while (i_13_ < archiveSubs[entryIndices[i_1_]].method174().length) {
                    buffer.writeInt(archiveSubs[entryIndices[i_1_]]
                            .getArchives()[archiveSubs[entryIndices[i_1_]]
                            .method174()[i_14_]].method140());
                    i_13_ = ++i_14_;
                }
                i_12_ = ++i_1_;
            }
        }
        byte[] is = new byte[buffer.offset];
        buffer.offset = 0;
        buffer.readData(is, 0, is.length);
        return is;
    }

    public int[] an_int_array_method285() {
        return entryIndices;
    }

    public ArchiveSub[] getArchiveSubs() {
        return archiveSubs;
    }

    public boolean boolean_method141() {
        return aBoolean692;
    }

    public int getRevision() {
        return revision;
    }

    public int int_method152(int i) {
        if (i < 0) {
            return -1;
        }
        int i_15_ = -1;
        int i_17_;
        int i_16_ = i_17_ = 0;
        while (i_16_ < entryIndices.length) {
            if (entryIndices[i_17_] == i) {
                i_15_ = i_17_;
                break;
            }
            i_16_ = ++i_17_;
        }
        if (i_15_ == -1) {
            int[] is = new int[(i_15_ = entryIndices.length) + 1];
            System.arraycopy(entryIndices, 0, is, 0, i_15_);
            is[i_15_] = i;
            entryIndices = is;
        }
        if (archiveSubs.length <= i) {
            ArchiveSub[] var_k_sub_93s = new ArchiveSub[i + 1];
            System.arraycopy(archiveSubs, 0, var_k_sub_93s, 0,
                    archiveSubs.length);
            archiveSubs = var_k_sub_93s;
        }
        if (archiveSubs[i] == null) {
            archiveSubs[i] = new ArchiveSub();
        }
        return i_15_;
    }

    public int int_method288(int i, int i_42_) {
        if (i < 0 || archiveSubs[i] == null) {
            return -1;
        }
        int i_43_ = -1;
        if (archiveSubs[i].method174() == null) {
            archiveSubs[i].method171(new int[1]);
            archiveSubs[i].method174()[0] = i_42_;
            i_43_ = 0;
        } else {
            int i_45_;
            int i_44_ = i_45_ = 0;
            while (i_44_ < entryIndices.length) {
                if (archiveSubs[i].method174()[i_45_] == i_42_) {
                    i_43_ = i_45_;
                    break;
                }
                i_44_ = ++i_45_;
            }
            if (i_43_ == -1) {
                int[] is = new int[(i_43_ = archiveSubs[i].method174().length) + 1];
                System.arraycopy(archiveSubs[i].method174(), 0, is, 0, i_43_);
                is[i_43_] = i_42_;
                archiveSubs[i].method171(is);
            }
        }
        if (archiveSubs[i].getArchives() == null) {
            archiveSubs[i].setArchives(new Archive[i_42_ + 1]);
        } else if (archiveSubs[i].getArchives().length <= i_42_) {
            Archive[] class_ks = new Archive[i_42_ + 1];
            System.arraycopy(archiveSubs[i].getArchives(), 0, class_ks, 0,
                    archiveSubs[i].getArchives().length);
            archiveSubs[i].setArchives(class_ks);
        }
        if (archiveSubs[i].getArchives()[i_42_] == null) {
            archiveSubs[i].getArchives()[i_42_] = new Archive();
        }
        return i_43_;
    }

    public Archive k_method283() {
        return archive;
    }

    public void unpackTable(byte[] payload) {
        Buffer buffer = new Buffer(payload);
        protocol = buffer.readUByte();
        System.out.println(new StringBuilder().append("Protocol: ")
                .append(protocol).toString());
        revision = protocol < 6 ? 0 : buffer.readInt3();
        System.out.println(new StringBuilder().append("Revision: ")
                .append(revision).toString());
        byte identifierFlag = buffer.readByte();
        aBoolean691 = (identifierFlag & 0x1) != 0;
        aBoolean694 = (identifierFlag & 0x2) != 0;
        int entryCount;
        if (protocol >= 7) {
            entryCount = method286(buffer);
        } else {
            entryCount = buffer.readUShort();
        }
        entryIndices = new int[entryCount];
        int count = -1;
        int index;
        int i_20_ = index = 0;
        while (i_20_ < entryIndices.length) {
            entryIndices[index] = (protocol >= 7 ? method286(buffer) : buffer
                    .readUShort()) + (index == 0 ? 0 : entryIndices[index - 1]);
            if (entryIndices[index] > count) {
                count = entryIndices[index];
            }
            i_20_ = ++index;
        }
        archiveSubs = new ArchiveSub[count + 1];
        int i_22_ = index = 0;
        while (i_22_ < entryIndices.length) {
            archiveSubs[entryIndices[index]] = new ArchiveSub();
            i_22_ = ++index;
        }
        if (aBoolean691) {
            int i_23_ = index = 0;
            while (i_23_ < entryIndices.length) {
                // aK_sub_93Array695[anIntArray697[i_21_]].method171(class_k).int_method260());
                i_23_ = ++index;
            }
        }
        byte[][] is_24_ = null;
        if (aBoolean694) {
            is_24_ = new byte[archiveSubs.length][];
            int i_26_;
            int i_25_ = i_26_ = 0;
            while (i_25_ < entryIndices.length) {
                is_24_[entryIndices[i_26_]] = new byte[64];
                buffer.readData(is_24_[entryIndices[i_26_]], 0, 64);
                i_25_ = ++i_26_;
            }
        }
        int i_28_;
        int i_27_ = i_28_ = 0;
        while (i_27_ < entryIndices.length) {
            // aK_sub_93Array695[anIntArray697[i_28_]].C(class_k.int_method260());
            i_27_ = ++i_28_;
        }
        int i_29_ = i_28_ = 0;
        while (i_29_ < entryIndices.length) {
            // aK_sub_93Array695[anIntArray697[i_28_]].G(class_k.int_method260());
            i_29_ = ++i_28_;
        }
        int i_30_ = i_28_ = 0;
        while (i_30_ < entryIndices.length) {
            archiveSubs[entryIndices[i_28_]]
                    .method171(new int[protocol >= 7 ? method286(buffer)
                            : buffer.readUShort()]);
            i_30_ = ++i_28_;
        }
        int i_31_ = i_28_ = 0;
        while (i_31_ < entryIndices.length) {
            int i_32_ = -1;
            int i_34_;
            int i_33_ = i_34_ = 0;
            while (i_33_ < archiveSubs[entryIndices[i_28_]].method174().length) {
                archiveSubs[entryIndices[i_28_]].method174()[i_34_] = (protocol >= 7 ? method286(buffer)
                        : buffer.readUShort())
                        + (i_34_ == 0 ? 0 : archiveSubs[entryIndices[i_28_]]
                        .method174()[i_34_ - 1]);
                if (archiveSubs[entryIndices[i_28_]].method174()[i_34_] > i_32_) {
                    i_32_ = archiveSubs[entryIndices[i_28_]].method174()[i_34_];
                }
                i_33_ = ++i_34_;
            }
            archiveSubs[entryIndices[i_28_]]
                    .setArchives(new Archive[i_32_ + 1]);
            int i_35_ = i_34_ = 0;
            while (i_35_ < archiveSubs[entryIndices[i_28_]].method174().length) {
                archiveSubs[entryIndices[i_28_]].getArchives()[archiveSubs[entryIndices[i_28_]]
                        .method174()[i_34_]] = new Archive();
                i_35_ = ++i_34_;
            }
            i_31_ = ++i_28_;
        }
        if (aBoolean694) {
            int i_36_ = i_28_ = 0;
            while (i_36_ < entryIndices.length) {
                int i_38_;
                int i_37_ = i_38_ = 0;
                while (i_37_ < archiveSubs[entryIndices[i_28_]].method174().length) {
                    archiveSubs[entryIndices[i_28_]].getArchives()[archiveSubs[entryIndices[i_28_]]
                            .method174()[i_38_]]
                            .method88(is_24_[entryIndices[i_28_]][archiveSubs[entryIndices[i_28_]]
                                    .method174()[i_38_]]);
                    i_37_ = ++i_38_;
                }
                i_36_ = ++i_28_;
            }
        }
        if (aBoolean691) {
            int i_39_ = i_28_ = 0;
            while (i_39_ < entryIndices.length) {
                int i_41_;
                int i_40_ = i_41_ = 0;
                while (i_40_ < archiveSubs[entryIndices[i_28_]].method174().length) {
                    archiveSubs[entryIndices[i_28_]].getArchives()[archiveSubs[entryIndices[i_28_]]
                            .method174()[i_41_]].method54(buffer.readInt3());
                    i_40_ = ++i_41_;
                }
                i_39_ = ++i_28_;
            }
        }
    }

    public void void_method64() {
        revision++;
        aBoolean692 = true;
    }

}