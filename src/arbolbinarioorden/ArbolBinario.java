/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbinarioorden;

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Insertar (tipo ABB)
    public Nodo insertar(Nodo raiz, int dato) {
        if (raiz == null) {
            return new Nodo(dato);
        }

        if (dato < raiz.dato) {
            raiz.izquierdo = insertar(raiz.izquierdo, dato);
        } else {
            raiz.derecho = insertar(raiz.derecho, dato);
        }

        return raiz;
    }

    // InOrden
    public void inOrden(Nodo raiz) {
        if (raiz != null) {
            inOrden(raiz.izquierdo);
            System.out.print(raiz.dato + " ");
            inOrden(raiz.derecho);
        }
    }

    // PreOrden
    public void preOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato + " ");
            preOrden(raiz.izquierdo);
            preOrden(raiz.derecho);
        }
    }

    // PostOrden
    public void postOrden(Nodo raiz) {
        if (raiz != null) {
            postOrden(raiz.izquierdo);
            postOrden(raiz.derecho);
            System.out.print(raiz.dato + " ");
        }
    }
}