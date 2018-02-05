package fr.ahkrin.ahk.modules.galharim;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.SubscribeEvent;
import org.krobot.config.ConfigProvider;
import org.krobot.permission.BotRequires;

import javax.inject.Inject;
import java.awt.*;

@BotRequires(
        Permission.MESSAGE_WRITE
)

public class JoinListener {

    @Inject
    private ConfigProvider config;

    @SubscribeEvent
    public void onGuildJoinEvent(GuildMemberJoinEvent event){

        User user = event.getUser();

        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor(user.getName(), user.getAvatarUrl(), user.getEffectiveAvatarUrl());
        eb.setColor(Color.red);
        eb.setTitle("Bienvenue à " + user.getName());
        eb.setDescription("Souhaitez la bienvenue au nouveau vous autres, ou soyez maudit !");
        MessageEmbed embed = eb.build();

        event.getGuild().getTextChannelById("278967298310799362").sendMessage(embed).queue();

    }

}
