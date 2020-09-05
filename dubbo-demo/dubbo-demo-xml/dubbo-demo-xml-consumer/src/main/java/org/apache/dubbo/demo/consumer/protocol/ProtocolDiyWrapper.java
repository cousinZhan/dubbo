package org.apache.dubbo.demo.consumer.protocol;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.RpcException;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/8/22 14:29
 * @description： 自定义的协议包装类
 */
public class ProtocolDiyWrapper implements Protocol {

    private Protocol protocol;

    public ProtocolDiyWrapper(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public int getDefaultPort() {
        return 0;
    }

    @Override
    public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException {
        return null;
    }

    @Override
    public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {
        System.out.println("start : 我是自定义的包装类 *************** + type : " + type.getCanonicalName() + " + url : " + url.toFullString());
        return protocol.refer(type, url);
    }

    @Override
    public void destroy() {

    }
}
