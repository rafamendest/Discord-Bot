package discordbot;

import java.io.FileNotFoundException;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordBot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, FileNotFoundException {

            String token = "ODk5OTgyMDIwMjgzODY3MTQ2.YW6rkg.mTRVfLN2e2FuEnj0xyXjaikb_AY";
            ConexaoDAO conn = new ConexaoDAO();
            conn.conectaBD();

            JDA builder = JDABuilder.createDefault(token).build();
            builder.addEventListener(new LolBD());
            builder.addEventListener(new Commands());
        
        
        try {
            

            TableFactory tf = new TableFactory(conn);
            tf.criarTabelaCampeao();

            
        } catch (Exception e) {

            System.out.println("erro na main");
            
            
        }

            JDABuilder j = JDABuilder.createDefault(token);
            j.setActivity(Activity.playing("-ajuda"));
            j.build();
    }

}
