package eyeq.util.asm;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import eyeq.util.client.UtilFileResourcePack;
import eyeq.util.client.UtilFolderResourcePack;
import eyeq.util.client.resource.ULanguageCreator;
import eyeq.util.client.resource.lang.LanguageResourceManager;
import eyeq.util.event.UtilEventHandler;
import eyeq.util.item.UItemSword;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
import java.util.Collections;

public class UtilContainer extends DummyModContainer {
    public static final String MOD_ID = "eyeq_util";

    public static File coremodLocation;

    public UtilContainer() {
        super(new ModMetadata());

        ModMetadata meta = getMetadata();
        meta.modId = MOD_ID;
        meta.name = "Util";
        meta.description = "前提";
        meta.version = "1.6";
        meta.authorList = Collections.singletonList("eyeq");
        meta.credits = "";
    }

    @Override
    public File getSource() {
        return coremodLocation;
    }

    @Override
    public Class<?> getCustomResourcePackClass() {
        return coremodLocation.isDirectory() ? UtilFolderResourcePack.class : UtilFileResourcePack.class;
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }

    @Subscribe
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new UtilEventHandler());
        if(event.getSide().isServer()) {
            return;
        }
        createFiles();
    }

    public static void createFiles() {
        File project = new File("../1.11.2-Util");

        LanguageResourceManager language = new LanguageResourceManager();

        language.register(LanguageResourceManager.EN_US, UItemSword.ATTACK_REACH, "Attack Reach");
        language.register(LanguageResourceManager.JA_JP, UItemSword.ATTACK_REACH, "リーチ");

        ULanguageCreator.createLanguage(project, MOD_ID, language);
    }
}
