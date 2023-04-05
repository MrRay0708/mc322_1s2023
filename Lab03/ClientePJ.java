
public class ClientePJ {
	private String cnpj ;
	private int dataFundacao ;
	
	// Construtor
	public ClientePJ ( String cnpj , int dataFundacao ) {
		this . cnpj = cnpj ;
		this . dataFundacao = dataFundacao ;
	}
	
	// Getters e setters
	public String getCnpj () {
		return cnpj ;
	}
	
	public void setCnpj ( String cnpj ) {
		this . cnpj = cnpj ;
	}
	
	public int getDataFundacao () {
		return dataFundacao ;
	}
	
	public void setDataFundacao ( int dataFundacao ) {
		this . dataFundacao = dataFundacao ;
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
		char primeiroDigito = intCnpj.charAt(9) ; 
		char segundoDigito = intCnpj.charAt(10) ;
		int somatorio = 0 ;
		// Cálculo do primeiro digito
		for ( int manipulador = 8 ; manipulador != -1 ; manipulador-- ) {
			somatorio += ( manipulador + 2 ) * ( intCnpj.charAt(8 - manipulador) - '0');
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
		for ( int manipulador = 9 ; manipulador != 0 ; manipulador-- ) {
			somatorio += ( manipulador + 1 ) * ( intCnpj.charAt(10 - manipulador) - '0');
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
}
