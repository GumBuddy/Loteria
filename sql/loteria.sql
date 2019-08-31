create table datos_de_contacto
(
    id_contacto        int          not null
        primary key,
    correo_electronico varchar(50)  null,
    direccion          varchar(100) not null,
    numero_celular     char(10)     not null
);

create table datos_de_institucionales
(
    id_institucionales varchar(20) not null
        primary key,
    adscripcion        varchar(50) null,
    tipo_universitario varchar(20) null
);

create table datos_personales
(
    id_datos_personales int auto_increment
        primary key,
    folio               char(6)     not null,
    apellido_paterno    varchar(15) not null,
    apellido_materno    varchar(15) not null,
    Nombres             varchar(50) not null,
    edad                int         not null,
    asistencia          tinyint(1)  null
);

create table datos_de_grupo
(
    id_grupo            char(6) not null
        primary key,
    id_datos_personales int     null,
    constraint fk_datos_personales
        foreign key (id_datos_personales) references datos_personales (id_datos_personales)
);

create table datos_participante
(
    id_participante    int auto_increment
        primary key,
    id_contacto        int         not null,
    id_institucionales varchar(20) not null,
    id_grupo           char(6)     not null,
    constraint fk_id_contacto
        foreign key (id_contacto) references datos_de_contacto (id_contacto),
    constraint fk_id_grupo
        foreign key (id_grupo) references datos_de_grupo (id_grupo),
    constraint fk_id_institucionales
        foreign key (id_institucionales) references datos_de_institucionales (id_institucionales)
);

