# proyectosoftware2restaurante

Link vista
https://pedidofacilito.herokuapp.com/greetings

Link aplicacion funcionando
https://proyectosoftware2restaurante.herokuapp.com/obtenerMenu

SCRIPT SQL
```sql
create table CATEGORIA
(
    CTG_ID          serial
        constraint CATEGORIA_pk
            primary key,
    CTG_DESCRIPCION varchar(200)
);

create table PLATO
(
    PTL_ID          serial
        constraint PLATO_pk
            primary key,
    PTL_DESCRIPCION varchar(200),
    PTL_PRECIO      double PRECISION,
    PTL_CATEGORIA   int not null,
    CONSTRAINT CATEGORIA_pk FOREIGN KEY (PTL_CATEGORIA)
        REFERENCES CATEGORIA (CTG_ID)
);
create table MESA
(
    MSA_ID          serial
        constraint MESA_pk
            primary key,
    MSA_DESCRIPCION varchar(200),
    MSA_ESTADO      CHARACTER default 'L'
);
create table PEDIDO
(
    PDD_ID         serial
        constraint PEDIDO_pk
            primary key,
    PDD_COMENTARIO varchar(200),
    PDD_ESTADO     CHARACTER default 'A',
    PDD_MESA       int
        constraint PEDIDO_PDD_MESA_MSA_ID_fk
            references MESA (MSA_ID)
);



create table DETALLE_PEDIDO
(
    DPD_ID     serial
        constraint DETALLE_PEDIDO_pk
            primary key,
    DPD_PEDIDO int
        constraint DETALLE_PEDIDO_PEDIDO_fk
            references PEDIDO (PDD_ID),
    DPD_PLATO  int
        constraint DETALLE_PEDIDO_PLATO_fk
            references PLATO (PTL_ID)
);


INSERT INTO public.greeting (id, message, price) VALUES (1, 'asd', 3);
INSERT INTO public.greeting (id, message, price) VALUES (2, 'sdf', 2);

INSERT INTO public.categoria (ctg_id, ctg_descripcion) VALUES (1, 'Plato fuerte');
INSERT INTO public.categoria (ctg_id, ctg_descripcion) VALUES (2, 'Picadas');
INSERT INTO public.categoria (ctg_id, ctg_descripcion) VALUES (3, 'Sopas');

INSERT INTO public.plato (ptl_id, ptl_descripcion, ptl_categoria) VALUES (1, 'Quesos', 2);
INSERT INTO public.plato (ptl_id, ptl_descripcion, ptl_categoria) VALUES (2, 'Sopa de pollo', 3);
INSERT INTO public.plato (ptl_id, ptl_descripcion, ptl_categoria) VALUES (3, 'Churrasco', 1);

INSERT INTO public.mesa (msa_id, msa_descripcion, msa_estado) VALUES (1, 'Esquina Izquierda', 'L');
INSERT INTO public.mesa (msa_id, msa_descripcion, msa_estado) VALUES (2, 'Centro', 'L');
INSERT INTO public.mesa (msa_id, msa_descripcion, msa_estado) VALUES (3, 'Esquina Derecha', 'L');

INSERT INTO pedido (pdd_comentario,pdd_mesa) VALUES ('Sin cebolla',1);
INSERT INTO pedido (pdd_comentario,pdd_mesa) VALUES ('Extra Queso',2);
INSERT INTO pedido (pdd_comentario,pdd_mesa) VALUES ('Extra Carne',3);

INSERT INTO detalle_pedido (dpd_pedido, dpd_plato) VALUES (1,2);
INSERT INTO detalle_pedido (dpd_pedido, dpd_plato) VALUES (2,1);
INSERT INTO detalle_pedido (dpd_pedido, dpd_plato) VALUES (3,3);

```
