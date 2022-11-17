package gg.tame.client.event.impl;

import gg.tame.client.event.EventBus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ChatEvent extends EventBus.Event {

    private final String receivedChatMessage;

}
