# desafio_candidato

Se debe confeccionar una aplicación punta a punta en las tecnologías/plataformas que
conozca o maneje, utilizando para java y Sprint Rest para el backend.
La aplicación debe contener un login de autenticación a la aplicación Candidatos FluxIT,
una vez ingresado a la aplicación, debe mostrarse un listado de candidatos (ya
precargados) a ser reclutados por FluxIT.
Al ingresar a un candidato, se podrá visualizar un listado con la siguiente información básica
de cada aspirante:
● Nombre y apellido
● DNI
Se puede ingresar a ver el detalle de cada candidato, al hacerlo se visualizará:
○ Nombre y apellido
○ DNI
○ Fecha de nacimiento
○ Domicilio: campo descriptivo
○ Teléfono
○ Mail
○ Foto
○ Experiencia Laboral: campo descriptivo
Se debe también poder modificar y eliminar a los aspirantes
Finalmente, desarrollar los servicios web con Spring Rest de agregado, modificación,
eliminación y búsqueda por DNI o Nombre y apellido de aspirantes para poder utilizar los
servicios desde una aplicación externa.

Basa de datos
Mysql

Aplicacion nodejs frontend
ejecutar con la consola en el directorio del proyecto:
npm install
npm start
el proyecto escucha en el puerto 3000

Login 
usuario flux, password 1234

Aplicacion Backend
ejecutar los siguientes script sql

db_candidatos.sql

el proyecto escucha en el puerto 8081
localhost:8081/api/candidatos

pruebas con Swagger
http://localhost:8081/swagger-ui.html#/


