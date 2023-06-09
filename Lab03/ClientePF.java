import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePF extends Cliente{
	private String cpf ;
	private String dataNascimento ;
	private LocalDate dataLicenca ;
	private String educacao ;
	private String genero ;
	private String classeEconomica ;
	
	// Construtor
	public ClientePF(String nome, String endereco, ArrayList<Veículo> listaVeículos, String genero, String classeEconomica, String educacao,
			LocalDate dataLicenca, String cpf , String dataNascimento) {
		super(nome, endereco, listaVeículos);
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.educacao = educacao;
		this.dataLicenca = dataLicenca;
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
	
	public String getDataNascimento () {
		return dataNascimento ;
	}
	
	public void setDataNascimento ( String dataNascimento ) {
		this . dataNascimento = dataNascimento ;
	}
	
	public String getGenero () {
		return genero ;
	}
	
	public void setGenero ( String genero ) {
		this . genero = genero ;
	}
	
	public String getClasseEconomica () {
		return classeEconomica ;
	}
	
	public void setClasseEconomica ( String classeEconomica ) {
		this . classeEconomica = classeEconomica ;
	}
	
	public String getEducacao () {
		return educacao ;
	}
	
	public void setEducacao ( String educacao ) {
		this . educacao = educacao ;
	}
	
	public LocalDate getDataLicenca () {
		return dataLicenca ;
	}
	
	public void setDataLicenca ( LocalDate dataLicenca ) {
		this . dataLicenca = dataLicenca ;
	}
	
	// Checagem de Dados
	public String toString() {
		return "ClientePF \nCpf: " + cpf + " \nDataNascimento: " + dataNascimento + " \nDataLicenca: " + dataLicenca
				+ " \nEducacao: " + educacao + " \nGenero: " + genero + " \nClasseEconomica: " + classeEconomica;
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
