package com.gmdb.team5.pf7project.bootstrap;

import com.gmdb.team5.pf7project.domain.Rating;

import java.util.Locale;
import java.util.Random;

public class Utils {


    Random random = new Random();
    String[] isoCountryCodes = Locale.getISOCountries();

    public Random getRandom() {
        return random;
    }

    public String generateCountry() {
        int index = random.nextInt(isoCountryCodes.length);
        Locale locale = new Locale("", isoCountryCodes[index]);
        return locale.getCountry();
    }


    public Integer generateRandomIntInRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

}
