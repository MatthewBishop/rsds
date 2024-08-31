/* Class_a - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package dev.openrune.rsds.client;

public class Renderable {

    VertexNormal[] vertexNormals;
    public int modelHeight = 1000;

    Renderable() {
        /* empty */
    }

    Model getRotatedModel() {
        return null;
    }

    public void render(int i, int i_0_, int i_1_, int i_2_, int i_3_,
                       int i_4_, int i_5_, int i_6_, int i_7_) {
        Model model;
        if ((model = getRotatedModel()) != null) {
            modelHeight = model.modelHeight;
            model.render(i, i_0_, i_1_, i_2_, i_3_, i_4_, i_5_, i_6_,
                    i_7_);
        }
    }
}
