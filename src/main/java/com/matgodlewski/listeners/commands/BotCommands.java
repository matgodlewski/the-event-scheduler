package com.matgodlewski.listeners.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class BotCommands extends ListenerAdapter {
    private Modal getScheduleEventModal() {
        TextInput title = TextInput.create("scheduled_event_title", "Title", TextInputStyle.SHORT)
                .setRequired(true)
                .setPlaceholder("Title of the event")
                .setMinLength(1)
                .build();
        TextInput description = TextInput.create("scheduled_event_description", "Description", TextInputStyle.PARAGRAPH)
                .setRequired(true)
                .setPlaceholder("Description of the event")
                .setMinLength(1)
                .build();
        TextInput date = TextInput.create("scheduled_event_date", "Date", TextInputStyle.SHORT)
                .setRequired(true)
                .setPlaceholder("Date of the event")
                .setMinLength(1)
                .build();
        TextInput time = TextInput.create("scheduled_event_time", "Time", TextInputStyle.SHORT)
                .setRequired(true)
                .setPlaceholder("Time of the event")
                .setMinLength(1)
                .build();
        return Modal.create("schedule_event_modal", "Schedule an event")
                .addActionRow(title)
                .addActionRow(description)
                .addActionRow(date)
                .addActionRow(time)
                .build();
    }
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("schedule")) {
            event.replyModal(getScheduleEventModal()).queue();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("!schedule")) {
            event.getChannel().sendMessage("Schedule command works!").queue();
        }
    }
}
