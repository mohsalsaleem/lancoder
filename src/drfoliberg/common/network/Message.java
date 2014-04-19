package drfoliberg.common.network;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = -483657531000641905L;

    protected ClusterProtocol code;

    /**
     * Generic message object without unid.
     * See child AuthMessage object to use unid along with messages
     *
     * @param code
     */
    public Message(ClusterProtocol code) {
        this.code = code;
    }

    public ClusterProtocol getCode() {
        return code;
    }


}
