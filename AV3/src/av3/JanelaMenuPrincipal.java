package av3;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class JanelaMenuPrincipal extends JFrame implements ActionListener{
	
	public JanelaMenuPrincipal() {
		
		
		setResizable(false);
		setTitle("Gerenciador de Obrigações");
		ImageIcon icone = new ImageIcon("icone.png");
        setIconImage(icone.getImage());
		getContentPane().setBackground(new Color(225, 227, 230));
		getContentPane().setLayout(null);
		
		JLabel textoBemVindo = new JLabel("Bem-vindo!");
		textoBemVindo.setBounds(200, 94, 400, 100);
		textoBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		textoBemVindo.setForeground(new Color(23, 78, 166));
		textoBemVindo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 70));
		
		JButton botaoAcessarPessoas = new JButton("Acessar pessoas");
		botaoAcessarPessoas.setBounds(250, 305, 300, 50);
		botaoAcessarPessoas.setFont(new Font("SansSerif", Font.PLAIN, 20));
		botaoAcessarPessoas.setBackground(new Color(255, 255, 255));
		botaoAcessarPessoas.setForeground(new Color(23, 78, 166));
		botaoAcessarPessoas.setHorizontalAlignment(JButton.CENTER);
		
		
		
		botaoAcessarPessoas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	JanelaAcessarPessoas abaAcessarObrigacoes = null;
				
				try {
					abaAcessarObrigacoes = new JanelaAcessarPessoas();
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
				}
				
                abaAcessarObrigacoes.setVisible(true);
                
            }
        });
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setBounds(300, 476, 200, 50);
		botaoSair.setForeground(new Color(23, 78, 166));
		botaoSair.setFont(new Font("SansSerif", Font.PLAIN, 20));
		botaoSair.setBackground(new Color(255, 255, 255));
		botaoSair.setHorizontalAlignment(JButton.CENTER);
		
		
		botaoSair.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	            }
	        });
		
		JLabel textoFeitoPor = new JLabel("Feito por Enzo Sá");
		textoFeitoPor.setForeground(new Color(23, 78, 166));
		textoFeitoPor.setBackground(new Color(23, 78, 166));
		textoFeitoPor.setFont(new Font("SansSerif", Font.ITALIC, 15));
		textoFeitoPor.setBounds(10, 740, 156, 13);
		
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().add(textoBemVindo);
		getContentPane().add(botaoAcessarPessoas);
		getContentPane().add(botaoSair);
		getContentPane().add(textoFeitoPor);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
