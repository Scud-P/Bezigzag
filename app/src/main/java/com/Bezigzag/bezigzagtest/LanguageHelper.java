package com.Bezigzag.bezigzagtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import java.util.Locale;

public class LanguageHelper {
    private static final String LANG_PREF_KEY = "language_preference";

    // Méthode servant à changer la langue de l'application du français à l'anglais et vice versa.
    // Obtenir les préférences partagées par défaut de l'application
    // Mettre à jour la préférence de langue avec le nouveau code de langue
    // Créer un objet Locale avec le nouveau code de langue
    // Définir le locale nouvellement créé comme locale par défaut
    // Obtenir les ressources de l'application
    // Obtenir la configuration de l'application
    // Définir le locale de la configuration sur le nouveau locale
    // Mettre à jour la configuration de l'application avec le nouveau locale

    public static void changeLanguage(Context context, String languageCode) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(LANG_PREF_KEY, languageCode).apply();
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

}
