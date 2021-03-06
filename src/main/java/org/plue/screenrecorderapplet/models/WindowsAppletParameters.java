package org.plue.screenrecorderapplet.models;

import org.apache.commons.io.FilenameUtils;
import org.plue.screenrecorderapplet.Applet;
import org.plue.screenrecorderapplet.constants.PropertyKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author paolo86@altervista.org
 */
public class WindowsAppletParameters extends AppletParameters
{
	private static final Logger logger = LoggerFactory.getLogger(LinuxAppletParameters.class);

	WindowsAppletParameters() throws IOException
	{
		super();
	}

	@Override
	protected void readBaseFolder()
	{
		logger.debug("# called readBaseFolder");

		String folderName = properties.getProperty(PropertyKeys.BASE_FOLDER);

		String tempFolder = System.getenv("TEMP");
		this.baseFolder = new File(FilenameUtils.concat(tempFolder, folderName));

		logger.info("Retrieved base folder: '" + baseFolder + "'");

		logger.debug("# completed readBaseFolder");
	}

	@Override
	protected void readBinFolder()
	{
		logger.debug("# called readBinFolder");

		this.binFolder = new File(FilenameUtils.concat(getBaseFolder().getAbsolutePath(), "bin-windows-1.0"));
		logger.info("Retrieved bin folder: '" + binFolder + "'");

		logger.debug("# completed readBinFolder");
	}

	@Override
	protected void readTmpFolder()
	{
		logger.debug("# called readTmpFolder");

		this.tmpFolder = new File(System.getenv("TEMP"));
		logger.info("Retrieved temp folder: '" + tmpFolder + "'");

		logger.debug("# completed readTmpFolder");
	}

	@Override
	public File getFFmpegBinaryPath()
	{
		logger.debug("# called getFFmpegBinaryPath");

		String ffmpegBinaryPath = FilenameUtils.concat(getBinFolder().getAbsolutePath(), "ffmpeg.exe");
		logger.info("Retrieved FFMpeg Binary Path: '" + ffmpegBinaryPath + "'");

		logger.debug("# completed getFFmpegBinaryPath");
		return new File(ffmpegBinaryPath);
	}

	@Override
	public OperatingSystem getOperatingSystem()
	{
		return OperatingSystem.WINDOWS;
	}
}
