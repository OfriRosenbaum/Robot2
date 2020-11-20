package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

import java.util.function.Supplier;

public class Elevate extends CommandBase {

    private Elevator elevator;
    private Supplier<Double> kP;
    private Supplier<Double> kI;
    private Supplier<Double> kD;
    private Supplier<Double> tolerance;
    private Supplier<Double> setpoint;
    private PIDController pidController;

    public Elevate(Elevator elevator, Supplier<Double> kP, Supplier<Double> kI,
                   Supplier<Double> kD, Supplier<Double> tolerance, Supplier<Double> setpoint) {

        this.elevator = elevator;
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.tolerance = tolerance;
        this.setpoint = setpoint;
        addRequirements(elevator);

    }


    @Override
    public void initialize() {
        pidController = new PIDController(kP.get(), kI.get(), kD.get());
    }

    @Override
    public void execute() {
        pidController.setPID(kP.get(), kI.get(), kD.get());
        pidController.setTolerance(tolerance.get());
        elevator.elevate(pidController.calculate(elevator.returnEncoderDistance(), setpoint.get()));
    }

    @Override
    public boolean isFinished(){
    return (elevator.returnEncoderDistance()>=setpoint.get()-tolerance.get() &&
            elevator.returnEncoderDistance()<=setpoint.get()+tolerance.get());
    }
    @Override
    public void end(boolean interrupted){
        elevator.stopElevator();
    }
}