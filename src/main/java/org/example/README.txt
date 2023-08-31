GENERADOR DE RUTINAS.

    DESCRIPCION:
        Aplicacion que genera un archivo .pdf de rutinas de entrenamiento seleccionandolas desde una interfaz
        grafica.
        Los ejercicios seran guardados como entidades en una base de datos (inicialmente un fichero de texto) donde cada
        ejercicio tendra los campos "id", "nombre", "foto", y "link_video".
        La interfaz grafica tendra dos opciones principales: "Cargar ejercicio" y "Generar rutina".
        En la primera opcion, se podra cargar cualquier ejercicio elegido en la BBDD, insertando el nombre, una foto y
        un link a un video de YouTube del mismo.
        En la opcion "Generar rutina" se abrira una pantalla en donde se podran buscar los ejercicios por nombre, y se podran
        agregar a la rutina desde un boton "Agregar Ejercicio", ademas, para cada ejercicio se podra incluir la cantidad de
        repeticiones requeridas para el mismo.
        Luego de agregar los ejercicios, se podra generar un archivo .pdf utilizando el boton "Generar pdf" el cual creara un
        archivo con los distintos ejercicios agregados.
        En el archivo "rutina.pdf" cada ejercicio aparecera como un item con el nombre del ejercicio, una foto ilustrativa y
        un link a un video del mismo en YouTube.


