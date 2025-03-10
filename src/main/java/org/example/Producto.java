package org.example;

public class Producto {

    private String _nombre;
    private int  _cantidad;
    private double _precio;

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public void set_precio(double _precio) {
        this._precio = _precio;
    }

    public void set_cantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public String get_nombre() {
        return _nombre;
    }

    public double get_precio() {
        return _precio;
    }

    public int get_cantidad() {
        return _cantidad;
    }

    public Producto(){

    }

    public Producto(String _nombre, double _precio, int _cantidad) {
        this._nombre = _nombre;
        this._precio = _precio;
        this._cantidad = _cantidad;
    }
//____________________________________________________________________
    public void Reponer(int _cantidad){
        this._cantidad = this._cantidad + _cantidad;
    }
    public void Vender(int _cantidad){
        this._cantidad = this._cantidad - _cantidad;
    }
    public void AplicarDescuento(){
        this._precio = this._precio - (this._precio * 0.02);
    }
    public String Informacion(){
        return "Nombre producto: " + this._nombre +
                "\n    Cantidad : " + this._cantidad +
                "\n    Precio : " + this._precio;
    }
    public void AumentarPrecio(double _porcentaje ){
        this._precio = this._precio+(this._precio * (_porcentaje / 100));
    }
    public double ValorTotal(){
        return this._precio * this._cantidad;
    }
    public void CompararPrecio(){

    }

}
