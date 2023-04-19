public class Sinistro {
	private static int marcador = 0 ;
	private int id ;
	private String data ;
	private String endereco ;
	private Seguradora seguradora ;
	private Veículo veiculo ;
	private Cliente cliente ;

	// Construtor
	public Sinistro(int id, String data, String endereco, Seguradora seguradora, Veículo veiculo, Cliente cliente) {
		super();
		this.id = id;
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	// Getters e setters
	public int getId () {
		return id ;
	}	
	
	public void setId ( int id ) {
		this . id = id ;
	}
	
	public String getData () {
		return data ;
	}
	
	public void setData ( String data ) {
		this . data = data ;
	}
	
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this . endereco = endereco ;
	}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veículo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veículo veiculo) {	 
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Método de geração de Id
	public int buildId () {
		marcador += 1 ;
		this. id = marcador ;
		return id ;
	}
	
	// Checagem de Dados
	public String toString() {
		return "Sinistro [Id: " + id + "\nData: " + data + "\nEndereco: " + endereco + "\nSeguradora: " + seguradora
				+ "\nVeículo: " + veiculo + "\nCliente: " + cliente + "]";
	}
}