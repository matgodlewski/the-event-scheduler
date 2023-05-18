package com.matgodlewski.listeners.modals;

import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ModalListeners extends ListenerAdapter {

    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        if (event.getModalId().equals("schedule_event_modal")) {

            String title = event.getValues().get(0).getAsString();
            String description = event.getValues().get(1).getAsString();
            String date = event.getValues().get(2).getAsString();
            String time = event.getValues().get(3).getAsString();

            StringBuilder sb = new StringBuilder();
            sb.append("Scheduled event:\n");
            sb.append("Title: ").append(title).append("\n");
            sb.append("Description: ").append(description).append("\n");
            sb.append("Date: ").append(date).append("\n");
            sb.append("Time: ").append(time).append("\n");

            event.reply(sb.toString()).queue();
        }
    }
}
