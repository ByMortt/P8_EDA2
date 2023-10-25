/**
 *
 * @author Edgar
 */
public class Nodo {

    int valor;
    Nodo izq;
    Nodo der;

    public Nodo(){
        izq=der=null;
    }
    public Nodo(int data){
        this(data,null,null);
    }
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;
        izq = lt;
        der = rt;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    //insertar nodo en el arbol binario de busqueda
    public void insertar(int valor) {
        if(valor < this.valor){
            if(izq == null){
                izq = new Nodo(valor);
            }else{
                izq.insertar(valor);
            }
        }else{
            if(der == null){
                der = new Nodo(valor);
            }else{
                der.insertar(valor);
            }
        }
    }
}
