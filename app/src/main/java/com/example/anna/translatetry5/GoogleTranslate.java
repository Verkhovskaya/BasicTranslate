package com.example.anna.translatetry5;

import com.google.cloud.RetryParams;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;


public class GoogleTranslate {

    public static String translateText(String sourceText, String sourceLang, String targetLang) {

        Translate translate = createTranslateService();
        TranslateOption srcLang = TranslateOption.sourceLanguage(sourceLang);
        TranslateOption tgtLang = TranslateOption.targetLanguage(targetLang);

        return translate.translate(sourceText, srcLang, tgtLang).toString();
    }

    public static Translate createTranslateService() {
        TranslateOptions translateOption = TranslateOptions.newBuilder()
                .setRetryParams(retryParams())
                .setConnectTimeout(60000)
                .setReadTimeout(60000)
                .build();
        return translateOption.getService();
    }

    private static RetryParams retryParams() {
        return RetryParams.newBuilder()
                .setRetryMaxAttempts(3)
                .setMaxRetryDelayMillis(30000)
                .setTotalRetryPeriodMillis(120000)
                .setInitialRetryDelayMillis(250)
                .build();
    }
}