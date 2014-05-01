package drfoliberg;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import drfoliberg.common.task.Job;
import drfoliberg.common.task.JobType;
import drfoliberg.master.Master;
import drfoliberg.worker.Worker;

public class Simulation extends Thread {

	/**
	 * This simulation runs to instantiate multiple clients and a master server under the same console.
     * We can also access each instance and trigger events.
	 * 
	 */
	public Simulation() throws IOException {

	}
	
	/**
	 * Attempts to encode a file locally with a single worker thread.
	 * @param filepath Path of the video file to encode
	 */
	public void basicSimulation(String filepath) {
		InetAddress masterIp;
		try {
			
			System.out.println("SIM: Starting master now");
			
			Master m = new Master();
			Thread masterThread = new Thread(m);
			masterThread.start();
			Job j = new Job("testname", filepath, JobType.BITRATE_2_PASS_JOB, 1000 * 30 * 1 );
			System.out.println("SIM: adding a job to master's queue !");
			m.addJob(j);
			masterIp = InetAddress.getByName("127.0.0.1");
			System.out.println("SIM: Creating first worker now,");
			Worker worker1 = new Worker("worker1", masterIp, 1337, 1338);
			Thread w1Thread = new Thread(worker1);
			w1Thread.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Attempts to encode a file locally with multiple worker threads.
	 * @param filepath Path of the video file to encode
	 */
	public void fullSimulation(String filepath){
		InetAddress masterIp;
		try {
			masterIp = InetAddress.getByName("127.0.0.1");
			System.out.println("SIM: Creating a job");
			Job j = new Job("testname", filepath, JobType.BITRATE_2_PASS_JOB, 5 * 60 * 1000);
			System.out.println("SIM: Creating first worker now,");
			Worker worker1 = new Worker("worker1", masterIp, 1337, 1338);
			Thread w1Thread = new Thread(worker1);
			w1Thread.start();
			System.out
					.println("SIM: Faking that master is not up... waiting 5 seconds to start master.");
			sleep(5000);
			System.out.println("SIM: Starting master now");
			
			Master m = new Master();
			Thread masterThread = new Thread(m);
			masterThread.start();
			sleep(2000);
			System.out.println("SIM: adding a job to master's queue !");
			m.addJob(j);
			sleep(5000);
			System.out.println("SIM: Creating second worker now");
			Worker worker2 = new Worker("worker2", masterIp, 1337, 1339);
			Thread w2Thread = new Thread(worker2);
			w2Thread.start();
			sleep(1000);
			System.out.println("SIM: Creating third worker now");
			Worker worker3 = new Worker("worker3", masterIp, 1337, 1340);
			Thread w3Thread = new Thread(worker3);
			w3Thread.start();
			sleep(10000);
			System.out.println("SIM: shutting down worker 3");
			worker3.shutdown();
			System.out.println("SIM: simulation completed !");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(String filepath) {
		basicSimulation(filepath);
//		fullSimulation(filepath);
	}
}
