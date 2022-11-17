package gg.tame.client.module.data.setting.types;

import gg.tame.client.module.AbstractModule;
import gg.tame.client.module.data.setting.Setting;

import java.util.List;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
public class TextFieldSetting extends Setting {

    public TextFieldSetting(AbstractModule container, String name) {
        super(container, name);
    }

    public TextFieldSetting(List<Setting> list, String name) {
        super(list, name);
    }

    public String getValue() {
        return (String) this.value;
    }

}
