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

@Command(value = "quote <temp> <message...>", desc = "print a message with template")
public class QuoteCommands implements CommandHandler {

    @Override
    public Object handle(MessageContext context, ArgumentMap args) throws Exception {
        String temp = args.get("temp");
        String message = String.join(" ", (String[]) args.get("message"));
        return context.info(context.getMessage().getAuthor().getName(), temp + " " + message + " " + temp);
    }

}