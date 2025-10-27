Aplicación de los pilares de la Programación Orientada a Objetos (POO)

Encapsulamiento

*En Task y Student todos los atributos son privados y se acceden mediante getters y setters públicos, evitando modificaciones directas desde otras capas y controlando el estado de los objetos.​

*Por ejemplo, el estado entregada de Task solo se cambia con setEntregada(true) desde la lógica del servicio, lo que permite mantener reglas de negocio coherentes.​

Abstracción

*TaskService y StudentService exponen operaciones de alto nivel (create, findAll, update, delete, marcarEntregada) y ocultan los detalles de almacenamiento en memoria, simplificando el uso desde los controladores.​

*Los controladores no conocen cómo se guardan los datos (List y nextId); solo invocan métodos del servicio y reciben objetos de dominio, reduciendo complejidad y acoplamiento.​

Herencia

*Aunque el proyecto no requiere herencia explícita, podría introducirse una clase base AbstractEntity con el campo id y comportamiento común para reutilizar código entre Task y Student.​

*También se podría definir una jerarquía de usuarios (por ejemplo, Persona → Student) si en el futuro se agregan más roles con atributos compartidos.​

Polimorfismo

*Si se incorporan distintos tipos de tareas (por ejemplo, TaskPractica y TaskTeorica) que redefinan validaciones o reglas al entregarse, podrían consumirse desde una interfaz común TaskType en la capa de servicio.​

*Del mismo modo, distintas implementaciones de repositorio (en memoria o conectado a BD) podrían intercambiarse sin cambiar los controladores si se abstrae el acceso a datos detrás de una interfaz.
