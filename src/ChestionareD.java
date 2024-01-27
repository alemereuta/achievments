

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChestionareD extends JFrame {
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
        
           "Care dintre următoarele cauze provoacă manevrarea anevoioasă a volanului, în cazul unui sistem de direcţie cu servomecanism hidraulic?",
"Circulaţi cu un autobuz cu remorcă pe o şosea cu o singură bandă pentru fiecare direcţie şi vă apropiaţi de o curbă la stânga, foarte strânsă şi fără vizibilitate. Cum trebuie să adaptaţi modul de conducere?" ,
"Injecţia de benzină multipunct se realizează în:",
"Cum trebuie să procedeze conducătorul unui autobuz, atunci când se apropie de tramvaie aflate în mers?",
"Ce este interzis să se monteze la autovehicul?",
"Circulaţia pe banda rezervată transportului public de persoane, semnalizată ca atare, este permisă:",
"Care dintre cauzele enumerate mai jos provoacă la viraj şocuri în volanul unui sistem de direcţie cu servomecanism hidraulic?",
"Este interzisă staţionarea în dreptul marcajului longitudinal continuu, aplicat între sensurile de circulaţie?",
"Circuitul de înaltă tensiune din cadrul instalaţiei de aprindere prin scânteie cuprinde:",
"Ce bandă de circulaţie trebuie să folosiţi, atunci când conduceţi un autobuz pe autostradă?",
"Conducătorii de tramvaie sau de vehicule, care efectuează transport public de persoane, trebuie să aibă vârsta minimă de:",
"Manevra de evitare, prin schimbarea direcţiei de mers, a unui obstacol aflat pe sensul dvs. de circulaţie, urmată de revenirea pe acelaşi sens, constituie:",
"Precizaţi care este viteza maximă admisă în afara localităţilor, pentru un ansamblu de autovehicule format dintr-un autobuz şi o remorcă:",
"Ce măsuri se recomandă atunci când urmează să străbateţi o porţiune de drum public acoperită cu piatră cubică?",
"În funcţie de starea accidentatului, măsurile de prim ajutor se vor lua în următoarea ordine:",
"Care dintre cauzele de mai jos provoacă sulfatarea bateriei de acumulatori?",
"Dispozitivele principale care compun sistemul de transmisie sunt:",
"Care dintre următoarele cauze determină încălzirea anormală a tamburilor sistemului de frânare cu comandă hidraulică?",
"Viteza maximă admisă pe autostrăzi, pentru vehiculele din categoria D şi subcategoria D1, este de:",
"Apariţia unor bule de gaz în vasul de expansiune, la accelerarea motorului, indică:",
"Când circulaţi pe un drum naţional european vă este interzisă:",
"Se consideră contravenţie:",
"Cum trebuie să conduceţi autobuzul noaptea, pe timp de ploaie torenţială sau ninsoare abundentă, dacă vizibilitatea este sub 100 m?",
"Atunci când victimei unui accident de circulaţie i s-au oprit bătăile inimii (stop cardiac), masajul cardiac se execută:",
"La un accidentat cu corpi străini în interiorul plăgilor, procedura corectă este:",
"Care dintre factorii enumeraţi mai jos condiţionează exploatarea raţională a pneurilor?",

    
    
    };
    private String[][] raspunsuri = {
       
           {"A. defectarea pompei de înaltă presiune;","	B. jocul mare din articulaţii;","	C. presiunea mare în pneurile roţilor directoare;"},
        {"A. reduceţi viteza înaintea curbei, din cauza pericolului mărit de derapare a remorcii;	","B. reduceţi viteza, circulaţi pe mijlocul benzii şi acceleraţi uşor când ajungeţi în vârful curbei;	C. menţineţi viteza, iar în curbă frânaţi;"},
        {"A. fiecare cilindru al motorului, în poarta supapei de admisie;","	B. interiorul difuzorului carburatorului;	","C. filtrul de benzină situat înaintea carburatorului;"},
        {"A. să atenţioneze conducătorul tramvaiului, prin semnale sonore, pentru ca acesta să reducă viteza;","	B. să păstreze în mers cel puţin 10 m faţă de ultimul vagon al tramvaiului;","	C. dacă spaţiul permite, poate depăşi tramvaiele prin partea dreaptă;"},
        {"A. dispozitive de detectare a aparatelor radar;	","B. lumini de altă culoare şi intensitate decât cele omologate;","	C. lumini de poziţie;"},
        {"A. vehiculelor care efectuează transport public de persoane şi autovehiculelor cu regim de circulaţie prioritar, atunci când se deplasează în acţiuni de intervenţie sau în misiuni care au caracter de urgenţă;","	B. numai vehiculelor care efectuează transport public de persoane;	","C. tuturor vehiculelor, dacă nu incomodează circulaţia vehiculelor prioritare;"},
        {"A. pătrunderea aerului în instalaţia hidraulică;	","B. gresajul defectuos al articulaţiilor;	","C. geometria roţilor dereglată;"},
        {"A. nu;","	B. da, atunci când conducătorii celorlalte vehicule ar fi obligaţi astfel să treacă peste marcajul respectiv;","	C. legal, nu este prevăzut;"},
        {"A. condensatorul, bobinajul rotorului demarorului şi releul electroventilatorului;	","B. înfăşurarea secundară a bobinei de inducţie, distribuitorul, rotorul, fişele şi bujiile;	","C. conductorii electrici marcaţi cu izolatori de culoare roşie şi siguranţele;"},
        {"A. numai banda din partea dreaptă, în sensul de mers;	","B. banda de lângă axul autostrăzii;	","C. oricare bandă liberă;"},
        {"A. 18 ani împliniţi;	","B. 21 ani împliniţi;	","C. 25 ani împliniţi;"},
        {"A. ocolire;","	B. depăşire;","	C. situaţie de urgenţă;"},
        {"A. 80 km/h pe autostrăzi şi 70 km/h pe celelalte categorii de drumuri;","	B. 100 km/h pe autostradă, 80 km/h pe drumurile expres sau naţionale europene şi 70 km/h pe celelalte categorii de drumuri;","	C. 100 km/h atât pe autostrăzi, cât şi pe celelalte categorii de drumuri;"},
        {"A. să folosiţi numai frâna de ajutor pentru a evita derapajul;","	B. să reduceţi din timp viteza, evitând bruscarea comenzilor;","	C. să circulaţi cât mai aproape de axul drumului, pentru a evita lovirea acostamentului;"},
        {"A. oprirea hemoragiei, pansarea rănilor, imobilizarea fracturilor, respiraţia artificială, masajul cardiac;","	B. respiraţia artificială, masajul cardiac, oprirea hemoragiei, pansarea rănilor, imobilizarea fracturilor;","	C. imobilizarea fracturilor, pansarea rănilor, respiraţia artificială, masajul cardiac, oprirea hemoragiei;"},
        {"A. legăturile bateriei cu alternatorul sunt slabe;","	B. nivelul scăzut al electrolitului în baterie;	","C. bornele bateriei sunt oxidate;"},
        {"A. lanţul de distribuţie, pinioanele distribuţiei, axa cu came şi jantele;","	B. ambreiajul, cutia de viteze, arborii intermediari, diferenţialul şi planetarele;","	C. demarorul, arborele motor, cureaua de ventilator şi fuliile;"},
        {"A. uzura exagerată a garniturilor de ferodou;	","B. distanţa prea mare între saboţi şi tamburi;	","C. arcul de readucere a saboţilor este slab sau rupt;"},
        {"A. 90 km/h;	","B. 110 km/h;	","C. 130 km/h;"},
        {"A. arderea garniturii de chiulasă;","	B. temperatura ridicată a lichidului de răcire;	","C. blocarea termostatului;"},
        {"A. folosirea mijloacelor de avertizare sonoră;	","B. remorcarea altui autovehicul;","	C. staţionarea voluntară pe partea carosabilă;"},
        {"A. nerespectarea prevederilor privind deţinerea, de către un conducător auto, a mai mult de o cartelă tahografică validă;	","B. oprirea autovehiculului în afara locurilor specificate în cartela tahografică;","	C. fumatul în autovehiculele dotate cu tahograf;"},
        {"A. cu atenţie sporită, cât mai aproape de acostament sau de bordură;	","B. cu atenţie sporită şi cu lumina galbenă intermitentă în funcţiune;","	C. cu viteza redusă la 30 km/h în localităţi sau 50 km/h în afara acestora, precum şi cu luminile de întâlnire;"},
        {"A. prin apăsarea ritmică cu podul palmelor suprapuse a toracelui victimei, în dreptul inimii;	","B. prin lovirea cu palmele a obrajilor victimei;	","C. prin încrucişarea ritmică a braţelor victimei simultan cu respiraţia artificială;"},
        {"A. extragerea corpilor străini din plăgi;	","B. spălarea corpilor străini cu apă curată;	","C. corpii străini nu se extrag din plăgi, întrucât se pot produce complicaţii;"},
        {"A. viteza de deplasare, modul de conducere, presiunea corectă;","	B. tipul autovehiculului, numărul de roţi, viteza de deplasare;","	C. puterea motorului, tipul de tracţiune al autovehiculului, viteza de deplasare;"},

    
    };
    private int numarIntrebari;
    private int timpRamas;
    private List<Integer> intrebariNeraspunse;

    public ChestionareD() {
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
                  boolean raspuns1Corect = intrebareCurenta == 0 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns2Corect = intrebareCurenta == 1 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns3Corect = intrebareCurenta == 2 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns4Corect = intrebareCurenta == 3 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns5Corect = intrebareCurenta == 4 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns6Corect = intrebareCurenta == 5 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns7Corect = intrebareCurenta == 6 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns8Corect = intrebareCurenta == 7 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns9Corect = intrebareCurenta == 8 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns10Corect = intrebareCurenta == 9 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns11Corect = intrebareCurenta == 10 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns12Corect = intrebareCurenta == 11 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns13Corect = intrebareCurenta == 12 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns14Corect = intrebareCurenta == 13 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns15Corect = intrebareCurenta == 14 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns16Corect = intrebareCurenta == 15 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns17Corect = intrebareCurenta == 16 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns18Corect = intrebareCurenta == 17 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns19Corect = intrebareCurenta == 18 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns20Corect = intrebareCurenta == 19 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns21Corect = intrebareCurenta == 20 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns22Corect = intrebareCurenta == 21 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns23Corect = intrebareCurenta == 22 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns24Corect = intrebareCurenta == 23 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns25Corect = intrebareCurenta == 24 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns26Corect = intrebareCurenta == 25 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    

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
            JOptionPane.showMessageDialog(ChestionareD.this, "Nu există întrebări disponibile.");
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
                new ChestionareD();
            }
        });
    }
}
