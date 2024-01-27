

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChestionareB extends JFrame {
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
           "Cum veţi proceda dacă intenţionaţi să schimbaţi direcţia de mers spre dreapta?" ,
"Ce tendinţă prezintă un autoturism cu tracţiune pe spate, dacă acceleraţi prea puternic în curbă?" ,
"Ce obligaţii are conducătorul de autovehicule când circulă pe un drum public?",
"Ce se înţelege prin conducere ecologică a unui autovehicul?",
"În rănile cu hemoragie se va avea în vedere, în faza iniţială:",
"La semnalul poliţistului situat într-o intersecţie, cu braţul ridicat vertical, aveţi obligaţia:" ,
"Care este deosebirea dintre oprire şi staţionare?",
"Ce obligaţii vă revin la semnalul agentului de cale ferată de la trecerile la nivel, executat cu un dispozitiv cu lumină roşie ori cu bastonul fluorescent-reflectorizant?",
"La apropierea de staţiile prevăzute cu alveolă, când circulaţi pe banda de lângă acostament, iar conducătorul autovehiculului de transport public de persoane semnalizează pornirea din staţie:",
"Pe o autostradă cu trei benzi, s-a blocat circulaţia. Pe unde vor circula vehiculele de intervenţie?",
"Utilizarea sistemului de climatizare are ca efect:",
"Pentru a conduce ecologic un autovehicul, se recomandă:",
"Când sunteţi obligat să păstraţi o distanţă corespunzătoare faţă de cel care rulează în faţa dumneavoastră?" ,
"Semnalul poliţistului rutier aflat într-un autovehicul al poliţiei, efectuat cu braţul, cu sau fără baston reflectorizant, scos pe partea laterală dreaptă a vehiculului, semnifică:",
"Copiii cu vârste de până la 12 ani pot fi transportaţi:",
"Dezinfecţia plăgilor ce necesită a fi pansate se face cu:" ,
"Cum procedează conducătorul de autovehicul atunci când, apropiindu-se de o trecere la nivel cu calea ferată, prevăzută cu bariere ori semibariere, cele două lumini roşii funcţionează intermitent-alternativ?",
"Care este regula priorităţii de trecere la intersecţia a două drumuri de aceeaşi categorie, cu circulaţie nedirijată?n",
"În faţa dvs. s-a produs un accident rutier care este cercetat de poliţie, iar circulaţia se desfăşoară anevoios, pe un singur sens. Cum veţi proceda?",
"Ce obligaţii aveţi la întâlnirea indicatorului „Biciclişti”?",
"Este permisă oprirea voluntară a autovehiculului în tuneluri?",
"În ce locuri circulaţia cu viteză duce adeseori la accidente?",
"Ce trebuie să facă un conducător de vehicul pentru ca depăşirea să fie considerată regulamentară?",
"Vă apropiaţi de o trecere la nivel cu calea ferată curentă fără bariere, în traversarea căreia s-a angajat o căruţă aflată în faţa dvs. În această situaţie puteţi efectua depăşirea?",
"Care autovehicule pot fi echipate cu lumini speciale de avertizare de culoare albastră?",
"Dacă circulaţi pe un drum naţional european (E), vă este interzis:"
            
    };
    private String[][] raspunsuri = {
       
           {"A. semnalizaţi schimbarea direcţiei de mers; pietonii vă vor acorda prioritate;","B. semnalizaţi schimbarea direcţiei de mers; acordaţi prioritate vehiculelor care circulă din partea stângă;","C. semnalizaţi schimbarea direcţiei de mers şi acordaţi prioritate de trecere pietonilor"},
{"A. autoturismul urmează, fără deviere, cursa volanului;","B. autoturismul tinde să derapeze cu spatele spre exteriorul curbei;	","C. roţile din faţă se învârtesc în gol"},
{"A. să circule numai dacă verificarea medicală lunară este efectuată;","B. să circule numai pe sectoarele de drum pe care îi este permis accesul şi să respecte normele referitoare la masele totale maxime autorizate admise de autoritatea competentă;	","C. să se informeze din timp, la administratorii de drum, în legătură cu eventualele limite maxime şi minime de viteză"},
{"A. obligaţia de a folosi în permanenţă carburant biodegradabil;	","B. deplasări urbane cu bicicleta, pe jos sau cu alte mijloace care nu poluează atmosfera;	","C. un ansamblu de măsuri comportamentale, de control sau de verificare a vehiculului, prin care se realizează o importantă economie de energie şi protecţia mediului"},
{"A. curăţarea şi pansarea rănii;	","B. pansarea rănii;	","C. oprirea hemoragiei"},
{"A. să circulaţi cu prudenţă maximă;	","B. să reduceţi viteza;	","C. să opriţi, indiferent din ce direcţie circulaţi"},
{"A. niciuna;","B. deosebirea constă în durata de imobilizare a vehiculului;","	C. deosebirea constă în modul de aşezare şi asigurare a autovehiculului pe drum"},
{"A. să reduceţi viteza doar până traversaţi calea ferată;","	B. să opriţi autovehiculul;	","C. să reduceţi viteza şi să opriţi numai dacă circulă un vehicul feroviar"},
{"A. opriţi obligatoriu;	","B. reduceţi viteza şi, la nevoie, opriţi;	","C. măriţi viteza"},
{"A. pe banda de urgenţă;","	B. între banda din stânga şi banda din mijloc;","	C. între banda din dreapta şi banda din mijloc"},
{"A. creşterea consumului de combustibil;","	B. reducerea consumului de combustibil;","	C. scăderea puternică a gradului de confort"},
{"A. utilizarea climatizării numai în cazul traseelor scurte;","	B. utilizarea climatizării numai pe timp de noapte;	","C. utilizarea climatizării numai în situaţiile absolut necesare"},
{"A. numai atunci când nu aveţi experienţă în conducere;","	B. numai dacă autovehiculul pe care îl conduceţi nu are frânele eficiente;","	C. în orice situaţie"},
{"A. oprire pentru conducătorii vehiculelor care circulă în spatele autovehiculului poliţiei;	","B. reducerea vitezei de către cei care circulă în spatele autovehiculului poliţiei;","	C. semnalul se adresează celor care circulă din sens opus"},
{"A. pe scaunul din faţă al autovehiculului, dacă sunt ţinuţi în braţe de persoane majore;	","B. pe scaunul din faţă al autovehiculului, având fixată centura de siguranţă;	","C. pe bancheta din spate a autovehiculului, având fixată centura de siguranţă, adaptată greutăţii şi dimensiunilor lor"},
{"A. apă oxigenată sau iod;","	B. ser fiziologic;","	C. apă potabilă"},
{"A. continuă deplasarea, dacă barierele nu sunt coborâte;","	B. opreşte, deoarece barierele sunt închise sau urmează să coboare;","	C. continuă deplasarea fără interdicţie, deoarece luminile semnalizează doar prezenţa unei treceri la nivel cu calea ferată"},
{"A. prioritatea de dreapta;	","B. prioritatea primului sosit;	","C. prioritatea de drum principal"},
{"A. vă continuaţi drumul cu atenţie, respectând indicaţiile poliţistului rutier;","	B. vă continuaţi drumul cu viteză sporită, pentru a nu bloca traficul rutier;","	C. reduceţi viteza şi opriţi în locul accidentului, pentru a vedea ce s-a întâmplat"},
{"A. să reduceţi viteza la maximum 30 km/h;	","B. să circulaţi cu atenţie şi, dacă este cazul, acordaţi prioritate de trecere bicicliştilor care circulă pe pista special destinată;","	C. nu aveţi nicio obligaţie, bicicliştii vă vor acorda prioritate"},
{"A. da;	","B. nu;","	C. numai dacă lungimea tunelului depăşeşte 1000 m"},
{"A. în intersecţii;	","B. în parcări;","	C. în poligoanele auto"},
{"A. să se asigure că manevra poate fi executată în condiţii de siguranţă, după care să semnalizeze intenţia de schimbare a poziţiei de mers şi să efectueze depăşirea;	","B. să semnalizeze din timp intenţia de schimbare a direcţiei de mers;	","C. să mărească viteza de deplasare, astfel încât să scurteze timpul de realizare a depăşirii"},
{"A. da, dacă aceasta nu a ajuns încă la linia de tren;","	B. da, întrucât căruţa este un vehicul lent;	","C. nu"},
{"A. legea nu prevede;	","B. orice autovehicul pentru care se obţine aprobarea poliţiei rutiere;","	C. vehiculele aparţinând poliţiei, jandarmeriei şi poliţiei de frontieră"},
{"A. să folosiţi pe timpul zilei luminile de întâlnire;","	B. să opriţi pe partea carosabilă;","	C. să depăşiţi"},

            
    
    };
    private int numarIntrebari;
    private int timpRamas;
    private List<Integer> intrebariNeraspunse;

    public ChestionareB() {
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
                    boolean raspuns2Corect = intrebareCurenta == 1 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns3Corect = intrebareCurenta == 2 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns4Corect = intrebareCurenta == 3 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns5Corect = intrebareCurenta == 4 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns6Corect = intrebareCurenta == 5 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns7Corect = intrebareCurenta == 6 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns8Corect = intrebareCurenta == 7 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns9Corect = intrebareCurenta == 8 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns10Corect = intrebareCurenta == 9 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns11Corect = intrebareCurenta == 10 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns12Corect = intrebareCurenta == 11 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns13Corect = intrebareCurenta == 12 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns14Corect = intrebareCurenta == 13 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns15Corect = intrebareCurenta == 14 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns16Corect = intrebareCurenta == 15 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns17Corect = intrebareCurenta == 16 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns18Corect = intrebareCurenta == 17 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns19Corect = intrebareCurenta == 18 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns20Corect = intrebareCurenta == 19 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns21Corect = intrebareCurenta == 20 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns22Corect = intrebareCurenta == 21 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns23Corect = intrebareCurenta == 22 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns24Corect = intrebareCurenta == 23 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns25Corect = intrebareCurenta == 24 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns26Corect = intrebareCurenta == 25 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    

                    if (raspuns1Corect || raspuns2Corect || raspuns3Corect || raspuns4Corect || raspuns5Corect || raspuns6Corect || raspuns7Corect || raspuns8Corect || raspuns9Corect || raspuns10Corect || raspuns11Corect || raspuns12Corect || raspuns13Corect || raspuns14Corect || raspuns15Corect || raspuns16Corect || raspuns17Corect || raspuns18Corect || raspuns19Corect || raspuns20Corect || raspuns21Corect || raspuns22Corect || raspuns23Corect || raspuns24Corect || raspuns25Corect || raspuns26Corect ) {
                        scor++;
                    }
                    
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
                    }
                    }
                    System.exit(0);
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
                    }
                    }
                    System.exit(0);
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

        

        timpRamas = 1800; // 120 de secunde

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
                    }
                    }
                    System.exit(0);
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
            JOptionPane.showMessageDialog(ChestionareB.this, "Nu există întrebări disponibile.");
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
                new ChestionareB();
            }
        });
    }
}
