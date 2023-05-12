import java.time.LocalDate;
import java.util.ArrayList;

public class Seguradora {
	private static int id = 0 ;
	private String nome ;
	private String telefone ;
	private String email ;
	private String endereco ;
	private ArrayList <Sinistro> listaSinistros ;
	private ArrayList <Cliente> listaClientes ;

	// Construtor
		public Seguradora(String nome, String telefone, String email, String endereco, ArrayList<Sinistro> listaSinistros,
				ArrayList<Cliente> listaClientes) {
			super();
			this.nome = nome;
			this.telefone = telefone;
			this.email = email;
			this.endereco = endereco;
			this.listaSinistros = listaSinistros;
			this.listaClientes = listaClientes;
		}

	// Getters e setters
		public String getNome () {
			return nome ;
		}
		
		public void setNome ( String nome ) {
			this . nome = nome ;
		}
		
		public String getTelefone () {
			return telefone ;
		}
		
		public void setTelefone ( String telefone ) {
			this . telefone = telefone ;
		}
		
		public String getEmail () {
			return email ;
		}
		
		public void setEmail ( String email ) {
			this . email = email ;
		}
		
		public String getEndereco () {
			return endereco ;
		}
		
		public void setEndereco ( String endereco ) {
			this . endereco = endereco ;
		}
	
		public ArrayList<Sinistro> getListaSinistros() {
			return listaSinistros;
		}
	
