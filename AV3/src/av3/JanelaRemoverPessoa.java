package av3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JanelaRemoverPessoa extends JFrame implements ActionListener{

	
	public JanelaRemoverPessoa(ListaPessoas lista, JComboBox<Pessoa> escolherPessoas) {
		
		setResizable(false);
		ImageIcon icone = new ImageIcon("icone.png");
        setIconImage(icone.getImage());
		setTitle("Remover Pessoa");
		setVisible(true);
		setSize(300, 275);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setForeground(new Color(23, 78, 166));
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelNome.setBounds(50, 20, 200, 20);
		getContentPane().add(labelNome);
		
		JTextField inserirNome = new JTextField("Digite aqui");
		inserirNome.setForeground(Color.GRAY);
		inserirNome.setFont(new Font("SansSerif", Font.PLAIN, 15));
		inserirNome.setHorizontalAlignment(SwingConstants.CENTER);
		inserirNome.setBounds(50, 45, 200, 30);
		
		inserirNome.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (inserirNome.getText().equals("Digite aqui")) {
	                inserirNome.setText("");
	                inserirNome.setForeground(Color.BLACK);
	            }
	        }
	        @Override
	        public void focusLost(FocusEvent e) {
	            if (inserirNome.getText().isEmpty()) {
	                inserirNome.setText("Digite aqui");
	                inserirNome.setForeground(Color.GRAY);
	            }
	        }
	    });
		
		getContentPane().add(inserirNome);	
		
		JLabel labelIdade = new JLabel("Idade:");
		labelIdade.setForeground(new Color(23, 78, 166));
		labelIdade.setFont(new Font("SansSerif", Font.PLAIN, 15));
		labelIdade.setBounds(50, 85, 200, 20);
		getContentPane().add(labelIdade);
		
		JTextField inserirIdade = new JTextField("Digite aqui");
		inserirIdade.setForeground(Color.GRAY);
		inserirIdade.setFont(new Font("SansSerif", Font.PLAIN, 15));
		inserirIdade.setHorizontalAlignment(SwingConstants.CENTER);
		inserirIdade.setBounds(50, 110, 200, 30);
		
		inserirIdade.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (inserirIdade.getText().equals("Digite aqui")) {
	                inserirIdade.setText("");
	                inserirIdade.setForeground(Color.BLACK);
	            }
	        }
	        @Override
	        public void focusLost(FocusEvent e) {
	            if (inserirIdade.getText().isEmpty()) {
	                inserirIdade.setText("Digite aqui");
	                inserirIdade.setForeground(Color.GRAY);
	            }
	        }
	    });
		
		getContentPane().add(inserirIdade);
		
		JButton botaoRemover = new JButton("Remover");
		botaoRemover.setForeground(new Color(23, 78, 166));
		botaoRemover.setFont(new Font("SansSerif", Font.PLAIN, 15));
		botaoRemover.setBounds(90, 170, 120, 40);
		getRootPane().setDefaultButton(botaoRemover);
		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String nome = inserirNome.getText().trim();
		        String idadeTexto = inserirIdade.getText().trim();
		        
		        if (nome.matches(".*[!@#$%¨&*()_+=\\[\\]{};:'\",.<>?/\\\\|`~^-].*")) {
		            JOptionPane.showMessageDialog(null, "O nome não pode conter caracteres especiais!");
		            return;
		        }
		        
		        if (nome.equals("Digite aqui") || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nome inválido!");
					return;
		        }
		        
		        for (int i = 0; i < nome.length(); i++) {
		            if (Character.isDigit(nome.charAt(i))) {
		                JOptionPane.showMessageDialog(null, "O nome não pode conter números!");
		                return;
		            }
		        }
  
		        if (idadeTexto.isEmpty() || idadeTexto.equals("Digite aqui")) {
		            JOptionPane.showMessageDialog(null, "Idade inválida!");
		            return;
		        }
		        
		        for (int i = 0; i < idadeTexto.length(); i++) {
		            if (!Character.isDigit(idadeTexto.charAt(i))) {
		                JOptionPane.showMessageDialog(null, "A idade deve conter apenas números!");
		                return;
		            }
		        }
				
				int idade;
				
				try {
		            idade = Integer.parseInt(idadeTexto);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Idade deve ser um número!");
		            return;
		        }
				
				Pessoa pessoaParaRemover = null;
		
				for (Pessoa pessoaNaLista : lista.getListaPessoas()) {
				    if (pessoaNaLista.getNome().equalsIgnoreCase(nome) && pessoaNaLista.getIdade() == idade) {
				        pessoaParaRemover = pessoaNaLista;
				        break;
				    }
				}

				if (pessoaParaRemover != null) {
				    for (int i = 0; i < escolherPessoas.getItemCount(); i++) {
				        Pessoa pessoa = escolherPessoas.getItemAt(i);
				        if (pessoa.getNome().equalsIgnoreCase(nome) && pessoa.getIdade() == idade) {
				            escolherPessoas.removeItemAt(i);
				            break;
				        }
				    }
					
					lista.removerPessoa(pessoaParaRemover);
					lista.reescreverCSV();
					JOptionPane.showMessageDialog(null, "Pessoa removida!");
					dispose();
					
				} else {
		            
					JOptionPane.showMessageDialog(null, "Essa pessoa não está registrada!");
		        }
				
				
				
			}
				
		});

		getContentPane().add(botaoRemover);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
