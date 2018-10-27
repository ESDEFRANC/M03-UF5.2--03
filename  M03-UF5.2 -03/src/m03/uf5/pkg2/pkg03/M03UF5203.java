/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.pkg2.pkg03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author usuario
 */
public class M03UF5203 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, SaldoInicialInsuficienteException {
        // TODO code application logic here

        ArrayList<Bank> usuarios = new ArrayList<Bank>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Bank b = new Bank("12345678A", 70.56);
        Bank b1 = new Bank("12345679B", 100.00);
        Bank b2 = new Bank("12345677C", 55.00);
        usuarios.add(b);
        usuarios.add(b1);
        usuarios.add(b2);
        int menu = 0;

        String cadena;

        System.out.println(usuarios);
        while (menu != 4) {
            System.out.println("1. Abrir cuenta bancaria");
            System.out.println("2. Consultar saldo cuenta bancaria");
            System.out.println("3. Extraer dinero cuenta bancaria");
            System.out.println("4. Ingresar dinero cuenta bancaria");
            System.out.println("5. Listar clientes");
            System.out.println("6. Salir");
            cadena = br.readLine();
            menu = Integer.parseInt(cadena);

            switch (menu) {

                case 1:

                    System.out.println("1. Cargar datos de inicio");
                    boolean dniOk = false;
                    while (!dniOk) {
                        System.out.println("Introduce dni");
                        String dni = br.readLine();
                        if (!validar(dni)) {
                            System.out.println("Dni mal introducido");

                        } else {
                     
                  
                            dniOk = true;
                            boolean trovat = false;
                            Bank bankAux = new Bank();
                            Bank bankDef = new Bank();
                            for (int i = 0; i < usuarios.size(); i++) {
                                bankAux = usuarios.get(i);
                                if (bankAux.getDni().contains(dni)) {
                                    System.out.println("El cliente ya esta registrado");
                                    trovat = true;

                                    bankDef = bankAux;
                                }
                            }

                            if (trovat) {
                                System.out.println(bankDef.toString());
                            } else {
                                System.out.println("Introduce diero en tu cuenta:");
                                cadena = br.readLine();
                                double dinero = Double.parseDouble(cadena);
                                bankDef.setSaldo(dinero);

                                    Bank banco = new Bank(dni, dinero);
                                    usuarios.add(banco);
                                    System.out.println(usuarios);
                                

                            }
                        }
                    }
                        
                    

                    break;

                case 2:
                    System.out.println("2. Listar peliculas ordenadas por n de votos");
                    //ordenarVotos(peliculas);
                    break;
                case 3:
                    System.out.println("3. Listar peliculas ordenadas por genero");

                    //ordenar4(peliculas);
                    break;
                case 4:
                    System.out.println("Adios");
                    break;
            }

        }

    }

    public static boolean validar(String dni) {

        String letra = "";
        if (dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) {
            return false;
        }
        letra = (dni.substring(8).toUpperCase());
        if (numDNI(dni) == true) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean numDNI(String dni) {
        String miDni = "";
        String num = "";
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < dni.length() - 1; i++) {
            num = dni.substring(i, i + 1);
            for (int j = 0; j < 10; j++) {
                if (num.equals(numeros[j])) {
                    miDni += numeros[j];
                }
            }
        }
        if (miDni.length() != 8) {
            return false;
        } else {
            return true;
        }
    }

        /*ublic static Genero getGeneros(String genero){
        Genero gen = null;
        if(genero.equals("aventura")){
              gen = Genero.AVENTURA;
             return gen;
         } else if(genero.equals("terror")){
              gen = Genero.TERROR;
             return gen;
         }else if(genero.equals("cienciaficcion")){
              gen = Genero.CIENCIAFICCION;
             return gen;
         }else if(genero.equals("infantil")){
              gen = Genero.INFANTIL;
             return gen;
    }
        
         return gen;
        
        
    }
    public static ArrayList<Peliculas> ordenarVotos(ArrayList<Peliculas> peliculas){
        
        Collections.sort(peliculas);
                    for (Peliculas pel : peliculas) {
                        System.out.println("Titulo: " + pel.getTitulo() + ", numero votos: " + pel.getVotos());
                    }
                    return peliculas;
    }
      public static ArrayList<Peliculas> ordenar4(ArrayList<Peliculas> peliculas){
        
        Collections.sort(peliculas, new Comparator<Peliculas>() {
            @Override
            public int compare(Peliculas obj1, Peliculas obj2) {

                 int num = obj1.getGenero().compareTo(obj2.getGenero());
                 switch(num){
                     case 1:
                         return -1;
                         
                     case 0:
                         if(obj1.getVotos() > obj2.getVotos()){
                             return -1;
                     }
                         return 1;
                     case -1:
                         return 1;
                     
                 }
                 
                 return num;
                
            }
        });
                      
        
                    for (Peliculas pel : peliculas) {
                        System.out.println("Genero: " + pel.getGenero()+ " Nombre peli: " +pel.getTitulo()+ ", numero votos: " + pel.getVotos());
                    }
                    return peliculas;
    }*/
    }
