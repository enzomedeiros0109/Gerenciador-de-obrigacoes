package av3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class JanelaObrigacoesDaPessoa extends JFrame implements ActionListener{
	
	public JanelaObrigacoesDaPessoa(Pessoa pessoa, ListaPessoas lista) throws IOException {
		
		setTitle("Obrigacões de " + pessoa.getNome());
		ImageIcon icone = new ImageIcon("icone.png");
        setIconImage(icone.getImage());
		setSize(800, 800);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton botaoVoltarAcessarPessoas = new JButton("Voltar");
		botaoVoltarAcessarPessoas.setForeground(new Color(23, 78, 166));
		botaoVoltarAcessarPessoas.setFont(new Font("SansSerif", Font.PLAIN, 17));
		botaoVoltarAcessarPessoas.setBackground(new Color(255, 255, 255));
		botaoVoltarAcessarPessoas.setBounds(10, 10, 130, 40);
		
		botaoVoltarAcessarPessoas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	dispose();
  
            }
        });
		
		getContentPane().add(botaoVoltarAcessarPessoas);
		
		JLabel TextoNomePessoa = new JLabel(pessoa.getNome());
		TextoNomePessoa.setForeground(new Color(23, 78, 166));
		TextoNomePessoa.setFont(new Font("SansSerif", Font.PLAIN, 20));
		TextoNomePessoa.setHorizontalAlignment(SwingConstants.CENTER);
		TextoNomePessoa.setBounds(20, 230, 200, 40);
		getContentPane().add(TextoNomePessoa);
		
		JLabel textoIdadePessoa = new JLabel(String.valueOf(pessoa.getIdade() + " anos"));
		textoIdadePessoa.setForeground(new Color(23, 78, 166));
		textoIdadePessoa.setHorizontalAlignment(SwingConstants.CENTER);
		textoIdadePessoa.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textoIdadePessoa.setBounds(20, 330, 200, 40);
		getContentPane().add(textoIdadePessoa);
		
		String textoMesada;
		if (pessoa instanceof Mesada) {
		    
			double valorMesada = ((Mesada) pessoa).getMesada();
		    textoMesada = "Mesada: R$ " + valorMesada;
		} else {
		    textoMesada = "Mesada: N/A";
		}
		
		

		JLabel textoMesadaPessoa = new JLabel(textoMesada);
		textoMesadaPessoa.setForeground(new Color(23, 78, 166));
		textoMesadaPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		textoMesadaPessoa.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textoMesadaPessoa.setBounds(20, 430, 200, 40);
		getContentPane().add(textoMesadaPessoa);
		
		JComboBox<String> selecionarDiaDaSemana = new JComboBox<>(pessoa.getDiasDaSemana());
		selecionarDiaDaSemana.setForeground(new Color(23, 78, 166));
		selecionarDiaDaSemana.setFont(new Font("SansSerif", Font.PLAIN, 20));
		selecionarDiaDaSemana.setBounds(231, 23, 500, 40);
		

		JTextArea areaObrigacoes = new JTextArea();
		areaObrigacoes.setForeground(new Color(23, 78, 166));
		areaObrigacoes.setBackground(new Color(240, 240, 240));
		areaObrigacoes.setLineWrap(true);
		areaObrigacoes.setFont(new Font("SansSerif", Font.PLAIN, 25));
		areaObrigacoes.setBounds(273, 112, 400, 450);
		areaObrigacoes.setEditable(false);
		
		
		selecionarDiaDaSemana.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    	
		    	
		    	String diaSelecionado = (String) selecionarDiaDaSemana.getSelectedItem();
		        HashMap<String, ArrayList<String>> mapaObrigacoes = pessoa.getObrigacoes();
		        
		        areaObrigacoes.setText(""); // limpa antes
		       
		        if (mapaObrigacoes == null || !mapaObrigacoes.containsKey(diaSelecionado) 
		                || mapaObrigacoes.get(diaSelecionado) == null
		                || mapaObrigacoes.get(diaSelecionado).isEmpty()) {

		                areaObrigacoes.setText("Nenhuma tarefa para esse dia");
		                return;
		            }
		        
		        if (mapaObrigacoes.containsKey(diaSelecionado)) {
		            ArrayList<String> obrigacoesDoDia = mapaObrigacoes.get(diaSelecionado);
		            
		            for (String obrigacao : obrigacoesDoDia) {
		                areaObrigacoes.append("• " + obrigacao + "\n");
		            }
		        } else {
		            areaObrigacoes.setText("Nenhuma obrigação para este dia.");
		            
		        }
		    }
		});
		
		selecionarDiaDaSemana.setSelectedIndex(selecionarDiaDaSemana.getSelectedIndex());
		
		
		getContentPane().add(areaObrigacoes);
		getContentPane().add(selecionarDiaDaSemana);
		
		JButton botaoDefinirMesada = new JButton("Definir mesada");
		botaoDefinirMesada.setForeground(new Color(23, 78, 166));
		botaoDefinirMesada.setFont(new Font("SansSerif", Font.PLAIN, 15));
		botaoDefinirMesada.setBackground(Color.WHITE);
		botaoDefinirMesada.setBounds(20, 522, 200, 40);
		
		if(!(pessoa instanceof Mesada)) {
			
			botaoDefinirMesada.setVisible(false);
			textoMesadaPessoa.setVisible(false);
			
			
		}
		
		botaoDefinirMesada.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                
            	JanelaDefinirMesada janelaDefinirMesada = new JanelaDefinirMesada(pessoa, textoMesadaPessoa);
                 
            }
        });
		
		getContentPane().add(botaoDefinirMesada);
		
		JButton botaoAdicionarObrigacao = new JButton("Adicionar obrigação");
		botaoAdicionarObrigacao.setForeground(new Color(23, 78, 166));
		botaoAdicionarObrigacao.setFont(new Font("SansSerif", Font.PLAIN, 15));
		botaoAdicionarObrigacao.setBounds(273, 601, 170, 40);
		getContentPane().add(botaoAdicionarObrigacao);
		
		botaoAdicionarObrigacao.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	                
	            	JanelaAdicionarObrigacao janelaAdicionarObrigacao = new JanelaAdicionarObrigacao(pessoa, selecionarDiaDaSemana);
	                 
	            }
	        });
		
		JButton botaoRemoverObrigacao = new JButton("Remover obrigação");
		botaoRemoverObrigacao.setForeground(new Color(23, 78, 166));
		botaoRemoverObrigacao.setFont(new Font("SansSerif", Font.PLAIN, 15));
		botaoRemoverObrigacao.setBounds(503, 601, 170, 40);
		
		botaoRemoverObrigacao.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	                
	            	JanelaRemoverObrigacao janelaRemoverObrigacao = new JanelaRemoverObrigacao(pessoa, selecionarDiaDaSemana);
	                 
	            }
	        });
		
		getContentPane().add(botaoRemoverObrigacao);
		
		JButton botaoRemoverTodasObrigacoes = new JButton("Remover todas obrigações");
		botaoRemoverTodasObrigacoes.setForeground(new Color(23, 78, 166));
		botaoRemoverTodasObrigacoes.setFont(new Font("SansSerif", Font.PLAIN, 15));
		botaoRemoverTodasObrigacoes.setBounds(363, 684, 220, 40);
		getContentPane().add(botaoRemoverTodasObrigacoes);
		
		botaoRemoverTodasObrigacoes.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	                
	        	int resposta = JOptionPane.showConfirmDialog(null, "Deseja remover todas as obrigações do dia?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
	            	
	        	if(resposta == JOptionPane.YES_OPTION) {
	        		
	        		String dia = (String) selecionarDiaDaSemana.getSelectedItem();
	            	 
	            	 pessoa.removerObrigacao(dia);
	            	 
	            	 lista.reescreverCSV();
	            	 
	            	 selecionarDiaDaSemana.setSelectedIndex(selecionarDiaDaSemana.getSelectedIndex());
	        		
	        	}
	        	
	        		
	            }
	        });
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
