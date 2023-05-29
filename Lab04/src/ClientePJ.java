import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private String cnpj ;
	private String dataFundacao ;
	private double quantFunc;
	
	// Construtor
	public ClientePJ(String nome, String endereco, ArrayList<Veículo> listaVeículos, String cnpj , String dataFundacao, int quantFunc ) {
		super(nome, endereco, listaVeículos);
		this . cnpj = cnpj ;
		this . dataFundacao = dataFundacao ;
		this. quantFunc = quantFunc;
	}

	// Getters e setters
	public String getCnpj () {
		return cnpj ;
	}
	
	public void setCnpj ( String cnpj ) {
		this . cnpj = cnpj ;
	}
	
	public String getDataFundacao () {
		return dataFundacao ;
	}
	
	public void setDataFundacao ( String dataFundacao ) {
		this . dataFundacao = dataFundacao ;
	}
	
	public double getQuantFunc() {
		return quantFunc;
	}

	public void setQuantFunc( double quantFunc ) {
		this . quantFunc = quantFunc;
	}

	// Checagem de dados
	public String toString () {
		String dados = "" ;
		dados += "Cnpj: " + getCnpj() + "\nData de fundação: " + getDataFundacao() ;
		return dados ;
	}
	
	// Caculando score
	public double calcularScore() {
		CalcSeguro base = CalcSeguro.VALOR_BASE;
		return ( 1 + quantFunc / 100 ) * getListaVeículos().size() * base.getVariavel(); 
	}
	
	// Listar Sinistros
}
