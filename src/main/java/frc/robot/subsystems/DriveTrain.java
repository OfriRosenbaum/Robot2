package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private WPI_TalonSRX rightSpeedController;
    private WPI_TalonSRX leftSpeedController;


    public DriveTrain(WPI_TalonSRX rightSpeedController1, WPI_VictorSPX rightSpeedController2,
                      WPI_TalonSRX leftSpeedController1, WPI_VictorSPX leftSpeedController2) {
        this.rightSpeedController = rightSpeedController1;
        rightSpeedController2.follow(rightSpeedController1);
        this.leftSpeedController = leftSpeedController1;
        leftSpeedController1.setInverted(true);
        leftSpeedController2.follow(leftSpeedController1);
    }

    public void move(double speedRight, double speedLeft){
        rightSpeedController.set(speedRight);
        leftSpeedController.set(speedLeft);
    }

    public void stop(){
    rightSpeedController.stopMotor();
    leftSpeedController.stopMotor();
    }
}
