package av3;

public class PessoaAdulta extends Pessoa implements Obrigacoes, Mesada{

	private double mesada;
	public PessoaAdulta(String nome, int idade) {
		super(nome, idade);
		this.mesada = 0;
	}
	
	@Override
	public double getMesada() {
		
		return mesada;
	}
	@Override
    public double setMesada(double mesada) {
			
		return this.mesada = mesada;
	}
}
