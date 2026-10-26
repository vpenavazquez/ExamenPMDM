class ascensorHalo {

    enum class EstadoHalo{
        IDLE,
        MovingDOWN,
        MovingUP,
        ERROR

    }

    var estadoActual: EstadoHalo = EstadoHalo.IDLE
        private set


    fun pulsarBotonBajar(){
        when (estadoActual) {
            EstadoHalo.IDLE -> { estadoActual = EstadoHalo.MovingDOWN }
            else -> { estadoActual = EstadoHalo.ERROR }
        }
    }

    fun pulsarBotonSubir(){
        when (estadoActual) {
            EstadoHalo.IDLE -> { estadoActual = EstadoHalo.MovingUP }
            else -> { estadoActual = EstadoHalo.ERROR }
        }
    }



    fun abrirPuerta(){
        when (estadoActual) {
            EstadoHalo.MovingDOWN -> { estadoActual = EstadoHalo.IDLE }
            EstadoHalo.MovingUP -> { estadoActual = EstadoHalo.IDLE }
            else -> { estadoActual = EstadoHalo.ERROR }
        }

    }



    fun fallo(){
        when (estadoActual) {
            EstadoHalo.IDLE,
            EstadoHalo.MovingDOWN,
            EstadoHalo.MovingUP -> { estadoActual = EstadoHalo.ERROR
            }
            else -> {}
        }

    }


}