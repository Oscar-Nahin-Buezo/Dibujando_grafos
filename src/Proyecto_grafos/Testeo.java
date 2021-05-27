/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto_grafos;

/**
 *
 * @author Nahin
 */
public class Testeo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo frame = new Grafo();

	frame.setSize(400,300);
	
	frame.setVisible(true);

	frame.addVertice("a", 50,50);
	frame.addVertice("b", 100,100);
	frame.addVertice("longVertice", 200,200);
	frame.addEdge(0,1,3, "a","b");
	frame.addEdge(0,2,4, "a","longVertice");
    }
    
}
