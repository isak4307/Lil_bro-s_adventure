package inf112.lilBro.app.view.texturepack;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import inf112.lilBro.app.model.PlayerState;
import inf112.lilBro.app.model.tiles.TileModel;
import inf112.lilBro.app.view.ViewableEffect;
import inf112.lilBro.app.view.ViewableItem;
import inf112.lilBro.app.view.ViewableTile;

public interface ITexturePack {
    /**
     * Returns a {@link TextureRegion} based on the specified {@link TileModel}.
     *
     * @param tile that is used for selecting the {@link TextureRegion}
     * @return {@link TextureRegion} based on the {@link TileModel}
     */
    TextureRegion getTileTexture(ViewableTile tile);

    /**
     * Returns a {@link TextureRegion} based on the player's
     * {@link PlayerState} and the model's {@code stateTime}.
     *
     * @param state the {@link PlayerState} the player currently is in
     * @return the {@link TextureRegion} for the given {@link PlayerState}
     */
    TextureRegion getPlayerTexture(PlayerState state, float stateTime);


    /**
     * Returns a {@link TextureRegion} based on class of the {@link ViewableItem}.
     *
     * @param item that is used to get the {@link TextureRegion}
     * @return the {@link TextureRegion} for the given {@link ViewableItem}
     */
    TextureRegion getItemTexture(ViewableItem item);

    /**
     * Returns a {@link TextureRegion} based on class of the {@link ViewableEffect}.
     *
     * @param effect that is used to get the {@link TextureRegion}
     * @return the {@link TextureRegion} for the given {@link ViewableEffect}
     */
    TextureRegion getEffectTexture(ViewableEffect effect);

    /**
     * @return a {@link TextureRegion} of the inventory slot
     */
    TextureRegion getInventorySlot();

    /**
     * Get the texture of the Hp Icon
     *
     * @return {@link TextureRegion} for the given Hp texture
     */
    TextureRegion getHpTexture();
}
