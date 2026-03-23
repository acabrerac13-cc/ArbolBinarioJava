/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbinarioorden;

import javax.swing.*;

public class InterfazArbol extends JFrame {

    // Componentes
    JTextField txtNumero;
    JTextArea txtResultado;
    JButton btnInsertar, btnInOrden, btnPreOrden, btnPostOrden;

    // Árbol
    ArbolBinario arbol = new ArbolBinario();

    public InterfazArbol() {
        setTitle("Árbol Binario");
        setSize(450, 350);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Campo de texto
        txtNumero = new JTextField();
        txtNumero.setBounds(30, 30, 100, 30);
        add(txtNumero);

        // Botón insertar
        btnInsertar = new JButton("Insertar");
        btnInsertar.setBounds(150, 30, 100, 30);
        add(btnInsertar);

        // Botones de recorrido
        btnInOrden = new JButton("InOrden");
        btnInOrden.setBounds(30, 80, 100, 30);
        add(btnInOrden);

        btnPreOrden = new JButton("PreOrden");
        btnPreOrden.setBounds(150, 80, 100, 30);
        add(btnPreOrden);

        btnPostOrden = new JButton("PostOrden");
        btnPostOrden.setBounds(270, 80, 120, 30);
        add(btnPostOrden);

        // Área de texto con scroll
        txtResultado = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtResultado);
        scroll.setBounds(30, 130, 360, 150);
        add(scroll);

        // EVENTO INSERTAR
        btnInsertar.addActionListener(e -> {
            try {
                int num = Integer.parseInt(txtNumero.getText());

                // Insertar en el árbol
                arbol.raiz = arbol.insertar(arbol.raiz, num);

                // Mostrar en pantalla
                txtResultado.append("Insertado: " + num + "\n");

                txtNumero.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
            }
        });

        // EVENTO INORDEN
        btnInOrden.addActionListener(e -> {
            txtResultado.setText("");
            mostrarInOrden(arbol.raiz);
        });

        // EVENTO PREORDEN
        btnPreOrden.addActionListener(e -> {
            txtResultado.setText("");
            mostrarPreOrden(arbol.raiz);
        });

        // EVENTO POSTORDEN
        btnPostOrden.addActionListener(e -> {
            txtResultado.setText("");
            mostrarPostOrden(arbol.raiz);
        });
    }

    // Métodos de recorrido
    private void mostrarInOrden(Nodo r) {
        if (r != null) {
            mostrarInOrden(r.izquierdo);
            txtResultado.append(r.dato + " ");
            mostrarInOrden(r.derecho);
        }
    }

    private void mostrarPreOrden(Nodo r) {
        if (r != null) {
            txtResultado.append(r.dato + " ");
            mostrarPreOrden(r.izquierdo);
            mostrarPreOrden(r.derecho);
        }
    }

    private void mostrarPostOrden(Nodo r) {
        if (r != null) {
            mostrarPostOrden(r.izquierdo);
            mostrarPostOrden(r.derecho);
            txtResultado.append(r.dato + " ");
        }
    }

    public static void main(String[] args) {
        new InterfazArbol().setVisible(true);
    }
}