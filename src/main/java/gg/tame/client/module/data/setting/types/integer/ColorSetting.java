package gg.tame.client.module.data.setting.types.integer;

import gg.tame.client.module.AbstractModule;
import gg.tame.client.module.data.setting.Setting;
import lombok.Getter;

import java.util.List;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
@Getter
public class ColorSetting extends Setting {

    private boolean chroma = false;

    public ColorSetting(AbstractModule container, String name) {
        super(container, name);
    }

    public ColorSetting(List<Setting> list, String name) {
        super(list, name);
    }

    public ColorSetting setValue(int value) {
        this.value = value;
        return this;
    }

    public ColorSetting setChroma(boolean chroma) {
        this.chroma = chroma;
        return this;
    }

    public int getColorValue() {
        // TODO: Implement chroma
        return (int) this.value;
    }

}
