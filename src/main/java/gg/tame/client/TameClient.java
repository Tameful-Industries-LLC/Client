package gg.tame.client;

import gg.tame.client.ui.pack.ResourcePackManager;
import gg.tame.client.config.GlobalSettings;
import gg.tame.client.controller.impl.resource.ResourceController;
import gg.tame.client.event.EventBus;
import gg.tame.client.module.ModuleManager;
import lombok.Getter;
import net.minecraft.client.Minecraft;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
@Getter
public class TameClient {

    @Getter public static TameClient instance;

    private final Minecraft mc = Minecraft.getMinecraft();

    private final EventBus eventBus;
    private final GlobalSettings globalSettings;
    private final ModuleManager moduleManager;

    private final ResourceController resourceController;

    public TameClient() {
        instance = this;

        this.eventBus = new EventBus();

        // Events
        this.moduleManager = new ModuleManager();
        new ResourcePackManager();

        // Mods
        this.globalSettings = new GlobalSettings();

        // Settings
        (this.resourceController = new ResourceController()).onLoad();

    }

}
