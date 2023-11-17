package frc.robot

object Constants {
    object ControllerConst {
        const val DRIVE_JOYSTICK_PORT = 0

        const val X_CHANNEL = 0
        const val Y_CHANNEL = 1
        const val Z_CHANNEL = 4

        const val X_DEAD_ZONE = 0.2
        const val Y_DEAD_ZONE = 0.2
        const val Z_DEAD_ZONE = 0.2
    }

    object DriveSystemConst {
        const val FRONT_LEFT_CHANNEL = 1
        const val REAR_LEFT_CHANNEL = 3
        const val FRONT_RIGHT_CHANNEL = 0
        const val REAR_RIGHT_CHANNEL = 2

        const val FRONT_LEFT_INVERTED = true
        const val FRONT_RIGHT_INVERTED = false
        const val REAR_LEFT_INVERTED = true
        const val REAR_RIGHT_INVERTED = false

        const val MAX_OUT = 0.5
    }

    object Utils {
        fun getSign(number: Double): Double = when {
            (number > 0.0) -> 1.0
            (number < 0.0) -> -1.0
            else -> 0.0
        }

        fun getSign(number: Int): Int = when {
            (number > 0) -> 1
            (number < 0) -> -1
            else -> 0
        }
    }
}