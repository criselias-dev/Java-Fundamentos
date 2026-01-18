
public class Pessoas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
				Fisica fis = new Fisica();
				Juridica jur = new Juridica();
				
				fis.nome = "Cristian";
				fis.cpf = "249.419.178-55";
				fis.identidade = "19446401";
				fis.situacaoPessoa = "A";
				
				jur.nome = "WetPleasures";
				jur.cnpj = "123.456/0001-54";
				jur.inscEstadual = "6787898909";
				jur.situacaoPessoa = "I";
				
				System.out.println("Dados da Pessoa Física");
				System.out.println(fis.toString());
				System.out.println("Dados da Pessoa Jurídica");
				System.out.println(jur.toString());
	}

}
