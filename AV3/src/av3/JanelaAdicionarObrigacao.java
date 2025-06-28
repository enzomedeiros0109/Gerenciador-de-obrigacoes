package av3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JanelaAdicionarObrigacao extends JFrame implements ActionListener{

	private ListaPessoas lista;
	
	public JanelaAdicionarObrigacao(Pessoa pessoa, JComboBox<String> selecionarDiaDaSemana){
		
		try {
			
			lista = new ListaPessoas("tabela.csv");
			lista.lerDoCSV();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar lista");
			
		}
		
		ImageIcon icone = new ImageIcon("icone.png");
        setIconImage(icone.getImage());
		setTitle("Adicionar obrigação");
		setResizable(false);
		setSize(300, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
		
		JTextField inserirObrigacao = new JTextField();
		inserirObrigacao.setFont(new Font("SansSerif", Font.PLAIN, 20));
		inserirObrigacao.setHorizontalAlignment(SwingConstants.CENTER);
		inserirObrigacao.setText("Digite aqui");
		inserirObrigacao.setBounds(50, 30, 200, 50);
		
		inserirObrigacao.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (inserirObrigacao.getText().equals("Digite aqui")) {
	            	inserirObrigacao.setText("");
	            	inserirObrigacao.setForeground(Color.BLACK);
	            }
	        }
	        @Override
	        public void focusLost(FocusEvent e) {
	            if (inserirObrigacao.getText().isEmpty()) {
	            	inserirObrigacao.setText("Digite aqui");
	            	inserirObrigacao.setForeground(Color.GRAY);
	            }
	        }
	    });
		
		getContentPane().add(inserirObrigacao);
		
		JButton botaoAdicionar = new JButton("Adicionar");
		botaoAdicionar.setFont(new Font("SansSerif", Font.PLAIN, 13));
		botaoAdicionar.setBounds(90, 111, 120, 30);
		getRootPane().setDefaultButton(botaoAdicionar);
		getContentPane().add(botaoAdicionar);

		botaoAdicionar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {

	       if(inserirObrigacao.getText().equals("") || inserirObrigacao.getText().isEmpty()) {
	    	   
	    	   JOptionPane.showMessageDialog(null, "Digite algo para adicionar!");
	    	   
	       } else {
	    	   
	    	   pessoa.adicionarObrigacao(inserirObrigacao.getText(), selecionarDiaDaSemana.getSelectedItem().toString());
	           
		       lista.atualizarPessoa(pessoa);
	           lista.reescreverCSV();
	           selecionarDiaDaSemana.setSelectedIndex(selecionarDiaDaSemana.getSelectedIndex());
	           dispose();
	       }
	        	
	       
	            
	            }
	        });
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
