
package Preceptron;

import java.util.Random;

public class PreceptronXOR{
    public static void main(String args[]){

//Arreglo de valores XOR

    double [][] arregloXOR = {
                    {1, 1, 0},
                    {1, 0, 1},
                    {0, 1, 1},
                    {0, 0, 0}

                };

        //Pesos Aleatorios
        double w1X1;
        double w2X1;
        double w1X2;
        double w2X2;
        double w1Y1;
        double w1Y2;
        double wBias1;
        double wBias2;
        double wBias3;
        
        double factorAprendizaje=0.5;
        
        double errorDelta3=0;
        double errorDelta1=0;
        double errorDelta2=0;
        double y1=0;
        double y2=0;
        double y3=0;
        int fila=0;
        int iteraciones=1;
        
        while(fila<=3){
            y1=0;y2=0;y3=0;errorDelta3=0;errorDelta1=0;errorDelta2=0;iteraciones=0;
            
            w1X1 = new Random().nextDouble();
            w2X1 = new Random().nextDouble();
            w1X2 = new Random().nextDouble();
            w2X2 = new Random().nextDouble();
            w1Y1 = new Random().nextDouble();
            w1Y2 = new Random().nextDouble();
            wBias1 = new Random().nextDouble();
            wBias2 = new Random().nextDouble();
            wBias3 = new Random().nextDouble();
            while (iteraciones<=100000){
                // HACIA ADELANTE
                //Calcula la salida de las neuronas de la capa oculta
                y1 = (arregloXOR[fila][0]*w1X1) + (arregloXOR[fila][1]*w1X2)+(1*wBias1);
                y2 = (arregloXOR[fila][0]*w2X1) + (arregloXOR[fila][1]*w2X2)+(1*wBias2);
                
                //Implementa la funcion de activacion Sigmoide
                y1= 1.0/(1+Math.pow(Math.E, (-1)*y1));
                y2= 1.0/(1+Math.pow(Math.E, (-1)*y2));
                
                //Calcula la salida
                y3=(y1*w1Y1)+(y2*w1Y2)+(1*wBias3);
                //implementa la funcion
                y3=1.0/(1 + Math.pow(Math.E,(-1)*y3));
                
                //HACIA ATRAS
                errorDelta3=(y3*(1-y3))*(arregloXOR[fila][2]-y3);
                
                //Ajusta los pesos de la neurona de salida
                w1Y1 = w1Y1 + (factorAprendizaje*errorDelta3*y1);
                w1Y2 = w1Y2 + (factorAprendizaje*errorDelta3*y2);
                wBias3 = wBias3+(errorDelta3);
                
                //Calcula error de capa oculta
                errorDelta1=(y1*(1-y1))*errorDelta3-w1Y1;
                errorDelta2=(y2*(1-y2))*errorDelta3-w1Y2;
                
                //neurona1
                w1X1 = w1X1 + (factorAprendizaje*errorDelta1*arregloXOR[fila][0]);
                w1X2 = w1X2 + (factorAprendizaje*errorDelta1*arregloXOR[fila][1]);
                wBias1=wBias1+errorDelta1;
                
                //neurona2
                w2X1 = w2X1 + (factorAprendizaje*errorDelta2*arregloXOR[fila][0]);
                w2X2 = w2X2 + (factorAprendizaje*errorDelta2*arregloXOR[fila][1]);
                wBias2=wBias2+errorDelta2;
                iteraciones++;
                
          
            }
            System.out.println(""+(int)arregloXOR[fila][0]+"\tXOR\t"+(int)arregloXOR[fila][1]+"\t=\t"+(int)arregloXOR[fila][2]+"\tResultado de la red: "+y3);
            fila++;
        }
        
        
        
    }
}
