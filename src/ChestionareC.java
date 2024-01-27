

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChestionareC extends JFrame {
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
           "Ce obligaţie are conducătorul unui autocamion imobilizat într-un pasaj subteran?",
"În ce situaţii sunteţi obligat să circulaţi cu o viteză care să nu depăşească 30 km/h în localităţi sau 50 km/h în afara acestora?" ,
"Poate staţiona noaptea, pe un drum public, remorca unui autocamion?",
"Cele mai frecvente pene ale motoarelor pe benzină sunt cauzate de:" ,
"Semnalele date dintr-un autovehicul al poliţiei, ce însoţeşte o coloană oficială, prin folosirea avertizoarelor sonore şi luminoase, obligă la:" ,
"Când circulaţi pe un drum naţional european vă este interzisă:",
"Ce se înţelege prin selectarea benzii de circulaţie în apropierea unei intersecţii?",
"Atunci când intenţionaţi să circulaţi cu autocamionul spre stânga, într-o intersecţie fără marcaje, aflată în afara localităţii, ce rând trebuie să ocupaţi şi de la ce distanţă?",
"Ce îi este interzis conducătorului de autocamion pe timpul deplasării pe un drum public?",
"La intersecţiile fără marcaje, dacă intenţionaţi să circulaţi pe direcţia înainte, ocupaţi în mers:",
"În care dintre situaţiile de mai jos puteţi folosi banda de lângă axul drumului pe o autostradă?",
"Rolul instalaţiei de ungere este de a asigura:",
"Un garou, aplicat unei persoane rănite într-un accident de circulaţie, poate fi menţinut pentru a nu afecta ţesuturile:",
"Patinarea ambreiajului se manifestă prin:",
"Victima care a pierdut mult sânge trebuie să fie aşezată:",
"Exploziile cadenţate în eşapament indică:",
"Vă este permis să parcaţi autocamionul pe drumurile publice:",
"În care dintre situaţii nu este permisă depăşirea?",
"Limita maximă de viteză pe drumurile naţionale din afara localităţilor, pentru autovehiculele din categoria C este:",
"Cum trebuie scoase dintr-un autovehicul persoanele rănite?",
"Certificatul de înmatriculare se reţine atunci când:",
"Trusa pentru primul ajutor medical trebuie să conţină, în principal:",
"Care dintre următoarele cauze provoacă, la un sistem de direcţie cu servomecanism hidraulic, manevrarea greoaie a volanului, atunci când acesta este acţionat rapid?" ,
"Ce măsuri ia conducătorul de autocamion, angajat într-un accident cu avarii uşoare?",
"Cum trebuie să se încadreze conducătorul de autocamion, dacă intenţionează să schimbe direcţia de mers spre stânga într-o intersecţie prin care circulă şi tramvaie, iar spaţiul dintre şina din dreapta şi bordura trotuarului permite deplasarea vehiculelor doar pe un singur rând?" ,
"Ce vehicul poate îndeplini funcţia de remorcă?"
            
    };
    private String[][] raspunsuri = {
       
           {"A. să oprească motorul şi să pună în funcţiune luminile de avarie;	","B. să tracteze autocamionul până la ieşirea din pasajul subteran;","	C. să anunţe imediat pompierii în legătură cu locul în care se află"},
            {"A. în zonele unde sunt interzise oprirea şi staţionarea;	","B. pe drumurile publice cu sens unic;","	C. la schimbarea direcţiei de mers prin viraje"},
            {"A. nu;	B. da, dacă drumul este iluminat;	","C. da, dacă aceasta este semnalizată cu triunghiuri reflectorizante"},
            {"A. instalaţia de aprindere;	","B. instalaţia de iluminare;","	C. sistemul de evacuare a gazelor arse"},
            {"A. intrarea pe prima stradă în dreapta;","	B. oprirea de îndată pe partea dreaptă a drumului, cât mai aproape de trotuar sau de acostament ori, dacă este posibil, în afara părţii carosabile;	","C. reducerea vitezei şi deplasarea pe lângă bordură sau acostament"},
            {"A. folosirea mijloacelor de averizare sonoră;","	B. remorcarea altui autovehicul;	","C. staţionarea voluntară pe partea carosabilă;" },
            {"A. semnalizarea şi asigurarea la schimbarea direcţiei de mers;","	B. ocuparea din timp a benzii corespunzătoare direcţiei de mers, la apropierea de o intersecţie;	","C. reducerea vitezei şi semnalizarea schimbării poziţiei autocamionului"},
            {"A. rândul din stânga, de la cel puţin 50 m;	","B. rândul din stânga, de la cel puţin 200 m;	C. rândul din dreapta, de la cel puţin 100 m;"},
            {"A. să transporte în autocamion mai multe persoane decât numărul de locuri înscrise în certificatul de înmatriculare sau înregistrare;","	B. să permită controlul stării tehnice a autocamionului, precum şi al bunurilor transportate;","	C. să deschidă uşile autocamionului atunci când este parcat"},
            {"A. rândul din stânga;	","B. rândul din dreapta;	","C. oricare dintre rânduri;"},
            {"A. când efectuaţi depăşirea altor autovehicule, dacă celelalte benzi în direcţia de mers sunt ocupate;","	B. când conduceţi autocamionul cu viteza maximă admisă;	","C. când nu sunteţi precedat de alte autovehicule;" },
            {"A. ungerea pieselor mobile ale mecanismului motor, pentru a reduce frecarea şi pentru a preveni uzura;	","B. lubrifierea roţilor, pentru a asigura o deplasare uşoară a vehiculului pe drumurile publice;	","C. funcţionarea corespunzătoare a trasmisiei autovehiculului, în orice regim de exploatare;" },
            {"A. maximum 24 de ore;","	B. minimum 2 ore;	","C. maximum 2 ore;" },
            {"A. zgomote sacadate în partea din faţă a motorului;","	B. miros specific de garnitură arsă şi mărirea lentă a vitezei la accelerare;	","C. producerea unei fluierături în timpul frânării;" },
            {"A. cu faţa în sus;","	B. cu faţa în jos;","	C. cu picioarele situate mai sus decât nivelul corpului;" },
            {"A. pierderea etanşeităţii unei supape de evacuare;	","B. defectarea tobei de eşapament;	","C. dereglarea unui amortizor;" },
            {"A. în locurile special amenajate şi semnalizate prin indicatoare şi marcaje rutiere;","	B. acolo unde nu există parcări amenajate;","	C. acolo unde circulaţia în ambele sensuri se desfăşoară fără dificultate;" },
            {"A. pe un drum în rampă, în apropierea vârfului, când vizibilitatea este redusă sub 50 m;","	B. când un autobuz se află oprit în staţie;","	C. în zonele cu trafic intens;" },
            {"A. 110 km/h;","	B. 80 km/h;","	C. 100 km/h;"},
            {"A. prin ridicare;	","B. prin tragere;","	C. prin împingere;"},
            {"A. vehiculul nu are efectuată inspecţia tehnică;	","B. sunt aplicate abţibilduri pe parbriz;","	C. există defecţiuni la sistemul de climatizare;"},
            {"A. foarfece cu vârfuri boante, dispozitiv intermediar pentru respiraţie „gură la gură”, comprese sterile, feşe, pansamente, mănuşi de unică folosinţă din latex, folie de supravieţuire izotermă, broşură de prim ajutor autorizată de Ministerul Sănătăţii Publice;","	B. role de leucoplast, plasturi, alcool medicinal, dispozitive pentru suspendarea membrelor accidentate şi adresele personalului medical care sunt de serviciu la camerele de gardă;","	C. butelie cu oxigen tehnic, un furtun de legătură şi un manometru care să reziste la o presiune de cel puţin 6 atmosfere, o mască din pansament steril şi dispozitive pentru curăţarea rănilor;"},
            {"A. pompa nu debitează ulei suficient;	","B. angrenajele sistemului de direcţie au jocuri;	","C. roţile posterioare sunt dezechilibrate;"},
            {"A. aşteaptă sosirea poliţistului din zonă;","	B. scoate autocamionul în afara părţii carosabile, după care anunţă poliţia în 24 de ore;","	C. anunţă poliţia, fără a schimba poziţia autocamionului;" },
            {"A. pe linia tramvaiului;	","B. pe singurul rând rămas la dispoziţie, lăsând liber traseul tramvaiului;","	C. în această situaţie nu se poate schimba direcţia de mers spre stânga;" },
            {"A. orice autovehicul cu o putere mai mică de 11 kW;	","B. orice vehicul destinat să fie tractat de un autovehicul sau de un autotractor;	","C. orice vehicul dotat cu 4 roţi şi o osie;"},

            
    
    };
    private int numarIntrebari;
    private int timpRamas;
    private List<Integer> intrebariNeraspunse;

    public ChestionareC() {
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
                    boolean raspuns2Corect = intrebareCurenta == 1 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns3Corect = intrebareCurenta == 2 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns4Corect = intrebareCurenta == 3 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns5Corect = intrebareCurenta == 4 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns6Corect = intrebareCurenta == 5 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns7Corect = intrebareCurenta == 6 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns8Corect = intrebareCurenta == 7 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns9Corect = intrebareCurenta == 8 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns10Corect = intrebareCurenta == 9 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns11Corect = intrebareCurenta == 10 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns12Corect = intrebareCurenta == 11 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns13Corect = intrebareCurenta == 12 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns14Corect = intrebareCurenta == 13 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns15Corect = intrebareCurenta == 14 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                    boolean raspuns16Corect = intrebareCurenta == 15 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns17Corect = intrebareCurenta == 16 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns18Corect = intrebareCurenta == 17 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns19Corect = intrebareCurenta == 18 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns20Corect = intrebareCurenta == 19 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns21Corect = intrebareCurenta == 20 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns22Corect = intrebareCurenta == 21 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns23Corect = intrebareCurenta == 22 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns24Corect = intrebareCurenta == 23 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                    boolean raspuns25Corect = intrebareCurenta == 24 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
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
            JOptionPane.showMessageDialog(ChestionareC.this, "Nu există întrebări disponibile.");
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
                new ChestionareC();
            }
        });
    }
}
