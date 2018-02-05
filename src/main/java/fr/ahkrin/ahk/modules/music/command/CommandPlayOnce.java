package fr.ahkrin.ahk.modules.music.command;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import fr.ahkrin.ahk.modules.music.MusicPlayer;
import javax.inject.Inject;
import org.krobot.command.Command;
import org.krobot.config.ConfigProvider;

@Command(value = "once <query...>", desc = "Supprime la musique après l'avoir jouée", aliases = {"o", "once", "noce", "onec"})
public class CommandPlayOnce extends CommandPlay
{
    @Inject
    public CommandPlayOnce(ConfigProvider config)
    {
        super(config);
    }

    @Override
    protected void queue(MusicPlayer player, AudioTrack track)
    {
        player.addOnce(track);
    }
}
