
public class Main {
	public static void main(){
		
		// Segurador
		Seguradora s1 = new Seguradora ( "Bom Seguros", "011958742000", "megatronterrivel@gmail.com", "Rua Segura") ; // Builder
		
		s1.setNome ( "Ótimos Seguros" ) ; // Setter
		String nominho = s1.getNome() ; // Getter
		System.out.print( nominho ) ;
		
		// Veículo
		Veículo carrin = new Veículo ( "SEI0N454", "Ford", "Poçante maneiro") ; // Builder
		
		carrin.setPlaca ( "FUI4G054" ) ; // Setter
		String plaquinha = carrin.getPlaca() ; // Getter
		System.out.print( plaquinha ) ;
		
		// Sinistro
		Sinistro acidente = new Sinistro ( 1542, "15/06/2354", "Rua Nada Segura") ; // Builder
		
		int idProprio = acidente.buildId() ; // Criador de Id
		
		acidente.setId( idProprio ) ; // Setter
		int idzinho = acidente.getId() ; // Getter
		System.out.print( idzinho ) ;
		
		// Cliente
		Cliente cli1 = new Cliente ( "Roberto Justus Segundo", "018.691.799-60" , "07/03/2318", "Rua Ben10", 36) ; // Builder
		
		System.out.print( cli1.validadorCPF( cli1.getCpf() ) ) ; // Validador
		
		cli1.setEndereco( "Rua Vilgax" ) ; // Setter
		String ruinha = cli1.getEndereco() ; // Getter
		System.out.print( ruinha ) ;
		
		System.out.print( cli1.toString() ) ; // Dados
	}
}
