package gg.tame.client.module;

import gg.tame.client.module.AbstractModule;
import gg.tame.client.module.impl.fix.ModernKeybindHandling;
import gg.tame.client.module.impl.hud.ModuleFPS;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class ModuleManager {

    private final List<AbstractModule> modules = new CopyOnWriteArrayList<>();

    private final ModernKeybindHandling modernKeybindHandling;

    private final ModuleFPS fps;

    public ModuleManager() {
        this.modules.add(this.fps = new ModuleFPS());

        this.modernKeybindHandling = new ModernKeybindHandling(); // incase we ever need to access it.
    }

}
