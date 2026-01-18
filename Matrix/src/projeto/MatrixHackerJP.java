package projeto; 

import java.util.Random;

public class MatrixHackerJP {

    
    private static final char[] KATAKANA = {
        'ｱ','ｲ','ｳ','ｴ','ｵ',
        'ｶ','ｷ','ｸ','ｹ','ｺ',
        'ｻ','ｼ','ｽ','ｾ','ｿ',
        'ﾀ','ﾁ','ﾂ','ﾃ','ﾄ',
        'ﾅ','ﾆ','ﾇ','ﾈ','ﾉ',
        'ﾊ','ﾋ','ﾌ','ﾍ','ﾎ',
        'ﾏ','ﾐ','ﾑ','ﾒ','ﾓ',
        'ﾔ','ﾕ','ﾖ','ﾜ','ﾝ'
    };

    public static void main(String[] args) throws InterruptedException {
        String verde = "\u001B[32m";
        String reset = "\u001B[0m";
        // Barras de progresso
        carregar("Decodificando firewall", verde, reset);
        carregar("Extraindo credenciais", verde, reset);
        carregar("Estabelecendo conexão segura", verde, reset);

        // Mensagem final dramática
        System.out.println("\n" + verde + ">> 接続完了 (Conexão estabelecida)" + reset);
        System.out.println(verde + ">> アクセス許可 (Acesso concedido)" + reset);
    }

    // Método para simular barra de progresso
    private static void carregar(String tarefa, String verde, String reset) throws InterruptedException {
        System.out.print(verde + tarefa + ": [" + reset);
        for (int i = 0; i < 30; i++) {
            System.out.print(verde + "=" + reset);
            Thread.sleep(80);
        }
        System.out.println(verde + "] 100%" + reset);
        Thread.sleep(400);
    }
}
