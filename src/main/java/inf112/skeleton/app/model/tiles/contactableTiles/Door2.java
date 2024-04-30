package inf112.skeleton.app.model.tiles.contactableTiles;

import com.badlogic.gdx.physics.box2d.*;
import inf112.skeleton.app.event.Event;
import inf112.skeleton.app.event.EventBus;
import inf112.skeleton.app.model.TileFactory;
import inf112.skeleton.app.model.event.EventReachedDoor;
import inf112.skeleton.app.model.tiles.TileModel;

public class Door2 extends DoorModel {
    public static final char KEY = '8';

    /**
     * Creates a {@link TileModel} with default width and height.
     * <p>
     * Used for {@link inf112.skeleton.app.model.TileFactory}.
     *
     * @param world that the body is added to
     * @param bus   that is used for handling and posting {@link inf112.skeleton.app.event.Event}s
     * @param x     left-most position in the horizontal axis
     * @param y     bottom-most position in the vertical axis
     */
    public Door2(World world, EventBus bus, float x, float y) {
        this(world, bus, x + TILE_HEIGHT / 2, y + TILE_HEIGHT / 4, TILE_WIDTH / 2, TILE_HEIGHT / 2);
    }

    /**
     * Creates a {@link TileModel} and places its body in
     * the specified {@link World}.
     *
     * @param world that the body is added to
     * @param x     center position in the horizontal axis
     * @param y     center position in the vertical axis
     * @param w     width of body
     * @param h     height of body
     */
    public Door2(World world, EventBus bus, float x, float y, float w, float h) {
        super(world, bus, x, y, w, h);
        body.getFixtureList().get(0).setUserData(this);
    }
}
