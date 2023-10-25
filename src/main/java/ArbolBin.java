import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class ArbolBin {
    Nodo root;

    public ArbolBin(){
        root=null;
    }

    public ArbolBin(int val){
        root=new Nodo(val);
    }

    public ArbolBin(Nodo root){
        this.root=root;
    }

    public void add(Nodo padre, Nodo hijo, int lado){
        if(lado==0)
            padre.setIzq(hijo);
        else
            padre.setDer(hijo);
    }

    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
    }

    public void breadthFrist(){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList<>();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = queue.poll();
                visit(r);
                if(r.izq!=null)
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
            }
        }
    }

    //elimina un nodo del arbol reemplaza con cualquiera de sus hijos, el objetivo es que no se pierdan los subárboles del nodo eliminado
    public void delete(Nodo n){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList<>();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = queue.poll();
                if(r.izq==n){
                    r.izq=null;
                    return;
                }
                if(r.der==n){
                    r.der=null;
                    return;
                }
                if(r.izq!=null)
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
            }
        }
    }

    //busqueda de un nodo en el arbol y retornar true si se encuentra, false en caso contrario, se usa el recorrido en anchura
    public boolean search(Nodo n){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList<>();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = queue.poll();
                if(r==n)
                    return true;
                if(r.izq!=null)
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
            }
        }
        return false;
    }

    //operaciones de arbol binario
    //recorrido del arbol por preorden
    public void preOrden(Nodo n){
        if(n!=null){
            visit(n);
            preOrden(n.izq);
            preOrden(n.der);
        }
    }
    //recorrido del arbol por inorden
    public void inOrden(Nodo n){
        if(n!=null){
            inOrden(n.izq);
            visit(n);
            inOrden(n.der);
        }
    }
    //recorrido del arbol por postorden
    public void postOrden(Nodo n){
        if(n!=null){
            postOrden(n.izq);
            postOrden(n.der);
            visit(n);
        }
    }
}