package inf112.skeleton.app.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.skeleton.app.view.texturepack.ITexturePack;

public class Hud extends Stage {
    private static final int IMG_SIZE = 16;
    private static final int TEXT_WIDTH = 10;
    private static final int TEXT_HEIGHT = 20;
    private final ViewableGameModel model;
    private final ITexturePack texturePack;
    private final Image itemIcon;
    private final Label itemDurability;
    private final Image effectIcon;
    private final Image effectDuration;

    public Hud(SpriteBatch batch, ViewableGameModel model, ITexturePack texturePack) {
        super(new ExtendViewport(GameView.VIEWPORT_WIDTH * 20,GameView.VIEWPORT_HEIGHT / GameView.VIEWPORT_WIDTH * 20, new OrthographicCamera()), batch);
        this.model = model;
        this.texturePack = texturePack;

        Label.LabelStyle style = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        itemIcon = new Image(new BaseDrawable());
        itemDurability = new Label("", style);
        effectIcon = new Image(new BaseDrawable());
        effectDuration = new Image(new BaseDrawable());

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        fillTable(table);
        addActor(table);
    }

    private void fillTable(Table table) {
        Table inventory = new Table();
        inventory.setBackground(new SpriteDrawable(new Sprite(texturePack.getInventorySlot())));
        inventory.add(itemIcon);
        inventory.add(itemDurability);

        Table effects = new Table();
        effects.left();
        effects.add(effectIcon);
        effects.row().left();
        effects.add(effectDuration);

        table.top().left();
        table.padLeft(10).padTop(10);
        table.add(inventory).width(IMG_SIZE + TEXT_WIDTH * 2).height(TEXT_HEIGHT);
        table.row().left();
        table.add(effects);
    }

    private void updateItemActors() {
        ViewableItem item = model.getViewablePlayer().getItem();
        boolean isFilled = itemIcon.getWidth() != 0;

        if (item != null) {
            if (!isFilled) {
                itemIcon.setDrawable(new SpriteDrawable(new Sprite(texturePack.getItemTexture(item))));
            }
            itemDurability.setText(item.getDurability().remaining());
        } else {
            if (isFilled) {
                itemIcon.setDrawable(new BaseDrawable());
                itemDurability.setText("");
            }
        }
    }

    private void updateEffectActors() {
        ViewableEffect effect = model.getViewablePlayer().getEffect();
        boolean isFilled = effectIcon.getWidth() != 0;

        if (effect != null) {
            if (!isFilled) {
                effectIcon.setDrawable(new SpriteDrawable(new Sprite(texturePack.getItemTexture(effect.getItem()))));
            }
            float wp = model.getViewablePlayer().getEffect().getDuration().remaining() / (float) model.getViewablePlayer().getEffect().getDuration().maximum();
            Pixmap pm = new Pixmap(IMG_SIZE,IMG_SIZE / 4, Pixmap.Format.RGBA8888);
            pm.setColor(Color.GREEN);
            pm.fillRectangle(0,0, (int) (IMG_SIZE * wp), IMG_SIZE / 4);
            effectDuration.setDrawable(new SpriteDrawable(new Sprite(new Texture(pm))));
        } else {
            if (isFilled) {
                effectIcon.setDrawable(new BaseDrawable());
            }
            effectDuration.setDrawable(new BaseDrawable());
        }
    }

    private void update() {
        updateItemActors();
        updateEffectActors();
    }

    @Override
    public void draw() {
        update();
        super.draw();
    }
}
