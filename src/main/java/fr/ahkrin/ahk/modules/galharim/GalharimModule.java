package fr.ahkrin.ahk.modules.galharim;


import org.krobot.KrobotModule;
import org.krobot.config.ConfigProvider;
import org.krobot.module.Include;

import javax.inject.Inject;

@Include(
    listeners = {
        JoinListener.class
    }
)

public class GalharimModule extends KrobotModule{

    @Inject
    private ConfigProvider configs;

    @Override
    public void preInit() {
        folder("config/")
                .configs("ahk")
                .withDefaultsIn().classpathFolder("/");
    }

    @Override
    public void init() {
        when(context -> !context.getGuild().getId().equals("278966830473674753")).disable();
    }

    @Override
    public void postInit() {}

}
