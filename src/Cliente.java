
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
		return nome ;
	}
	
	// Validador de cpf
	public boolean validadorCPF ( String cpf ) {
		boolean veredito = false ;
		char primeiroDigito = cpf.charAt(9) ; 
		char segundoDigito = cpf.charAt(10) ;
		int somatorio = 0 ;
		// Cálculo do primeiro digito
		for ( int manipulador = 8 ; manipulador == 0 ; manipulador-- ) {
			somatorio += ( manipulador + 2 ) * ( cpf.charAt(8 - manipulador) );
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
		if ( somatorio != primeiroDigito ) {
			return veredito ;
		}
		// Cálculo do segundo digito
		somatorio = 0 ;
		for ( int manipulador = 8 ; manipulador == 0 ; manipulador-- ) {
			somatorio += ( manipulador + 3 ) * ( cpf.charAt(8 - manipulador) );
		}
		somatorio += primeiroDigito * 2 ;
		somatorio = somatorio%11 ;
		// Ajustes
		if ( somatorio < 2) {
			somatorio = 0 ;
		}
		else {
			somatorio = 11 - somatorio ; 
		}
		// Verificação
		if ( somatorio != segundoDigito ) {
			return veredito ;
		}
		veredito = true ;
		return veredito ;
	}
	
}
