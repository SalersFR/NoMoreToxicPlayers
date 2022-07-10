package fr.salers.nomoretoxic.nomoretoxicplayers.manager;

import com.gtranslate.Language;
import com.gtranslate.Translator;
import fr.salers.nomoretoxic.nomoretoxicplayers.NoMoreToxicPlayers;

/**
 * @author Salers
 * made on fr.salers.nomoretoxic.nomoretoxicplayers.manager
 */
public class CheckManager {

    public boolean check(final String message) {
        return NoMoreToxicPlayers.getInstance().getConfigManager().getBlockedWords().contains(message);
    }

    public boolean checkMultiLang(String message) {
        final Translator translator = Translator.getInstance();
        final String detectedLanguage = Language.getInstance().getNameLanguage(translator.detect(message));
        //isn't english so have to translate it
        if(!translator.detect(message).equalsIgnoreCase("en")) {
            message = translator.translate(message, detectedLanguage, Language.ENGLISH);
        }

        return check(message);
    }



}
