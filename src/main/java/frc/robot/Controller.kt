package frc.robot

import edu.wpi.first.wpilibj.Joystick

import frc.robot.Constants.ControllerConst
import frc.robot.Constants.Utils.getSign

import kotlin.math.abs

object Controller {
    private val m_Joystick = Joystick(ControllerConst.DRIVE_JOYSTICK_PORT)

    init {
        m_Joystick.xChannel = ControllerConst.X_CHANNEL
        m_Joystick.yChannel = ControllerConst.Y_CHANNEL
        m_Joystick.zChannel = ControllerConst.Z_CHANNEL
    }


    // 0 <= startPoint <= currentPoint <= 1
    private fun smooth(startPoint: Double, currentPoint: Double): Double {
        val slope = 1 / (1 - startPoint)

        return currentPoint * slope + -startPoint * slope
    }

    val verticalOffset
        get() =
            if (abs(m_Joystick.y) > ControllerConst.Y_DEAD_ZONE)
                smooth(ControllerConst.Y_DEAD_ZONE, abs(m_Joystick.y)) * getSign(m_Joystick.y)
            else 0.0

    val horizontalOffset
        get() =
            if (abs(m_Joystick.x) > ControllerConst.X_DEAD_ZONE)
                smooth(ControllerConst.X_DEAD_ZONE, abs(m_Joystick.x)) * getSign(m_Joystick.x)
            else 0.0

    val rotation
        get() =
            if (abs(m_Joystick.z) > ControllerConst.Z_DEAD_ZONE)
                smooth(ControllerConst.Z_DEAD_ZONE, abs(m_Joystick.z)) * getSign(m_Joystick.z)
            else 0.0
}