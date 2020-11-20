package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {

    private WPI_TalonSRX speedController1;
    private DigitalInput digitalInputBottom;
    private DigitalInput digitalInputMiddle;
    private DigitalInput digitalInputTop;
    private Encoder encoder;
    public static final int TICKS_MIDDLE=2500;
    public static final int TICKS_TOP=5000;

    public Elevator(WPI_TalonSRX speedController1, WPI_VictorSPX speedController2,
                    WPI_VictorSPX speedController3, DigitalInput digitalInputBottom, DigitalInput digitalInputMiddle,
                    DigitalInput digitalInputTop, Encoder encoder) {
        this.speedController1 = speedController1;
        speedController2.follow(speedController1);
        speedController3.follow(speedController1);
        this.digitalInputBottom = digitalInputBottom;
        this.digitalInputMiddle = digitalInputMiddle;
        this.digitalInputTop = digitalInputTop;
        this.encoder = encoder;
    }

    public void elevate(double speed){
        speedController1.set(speed);
    }

    public void stopElevator(){
        speedController1.stopMotor();
    }


    public double returnEncoderDistance() {
        return encoder.getDistance();
    }

    @Override
    public void periodic() {
        if(digitalInputBottom.get())
            speedController1.setSelectedSensorPosition(0);
        else
            if (digitalInputMiddle.get())
                speedController1.setSelectedSensorPosition(TICKS_MIDDLE);
            else
                if (digitalInputTop.get())
                    speedController1.setSelectedSensorPosition(TICKS_TOP);
    }
}
