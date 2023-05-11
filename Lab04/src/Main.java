import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// Veículo
		Veículo palio = new Veículo ( "SEI0N454", "Ford", "palio", 1997) ; // Builder
		
		palio.setPlaca ( "FUI4G054" ) ; // Setter
		String plaquinha = palio.getPlaca() ; // Getter
		System.out.println( plaquinha ) ;
		
		Veículo astra = new Veículo ( "FFP9M894", "Ford", "astra", 1974) ; // Builder
		
		astra.setPlaca ( "JVM9L715" ) ; // Setter
		String plaquinha2 = astra.getPlaca() ; // Getter
		System.out.println( plaquinha2 ) ;
		
		Veículo doblo = new Veículo ( "SAQ7K854", "Ford", "doblo", 1995) ; // Builder
		
		doblo.setPlaca ( "GDG0H676" ) ; // Setter
		String plaquinha3 = doblo.getPlaca() ; // Getter
		System.out.println( plaquinha3 ) ;
		
		System.out.println( doblo.toString() ); // Dados Veículo

		// Cliente
		ArrayList <Veículo> carrosCli1 = new ArrayList <Veículo>();
		carrosCli1.add(astra);
		carrosCli1.add(palio);
		LocalDate data = LocalDate.of(2000, 8, 6);
		ClientePF cli1 = new ClientePF("Roberto Justus Segundo", "Rua Ben10", carrosCli1, "masculino", "classe alta", 
										"superior", LocalDate.now(), "018.691.799-60", data ); // Builder PF
			
		System.out.println( Validacao.validadorCpf( cli1.getCpf() ) ) ; // Validador PF
		
		cli1.setEndereco( "Rua Vilgax" ) ; // Setter PF
		String ruinha = cli1.getEndereco() ; // Getter PF
		System.out.println( ruinha ) ;
		
		System.out.println( cli1.toString() ) ; // Dados PF
		
		ArrayList <Veículo> carrosCli2 = new ArrayList <Veículo>();
		carrosCli2.add(doblo);
		ClientePJ cli2 = new ClientePJ("Mac Donalds", "Rua Batatinha", carrosCli2, "42.591.651/0001-43", "15/04/1995", 2 ); // Builder
			
		System.out.println( Validacao.validadorCnpj( cli2.getCnpj() ) ) ; // Validador
		
		cli2.setEndereco( "Rua Nuggets" ) ; // Setter PJ
		String ruinha2 = cli2.getEndereco() ; // Getter PJ
		System.out.println( ruinha2 ) ;
		
		System.out.println( cli2.toString() ) ; // Dados PJ
		
		// Seguradora
		ArrayList <Sinistro> listaSinistros = new ArrayList <Sinistro>() ;
		ArrayList <Cliente> listaClientes = new ArrayList <Cliente>() ;
		
		Seguradora s1 = new Seguradora ( "Bom Seguros", "011958742000", "megatronterrivel@gmail.com", 
											"Rua Segura", listaSinistros, listaClientes) ; // Builder
		
		s1.cadastrarCliente(cli1); // Cadastrar ClientePF
		s1.cadastrarCliente(cli2); // Cadastrar ClientePJ
		s1.gerarSinistro(cli2, doblo); // Gerador de Sinistro
		s1.getListaSinistros().get(0).getEndereco(); // Setter Sinistro
		s1.getListaSinistros().get(0).setEndereco("Rua dos Bobos"); // Getter Sinistro
		System.out.println (s1.getListaSinistros().get(0).toString() );  // Dados Sinistro Sinistro
		
		System.out.println (s1.listarClientes()); // Listando Clientes
		System.out.println (s1.listarSinistros()); // Listando Sinistros
		
		s1.vizualizarSinistro("PF"); // Vizualizando Sinistros vinculados a ClientePF
		s1.vizualizarSinistro("PJ"); // Vizualizando Sinistros vinculados a ClientePJ
		s1.removerCliente("Mac Donalds"); // Removendo ClientePJ
		
		s1.setNome ( "Ótimos Seguros" ) ; // Setter
		String nominho = s1.getNome() ; // Getter
		System.out.println( nominho ) ;
		
		System.out.println( s1.toString() ); // Dados Seguradora
		
		// Método interativo
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean continuar = true;
		String ordem ;
		do {
			System.out.println("O que deseja fazer ? Essas são as opções: Cadastrar Cliente(PF ou PJ)\n Remover Cliente\n Gerar Sinistro\n "
					+ "Listar Clientes\n Listar Sinistros\n Vizualizar Sinistro\n Encerrar\n");
			ordem = scan.next();
			switch(ordem) {
			case("Cadastrar ClientePF"):
				System.out.println("Insira os parâmetros [Nome, Endereço, Veículos, Cpf, Data de Nascimento, Educação,"
						+ " Gênero e Classe Econômica]");
				String nomeTeste = scan.next();
				String endeTeste = scan.next();
				ArrayList <Veículo> autoTeste = new ArrayList <Veículo>();
				autoTeste.add(astra);
				String cpfTeste = scan.next();
				String dataTeste = scan.next();
				// separa dataTeste e insere em nova data teste sendo LocalDate
				String eduTeste = scan.next();
				String geneTeste = scan.next();
				String classeTeste = scan.next();
				LocalDate data2 = LocalDate.of(2002, 4, 16);
				
				ClientePF cliTeste = new ClientePF(nomeTeste, endeTeste, autoTeste, geneTeste, classeTeste, eduTeste, LocalDate.now(), cpfTeste, data2);
				s1.cadastrarCliente(cliTeste);
				System.out.println("Deseja realizar mais alguma ação ?");
				ordem = scan.next();
				switch (ordem) {
				case("Não"):
					System.out.println("Ok! Encerrando sessão");
					continuar = false;
				case("Sim"):
					System.out.println("Ok! ");
				}
				
			case("Cadastrar ClientePJ"):
				System.out.println("Insira os parâmetros [Nome, Endereço, Veículos, Cnpj e Data de Fundação]");
				String nomeTeste2 = scan.next();
				String endeTeste2 = scan.next();
				ArrayList <Veículo> autoTeste2 = new ArrayList <Veículo>();
				autoTeste2.add(palio);
				String cnpjTeste = scan.next();
				String fundTeste = scan.next();
				
				ClientePJ cliTeste2 = new ClientePJ(nomeTeste2, endeTeste2, autoTeste2, cnpjTeste, fundTeste, 3);
				s1.cadastrarCliente(cliTeste2);
				System.out.println("Deseja realizar mais alguma ação ?");
				ordem = scan.next();
				switch (ordem) {
				case("Não"):
					System.out.println("Ok! Encerrando sessão");
					continuar = false;
				case("Sim"):
					System.out.println("Ok! ");
				}
				
			case("Remover Cliente"):
				System.out.println("Insira os parâmetros [Nome do Cliente]");
				String removido = scan.next();
				s1.removerCliente(removido);
				System.out.println("Deseja realizar mais alguma ação ?");
				ordem = scan.next();
				switch (ordem) {
				case("Não"):
					System.out.println("Ok! Encerrando sessão");
					continuar = false;
				case("Sim"):
					System.out.println("Ok! ");
				}
				
			case("Gerar Sinistro"):
				System.out.println("Insira os parâmetros [Nome do Cliente e Veículo]"); // Considerei o Cliente e Veículo já registrado no sistema 
				s1.gerarSinistro(cli1, astra);
				System.out.println("Deseja realizar mais alguma ação ?");
				ordem = scan.next();
				switch (ordem) {
				case("Não"):
					System.out.println("Ok! Encerrando sessão");
					continuar = false;
				case("Sim"):
					System.out.println("Ok! ");
				}
				
			case("Listar Clientes"):
				s1.listarClientes();
				System.out.println("Deseja realizar mais alguma ação ?");
				ordem = scan.next();
				switch (ordem) {
				case("Não"):
					System.out.println("Ok! Encerrando sessão");
					continuar = false;
				case("Sim"):
					System.out.println("Ok! ");
				}
				
			case("Listar Sinistros"):
				s1.listarSinistros();
				System.out.println("Deseja realizar mais alguma ação ?");
				ordem = scan.next();
				switch (ordem) {
				case("Não"):
					System.out.println("Ok! Encerrando sessão");
					continuar = false;
				case("Sim"):
					System.out.println("Ok! ");
				}
			
			case("Vizualizar Sinistro"):
				System.out.println("Insira os parâmetros [PF ou PJ]");
				String tipo = scan.next();
				s1.vizualizarSinistro(tipo);
				System.out.println("Deseja realizar mais alguma ação ?");
				ordem = scan.next();
				switch (ordem) {
				case("Não"):
					System.out.println("Ok! Encerrando sessão");
					continuar = false;
				case("Sim"):
					System.out.println("Ok! ");
				}
			
			case("Encerrar"):
				System.out.println("Encerrando sessão");
				continuar = false;
			}
		} while (continuar);
	}
}
