package com.restaurante.proyecto.controllers;


import com.restaurante.proyecto.controllers.objetos.ObjetoPlato;
import com.restaurante.proyecto.models.dao.CategoriaRepository;
import com.restaurante.proyecto.models.dao.PlatoRepository;
import com.restaurante.proyecto.controllers.objetos.MenuRestaurante;
import com.restaurante.proyecto.models.entity.CategoriaEntity;
import com.restaurante.proyecto.models.entity.PlatoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
class PlatoController {
    @Autowired
    private PlatoRepository platoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/obtenerMenu")
    List<MenuRestaurante> obtenerMenu() {

        List<MenuRestaurante> menu = new ArrayList<>();

        List<CategoriaEntity> categorias = (List<CategoriaEntity>) categoriaRepository.findAll();

        for (CategoriaEntity categoria : categorias) {
            MenuRestaurante mnu = new MenuRestaurante();
            mnu.setIdCategoria(categoria.getCtgId());
            mnu.setDescripcionCategoria(categoria.getCtgDescripcion());

            List<PlatoEntity> platos = (List<PlatoEntity>) platoRepository.platoporCategoria(categoria);
            List<ObjetoPlato> platoList = new ArrayList<>();

            for (PlatoEntity plato : platos) {
                ObjetoPlato objetoPlato = new ObjetoPlato();

                objetoPlato.setId(plato.getPtlId());
                objetoPlato.setDescripcion(plato.getPtlDescripcion());
                objetoPlato.setPrecio(plato.getPtlPrecio());

                platoList.add(objetoPlato);
            }

            mnu.setPlatoList(platoList);
            menu.add(mnu);

        }
        return menu;
    }

}