/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import bd.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author Ricardo
 */
public class Vehiculo {
    private int chasis,precio;
    private String marca,modelo,color,transmicion,stock;

    public Vehiculo() {
    }

    public Vehiculo(int chasis, int precio, String marca, String modelo, String color, String transmicion, String stock) {
        this.chasis = chasis;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.transmicion = transmicion;
        this.stock = stock;
    }

    public int getChasis() {
        return chasis;
    }

    public void setChasis(int chasis) {
        this.chasis = chasis;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmicion() {
        return transmicion;
    }

    public void setTransmicion(String transmicion) {
        this.transmicion = transmicion;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "chasis=" + chasis + ", precio=" + precio + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", transmicion=" + transmicion + ", stock=" + stock + '}';
    }
    public void imprimir(){
        System.out.println(toString());
    }
    public void guardarVehiculo(){
       try {
           String strSQL = "insert into vehiculo values('"+chasis+"','"+marca+"','"+modelo+"','"+color+"','"+precio+"','"+transmicion+"','"+stock+"')";
           Conexion.conectar();
           Conexion.sentencia = Conexion.conn.prepareStatement(strSQL);
           Conexion.sentencia.execute(strSQL);
           System.out.println("Datos de Vehiculo Almacenados.");
           Conexion.desconectar();
       } catch (Exception e) {
           System.out.println("Error en el metodo guardar VEHICULO. WARNINGGGGGGGGG!!");
       }
   }
    public void cargarChasisVehiculo(){
        try {
            Conexion.buscarChasis = false;
            String strSQL = "select * from vehiculo where chasis = '"+chasis+"'";
            Conexion.conectar();
            Conexion.sentencia = Conexion.conn.prepareStatement(strSQL);
            ResultSet objRes = Conexion.sentencia.executeQuery(strSQL);
            //buscar en la base de datos. con ek ResultSet y el objeto objRes
            if (objRes.next()) { //En el IF es, ese objeto "objRes" tiene datos? (datos desde la base de datos..)
                Conexion.buscarChasis = true;
                //private int chasis,precio;
                //private String marca,modelo,color,transmicion,stock;
                marca = objRes.getString(2);
                modelo = objRes.getString(3);
                color = objRes.getString(4);
                transmicion = objRes.getString(6);
                stock = objRes.getString(7);
                chasis = Integer.parseInt(objRes.getString(1));
                precio = Integer.parseInt(objRes.getString(5));
                Conexion.desconectar();
                
                
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el Alumno.");
        }
    }
    public void actualizarVehiculo(){ //actualizar vehiculo con numero de chasis
        try {
            String strSQL = "update vehiculo set marca = '"+marca+"',modelo = "+modelo+",color = '"+color+"',transmicion = '"+transmicion+"',stock = '"+stock+"',chasis = "+chasis+", precio = "+precio+", where chasis = '"+chasis+"'";
            Conexion.conectar();
            Conexion.sentencia = Conexion.conn.prepareStatement(strSQL);
            Conexion.sentencia.execute(strSQL);
            System.out.println("Vehiculo Actualizado!");
        } catch (Exception e) {
            System.out.println("Falló el actualizar vehiculo.");
        }
    }
    public void eliminarVehiculo(){ //ELIMINAR VEHICULO POR NUMERO DE CHASIS
        try {
            String strSQL = "delete * from vehiculo where chasis = '"+chasis+"'";
            Conexion.conectar();
            Conexion.sentencia = Conexion.conn.prepareStatement(strSQL);
            Conexion.sentencia.execute(strSQL);
            System.out.println("VEHICULO Eliminado.!");
        } catch (Exception e) {
            System.out.println("Falló el Eliminar Vehiculo.");
        }
    }
    
}
