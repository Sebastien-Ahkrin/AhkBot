package fr.ahkrin.ahk.modules.music.command;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import fr.ahkrin.ahk.modules.music.MusicModule;
import fr.ahkrin.ahk.modules.music.MusicPlayer;
import org.krobot.MessageContext;
import org.krobot.command.ArgumentMap;
import org.krobot.command.Command;
import org.krobot.command.CommandHandler;

@Command(value = "music", desc = "Affiche les informations de la musique actuelle")
public class CommandMusic implements CommandHandler
{
    @Override
    public Object handle(MessageContext context, ArgumentMap args) throws Exception
    {
        MusicPlayer player = MusicPlayer.from(context.getGuild());
        AudioTrack track = player.getPlayer().getPlayingTrack();

        if (track == null)
        {
            return context.warn("Erreur", "Aucune musique n'est actuellement jouée");
        }

        return context.info("Musique actuelle", track.getInfo().title + " [" + MusicModule.parseTime(track.getPosition()) + "/" + MusicModule.parseTime(track.getDuration()) + "]");
    }
}
