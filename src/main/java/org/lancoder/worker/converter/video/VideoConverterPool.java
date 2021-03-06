package org.lancoder.worker.converter.video;

import org.lancoder.common.FilePathManager;
import org.lancoder.common.pool.PoolWorker;
import org.lancoder.common.task.video.ClientVideoTask;
import org.lancoder.common.third_parties.FFmpeg;
import org.lancoder.worker.converter.ConverterListener;
import org.lancoder.worker.converter.ConverterPool;

public class VideoConverterPool extends ConverterPool<ClientVideoTask> {

	private ConverterListener listener;
	private FilePathManager filePathManager;
	private FFmpeg ffMpeg;

	public VideoConverterPool(int threads, ConverterListener listener, FilePathManager filePathManager, FFmpeg ffMpeg) {
		super(threads, false);
		this.listener = listener;
		this.filePathManager = filePathManager;
		this.ffMpeg = ffMpeg;
	}

	@Override
	protected PoolWorker<ClientVideoTask> getPoolWorkerInstance() {
		return new VideoWorkThread(listener, filePathManager, ffMpeg);
	}

	@Override
	public int getActiveThreadCount() {
		// TODO get each task's thread count
		return getActiveCount() * 9000;
	}

}
