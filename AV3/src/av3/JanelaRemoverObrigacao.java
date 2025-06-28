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

public class JanelaRemoverObrigacao extends JFrame implements ActionListener{

	private ListaPessoas lista;
	
	public JanelaRemoverObrigacao(Pessoa pessoa, JComboBox<String> selecionarDiaDaSemana){
		
		try {
			
			lista = new ListaPessoas("tabela.csv");
			lista.lerDoCSV();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar lista");
			
		}
		
		setTitle("Remover obrigação");
		ImageIcon icone = new ImageIcon("icone.png");
        setIconImage(icone.getImage());
		setResizable(false);
		setSize(300, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
		
		JTextField inserirObrigacaoaSerRemovida = new JTextField();
		inserirObrigacaoaSerRemovida.setFont(new Font("SansSerif", Font.PLAIN, 20));
		inserirObrigacaoaSerRemovida.setHorizontalAlignment(SwingConstants.CENTER);
		inserirObrigacaoaSerRemovida.setText("Digite aqui");
		inserirObrigacaoaSerRemovida.setBounds(50, 30, 200, 50);
		
		inserirObrigacaoaSerRemovida.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (inserirObrigacaoaSerRemovida.getText().equals("Digite aqui")) {
	            	inserirObrigacaoaSerRemovida.setText("");
	            	inserirObrigacaoaSerRemovida.setForeground(Color.BLACK);
	            }
	        }
	        @Override
	        public void focusLost(FocusEvent e) {
	            if (inserirObrigacaoaSerRemovida.getText().isEmpty()) {
	            	inserirObrigacaoaSerRemovida.setText("Digite aqui");
	            	inserirObrigacaoaSerRemovida.setForeground(Color.GRAY);
	            }
	        }
	    });
		
		getContentPane().add(inserirObrigacaoaSerRemovida);
		
		JButton botaoRemoverObrigacao = new JButton("Remover");
		botaoRemoverObrigacao.setFont(new Font("SansSerif", Font.PLAIN, 13));
		botaoRemoverObrigacao.setBounds(90, 111, 120, 30);
		getRootPane().setDefaultButton(botaoRemoverObrigacao);
		getContentPane().add(botaoRemoverObrigacao);

		botaoRemoverObrigacao.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {

	           pessoa.removerObrigacao(inserirObrigacaoaSerRemovida.getText(), selecionarDiaDaSemana.getSelectedItem().toString());
	           
	           lista.atualizarPessoa(pessoa);
	           lista.reescreverCSV();
	           selecionarDiaDaSemana.setSelectedIndex(selecionarDiaDaSemana.getSelectedIndex());
	           dispose();
	            
	            }
	        });
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
