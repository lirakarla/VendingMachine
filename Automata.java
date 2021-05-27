 /*
*********************************************************************************************************************************

Autor:Karla Lira  Matricula:526389
Fecha:28/11/20
Tarea: Miniproyecto_fase 1
Objetivo: Se realiza este programa para determinar si una cadena ingresada es aceptadao no aceptada, apartir de la expresión.
          AFD  a*b(bb)*   
          
 ******************************************************************************************************************************+
*/

//se importa la libreria de scanner
import java.util.Scanner;

//se crea la clase en donde estará nuestro programa
public class Automata{
   int count;
   boolean aceptado;
   char [] car;
   int valido1=1;
   int valido2=1;
   
   //este es el metodo principal en donde se hara llamada a los otros métodos y se realizará la impresión de los resultados.
   public static void main (String [] args){
       Scanner sc=new Scanner(System.in);
       System.out.println("\t  __________________________________________________________________________________________");
        System.out.println("\t |                                 IMPLEMENTACION DE AFD  a*b(bb)*                          | ");                       
        System.out.println("\t |__________________________________________________________________________________________| ");
        System.out.print("\n\t  Escribe tu cadena: ");
        String cadena=sc.nextLine();
        System.out.println("\n\t Proceso:"); 
        System.out.println(""); 
         Automata aut=new Automata();
         aut.car=cadena.toCharArray();
         aut.inicio();
         

     }
     
     //en este metodo declaras que se iniciara el proceso para revisar la cadena.
     public void inicio(){
     count=0;
     aceptado=false;
       q0();
       
       //se hace una condicion para saber si es valido o no la cadena despues de hacer el recorrido por los estados.
        if(valido1==1 || valido1==1 && valido2==1){
                System.out.println("");
                System.out.println("*****************************************");
                System.out.println("* RESULTADO: El automata es valido      *");
                System.out.println("*****************************************");
            }
          if(valido1==0){
                System.out.println("");
                System.out.println("*****************************************");
                System.out.println("* RESULTADO: El automata es invalido    *");
                 System.out.println("*****************************************");
               
            }
     }
     
     //el primer estado es el q0 y se revisará cuál es la letra insertada, ya que si es a se queda en este estado,
     // pero si la primer letra es b pasa al siguiente estado
     public void q0(){
         System.out.println("\t\tTe encuentras en el estado q0");
         if(count<car.length){
            if(car[count]=='a'){
               valido1=0;
               count++;
               q0();
            }else if(car[count]=='b'){
               valido1=1;
               count++;
               q1();
            }
         }
     }
     
     //este es el segundo estado en donde se verifica que si la segunda letra es b pasa al estado 2, pero si es a acaba aqui inidicando su invalides.
     //también si acaba en b sería una cadena no aceptada, ya que inidcaría que puede haber un número par de b.
     public void q1(){
     System.out.println("\t\tTe encuentras en el estado q1");
       if(count<car.length){ 
         aceptado=true;
            if(car[count]=='b'){
               valido1=0;
               count++;
               q2();
               
               }else if(car[count]=='a'){
               count++;
               qError();
                valido1=0;

             }
         }
       }
     
     //en este tercer estado se revisa si la b es numero impar se convierte en valido y tambien se verifica el estado de error.
     public void q2(){
     System.out.println("\t\tTe encuentras en el estado q2");
        if(count<car.length){
                    if(car[count]=='b'){
               valido1=1;
               count++;
               validacion();
               
                }else if(car[count]=='a'){
               count++;
               qError();
               valido1=0;

             }
         }
       }
       
       //en este validas cuantas veces se ha insertado la b para determinar si la cantidad de veces son impares de ser asi regresa al estado 0 dle caso contrario acaba el sistema.
        public void validacion(){
        if(count<car.length){
                    if(car[count]=='b'){
                     valido1=0;
                     count++;
                     q0();
               
                }else if(car[count]=='a'){
               count++;
               qError();
               valido2=0;

             }
         }
       }

    //el estado de error es cuando se inserta una cadena no valida
      public void qError(){
         System.out.println("Cadena no aceptada");
         
      }
     
     }