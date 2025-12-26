/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao.Daos;

import java.util.List;

/**
 *
 * @author HugoJB
 */
public interface DaoInterface <T>{

    /**
     * Inserta un nuevo registro en la base de datos.
     *
     * @param dato objeto que contiene los datos a insertar
     */
    void insert(T dato) ;

    /**
     * Obtiene un único registro a partir de su identificador.
     *
     * @param id identificador único del registro
     * @return objeto encontrado o null si no existe
     */
    T fetchOne(int id);

    /**
     * Recupera todos los registros de la tabla asociada.
     *
     * @return lista con todos los objetos encontrados (puede estar vacía)
     */
    List<T> fetchAll();

    /**
     * Actualiza un registro existente en la base de datos.
     *
     * @param dato objeto con los nuevos valores a actualizar
     */
    void update(T dato);

    /**
     * Elimina un registro de la base de datos según su identificador.
     *
     * @param id identificador del registro a eliminar
     */
    void delete(int id) ;
}
