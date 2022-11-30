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
public class SliderSetting extends Setting {

    private int min;
    private int max;

    public SliderSetting(AbstractModule container, String name) {
        super(container, name);
    }

    public SliderSetting(List<Setting> list, String name) {
        super(list, name);
    }

    public SliderSetting setMinMax(int min, int max) {
        this.min = min;
        this.max = max;
        return this;
    }

    public Integer getValue() {
        return (int) this.value;
    }

    public boolean isChangable() {
        int value = (int) this.value;
        return value >= this.max && value <= this.min;
    }

}
