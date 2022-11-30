package gg.tame.client.module.data.setting.types.string;

import gg.tame.client.module.AbstractModule;
import gg.tame.client.module.data.setting.Setting;
import lombok.Getter;

import java.util.List;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
public class ChoiceSetting extends Setting {

    @Getter
    private String[] acceptedValues;

    public ChoiceSetting(AbstractModule container, String name) {
        super(container, name);
    }

    public ChoiceSetting(List<Setting> list, String name) {
        super(list, name);
    }

    public String getValue() {
        return (String) this.value;
    }

    public ChoiceSetting setAcceptedValues(String... values) {
        this.acceptedValues = values;
        return this;
    }

    public ChoiceSetting setValue(String value) {
        this.value = value;
        return this;
    }

}
