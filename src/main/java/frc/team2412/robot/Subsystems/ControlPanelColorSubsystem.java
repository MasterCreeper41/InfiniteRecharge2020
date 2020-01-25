package frc.team2412.robot.Subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2412.robot.Subsystems.constants.ControlPanelConstants;

public class ControlPanelColorSubsystem extends SubsystemBase {

	private ColorSensorV3 m_colorSensor;
	private Talon m_wheelMotor;
	private Color m_CurrentColor;
	private Color m_StartColor;
	private Color m_ColorUnderBar;
	private int rotationCount = 0;

	public ControlPanelColorSubsystem(ColorSensorV3 colorSensor, Talon motor) {
		this.m_colorSensor = colorSensor;
		this.m_wheelMotor = motor;
	}

	public void rotateControlPanel() {
		rotationCount = 0;
		m_StartColor = m_colorSensor.getColor();
		m_wheelMotor.set(0.5);
		while (rotationCount <= 7) {
			m_CurrentColor = m_colorSensor.getColor();
			if (m_CurrentColor.equals(m_StartColor)) {
				rotationCount++;
			}
		}
		m_wheelMotor.set(0);
	}

	public void setToTargetColor() {
		m_CurrentColor = m_colorSensor.getColor();
		m_ColorUnderBar = getColorUnderBar(m_CurrentColor);

		while (m_ColorUnderBar != ControlPanelConstants.TargetColor) {
			m_wheelMotor.set(0.25);
			m_CurrentColor = m_colorSensor.getColor();
			m_ColorUnderBar = getColorUnderBar(m_CurrentColor);
		}

		m_wheelMotor.set(0);
	}

	public Color getColorUnderBar(Color readColor) {
		if (readColor.equals(ControlPanelConstants.blueTarget)) {
			return ControlPanelConstants.redTarget;
		} else if (readColor.equals(ControlPanelConstants.greenTarget)) {
			return ControlPanelConstants.yellowTarget;
		} else if (readColor.equals(ControlPanelConstants.redTarget)) {
			return ControlPanelConstants.blueTarget;
		} else if (readColor.equals(ControlPanelConstants.yellowTarget)) {
			return ControlPanelConstants.greenTarget;
		} else {
			return Color.kBlack;
		}
	}

}
