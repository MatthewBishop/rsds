package dev.openrune.rsds.client;

import dev.openrune.rsds.GUI;
import dev.openrune.rsds.fs.def.Class_n;
import dev.openrune.rsds.fs.def.GraphicDefinition;

public class AnimableObject extends Renderable {

    public boolean transformationComplete = false;
    public int elapsedFrames;
    public final int anInt_232;
    public final int cycle;
    public final int anInt_235;
    private int duration;
    public final int anInt_237;
    public final int anInt_238;
    private final GraphicDefinition graphic;

    public AnimableObject(int i, int currentTime, int delay, int graphicId,
                          int i_5_, int i_6_, int i_7_) {
        graphic = GraphicDefinition
                .getDefinition(GUI.cache, graphicId);
        anInt_235 = i; // z
        anInt_238 = i_7_; // x
        anInt_237 = i_6_; // y
        anInt_232 = i_5_; // render height
        cycle = currentTime + delay;
        transformationComplete = false;
    }

    @Override
    public Model getRotatedModel() {
        Model model;
        if ((model = graphic.getModel()) == null) {
            return null;
        }
        int frame;
        if (graphic.animationDefinition == null) {
            frame = -1;
        } else {
            frame = graphic.animationDefinition.frames[elapsedFrames];
        }
        Model model_2;
        (model_2 = new Model(true, Class_n.frameIsNull(frame), false,
                model)).createBones();
        model_2.transform(frame);
        model_2.anIntArrayArray_173 = null;
        model_2.anIntArrayArray_209 = null;
        if (graphic.client_anInt410 != 128 || graphic.client_anInt411 != 128) {
            model_2.scale(graphic.client_anInt410, graphic.client_anInt410,
                    graphic.client_anInt411);
        }
        if (graphic.rotation != 0) {
            if (graphic.rotation == 90) {
                model_2.rotate90Degrees();
            }
            if (graphic.rotation == 180) {
                model_2.rotate90Degrees();
                model_2.rotate90Degrees();
            }
            if (graphic.rotation == 270) {
                model_2.rotate90Degrees();
                model_2.rotate90Degrees();
                model_2.rotate90Degrees();
            }
        }
        model_2.light(84, 1000, -90, -580, -90, true);
        return model_2;
    }

    public void method38() {
        if (graphic.animationDefinition != null) {
            duration++;
            int delay = graphic.animationDefinition.getDelay(elapsedFrames);
            if (duration >= delay) {
                elapsedFrames++;
            }
            if (elapsedFrames >= graphic.animationDefinition.frameCount
                    || elapsedFrames < 0) {
                elapsedFrames = 0;
            }
        }
    }

    public void nextAnimationStep(int elapsedTime) {
        duration += elapsedTime;
        outer:
        for (; ; ) {
            AnimableObject var_a_sub_53_0_ = this;
            for (; ; ) {
                if (var_a_sub_53_0_.duration <= graphic.animationDefinition
                        .getDelay(elapsedFrames)) {
                    break outer;
                }
                duration -= graphic.animationDefinition.getDelay(elapsedFrames) + 1;
                elapsedFrames++;
                if (elapsedFrames < graphic.animationDefinition.frameCount
                        || elapsedFrames >= 0
                        && elapsedFrames < graphic.animationDefinition.frameCount) {
                    break;
                }
                elapsedFrames = 0;
                var_a_sub_53_0_ = this;
            }
        }
    }

}