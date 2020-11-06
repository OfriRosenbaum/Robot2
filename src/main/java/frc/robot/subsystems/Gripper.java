package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gripper extends SubsystemBase {

    private WPI_VictorSPX speedController1;
    private WPI_VictorSPX speedController2;
    private DigitalInput digitalInput;

    public Gripper(WPI_VictorSPX speedController1, WPI_VictorSPX speedController2, DigitalInput digitalInput) {
        this.speedController1 = speedController1;
        this.speedController2 = speedController2;
        speedController2.setInverted(true);
        this.digitalInput = digitalInput;
    }

    public boolean hasBall(){
    return digitalInput.get();
    }

    public void grip(double speed){
    speedController1.set(speed);
    speedController2.set(speed);
    }

    public void release(){
    speedController1.set();
    speedController2.set();
    }

    public void stopGripper(){
        speedController1.stopMotor();
        speedController2.stopMotor();
    }
}
