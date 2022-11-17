package gg.tame.client.ui.elements.button;

import gg.tame.client.TameClient;
import gg.tame.client.ui.elements.AbstractElement;
import gg.tame.client.ui.elements.fade.types.ColorFade;
import gg.tame.client.ui.util.RenderUtil;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
public class MainMenuButton extends AbstractElement {

    // colors we will be using for the main menu buttons.
    private final int bgColor = -1357507050;
    private final int hoveredBgColor = 0x80462EE3;

    private final String text;
    private final ColorFade colorFade = new ColorFade(bgColor, hoveredBgColor);

    public MainMenuButton(String text) {
        this.text = text;
    }

    @Override
    public void handleDraw(float x, float y, boolean isHovering) {

        // draw background
        RenderUtil.drawRoundedRect(
                this.xPosition, this.yPosition,
                this.xPosition + this.width,
                this.yPosition + this.height + 1,
                8, colorFade.getColor(this.isMouseInside(x, y)).getRGB()
        );

        // draw an outline on hover
        if (this.isMouseInside(x, y)) {
            RenderUtil.drawRoundedOutline(
                    this.xPosition, this.yPosition,
                    this.xPosition + this.width,
                    this.yPosition + this.height + 1,
                    8, 2.3f, 0xB3FFFFFF);
        }

        // draw using font renderer
        TameClient.getInstance().getResourceController().getDosisBold16px().drawCenteredString(
                this.text, this.xPosition + this.width / 2.0f, this.yPosition + 4.5F, -1
        );

    }
}
