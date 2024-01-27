

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChestionareTr extends JFrame {
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
           "1. Un vehicul are luminile de avarie aprinse. Ce trebuie să aveți în vedere?",
        "2. Cifra 14 din inscripționarea 185/70R 14, existentă pe o anvelopă, reprezintă:",
        "3. Ce obligații are conducătorul de vehicule când circulă pe un drum public?",
        "4. Sunteți obligat să folosiți luminile de întâlnire în timpul zilei:",
        "5. În care dintre următoarele situații conducătorul unui vehicul este obligat să folosească luminile de întâlnire sau de drum?",
        "6. Ce rând trebuie să ocupați și de la ce distanță, pentru a putea executa virajul la stânga într-o intersecție nedirijată?",
        "7. Cum se opresc hemoragiile la trunchi și cap?",
        "8. Când este indicat să verificați presiunea din anvelope?",
        "9. Criteriul de alegere a motorinei pentru motoarele Diesel îl constituie:",
        "10. Cum acționați în cazul unui accidentat a cărui inimă s-a oprit (nu mai are puls)?",
        "11. Conducerea pe drumul public a autovehicului / tractorului agricol sau forestier, de către o persoană cu o alcoolemie în sânge de peste 0,8 g/l atrage:",
        "12. Instalațiile de semnalizare și iluminare ale unui autovehicul / tractor agricol sau forestier trebuie:",
        "13. Ce trebuie să facă un conducător de vehicul pentru ca depășirea să fie considerată regulamentară?",
        "14. Primul ajutor în caz de traumatism al capului constă în:",
        "15. Vă este permis să claxonați un biciclist înainte de a-l depăși?",
        "16. Ce parte componentă a transmisiei dă posibilitatea roților motoare ale aceleiași punți să parcurgă, în viraje, drumuri de lungimi diferite?",
        "17. Când gura unui rănit rămâne încleștată, respirația artificială se poate face:",
        "18. Ce trebuie să aveți în vedere atunci când intenționați să depășiți atât bicicliști, cât și grupuri de pietoni care se deplasează pe carosabil?",
        "19. Ce obligații îi revin conducătorului de vehicul care a accidentat un pieton ce a traversat strada printr-un loc nepermis?",
        "20. În ce situație este interzisă întoarcerea?",
        "21. Neacordarea priorității înseamnă:",
        "22. Vehiculele lente sau grele se conduc:",
        "23. Termenul „remorcă” desemnează:",
        "24. Cum veți proceda corect la întâlnirea indicatoarelor „Oprire“ și „Trecere la nivel cu o cale ferată dublă fără bariere“?",
        "25. Apariția unui zgomot ascuțit în momentul apăsării pedalei de ambreiaj semnifică:",
        "26. Ce se înțelege prin „semiremorcă”?",

            
    };
    private String[][] raspunsuri = {
       
          {"A. vehiculul va vira la dreapta sau la stânga","B. vehiculul este parcat","C. vehiculul a rămas în pană sau este remorcat"},
        {"A.  limita maximă de viteză cu care se poate rula, respectiv 140 km/h","B.  diametrul jantei, exprimat în inci, adică echivalentul a 365 mm","C. presiunea recomandată, respectiv 1,4 atmosfere"},
        {"A. să circule numai dacă verificarea medicală lunară este efectuată","B. să circule numai pe sectoarele de drum pe care îi este permis accesul și să respecte normele referitoare la masele totale maxime autorizate admise de autoritatea competentă","C. să se informeze din timp, la administratorii de drum, în legătură cu eventualele limite maxime și minime de viteză"},
        {"A. pe toate categoriile de drumuri","B. pe drumurile județene, comunale și locale","C. pe autostrăzi, drumuri expres și naționale europene"},
        {"A.  în cazul arterelor de circulație slab iluminate, când vizibilitatea este redusă, în mers, atât în localități, cât și în afara acestora","B. în cazul staționării pe timp de noapte pe partea carosabilă a drumurilor naționale sau în cazul parcării în locuri special amenajate, dar neiluminate","C. pe timp de zi pe drumurile naționale, în situațiile în care traficul este supraaglomerat"},
        {"A. rândul din stânga, de la o distanță de cel puțin 50 m","B.  rândul din mijloc, de la o distanță de cel puțin 100 m","C. rândul de lângă bordură, de la o distanță de cel puțin 50 m"},
        {"A. prin orice mijloace","B. prin aplicarea unui garou de cauciuc","C. prin aplicarea compreselor sterile și a pansamentelor compresive"},
        {"A. întotdeauna la 300 km","B. de regulă, înainte de a porni la drum","C. numai pe timp de iarnă, când anvelopele sunt reci"},
        {"A. culoarea și consistența","B. cifra octanică (CO)","C. cifra cetanică (CC)"},
        {"A. plecați, întrucât nu se mai poate face nimic","B. începeți compresia artificială a inimii și respirația artificială","C.  mișcați energic accidentatul, pentru a-și reveni"},
        {"A.  răspunderea contravențională și reținerea permisului de conducere","B.  răspunderea penală și anularea permisului de conducere","C. răspunderea penală și suspendarea exercitării dreptului de a conduce pe o perioadă de 90 de zile"},
        {"A. să se asigure că manevra poate fi executată în condiții de siguranță, după care să semnalizeze intenția de schimbare a poziției de mers și să efectueze depășirea","B. să semnalizeze din timp intenția de schimbare a direcției de mers","C. să mărească viteza de deplasare, astfel încât să scurteze timpul de realizare a depășirii"},
        {"A. aplicarea unor comprese reci pe frunte și bandajarea părților lovite","B. observarea respirației și a circulației sanguine și aplecarea capului către bărbie","C. bandajarea fracturii deschise, deschiderea căilor respiratorii dacă se impune și culcarea victimei pe o targă plană pentru transport"},
        {"A. da, dacă distanța este de peste 25 m","B.  nu","C. numai în reprize foarte scurte"},
        {"A.  cutia de viteze","B.  diferențialul","C. arborii planetari"},
        {"A. prin gura închisă a victimei","B.  prin nările victimei","C. în acest caz nu se mai face respirație artificial?"},
        {"A.  puteți depăși numai după ce pietonii și bicicliștii v-au făcut semn în acest sens","B. respectați prevederile legale","C.  bicicliștii și pietonii pot fi depășiți numai dacă distanța laterală este de 3 m"},
        {"A. să se prezinte de urgență la cea mai apropiată unitate de poliție","B. întrucât nu este vinovat de accident, poate părăsi locul faptei","C. să anunțe poliția și, în lipsa altor mijloace de transport, să-l transporte el însuși la cea mai apropiată unitate sanitară, apoi să se întoarcă la locul accidentului"},
        {"A. în apropierea stațiilor de tramvai","B. când vizibilitatea este redusă sub 100 m","C. în locurile unde soliditatea drumului nu permite"},
        {"A. nerespectarea semnificației semnalizării rutiere de obligare sau de avertizare","B. nerespectarea dispozițiilor legale privind asigurarea și semnalizarea în intersecții","C. obligarea celor care au prioritate de trecere de a-și modifica brusc direcția sau viteza de deplasare ori să oprească"},
        {"A.  să funcționeze doar pe timp de noapte","B.  să corespundă condițiilor tehnice impuse și să fie omologate de către autoritatea competentă","C.  să nu fie folosite în mediul urban"},
        {"A. pe banda de lângă axul drumului","B. pe banda de lângă acostament sau bordură, dacă în sensul de mers nu este amenajată o bandă destinată acestora","C. pe oricare dintre benzi, dacă circulă cu viteza maximă admisă pe sectorul de drum respectiv"},
        {"A.vehiculul fără motor, destinat a fi tractat de un autovehicul sau de un tractor","B. un autovehicul care este tractat de un alt autovehicul","C. dispozitivul ce se atașeazã la partea din spate a unui vehicul, pentru a asigura remorcarea"},
        {"A.  opriți și vă asigurați, la 1 m de calea ferată","B. reduceți viteza și traversați cu atenție linia ferată","C. opriți în locul în care există vizibilitate maximă asupra căii ferate, fără a depăși indicatoarele menționate sau marcajul pentru oprire"},
        {"A. ferodourile sunt uzate","B. arcul de revenire a pedalei de ambreiaj este uzat","C. rulmentul de presiune este defect"},
        {"A. să completați lichidul de frână","B. să reglați cursa pedalei","C. să reparați instalația de frânare într-un atelier specializat"}

    
    };
    private int numarIntrebari;
    private int timpRamas;
    private List<Integer> intrebariNeraspunse;

    public ChestionareTr() {
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
                 boolean raspuns1Corect = intrebareCurenta ==0 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns2Corect = intrebareCurenta ==1 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns3Corect = intrebareCurenta ==2 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns4Corect = intrebareCurenta ==3 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns5Corect = intrebareCurenta ==4 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns6Corect = intrebareCurenta ==5 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns7Corect = intrebareCurenta ==6 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns8Corect = intrebareCurenta ==7 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns9Corect = intrebareCurenta ==8 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns10Corect = intrebareCurenta ==9 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns11Corect = intrebareCurenta ==10 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns12Corect = intrebareCurenta ==11 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns13Corect = intrebareCurenta ==12 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns14Corect = intrebareCurenta ==13 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns15Corect = intrebareCurenta ==14 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns16Corect = intrebareCurenta ==15 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns17Corect = intrebareCurenta ==16 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns18Corect = intrebareCurenta ==17 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns19Corect = intrebareCurenta ==18 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns20Corect = intrebareCurenta ==19 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns21Corect = intrebareCurenta ==20 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns22Corect = intrebareCurenta ==21 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns23Corect = intrebareCurenta ==22 && checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected();
                boolean raspuns24Corect = intrebareCurenta ==23 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns25Corect = intrebareCurenta ==24 && !checkBox1.isSelected() && !checkBox2.isSelected() && checkBox3.isSelected();
                boolean raspuns26Corect = intrebareCurenta ==25 && !checkBox1.isSelected() && checkBox2.isSelected() && !checkBox3.isSelected();


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
            JOptionPane.showMessageDialog(ChestionareTr.this, "Nu există întrebări disponibile.");
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
                new ChestionareTr();
            }
        });
    }
}
