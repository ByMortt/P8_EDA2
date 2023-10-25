/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class Prueba {

    public static void main(String[] args){
        ArbolBin arbol;

        Nodo n7 = new Nodo(7);
        Nodo n9 = new Nodo(9);
        Nodo n1 = new Nodo(1,n7,n9);
        Nodo n15 = new Nodo(15);
        Nodo n8 = new Nodo(8);
        Nodo n4 = new Nodo(4);
        Nodo n2 = new Nodo(2);
        Nodo n16 = new Nodo(16);
        Nodo n3 = new Nodo(3);

        arbol = new ArbolBin(n1);
        arbol.add(n7,n15,0);
        arbol.add(n7,n8,1);
        arbol.add(n9,n4,0);
        arbol.add(n9,n2,1);
        arbol.add(n15,n16,1);
        arbol.add(n8,n3,0);
        arbol.breadthFrist();

        System.out.println("Eliminando nodo 9");
        arbol.delete(n9);
        arbol.breadthFrist();

        //Buscando nodo 16
        System.out.println("Buscando nodo 16");
        boolean n = arbol.search(n16);
        if(n)
            System.out.println("Nodo encontrado: "+ n16.valor);
        else
            System.out.println("Nodo no encontrado");

        //Recorridos
        System.out.println("Recorridos");

        System.out.println("Recorrido por preorden");
        arbol.preOrden(arbol.root);
        System.out.println("Recorrido por inorden");
        arbol.inOrden(arbol.root);
        System.out.println("Recorrido por postorden");
        arbol.postOrden(arbol.root);
        //Arbol binario de busqueda
        System.out.println("Arbol binario de busqueda");
        ArbolBinBusqueda abb = new ArbolBinBusqueda();
        abb.insertar(5);
        abb.insertar(3);
        abb.insertar(7);
        abb.insertar(2);
        abb.insertar(4);
        abb.insertar(6);
        abb.insertar(8);
        System.out.println("Imprimir representación grafica de un árbol binario de búsqueda");
        abb.imprimirGrafico();
        System.out.println("BFS");
        abb.BFS();
        System.out.println("Eliminar nodo 3");
        abb.eliminar(3);
        abb.imprimirGrafico();
        System.out.println("Buscar nodo 6: ");
        if(abb.buscar(6))
            System.out.println("Nodo encontrado");
        else
            System.out.println("Nodo no encontrado");

        //Ejercicio 4: insertar de la clase menu el menu
        System.out.println("Ejercicio 4");
          Menu menu = new Menu();
            menu.menu();
    }
}
