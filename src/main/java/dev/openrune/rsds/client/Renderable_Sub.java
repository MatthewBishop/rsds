package dev.openrune.rsds.client;

import dev.openrune.rsds.GUI;
import dev.openrune.rsds.fs.def.AnimationDefinition;
import dev.openrune.rsds.fs.def.Class_n;

public class Renderable_Sub extends Renderable {

    public int animationId;
    private int anInt_418;
    public int frameId;
    public Model model;
    public AnimationDefinition animationDefinition;

    public Renderable_Sub(Model model, int id) {
        this.model = model;
        animationId = id;
        animationDefinition = AnimationDefinition.getDefinition(GUI.cache, id);
    }

    public Model getRotatedModel() {
        Model model;
        if ((model = this.model) == null) {
            return null;
        }
        int frame;
        if (animationDefinition == null) {
            frame = -1;
        } else if (animationDefinition.frames == null) {
            frame = -1;
        } else {
            frame = animationDefinition.frames[frameId];
        }
        Model model_2;
        (model_2 = new Model(true, Class_n.frameIsNull(frame), false,
                model)).createBones();
        model_2.transform(frame);
        model_2.anIntArrayArray_173 = null;
        model_2.anIntArrayArray_209 = null;
        model_2.light(84, 1000, -90, -580, -90, true);
        return model_2;
    }

    public void method38() {
        if (animationDefinition != null) {
            anInt_418 += 5;
            int delay = animationDefinition.getDelay(frameId);
            if (anInt_418 >= delay) {
                frameId++;
                anInt_418 = 0;
            }
            if (frameId >= animationDefinition.frameCount || frameId < 0) {
                frameId = 0;
            }
        }
    }

}