package gg.tame.client.module.data.setting.types;

import gg.tame.client.module.AbstractModule;
import gg.tame.client.module.data.setting.Setting;

import java.util.List;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
public class BooleanSetting extends Setting {

    public BooleanSetting(AbstractModule container, String name) {
        super(container, name);
    }

    public BooleanSetting(List<Setting> list, String name) {
        super(list, name);
    }

    public Boolean getValue() {
        return (boolean) this.value;
    }

    public BooleanSetting setValue(boolean value) {
        this.value = value;
        return this;
    }

}
