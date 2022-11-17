package gg.tame.client.ui.pack;

import gg.tame.client.TameClient;
import gg.tame.client.event.data.Subscriber;
import gg.tame.client.event.impl.InitializationEvent;
import gg.tame.client.ui.pack.utils.PackUtils;
import gg.tame.client.ui.pack.utils.ThreadUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ResourcePackRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
public class ResourcePackManager {

    private final Minecraft mc = Minecraft.getMinecraft();

    public ResourcePackManager() {
        TameClient.getInstance().getEventBus().addEvent(InitializationEvent.class, this::onInit);
    }

    @Subscriber
    public void onInit(InitializationEvent event) {
        HashMap<String, ResourcePackRepository.Entry> activeEntries = new HashMap<>();
        for (String packName : this.mc.gameSettings.resourcePacks) {
            activeEntries.put(packName, null);
        }

        for (ResourcePackRepository.Entry entry : this.mc.getResourcePackRepository().getRepositoryEntries()) {
            activeEntries.put(entry.getResourcePackName(), entry);
        }

        for (ResourcePackRepository.Entry entry : PackUtils.getActiveEntries()) {
            activeEntries.put(entry.getResourcePackName(), entry);
        }

        activeEntries.values().removeIf(Objects::isNull);
        this.mc.getResourcePackRepository().setRepositories(new ArrayList<>(activeEntries.values()));
        this.mc.refreshResources();
        Runtime.getRuntime().addShutdownHook(new Thread(ThreadUtils::shutdown));
    }

}
