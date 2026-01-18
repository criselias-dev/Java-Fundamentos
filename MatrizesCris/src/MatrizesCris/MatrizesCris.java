package MatrizesCris;



	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;

	public class MatrizesCris {

	    public static void main(String[] args) {

	        // -----------------------------------------------------------
	        // LISTA DE ALUNOS
	        // Pode ser expandida para inserir mais alunos futuramente
	        // -----------------------------------------------------------
	        String[] alunos = {"Sinclair", "Siddharta", "Demian"};

	        // Matriz para armazenar as 4 notas de cada um dos 3 alunos
	        float[][] notas = new float[3][4];

	        // Título principal da aplicação (Janela)
	        JFrame frame = new JFrame("Sistema de Notas | Versão Cris");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(950, 350);
	        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
	        frame.setLayout(new BorderLayout());

	        // Painel superior para introdução
	        JLabel titulo = new JLabel("Lançamento de Notas dos Alunos", SwingConstants.CENTER);
	        titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
	        titulo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	        frame.add(titulo, BorderLayout.NORTH);

	        // -----------------------------------------------------------
	        // COLETA DAS NOTAS
	        // Para cada aluno será pedido 4 notas por JOptionPane
	        // -----------------------------------------------------------
	        for (int i = 0; i < alunos.length; i++) {
	            float soma = 0;

	            // Loop para registrar 4 notas por aluno
	            for (int j = 0; j < 4; j++) {
	                notas[i][j] = Float.parseFloat(
	                    JOptionPane.showInputDialog(
	                        null,
	                        "Informe a Nota " + (j+1) + " do aluno " + alunos[i],
	                        "Inserção de Notas",
	                        JOptionPane.QUESTION_MESSAGE
	                    )
	                );
	                soma += notas[i][j];
	            }
	        }

	        // -----------------------------------------------------------
	        // Tabela para exibir o boletim
	        // Usamos JTable para criar uma visão mais profissional
	        // -----------------------------------------------------------
	        
	        String[] colunas = {"Aluno", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Média", "Status"};
	        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

	        // Cálculo da média, definição de status e inserção dos dados na tabela
	        
	        for (int i = 0; i < alunos.length; i++) {
	            float soma = 0;
	            for (int j = 0; j < 4; j++) soma += notas[i][j];
	            float media = soma / 4;

	            // Regras de negócio
	            
	            String status;
	            if (media < 5.5) {
	                status = "REPROVADO";
	            } else if (media < 7.5) {
	                status = "EM RECUPERAÇÃO";
	            } else {
	                status = "APROVADO";
	            }

	            // Adicionando linha na tabela
	            
	            modelo.addRow(new Object[]{
	                alunos[i], notas[i][0], notas[i][1], notas[i][2], notas[i][3], media, status
	            });
	        }

	        JTable tabela = new JTable(modelo);
	        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
	        tabela.setRowHeight(28);
	        
	     // -----------------------------------------------------------
	     // Colorindo a coluna "Status" conforme o resultado do aluno
	     // -----------------------------------------------------------
	     tabela.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
	         @Override
	         public java.awt.Component getTableCellRendererComponent(
	                 JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

	             // Pega a célula renderizada normalmente
	             java.awt.Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	             // Verifica se é a coluna de status (a última)
	             if (column == 6) { // Coluna "Status"
	                 String status = value.toString();

	                 // Aplica cores de acordo com o status
	                 if (status.equals("APROVADO")) {
	                     cell.setForeground(Color.GREEN);     // Verde
	                 } else if (status.equals("EM RECUPERAÇÃO")) {
	                     cell.setForeground(Color.ORANGE);    // Amarelo
	                 } else if (status.equals("REPROVADO")) {
	                     cell.setForeground(Color.RED);       // Vermelho
	                 }
	             } else {
	                 cell.setForeground(Color.BLACK); // Outras colunas normal
	             }

	             return cell;
	         }
	     });


	        // Colocando tabela dentro de uma área rolável
	        
	        JScrollPane scroll = new JScrollPane(tabela);
	        frame.add(scroll, BorderLayout.CENTER);

	        // Exibe tudo em tela
	        
	        frame.setVisible(true);
	    }
	}
