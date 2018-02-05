package fr.ahkrin.ahk.commands.admins;


import net.dv8tion.jda.core.Permission;
import org.krobot.MessageContext;
import org.krobot.command.ArgumentMap;
import org.krobot.command.Command;
import org.krobot.command.CommandHandler;
import org.krobot.command.NoTyping;
import org.krobot.permission.BotRequires;
import org.krobot.permission.UserRequires;

import net.dv8tion.jda.core.entities.Member;

@BotRequires(
        Permission.BAN_MEMBERS
)

@UserRequires(
        Permission.BAN_MEMBERS
)

@NoTyping
@Command(value = "ban <target:user> <msg:string>", desc = "Ban a user [Only for Admin]")
public class BanCommands implements CommandHandler {

    @Override
    public Object handle(MessageContext context, ArgumentMap args) throws Exception {
        Member ban = context.getGuild().getMember(args.get("target"));
        String id = ban.getUser().getId();

        if(id.equals("182414082022834176") || id.equals("327082190460682240"))
            return context.warn("Error", "You can't ban my master or me !");

        context.getGuild().getController().ban(ban, 7).reason(args.get("msg")).queue();

        return null;
    }

}
