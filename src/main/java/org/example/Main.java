package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       int _opa, _opx;
       String _opp;
        Scanner _teclado = new Scanner(System.in);
        Producto _proBase = new Producto();
        List<Producto> _productos = new ArrayList<>();

        do {
            System.out.println("""
                     ###  TIENDA  ###
             Digite la opcion:
             
             1. Crear un producto
             2. Vender Producto
             3. Reponer Stocks
             4. Aplicar un Descuento (2%)
             5. Mostara Informacion
             6. Aumentar Precio
             7. Calcular valor Total Inventario
             8. Comparar Precios
             
               '0' Para salir:
             """);
            _opa = _teclado.nextInt();
            switch (_opa){
                case 1-> {

                    System.out.println("""
                            ##   CREAR PRODUCTO   ##
                            
                            Nombre del producto:
                            """);
                    String _nombre = _teclado.next();
                    System.out.println("Cantidad: ");
                    int _cantidad = _teclado.nextInt();
                    if (_cantidad > 0 ){
                        System.out.println("Precio del producto: ");
                        double _precio = _teclado.nextDouble();
                        if (_precio > 0){
                            _productos.add( new Producto(_nombre, _precio, _cantidad));
                            System.out.println("_______________ Producto: '" + _productos.getLast().get_nombre() +
                                    "' Ha sido creado con exito\n");
                        }else if (_precio == 0){
                        System.out.println("--- El precio no puede ser cero (0)");
                        } else if (_precio < 0){
                        System.out.println("--- El precio no puede ser negativa");
                        }
                    }else if (_cantidad == 0){
                        System.out.println("--- La cantidad no puede ser cero (0)");
                    }
                    else if (_cantidad < 0){
                        System.out.println("--- La cantidad no puede ser negativa");
                    }
                }
                case 2-> {
                    System.out.println("""
                            ##   VENDER PRODUCTOS   ##
                            Digite el producto a vender:
                            """);
                    System.out.println("  Nombre    Cantidad    Precio");
                    for (int i = 0; i < _productos.size(); i++){
                        System.out.println((i+1)+" "+_productos.get(i).get_nombre()+"     "+
                                _productos.get(i).get_cantidad()+"       "+
                                _productos.get(i).get_precio());
                    }
                    int id_producto = _teclado.nextInt();
                    id_producto = id_producto-1;
                    System.out.println("Producto: "+ _productos.get(id_producto).get_nombre() +
                            "\n¿ Cantidad a vender ?." +
                            " Cantidad en existencia: ("+ _productos.get(id_producto).get_cantidad()+"): " +
                            "");
                    int _cantidad = _teclado.nextInt();
                    if (_cantidad > 0){
                        if (_productos.get(id_producto).get_cantidad() >= _cantidad){
                            _productos.get(id_producto).Vender(_cantidad);
                            System.out.println("_________________ El producto se ha vendido con EXITO");
                        }else {
                            System.out.println("------------- No hay unidades Suficientes");
                        }
                    }else if (_cantidad == 0){
                        System.out.println("La cantidad de productos a vender no puede ser cero (0)");
                    }else if (_cantidad < 0 ){
                        System.out.println("La cantidad de productos a vender no puede ser negativa");
                    }
                }
                case 3-> {
                    System.out.println("""
                            ##   REPONER STOCKS   ##
                            Digite el producto a Reponer:
                            """);
                    System.out.println("  Nombre    Cantidad");
                    for (int i = 0; i < _productos.size(); i++){
                        System.out.println((i+1)+" "+_productos.get(i).get_nombre() +
                                "    "+_productos.get(i).get_cantidad());
                    }
                    int id_producto = _teclado.nextInt();
                    id_producto = id_producto - 1;
                    System.out.println("Producto: "+ _productos.get(id_producto).get_nombre() +
                            " Cantidad en existencia: ("+ _productos.get(id_producto).get_cantidad()+"): " +
                            "\nCantidad: ");
                    int _cantidad = _teclado.nextInt();
                    _productos.get(id_producto).Reponer(_cantidad);
                    System.out.println("_______________ Se han repuesto productos con EXITO");
                }
                case 4-> {
                    System.out.println("""
                            ##   APLICAR DESCUENTO A UN PRODUCTO   ##
                            Digite el producto:
                            """);
                    System.out.println("  Nombre    Precio");
                    for (int i = 0; i < _productos.size(); i++){
                        System.out.println((i+1)+" "+_productos.get(i).get_nombre() +
                                "    "+_productos.get(i).get_precio());
                    }
                    int id_producto = _teclado.nextInt();
                    id_producto = id_producto - 1;
                    _productos.get(id_producto).AplicarDescuento();
                    System.out.println("________________ Descuento aplicado con EXITO");

                }
                case 5-> {
                    System.out.println("Informacion de inventario");
                    for (int i = 0; i < _productos.size(); i++){
                        System.out.println((i+1) + " " +_productos.get(i).Informacion());
                    }
                    System.out.println("Digite cualquier letra para salir");
                    String _aceptar = _teclado.next();
                }
                case 6-> {
                    System.out.println("""
                            Aumentar precio de  Productos:
                            Digite el producto:
                            """);
                    for (int i = 0; i < _productos.size(); i++){
                        System.out.println((i+1)+" "+_productos.get(i).get_nombre() +
                                _productos.get(i).get_cantidad()+
                                _productos.get(i).get_precio());
                    }
                    int id_producto = _teclado.nextInt();
                    id_producto = id_producto - 1;
                    System.out.println("Producto: "+ _productos.get(id_producto).get_nombre() +
                            "\nEn cuando aumentara el precio, digitelo en porcentaje.");
                    double _porcentaje = _teclado.nextDouble();
                    _productos.get(id_producto).AumentarPrecio(_porcentaje);
                }
                case 7-> {
                    double _valortotal = 0;
                    System.out.println("""
                            Valor total inventario:
                            """);
                    for (int i = 0; i < _productos.size(); i++){
                        double _indiTotal = _productos.get(i).ValorTotal();

                        _valortotal = _indiTotal + _valortotal;

                    }
                    System.out.println("valor total: " + _valortotal);
                }
                case 8-> {
                    System.out.println("""
                            Comparar Productos:
                            Digite el producto:
                            """);
                    for (int i = 0; i < _productos.size(); i++){
                        System.out.println((i+1)+" "+_productos.get(i).get_nombre());
                    }
                    System.out.println("\nNuevo Producto: "+ _productos.getLast().get_nombre());
                    int id_productoA = _teclado.nextInt();
                    id_productoA = id_productoA -1 ;
                    System.out.println("""
                            Comparar Productos:
                            Digite el segundo producto:
                            """);
                    for (int i = 0; i < _productos.size(); i++){
                        System.out.println((i+1)+" "+_productos.get(i).get_nombre());
                    }
                    int id_productoB = _teclado.nextInt();
                    id_productoB = id_productoB -1 ;
                    if (_productos.get(id_productoA).get_precio() < _productos.get(id_productoB).get_precio()){
                        System.out.println("el producto: "+_productos.get(id_productoB).get_nombre()+
                                " es mas caro que el producto: "+_productos.get(id_productoA).get_nombre());
                    } else if (_productos.get(id_productoA).get_precio() > _productos.get(id_productoB).get_precio()){
                        System.out.println("el producto: "+_productos.get(id_productoA).get_nombre()+
                                " es mas caro que el producto: "+_productos.get(id_productoB).get_nombre());
                    }else if (_productos.get(id_productoA).get_precio() == _productos.get(id_productoB).get_precio()){
                        System.out.println("el producto: "+_productos.get(id_productoA).get_nombre()+
                                " tiene el mismo precio que el producto: "+_productos.get(id_productoB).get_nombre());
                    }
                }
                default -> System.out.println("salir");
            }
        } while (_opa != 0);
    }
}