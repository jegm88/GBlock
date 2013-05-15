CREATE TABLE "public"."documentos" (
"id" serial8,
"codigo" varchar(50) NOT NULL,
"tipo" int4 NOT NULL,
"bodega" int4 NOT NULL,
"fecha1" timestamp NOT NULL,
"fecha2" timestamp,
"emisor" varchar(50) NOT NULL,
"receptor" varchar(50) NOT NULL,
"documento_asociado" int8,
"forma_pago" int4 NOT NULL,
"reteiva" money,
"reteica" money,
"retefuente" money,
"tipo_reteiva" varchar(50),
"tipo_reteica" varchar(50),
"tipo_retefuente" varchar(50),
"total_iva" money NOT NULL,
"descuento" money,
"subtotal" money NOT NULL,
"total" money NOT NULL,
"vendedor" varchar(50) NOT NULL,
"observaciones" text,
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."formas_pago" (
"id" serial4,
"nombre" varchar(50) NOT NULL,
"descripcion" varchar(50),
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."detalles_documento" (
"id" serial8,
"documento" int8 NOT NULL,
"articulo" int8 NOT NULL,
"cantidad" int4 NOT NULL,
"valor" money NOT NULL,
"iva_ptj" float4 NOT NULL,
"reteica" money,
"retefuente" money,
"tipo_reteiva" varchar(50),
"tipo_reteica" varchar(50),
"tipo_retefuente" varchar(50),
"iva" money NOT NULL,
"descuento_ptj" float4,
"descuento" money,
"subtotal" money NOT NULL,
"total" money NOT NULL,
"descripcion" text,
"reteiva" money,
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."articulos" (
"id" serial8,
"nombre" varchar(50) NOT NULL,
"descripcion" text,
"marca" varchar(50),
"modelo" varchar(50),
"valor_unit" money NOT NULL,
"iva_ptj" float4 NOT NULL,
"categoria" int4 NOT NULL,
"observaciones" text,
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."categorias_articulo" (
"id" serial4,
"nombre" varchar(50) NOT NULL,
"descripcion" text,
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."tipos_documento" (
"id" serial4,
"nombre" varchar(50) NOT NULL,
"descripcion" text,
"indice" int8 NOT NULL,
"formato_codigo" varchar(50) NOT NULL,
"impacto_inventario" int2,
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."bodegas" (
"id" serial4,
"nombre" varchar(50) NOT NULL,
"descripcion" text,
"ubicacion" text,
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."inventarios" (
"bodega" int4,
"articulo" int8,
"cantidad" int4 NOT NULL,
"stockMax" int4,
"stockMin" int4,
"stockAlerta" int4,
"estado" int2 NOT NULL,
PRIMARY KEY ("bodega", "articulo") 
);

CREATE TABLE "public"."tipos_tercero" (
"id" serial4,
"nombre" varchar(50) NOT NULL,
"descripcion" text,
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."terceros" (
"id" varchar(50),
"tipo" int4 NOT NULL,
"tipoId" varchar(50),
"digitoVerificacion" int2,
"nombres" varchar(50),
"apellidos" varchar(50),
"direccion" varchar(50),
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."telefonos" (
"numero" varchar(50),
"tipo" varchar(50),
"tercero" varchar(50) NOT NULL,
"estado" int2 NOT NULL,
PRIMARY KEY ("numero") 
);

CREATE TABLE "public"."correos" (
"email" varchar(50),
"tipo" varchar(50),
"tercero" varchar(50) NOT NULL,
"estado" int2 NOT NULL,
PRIMARY KEY ("email") 
);

CREATE TABLE "public"."usuarios" (
"id" serial4,
"nick" varchar(50) NOT NULL,
"password" varchar(50) NOT NULL,
"tercero" varchar(50) NOT NULL,
"perfil" int4 NOT NULL,
"estado" int2 NOT NULL,
PRIMARY KEY ("id") ,
CONSTRAINT "uq_tercero" UNIQUE ("tercero")
);

CREATE TABLE "public"."perfiles" (
"id" serial4,
"nombre" varchar(50) NOT NULL,
"descripcion" text,
"estado" int2 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "public"."arqueos" (
"id" serial8,
"bodega" int4 NOT NULL,
"fechaApertura" timestamp NOT NULL,
"valorApertura" money NOT NULL,
"usuarioApertura" int4 NOT NULL,
"fechaCierre" timestamp NOT NULL,
"valorCierre" money NOT NULL,
"usuarioCierre" int4 NOT NULL,
"descuadre" money NOT NULL,
"estado" int2,
PRIMARY KEY ("id") 
);


ALTER TABLE "public"."documentos" ADD CONSTRAINT "fk_forma_pago" FOREIGN KEY ("forma_pago") REFERENCES "public"."formas_pago" ("id");
ALTER TABLE "public"."detalles_documento" ADD CONSTRAINT "fk_documento" FOREIGN KEY ("documento") REFERENCES "public"."documentos" ("id");
ALTER TABLE "public"."articulos" ADD CONSTRAINT "fk_categoria" FOREIGN KEY ("categoria") REFERENCES "public"."categorias_articulo" ("id");
ALTER TABLE "public"."detalles_documento" ADD CONSTRAINT "fk_articulo" FOREIGN KEY ("articulo") REFERENCES "public"."articulos" ("id");
ALTER TABLE "public"."documentos" ADD CONSTRAINT "fk_tipo_documento" FOREIGN KEY ("tipo") REFERENCES "public"."tipos_documento" ("id");
ALTER TABLE "public"."inventarios" ADD CONSTRAINT "fk_bodega_inv" FOREIGN KEY ("bodega") REFERENCES "public"."bodegas" ("id");
ALTER TABLE "public"."inventarios" ADD CONSTRAINT "fk_articulo_inv" FOREIGN KEY ("articulo") REFERENCES "public"."articulos" ("id");
ALTER TABLE "public"."documentos" ADD CONSTRAINT "fk_bodega_doc" FOREIGN KEY ("bodega") REFERENCES "public"."bodegas" ("id");
ALTER TABLE "public"."telefonos" ADD CONSTRAINT "fk_tercero_tel" FOREIGN KEY ("tercero") REFERENCES "public"."terceros" ("id");
ALTER TABLE "public"."correos" ADD CONSTRAINT "fk_tercero_cor" FOREIGN KEY ("tercero") REFERENCES "public"."terceros" ("id");
ALTER TABLE "public"."documentos" ADD CONSTRAINT "fk_emisor_doc" FOREIGN KEY ("emisor") REFERENCES "public"."terceros" ("id");
ALTER TABLE "public"."documentos" ADD CONSTRAINT "fk_receptor_doc" FOREIGN KEY ("receptor") REFERENCES "public"."terceros" ("id");
ALTER TABLE "public"."terceros" ADD CONSTRAINT "fk_tipotercero_ter" FOREIGN KEY ("tipo") REFERENCES "public"."tipos_tercero" ("id");
ALTER TABLE "public"."usuarios" ADD CONSTRAINT "fk_tercero_usr" FOREIGN KEY ("tercero") REFERENCES "public"."terceros" ("id");
ALTER TABLE "public"."usuarios" ADD CONSTRAINT "fk_perfil_usr" FOREIGN KEY ("perfil") REFERENCES "public"."perfiles" ("id");
ALTER TABLE "public"."documentos" ADD CONSTRAINT "fk_asociado_doc" FOREIGN KEY ("documento_asociado") REFERENCES "public"."documentos" ("id");
ALTER TABLE "public"."arqueos" ADD CONSTRAINT "fk_bodega_arq" FOREIGN KEY ("bodega") REFERENCES "public"."bodegas" ("id");
ALTER TABLE "public"."arqueos" ADD CONSTRAINT "fk_usuarioAp_arq" FOREIGN KEY ("usuarioApertura") REFERENCES "public"."usuarios" ("id");
ALTER TABLE "public"."arqueos" ADD CONSTRAINT "fk_usuarioCi_arq" FOREIGN KEY ("usuarioCierre") REFERENCES "public"."usuarios" ("id");

