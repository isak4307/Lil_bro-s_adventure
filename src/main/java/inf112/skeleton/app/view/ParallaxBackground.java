package inf112.skeleton.app.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class ParallaxBackground extends Actor {
    private Array<Texture> layers;
    private final float x, y, width, height;

    public ParallaxBackground(Array<Texture> textures) {
        layers = textures;
        for (int i = 0; i < textures.size; i++) {
            layers.get(i).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }
        x = y = 0;
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);
        for (int i = 0; i < layers.size; i++) {
            batch.draw(layers.get(i),x,y,width,height);
        }
    }
}