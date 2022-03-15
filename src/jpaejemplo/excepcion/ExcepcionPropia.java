package jpaejemplo.excepcion;


public class ExcepcionPropia extends Exception{

    public ExcepcionPropia() {
    }
    
    public ExcepcionPropia(String msg) {
        super(msg);
    }
}
