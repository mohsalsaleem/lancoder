package main.java.drfoliberg.common.task.audio;

import java.io.Serializable;

import main.java.drfoliberg.common.job.RateControlType;
import main.java.drfoliberg.common.status.TaskState;

public class AudioEncodingTask implements Serializable {

	private static final long serialVersionUID = 1319651638856267785L;

	private AudioCodec codec;
	private int channels;
	private int sampleRate;
	private int qualityRate;
	private String inputFile;
	private String outputFile;
	private RateControlType rateControlType;
	private TaskState taskState;

	/**
	 * Creates an audio encoding task with handling of the extension and quality control
	 * 
	 * @param codec
	 * @param channels
	 * @param sampleRate
	 * @param qualityRate
	 * @param inputFile
	 * @param outputFile
	 * @return
	 */
	public AudioEncodingTask(AudioCodec codec, int channels, int sampleRate, int qualityRate,
			RateControlType rateControlType, String inputFile, String outputFile) {
		this.codec = codec;
		this.channels = channels;
		this.sampleRate = sampleRate;
		this.qualityRate = qualityRate;
		this.rateControlType = rateControlType;
		this.inputFile = inputFile;
		this.outputFile = String.format("%s.%s", outputFile, codec.getContainer());
		this.taskState = TaskState.TASK_TODO;
	}

	public AudioCodec getCodec() {
		return codec;
	}

	public void setCodec(AudioCodec codec) {
		this.codec = codec;
	}

	public int getChannels() {
		return channels;
	}

	public void setChannels(int channels) {
		this.channels = channels;
	}

	public int getSampleRate() {
		return sampleRate;
	}

	public void setSampleRate(int sampleRate) {
		this.sampleRate = sampleRate;
	}

	public int getQualityRate() {
		return qualityRate;
	}

	public void setQualityRate(int qualityRate) {
		this.qualityRate = qualityRate;
	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public RateControlType getRateControlType() {
		return rateControlType;
	}

	public void setRateControlType(RateControlType rateControlType) {
		this.rateControlType = rateControlType;
	}

	public TaskState getTaskState() {
		return taskState;
	}

	public void setTaskState(TaskState taskState) {
		this.taskState = taskState;
	}

}