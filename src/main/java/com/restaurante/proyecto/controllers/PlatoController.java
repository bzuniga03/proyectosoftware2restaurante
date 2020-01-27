package com.restaurante.proyecto.controllers;


import com.restaurante.proyecto.models.dao.CategoriaRepository;
import com.restaurante.proyecto.models.dao.PlatoRepository;
import com.restaurante.proyecto.models.entity.Categoria;
import com.restaurante.proyecto.controllers.objetos.MenuRestaurante;
import com.restaurante.proyecto.models.entity.Plato;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
class PlatoController {
    private final PlatoRepository platoRepository;
    private final CategoriaRepository categoriaRepository;


    @GetMapping("/obtenerMenu")
    List<MenuRestaurante> obtenerMenu() {

        List<MenuRestaurante> menu = new ArrayList<>();

        List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();

        for (Categoria categoria : categorias) {
            MenuRestaurante mnu = new MenuRestaurante();
            mnu.setIdCategoria(categoria.getCtg_id());
            mnu.setDescripcionCategoria(categoria.getCtg_descripcion());

            List<Plato> platos = (List<Plato>) platoRepository.findAll();

            mnu.setPlatoList(platos);

        }
        return menu;
    }

    PlatoController(PlatoRepository platoRepository, CategoriaRepository categoriaRepository) {
        this.platoRepository = platoRepository;
        this.categoriaRepository = categoriaRepository;
    }

}