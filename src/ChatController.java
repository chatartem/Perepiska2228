import com.google.gson.Gson;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

public class ChatController {
    Chat chat;
    File chatFile;
    JTextPane chatPane;
    public ChatController(String nazvanie) {
        chatFile = new File("Z:\\chats\\"+nazvanie);
        //Если чат существует, то открываем его и загружаем сообщения
        if((chatFile.exists())&&(!chatFile.isDirectory())){
            //todo загрузить файл в чат
            obnovitChat();
        }else{
            //Иначе, создаем новый чат
            chat = new Chat(nazvanie,"Chat",new Date());
            //todo сохранить файл чат
            sohranitChat();
        }
    }

    public void sohranitChat(){
        Gson gson = new Gson();
        String chatJson = gson.toJson(chat);
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(chatFile.getAbsolutePath());
            bw = new BufferedWriter(fw);
            bw.write(chatJson);
            bw.flush();
            bw.close();
            fw.close();
        }
        catch ( IOException e)
        {
            e.printStackTrace();
        }
    }

    public void obnovitChat() {
        try {
            byte[] encoded = Files.readAllBytes(
                    Paths.get(chatFile.getAbsolutePath()));
            String chatJson = new String(encoded, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            chat = gson.fromJson(chatJson, Chat.class);
            if ((chat.getSoosbchenia() != null)&&(chatPane!=null)) {
                if (chat.getSoosbchenia().size() > 0) {
                    for (Soobsch s : chat.getSoosbchenia()) {
                        chatPane.setText(chatPane.getText()+"\n"+"Автор: "+ s.getAuthor());
                        chatPane.setText(chatPane.getText()+"\n"+"Дата: "+ s.getData().toString());
                        chatPane.setText(chatPane.getText()+"\n"+s.getText());
                        chatPane.setText(chatPane.getText()+"\n");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dobavitSoobsch(String soobsch){
        obnovitChat();
        if(chat.getSoosbchenia()==null){
            chat.setSoosbchenia(new ArrayList<Soobsch>());
        }
        chat.getSoosbchenia().add(new Soobsch(new Date(), soobsch, "Chat"));
        sohranitChat();
    }
    public void setPane(JTextPane chatPane){
        this.chatPane=chatPane;
    }
}
