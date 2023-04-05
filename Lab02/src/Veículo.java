
public class Veículo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	// Construtor
	public Veículo ( String placa, String marca, String modelo) {
		this . placa = placa;
		this . marca = marca;
		this . modelo = modelo;
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
	
	public int getAno () {
		return anoFabricacao ;
	}
	
	public void setAno ( int anoFabricacao ) {
		this . anoFabricacao = anoFabricacao ;
	}
	
	// Checagem de dados
	public String toString () {
		String dados = "" ;
		dados += "Modelo: " + getModelo() + "\nMarca: " + getMarca() + "\nAno de fabricação: " + getAno() + "\nPlaca: " + getPlaca() ;
		return dados ;
	}
}
