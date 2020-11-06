package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

import java.util.function.Supplier;

public class TankDrive extends CommandBase {

    Supplier<Double> speedLeft;
    Supplier<Double> speedRight;
    DriveTrain driveTrain;

    public TankDrive(Supplier<Double> speedLeft, Supplier<Double> speedRight, DriveTrain driveTrain) {
        this.speedLeft = speedLeft;
        this.speedRight = speedRight;
        this.driveTrain = driveTrain;
    }

    @Override
    public void execute(){
        driveTrain.move(speedRight.get(), speedLeft.get());
    }
    @Override
    public void end(boolean interrupted){
        driveTrain.stop();
    }
}
