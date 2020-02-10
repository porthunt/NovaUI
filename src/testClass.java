

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import exceptions.CSSNotValidException;
import exceptions.UndefinedPanelException;
import view.JNovaPanel;
import view.JNovaUI;

public class testClass {

	public static void main(String[] args) throws UndefinedPanelException {
		
		final JNovaUI js = new JNovaUI();
		final JNovaPanel panelBlue = (JNovaPanel)js.getCurrentPanel();
		final JNovaPanel panelRed = new JNovaPanel("Red");
		final JNovaPanel panelGreen = new JNovaPanel("Green");
		panelBlue.setLayout(null);
		panelRed.setLayout(null);
		panelGreen.setLayout(null);
		try {
			panelBlue.addCSS("background-color", "rgb(0,0,255)");
			panelRed.addCSS("background-color", "rgb(255,0,0)");
			panelGreen.addCSS("background-color", "rgb(0,255,0)");
		} catch (CSSNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton jButtonBlueNext = new JButton("To Red");
		jButtonBlueNext.setBounds(690, 50, 150, 20);
		jButtonBlueNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        js.next(panelRed);
		        js.showList();
		    }
		}); 
		panelBlue.add(jButtonBlueNext);
		
		JButton jButtonRedBack = new JButton("To Blue");
		jButtonRedBack.setBounds(50, 50, 150, 20);
		jButtonRedBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        js.back();
		        js.showList();
		    }
		}); 
		panelRed.add(jButtonRedBack);
		
		JButton jButtonRedNext = new JButton("To Green");
		jButtonRedNext.setBounds(690, 50, 150, 20);
		jButtonRedNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        js.next(panelGreen);
		        js.showList();
		    }
		}); 
		panelRed.add(jButtonRedNext);
		
		JButton jButtonGreenBack = new JButton("To Red");
		jButtonGreenBack.setBounds(50, 50, 150, 20);
		jButtonGreenBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        js.back();
		        js.showList();
		    }
		}); 
		panelGreen.add(jButtonGreenBack);
		
		JButton jButtonGreenBegin = new JButton("To Beginning");
		jButtonGreenBegin.setBounds(50, 350, 150, 20);
		jButtonGreenBegin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        js.restart();
		        js.showList();
		    }
		}); 
		panelGreen.add(jButtonGreenBegin);
		
		js.setVisible(true);
		js.showList();

	}

}
