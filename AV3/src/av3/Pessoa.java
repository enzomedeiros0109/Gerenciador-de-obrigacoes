package av3;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public abstract class Pessoa{

	private String nome;
	private int idade;
	
	
	private String[] diasDaSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
	private HashMap<String, ArrayList<String>> obrigacoes = new HashMap<>();
	
	
	 public Pessoa(String nome, int idade) {
	        this.nome = nome;
	        this.idade = idade;   
	        this.obrigacoes = new HashMap<>();

	        for (String dia : diasDaSemana) {
	            obrigacoes.put(dia, new ArrayList<>());
	        }
	    } 
	
	 public void adicionarObrigacao(String tarefa, String dia) {
		    
		 	if(tarefa.contains(",") || tarefa.contains(";")) {
		 		
		 		JOptionPane.showMessageDialog(null, "O texto possui caracteres inválidos! Remova as vírgulas ou ponto e vírgula");
		 		return;
		 	}
		    
		 	if (!obrigacoes.containsKey(dia)) {
		        obrigacoes.put(dia, new ArrayList<>());
		    }

		    int totalTarefas = obrigacoes.get(dia).size();

		    if (this instanceof PessoaAdulta) {
		        if (totalTarefas >= 12) {
		            JOptionPane.showMessageDialog(null, "Máximo de obrigações para " + getNome() + " atingido!");
		        } else {
		            if (totalTarefas >= 10) {
		                JOptionPane.showMessageDialog(null, "Atenção: " + getNome() + " está com muitas tarefas!\nTarefa adicionada.");
		            } else {
		                JOptionPane.showMessageDialog(null, "Tarefa adicionada.");
		            }
		            obrigacoes.get(dia).add(tarefa);
		        }
		    } else if (this instanceof PessoaIdosa) {
		        if (totalTarefas >= 5) {
		            JOptionPane.showMessageDialog(null, "Máximo de obrigações para " + getNome() + " atingido!");
		        } else {
		            if (totalTarefas >= 3) {
		                JOptionPane.showMessageDialog(null, "Atenção: " + getNome() + " está com muitas tarefas!\nTarefa adicionada.");
		            }
		            JOptionPane.showMessageDialog(null, "Tarefa adicionada");
		            obrigacoes.get(dia).add(tarefa);
		        }
		    } else if (this instanceof PessoaCrianca) {
		        if (totalTarefas >= 6) {
		            JOptionPane.showMessageDialog(null, "Máximo de obrigações para " + getNome() + " atingido!");
		        } else {
		            if (totalTarefas >= 4) {
		                JOptionPane.showMessageDialog(null, "Atenção: " + getNome() + " está com muitas tarefas!\nTarefa adicionada.");
		            }
		            JOptionPane.showMessageDialog(null, "Tarefa adicionada.");
		            obrigacoes.get(dia).add(tarefa);
		        }
		    } else { 
		        if (totalTarefas >= 10) {
		            JOptionPane.showMessageDialog(null, "Máximo de obrigações para " + getNome() + " atingido!");
		        } else {
		            if (totalTarefas >= 6) {
		                JOptionPane.showMessageDialog(null, "Atenção: " + getNome() + " está com muitas tarefas!\nTarefa adicionada.");
		            }
		            JOptionPane.showMessageDialog(null, "Tarefa adicionada");
		            obrigacoes.get(dia).add(tarefa);
		        }
		    }
		}
	 
	public void adicionarObrigacaoSemAviso(String tarefa, String dia) {
		
		if (obrigacoes.containsKey(dia)) {
            obrigacoes.get(dia).add(tarefa);
		}
		
	}

	public void removerObrigacao(String tarefa, String dia) {
	        
		if(tarefa.contains(",") || tarefa.contains(";")) {
	 		
	 		JOptionPane.showMessageDialog(null, "o texto possui caracteres inválidos! Remova as vírgulas ou ponto e vírgula");
	 		return;
	 	}
		
		if (!(obrigacoes.get(dia).contains(tarefa))) {
	            
	            JOptionPane.showMessageDialog(null, "Tarefa não encontrada para o dia");
	            
	        } else {
				
	        	obrigacoes.get(dia).remove(tarefa);
	        	JOptionPane.showMessageDialog(null, "Obrigacão removida");
				
			}
	    }
	
	public void removerObrigacao(String dia) {
		
		if(obrigacoes.containsKey(dia)) {
			
			obrigacoes.get(dia).clear();
			
		}
		
	}

	public void realizarObrigacao(String tarefa, String dia) {
	        if (obrigacoes.containsKey(dia) && obrigacoes.get(dia).contains(tarefa)) {
	            obrigacoes.get(dia).remove(tarefa);
	           
	        }
	    }
	    
	public String[] getDiasDaSemana() {
		return diasDaSemana;
	}
	 
	public HashMap<String, ArrayList<String>> getObrigacoes() {
		
		return obrigacoes;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	@Override
	public String toString() {
	    return nome + " (" + idade + ")"; // Para o JComboBox de AbaAcessarObrigacoes mostrar o nome da pessoa e não o endereço de memória
	}
	
	
	
}
