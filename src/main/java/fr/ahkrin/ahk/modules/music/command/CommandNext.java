package fr.ahkrin.ahk.modules.music.command;

import fr.ahkrin.ahk.modules.music.MusicPlayer;
import org.krobot.MessageContext;
import org.krobot.command.ArgumentMap;
import org.krobot.command.Command;
import org.krobot.command.CommandHandler;

@Command(value = "next", desc = "Passe à la chanson suivante", aliases = {"n", "netx", "nxet", "enxt"})
public class CommandNext implements CommandHandler
{
    @Override
    public Object handle(MessageContext context, ArgumentMap args) throws Exception
    {
        MusicPlayer.from(context.getGuild()).next(false);
        return context.info("Chanson suivante", "Passage à la chanson suivante...");
    }
}
