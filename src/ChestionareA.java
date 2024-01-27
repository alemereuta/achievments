
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChestionareA extends JFrame {
    private JLabel labelIntrebareCurenta;
    private JLabel labelIntrebare;
    
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    
    private JButton buttonUrmatoarea;
    private JButton buttonSaltIntrebare;
    private JButton buttonDeselectare;
    
    private JLabel labelTimer;
    
    private int intrebareCurenta;
    private int scor;
    
    private String[] intrebari = {
            "Sunteţi obligat să vă supuneţi recoltării probelor biologice, în cazul unui accident de circulaţie din care a rezultat moartea sau vătămarea integrităţii corporale ori a sănătăţii unor persoane??",
            "Semnalul luminos intermitent de culoare albă, având cadenţa lentă, funcţionează:",
            "Conduceţi motocicleta pe drumurile publice şi refuzaţi recoltarea unor probe biologice în vederea stabilirii alcoolemiei. Veţi fi pedepsit penal?",
            "Victima care a pierdut mult sânge trebuie să fie aşezată:",
            "La circulaţia pe autostrăzi, conducătorului de motociclete îi este interzis:",
            "Căror vehicule le este interzisă circulaţia pe autostrăzi?",
            "Semnalele date dintr-un autovehicul al poliţiei, care însoţeşte o coloană oficială de vehicule, prin folosirea mijloacelor speciale de avertizare sonoră şi luminoasă, obligă la:",
            "Cum trebuie aşezată într-un mijloc de transport o persoană rănită, care prezintă leziuni ale coloanei vertebrale?",
            "Imobilizarea unui braţ fracturat se face:",
            "Ce obligaţii ai dacă ai obţinut permis de conducere pentru motociclete de mai puţin de un an?",
            "Pe autostradă se interzice:",
            "Cum procedaţi atunci când, deplasându-vă cu motocicleta pe un drum public, întâlniţi un poliţist rutier orientat cu spatele către dumneavoastră şi cu braţele întinse orizontal?",
            "Cum trebuie să procedaţi când ajungeţi în spatele unui tramvai oprit într-o staţie fără refugiu pentru pietoni?",
            "Conducătorilor de motociclete le este interzis:",
            "Cum trebuie scoase dintr-un autovehicul persoanele rănite?",
            "Ce obligaţii are un motociclist care urmează să fie depăşit?",
    /*17*/    "Bastonul alb, ridicat de un pieton care traversează strada printr-un loc nesemnalizat şi nemarcat, vă obligă:",
    /*18*/    "Cum veţi proceda corect dacă, aflându-vă în interiorul unei intersecţii cu circulaţie în sens giratoriu, observaţi că pe un drum lateral circulă o coloană cu regim de circulaţie prioritară?",
            "Care este limita maximă de viteză cu care aveţi voie să conduceţi un autovehicul aparţinând categoriei A, pe autostrăzi?",
            "Semnalele date dintr-un autovehicul al poliţiei, ce însoţeşte o coloană oficială, prin folosirea avertizoarelor sonore şi luminoase, obligă la:",
           "Ce măsuri ia conducătorul unei motociclete, angajat într-un accident cu avarii uşoare?",                       
            "Faptul că un vehicul de pe o bandă circulă mai repede decât un vehicul de pe altă bandă, în aceeaşi direcţie de mers, se consideră depăşire?",
            "Depăşirea se defineşte astfel:",
            "Puteţi schimba direcţia de mers la dreapta la semnalul roşu al semaforului?",
            "Vă apropiaţi de un drum forestier, ce intră în şosea din partea dreaptă şi de pe care iese un alt autovehicul. Cine trebuie să aştepte?",
            "Un biciclist circulă printre vehiculele staţionate pe partea dreaptă a carosabilului. Ce trebuie să aveţi în vedere atunci când vă apropiaţi cu motocicleta de acesta?",

            
    };
    private String[][] raspunsuri = {
       
            {"A. da, dar numai dacă sunteţi vinovat de producerea accidentului;", "B. nu, dacă aţi fost testat cu un aparat autorizat;", "C. da, în mod necondiţionat;"},
            {"A. pe timpul cât semnalele luminoase de culoare roşie de la trecerea la nivel cu calea ferată sunt stinse;", "B. pe timpul cât semnalele luminoase ale semaforului defect sunt stinse;", "C. pe timpul cât barierele ori semibarierele sunt în curs de coborâre sau de ridicare."},
            {"A. da;", "B. numai dacă sunteţi implicat într-un accident de circulaţie;", "C. nu;"},
            
            {"A. cu faţa în sus;","B. cu faţa în jos;","C. cu picioarele situate mai sus decât nivelul corpului;"},
            {"A. să staţioneze pe banda de urgenţă, cu excepţia cazurilor justificate;","B. să oprească pentru a remedia o defecţiune;","C. să depăşească alte autovehicule;"},
            {"A. motocicletelor şi automobilelor care nu pot circula cu mai mult de 60 km/h;","B. celor care, prin construcţie sau din alte cauze, nu pot depăşi viteza de 50 km/h;","C. autovehiculelor care transportă încărcături periculoase;"},
            {"A. părăsirea drumului pe prima stradă la dreapta;","B. oprirea, de îndată, în afara părţii carosabile sau cât mai aproape de bordură ori acostament, până la trecerea coloanei;","C. reducerea vitezei şi deplasarea cât mai aproape de bordură sau acostament;"},
            {"A. în poziţie şezândă;","B. orizontal, cu faţa în sus;","C. persoana nu trebuie mişcată până la sosirea ambulanţei;"},
            {"A. în dreptul osului fracturat;","B. cuprinzând osul fracturat şi articulaţia superioară;","C. cuprinzând osul fracturat şi cele două articulaţii, respectiv cea superioară şi inferioară;"},
            {"A. să emiţi semnale acustice ori de câte ori efectuezi o depăşire;","B. să circuli cu semnul distinctiv aplicat regulamentar;","C. să circuli cu faza de drum în funcţiune, inclusiv pe timp de zi;"},
            {"A. circulaţia autovehiculelor în coloană;","B. învăţarea conducerii unui vehicul, încercarea prototipurilor de şasiuri şi de vehicule cu motor;","C. executarea de lucrări pe partea carosabilă pe timp de noapte;"},
            {"A. opriţi motocicleta;","B. vă continuaţi drumul;","C. reduceţi viteza;"},
            {"A. să opriţi în dreptul ultimei uşi;","B. să opriţi în spatele acestuia şi să vă reluaţi deplasarea numai după ce uşile tramvaiului au fost închise;","C. să reduceţi viteza şi să vă continuaţi deplasarea;"},
            {"A. să ameninţe participanţii la trafic cu violenţe ;","	B. să săvârşească acte sau gesturi obscene;	","C. să adreseze celorlalţi participanţi la trafic expresii jignitoare sau vulgare;"},
            {"A. prin ridicare;","	B. prin tragere;","	C. prin împingere;"},
            {"A. să reducă viteza;","	B. să nu mărească viteza şi să se angajeze cât mai aproape de marginea din dreapta a drumului;	","C. nu are nicio obligaţie;"},
            {"A. nu aveţi nicio obligaţie, întrucât locul nu este marcat sau semnalizat;	","B. să opriţi imediat motocicleta, pentru a permite trecerea pietonului;","	C. să reduceţi viteza şi să circulaţi cu atenţie;"},
            {"A. vă continuaţi drumul, deoarece aveţi prioritate de trecere în sensul giratoriu;","B. opriţi şi acordaţi prioritate coloanei cu regim prioritar;","C. viraţi la dreapta şi părăsiţi intersecţia;"},
            {"A. 100 km/h;","B. 130 km/h;","C. 90 km/h;"},
            {"A. intrarea pe prima stradă în dreapta;","B. oprirea de îndată pe partea dreaptă a drumului, cât mai aproape de trotuar sau de acostament ori, dacă este posibil, în afara părţii carosabile;","C. reducerea vitezei şi deplasarea pe lângă bordură sau acostament;"},
            {"A. aşteaptă sosirea poliţistului din zonă;","B. scoate motocicleta în afara părţii carosabile sau, dacă nu este posibil, o deplasează cât mai aproape de marginea drumului, după care anunţă în termen de 24 de ore cea mai apropiată unitate de poliţie competentă, pentru constatarea şi întocmirea documentelor legale;","C. anunţă poliţia, fără a schimba poziţia motocicletei;"},
            {"A. nu;","B. da;","C. legea nu prevede nimic în acest sens;"},
            {"A. trecerea unui vehicul înaintea altuia aflat pe acelaşi sens de circulaţie, prin schimbarea direcţiei de mers sau ieşirea din banda pe care s-a aflat iniţial;","B. trecerea unui vehicul pe lângă altul, care circulă din sens opus;","C. trecerea unui vehicul pe lângă altul, care circulă pe banda alăturată în aceeaşi direcţie de mers;"},
            {"A. da;","B. nu;",". numai dacă nu sunt pietoni pe trecere;"},
            {"A. dvs., pentru că acordaţi prioritate de dreapta;","B. autovehiculul care iese de pe drumul forestier;","C. autovehiculul care circulă cu viteză mai mare;"},
            {"A. biciclistul va opri;","B. biciclistul poate să se angajeze pe carosabil fără să se asigure;","C. biciclistul se va comporta corect şi va circula pe trotuar;"},

            
    
    };
    private int numarIntrebari;
    private int timpRamas;
    private List<Integer> intrebariNeraspunse;

    public ChestionareA() {
        setLayout(null);
        setTitle("Scor Intrebari");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        numarIntrebari = intrebari.length;

        labelIntrebareCurenta = new JLabel();
        labelIntrebare = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        buttonUrmatoarea = new JButton("Raspunde");
        buttonSaltIntrebare = new JButton("Skip");
        buttonDeselectare = new JButton("Sterge Raspuns");
        labelTimer = new JLabel();

        buttonUrmatoarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (intrebareCurenta >= 0 && intrebareCurenta < numarIntrebari) {
                    boolean raspuns1Corect = intrebareCurenta == 0 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns2Corect = intrebareCurenta == 1 && !checkBox3.isSelected() && !checkBox2.isSelected() && checkBox1.isSelected();
                    boolean raspuns3Corect = intrebareCurenta == 2 && !checkBox2.isSelected() && !checkBox3.isSelected() && checkBox1.isSelected();
                    boolean raspuns4Corect = intrebareCurenta == 3 && !checkBox1.isSelected() && !checkBox2.isSelected() &&checkBox3.isSelected();
                    boolean raspuns5Corect = intrebareCurenta == 4 && !checkBox2.isSelected() && !checkBox3.isSelected() && checkBox1.isSelected();
                    boolean raspuns6Corect = intrebareCurenta == 5 && !checkBox1.isSelected() && !checkBox3.isSelected() && checkBox2.isSelected();
                    boolean raspuns7Corect = intrebareCurenta == 6 && !checkBox1.isSelected() && !checkBox3.isSelected() && checkBox2.isSelected();
                    boolean raspuns8Corect = intrebareCurenta == 7 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns9Corect = intrebareCurenta == 8 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns10Corect = intrebareCurenta == 9 && !checkBox3.isSelected() && !checkBox1.isSelected() && checkBox2.isSelected();
                    boolean raspuns11Corect = intrebareCurenta == 10 && !checkBox1.isSelected() && !checkBox3.isSelected() && checkBox2.isSelected();
                    boolean raspuns12Corect = intrebareCurenta == 11 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox1.isSelected();
                    boolean raspuns13Corect = intrebareCurenta == 12 && !checkBox1.isSelected() && !checkBox3.isSelected() && checkBox2.isSelected();
                    boolean raspuns14Corect = intrebareCurenta == 13 && checkBox1.isSelected()&&checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns15Corect = intrebareCurenta == 14 && !checkBox3.isSelected() && !checkBox2.isSelected() && checkBox1.isSelected();
                    boolean raspuns16Corect = intrebareCurenta == 15 && !checkBox3.isSelected() && !checkBox1.isSelected() && checkBox2.isSelected();
                    boolean raspuns17Corect = intrebareCurenta == 16 && !checkBox3.isSelected() && !checkBox1.isSelected() && checkBox2.isSelected();
                    boolean raspuns18Corect = intrebareCurenta == 17 && !checkBox3.isSelected() && !checkBox1.isSelected() && checkBox2.isSelected();
                    boolean raspuns19Corect = intrebareCurenta == 18 && !checkBox3.isSelected() && !checkBox1.isSelected() && checkBox2.isSelected();
                    boolean raspuns20Corect = intrebareCurenta == 19 && !checkBox3.isSelected() && !checkBox1.isSelected() && checkBox2.isSelected();
                    boolean raspuns21Corect = intrebareCurenta == 20 && !checkBox3.isSelected() && !checkBox1.isSelected() && checkBox2.isSelected();
                    boolean raspuns22Corect = intrebareCurenta == 21 && !checkBox3.isSelected() && !checkBox2.isSelected() && checkBox1.isSelected();
                    boolean raspuns23Corect = intrebareCurenta == 22 && !checkBox3.isSelected() && !checkBox2.isSelected() && checkBox1.isSelected();
                    boolean raspuns24Corect = intrebareCurenta == 23 && !checkBox3.isSelected() && !checkBox1.isSelected() && checkBox2.isSelected();
                    boolean raspuns25Corect = intrebareCurenta == 24 && !checkBox1.isSelected() && !checkBox3.isSelected() && checkBox2.isSelected();
                    boolean raspuns26Corect = intrebareCurenta == 25 && !checkBox3.isSelected() && !checkBox1.isSelected() && checkBox2.isSelected();
                    

                    if (raspuns1Corect || raspuns2Corect || raspuns3Corect || raspuns4Corect || raspuns5Corect || raspuns6Corect || raspuns7Corect || raspuns8Corect || raspuns9Corect || raspuns10Corect || raspuns11Corect || raspuns12Corect || raspuns13Corect || raspuns14Corect || raspuns15Corect || raspuns16Corect || raspuns17Corect || raspuns18Corect || raspuns19Corect || raspuns20Corect || raspuns21Corect || raspuns22Corect || raspuns23Corect || raspuns24Corect || raspuns25Corect || raspuns26Corect ) {
                        scor++;
                    }
                    
                }

                if (!intrebariNeraspunse.isEmpty()) {
                    intrebareCurenta = intrebariNeraspunse.remove(0);
                    
                    afisareIntrebareCurenta();
                } else {
                    //JOptionPane.showMessageDialog(ChestionareA.this, "Sfârșitul întrebărilor. Scor final: " + scor);
                    if(scor >=22)
                   {
                        int raspuns = JOptionPane.showOptionDialog(new JFrame(), "Ai raspuns corect la " + scor + "/26" + "\n" + "PROMOVAT","Rezultat",
         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         new Object[] {"Meniu"}, JOptionPane.YES_OPTION);
                    if (raspuns == JOptionPane.YES_OPTION) 
                    {
                        // DU-TE IN MENIU 
                        Meniu mn = new Meniu();
                        mn.setVisible(true);
                    }
                   }
                    else
                    {
                        int raspuns = JOptionPane.showOptionDialog(new JFrame(), "Ai raspuns corect la " + scor + "/26" + "\n" + "PICAT","Rezultat",
         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         new Object[] {"Meniu"}, JOptionPane.YES_OPTION);
                    if (raspuns == JOptionPane.YES_OPTION) 
                    {
                        // DU-TE IN MENIU
                        Meniu mn = new Meniu();
                        mn.setVisible(true);
                    }
                    }
                    //System.exit(0);
                    
                }
            }
        });

        buttonSaltIntrebare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!intrebariNeraspunse.contains(intrebareCurenta)) {
                    intrebariNeraspunse.add(intrebareCurenta);
                }
                if (!intrebariNeraspunse.isEmpty()) {
                    intrebareCurenta = intrebariNeraspunse.remove(0);
                    afisareIntrebareCurenta();
                } else {
                    if(scor >=22)
                   {
                        int raspuns = JOptionPane.showOptionDialog(new JFrame(), "Ai raspuns corect la " + scor + "/26" + "\n" + "PROMOVAT","Rezultat",
         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         new Object[] {"Meniu"}, JOptionPane.YES_OPTION);
                    if (raspuns == JOptionPane.YES_OPTION) 
                    {
                        // DU-TE IN MENIU
                        Meniu mn = new Meniu();
                        mn.setVisible(true);
                    }
                   }
                    else
                    {
                        int raspuns = JOptionPane.showOptionDialog(new JFrame(), "Ai raspuns corect la " + scor + "/26" + "\n" + "PICAT","Rezultat",
         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         new Object[] {"Meniu"}, JOptionPane.YES_OPTION);
                    if (raspuns == JOptionPane.YES_OPTION) 
                    {
                        // DU-TE IN MENIU
                        Meniu mn = new Meniu();
                        mn.setVisible(true);
                    }
                    }
                   // System.exit(0);
                }
            }
        });
        
        
            buttonDeselectare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
            }
});

        

        timpRamas = 1800;

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timpRamas > 0) {
                    timpRamas--;
                    labelTimer.setText("Timp rămas: " + timpRamas + " secunde");
                } else {
                    ((Timer) e.getSource()).stop();
                    if(scor >=22)
                   {
                        int raspuns = JOptionPane.showOptionDialog(new JFrame(), "Ai raspuns corect la " + scor + "/26" + "\n" + "PROMOVAT","Rezultat",
         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         new Object[] {"Meniu"}, JOptionPane.YES_OPTION);
                    if (raspuns == JOptionPane.YES_OPTION) 
                    {
                        // DU-TE IN MENIU
                        Meniu mn = new Meniu();
                        mn.setVisible(true);
                    }
                   }
                    else
                    {
                        int raspuns = JOptionPane.showOptionDialog(new JFrame(), "Ai raspuns corect la " + scor + "/26" + "\n" + "PICAT","Rezultat",
         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         new Object[] {"Meniu"}, JOptionPane.YES_OPTION);
                    if (raspuns == JOptionPane.YES_OPTION) 
                    {
                        // DU-TE IN MENIU
                        Meniu mn = new Meniu();
                        mn.setVisible(true);
                    }
                    }
                   // System.exit(0);
                }
            }
        });
        timer.start();
        

        //setLayout(new FlowLayout());
        add(labelIntrebareCurenta);
        add(labelIntrebare);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        add(buttonUrmatoarea);
        add(buttonSaltIntrebare);
        add(buttonDeselectare);
        add(labelTimer);

        intrebariNeraspunse = new ArrayList<>();
        for (int i = 0; i < numarIntrebari; i++) {
            intrebariNeraspunse.add(i);
        }

        if (!intrebariNeraspunse.isEmpty()) {
            intrebareCurenta = intrebariNeraspunse.remove(0);
            afisareIntrebareCurenta();
        } else {
            JOptionPane.showMessageDialog(ChestionareA.this, "Nu există întrebări disponibile.");
            System.exit(0);
        }

        pack();
        setLocationRelativeTo(null);
        setSize(800, 600);
        setVisible(true);
    }

    private void afisareIntrebareCurenta() {
        
        labelIntrebareCurenta.setBounds(1,1,120,50);
        labelIntrebare.setBounds(120,50,1920,50);
        labelTimer.setBounds(500,1, 150, 50);
        checkBox1.setBounds(120,120,1920,50);
        checkBox2.setBounds(120,180,1920,50);
        checkBox3.setBounds(120,240,1920,50);
        buttonUrmatoarea.setBounds(120,300,120,50);
        buttonSaltIntrebare.setBounds(250,300,120,50);
        buttonDeselectare.setBounds(380,300,130,50);
        
        labelIntrebareCurenta.setText("Întrebarea " + (intrebareCurenta + 1) + " din " + numarIntrebari);
        labelIntrebare.setText(intrebari[intrebareCurenta]);
        checkBox1.setText(raspunsuri[intrebareCurenta][0]);
        checkBox2.setText(raspunsuri[intrebareCurenta][1]);
        checkBox3.setText(raspunsuri[intrebareCurenta][2]);
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChestionareA();
            }
        });
    }
}
