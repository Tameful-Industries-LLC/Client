package gg.tame.client.controller.impl.resource;

import gg.tame.client.controller.Controller;
import gg.tame.client.util.font.NFontRenderer;
import lombok.Getter;
import net.minecraft.util.ResourceLocation;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
@Getter
public class ResourceController extends Controller {

    private NFontRenderer dosisBold14px;
    private NFontRenderer dosisBold16px;
    private NFontRenderer dosisBold20px;

    @Override
    public void onLoad() {
        this.dosisBold14px = new NFontRenderer(new ResourceLocation("client/font/Dosis-Bold.ttf"), 14.0F);
        this.dosisBold16px = new NFontRenderer(new ResourceLocation("client/font/Dosis-Bold.ttf"), 16.0F);
        this.dosisBold20px = new NFontRenderer(new ResourceLocation("client/font/Dosis-Bold.ttf"), 20.0F);
    }

}
