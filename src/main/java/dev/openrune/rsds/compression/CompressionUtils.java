package dev.openrune.rsds.compression;

import java.util.zip.CRC32;

import dev.openrune.rsds.compression.bzip.BZip2Decompressor;
import dev.openrune.rsds.compression.gzip.GZipDecompressor;
import dev.openrune.rsds.fs.Archive;
import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.compression.gzip.GZipCompressor;

public class CompressionUtils {

    public static char[] STRING_ENCODING_CHARACTERS = {'\u20ac', '\0',
            '\u201a', '\u0192', '\u201e', '\u2026', '\u2020', '\u2021',
            '\u02c6', '\u2030', '\u0160', '\u2039', '\u0152', '\0', '\u017d',
            '\0', '\0', '\u2018', '\u2019', '\u201c', '\u201d', '\u2022',
            '\u2013', '\u2014', '\u02dc', '\u2122', '\u0161', '\u203a',
            '\u0153', '\0', '\u017e', '\u0178'};
    public static final CRC32 crc = new CRC32();

    public static final byte[] writeCompressedData(byte[] bytes, int type) {
        Buffer buffer;
        (buffer = new Buffer(bytes.length + 100)).writeByte(type);
        byte[] buf;
        if (type == 1) {
            buf = null;
        } else {
            buf = GZipCompressor.compress(bytes);
        }
        buffer.writeInt(buf.length);
        if (type > 0) {
            buffer.writeInt(bytes.length);
        }
        int i_3_;
        int i_2_ = i_3_ = 0;
        while (i_2_ < buf.length) {
            buffer.writeByte(buf[i_3_]);
            i_2_ = ++i_3_;
        }
        byte[] in = new byte[buffer.offset];
        buffer.offset = 0;
        buffer.readData(in, 0, in.length);
        return in;
    }

    public static final byte[] readDecompressedData(byte[] bytes) {
        Buffer buffer;
        int type = (buffer = new Buffer(bytes)).readUByte();
        int length;
        if ((length = buffer.readInt3()) < 0) {
            throw new RuntimeException();
        }
        if (type == 0) {
            byte[] buf = new byte[length];
            buffer.readData(buf, 0, length);
            return buf;
        }
        int uncompressedLength;
        if ((uncompressedLength = buffer.readInt3()) < 0) {
            throw new RuntimeException();
        }
        byte[] uncompressed = new byte[uncompressedLength];
        if (type == 1) {
            BZip2Decompressor.decompress(uncompressed, bytes, 9);
        } else {
            GZipDecompressor.decompress(buffer, uncompressed);
        }
        return uncompressed;
    }

    public static final int[] copy(int[] is) {
        int[] copy = new int[is.length];
        System.arraycopy(is, 0, copy, 0, is.length);
        return copy;
    }

    public static final Archive[] an_k_array_method135(
            Archive[] class_ks) {
        Archive[] class_ks_17_ = new Archive[class_ks.length];
        System.arraycopy(class_ks, 0, class_ks_17_, 0, class_ks.length);
        return class_ks_17_;
    }

    static final byte byte_method132(char c) {
        byte i;
        if (c > 0 && c < '\u0080' || c >= '\u00a0' && c <= '\u00ff') {
            i = (byte) c;
        } else if (c != '\u20ac') {
            if (c != '\u201a') {
                if (c != '\u0192') {
                    if (c == '\u201e') {
                        i = (byte) -124;
                    } else if (c != '\u2026') {
                        if (c != '\u2020') {
                            if (c == '\u2021') {
                                i = (byte) -121;
                            } else if (c == '\u02c6') {
                                i = (byte) -120;
                            } else if (c == '\u2030') {
                                i = (byte) -119;
                            } else if (c == '\u0160') {
                                i = (byte) -118;
                            } else if (c == '\u2039') {
                                i = (byte) -117;
                            } else if (c == '\u0152') {
                                i = (byte) -116;
                            } else if (c != '\u017d') {
                                if (c == '\u2018') {
                                    i = (byte) -111;
                                } else if (c != '\u2019') {
                                    if (c != '\u201c') {
                                        if (c == '\u201d') {
                                            i = (byte) -108;
                                        } else if (c != '\u2022') {
                                            if (c == '\u2013') {
                                                i = (byte) -106;
                                            } else if (c == '\u2014') {
                                                i = (byte) -105;
                                            } else if (c == '\u02dc') {
                                                i = (byte) -104;
                                            } else if (c == '\u2122') {
                                                i = (byte) -103;
                                            } else if (c != '\u0161') {
                                                if (c == '\u203a') {
                                                    i = (byte) -101;
                                                } else if (c != '\u0153') {
                                                    if (c == '\u017e') {
                                                        i = (byte) -98;
                                                    } else if (c != '\u0178') {
                                                        i = (byte) 63;
                                                    } else {
                                                        i = (byte) -97;
                                                    }
                                                } else {
                                                    i = (byte) -100;
                                                }
                                            } else {
                                                i = (byte) -102;
                                            }
                                        } else {
                                            i = (byte) -107;
                                        }
                                    } else {
                                        i = (byte) -109;
                                    }
                                } else {
                                    i = (byte) -110;
                                }
                            } else {
                                i = (byte) -114;
                            }
                        } else {
                            i = (byte) -122;
                        }
                    } else {
                        i = (byte) -123;
                    }
                } else {
                    i = (byte) -125;
                }
            } else {
                i = (byte) -126;
            }
        } else {
            i = (byte) -128;
        }
        return i;
    }

