

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import jstackui.exceptions.UndefinedPanelException;
import jstackui.view.JNovaPanel;
import jstackui.view.JNovaUI;

public class main {

	public static void main(String[] args) throws UndefinedPanelException {
		
		JNovaPanel panel = new JNovaPanel("Panel 1");
		panel.setLayout(null);
		panel.addCSS("background-color", "rgb(34,34,34)");
		
		final JNovaUI js = new JNovaUI(panel);
		
		final JNovaPanel panel2 = new JNovaPanel("Panel 2");
		panel2.setLayout(null);
		panel2.addCSS("background-color", "red");
		
		JButton jbutton = new JButton("Teste");
		jbutton.setBounds(50, 50, 50, 20);
		jbutton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        js.next(panel2);
		    }
		}); 
		panel.add(jbutton);
		
		js.showList();

	}

}
