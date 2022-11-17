package gg.tame.client.event.impl;

import gg.tame.client.event.EventBus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
@Getter
@AllArgsConstructor
public class ClickEvent extends EventBus.Event {

    private final int mouseButton;

}
