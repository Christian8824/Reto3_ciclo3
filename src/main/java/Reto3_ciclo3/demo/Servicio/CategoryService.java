/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_ciclo3.demo.Servicio;

import Reto3_ciclo3.demo.Modelo.Category;
import Reto3_ciclo3.demo.Repositorio.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christian
 */

@Service

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    //Importar Métodos del Repositorio
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category category){
        if (category.getId() == null){
            return categoryRepository.save(category);
        }else {
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if(category1.isEmpty()){
                return categoryRepository.save(category);
            }else {
                return category;
            }
        }
    }
    
}
