import java.util.Scanner;

public class Menu {
    //implementar funcion que se va a llamar menu, en donde se va a mostrar un menu con las opciones de arbol binario de busqueda y arbol binario
    /*
        OPCION ARBOL BINARIO DE BUSQUEDA
        1. crear arbol binario de busqueda
        2. insertar dato
        3. eliminar dato
        4. buscar dato
        5. imprimir arbol binario de busqueda (BFS)

        OPCION ARBOL BINARIO
        1. crear arbol binario
        2. insertar dato
        3. eliminar dato
        4. imprimir arbol binario (BFS)
        5. recorridos
            5.1 preorden
            5.2 inorden
            5.3 postorden
     */
    public void menu(){
        do {
            System.out.println("Menu");
            System.out.println("1. Arbol binario de busqueda");
            System.out.println("2. Arbol binario");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opcion");
            int opcion;
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    menuArbolBinBusqueda();
                    break;
                case 2:
                    menuArbolBin();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (true);
    }

    public void menuArbolBinBusqueda(){
        ArbolBinBusqueda abb = new ArbolBinBusqueda();
        int opcion;
        do {
            System.out.println("Menu arbol binario de busqueda");
            System.out.println("1. Crear arbol binario de busqueda");
            System.out.println("2. Insertar dato");
            System.out.println("3. Eliminar dato");
            System.out.println("4. Buscar dato");
            System.out.println("5. Imprimir arbol binario de busqueda (BFS)");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    //crear arbol binario de busqueda de la clase ArbolBinBusqueda
                    System.out.println("Cuantos datos desea insertar?");
                    int n1 = sc.nextInt();
                    for(int i=0;i<n1;i++){
                        System.out.println("Ingrese el dato a insertar");
                        int dato = sc.nextInt();
                        abb.insertar(dato);
                    }
                    abb.imprimirGrafico();
                    break;
                case 2:
                    //insertar dato en el arbol binario de busqueda
                    System.out.println("Cuantos datos desea insertar?");
                    int n = sc.nextInt();
                    for(int i=0;i<n;i++){
                        System.out.println("Ingrese el dato a insertar");
                        int dato = sc.nextInt();
                        abb.insertar(dato);
                    }
                    break;
                case 3:
                    //eliminar dato del arbol binario de busqueda
                    System.out.println("Ingrese el dato a eliminar");
                    int dato = sc.nextInt();
                    abb.eliminar(dato);
                    break;
                case 4:
                    //buscar dato
                    System.out.println("Ingrese el dato a buscar");
                    int dato1 = sc.nextInt();
                    if(abb.buscar(dato1))
                        System.out.println("Nodo encontrado");
                    else
                        System.out.println("Nodo no encontrado");
                    break;
                case 5:
                    //imprimir arbol binario de busqueda (BFS)
                    abb.BFS();
                    break;
                case 6:
                    menu();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (opcion!=6);
    }

    public void menuArbolBin(){
        int opcion;
        ArbolBin arbol = new ArbolBin();
        do {
            System.out.println("Menu arbol binario");
            System.out.println("1. Crear arbol binario");
            System.out.println("2. Insertar dato");
            System.out.println("3. Eliminar dato");
            System.out.println("4. Imprimir arbol binario (BFS)");
            System.out.println("5. Recorridos");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            new ArbolBin();
            switch (opcion){
                case 1:
                    //crear arbol binario de la clase ArbolBin; toma en cuenta que no se debe usar el método insertar de la clase Nodo, ya que corresponde a un arbol binario de busqueda. Por otra parte considera el código de la clase Prueba para crear el arbol binario
                    System.out.println("Ingrese el nodo raiz");
                    int datoRaiz = sc.nextInt();
                    arbol = new ArbolBin(datoRaiz);
                    System.out.println("Cuantos nodos va a tener el arbol?");
                    int n = sc.nextInt();
                    for(int i=0;i<n;i++){
                        System.out.println("Ingrese el nodo padre");
                        int datoPadre = sc.nextInt();
                        System.out.println("Ingrese el nodo hijo");
                        int datoHijo = sc.nextInt();
                        System.out.println("Ingrese el lado del nodo hijo (0 izquierda, 1 derecha)");
                        int lado = sc.nextInt();
                        Nodo padre = new Nodo(datoPadre);
                        Nodo hijo = new Nodo(datoHijo);
                        arbol.add(padre,hijo,lado);
                    }
                    break;
                case 2:
                    //insertar dato en el arbol binario
                    System.out.println("Ingrese el nodo a insertar");
                    int dato = sc.nextInt();
                    System.out.println("Ingrese el nodo padre");
                    int datoPadre = sc.nextInt();
                    System.out.println("Ingrese el lado del nodo hijo (0 izquierda, 1 derecha)");
                    int lado = sc.nextInt();
                    Nodo padre = new Nodo(datoPadre);
                    Nodo hijo = new Nodo(dato);
                    arbol.add(padre,hijo,lado);
                    break;
                case 3:
                    //eliminar dato
                    System.out.println("Ingrese el nodo a eliminar");
                    int dato1 = sc.nextInt();
                    Nodo j = new Nodo(dato1);
                    arbol.delete(j);
                    break;
                case 4:
                    //imprimir arbol binario (BFS)
                    arbol.breadthFrist();
                    break;
                case 5:
                    menuRecorridos(arbol);
                    break;
                case 6:
                    menu();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (opcion!=6);
    }

    public void menuRecorridos(ArbolBin arbol){
        int opcion;
        do {
            System.out.println("Menu recorridos");
            System.out.println("1. Preorden");
            System.out.println("2. Inorden");
            System.out.println("3. Postorden");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    //preorden del arbol binario
                    System.out.println("Recorrido por preorden");
                    arbol.preOrden(arbol.root);
                    break;
                case 2:
                    //inorden
                    System.out.println("Recorrido por inorden");
                    arbol.inOrden(arbol.root);
                    break;
                case 3:
                    //postorden
                    System.out.println("Recorrido por postorden");
                    arbol.postOrden(arbol.root);
                    break;
                case 4:
                    menuArbolBin();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (opcion!=4);
    }
}