		public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
			this.listaSinistros = listaSinistros;
		}
	
		public ArrayList<Cliente> getListaClientes() {
			return listaClientes;
		}
	
		public void setListaClientes(ArrayList<Cliente> listaClientes) {
			this.listaClientes = listaClientes;
		}
	
	// Cadastro de Clientes 
		public boolean cadastrarCliente ( Cliente cliente ) {
			listaClientes.add(cliente);
			calcularPrecoSeguroCliente(cliente);
			return true;
		}
	
	// Remoção de Clientes
		public boolean removerCliente ( String cliente ) {
			for (int x=0; x<listaClientes.size(); x++) {
				if (listaClientes.get(x).getNome() == cliente) {
					listaClientes.remove(x);
					break;
				}
			}
			for (int x=0; x<listaSinistros.size(); x++) {
				if (listaSinistros.get(x).getCliente().getNome() == cliente) {
					listaSinistros.remove(x);
				}
			}
			return true;
		}
		
	// Remoção de Sinistro
		boolean removerSinistro ( int idSinistro ) {
			for (int x=0; x<listaSinistros.size(); x++) {
				if (listaSinistros.get(x).getId() == idSinistro) {
					listaSinistros.remove(x);
				}
			}
		}
		
	// Gerador de Sinistro
		public boolean gerarSinistro( Cliente cliente, Veículo carro ) {
			Sinistro novoSinistro = new Sinistro(buildId(), LocalDate.now(), endereco, Seguradora.this, carro, cliente) ;
			listaSinistros.add(novoSinistro);
			return true;
		}
	
	// Método de geração de Id
		public int buildId () {
			id += 1 ;
			return id ;
		}
	
	// Vizualição de Sinistros
		public boolean vizualizarSinistro( String tipoCliente ) {
			
			if (tipoCliente == "PF") {
				for (int x=0; x<listaSinistros.size(); x++) {
					if (listaSinistros.get(x).getCliente() instanceof ClientePF) {
						System.out.println (listaSinistros.get(x).getId());
					}
				}
			}
			else {
				for (int x=0; x<listaSinistros.size(); x++) {
					if (listaSinistros.get(x).getCliente() instanceof ClientePJ) {
						System.out.println (listaSinistros.get(x).getId());
					}
				}
			}
			return true;
		}
		
	// Listando Sinistros
		public String listarSinistros() {
			String bigstring = new String();
			if (!listaSinistros.isEmpty()) {
				for (int x=0; x<listaSinistros.size(); x++) {
					if (x==listaSinistros.size()-1) {
						bigstring += listaSinistros.get(x).getId() + ".";
					}
					else {
						bigstring += listaSinistros.get(x).getId() + ", ";
					}
				}
				return bigstring;
			}
			return "Não há Sinistros!";
		}
		
	// Listando Veículos
		public String listarVeiculos() {
			String bigstring = new String();
			if (!listaClientes.isEmpty()) {
				for (int x=0; x<listaClientes.size(); x++) {
					if (x==listaClientes.size()-1) {
						bigstring += listaClientes.get(x).getNome() + ": " + listaClientes.get(x).listarVeiculosCliente() + ".";
					}
					else {
						bigstring += listaClientes.get(x).getNome() + ": " + listaClientes.get(x).listarVeiculosCliente() + "; ";
					}
				}
				return bigstring;
			}
			return "Não há Veículos!";
		}
		
	// Listando Sinistros pelo cliente
		public String listarSinistroCliente( String nomecli ) {
			String bigstring = new String();
			if (!listaSinistros.isEmpty()) {
				for (int x=0; x<listaSinistros.size(); x++) {
					if (listaSinistros.get(x).getCliente().getNome() == nomecli) {
						listaSinistros.get(x).toString();
					}
				}
			}
			return "Não há Sinistros!";
		}
		
	// Listando Veículos pelo cliente
			public String listarVeiculosCliente( String nomecli ) {
				String bigstring = new String();
				if (!listaClientes.isEmpty()) {
					for (int x=0; x<listaClientes.size(); x++) {
						if (listaClientes.get(x).getNome() == nomecli) {
							listaClientes.get(x).listarVeiculosCliente();
						}
					}
				}
				return "Não há este CLiente!";
			}	
	
	// Listando Clientes
		public String listarClientes() {
			String bigstring = new String();
			if (!listaClientes.isEmpty()) {
				for (int x=0; x<listaClientes.size(); x++) {
					if (x==listaClientes.size()-1) {
						bigstring += listaClientes.get(x).getNome() + ".";
					}
					else {
						bigstring += listaClientes.get(x).getNome() + ", ";
					}
				}
				return bigstring;
			}
			return "Não há Clientes!";
		}
		
	// Adicionar Veiculo no Cliente
		public String addVeiculo( String nomecli, Veículo carrin ) {
			String bigstring = new String();
			if (!listaClientes.isEmpty()) {
				for (int x=0; x<listaClientes.size(); x++) {
					if (listaClientes.get(x).getNome() == nomecli) {
						listaClientes.get(x).addVeiculo(carrin) ;
					}
				}
			}
			return "Não há este CLiente!";
		}
		
	// Remover Veiculo no Cliente
			public String removerVeiculo( String nomecli, String placa ) {
				String bigstring = new String();
				if (!listaClientes.isEmpty()) {
					for (int x=0; x<listaClientes.size(); x++) {
						if (listaClientes.get(x).getNome() == nomecli) {
							listaClientes.get(x).removerVeiculo(placa) ;
						}
					}
				}
				return "Não há este Cliente!";
			}
		
	// Calculando Preço
		public double calcularPrecoSeguroCliente( Cliente cliente ) {
			int sinistros = 0;
			if (!listaSinistros.isEmpty()) {
				for (int x=0; x<listaSinistros.size(); x++) {
					if (listaSinistros.get(x).getCliente().getNome() == cliente.getNome() ) {
						sinistros += 1;
					}
				}
			}
			return cliente.calcularScore() * ( 1 + sinistros );
		}
		
	// Calculando Receita
		public double calcularReceita( ) {
			double receita = 0;
			if (!listaClientes.isEmpty()) {
				for (int x=0; x<listaClientes.size(); x++) {
					receita += calcularPrecoSeguroCliente( listaClientes.get(x) );
				}
			}
			return receita;
		}
		
	// Transfência de Seguro
		public String tranferencia( String cliente, String destinatario ) {
			int indice_1 = 0;
			int indice_2 = 0;
			String bigstring = new String();
			if (!listaClientes.isEmpty()) {
				for (int x=0; x<listaClientes.size(); x++) {
					if (listaClientes.get(x).getNome() == cliente) {
						indice_1 = x;
					}
					else if (listaClientes.get(x).getNome() == destinatario) {
						indice_2 = x;
					}
				}
				listaClientes.get(indice_2).getListaVeículos().addAll(listaClientes.get(indice_1).getListaVeículos());
				removerCliente( cliente );
			}
			return "Não há este Cliente!";
		}

	// Checagem de Dados
		public String toString() {
			return "Seguradora \nNome: " + nome + ", \nTelefone: " + telefone + ", \nEmail: " + email
					+ ", \nEndereco: " + endereco + ", \nListaSinistros: " + listaSinistros + ", \nListaClientes: "
					+ listaClientes;
		}
	
}