package fr.ahkrin.ahk.commands.admins;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.requests.RestAction;
import org.krobot.MessageContext;
import org.krobot.command.ArgumentMap;
import org.krobot.command.CommandHandler;
import org.krobot.command.Command;
import org.krobot.command.NoTyping;
import org.krobot.permission.BotRequires;
import org.krobot.permission.UserRequires;

import java.util.List;

@BotRequires (
    Permission.MESSAGE_MANAGE
)

@UserRequires (
    Permission.MESSAGE_MANAGE
)

@NoTyping
@Command(value = "clr <num:int>", desc = "Clear a number of message [Only for Admin]")
public class ClrCommands implements CommandHandler {

    @Override
    public Object handle(MessageContext context, ArgumentMap args) throws Exception {
        int number = args.get("num");
        if((number > 0) && number <= 100){
            for (TextChannel channelText : context.getGuild().getTextChannels()) {
                if (channelText.equals(context.getMessage().getTextChannel())) {
                    MessageHistory history = new MessageHistory(channelText);
                    RestAction<List<Message>> mgs = history.retrievePast(number);
                    mgs.queue(messages -> channelText.deleteMessages(messages).queue());
                }
            }
        }else{
            return context.warn("Error", "The number must be between 0 and 100 not less, not more");
        }
        return null;
    }

}
