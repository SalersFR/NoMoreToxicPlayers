package fr.salers.nomoretoxic.nomoretoxicplayers.manager;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Salers
 * made on fr.salers.nomoretoxic.nomoretoxicplayers.manager
 */
public class ConfigManager {

    private final boolean separatedLettersCheck;
    private final boolean multiLanguageCheck;
    private List<String> blockedWords = new ArrayList<>();

    public ConfigManager(final FileConfiguration config) {
        this.separatedLettersCheck = config.getBoolean("anti-toxicity.separated-letters-swear-check");
        this.multiLanguageCheck = config.getBoolean("anti-toxicity.multiple-languages-check");

        //putting in lowercase , so it's easier for us to check
        this.blockedWords = config.getStringList("blocked-words").stream().
                map(String::toLowerCase).collect(Collectors.toList());

    }

    public boolean isSeparatedLettersCheck() {
        return separatedLettersCheck;
    }

    public boolean isMultiLanguageCheck() {
        return multiLanguageCheck;
    }

    public List<String> getBlockedWords() {
        return blockedWords;
    }
}
