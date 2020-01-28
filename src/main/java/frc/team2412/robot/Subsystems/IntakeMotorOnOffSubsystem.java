package frc.team2412.robot.Subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeMotorOnOffSubsystem extends SubsystemBase {

	private CANSparkMax m_intakeFrontMotor;
	private CANSparkMax m_intakeBackMotor;
	private SpeedControllerGroup m_intakes = new SpeedControllerGroup(m_intakeFrontMotor, m_intakeBackMotor);

	public IntakeMotorOnOffSubsystem(CANSparkMax frontMotor, CANSparkMax backMotor) {
		this.m_intakeFrontMotor = frontMotor;
		this.m_intakeBackMotor = backMotor;
	}

	public void intakeOn() {
		m_intakes.set(1);
	}

	public void intakeOff() {
		m_intakes.set(0);
	}

	public void frontIntakeOn() {
		m_intakeFrontMotor.set(1);
	}

	public void backIntakeOn() {
		m_intakeBackMotor.set(1);
	}

	public void frontIntakeOff() {
		m_intakeFrontMotor.set(0);
	}

	public void backIntakeOff() {
		m_intakeBackMotor.set(0);
	}
	
	public void frontIntakeOnBackIntakeOff() {
		m_intakeFrontMotor.set(1);
		m_intakeBackMotor.set(0);
	}

	public void frontIntakeOffBackIntakeOn() {
		m_intakeFrontMotor.set(0);
		m_intakeBackMotor.set(1);
	}
	
	public void setIntake(double speed) {
		m_intakes.set(speed);
	}

}
