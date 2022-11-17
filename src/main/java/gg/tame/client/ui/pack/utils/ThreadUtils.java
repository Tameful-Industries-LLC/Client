package gg.tame.client.ui.pack.utils;

import net.minecraft.client.Minecraft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
public class ThreadUtils {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

    public static void execute(Runnable task) {
        EXECUTOR_SERVICE.execute(task);
    }

    public static void shutdown() {
        Minecraft.getMinecraft().gameSettings.saveOptions();
        EXECUTOR_SERVICE.shutdown();
    }

}