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
	
	// Validador de cnpj
	public boolean validadorCnpj ( String cnpj ) {
		boolean veredito = false ;
		String intCnpj = cnpj.replaceAll("[^0-9]", "") ;
		char primeiroDigito = intCnpj.charAt(12) ; 
		char segundoDigito = intCnpj.charAt(13) ;
		int somatorio = 0 ;
		int contador = 0 ;
		// Cálculo do primeiro digito
		for ( int manipulador = 5 ; contador <= 11 ; manipulador-- ) {
			if ( contador == 4 ) {
				manipulador = 9 ;
			}
			somatorio += ( manipulador ) * ( intCnpj.charAt( contador ) - '0');
			contador += 1 ;
			
		}
		somatorio = somatorio%11 ;
		// Ajustes
		if ( somatorio < 2) {
			somatorio = 0 ;
		}
		else {
			somatorio = 11 - somatorio ; 
		}
		// Verificação
		if ( somatorio != primeiroDigito - '0' ) {
			return veredito ;
		}
		// Cálculo do segundo digito
		somatorio = 0 ;
		contador = 0 ;
		for ( int manipulador = 6 ; contador <= 12 ; manipulador-- ) {
			if ( contador == 5 ) {
				manipulador = 9 ;
			}
			somatorio += ( manipulador ) * ( intCnpj.charAt( contador ) - '0');
			contador += 1 ;
			
		}
		somatorio = somatorio%11 ;
		// Ajustes
		if ( somatorio < 2) {
			somatorio = 0 ;
		}
		else {
			somatorio = 11 - somatorio ; 
		}
		// Verificação
		if ( somatorio != segundoDigito - '0' ) {
			return veredito ; 
		}
		veredito = true ;
		return veredito ;
	}
	// Caculando score
	public double calcularScore() {
		CalcSeguro base = CalcSeguro.VALOR_BASE;
		( 1 + (this.quantFunc) / 100 ) * getListaVeículos().size() * base.getVariavel(); 
	}
}
