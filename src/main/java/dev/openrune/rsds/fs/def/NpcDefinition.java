package dev.openrune.rsds.fs.def;

import java.util.HashMap;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.io.Buffer;
import dev.openrune.rsds.GUI;
import dev.openrune.rsds.client.Model;
import dev.openrune.rsds.ui.ModelViewerFrame;

public class NpcDefinition {

    @SuppressWarnings("rawtypes")
    public static HashMap definitionMap = new HashMap();

    public static int method152(int i) {
        return i & 0x7f;
    }

    public static int method178(int i) {
        if (GUI.revision >= 667) {
            return i >>> 7;
        }
        if (GUI.revision >= 600) {
            return i >>> 7;
        }
        return i >>> 39;
    }

    @SuppressWarnings("unchecked")
    public static NpcDefinition getDefinition(Cache class_n, int id,
                                              boolean bool) {
        if (definitionMap.containsKey(Integer.valueOf(id))) {
            return (NpcDefinition) definitionMap.get(Integer.valueOf(id));
        }
        NpcDefinition definition = new NpcDefinition(class_n, id, bool);
        definitionMap.put(Integer.valueOf(id), definition);
        return definition;
    }

    public static NpcDefinition getDefinition(Cache class_n, int i) {
        return getDefinition(class_n, i, true);
    }

    public int[][] an_an_2Dims_int_array502_502;
    public byte[] an_an_byte_array481_481;
    public int[] client_anIntArray73;
    public int[] childrenIDs;
    public int[] componentModels;
    public short[] colour1;
    public short[] an_an_short_array484_484;
    public short[] colour2;
    public short[] an_an_short_array501_501;
    public String[] actions;
    public boolean an_boolean_491;
    public boolean client_aBoolean84;
    public boolean an_boolean_519;
    private boolean aBoolean527;
    public boolean client_aBoolean87;
    public boolean client_aBoolean93;
    public byte an_byte_483;
    public byte an_byte_485;
    public byte an_byte_522;
    public byte an_byte_526;
    public int client_anInt58;
    public int client_anInt59;
    public int an_int_488;
    public int an_int_489;
    public int client_anInt86;
    public int an_int_494;
    public int client_anInt57;
    public int an_int_497;
    public int an_int_498;
    public int client_anInt85;
    public int standingAnimation;
    public int an_int_503;
    public int client_anInt91;
    public int an_int_506;
    public int an_int_507;
    public int an_int_508;
    public int an_int_509;
    public int client_anInt79;
    public int client_anInt83;
    public int client_anInt92;
    public int client_anInt75;
    public int combatLevel = -1;
    public int client_aByte68;
    public int an_int_524;
    public int walkingAnimation;
    public int client_anInt55;
    public short an_short_490;
    public short an_short_496;
    public short an_short_514;
    public short an_short_531;
    public String name;

    public NpcDefinition(Cache class_n, int i) {
        this(class_n, i, true);
    }

    public NpcDefinition(Cache class_n, int i, boolean bool) {
        an_int_497 = -1;
        an_int_489 = i;
        void_method65();
        if (bool) {
            void_method30(class_n);
        }
    }

    public boolean method179() {
        return aBoolean527;
    }

    public Model o_method159() {
        if (childrenIDs != null) {
            NpcDefinition definition;
            if ((definition = o_method182()) == null) {
                return null;
            }
            return definition.o_method159();
        }
        if (componentModels == null) {
            return null;
        }
        Model[] var_a_sub_46s = new Model[componentModels.length];
        int i_2_;
        int i = i_2_ = 0;
        while (i < componentModels.length) {
            Model[] var_a_sub_46s_3_ = var_a_sub_46s;
            int i_4_ = i_2_;
            if (GUI.modelViewerFrame != null) {
                /* empty */
            }
            var_a_sub_46s_3_[i_4_] = ModelViewerFrame
                    .getModelFromCache(componentModels[i_2_]);
            i = ++i_2_;
        }
        Model var_a_sub_46;
        if (var_a_sub_46s.length == 1) {
            var_a_sub_46 = var_a_sub_46s[0];
        } else {
            var_a_sub_46 = new Model(var_a_sub_46s.length, var_a_sub_46s);
        }
        if (colour1 != null) {
            int i_5_ = i_2_ = 0;
            while (i_5_ < colour1.length) {
                var_a_sub_46.recolor(colour1[i_2_], colour2[i_2_]);
                i_5_ = ++i_2_;
            }
        }
        return var_a_sub_46;
    }

