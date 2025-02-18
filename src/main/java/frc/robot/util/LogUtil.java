// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Add your docs here. */
public class LogUtil {
    public static void recordPose2d(String key, Pose2d... poses) {
		final double[] doubleArray = Arrays.stream(poses)
				.flatMapToDouble(pose -> DoubleStream.of(
						pose.getTranslation().getX(),
						pose.getTranslation().getY(),
						pose.getRotation().getRadians()))
				.toArray();
		SmartDashboard.putNumberArray(key, doubleArray);
	}

	public static void recordPose3d(String key, Pose3d... poses) {
		final double[] doubleArray = Arrays.stream(poses)
				.flatMapToDouble(pose -> DoubleStream.of(
						pose.getTranslation().getX(),
						pose.getTranslation().getY(),
						pose.getTranslation().getZ(),
						pose.getRotation().getQuaternion().getW(),
						pose.getRotation().getQuaternion().getX(),
						pose.getRotation().getQuaternion().getY(),
						pose.getRotation().getQuaternion().getZ()))
				.toArray();
		SmartDashboard.putNumberArray(key, doubleArray);
	}
}
