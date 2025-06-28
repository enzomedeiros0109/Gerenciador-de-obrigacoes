package av3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class JanelaDefinirMesada extends JFrame implements ActionListener{

	private ListaPessoas lista;
	
	public JanelaDefinirMesada(Pessoa pessoa, JLabel textoMesadaPessoa) {
		
		try {
			
			lista = new ListaPessoas("tabela.csv");
			lista.lerDoCSV();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar lista");
			
		}
		
		ImageIcon icone = new ImageIcon("icone.png");
        setIconImage(icone.getImage());
		setTitle("Definir mesada");
		setResizable(false);
		setSize(200, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
		
		JTextField inserirMesada = new JTextField();
		inserirMesada.setFont(new Font("SansSerif", Font.PLAIN, 20));
		inserirMesada.setHorizontalAlignment(SwingConstants.CENTER);
		inserirMesada.setText("Digite aqui");
		inserirMesada.setBounds(20, 40, 150, 50);
		
		inserirMesada.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (inserirMesada.getText().equals("Digite aqui")) {
	            	inserirMesada.setText("");
	            	inserirMesada.setForeground(Color.BLACK);
	            }
	        }
	        @Override
	        public void focusLost(FocusEvent e) {
	            if (inserirMesada.getText().isEmpty()) {
	            	inserirMesada.setText("Digite aqui");
	            	inserirMesada.setForeground(Color.GRAY);
	            }
	        }
	    });
		
		getContentPane().add(inserirMesada);
		
		JButton botaoDefinir = new JButton("Definir");
		botaoDefinir.setFont(new Font("SansSerif", Font.PLAIN, 13));
		botaoDefinir.setBounds(45, 110, 100, 30);
		getRootPane().setDefaultButton(botaoDefinir);
		getContentPane().add(botaoDefinir);

		botaoDefinir.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {

	            try {
	            	
	            	double mesada = Double.parseDouble(inserirMesada.getText());
	            	
	            	if(mesada > 1000) {
	            		
	            		JOptionPane.showMessageDialog(null, "Mesada inválida!");
	            		
	            	} else if(mesada < 0) {
	            		
	            		JOptionPane.showMessageDialog(null, "Apenas números positivos para a mesada!");
	            		
	            		
	            	} else {
	            		
	            		((Mesada) pessoa).setMesada(mesada);
		            	
	            		
		            	lista.atualizarPessoa(pessoa);
		            	lista.reescreverCSV();
		            	textoMesadaPessoa.setText("Mesada: R$ " + String.format("%.2f", ((Mesada) pessoa).getMesada()));
		            	
		            	JOptionPane.showMessageDialog(null, "Mesada definida");
		            	dispose();
		            	
	            	}
	
	            } catch(NumberFormatException e1) {
	            	
	            	JOptionPane.showMessageDialog(null, "Apenas números para a mesada!");
	            	
	            }
	            
	            }
	        });
	
	
	}
		
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
