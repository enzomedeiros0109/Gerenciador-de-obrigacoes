package av3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Sistema {
    public Sistema() throws IOException {
    	
    	JanelaMenuPrincipal menu = new JanelaMenuPrincipal();
        ListaPessoas lista = new ListaPessoas("tabela.csv");
        lista.lerDoCSV();
    }
}
	
