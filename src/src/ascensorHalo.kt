class AscensorHalo {

    //estados
    enum class EstadoHalo {
        Idle,
        MovingDOWN,
        MovingUP,
        Error
    }

    //valores de posicion
    val GarciaBarbon: Int = 0
    val Pcompostela: Int = 1
    val Movimiento: Int = 2
    val ErrorNivel: Int = -1


    var estadoActual: EstadoHalo = EstadoHalo.Idle
    private set

    var nivel_actual: Int = GarciaBarbon
    private set

    //metodo comprueba si esta en plaza compostela y baja, se pone en el nivel movimiento y si no da error
    fun pulsarBotonBajar(): Unit {
        when (estadoActual) {
            EstadoHalo.Idle -> {
                if (nivel_actual == Pcompostela) {
                    estadoActual = EstadoHalo.MovingDOWN
                    nivel_actual = Movimiento
                } else {
                    registrarError()
                }
            }
            else -> registrarError()
        }
    }

    //metodo comprueba si esta en GarciaBarbon y sube, se pone en el nivel movimiento y si no da error
    fun pulsarBotonSubir(): Unit {
        when (estadoActual) {
            EstadoHalo.Idle -> {
                if (nivel_actual == GarciaBarbon) {
                    estadoActual = EstadoHalo.MovingUP
                    nivel_actual = Movimiento
                } else {
                    registrarError()
                }
            }
            else -> registrarError()
        }
    }

    //registra cuando el ascesor esta bajando o subiendo, cuando llega a uno de los niveles abre las puertas y pasa a estado idle
    fun abrirPuerta(): Unit {
        when (estadoActual) {
            EstadoHalo.MovingDOWN -> {
                estadoActual = EstadoHalo.Idle
                nivel_actual = GarciaBarbon
            }
            EstadoHalo.MovingUP -> {
                estadoActual = EstadoHalo.Idle
                nivel_actual = Pcompostela
            }
            else -> registrarError()
        }
    }

    //registra un fallo en el ascensor
    fun fallo(): Unit {
        registrarError()
    }




    //registras el error y pasa a estado error
    private fun registrarError(): Unit {
        estadoActual = EstadoHalo.Error
        nivel_actual = ErrorNivel
    }
}