/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnomail;

import Utils.PieChart;
import Utils.CommandManager;
import Entities.*;
import Services.ClientPOP;
import Services.Mail;
import Services.MailMessage;
import Utils.Utils;
import Utils.ValidatorCommand;
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
                    //INSERTAR_PERSONA(Antony,Rios,9548665,23123,2342342,Santa cruz,Andrez I.,Plan 4000,ant@gmail.com,imagen,C)
                    System.out.println("Asunto: " + asunto);
                    if (asunto.indexOf("imagen") > 0) {
                        String image = clientPOP.getImage(message).trim();
                       // image = "data:image/jpeg;base64," + image;
                        asunto = asunto.replace("imagen", image);
                    }
                    CommandManager commandManager = new CommandManager(asunto);
                    String from = clientPOP.getFrom(message);
                    //System.out.println("AsuntoModificado: " + asunto);
                    commandManager.executeCommand(new ValidatorCommand() {
                        @Override
                        public void onSuccess() {
                            try {
                                String html = "";
                                String pathChart = "";
                                switch (commandManager.getTipoComando()) {
                                    case Insercion:
                                        int idInserted = (int) commandManager.getResult().get("result");
                                        html = "NUMEROS DE FILAS AFECTADOS POR LA INSTRUCCION " + idInserted;
                                        pathChart = "";
                                        break;
                                    case Reporte:
                                        html = Utils.dibujarTablawithHTMLListado((DefaultTableModel) commandManager.getResult().get("result"));
                                        pathChart = "";
                                        break;
                                    case Listado:
                                        html = Utils.dibujarTablawithHTML((DefaultTableModel) commandManager.getResult().get("result"));
                                        pathChart = "";
                                        break;

                                    case Estadistica:
                                        PieChart chart = new PieChart("Ejemplo", commandManager.getNombreEstadistica(), (List<EstadisticaEntity>) commandManager.getResult().get("result"));
                                        pathChart = "chart.jpg";
                                        break;
                                }
                                // System.out.println(html);
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
