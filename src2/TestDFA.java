import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class TestDFA {
    public static void main(String args[]){
    try {
            Automat M = new Automat("C:\\lfc\\Automat.txt"); 
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Q={");
            ArrayList<String> q = M.getQ();
            boolean firstQ = true;
            for (String qItem : q) {
                if (!qItem.equals("a") && !qItem.equals("b")) {
                    if (!firstQ) {
                        System.out.print(",");
                    }
                    System.out.print(qItem);
                    firstQ = false;
                }
            }
            System.out.println("}");
            
            System.out.print("D={");
            ArrayList<Character> d = M.getD();
            boolean firstD = true;
            for (char dItem : d) {
                if (!firstD) {
                    System.out.print(",");
                }
                System.out.print(dItem);
                firstD = false;
            }
            System.out.println("}");
            
            System.out.print("F={");
            ArrayList<String> f = M.getF();
            boolean firstF = true;
            for (String fItem : f) {
                if (!firstF) {
                    System.out.print(",");
                }
                System.out.print(fItem);
                firstF = false;
            }
            System.out.println("}");

            
            String cuvant = JOptionPane.showInputDialog(null, "Introduceti cuvantul: ");
            if(M.analizeazaCuvant(cuvant)){

                JOptionPane.showMessageDialog(null, "Cuvantul " + cuvant + " apartine limbajului.");
            } else {
                JOptionPane.showMessageDialog(null, "Cuvantul " + cuvant + " nu apartine limbajului.");
            }
          
            M.afiseazaSirAsociat();
            M.afiseazaStariNetrecute();
            Set<Character> alfabet = M.getAlfabet();
            System.out.println("Alfabet: "+alfabet);
            
            
            if (M.isDeterminist()) {
                JOptionPane.showMessageDialog(null, "Automatul este determinist.");
            } else if (M.isNedeterminist()) {
                JOptionPane.showMessageDialog(null, "Automatul este nedeterminist.");
            } else {
                JOptionPane.showMessageDialog(null, "Automatul este nedefinit (nu este nici determinist, nici nedeterminist).");
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Eroare. Fisierul nu a putut fi gasit.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Eroare la initializarea automatului.");
        }
    
    }
    
}

