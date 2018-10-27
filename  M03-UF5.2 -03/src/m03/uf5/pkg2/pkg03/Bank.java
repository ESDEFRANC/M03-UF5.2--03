/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.pkg2.pkg03;

/**
 *
 * @author usuario
 */
public class Bank {
    private String dni;
    private Double saldo;

    public Bank() {
    }

   
    
    public Bank(String dni, Double saldo) {
        this.dni = dni;
        this.saldo = saldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) throws SaldoInicialInsuficienteException {
        if(saldo<50){
            throw new SaldoInicialInsuficienteException("No se puede introducir salo inferior a 50");
        }else{
            System.out.println("Usurio registrado");
            this.saldo = saldo;
        }
        
    }
    public void extractSaldo(double extract) throws SaldoInsuficienteException{
        
        if(extract>saldo){
            extract=extract*100/10;
            System.out.println("Has gastado todo el saldo tienes en cuenta: " + extract);
            
        }else if(saldo<0){
            throw new SaldoInsuficienteException("No se puede extraer mas de lo que tienes");
        }
        
    }
    
    

    @Override
    public String toString() {
        return "Bank{" + "dni=" + dni + ", saldo=" + saldo + '}';
    }
    
    
    
}
