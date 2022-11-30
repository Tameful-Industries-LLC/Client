package gg.tame.client.module.data.setting.types.string;

import gg.tame.client.module.AbstractModule;
import gg.tame.client.module.data.setting.Setting;
import lombok.Getter;

import java.util.List;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
@Getter
public class LabelSetting extends Setting {

    private boolean hidden;

    public LabelSetting(AbstractModule container, String name) {
        super(container, name);
    }

    public LabelSetting(List<Setting> list, String name) {
        super(list, name);
    }

    public LabelSetting setHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

}
