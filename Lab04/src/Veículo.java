
public class Veículo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	// Construtor
	public Veículo ( String placa, String marca, String modelo, int anoFabricacao) {
		this . placa = placa;
		this . marca = marca;
		this . modelo = modelo;
		this . anoFabricacao = anoFabricacao;
	}
	
	// Getters e setters
	public String getPlaca () {
		return placa ;
	}
	
	public void setPlaca ( String placa ) {
		this . placa = placa ;
	}
	
	public String getMarca () {
		return marca ;
	}
	
	public void setMarca ( String marca ) {
		this . marca = marca ;
	}
	
	public String getModelo () {
		return modelo ;
	}
	
	public void setModelo ( String modelo ) {
		this . modelo = modelo ;
	}
	
	public int getAnoFabricacao () {
		return anoFabricacao ;
	}
	
	public void setAnoFabricacao ( int anoFabricacao ) {
		this . anoFabricacao = anoFabricacao ;
	}
	
	// Checagem de dados
	public String toString () {
		String dados = "" ;
		dados += "Modelo: " + getModelo() + "\nMarca: " + getMarca() + "\nAno de fabricação: " + getAnoFabricacao() + "\nPlaca: " + getPlaca() ;
		return dados ;
	}
}
