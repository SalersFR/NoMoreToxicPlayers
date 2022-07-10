package fr.salers.nomoretoxic.nomoretoxicplayers.listener;

import fr.salers.nomoretoxic.nomoretoxicplayers.NoMoreToxicPlayers;
import fr.salers.nomoretoxic.nomoretoxicplayers.manager.CheckManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Locale;

/**
 * @author Salers
 * made on fr.salers.nomoretoxic.nomoretoxicplayers.listener
 */
public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event) {

        final String message = event.getMessage().toLowerCase(Locale.ROOT);
        final CheckManager checkManager = NoMoreToxicPlayers.getInstance().getCheckManager();

        boolean flag = false;

        if (NoMoreToxicPlayers.getInstance().getConfigManager().isSeparatedLettersCheck()) {
            final String spaceCutMessage = message.replace(" ", "");
            flag = checkManager.check(spaceCutMessage);

        }

        if (NoMoreToxicPlayers.getInstance().getConfigManager().isMultiLanguageCheck())
            flag = checkManager.checkMultiLang(message);

        //not setting it to false, if you're already flagging
        flag = flag || checkManager.check(message);

        event.setCancelled(flag);


    }
}
