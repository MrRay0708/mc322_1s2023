
public class Cliente {
	private String nome ;
	private String cpf ;
	private String dataNascimento ;
	private String endereco ;
	private int idade ;

	// Construtor
	public Cliente ( String nome , String cpf , String dataNascimento , String endereco , int idade ) {
		this . nome = nome ;
		this . cpf = cpf ;
		this . dataNascimento = dataNascimento ;
		this . endereco = endereco ;
		this . idade = idade ;
	}

	// Getters e setters
	public String getNome () {
		return nome ;
	}
	
	public void setNome ( String nome ) {
		this . nome = nome ;
	}
	
	public String getCpf () {
		return cpf ;
	}
	
	public void setCpf ( String cpf ) {
		this . cpf = cpf ;
	}
	
	public String getDataNascimento () {
		return dataNascimento ;
	}
	
	public void setDataNascimento ( String dataNascimento ) {
		this . dataNascimento = dataNascimento ;
	}
	
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this . endereco = endereco ;
	}
	
	public int getIdade () {
		return idade ;
	}
	
	public void setIdade ( int idade ) {
		this . idade = idade ;
	}
	
	// Checagem de dados
	public String toString () {
		String dados = "" ;
		dados += "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nData de nascimento: " + getDataNascimento() + "\nIdade: " + getIdade() + "\nEndereço: " + getEndereco() ;
		return dados ;
	}
	
	// Validador de cpf
	public boolean validadorCPF ( String cpf ) {
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
