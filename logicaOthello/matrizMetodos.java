package logicaOthello;

public class matrizMetodos {
    // 0 - vacio
    // 1 - Negros
    // 2 - blancos
    // //private int[][] matrizLogica;
    private int SIZE;
    private boolean cambio;
    // private int player;
    // private boolean cambio = false;

    public matrizMetodos(){
        //matrizLogica = matriz;
        SIZE=8;
        cambio = false;
    }

    public int[][] movimiento(int[][]matrizLogica, int x, int y, int player){
        cambio = false;
        if(y<SIZE-2 && matrizLogica[x][y+1]!=player && matrizLogica[x][y+1]!=0 && matrizLogica[x][y]==0){
            mirarDerecha(matrizLogica, x, y, player);
        }
        if(y>1 && matrizLogica[x][y-1]!=player && matrizLogica[x][y-1]!=0 && matrizLogica[x][y]==0){
            mirarIzquierda(matrizLogica, x ,y, player);
        }
        if(x>1 && matrizLogica[x-1][y]!=player && matrizLogica[x-1][y]!=0 && matrizLogica[x][y]==0){
            mirarArriba(matrizLogica, x, y, player);
        }
        if(x<SIZE-2 && matrizLogica[x+1][y]!=player && matrizLogica[x+1][y]!=0 && matrizLogica[x][y]==0){
            mirarAbajo(matrizLogica, x ,y, player);
        }
        if(y<SIZE-2 && x>1 && matrizLogica[x-1][y+1]!=player && matrizLogica[x-1][y+1]!=0 && matrizLogica[x][y]==0){
            mirarDerechaArriba(matrizLogica, x, y, player);
        }
        if(x<SIZE-2 && y<SIZE-2 && matrizLogica[x+1][y+1]!=player && matrizLogica[x+1][y+1]!=0 && matrizLogica[x][y]==0){
            mirarDerechaAbajo(matrizLogica, x, y, player);
        }
        if(x>1 && y>1 && matrizLogica[x-1][y-1]!=player && matrizLogica[x-1][y-1]!=0 && matrizLogica[x][y]==0){
            mirarIzquierdaArriba(matrizLogica, x, y, player);
        }
        if(x<SIZE-2 && y>1 && matrizLogica[x+1][y-1]!=player && matrizLogica[x+1][y-1]!=0 && matrizLogica[x][y]==0){
            mirarIzquierdaAbajo(matrizLogica, x, y, player);
        }
        if(cambio){
            matrizLogica[x][y]=player;
            // if(player==2){
            //     player=1;
            // }else{
            //     player=2;
            // }
            imprimir(matrizLogica);
        }

        return matrizLogica;
    }

    public void mirarDerecha(int[][]matrizLogica, int x, int y, int player){
        boolean flag=false;
        for(int i=y+1;i<SIZE;i++){
            if(matrizLogica[x][i]==0){
                break;
            }
            if(matrizLogica[x][i]==player){
                flag = true;
                break;
            }
        }
        if(flag){
            for(int i=y+1;i<SIZE;i++){
                matrizLogica[x][i]=player;
                if(matrizLogica[x][i+1]==player){
                    break;
                }
            }
            cambio = true;
        }
    }

    public void mirarDerechaArriba(int[][]matrizLogica, int x, int y, int player){
        boolean flag=false;
        int x1 = x;
        int y1 = y;
        while(x1>0 && y1<7){
            x1-=1;
            y1+=1;
            if(matrizLogica[x1][y1]==0){
                break;
            }
            if(matrizLogica[x1][y1]==player){
                flag=true;
                break;
            }
        }
        if(flag){
            while(x>0 && y<7){
                x-=1;
                y+=1;
                matrizLogica[x][y]=player;
                if(matrizLogica[x-1][y+1]==player){
                    break;
                }
            }
            cambio = true;
        }
    }
   
