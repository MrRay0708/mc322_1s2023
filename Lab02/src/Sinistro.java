public class Sinistro {
	private static int marcador = 0 ;
	private int id ;
	private String data ;
	private String endereco ;

	// Construtor
	public Sinistro ( int id , String data , String endereco ) {
		this . id = id ;
		this . data = data ;
		this . endereco = endereco ;
	}

	// Getters e setters
	public int getId () {
		return id ;
	}	
	
	public void setId ( int id ) {
		this . id = id ;
	}
	
	public String getData () {
		return data ;
	}
	
	public void setData ( String data ) {
		this . data = data ;
	}
	
	public String getEndereco () {
		return endereco ;
	}
	
	public void setEndereco ( String endereco ) {
		this . endereco = endereco ;
	}
	
	// Método de geração de Id
	public int buildId () {
		marcador += 1 ;
		this. id = marcador ;
		return id ;
	}
}