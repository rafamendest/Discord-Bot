package discordbot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LolBD extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String[] res = event.getMessage().getContentRaw().split(" /");

        ConexaoDAO conn = new ConexaoDAO();
        conn.conectaBD();

        ChampionRepository cr = new ChampionRepository(conn);
        String comando = args[0];

        // Adicionar um campeão na tabela tbl_counter
        if (comando.equalsIgnoreCase("-add")) {
            String nomeC = args[1];
            String resposta = res[1];
            try {
                cr.inserirRegistroChampion(nomeC, resposta);
                event.getChannel().sendMessage("Campeão adicionado!").queue();
            } catch (Exception e) {
                event.getChannel().sendMessage("Não consegui adicionar" + e).queue();
            }
        }

        // Mostrar os counters de algum campeão
        if (comando.equalsIgnoreCase("-counter")) {
            String nomeC = args[1];
            try {
                String resposta = cr.buscaChampion(nomeC);
                event.getChannel().sendMessage(resposta).queue();
            } catch (Exception e) {
                event.getChannel().sendMessage("Não encontrei esse campeão!").queue();
            }
        }

        // Deletar um registro 
        if (comando.equalsIgnoreCase("-delete")) {
            String nomeC = args[1];
            try {
                cr.deletarRegistroChampion(nomeC);
                event.getChannel().sendMessage("Campeão deletado!").queue();
            } catch (Exception e) {
                event.getChannel().sendMessage("Não consegui deletar esse campeão!").queue();
            }
        }

        if (comando.equalsIgnoreCase("-update")) {
            String nomeC = args[1];
            String resposta = res[1];
            try {
                cr.alterarRegistroChampion(nomeC, resposta);
                event.getChannel().sendMessage("Campeão alterado!").queue();
            } catch (Exception e) {
                event.getChannel().sendMessage("Ocorreu um erro ao fazer as mudanças").queue();
            }
        }
    }
}
