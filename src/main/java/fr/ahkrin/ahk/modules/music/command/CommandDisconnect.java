package fr.ahkrin.ahk.modules.music.command;

import fr.ahkrin.ahk.modules.music.MusicPlayer;
import org.krobot.MessageContext;
import org.krobot.command.ArgumentMap;
import org.krobot.command.Command;
import org.krobot.command.CommandHandler;
import org.krobot.command.NoTyping;

@NoTyping
@Command(value = "disconnect", desc = "Déconnecte le bot du channel vocal")
public class CommandDisconnect implements CommandHandler
{
    @Override
    public Object handle(MessageContext context, ArgumentMap args) throws Exception
    {
        if (!context.getGuild().getAudioManager().isConnected())
        {
            return context.warn("Erreur", "Le bot n'est pas dans un channel vocal");
        }

        MusicPlayer.from(context.getGuild()).stop();
        context.getGuild().getAudioManager().closeAudioConnection();

        return null;
    }
}
