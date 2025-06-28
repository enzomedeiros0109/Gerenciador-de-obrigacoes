package av3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JanelaAcessarPessoas extends JFrame implements ActionListener{

	private ListaPessoas lista;
	
	public JanelaAcessarPessoas() throws IOException {
		
		lista = new ListaPessoas("tabela.csv");
		lista.lerDoCSV();
		
		ImageIcon icone = new ImageIcon("icone.png");
        setIconImage(icone.getImage());
		setSize(700, 700);
		setLocationRelativeTo(null);
		setTitle("Acessar pessoa");
		
		getContentPane().setBackground(new Color(225, 227, 230));
		getContentPane().setLayout(null);
		
		JComboBox<Pessoa> escolherPessoas = new JComboBox<>();
		escolherPessoas.setForeground(new Color(23, 78, 166));
		escolherPessoas.setBackground(new Color(255, 255, 255));
		escolherPessoas.setFont(new Font("SansSerif", Font.PLAIN, 10));
		escolherPessoas.setBounds(50, 300, 200, 30);

		for (Pessoa p : lista.getListaPessoas()) {
		    escolherPessoas.addItem(p);
		}
		getContentPane().add(escolherPessoas);
		
		
		JButton acessarPessoa = new JButton("Acessar");
		acessarPessoa.setBackground(new Color(240, 240, 240));
		acessarPessoa.setFont(new Font("SansSerif", Font.PLAIN, 15));
		acessarPessoa.setForeground(new Color(23, 78, 166));
		acessarPessoa.setBounds(100, 350, 100, 30);
		
		
		acessarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 Pessoa pessoaSelecionada = (Pessoa) escolherPessoas.getSelectedItem();
				 
				 if(pessoaSelecionada == null) {
					 
					 JOptionPane.showMessageDialog(null, "Nenhuma pessoa foi selecionada!");
					 
				 } else {
					 
					 try {
							JanelaObrigacoesDaPessoa janelaObrigacoesDaPessoa = new JanelaObrigacoesDaPessoa(pessoaSelecionada, lista);
						} catch (IOException e1) {
							
							JOptionPane.showMessageDialog(null, "Não há pessoas registradas!");
							
						} 
					 
				 }

			}
		});
		
		getContentPane().add(acessarPessoa);
		
		
		
		
		JButton botaoAdicionarPessoa = new JButton("Adicionar Pessoa");
		botaoAdicionarPessoa.setForeground(new Color(23, 78, 166));
		botaoAdicionarPessoa.setFont(new Font("SansSerif", Font.PLAIN, 17));
		botaoAdicionarPessoa.setBackground(new Color(255, 255, 255));
		botaoAdicionarPessoa.setBounds(400, 240, 200, 60);
		getContentPane().add(botaoAdicionarPessoa);
		
		botaoAdicionarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JanelaAdicionarPessoa janelaAdicionarPessoa = new JanelaAdicionarPessoa(lista, escolherPessoas);
				
			}
		});
		
		JButton botaoRemoverPessoa = new JButton("Remover pessoa");
		botaoRemoverPessoa.setForeground(new Color(23, 78, 166));
		botaoRemoverPessoa.setFont(new Font("SansSerif", Font.PLAIN, 17));
		botaoRemoverPessoa.setBackground(new Color(255, 255, 255));
		botaoRemoverPessoa.setBounds(400, 360, 200, 60);
		botaoRemoverPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lista.getListaPessoas().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Não há pessoas registradas!");
					
				} else {
					
					JanelaRemoverPessoa janelaRemoverPessoa = new JanelaRemoverPessoa(lista, escolherPessoas);
					
				}
				
				
				
			
			}
		});
		
		getContentPane().add(botaoRemoverPessoa);
		
		JButton botaoVoltarMenuPrincipal = new JButton("Voltar");
		botaoVoltarMenuPrincipal.setForeground(new Color(23, 78, 166));
		botaoVoltarMenuPrincipal.setFont(new Font("SansSerif", Font.PLAIN, 17));
		botaoVoltarMenuPrincipal.setBackground(new Color(255, 255, 255));
		botaoVoltarMenuPrincipal.setBounds(10, 10, 130, 40);
		
		botaoVoltarMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	dispose();
                
                
            }
        });
		
		getContentPane().add(botaoVoltarMenuPrincipal);
		
		JLabel textoEscolhaAPessoa = new JLabel("Escolha a pessoa aqui");
		textoEscolhaAPessoa.setForeground(new Color(23, 78, 166));
		textoEscolhaAPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		textoEscolhaAPessoa.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textoEscolhaAPessoa.setBounds(50, 271, 200, 20);
		getContentPane().add(textoEscolhaAPessoa);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
