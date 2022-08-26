package logicaOthello;

public class maquinaRica {
    // Pintar
    private matrizMetodos matrizMetodos;
    // Comprobar
    private comprobarMatriz comprobarMatriz;
    private int[][] matriz;
    private int SIZE = 8;
    private int player;
    private boolean seguir = false;
    
    public maquinaRica(){

        matriz = new int[SIZE][SIZE];
        matriz[3][3] = 1;
        matriz[3][4] = 2;
        matriz[4][3] = 2;
        matriz[4][4] = 1;
        player = 2;

        matrizMetodos = new matrizMetodos();
        comprobarMatriz = new comprobarMatriz();
    }

    public boolean jugar(int x, int y){
        // validar movimientos blancos
        seguir = false;
        for(int i=0; i<SIZE; i++){
            if(seguir){
                break;
            }
            for(int j=0; j<SIZE; j++){
                seguir = comprobarMatriz.comprobar(matriz, i, j, player);
                if(seguir){
                    break;
                }
            }
        }
        
        if(seguir){
            int[][] matrizAux = clonar(matriz);
            matriz = matrizMetodos.movimiento(matriz, x, y, player);
            // mirar si el movimiento del usuario realizo algun cambio
            boolean flag = false;
            for(int i=0; i<SIZE; i++){
                if(flag){
                    break;
                }
                for(int j=0; j<SIZE; j++){
                    if(matrizAux[i][j] != matriz[i][j]){
                        flag = true;
                        if(flag){
                            jugarMaquinaRica(matriz);
                            break;
                        }
                    }
                }
            }
        }else if(!seguir){ // Si no hay movimientos para blancos entonces comprueba para negros y juega negros
            for(int i=0; i<SIZE; i++){
                if(seguir){
                    break;
                }
                for(int j=0; j<SIZE; j++){
                    seguir = comprobarMatriz.comprobar(matriz, i, j, 1);
                    if(seguir){
                        break;
                    }
                }
            }
            if(seguir){
                jugarMaquinaRica(matriz);
                System.out.println("AQUI TúPaPa");
            }

        }
        if(!seguir){
            for(int i=0; i<SIZE; i++){
                for(int j=0; j<SIZE; j++){

                }
            }
            System.out.println("FIN");
            System.out.println(determinar());
        }
////////
        // seguir = false;
        // for(int i=0; i<SIZE; i++){
        //     if(seguir){
        //         break;
        //     }
        //     for(int j=0; j<SIZE; j++){
        //         seguir = comprobarMatriz.comprobar(matriz, i, j, 1);
        //         if(seguir){
        //             break;
        //         }
        //     }
        // }
        // if(!seguir){
        //     jugarMaquinaRica(matriz);
        //     System.out.println("AQUI TúPaPa");
        // }
        
        ////

        // Ultima verificacion de movimientos para ambos jugadores
        for(int i=0; i<SIZE; i++){
            if(seguir){
                break;
            }
            for(int j=0; j<SIZE; j++){
                int playerAux = (player%2==0)?1:2;
                seguir = comprobarMatriz.comprobar(matriz, i, j, player);
                if(seguir){
                    break;
                }
                seguir = comprobarMatriz.comprobar(matriz, i, j, playerAux);
                if(seguir){
                    break;
                }
            }
        }
        return seguir;
    }

    public void jugarMaquinaRica(int[][] matriz){
        seguir=false;
        boolean flag = false;
        for(int i=0; i<SIZE; i++){
            if(flag){
                break;
            }
            for(int j=0; j<SIZE; j++){
                if(flag){
                    break;
                }
                
                // vuelte a validar si hay movimietnos disponibles
                for(int k=0; k<SIZE; k++){
                    if(seguir){
                        break;
                    }
                    for(int l=0; l<SIZE; l++){
                        seguir = comprobarMatriz.comprobar(matriz, k, l, 1);
                        if(seguir){
                            break;
                        }
                    }
                }
        
                
                if(seguir){
                    int[][] matrizAux2 = clonar(matriz);
                    matriz = matrizMetodos.movimiento(matriz, i, j, 1);
        
                    for(int k=0; k<SIZE; k++){
                        if(flag){
                            break;
                        }
                        for(int l=0; l<SIZE; l++){
                            if(matrizAux2[k][l] != matriz[k][l]){
                                System.out.println("(" + i + "," + j + ")");
                                flag = true;
                                if(flag){
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int[][] clonar(int[][] m){
        int[][] matrizClone = new int[8][8];
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                matrizClone[i][j] = m[i][j];
            }
        }
        return matrizClone;
    }
    
    public String determinar(){
        int uno = 0;
        int dos = 0;
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                if(matriz[i][j]==1){
                    uno+=1;
                }else if(matriz[i][j]==2){
                    dos+=1;
                }
            }
        }
         
        if(uno>dos){
            return "El ganador es negro";
        }else if(dos>uno){
            return "El ganador es blanco";
        }else{
            return "Hubó un empate";
        }
    }

    public int[][] getMatriz(){
        return matriz;
    }

    
}
