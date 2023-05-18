package com.matgodlewski;

import com.matgodlewski.listeners.commands.BotCommands;
import com.matgodlewski.listeners.modals.ModalListeners;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class TheEventScheduler {
    public static void main(String[] args) throws InterruptedException {
        String TOKEN = System.getenv("DISCORD_TOKEN");
        JDA jda = JDABuilder.createDefault(TOKEN)
                .addEventListeners(new BotCommands(), new ModalListeners())
                .setActivity(Activity.listening("to your grandma"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build().awaitReady();

        Guild guild = jda.getGuildById(System.getenv("GUILD_ID"));

        assert guild != null;
        guild.updateCommands().addCommands(
                Commands.slash("schedule", "Schedule command works!")
        ).queue();
    }
}