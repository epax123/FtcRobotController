**Technical Highlights**

* **Programming Paradigm**: Implemented Command-Based Programming, organizing the program into subsystems and commands. This modular design allows reusability across TeleOp and Autonomous routines while increasing readability and debugging speed.
* **Motion Control**: Programmed a PID (Proportional-Integral-Derivative) controller on our hooded launcher. This system stabilizes flywheel RPM, ensuring consistent projectile speeds.
* **Sensor Integration & Localization**:
  **Inertial Measurement Unit (IMU)**: Integrted the Control Hub's internal IMU to obtain robot heading, enabling a Field-Oriented Drive that calculates new Drivetrain inputs from the driver inputs relative to the playing field rather than the robot's chassis.
  **Computer Vision**: Utilized a Logitech webcam to detect april tag data, The bearing data used to calculate DriveTrain inputs to automatically aim our robot, and the distance to an april tag to automatically set our flywheel speed.
