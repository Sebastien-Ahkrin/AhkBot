package fr.ahkrin.ahk;

import fr.ahkrin.ahk.commands.admins.BanCommands;
import fr.ahkrin.ahk.commands.users.AddCommands;
import fr.ahkrin.ahk.commands.admins.ClrCommands;
import fr.ahkrin.ahk.commands.users.PingCommands;
import fr.ahkrin.ahk.commands.users.TwitchCommands;
import fr.ahkrin.ahk.modules.galharim.GalharimModule;
import net.dv8tion.jda.core.entities.Game;
import fr.ahkrin.ahk.modules.music.MusicModule;
import org.krobot.Bot;
import org.krobot.KrobotModule;
import org.krobot.command.HelpCommand;
import org.krobot.config.ConfigProvider;
import org.krobot.module.Include;
import org.krobot.runtime.KrobotRuntime;
import org.krobot.util.ColoredLogger;

import javax.inject.Inject;

@Include(
    imports = {
	    MusicModule.class,
        GalharimModule.class
    },
    commands = {
        HelpCommand.class,
        ClrCommands.class,
        AddCommands.class,
        PingCommands.class,
        TwitchCommands.class,
        BanCommands.class
    }
)

@Bot(name = "Ahk", version = "2.1", author = "Ahkrin")
public class Ahk extends KrobotModule {

    private static final ColoredLogger logger = ColoredLogger.getLogger("Ahk");
    private static final String DEFAULT_PREFIX = "$";

    @Inject
    private ConfigProvider configs;

    @Inject
    private KrobotRuntime runtime;

    @Override
    public void preInit() {
        folder("config/")
            .configs("ahk.json")
            .withDefaultsIn().classpathFolder("/");
    }

    @Override
    public void init() {
        prefix(DEFAULT_PREFIX);
    }

    @Override
    public void postInit(){
        jda().getPresence().setGame(Game.of(DEFAULT_PREFIX + "help"));
    }

}
