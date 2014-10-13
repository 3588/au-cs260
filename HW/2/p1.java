package hw2;
import javax.swing.JOptionPane;
public class p1 {
	public static void main(String[] args) {
	String string = JOptionPane.showInputDialog("Enter A String");
	String character = JOptionPane.showInputDialog("Enter A Character");
	char characterToChar = character.charAt(0);
	int nuString = string.length(), nuChar=0;
	for(int i=0;i<nuString;i++)
		if(string.charAt(i)==characterToChar)
			nuChar++;
	JOptionPane.showMessageDialog(null, character+" show "+nuChar+" times in "+string);
			
	}
}
