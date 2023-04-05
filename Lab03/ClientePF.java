
public class ClientePF {
	private String cpf ;
	private int dataNascimento ;
	
	// Construtor
	public ClientePF ( String cpf , int dataNascimento ) {
		this . cpf = cpf ;
		this . dataNascimento = dataNascimento ;
	}
	
	// Getters e setters
	public String getCpf () {
		return cpf ;
	}
	
	public void setCpf ( String cpf ) {
		this . cpf = cpf ;
	}
	
	public int getDataNascimento () {
		return dataNascimento ;
	}
	
	public void setDataNascimento ( int dataNascimento ) {
		this . dataNascimento = dataNascimento ;
	}
	
	// Checagem de dados
	public String toString () {
		String dados = "" ;
		dados += "Cpf: " + getCpf() + "\nData de fundação: " + getDataNascimento() ;
		return dados ;
	}
	
	// Validador de cpf
	public boolean validadorCpf ( String cpf ) {
		boolean veredito = false ;
		String intCpf = cpf.replaceAll("[^0-9]", "") ;
		char primeiroDigito = intCpf.charAt(9) ; 
		char segundoDigito = intCpf.charAt(10) ;
		int somatorio = 0 ;
		// Cálculo do primeiro digito
		for ( int manipulador = 8 ; manipulador != -1 ; manipulador-- ) {
			somatorio += ( manipulador + 2 ) * ( intCpf.charAt(8 - manipulador) - '0');
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
			somatorio += ( manipulador + 1 ) * ( intCpf.charAt(10 - manipulador) - '0');
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
