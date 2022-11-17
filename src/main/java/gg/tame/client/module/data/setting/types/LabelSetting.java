package gg.tame.client.module.data.setting.types;

import gg.tame.client.module.AbstractModule;
import gg.tame.client.module.data.setting.Setting;

import java.util.List;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
public class LabelSetting extends Setting {

    public LabelSetting(AbstractModule container, String name) {
        super(container, name);
    }

    public LabelSetting(List<Setting> list, String name) {
        super(list, name);
    }

}
