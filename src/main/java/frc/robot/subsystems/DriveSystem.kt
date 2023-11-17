package frc.robot.subsystems

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax
import edu.wpi.first.wpilibj2.command.SubsystemBase

import frc.robot.Constants.DriveSystemConst
import kotlin.math.abs
import kotlin.math.min

object DriveSystem: SubsystemBase() {

    private val m_FrontLeftMotor = PWMSparkMax(DriveSystemConst.FRONT_LEFT_CHANNEL)
    private val m_FrontRightMotor = PWMSparkMax(DriveSystemConst.FRONT_RIGHT_CHANNEL)
    private val m_RearLeftMotor = PWMSparkMax(DriveSystemConst.REAR_LEFT_CHANNEL)
    private val m_RearRightMotor = PWMSparkMax(DriveSystemConst.REAR_RIGHT_CHANNEL)

    init {
        m_FrontLeftMotor.inverted = DriveSystemConst.FRONT_LEFT_INVERTED
        m_FrontRightMotor.inverted = DriveSystemConst.FRONT_RIGHT_INVERTED
        m_RearLeftMotor.inverted = DriveSystemConst.REAR_LEFT_INVERTED
        m_RearRightMotor.inverted = DriveSystemConst.REAR_RIGHT_INVERTED
    }

    enum class MotorPlace {
        FRONT_LEFT,
        FRONT_RIGHT,
        REAR_LEFT,
        REAR_RIGHT
    }


    override fun periodic() {

    }

    fun getMotor(mp: MotorPlace): PWMSparkMax = when (mp) {
            MotorPlace.FRONT_LEFT -> m_FrontLeftMotor
            MotorPlace.FRONT_RIGHT -> m_FrontRightMotor
            MotorPlace.REAR_RIGHT -> m_RearRightMotor
            MotorPlace.REAR_LEFT -> m_RearLeftMotor
    }

    fun drive(vspeed: Double, hspeed: Double, rotation: Double) {

        var rlSpeed = vspeed * abs(vspeed)
        var frSpeed = vspeed * abs(vspeed)
        var flSpeed = vspeed * abs(vspeed)
        var rrSpeed = vspeed * abs(vspeed)

        flSpeed *= min(1.0, 2 * rotation + 1)
        rlSpeed *= min(1.0, 2 * rotation + 1)
        frSpeed *= min(1.0, -2 * rotation + 1)
        rrSpeed *= min(1.0, -2 * rotation + 1)

        flSpeed += -hspeed * abs(hspeed)
        rlSpeed += hspeed * abs(hspeed)
        frSpeed += hspeed * abs(hspeed)
        rrSpeed += -hspeed * abs(hspeed)

        m_RearLeftMotor.set(rlSpeed * DriveSystemConst.MAX_OUT)
        m_RearRightMotor.set(rrSpeed * DriveSystemConst.MAX_OUT)
        m_FrontRightMotor.set(frSpeed * DriveSystemConst.MAX_OUT)
        m_FrontLeftMotor.set(flSpeed * DriveSystemConst.MAX_OUT)
    }
}