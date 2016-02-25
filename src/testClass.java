

import java.awt.Cursor;

import com.sun.xml.internal.ws.util.StringUtils;

import exceptions.CSSNotValidException;
import exceptions.UndefinedPanelException;
import view.JNovaPanel;
import view.JNovaUI;

public class testClass {

	public static void main(String[] args) throws UndefinedPanelException {
		
		JNovaPanel panel = new JNovaPanel("Panel 1");
		panel.setLayout(null);
		try {
			panel.addCSS("background-color", "rgb(22,22,22)");
			panel.addCSS("border-color", "red green blue");
		} catch (CSSNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final JNovaUI js = new JNovaUI(panel);
		
		
		
//		final JNovaPanel panel2 = new JNovaPanel("Panel 2");
//		panel2.setLayout(null);
//		panel2.addCSS("background-color", "red");
//		
//		JButton jbutton = new JButton("Teste");
//		jbutton.setBounds(50, 50, 50, 20);
//		jbutton.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        js.next(panel2);
//		    }
//		}); 
//		panel.add(jbutton);
		
		js.showList();

	}

}
