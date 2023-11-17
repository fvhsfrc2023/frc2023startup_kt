package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.Controller
import frc.robot.subsystems.DriveSystem

object TeleopDrive: CommandBase() {

    init {
        addRequirements(DriveSystem)
    }

    override fun execute() {
        DriveSystem.drive(
            Controller.verticalOffset,
            Controller.horizontalOffset,
            Controller.rotation)
    }
}