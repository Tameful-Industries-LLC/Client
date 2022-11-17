package gg.tame.client.module.data.setting.types;

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
    private String[] acceptedStringValues;

    public ChoiceSetting(AbstractModule container, String name) {
        super(container, name);
    }

    public ChoiceSetting(List<Setting> list, String name) {
        super(list, name);
    }

    public String getValue() {
        return (String) this.value;
    }

    public ChoiceSetting setAcceptedStringValues(String... values) {
        this.acceptedStringValues = values;
        return this;
    }

    public ChoiceSetting setValue(String value) {
        this.value = value;
        return this;
    }

}
