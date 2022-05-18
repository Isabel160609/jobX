# jobX
Este es uno de los retos clasificatorios que forman parte del hackathon online de JOBarcelona ’22. El resultado de este reto va a permitir a los ganadores asistir
al hackathon presencial que se realizará el día 31 de mayo de 2022 en el Camp Nou.
## Background

El equipo de JOBX necesita implementar un sistema de autenticación (Auth) utilizando Jason Web Token para seguir de forma segura.

Tareas
Las especificaciones de este servidor para el desarrollo en local necesita lo siguiente:

Que se conecte al puerto: 3030

Las variables de entorno no se deben subir a github, pero tiene que haber un template que permita conocer cuales son las necesarias.

Las rutas de auth tiene que permitir registrar y logear usuarios:

Una ruta para el registro /signup

Una ruta para el login /login

Tanto la ruta de login como la de registro deben enviar el token para poder entrar en las demás rutas.

Además, se necesita una ruta que devuelva toda la lista de users que haya para que desde el backoffice de JOBX puedan controlar el crecimiento. 
Esta ruta tiene que estar protegida y solo se dará acceso a un usuario con rol de admin y con los credenciales que se encuentran encriptados en el documento.

ruta: /users
Un user tiene como parámetros obligatorios:

username (tiene que ser único)

email (tiene que seguir el patrón de correo y ser único)

password (tiene que tener mínimo de 8 caracteres, incluir una Mayúscula y un número).

Para poder finalizar la implementación con éxito tendrás que descifrar el código de encriptación y desbloquear el documento dónde se encuentran las librerías secretas, que son las que se se están usando para documentar y para el diseño del componente.
Los objetivos son:

✅ Task 1 → POST /auth/signup: Una ruta para el registro de usuarios

✅ Task 2 → POST /auths/login : Una ruta para el login de usuarios

✅ Task 3 → GET /users :  una ruta que devuelva toda la lista de users  solo con acceso a un usuario con rol de admin


Esto lo realizaremos guardando los datos en MySQL, y creando  JWT 

## Installation

### Los requisitos para poner en marcha este proyecto son:

  - Tener JavaSE-11  En el caso de no tenerlo instalado podemos instalarlo pulsando el siguiente link: [JavaSE-11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

  - Tener instalado el driver de JDBC. En el caso de no tenerlo instalado podemos instalarlo pulsando el siguiente link: [JDBC](https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15)

  - Tener instalado MySql En el caso de no tenerlo instalado podemos instalarlo pulsando el siguiente link: [MySql](https://dev.mysql.com/). Y como en cualquier otra instalación siguiente>siguiente… Seleccionamos la configuración por defecto y escribimos un user y una contraseña (opcional).
  
  -Tener instalado Eclipse En el caso de no tenerlo instalado podemos instalarlo pulsando el siguiente link:[Eclipse](https://www.eclipse.org/downloads/) y seguir las instrucciones de la página.

 ### Puesta en marcha
  
    Poner en marcha la base de datos MySql .
    
      
         usuario = "root";

         contraseña = "";
         

    Si se quiere usar postman en el proyecto hay un json para poder importar con las diferentes llamadas. Ya esta en este json los datos del superusuario que no se ha 
    introducido en la BBDD pero se puede hacer en el endpoint
  
    Poner en marcha el proyecto en eclipse hay una configuracion que rellenara automaicamente la base de datos con el json que se adjuntaba en el archivo secreto.
      
        
  ## Roadmap and visuals
  
     Se han añadido archivos json con las llamadas al api y ejemplos implementados para facilitar las llamadas
     
     
   [Captura](https://user-images.githubusercontent.com/77856098/169035615-71b52694-395e-47a1-a12d-ddd61bbf1320.png)

    
    Tambien se ha añadido Swagger quese puede ver en la siguiente ruta http://localhost:3030/swagger-ui.html# una vez puesto en marchael programa y si se desea tambien     se pueden manejar desde alli los 3 endpoints
    
      [Captura](https://user-images.githubusercontent.com/77856098/169036165-601cf8f5-1878-4a96-995f-7b628f861fcd.png)
      
  ## Contact info
  
  [Linkedin Isabel Domènech](https://www.linkedin.com/in/isabel-domenech-de-mena-157103124/)
  
  ## License 

  [MIT](https://opensource.org/licenses/MIT)
  
