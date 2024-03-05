package inf112.skeleton.app.view.texturepack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.skeleton.app.model.tiles.*;
import inf112.skeleton.app.view.ViewableTile;

public class TexturePack implements ITexturePack {
    private static final TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("atlas/gameAtlas.atlas"));
    public static final String TILE = "tile";
    // Legg til mer hvis vi vil ha andre sprite

    // DO not use tilemode :D stupid fortids-Johnny (acoustic fuck)
    // future note to self, add "tile".loadStatic into main
    @Override
    public TextureRegion getTileTexture(ViewableTile tile) {

        // testing indices 8bytt ut til riktig når tiden er inne)
        if (tile instanceof TileGroundCornerRight) {
            return new TextureRegion(atlas.findRegion(TILE, 51));
        }
        else if (tile instanceof TileGroundCornerLeft) {
            return new TextureRegion(atlas.findRegion(TILE, 49));
        }
        else if (tile instanceof TileGround) {
            return  new TextureRegion(atlas.findRegion(TILE, 50));
        }
        else if (tile instanceof Barrel) {
            return new TextureRegion(atlas.findRegion(TILE, 55));
        }

        // legg til mer ettersom mer tile klasser blir lagt
        return null;
    }

}