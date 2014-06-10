/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.unideb.inf.prt.levzh;

/**
 *
 * @author zbocskay
 */
public class NewClass {

    public static void main(String args[]) {


        Személy személy = new Személy("568", "sghs", "xfll", 8, "fdnf", Személy.Státusz.FELNŐTT);
        
        AtLeastTenCharsService dao = new AtLeastTenCharsServiceImpl(); 
        dao.correctAtLeastTenCharsMegsértések(személy); 
       // dao.getAtLeastTenCharstMegsértőAdattagok(személy);
        System.out.println(személy);

    }
}
