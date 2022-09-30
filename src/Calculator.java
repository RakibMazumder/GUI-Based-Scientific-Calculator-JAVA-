import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Calculator extends JFrame {

	// Fields
	Listener clickListener = new Listener();
	JPanel mypanel;

	JButton mybutton0;
	JButton mybutton1;
	JButton mybutton2;
	JButton mybutton3;
	JButton mybutton4;

	JButton mybutton5;
	JButton mybutton6;
	JButton mybutton7;
	JButton mybutton8;
	JButton mybutton9;

	JButton mybuttonPlus;
	JButton mybuttonMinus;
	JButton mybuttonMultiply;
	JButton mybuttonDivision;
	JButton mybuttonDecimal;

	JButton mybuttonSin;
	JButton mybuttonCos;
	JButton mybuttonTan;
	JButton mybuttonComma;
	JButton mybuttonPercentage;

	JButton mybuttonLog;
	JButton mybuttonSquareroot;
	JButton mybuttonXSqure;
	JButton mybuttonXtoThePowerY;
	JButton mybuttonCuberoot;

	JButton mybuttonFactorial;
	JButton mybuttonPi;
	JButton mybuttonEqual;
	JButton mybuttonClear;
	JButton mybuttonLeftBracket;
	JButton mybuttonRightBracket;
	JButton mybuttonM1;
	JButton mybuttonSave1;
	JButton mybuttonDelete;
	JButton mybuttonSave2;
	JButton mybuttonM2;

	JTextField mytext1;
	JTextField mytext2;
	// int count=0;
	String Line;
	double num = 0.0, result = 0.0, a;
	String RecallMemory, PutMemory;

	boolean firstEntry = true, firstOperation = true, plus = false, minus = false, multiply = false, division = false,
			firstperiod = false;
	String lastOperation = "";

	// Constructor
	public Calculator() {
		mypanel = new JPanel();
		mypanel.setLayout(null);
		// -------------------------------------

		mybutton0 = new JButton("0");
		mybutton0.setBounds(15, 400, 90, 45);

		mybutton1 = new JButton("1");
		mybutton1.setBounds(110, 400, 45, 45);

		mybutton2 = new JButton("2");
		mybutton2.setBounds(160, 400, 45, 45);

		mybutton3 = new JButton("3");
		mybutton3.setBounds(210, 400, 45, 45);

		mybutton4 = new JButton("4");
		mybutton4.setBounds(260, 400, 50, 45);

		// ----------------------------------------

		mybutton5 = new JButton("5");
		mybutton5.setBounds(15, 350, 45, 45);

		mybutton6 = new JButton("6");
		mybutton6.setBounds(65, 350, 45, 45);

		mybutton7 = new JButton("7");
		mybutton7.setBounds(115, 350, 45, 45);

		mybutton8 = new JButton("8");
		mybutton8.setBounds(165, 350, 45, 45);

		mybutton9 = new JButton("9");
		mybutton9.setBounds(215, 350, 45, 45);

		mybuttonPercentage = new JButton("%");
		mybuttonPercentage.setBounds(265, 350, 45, 45);

		// -----------------------------------------

		mybuttonPlus = new JButton("+");
		mybuttonPlus.setBounds(15, 300, 45, 45);

		mybuttonMinus = new JButton("-");
		mybuttonMinus.setBounds(65, 300, 45, 45);

		mybuttonMultiply = new JButton("×");
		mybuttonMultiply.setBounds(115, 300, 45, 45);

		mybuttonDivision = new JButton("÷");
		mybuttonDivision.setBounds(165, 300, 45, 45);

		mybuttonDecimal = new JButton(".");
		mybuttonDecimal.setBounds(215, 300, 45, 45);

		mybuttonCuberoot = new JButton("∛");
		mybuttonCuberoot.setBounds(265, 300, 45, 45);

		// ------------------------------------------

		mybuttonSin = new JButton("sin");
		mybuttonSin.setBounds(15, 250, 70, 45);

		mybuttonCos = new JButton("cos");
		mybuttonCos.setBounds(90, 250, 70, 45);

		mybuttonTan = new JButton("tan");
		mybuttonTan.setBounds(165, 250, 70, 45);

		mybuttonComma = new JButton(",");
		mybuttonComma.setBounds(240, 250, 70, 45);

		// ----------------------------------------------

		mybuttonLog = new JButton("log");
		mybuttonLog.setBounds(15, 200, 70, 45);

		mybuttonSquareroot = new JButton("√");
		mybuttonSquareroot.setBounds(90, 200, 70, 45);

		mybuttonXSqure = new JButton("x²");
		mybuttonXSqure.setBounds(165, 200, 70, 45);

		mybuttonXtoThePowerY = new JButton("x^y");
		mybuttonXtoThePowerY.setBounds(240, 200, 70, 45);

		// -------------------------------------------------

		mybuttonFactorial = new JButton("n!");
		mybuttonFactorial.setBounds(15, 150, 45, 45);

		mybuttonPi = new JButton("π");
		mybuttonPi.setBounds(65, 150, 45, 45);

		mybuttonLeftBracket = new JButton("(");
		mybuttonLeftBracket.setBounds(115, 150, 45, 45);

		mybuttonRightBracket = new JButton(")");
		mybuttonRightBracket.setBounds(165, 150, 45, 45);

		mybuttonEqual = new JButton("=");
		mybuttonEqual.setBounds(215, 150, 45, 45);

		mybuttonClear = new JButton("c");
		mybuttonClear.setBounds(265, 150, 45, 45);

		mybuttonM1 = new JButton("M1");
		mybuttonM1.setBounds(15, 100, 55, 45);

		mybuttonSave1 = new JButton("S1");
		mybuttonSave1.setBounds(75, 100, 55, 45);

		mybuttonDelete = new JButton("D");
		mybuttonDelete.setBounds(135, 100, 45, 45);
		
		mybuttonSave2 = new JButton("S2");
		mybuttonSave2.setBounds(185, 100, 55, 45);
		mybuttonM2 = new JButton("M2");
		mybuttonM2.setBounds(240, 100, 67, 45);

		// ----------------------------------------------

		mytext1 = new JTextField(20);
		mytext1.setText("0.0");
		mytext1.setBounds(15, 5, 295, 25);

		mytext2 = new JTextField(20);
		mytext2.setText("");
		mytext2.setBounds(15, 27, 295, 25);

		// -------------------------------------------------

		add(mypanel);
		mypanel.add(mybutton0);
		mypanel.add(mybutton1);
		mypanel.add(mybutton2);
		mypanel.add(mybutton3);
		mypanel.add(mybutton4);

		mypanel.add(mybutton5);
		mypanel.add(mybutton6);
		mypanel.add(mybutton7);
		mypanel.add(mybutton8);
		mypanel.add(mybutton9);

		mypanel.add(mybuttonPlus);
		mypanel.add(mybuttonMinus);
		mypanel.add(mybuttonMultiply);
		mypanel.add(mybuttonDivision);
		mypanel.add(mybuttonDecimal);

		mypanel.add(mybuttonSin);
		mypanel.add(mybuttonCos);
		mypanel.add(mybuttonTan);
		mypanel.add(mybuttonComma);
		mypanel.add(mybuttonPercentage);

		mypanel.add(mybuttonLog);
		mypanel.add(mybuttonSquareroot);
		mypanel.add(mybuttonXSqure);
		mypanel.add(mybuttonXtoThePowerY);
		mypanel.add(mybuttonCuberoot);

		mypanel.add(mybuttonFactorial);
		mypanel.add(mybuttonPi);
		mypanel.add(mybuttonEqual);
		mypanel.add(mybuttonClear);
		mypanel.add(mybuttonLeftBracket);
		mypanel.add(mybuttonRightBracket);
		mypanel.add(mybuttonM1);
		mypanel.add(mybuttonSave1);
		mypanel.add(mybuttonDelete);
		mypanel.add(mybuttonM2);
		mypanel.add(mybuttonSave2);
		mypanel.add(mytext1);
		mypanel.add(mytext2);

		mybutton1.addActionListener(clickListener);
		mybutton2.addActionListener(clickListener);
		mybutton3.addActionListener(clickListener);
		mybutton4.addActionListener(clickListener);
		mybutton5.addActionListener(clickListener);
		mybutton6.addActionListener(clickListener);
		mybutton7.addActionListener(clickListener);
		mybutton8.addActionListener(clickListener);
		mybutton9.addActionListener(clickListener);
		mybutton0.addActionListener(clickListener);

		mybuttonPlus.addActionListener(clickListener);
		mybuttonMinus.addActionListener(clickListener);
		mybuttonMultiply.addActionListener(clickListener);
		mybuttonDivision.addActionListener(clickListener);
		mybuttonDecimal.addActionListener(clickListener);

		mybuttonSin.addActionListener(clickListener);
		mybuttonCos.addActionListener(clickListener);
		mybuttonTan.addActionListener(clickListener);
		mybuttonComma.addActionListener(clickListener);
		mybuttonPercentage.addActionListener(clickListener);

		mybuttonLog.addActionListener(clickListener);
		mybuttonSquareroot.addActionListener(clickListener);
		mybuttonXSqure.addActionListener(clickListener);
		mybuttonXtoThePowerY.addActionListener(clickListener);
		mybuttonCuberoot.addActionListener(clickListener);

		mybuttonFactorial.addActionListener(clickListener);
		mybuttonPi.addActionListener(clickListener);
		mybuttonLeftBracket.addActionListener(clickListener);
		mybuttonRightBracket.addActionListener(clickListener);
		mybuttonEqual.addActionListener(clickListener);
		mybuttonClear.addActionListener(clickListener);
		mybuttonM1.addActionListener(clickListener);
		mybuttonSave1.addActionListener(clickListener);
		mybuttonDelete.addActionListener(clickListener);
		mybuttonM2.addActionListener(clickListener);
		mybuttonSave2.addActionListener(clickListener);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame Calculator = new Calculator();

		Calculator.setTitle("Calculator");
		Calculator.setSize(332, 520);
		Calculator.setLocation(20, 400);
		Calculator.setVisible(true);
		Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void writedata(String data) throws IOException {
		FileWriter handle = new FileWriter("Memory1.txt");
		BufferedWriter bw = new BufferedWriter(handle);

		bw.write(data);
		bw.newLine();
		bw.close();
		handle.close();
	}

	public static String recalldata() throws IOException {
		FileReader readHandle = new FileReader("Memory1.txt");
		BufferedReader BR = new BufferedReader(readHandle);

		String line = BR.readLine();
		
		BR.close();
		readHandle.close();
		return line;
	}
	public static void writedata2(String data) throws IOException {
		FileWriter handle = new FileWriter("Memory2.txt");
		BufferedWriter bw = new BufferedWriter(handle);

		bw.write(data);
		bw.newLine();
		bw.close();
		handle.close();
	}

	public static String recalldata2() throws IOException {
		FileReader readHandle = new FileReader("Memory2.txt");
		BufferedReader BR = new BufferedReader(readHandle);

		String line = BR.readLine();
		
		BR.close();
		readHandle.close();
		return line;
	}

	private class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			Line = mytext1.getText();

			if (e.getSource() == mybuttonDelete) {
				if (Line.length() > 0) {
					mytext1.setText(Line.substring(0, Line.length() - 1));
				}
			}

			if (e.getSource() == mybuttonClear) {
				mytext1.setText("");
				mytext2.setText("");

			}

			if (e.getSource() == mybuttonEqual) {
				if (!mytext1.getText().isEmpty()) {
					try {
						mytext2.setText(String.valueOf((long) Expression.eval(mytext1.getText())));
					} catch (Exception exception) {
						mytext2.setText(exception.getMessage());
					}
				}
			}
					 

			if (e.getSource() == mybutton1) {
				mytext1.setText(Line + "1");
			}

			if (e.getSource() == mybutton2) {
				mytext1.setText(Line + "2");
			}

			if (e.getSource() == mybutton3) {
				mytext1.setText(Line + "3");
			}

			if (e.getSource() == mybutton4) {
				mytext1.setText(Line + "4");
			}

			if (e.getSource() == mybutton5) {
				mytext1.setText(Line + "5");
			}

			if (e.getSource() == mybutton6) {
				mytext1.setText(Line + "6");
			}

			if (e.getSource() == mybutton7) {
				mytext1.setText(Line + "7");
			}
			if (e.getSource() == mybutton8) {
				mytext1.setText(Line + "8");
			}

			if (e.getSource() == mybutton9) {
				mytext1.setText(Line + "9");
			}

			if (e.getSource() == mybutton0) {
				mytext1.setText(Line + "0");
			}
			if (e.getSource() == mybuttonSin) {
				mytext1.setText(Line + "sin(");
			}
			if (e.getSource() == mybuttonPlus) {
				mytext1.setText(Line + "+");
			}
			if (e.getSource() == mybuttonMinus) {
				mytext1.setText(Line + "-");
			}
			if (e.getSource() == mybuttonMultiply) {
				mytext1.setText(Line + "*");
			}
			if (e.getSource() ==mybuttonDivision) {
				mytext1.setText(Line + "/");
			}
			
			if (e.getSource() ==mybuttonCos) {
				mytext1.setText(Line + "cos");
			}
			if (e.getSource() ==mybuttonTan) {
				mytext1.setText(Line + "tan");
			}
			if (e.getSource() ==mybuttonComma) {
				mytext1.setText(Line + ",");
			}
			if (e.getSource() ==mybuttonPercentage) {
				mytext1.setText(Line + "%");
			}
			
			if (e.getSource() ==mybuttonLog) {
				mytext1.setText(Line + "log");
			}
			if (e.getSource() ==mybuttonSquareroot) {
				mytext1.setText(Line + "sqrt");
			}
			if (e.getSource() ==mybuttonXSqure) {
				mytext1.setText(Line + "√");
			}
			if (e.getSource() ==mybuttonXSqure) {
				mytext1.setText(Line + "x²");
			}
			//
			if (e.getSource() ==mybuttonXtoThePowerY) {
				mytext1.setText(Line + "^");
			}
			if (e.getSource() ==mybuttonCuberoot) {
				mytext1.setText(Line + "∛");
			}
			if (e.getSource() ==mybuttonFactorial) {
				mytext1.setText(Line + "!");
			}
			if (e.getSource() ==mybuttonXSqure) {
				mytext1.setText(Line + "√");
			}
			if (e.getSource() ==mybuttonXSqure) {
				mytext1.setText(Line + "√");
			}
			
			if (e.getSource() ==mybuttonPi) {
				mytext1.setText(Line + "3.1416");
			}
			//
			
			if (e.getSource() ==mybuttonLeftBracket) {
				mytext1.setText(Line + "(");
			}
			if (e.getSource() ==mybuttonRightBracket) {
				mytext1.setText(Line + ")");
			}
			if (e.getSource() ==mybuttonXSqure) {
				mytext1.setText(Line + "√");
			}
			
			
			// --------------------------
			if (e.getSource() == mybuttonM1) {
				try {
					RecallMemory = recalldata();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mytext2.setText(RecallMemory);
			}

			if (e.getSource() == mybuttonSave1) {
				PutMemory = mytext2.getText();
				try {
					writedata(PutMemory);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (e.getSource() == mybuttonM2) {
				try {
					RecallMemory = recalldata2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mytext2.setText(RecallMemory);
			}

			if (e.getSource() == mybuttonSave2) {
				PutMemory = mytext2.getText();
				try {
					writedata2(PutMemory);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}
	}
}
