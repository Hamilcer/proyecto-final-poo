
package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import logicaOthello.logicaOthello;
import logicaOthello.maquinaRica;

import java.awt.*;
import java.awt.event.*;

public class interfazOthello extends JFrame {
    
    private JPanel panelOthello;
    private int SIZE = 8;
    private JButton[][] matrizInterfaz;
    private int modo;
    private boolean fin = true;

    private logicaOthello matrizLogica;
    private maquinaRica matrizLogicaMaquina;

    public interfazOthello(int modo){
        this.modo = modo;
        if(modo==1){
            matrizLogica = new logicaOthello();
        }else if(modo==2){
            matrizLogicaMaquina = new maquinaRica();
        }
        initFrame();
        initPanel();
        getContentPane().add(panelOthello, BorderLayout.CENTER);
        actionListener();
    }

    private void initFrame(){
        setTitle("Othello");
        setMinimumSize(new DimensionUIResource(400, 400));
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initPanel(){
        panelOthello = new JPanel();
        panelOthello.setLayout(new GridLayout(SIZE,SIZE));
        
        matrizInterfaz = new JButton[SIZE][SIZE];

        for(int i = 0;i < SIZE; i++){
          for(int j = 0; j < SIZE;j++){
              matrizInterfaz[i][j] = new JButton();
            
              panelOthello.add(matrizInterfaz[i][j]);
              matrizInterfaz[i][j].setBackground(Color.PINK);
          }
        }
        matrizInterfaz[3][3].setBackground(Color.BLACK);
        matrizInterfaz[3][4].setBackground(Color.WHITE);
        matrizInterfaz[4][3].setBackground(Color.WHITE);
        matrizInterfaz[4][4].setBackground(Color.BLACK);
    }

    private void actionListener(){
        ActionListener evento = new ActionListener(){
            public void actionPerformed(ActionEvent event){
                for(int i=0; i<SIZE; i++){
                    for(int j=0; j<SIZE; j++){
                        if(event.getSource() == matrizInterfaz[i][j]){
                            if(modo==1){
                                fin = matrizLogica.jugar(i, j);
                                update(matrizLogica.getMatriz());
                            }else if(modo==2){
                                fin = matrizLogicaMaquina.jugar(i, j);
                                update(matrizLogicaMaquina.getMatriz());
                            }
                            if(!fin){
                                determinarGanador();
                            }
                        }
                    }
                }
            }
        };

        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                matrizInterfaz[i][j].addActionListener(evento);
            }
        }
    }

    public void update(int matrizLogica[][]){
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
               if(matrizLogica[i][j]==2){
                   matrizInterfaz[i][j].setBackground(Color.WHITE);
               }else if(matrizLogica[i][j]==1){
                   matrizInterfaz[i][j].setBackground(Color.BLACK);
               }
            }
        }
    }

    public void determinarGanador (){
        if (modo == 1){
            new Ganador(matrizLogica.determinar()).setVisible(true);
        } else if (modo ==2){
            new Ganador(matrizLogicaMaquina.determinar()).setVisible(true);
        }   
    }
}