/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Nahin
 */
public class Grafo extends javax.swing.JFrame {

    int width;
    int height;

    ArrayList<Vertice> nodes;
    ArrayList<edge> edges;

    /**
     * Creates new form Dibujar_grafo
     */
    public Grafo() {
        nodes = new ArrayList<Vertice>();
        edges = new ArrayList<edge>();
        width = 30;
        height = 30;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setTitle("Grafo");
        setMinimumSize(new java.awt.Dimension(1000, 1000));
        setName("grafo"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1130, 1000));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    class Vertice {

        int x, y;
        String name;

        public Vertice(String myName, int myX, int myY) {
            x = myX;
            y = myY;
            name = myName;
        }
        public String getName (){
            return name;
        }
    }

    class edge {

        //i y j son posiciones en el arraylist de nodos
        int i, j, peso, posicionX, posicionY;
        String verticeA, verticeB, pesoArista;

        public edge(int ii, int jj, int pesoo, String a, String b, int posX, int posY) {
            i = ii;
            j = jj;
            peso = pesoo;
            verticeA = a;
            verticeB = b;
            posicionX=posX;
            posicionY=posY;
        }
        public String getVerticeA(){
            return verticeA;
        }
        public String getVerticeB(){
            return verticeB;
        }
       
    }

    public void addVertice(String name, int x, int y) {
        //add a node at pixel (x,y)
        boolean existe = false;
        for (Vertice n : nodes) {
            if (n.name.equalsIgnoreCase(name)) {
                existe = true;
            }
            if (n.x == x && n.y == y) {
                existe = true;
            }
        }

        if (existe) {
            JOptionPane.showMessageDialog(rootPane, "Ya existe este vertice, prueba con otros valores");
        } else {
            nodes.add(new Vertice(name, x, y));
            this.repaint();
        }

    }

    public ArrayList<Vertice> getVertices() {
        return nodes;
    }
    
    public ArrayList<edge> getEdges() {
        return edges;
    }
    

    public void addEdge(int i, int j, int peso, String a, String b) {
        //add an edge between nodes i and j
        Vertice uno = nodes.get(i);
        Vertice dos = nodes.get(j);
        int posx = (uno.x + dos.x) / 2;
        int posy = (uno.y + dos.y) / 2;
        edges.add(new edge(i, j, peso, a, b, posx, posy));//agregue a y b como las etiquetas de los vertices
        this.repaint();
    }

    public void paint(Graphics g) { // draw the nodes and edges

        FontMetrics f = g.getFontMetrics();
        int nodeHeight = Math.max(height, f.getHeight());
        System.out.println("F height: " + f.getHeight());
        g.setColor(Color.black);
        for (edge e : edges) {
            String valor=String.valueOf(e.peso);
            g.drawLine(nodes.get(e.i).x, nodes.get(e.i).y,
                    nodes.get(e.j).x, nodes.get(e.j).y);
            g.drawString(valor, e.posicionX,
                    e.posicionY);
        }

        for (Vertice n : nodes) {
            int nodeWidth = Math.max(width, f.stringWidth(n.name) + width / 2);
            System.out.println("x: " + n.x);
            System.out.println("y: " + n.y);
            System.out.println("F stringwid: " + f.stringWidth(n.name));
            Random Rand = new Random();
            float r = Rand.nextFloat();
            float gg = Rand.nextFloat();
            float b = Rand.nextFloat();
            Color randomColor = new Color(r, gg, b);
            g.setColor(randomColor);
            g.fillOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2,
                    nodeWidth, nodeHeight);
            g.setColor(Color.black);
            g.drawOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2,
                    nodeWidth, nodeHeight);

            g.drawString(n.name, n.x - f.stringWidth(n.name) / 2,
                    n.y + f.getHeight() / 2);
            System.out.println("Posicion del vertice " + n.name + " X:" + (n.x - nodeWidth / 2) + " y:" + (n.y - nodeHeight / 2) + " nodeWith: " + nodeWidth + " nodeHeight: " + nodeHeight);
        }
    }

    public static void Dibujar_grafo(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
