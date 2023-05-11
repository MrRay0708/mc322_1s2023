import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ClientePF extends Cliente{
	private String cpf ;
	private LocalDate dataNascimento ;
	private LocalDate dataLicenca ;
	private String educacao ;
	private String genero ;
	private String classeEconomica ;
	
	// Construtor
	public ClientePF(String nome, String endereco, ArrayList<Veículo> listaVeículos, String genero, String classeEconomica, String educacao,
			LocalDate dataLicenca, String cpf , LocalDate dataNascimento) {
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
	
	public LocalDate getDataNascimento () {
		return dataNascimento ;
	}
	
	public void setDataNascimento ( LocalDate dataNascimento ) {
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
	
	// Caculando score
	public double calcularScore() {
		CalcSeguro fator;
		CalcSeguro base = CalcSeguro.VALOR_BASE;
		LocalDate hoje = LocalDate.now();
		int idade = Period.between(dataNascimento, hoje).getYears();
		if ( 18 <= idade & idade < 30 ) {
			fator = CalcSeguro.FATOR_18_30;
		}
		else if ( idade < 60 ) {
			fator = CalcSeguro.FATOR_30_60;
		}
		else if ( idade < 90 ) {
			fator = CalcSeguro.FATOR_60_90;
		}
		return getListaVeículos().size() * fator.getVariavel() * base.getVariavel();
	}
}