    public NpcDefinition o_method182() {
        int child;
        int i = child = 0;
        while (i < childrenIDs.length && childrenIDs[child] == -1) {
            i = ++child;
        }
        return getDefinition(GUI.cache, childrenIDs[child], true);
    }

    public void void_method156(Buffer buffer) {
        /* empty */
    }

    private void readValues(Buffer buffer) {
        int i;
        while ((i = buffer.readUByte()) != 0) {
            readValues(buffer, i);
        }
    }

    private void readValues(Buffer buffer, int opcode) {
        if (opcode == 1) {
            int i_6_ = buffer.readUByte();
            componentModels = new int[i_6_];
            int i_8_;
            int i_7_ = i_8_ = 0;
            while (i_7_ < i_6_) {
                if (GUI.revision >= 667) {
                    componentModels[i_8_] = buffer.method229();
                    if (componentModels[i_8_] == 65535) {
                        componentModels[i_8_] = -1;
                    }
                } else {
                    componentModels[i_8_] = buffer.readUShort();
                }
                i_7_ = ++i_8_;
            }
        } else if (opcode == 2) {
            name = buffer.readJString();
        } else if (opcode == 12) {
            client_aByte68 = buffer.readUByte();
        } else if (opcode == 13) {
            standingAnimation = buffer.readUShort();
        } else if (opcode == 14) {
            walkingAnimation = buffer.readUShort();
        } else if (opcode == 15) {
            an_int_488 = buffer.readUShort();
        } else if (opcode == 16) {
            an_int_497 = buffer.readUShort();
        } else if (opcode == 17) {
            walkingAnimation = buffer.readUShort();
            client_anInt58 = buffer.readUShort();
            client_anInt83 = buffer.readUShort();
            client_anInt55 = buffer.readUShort();
        } else if (opcode >= 30 && opcode < 35) {
            actions[opcode - 30] = buffer.readJString();
        } else if (opcode == 40) {
            int i_9_ = buffer.readUByte();
            colour1 = new short[i_9_];
            colour2 = new short[i_9_];
            int i_10_ = 0;
            int i_11_ = i_9_;
            while (i_11_ > i_10_) {
                colour1[i_10_] = (short) buffer.readUShort();
                colour2[i_10_] = (short) buffer.readUShort();
                i_10_++;
                i_11_ = i_9_;
            }
        } else if (opcode == 41) {
            int i_12_ = buffer.readUByte();
            an_an_short_array501_501 = new short[i_12_];
            an_an_short_array484_484 = new short[i_12_];
            int i_14_;
            int i_13_ = i_14_ = 0;
            while (i_13_ < i_12_) {
                an_an_short_array501_501[i_14_] = (short) buffer.readUShort();
                an_an_short_array484_484[i_14_] = (short) buffer.readUShort();
                i_13_ = ++i_14_;
            }
        } else if (opcode == 42) {
            int i_15_ = buffer.readUByte();
            an_an_byte_array481_481 = new byte[i_15_];
            int i_16_ = 0;
            int i_17_ = i_15_;
            while (i_17_ > i_16_) {
                an_an_byte_array481_481[i_16_] = buffer.readByte();
                i_16_++;
                i_17_ = i_15_;
            }
        } else if (opcode == 60) {
            int i_18_ = buffer.readUByte();
            client_anIntArray73 = new int[i_18_];
            int i_20_;
            int i_19_ = i_20_ = 0;
            while (i_19_ < i_18_) {
                if (GUI.revision >= 667) {
                    client_anIntArray73[i_20_] = buffer.method229();
                } else {
                    client_anIntArray73[i_20_] = buffer.readUShort();
                }
                i_19_ = ++i_20_;
            }
        } else if (opcode == 93) {
            client_aBoolean87 = false;
        } else if (opcode == 95) {
            combatLevel = buffer.readUShort();
        } else if (opcode == 97) {
            client_anInt91 = buffer.readUShort();
        } else if (opcode == 98) {
            client_anInt86 = buffer.readUShort();
        } else if (opcode == 99) {
            client_aBoolean93 = true;
        } else if (opcode == 100) {
            client_anInt85 = buffer.readByte();
        } else if (opcode == 101) {
            client_anInt92 = buffer.readByte() * 5;
        } else if (opcode == 102) {
            client_anInt75 = buffer.readUShort();
        } else if (opcode == 103) {
            client_anInt79 = buffer.readUShort();
        } else if (opcode == 106 || opcode == 118) {
            client_anInt57 = buffer.readUShort();
            if (client_anInt57 == 65535) {
                client_anInt57 = -1;
            }
            client_anInt59 = buffer.readUShort();
            int i_21_ = -1;
            if (client_anInt59 == 65535) {
                client_anInt59 = -1;
            }
            if (opcode == 118 && (i_21_ = buffer.readUShort()) == 65535) {
                i_21_ = -1;
            }
            int i_22_ = buffer.readUByte();
            childrenIDs = new int[i_22_ + 2];
            int i_24_;
            int i_23_ = i_24_ = 0;
            while (i_23_ <= i_22_) {
                childrenIDs[i_24_] = buffer.readUShort();
                if (childrenIDs[i_24_] == 65535) {
                    childrenIDs[i_24_] = -1;
                }
                i_23_ = ++i_24_;
            }
            childrenIDs[i_22_ + 1] = i_21_;
        } else if (opcode == 107) {
            client_aBoolean84 = false;
        } else if (opcode == 109) {
            an_boolean_491 = false;
        } else if (opcode == 111) {
            an_boolean_519 = false;
        } else if (opcode == 113) {
            an_short_514 = (short) buffer.readUShort();
            an_short_496 = (short) buffer.readUShort();
        } else if (opcode == 114) {
            an_byte_485 = buffer.readByte();
            an_byte_522 = buffer.readByte();
        } else if (opcode == 115) {
            an_short_490 = (short) (buffer.readUByte() * 4);
            an_short_531 = (short) (buffer.readUByte() * 4);
        } else if (opcode == 119) {
            an_byte_483 = buffer.readByte();
        } else if (opcode == 120) {
            an_int_524 = buffer.readUShort();
            an_int_509 = buffer.readUShort();
            an_int_506 = buffer.readUShort();
            an_int_494 = buffer.readUByte();
        } else if (opcode == 121) {
            an_an_2Dims_int_array502_502 = new int[componentModels.length][];
            int i_25_ = buffer.readUByte();
            int i_27_;
            int i_26_ = i_27_ = 0;
            while (i_26_ < i_25_) {
                int i_28_ = buffer.readUByte();
                int[] is;
                (is = an_an_2Dims_int_array502_502[i_28_] = new int[3])[0] = buffer
                        .readByte();
                is[1] = buffer.readByte();
                is[2] = buffer.readByte();
                i_26_ = ++i_27_;
            }
        } else if (opcode == 122) {
            if (GUI.revision >= 667) {
                an_int_508 = buffer.method229();
            } else {
                an_int_508 = buffer.readUShort();
            }
        } else if (opcode == 123) {
            an_int_498 = buffer.readUShort();
        } else if (opcode == 125) {
            an_byte_526 = buffer.readByte();
        } else if (opcode == 126) {
            an_int_503 = buffer.readUShort();
        } else if (opcode == 127) {
            an_int_507 = buffer.readUShort();
            RenderAnimation class_a = RenderAnimation.get(GUI.cache, an_int_507,
                    true);
            standingAnimation = class_a.anInt_383;
            walkingAnimation = class_a.anInt_381;
        } else if (opcode == 128) {
            buffer.readUByte();
        } else if (opcode == 134) {
            if ((buffer.readUShort()) == 65535) {
            }
            if ((buffer.readUShort()) == 65535) {
            }
            if ((buffer.readUShort()) == 65535) {
            }
            if ((buffer.readUShort()) == 65535) {
            }
            buffer.readUByte();
        } else if (opcode == 135) {
            buffer.readUByte();
            buffer.readUShort();
        } else if (opcode == 136) {
            buffer.readUByte();
            buffer.readUShort();
        } else if (opcode == 137) {
            if (GUI.revision >= 667) {
                buffer.method229();
            } else {
                buffer.readUShort();
            }
        } else if (opcode == 138) {
            if (GUI.revision >= 667) {
                buffer.method229();
            } else {
                buffer.readUShort();
            }
        } else if (opcode == 139) {
            buffer.readUShort();
        } else if (opcode == 140) {
            buffer.readUByte();
        } else if (opcode == 141) {
        } else if (opcode == 142) {
            buffer.readUShort();
        } else if (opcode == 143) {
        } else if (opcode >= 150 && opcode < 155) {
            actions[opcode - 150] = buffer.readJString();
        } else if (opcode == 155) {
            buffer.readByte();
            buffer.readByte();
            buffer.readByte();
            buffer.readByte();
        } else if (opcode != 158 && opcode != 159) {
            if (opcode == 160) {
                int i_45_;
                int[] is = new int[i_45_ = buffer.readUByte()];
                int i_46_ = 0;
                int i_47_ = i_45_;
                while (i_47_ > i_46_) {
                    is[i_46_] = buffer.readUShort();
                    i_46_++;
                    i_47_ = i_45_;
                }
            } else if (opcode == 161) {
            } else if (opcode == 162) {
            } else if (opcode == 163) {
                buffer.readUByte();
            } else if (opcode == 164) {
                buffer.readUShort();
                buffer.readUShort();
            } else if (opcode == 165) {
                buffer.readUByte();
            } else if (opcode == 168) {
                buffer.readUByte();
            } else if (opcode == 249) {
                int i_53_ = buffer.readUByte();
                int i_55_;
                int i_54_ = i_55_ = 0;
                while (i_54_ < i_53_) {
                    boolean bool = buffer.readUByte() == 1;
                    buffer.readMediumInt2();
                    if (!bool) {
                        buffer.int_method138();
                    } else {
                        buffer.readJString();
                    }
                    i_54_ = ++i_55_;
                }
            } else {
                System.out.println(new StringBuilder()
                        .append("UNRECOGNIZED NPCDEF OPCODE: ").append(opcode)
                        .toString());
            }
        }
    }

