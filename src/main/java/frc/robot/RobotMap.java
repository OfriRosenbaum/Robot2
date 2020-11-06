package frc.robot;

public interface RobotMap {
    public interface CAN{
        public static final int RIGHT=0;
        public static final int RIGHT_SLAVE=1;
        public static final int LEFT=2;
        public static final int LEFT_SLAVE=3;
        public static final int GRIPPER_ONE=4;
        public static final int GRIPPER_TWO=5;
        public static final int ELEVATOR_ONE=6;
        public static final int ELEVATOR_TWO=7;
        public static final int ELEVATOR_THREE=8;
    }

    public interface DIO{
        public static final int POS_ENCODER=0;
        public static final int NEG_ENCODER=1;
        public static final int DIGITAL_INPUT_GRIPPER=2;
        public static final int DIGITAL_INPUT_ELEVATOR_BOTTOM=3;
        public static final int DIGITAL_INPUT_ELEVATOR_MIDDLE=4;
        public static final int DIGITAL_INPUT_ELEVATOR_TOP=5;
    }
}
