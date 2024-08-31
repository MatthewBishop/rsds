/* Class_a - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package dev.openrune.rsds.fs.def;

import dev.openrune.rsds.fs.Cache;
import dev.openrune.rsds.io.Buffer;

import java.util.HashMap;

public class RenderAnimation {

    @SuppressWarnings("rawtypes")
    public static HashMap caches = new HashMap();

    public static RenderAnimation get(Cache cache, int i) {
        return get(cache, i, true);
    }

    @SuppressWarnings("unchecked")
    public static RenderAnimation get(Cache cache, int id, boolean bool) {
        if (caches.containsKey(Integer.valueOf(id))) {
            return (RenderAnimation) caches.get(Integer.valueOf(id));
        }
        RenderAnimation animation = new RenderAnimation(cache, id, bool);
        caches.put(Integer.valueOf(id), animation);
        return animation;
    }

    public int[][] anIntArrayArray_409;
    public int[] anIntArray_377;
    public int[] anIntArray_387;
    public int[] anIntArray_410;
    public boolean an_boolean_371;
    private boolean loaded;
    public int anInt_368;
    public int anInt_369;
    public int anInt_370;
    public int anInt_372;
    public int anInt_373;
    public int anInt_374;
    public int anInt_375;
    public int anInt_376;
    public int anInt_378;
    public int anInt_379;
    public int anInt_380;
    public int anInt_381;
    public int anInt_382;
    public int anInt_383;
    public int anInt_384;
    public int anInt_385;
    public int anInt_386;
    public int anInt_388;
    public int anInt_389;
    public int anInt_390;
    public int anInt_391;
    public int anInt_393;
    public int anInt_394 = -1;
    public int anInt_396;
    public int anInt_397;
    public int anInt_398;
    public int anInt_399;
    public int anInt_400;
    public int anInt_401;
    public int anInt_402;
    public int anInt_403;
    public int file;
    public int anInt_405;
    public int anInt_406;
    public int anInt_407;
    public int anInt_408;

    public RenderAnimation(Cache cache, int file) {
        this(cache, file, true);
    }

    public RenderAnimation(Cache cache, int file,
                           boolean loadingRequired) {
        anInt_369 = -1;
        anInt_407 = 0;
        anIntArray_377 = null;
        this.file = file;
        resetValues();
        if (loadingRequired) {
            load(cache);
        }
    }

    public boolean loaded() {
        return loaded;
    }

    private void readValues(Buffer buffer) {
        int opcode;
        while ((opcode = buffer.readUByte()) != 0) {
            readValue(buffer, opcode);
        }
    }

    private void readValue(Buffer buffer, int i) {
        if (i == 54) {
        } else if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            anInt_389 = buffer.readUShort2();
                        } else if (i != 6) {
                            if (i == 7) {
                                anInt_390 = buffer.readUShort2();
                            } else if (i == 8) {
                                anInt_372 = buffer.readUShort2();
                            } else if (i == 9) {
                                anInt_386 = buffer.readUShort2();
                            } else if (i == 26) {
                                anInt_405 = (short) (buffer.readUByte2() * 4);
                                anInt_374 = (short) (buffer.readUByte2() * 4);
                            } else if (i == 27) {
                                if (anIntArrayArray_409 == null) {
                                    anIntArrayArray_409 = new int[12][];
                                }
                                int i_2_ = buffer.readUByte2();
                                anIntArrayArray_409[i_2_] = new int[6];
                                int i_4_;
                                int i_3_ = i_4_ = 0;
                                while (i_3_ < 6) {
                                    anIntArrayArray_409[i_2_][i_4_] = buffer
                                            .readShort();
                                    i_3_ = ++i_4_;
                                }
                            } else if (i == 28) {
                                anIntArray_410 = new int[12];
                                int i_6_;
                                int i_5_ = i_6_ = 0;
                                while (i_5_ < 12) {
                                    anIntArray_410[i_6_] = buffer.readUByte2();
                                    if (anIntArray_410[i_6_] == 255) {
                                        anIntArray_410[i_6_] = -1;
                                    }
                                    i_5_ = ++i_6_;
                                }
                            } else if (i != 29) {
                                if (i != 30) {
                                    if (i != 31) {
                                        if (i != 32) {
                                            if (i != 33) {
                                                if (i != 34) {
                                                    if (i != 35) {
                                                        if (i != 36) {
                                                            if (i != 37) {
                                                                if (i != 38) {
                                                                    if (i != 39) {
                                                                        if (i != 40) {
                                                                            if (i == 41) {
                                                                                anInt_369 = buffer
                                                                                        .readUShort2();
                                                                            } else if (i != 42) {
                                                                                if (i == 43) {
                                                                                    buffer.readUShort2();
                                                                                } else if (i != 44) {
                                                                                    if (i == 45) {
                                                                                        anInt_370 = buffer
                                                                                                .readUShort2();
                                                                                    } else if (i != 46) {
                                                                                        if (i == 47) {
                                                                                            anInt_385 = buffer
                                                                                                    .readUShort2();
                                                                                        } else if (i == 48) {
                                                                                            anInt_403 = buffer
                                                                                                    .readUShort2();
                                                                                        } else if (i != 49) {
                                                                                            if (i != 50) {
                                                                                                if (i != 51) {
                                                                                                    if (i == 52) {
                                                                                                        int i_7_ = buffer
                                                                                                                .readUByte2();
                                                                                                        anIntArray_377 = new int[i_7_];
                                                                                                        anIntArray_387 = new int[i_7_];
                                                                                                        int i_9_;
                                                                                                        int i_8_ = i_9_ = 0;
                                                                                                        while (i_8_ < i_7_) {
                                                                                                            anIntArray_387[i_9_] = buffer
                                                                                                                    .readUShort2();
                                                                                                            int i_10_ = buffer
                                                                                                                    .readUByte2();
                                                                                                            anIntArray_377[i_9_] = i_10_;
                                                                                                            anInt_402 += i_10_;
                                                                                                            i_8_ = ++i_9_;
                                                                                                        }
                                                                                                    } else if (i == 53) {
                                                                                                        an_boolean_371 = false;
                                                                                                    }
                                                                                                } else {
                                                                                                    anInt_379 = buffer
                                                                                                            .readUShort2();
                                                                                                }
                                                                                            } else {
                                                                                                anInt_396 = buffer
                                                                                                        .readUShort2();
                                                                                            }
                                                                                        } else {
                                                                                            anInt_375 = buffer
                                                                                                    .readUShort2();
                                                                                        }
                                                                                    } else {
                                                                                        anInt_378 = buffer
                                                                                                .readUShort2();
                                                                                    }
                                                                                } else {
                                                                                    anInt_400 = buffer
                                                                                            .readUShort2();
                                                                                }
                                                                            } else {
                                                                                anInt_393 = buffer
                                                                                        .readUShort2();
                                                                            }
                                                                        } else {
                                                                            anInt_376 = buffer
                                                                                    .readUShort2();
                                                                        }
                                                                    } else {
                                                                        anInt_397 = buffer
                                                                                .readUShort2();
                                                                    }
                                                                } else {
                                                                    anInt_368 = buffer
                                                                            .readUShort2();
                                                                }
                                                            } else {
                                                                anInt_394 = buffer
                                                                        .readUByte2();
                                                            }
                                                        } else {
                                                            anInt_388 = buffer
                                                                    .readShort();
                                                        }
                                                    } else {
                                                        anInt_406 = buffer
                                                                .readUShort2();
                                                    }
                                                } else {
                                                    anInt_382 = buffer
                                                            .readUByte2();
                                                }
                                            } else {
                                                anInt_373 = buffer.readShort();
                                            }
                                        } else {
                                            anInt_407 = buffer.readUShort2();
                                        }
                                    } else {
                                        anInt_391 = buffer.readUByte2();
                                    }
                                } else {
                                    anInt_401 = buffer.readUShort2();
                                }
                            } else {
                                anInt_384 = buffer.readUByte2();
                            }
                        } else {
                            anInt_380 = buffer.readUShort2();
                        }
                    } else {
                        anInt_399 = buffer.readUShort2();
                    }
                } else {
                    anInt_398 = buffer.readUShort2();
                }
            } else {
                anInt_408 = buffer.readUShort2();
            }
        } else {
            anInt_383 = buffer.readUShort2();
            anInt_381 = buffer.readUShort2();
            if (anInt_383 == 65535) {
                anInt_383 = -1;
            }
            if (anInt_381 == 65535) {
                anInt_381 = -1;
            }
        }
    }

    private void resetValues() {
        anInt_386 = -1;
        anInt_397 = -1;
        anInt_390 = -1;
        anInt_368 = -1;
        anInt_388 = 0;
        anInt_405 = 0;
        anInt_376 = -1;
        anInt_373 = 0;
        anInt_383 = -1;
        anIntArray_387 = null;
        anInt_375 = -1;
        anInt_378 = -1;
        anInt_372 = -1;
        anInt_379 = -1;
        anInt_385 = -1;
        anInt_389 = -1;
        anInt_374 = 0;
        anInt_380 = -1;
        anInt_391 = 0;
        anInt_393 = -1;
        anInt_398 = -1;
        anInt_401 = 0;
        anInt_370 = -1;
        anInt_381 = -1;
        anInt_399 = -1;
        an_boolean_371 = true;
        anInt_384 = 0;
        anInt_400 = -1;
        anInt_403 = -1;
        anInt_408 = -1;
        anInt_406 = 0;
        anInt_402 = 0;
        anInt_396 = -1;
        anInt_382 = 0;
    }

    private void load(Cache cache) {
        byte[] data;
        if ((data = cache.getFileSystems()[2].getFile(32, file)) == null) {
            System.out.println(new StringBuilder()
                    .append("FAILED LOADING RENDERANIM ").append(file)
                    .toString());
        } else {
            readValues(new Buffer(data));
            loaded = true;
        }
    }

}