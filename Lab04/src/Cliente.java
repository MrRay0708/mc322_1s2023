import java.util.ArrayList;

public abstract class Cliente {
	private String nome ;
	private String endereco ;
	private ArrayList<Veículo> listaVeículos ;

	// Construtor
	public Cliente(String nome, String endereco, ArrayList<Veículo> listaVeículos) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeículos = listaVeículos;
	}

	// Getters e setters
	public String getNome () {
		return nome ;
	}
	
	public void setNome ( String nome ) {
		this . nome = nome ;
	}
	
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this . endereco = endereco ;
	}
	
	public ArrayList<Veículo> getListaVeículos() {
		return listaVeículos;
	}

	public void setListaVeículos(ArrayList<Veículo> listaVeículos) {
		this.listaVeículos = listaVeículos;
	}

	// Checagem de dados
	public String toString () {
		String dados = "" ;
		dados += "Nome: " + getNome() + "\nEndereço: " + getEndereco() +  "\nVeículos: " + getListaVeículos() ;
		return dados ;
	}
	// Caculando score
	public abstract double calcularScore();
	
	// Listando Veículos
	public String listarVeiculosCliente() {
		for (int x=0; x<listaVeículos.size(); x++) {
			listaVeículos.get(x).toString() ;
		}
	}
	
	// Removendo veículos
	public boolean removerVeiculo (String placaCarro) {
		for (int x=0; x<listaVeículos.size(); x++) {
			if ( listaVeículos.get(x).getPlaca() == placaCarro ) {
				listaVeículos.remove(x) ;
			}
		}
		return true;
	}
	
}
