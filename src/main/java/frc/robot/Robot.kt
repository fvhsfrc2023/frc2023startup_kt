package frc.robot

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj2.command.CommandScheduler
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup

import frc.robot.commands.TeleopDrive
import frc.robot.subsystems.*

/**
 * The VM is configured to automatically run this object (which basically functions as a singleton class),
 * and to call the functions corresponding to each mode, as described in the TimedRobot documentation.
 * This is written as an object rather than a class since there should only ever be a single instance, and
 * it cannot take any constructor arguments. This makes it a natural fit to be an object in Kotlin.
 *
 * If you change the name of this object or its package after creating this project, you must also update
 * the `Main.kt` file in the project. (If you use the IDE's Rename or Move refactorings when renaming the
 * object or package, it will get changed everywhere.)
 */
object Robot : TimedRobot() {

    private val autonomousCommands = ParallelCommandGroup()

    private val teleopCommands = ParallelCommandGroup(
        TeleopDrive
    )


    override fun robotInit() {
        DriveSystem.register()
    }


    override fun robotPeriodic() {
        CommandScheduler.getInstance().run()
    }

    override fun autonomousInit() {
        teleopCommands.cancel()
        autonomousCommands.schedule()
    }

    override fun teleopInit() {
        autonomousCommands.cancel()
        teleopCommands.schedule()
    }
}