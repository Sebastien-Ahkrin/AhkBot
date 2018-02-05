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

@Command(value = "add", desc = "Send a message for add Ahk in your guilde.")
public class AddCommands implements CommandHandler {

    @Override
    public Object handle(MessageContext context, ArgumentMap args) throws Exception {
        return context.info("Message for add Ahk", "https://discordapp.com/oauth2/authorize?client_id=327082190460682240&scope=bot");
    }

}
