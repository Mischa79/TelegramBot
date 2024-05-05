package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "new_bot_02_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "6792601777:AAHvttglyACBRePIURuijcPAT6z_sGmMuK0"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // TODO: основной функционал бота будем писать здесь
        //Zeigen Sie eine Nachricht über den Start des Spiels an -
        //Sie müssen den Kühlschrank hacken

        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("den Kühlschrank hacken", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Nimm die Wurst! +20 Ruhm", "step_2_btn",
                            "Nimm den Fisch! +20 Ruhm", "step_2_btn",
                            "Werfen Sie ein Glas Gurken weg! +20 Ruhm", "step_2_btn"));

        }

        //Hacke einen Roboterstabsauger

        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Hacke einen Roboterstabsauger", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Schicken Sie einen Roboterstausauger für Lebensmittel! +30 Ruhm", "step_4_btn",
                            "Fahren Sie mit einem Roboterstabsauger! +30 Ruhm", "step_4_btn",
                            "Flucht aus dem Roboterstabsauger! +30 Ruhm", "step_4_btn"));

        }

        //Go-Pro - Kamera hacken

        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Schalten Sie Ihre Go-Pro - Kamera ein und setzen Sie sie ein", "step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Renne über die Dächer und erschieße alles! +40 Ruhm", "step_6_btn",
                            "Katzen angreifen und filmen! +40 Ruhm", "step_6_btn",
                            "Hunde aus dem Hinterhalt! +40 Ruhm", "step_6_btn"));

        }

        //PS - hacken

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("PS - hacken", "step_7_btn"));
        }

        //Prahlt vor den Hofkatzen

        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Geh auf den hof und prahle", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);

        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}
// if (getMessageText().equals("/start")){
//         sendTextMessageAsync("Hallo");
//         }
//         if (getMessageText().equals("/bye")){
//         sendTextMessageAsync("Asta la vista, baby!");
//         }
//
//         if (getMessageText().contains("Tier")){
//         sendTextMessageAsync("Dein Lieblingstier: ",
//         Map.of("Der Kater","cater","Das Hund","hund"));
//         }
//         if (getCallbackQueryButtonKey().equals("hund")){
//         sendPhotoMessageAsync("step_6_pic");
//         }
//         if (getCallbackQueryButtonKey().equals("cater")){
//         sendPhotoMessageAsync("step_4_pic");
//         }
//         if (getMessageText().equals("smile")){
//         var message = getLastSentMessage();
//         editTextMessageAsync(message.getMessageId(),message.getText()+ " :)");
//         }