package com.hardcodecoder.pulsemusic.helper;


import java.util.Calendar;

public class HomeWalliProvider {

    //private static final String[] keywordsLightMode =
    //{"Sunrise, Freshness, Morning, Music", "Afternoon, Relax, Rest, Music", "Evening, Sunset, Relaxing music", "Night, Dj, band, Music"};
    private static final String[] keywords =
            {"Sunrise morning walk music", "Musical Instrument, Morning", "Afternoon party, ", "Night band, Dj"};

    //private static final String[] keywordsDarkMode =
    //{"Morning, fresh, dark wallpaper", "Afternoon, Dark music, Relax, Music", "Evening, Sunset, Dark music, Relaxing music", "Night, Dj, band, Music"};

    public static String getUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://source.unsplash.com/featured/?");
        //String[] keywords;
        /*if (UserInfo.isDarkModeEnabled())
            keywords = keywordsDarkMode;
        else*/
        //keywords = keywordsLightMode;
        switch (getTimeOfDay()) {
            case MORNING:
                stringBuilder.append(keywords[0]);
                break;
            case AFTERNOON:
                stringBuilder.append(keywords[1]);
                break;
            case EVENING:
                stringBuilder.append(keywords[2]);
                break;
            case NIGHT:
                stringBuilder.append(keywords[3]);
                break;
            default:
                stringBuilder.append("music");
                break;
        }
        return stringBuilder.toString();
    }

    public static Day getTimeOfDay() {
        Calendar rightNow = Calendar.getInstance();
        int hourOfDay = rightNow.get(Calendar.HOUR_OF_DAY);
        if (hourOfDay >= 5 && hourOfDay < 12)
            return Day.MORNING;
        else if (hourOfDay >= 12 && hourOfDay < 17)
            return Day.AFTERNOON;
        else if (hourOfDay >= 17 && hourOfDay < 20)
            return Day.EVENING;
        else
            return Day.NIGHT;
    }

    public enum Day {
        MORNING,
        AFTERNOON,
        EVENING,
        NIGHT
    }
}
