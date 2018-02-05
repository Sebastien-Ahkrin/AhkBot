package fr.ahkrin.ahk.commands.users;

import com.mb3364.twitch.api.Twitch;
import com.mb3364.twitch.api.handlers.ChannelResponseHandler;
import fr.ahkrin.ahk.twitchs.Stream;
import net.dv8tion.jda.core.Permission;
import org.krobot.MessageContext;
import org.krobot.command.ArgumentMap;
import org.krobot.command.Command;
import org.krobot.command.CommandHandler;
import org.krobot.config.ConfigProvider;
import com.mb3364.twitch.api.models.Channel;
import org.krobot.permission.BotRequires;

import javax.inject.Inject;

@BotRequires(
    Permission.MESSAGE_WRITE
)

@Command(value = "twitch <name>", desc = "Get a twitch informations.")
public class TwitchCommands implements CommandHandler {

    @Inject
    private ConfigProvider configs;

    @Override
    public Object handle(MessageContext context, ArgumentMap args) throws Exception {
        Twitch twitch = new Twitch();
        twitch.setClientId(configs.at("ahk.twitch.twitchid"));
        String name = args.get("name");

        twitch.channels().get(name, new ChannelResponseHandler() {

            @Override
            public void onSuccess (Channel channel) {
                context.info("Informations : " + name,
                    "Language : " + channel.getLanguage() + "\n" +
                    "Game : " + channel.getGame() + "\n" +
                    "Name : " + channel.getDisplayName() + "\n" +
                    "Status : " + channel.getStatus() + "\n" +
                    "Url : " + channel.getUrl() + "\n" +
                    "Followers : " + Integer.toString(channel.getFollowers()) + "\n" +
                    "Mature : " + Boolean.toString(channel.isMature()) + "\n" +
                    "Partner : " + Boolean.toString(channel.isPartner()) + "\n" +
                    "Live : " + new Stream("lobxg757gxccaksg4vfegaqvgxjztm", name).getStream().get("online").toString());
            }

            @Override
            public void onFailure(int i, String s, String s1) {
                context.warn("Informations : " + name, "Le nom d'utilisateur : " + name + " n'existe pas.");
            }

            @Override
            public void onFailure(Throwable throwable) {
                context.getMessage().getAuthor().openPrivateChannel().complete().sendMessage(throwable.getMessage());
            }

        });
        return null;
    }

}
