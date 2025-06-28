package av3;

public class PessoaCrianca extends Pessoa implements Obrigacoes, Mesada{

	private double mesada;
	
	public PessoaCrianca(String nome, int idade) {
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
