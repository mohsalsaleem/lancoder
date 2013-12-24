package drfoliberg.master;

import java.net.InetAddress;

import drfoliberg.Status;

public class Node {

	private InetAddress nodeAddress;
	private int nodePort;
	private Status status;

	public Node(InetAddress nodeAddresse, int nodePort) {
		this.nodeAddress = nodeAddresse;
		this.status = Status.NOT_CONNECTED;
		this.nodePort = nodePort;
	}

	public boolean equals(Object o) {
		boolean equals = false;
		if (o instanceof Node) {
			Node n = (Node) o;
			if (n.getNodeAddress().equals(this.getNodeAddress()) && n.getNodePort() == this.getNodePort()) {
				equals = true;
			}
		}
		return equals;

	}

	public InetAddress getNodeAddress() {
		return nodeAddress;
	}

	public void setNodeAddress(InetAddress nodeAddress) {
		this.nodeAddress = nodeAddress;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getNodePort() {
		return nodePort;
	}

	public void setNodePort(int nodePort) {
		this.nodePort = nodePort;
	}

}
