import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	
	JFrame calcFrame;
	JTextField calcTextField;
	JButton[] calcNumbs = new JButton[10];
	JButton [] functionButton = new JButton[9];
	JButton add,subtract,multiply,divide;
	JButton negative,decimal,equals,delete,clear;
	JPanel calcPanel;
	
	
	Font myFont = new Font("Calculator",Font.BOLD,30);
	
	double int1=0, int2=0, result=0;
	char operatorButton;
	
		//sample
	Calculator(){
		calcFrame = new JFrame("Basic Calculator");
		calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcFrame.getContentPane().setBackground(Color.BLACK);
		calcFrame.setSize(400,550);
		calcFrame.setLayout(null);
		calcFrame.setResizable(false);
		
		
		calcTextField = new JTextField();
		calcTextField.setBounds(50,25,300,50);
		calcTextField.setFont(myFont);
		calcTextField.setEditable(false);
		calcFrame.add(calcTextField);
		
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		decimal = new JButton(".");
		equals = new JButton("=");
		delete = new JButton("del");
		clear = new JButton("clr");
		negative= new JButton("(-)");
		
		
		functionButton[0]= add;
		functionButton[1]= subtract;
		functionButton[2]= multiply;
		functionButton[3]= divide;
		functionButton[4]= decimal;
		functionButton[5]= equals;
		functionButton[6]= delete;
		functionButton[7]= clear;
		functionButton[8]= negative;
		
		for(int i=0;	i<9;	i++) {
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(myFont);
			functionButton[i].setFocusable(false);
		}
		
		for(int i=0;	i<10;	i++) {
			calcNumbs[i]= new JButton(String.valueOf(i));
			calcNumbs[i].addActionListener(this);
			calcNumbs[i].setFont(myFont);
			calcNumbs[i].setFocusable(false);
		}
		
		negative.setBounds(50,430,100,50);
		delete.setBounds(150,430,100,50);
		clear.setBounds(250,430,100,50);
	
		calcPanel = new JPanel();
		calcPanel.setBounds(50,100,300,300);
		calcPanel.setLayout(new GridLayout(4,4,10,10));
		calcPanel.setBackground(Color.black);
	
		calcPanel.add(calcNumbs[1]);
		calcPanel.add(calcNumbs[2]);
		calcPanel.add(calcNumbs[3]);
		calcPanel.add(add);
		calcPanel.add(calcNumbs[4]);
		calcPanel.add(calcNumbs[5]);
		calcPanel.add(calcNumbs[6]);
		calcPanel.add(subtract);
		calcPanel.add(calcNumbs[7]);
		calcPanel.add(calcNumbs[8]);
		calcPanel.add(calcNumbs[9]);
		calcPanel.add(multiply);
		calcPanel.add(calcNumbs[0]);
		calcPanel.add(decimal);
		calcPanel.add(divide);
		calcPanel.add(equals);
		
		
		calcFrame.add(negative);
		calcFrame.setVisible(true);
		calcFrame.add(delete);
		calcFrame.add(clear);
		calcFrame.add(calcPanel);
	}

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<10; i++) {
			if (e.getSource() == calcNumbs[i]) {
				calcTextField.setText(calcTextField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decimal) {
			calcTextField.setText(calcTextField.getText().concat("."));
		}
		
		if(e.getSource()==add) {
			int1= Double.parseDouble(calcTextField.getText());
			operatorButton ='+';
			calcTextField.setText("");
		}
		if(e.getSource()==subtract) {
			int1= Double.parseDouble(calcTextField.getText());
			operatorButton ='-';
			calcTextField.setText("");
		}
		if(e.getSource()==multiply) {
			int1= Double.parseDouble(calcTextField.getText());
			operatorButton ='*';
			calcTextField.setText("");
		}
		if(e.getSource()==divide) {
			int1= Double.parseDouble(calcTextField.getText());
			operatorButton ='/';
			calcTextField.setText("");
		}
		if(e.getSource()== equals) {
			int2 = Double.parseDouble(calcTextField.getText());
			
			switch (operatorButton){
			case '+':
				result = int1 + int2;
				break;
			case '-':
				result = int1 - int2;
				break;
			
			case '*':
				result = int1 * int2;
				break;
			
			case '/':
				result = int1/int2;
				break;
			}
			
			calcTextField.setText(String.valueOf(result));
			int1=result;
		}
		
		if(e.getSource()==clear) {
			calcTextField.setText("");
		}
		if(e.getSource()==delete) {
			String string = calcTextField.getText();
			calcTextField.setText("");
			for(int i=0; i<string.length()-1; i++) {
				calcTextField.setText(calcTextField.getText()+string.charAt(i));
			}
			
		}
		if(e.getSource()==negative) {
			double temp = Double.parseDouble(calcTextField.getText());
			temp *=-1;
			calcTextField.setText(String.valueOf(temp));
		}
		
	}

}
