
public class Validacao {
	// Validador de cpf
		public static boolean validadorCpf ( String cpf ) {
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
		
	// Validador de cnpj
		public static boolean validadorCnpj ( String cnpj ) {
			boolean veredito = false ;
			String intCnpj = cnpj.replaceAll("[^0-9]", "") ;
			char primeiroDigito = intCnpj.charAt(12) ; 
			char segundoDigito = intCnpj.charAt(13) ;
			int somatorio = 0 ;
			int contador = 0 ;
			// Cálculo do primeiro digito
			for ( int manipulador = 5 ; contador <= 11 ; manipulador-- ) {
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
			for ( int manipulador = 6 ; contador <= 12 ; manipulador-- ) {
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
	
	// Validação de Nome	
		public static boolean validadorNome ( String nome ) {
			if ( nome.matches("[A-Z]*") ) {
				return true;
			}
			return false;
		}
}
