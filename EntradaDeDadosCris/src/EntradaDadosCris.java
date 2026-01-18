import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class EntradaDadosCris {

    // Cria ícones coloridos em código
    private static Icon criarIcone(char simbolo, Color cor) {
        int size = 32;

        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fundo circular
        g.setColor(cor);
        g.fillOval(0, 0, size - 1, size - 1);

        // Símbolo
        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.BOLD, 18)); // já em BOLD
        FontMetrics fm = g.getFontMetrics();

        int x = (size - fm.charWidth(simbolo)) / 2;
        int y = (size - fm.getHeight()) / 2 + fm.getAscent();

        g.drawString(String.valueOf(simbolo), x, y);
        g.dispose();

        return new ImageIcon(img);
    }

    public static void main(String[] args) {

        // Fonte Helvetica BOLD
        Font fonteBold = new Font("Helvetica", Font.BOLD, 14);
        UIManager.put("OptionPane.messageFont", fonteBold);
        UIManager.put("OptionPane.buttonFont", fonteBold);

        // Borda 3px
        Border borda = BorderFactory.createLineBorder(Color.DARK_GRAY, 0);
        UIManager.put("OptionPane.border", borda);

        // Ícones
        Icon perguntaVermelha = criarIcone('?', Color.RED);
        Icon infoVerde = criarIcone('i', new Color(0, 150, 0));

        // Caixa 1 — pergunta
        String idadeStr = (String) JOptionPane.showInputDialog(
                null,
                "Informe a idade da pessoa",
                "Pergunta",
                JOptionPane.QUESTION_MESSAGE,
                perguntaVermelha,
                null,
                null
        );

        int idade = Integer.parseInt(idadeStr);

        // Caixa 2 — informação
        JOptionPane.showMessageDialog(
                null,
                "A pessoa tem " + idade + " anos de idade",
                "Informação",
                JOptionPane.INFORMATION_MESSAGE,
                infoVerde
        );

        // Caixa 3 — alerta padrão
        JOptionPane.showMessageDialog(
                null,
                "Teste realizado com sucesso",
                "ATENÇÃO !!",
                JOptionPane.WARNING_MESSAGE
        );
    }
}
