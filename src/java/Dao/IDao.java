/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 *
 * @author salah
 */
public interface IDao <S> {
    void create(S o);
    void delete(S o);
    void update(S o);
    List<S> findAll();
    S findById(int id);
}
