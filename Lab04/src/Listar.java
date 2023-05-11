public enum Listar {
	LISTAR_CLIENTE_PF_ou_PJ_POR_SEGURADORA (1) ,
	LISTAR_SINISTROS_POR_SEGURADORA (2) ,
	LISTAR_VEICULO_POR_SEGURADORA(3) ,
	LISTAR_SINISTRO_POR_CLIENTE (4) ,
	LISTAR_VEICULO_POR_CLIENTE (5) ,
	VOLTAR (6) ;
	
	public final int operacao ;
	
	Listar ( int operacao ) {
		this . operacao = operacao ;
	}
	
	public int getOperacao () {
		return this . operacao ;
	}
}
