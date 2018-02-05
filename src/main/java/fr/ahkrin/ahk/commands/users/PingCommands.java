package fr.ahkrin.ahk.commands.users;

import net.dv8tion.jda.core.Permission;
import org.krobot.MessageContext;
import org.krobot.command.ArgumentMap;
import org.krobot.command.Command;
import org.krobot.command.CommandHandler;
import org.krobot.permission.BotRequires;

@BotRequires(
        Permission.MESSAGE_WRITE
)

@Command(value = "ping", desc = "Ping.")
public class PingCommands implements CommandHandler {

    @Override
    public Object handle(MessageContext context, ArgumentMap args) throws Exception {
        return context.info("Ping", context.getBotMember().getJDA().getPing() + "ms.");
    }

}
