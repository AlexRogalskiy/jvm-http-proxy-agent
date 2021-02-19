package tech.httptoolkit.javaagent;

import net.bytebuddy.asm.Advice;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class ReturnProxyAdvice {
    @Advice.OnMethodExit
    public static void proxy(@Advice.Return(readOnly = false) Proxy returnValue) {
        returnValue = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
                HttpProxyAgent.getAgentProxyHost(),
                HttpProxyAgent.getAgentProxyPort()
        ));
    }
}
