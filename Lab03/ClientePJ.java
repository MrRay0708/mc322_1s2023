import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private String cnpj ;
	private int dataFundacao ;
	
	// Construtor
	public ClientePJ(String nome, String endereco, ArrayList<Veículo> listaVeículos, String cnpj , int dataFundacao ) {
		super(nome, endereco, listaVeículos);
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
		char primeiroDigito = intCnpj.charAt(12) ; 
		char segundoDigito = intCnpj.charAt(13) ;
		int somatorio = 0 ;
		int contador = 0 ;
		// Cálculo do primeiro digito
		for ( int manipulador = 5 ; contador != 11 ; manipulador-- ) {
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
		for ( int manipulador = 6 ; contador != 11 ; manipulador-- ) {
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
}
