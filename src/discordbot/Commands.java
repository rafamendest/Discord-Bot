package discordbot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Commands extends ListenerAdapter {
    
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
    public void onMessageReceived(MessageReceivedEvent event) {
        
         String[] args = event.getMessage().getContentRaw().split(" "); 
         
         if (args[0].equalsIgnoreCase("-ajuda".toLowerCase())) { 
             
             this.setNome(event.getAuthor().getName());
             event.getChannel().sendMessage("Olá " + this.getNome() + ", sou um bot feito pra te ajudar no lolzin nosso de cada dia.").queue();
             event.getChannel().sendMessage("Digite '-counter darius' por exemplo que vou te falar os principais counters do Darius.").queue();
             event.getChannel().sendMessage("Se o campeão tiver espaços no nome por exemplo Aurelion Sol, apenas ignore o espaço e digite aurelionsol, ou se tiver caracteres especiais por exemplo Kha'Zix, digite khazix").queue();
             event.getChannel().sendMessage("Os counters foi pesquisado através dos melhores sites de buscas, se você achar que algum counter informado está errado, fale com o RafaelMT#4284").queue();
             event.getChannel().sendMessage("(Sou recentemente criado por um iniciante em programação, qualquer bug ou erro que estiver acontecendo, informe o criador RafaelMT#4284)").queue();
        } 
        
    
   }
}
