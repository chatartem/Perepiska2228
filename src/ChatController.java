import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;


public class ChatController {
    Chat chat;
    File chatFile;

    public ChatController(String nazvanie) {
        chatFile = new File("Z:\\chats\\" + nazvanie);
        //если чат существует открываем его и загружаем сообщения
        if (chatFile.exists() && !chatFile.isDirectory()) {
            //todo загрузить файл в чат
            obnovitChat();
        } else {
            //иначе создаем пустой массив сообщений  и устанавливаем дату сообщнеий.
            chat = new Chat(nazvanie, "Artem Chat", new Date());
            //todo сохранить файл и обновить чат
            sohranitChat();
        }
    }

    public void sohranitChat(){
        Gson gson = new Gson();

        String chatJson = gson.toJson(chat);
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            fw = new FileWriter(chatFile.getAbsolutePath());
            bw = new BufferedWriter(fw);
            bw.write(chatJson);
            bw.flush();
            fw.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void obnovitChat() {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(chatFile.getName()));
            String chatJson = new String(encoded, StandardCharsets.UTF_8);
            Gson gson = new Gson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void dobavitSoobsch(String soobsch){
        obnovitChat();
        if(chat.getSoosbchenia()==null){
            chat.setSoosbchenia(new ArrayList<Soobsh>());
        }
        chat.getSoosbchenia().add(new Soobsh(new Date(), soobsch, "Artem Chat"));
        sohranitChat();
    }
}
