package logicaOthello;

public class logicaOthello {
    private matrizMetodos matrizMetodos;
    private comprobarMatriz comprobarMatriz;
    private int[][] matriz;
    private int SIZE = 8;
    private int player;
    private boolean seguir = true;
    
    public logicaOthello(){//boolean modo){

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

            boolean flag = false;
            for(int i=0; i<SIZE; i++){
                if(flag){
                    break;
                }
                for(int j=0; j<SIZE; j++){
                    if(matrizAux[i][j] != matriz[i][j]){
                        if(player==2){
                            player=1;
                        }else{
                            player=2;
                        }
                        flag = true;
                        if(flag){
                            break;
                        }
                    }
                }
            }
        }else if(!seguir){
            if(player==2){
                player=1;
            }else{
                player=2;
            }
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
        }
        if(!seguir){
            System.out.println("FIN");
            System.out.println(determinar());
        }

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

    

    