    public static final int int_method130(Cache class_n) {
        int i = class_n.getFileSystems()[19].method139() - 1;
        return i * 256 + class_n.getFileSystems()[19].getChildCount(i);
    }

    public static final int djb2(String string) {
        string = string.toLowerCase();
        int hash = 0;
        int index;// Dan Bernstein's djb2 algorithm
        int i = index = 0;
        while (i < string.length()) {
            hash = byte_method132(string.charAt(index)) + ((hash << 5) - hash);
            i = ++index;
        }
        return hash;
    }

    public static final int method134(String string, int i, int i_12_,
                                      byte[] is, int i_13_) {
        int i_14_ = -i + i_12_;
        int i_16_;
        int i_15_ = i_16_ = 0;
        while (i_15_ < i_14_) {
            char c;
            if ((c = string.charAt(i + i_16_)) > 0 && c < '\u0080'
                    || c >= '\u00a0' && c <= '\u00ff') {
                is[i_16_ + i_13_] = (byte) c;
            } else if (c == '\u20ac') {
                is[i_16_ + i_13_] = (byte) -128;
            } else if (c != '\u201a') {
                if (c == '\u0192') {
                    is[i_13_ + i_16_] = (byte) -125;
                } else if (c != '\u201e') {
                    if (c == '\u2026') {
                        is[i_13_ + i_16_] = (byte) -123;
                    } else if (c != '\u2020') {
                        if (c == '\u2021') {
                            is[i_13_ + i_16_] = (byte) -121;
                        } else if (c != '\u02c6') {
                            if (c == '\u2030') {
                                is[i_16_ + i_13_] = (byte) -119;
                            } else if (c == '\u0160') {
                                is[i_13_ + i_16_] = (byte) -118;
                            } else if (c == '\u2039') {
                                is[i_16_ + i_13_] = (byte) -117;
                            } else if (c == '\u0152') {
                                is[i_16_ + i_13_] = (byte) -116;
                            } else if (c == '\u017d') {
                                is[i_16_ + i_13_] = (byte) -114;
                            } else if (c == '\u2018') {
                                is[i_16_ + i_13_] = (byte) -111;
                            } else if (c == '\u2019') {
                                is[i_16_ + i_13_] = (byte) -110;
                            } else if (c == '\u201c') {
                                is[i_13_ + i_16_] = (byte) -109;
                            } else if (c == '\u201d') {
                                is[i_16_ + i_13_] = (byte) -108;
                            } else if (c == '\u2022') {
                                is[i_16_ + i_13_] = (byte) -107;
                            } else if (c != '\u2013') {
                                if (c == '\u2014') {
                                    is[i_16_ + i_13_] = (byte) -105;
                                } else if (c != '\u02dc') {
                                    if (c != '\u2122') {
                                        if (c == '\u0161') {
                                            is[i_16_ + i_13_] = (byte) -102;
                                        } else if (c == '\u203a') {
                                            is[i_13_ + i_16_] = (byte) -101;
                                        } else if (c == '\u0153') {
                                            is[i_13_ + i_16_] = (byte) -100;
                                        } else if (c == '\u017e') {
                                            is[i_13_ + i_16_] = (byte) -98;
                                        } else if (c == '\u0178') {
                                            is[i_16_ + i_13_] = (byte) -97;
                                        } else {
                                            is[i_16_ + i_13_] = (byte) 63;
                                        }
                                    } else {
                                        is[i_13_ + i_16_] = (byte) -103;
                                    }
                                } else {
                                    is[i_16_ + i_13_] = (byte) -104;
                                }
                            } else {
                                is[i_16_ + i_13_] = (byte) -106;
                            }
                        } else {
                            is[i_16_ + i_13_] = (byte) -120;
                        }
                    } else {
                        is[i_13_ + i_16_] = (byte) -122;
                    }
                } else {
                    is[i_16_ + i_13_] = (byte) -124;
                }
            } else {
                is[i_13_ + i_16_] = (byte) -126;
            }
            i_15_ = ++i_16_;
        }
        return i_14_;
    }

    public static final String getStringFromBytes(byte[] buffer, int offset,
                                                  int length) {
        char[] chars = new char[length];
        int finalLength = 0;
        int i_20_ = 0;
        int i_21_ = length;
        while (i_21_ > i_20_) {
            int i_22_;
            if ((i_22_ = buffer[offset + i_20_] & 0xff) != 0) {
                if (i_22_ >= 128 && i_22_ < 160) {
                    int i_23_;
                    if ((i_23_ = STRING_ENCODING_CHARACTERS[i_22_ - 128]) == 0) {
                        i_23_ = 63;
                    }
                    i_22_ = i_23_;
                }
                chars[finalLength++] = (char) i_22_;
            }
            i_20_++;
            i_21_ = length;
        }
        return new String(chars, 0, finalLength);
    }

}