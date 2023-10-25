import java.util.LinkedList;
import java.util.Queue;
public class ArbolBinBusqueda {
    //Crear un arbol binario de busqueda
    Nodo raiz;

    public ArbolBinBusqueda() {
        raiz = null;
    }

    public ArbolBinBusqueda(int valor) {
        raiz = new Nodo(valor);
    }

    public ArbolBinBusqueda(Nodo raiz) {
        this.raiz = raiz;
    }

    //metodo para insertar un nodo en el arbol: La forma más simple de inserción de claves en un árbol binario de búsqueda es realizarlo de acuerdo con el valor de la clave y recorriendo el árbol hasta ubicar su posición final
    public void insertar(int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
        } else {
            raiz.insertar(valor);
        }
    }

    //imprimir representación grafica de un árbol binario de búsqueda
    /*
   ejemplo:
                             5
                            /   \
                            3     7
                            / \   / \
                            2  4  6  8
     */
    public void imprimirGrafico() {
        imprimirGrafico(raiz, 0);
    }

    private void imprimirGrafico(Nodo raiz, int i) {
        if (raiz != null) {
            imprimirGrafico(raiz.der, i + 1);
            for (int j = 0; j < i; j++) {
                System.out.print("   ");
            }
            System.out.println(raiz.valor);
            imprimirGrafico(raiz.izq, i + 1);
        }
    }

    //eliminar un nodo del arbol binario de busqueda
    public void eliminar(int valor) {
        raiz = eliminar(raiz, valor);
    }

    private Nodo eliminar(Nodo raiz, int valor) {
        if (raiz == null) {
            return null;
        }
        if (valor < raiz.valor) {
            raiz.izq = eliminar(raiz.izq, valor);
        } else if (valor > raiz.valor) {
            raiz.der = eliminar(raiz.der, valor);
        } else {
            if (raiz.izq == null) {
                return raiz.der;
            } else if (raiz.der == null) {
                return raiz.izq;
            } else {
                raiz.valor = encontrarMin(raiz.der);
                raiz.der = eliminar(raiz.der, raiz.valor);
            }
        }
        return raiz;
    }

    private int encontrarMin(Nodo der) {
        if (der.izq != null) {
            return encontrarMin(der.izq);
        }
        return der.valor;
    }

    //buscar un nodo en el arbol binario de busqueda
    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(Nodo raiz, int valor) {
        if (raiz == null) {
            return false;
        }
        if (valor < raiz.valor) {
            return buscar(raiz.izq, valor);
        } else if (valor > raiz.valor) {
            return buscar(raiz.der, valor);
        } else {
            return true;
        }
    }

    //imprimir el arbol binario de busqueda mediante BFS
    //BFS
    public void BFS(){
        Queue<Nodo> queue = new LinkedList<>();
        queue.add(raiz);
        while(!queue.isEmpty()){
            Nodo nodo = queue.poll();
            System.out.print(nodo.valor + " ");
            if(nodo.izq != null){
                queue.add(nodo.izq);
            }
            if(nodo.der != null){
                queue.add(nodo.der);
            }
        }
    }
}