    private void void_method30(Cache class_n) {
        byte[] is;
        if ((is = class_n.getFileSystems()[18].getFile(method178(an_int_489),
                method152(an_int_489))) == null) {
            System.out.println(new StringBuilder()
                    .append("FAILED LOADING NPCDEF ").append(an_int_489)
                    .toString());
        } else {
            readValues(new Buffer(is));
            aBoolean527 = true;
        }
    }

    private void void_method65() {
        an_byte_485 = (byte) -96;
        client_aByte68 = 1;
        client_anInt91 = 128;
        an_int_524 = -1;
        name = null;
        an_short_514 = (short) 0;
        an_byte_526 = (byte) 7;
        an_int_509 = -1;
        an_int_508 = -1;
        an_short_490 = (short) 0;
        actions = new String[5];
        an_int_503 = -1;
        client_anInt83 = -1;
        walkingAnimation = -1;
        client_anInt75 = -1;
        client_anInt57 = -1;
        client_anInt58 = -1;
        an_boolean_519 = true;
        an_short_496 = (short) 0;
        client_anInt79 = 32;
        an_byte_522 = (byte) -16;
        an_short_531 = (short) 0;
        client_aBoolean84 = true;
        client_anInt55 = -1;
        client_anInt85 = 0;
        client_anInt59 = -1;
        an_boolean_491 = true;
        client_aBoolean93 = false;
        standingAnimation = -1;
        an_int_507 = -1;
        an_int_488 = -1;
        an_int_506 = -1;
        an_int_494 = 0;
        client_anInt92 = 0;
        client_anInt86 = 128;
        client_aBoolean87 = true;
        an_byte_483 = (byte) 0;
        an_int_498 = -1;
    }

}