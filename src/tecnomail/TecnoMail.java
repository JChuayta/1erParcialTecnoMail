/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnomail;

import Entities.*;
import Services.*;
import Utils.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo10sc
 */
public class TecnoMail {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClientPOP clientPOP = new ClientPOP();
        Mail mailManager = new Mail();
        System.out.println("Esperando");
        while (true) {
            if (clientPOP.connect()) {
                List<MailMessage> list = clientPOP.getIndexMessagesList();
                while (list.size() > 0) {
                    MailMessage mail = list.get(0);
                    String message = clientPOP.getMessage(mail.getIndex());
                    String asunto = clientPOP.getCommand(message).trim();
                    CommandManager commandManager = new CommandManager(asunto);
                    System.out.println("Asunto: " + asunto);
                    String from = clientPOP.getFrom(message);
                    System.out.println(from);
                    commandManager.executeCommand(new ValidatorCommand() {
                        @Override
                        public void onSuccess() {
                            try {
                                String html = "";
                                String pathChart = "";
                                switch (commandManager.getTipoComando()) {
                                    case Insercion:
                                        int idInserted = (int) commandManager.getResult().get("result");
                                        html = "EJECUTADO CORRECTAMENTE: LLAVE GENERADA=" + idInserted;
                                        pathChart = "";
                                        break;
                                    case Reporte:
                                        html = Utils.dibujarTablawithHTML((DefaultTableModel) commandManager.getResult().get("result"));
                                        pathChart = "";
                                        break;
                                }
                                System.out.println(html);
                                mailManager.sendHtmlEmail(from, "INFORME DE EJECUCION DEL COMANDO " + commandManager.getCommand(), html, pathChart);
                            } catch (MessagingException | IOException ex) {
                                Logger.getLogger(TecnoMail.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        @Override
                        public void onError() {
                            try {
                                String html = "Error al ejecutar el comando";
                                mailManager.sendHtmlEmail(from, "INFORME DE EJECUCION DEL COMANDO " + commandManager.getCommand(), html, "");
                            } catch (MessagingException | IOException ex) {
                                Logger.getLogger(TecnoMail.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    list.remove(0);
                    clientPOP.deleteMessage(mail.getIndex());
                }
                clientPOP.disconnect();
            }
        }
    }

}
