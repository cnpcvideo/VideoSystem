package org.jboss.errai.ioc.client.api;

import org.jboss.errai.ioc.client.api.Bootstrapper;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.ioc.client.ContextualProviderContext;
import org.cnpc.system.client.local.App;
import javax.enterprise.event.Event;
import org.jboss.errai.ioc.client.InterfaceInjectionContext;
import org.jboss.errai.ioc.client.api.BootstrapperImpl;
import java.lang.annotation.Annotation;
import org.cnpc.system.client.shared.PersonVo;
import org.jboss.errai.ioc.client.api.builtin.MessageBusProvider;
import org.jboss.errai.enterprise.client.cdi.AbstractCDIEventCallback;
import org.jboss.errai.bus.client.api.Message;
import java.util.Set;
import org.jboss.errai.enterprise.client.cdi.CDIProtocol;
import org.cnpc.system.client.shared.ResponseEvent;

public class BootstrapperImpl implements Bootstrapper {
    private native static void org_jboss_errai_enterprise_client_cdi_EventProvider_context(EventProvider instance, ContextualProviderContext value) /*-{
        instance.@org.jboss.errai.enterprise.client.cdi.EventProvider::context = value;
    }-*/;

    private native static ContextualProviderContext org_jboss_errai_enterprise_client_cdi_EventProvider_context(EventProvider instance) /*-{
        return instance.@org.jboss.errai.enterprise.client.cdi.EventProvider::context;
    }-*/;

    private native static void org_cnpc_system_client_local_App_personEvent(App instance, Event value) /*-{
        instance.@org.cnpc.system.client.local.App::personEvent = value;
    }-*/;

    private native static Event org_cnpc_system_client_local_App_personEvent(App instance) /*-{
        return instance.@org.cnpc.system.client.local.App::personEvent;
    }-*/;

    public InterfaceInjectionContext bootstrapContainer() {
        InterfaceInjectionContext ctx = new InterfaceInjectionContext();
        final App inj18 = new App();
        final EventProvider inj3 = new EventProvider();
        BootstrapperImpl.org_jboss_errai_enterprise_client_cdi_EventProvider_context(inj3, new ContextualProviderContext() {
            public java.lang.annotation.Annotation[] getQualifiers() {
                return new Annotation[0];
            }
            public Class[] getTypeArguments() {
                return new Class[] { PersonVo.class };
            }

        });
        BootstrapperImpl.org_cnpc_system_client_local_App_personEvent(inj18, (inj3).get());
        final MessageBusProvider inj15 = new MessageBusProvider();
        ((inj15).get()).subscribe("cdi.event:org.cnpc.system.client.shared.ResponseEvent", new AbstractCDIEventCallback() {
            public void callback(Message message) {
                Set<String> msgQualifiers = message.get(Set.class, CDIProtocol.QUALIFIERS);
                if (this.qualifiers.equals(msgQualifiers) || ((msgQualifiers == null) && this.qualifiers.isEmpty())) {
                    inj18.response(message.get(ResponseEvent.class, CDIProtocol.OBJECT_REF));
                }
            }

        });
        inj18.buildUI();
        return ctx;
    }
}