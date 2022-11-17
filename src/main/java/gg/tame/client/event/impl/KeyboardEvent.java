package gg.tame.client.event.impl;

import gg.tame.client.event.EventBus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class KeyboardEvent extends EventBus.Event {

    private int key;

}