    public void mirarIzquierda(int[][]matrizLogica, int x, int y, int player){
        boolean flag=false;
        for(int i=y-1;i>=0;i--){
            if(matrizLogica[x][i]==0){
                break;
            }
            if(matrizLogica[x][i]==player){
                flag = true;
                break;
            }
        }
        if(flag){
            for(int i=y-1;i>=0;i--){
                matrizLogica[x][i]=player;
                if(matrizLogica[x][i-1]==player){
                    break;
                }
            }
            cambio = true;
        }
    }

    public void mirarArriba(int[][]matrizLogica, int x, int y, int player){
        boolean flag=false;
        for(int i=x-1;i>=0;i--){
            if(matrizLogica[i][y]==0){
                break;
            }
            if(matrizLogica[i][y]==player){
                flag = true;
                break;
            }
        }
        if(flag){
            for(int i=x-1;i>=0;i--){
                matrizLogica[i][y]=player;
                if(matrizLogica[i-1][y]==player){
                    break;
                }
            }
            cambio = true;
        }
    }

    public void mirarAbajo(int[][]matrizLogica, int x, int y, int player){
        boolean flag=false;
        for(int i=x+1;i<SIZE;i++){
            if(matrizLogica[i][y]==0){
                break;
            }
            if(matrizLogica[i][y]==player){
                flag = true;
                break;
            }
        }
        if(flag){
            for(int i=x+1;i<SIZE;i++){
                matrizLogica[i][y]=player;
                if(matrizLogica[i+1][y]==player){
                    break;
                }
            }
            cambio = true;
        }
    }

    public void mirarDerechaAbajo(int[][]matrizLogica, int x, int y, int player){
        boolean flag=false;
        int x1 = x;
        int y1 = y;
        while(x1<7 && y1<7){
            x1+=1;
            y1+=1;
            if(matrizLogica[x1][y1]==0){
                break;
            }
            if(matrizLogica[x1][y1]==player){
                flag=true;
                break;
            }
        }
        if(flag){
            while(x<7 && y<7){
                x+=1;
                y+=1;
                matrizLogica[x][y]=player;
                if(matrizLogica[x+1][y+1]==player){
                    break;
                }
            }
            cambio = true;
        }
    }
    
    public void mirarIzquierdaArriba(int[][]matrizLogica, int x, int y, int player){
        boolean flag=false;
        int x1 = x;
        int y1 = y;
        while(x1>0 && y1>0){
            x1-=1;
            y1-=1;
            if(matrizLogica[x1][y1]==0){
                break;
            }
            if(matrizLogica[x1][y1]==player){
                flag=true;
                break;
            }
        }
        if(flag){
            while(x>0 && y>0){
                x-=1;
                y-=1;
                matrizLogica[x][y]=player;
                if(matrizLogica[x-1][y-1]==player){
                    break;
                }
            }
            cambio = true;
        }
    }
    
    public void mirarIzquierdaAbajo(int[][]matrizLogica, int x, int y, int player){
        boolean flag=false;
        int x1 = x;
        int y1 = y;
        while(x1<7 && y1>0){
            x1+=1;
            y1-=1;
            if(matrizLogica[x1][y1]==0){
                break;
            }
            if(matrizLogica[x1][y1]==player){
                flag=true;
                break;
            }
        }
        if(flag){
            while(x<7 && y>0){
                x+=1;
                y-=1;
                matrizLogica[x][y]=player;
                if(matrizLogica[x+1][y-1]==player){
                    break;
                }
            }
            cambio = true;
        }
    }


    public void imprimir(int[][]matrizLogica){
        System.out.println("-------------------");
        System.out.println("0|1|2|3|4|5|6|7");
        for(int x=0; x<SIZE;x++){
            for(int y=0; y<SIZE;y++){
                System.out.print(matrizLogica[x][y]+" ");
            }
            System.out.print("|" + x);
            System.out.println();
        }
    }


}

