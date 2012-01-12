package org.jboss.errai.bus.client.ext;

import com.google.gwt.json.client.JSONValue;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;

public class ExtensionsLoaderImpl implements org.jboss.errai.bus.client.ext.ExtensionsLoader {
  public ExtensionsLoaderImpl() { 
    super();
  }
  public void initExtensions(final org.jboss.errai.bus.client.framework.MessageBus bus) { 

org.jboss.errai.common.client.types.TypeDemarshallers.addDemarshaller(
    org.cnpc.system.client.shared.PersonVo.class,
    new org.jboss.errai.common.client.types.Demarshaller<org.cnpc.system.client.shared.PersonVo>() {
        public org.cnpc.system.client.shared.PersonVo demarshall(com.google.gwt.json.client.JSONObject o, org.jboss.errai.common.client.types.DecodingContext decodingContext) {
            Object v = null;
            try {
final org.cnpc.system.client.shared.PersonVo n = new org.cnpc.system.client.shared.PersonVo();
JSONString secondName = o.get("secondName").isString(); if (secondName != null) { n.setSecondName(secondName.stringValue()); }

JSONString firstName = o.get("firstName").isString(); if (firstName != null) { n.setFirstName(firstName.stringValue()); }

return n;
            }
            catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("could not demarshall type: org.cnpc.system.client.shared.PersonVo; value=" + o, e);
            }
        }
    }
);


org.jboss.errai.common.client.types.TypeMarshallers.addMarshaller(
    org.cnpc.system.client.shared.PersonVo.class,
    new org.jboss.errai.common.client.types.Marshaller<org.cnpc.system.client.shared.PersonVo>() {
        public String marshall(org.cnpc.system.client.shared.PersonVo o, org.jboss.errai.common.client.types.EncodingContext ctx) {
            if (ctx.isEncoded(o)) return "{\"__EncodedType\":\"org.cnpc.system.client.shared.PersonVo\",\"__ObjectID\":\"$" + ctx.markRef(o) + "\"}";

            try {

                ctx.markEncoded(o);
                StringBuilder json = new StringBuilder("{\"__EncodedType\":\"org.cnpc.system.client.shared.PersonVo\",\"__ObjectID\":\"" + o.hashCode() + "\"");
                
                json.append(",");
                org.jboss.errai.common.client.json.JSONEncoderCli jsonEncoder = new org.jboss.errai.common.client.json.JSONEncoderCli();
                json.append("\"secondName\":").append(jsonEncoder.encode(o.getSecondName(), ctx)).append(",\"firstName\":").append(jsonEncoder.encode(o.getFirstName(), ctx)).append("}");
                return json.toString();
                
                
            }
            catch (Exception e) {
                System.out.println("o=" + o + ";ctx=" + ctx);
                e.printStackTrace();
                return null;
            }
        }
    }
);
org.jboss.errai.common.client.types.TypeDemarshallers.addDemarshaller(
    org.cnpc.system.client.shared.MessageEvent.class,
    new org.jboss.errai.common.client.types.Demarshaller<org.cnpc.system.client.shared.MessageEvent>() {
        public org.cnpc.system.client.shared.MessageEvent demarshall(com.google.gwt.json.client.JSONObject o, org.jboss.errai.common.client.types.DecodingContext decodingContext) {
            Object v = null;
            try {
final org.cnpc.system.client.shared.MessageEvent n = new org.cnpc.system.client.shared.MessageEvent();
JSONString message = o.get("message").isString(); if (message != null) { n.setMessage(message.stringValue()); }



n.setId(new Double(o.get("id").isNumber().doubleValue()).intValue());

JSONString gentle = o.get("gentle").isString(); if (gentle != null) { n.setGentle(gentle.stringValue()); }

JSONString secondName = o.get("secondName").isString(); if (secondName != null) { n.setSecondName(secondName.stringValue()); }

JSONString birthDate = o.get("birthDate").isString(); if (birthDate != null) { n.setBirthDate(birthDate.stringValue()); }

JSONString firstName = o.get("firstName").isString(); if (firstName != null) { n.setFirstName(firstName.stringValue()); }

return n;
            }
            catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("could not demarshall type: org.cnpc.system.client.shared.MessageEvent; value=" + o, e);
            }
        }
    }
);


org.jboss.errai.common.client.types.TypeMarshallers.addMarshaller(
    org.cnpc.system.client.shared.MessageEvent.class,
    new org.jboss.errai.common.client.types.Marshaller<org.cnpc.system.client.shared.MessageEvent>() {
        public String marshall(org.cnpc.system.client.shared.MessageEvent o, org.jboss.errai.common.client.types.EncodingContext ctx) {
            if (ctx.isEncoded(o)) return "{\"__EncodedType\":\"org.cnpc.system.client.shared.MessageEvent\",\"__ObjectID\":\"$" + ctx.markRef(o) + "\"}";

            try {

                ctx.markEncoded(o);
                StringBuilder json = new StringBuilder("{\"__EncodedType\":\"org.cnpc.system.client.shared.MessageEvent\",\"__ObjectID\":\"" + o.hashCode() + "\"");
                
                json.append(",");
                org.jboss.errai.common.client.json.JSONEncoderCli jsonEncoder = new org.jboss.errai.common.client.json.JSONEncoderCli();
                json.append("\"message\":").append(jsonEncoder.encode(o.getMessage(), ctx)).append(",\"id\":").append(jsonEncoder.encode(o.getId(), ctx)).append(",\"gentle\":").append(jsonEncoder.encode(o.getGentle(), ctx)).append(",\"secondName\":").append(jsonEncoder.encode(o.getSecondName(), ctx)).append(",\"birthDate\":").append(jsonEncoder.encode(o.getBirthDate(), ctx)).append(",\"firstName\":").append(jsonEncoder.encode(o.getFirstName(), ctx)).append("}");
                return json.toString();
                
                
            }
            catch (Exception e) {
                System.out.println("o=" + o + ";ctx=" + ctx);
                e.printStackTrace();
                return null;
            }
        }
    }
);
org.jboss.errai.common.client.types.TypeDemarshallers.addDemarshaller(
    org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent.class,
    new org.jboss.errai.common.client.types.Demarshaller<org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent>() {
        public org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent demarshall(com.google.gwt.json.client.JSONObject o, org.jboss.errai.common.client.types.DecodingContext decodingContext) {
            Object v = null;
            try {
final org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent n = new org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent();
return n;
            }
            catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("could not demarshall type: org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent; value=" + o, e);
            }
        }
    }
);


org.jboss.errai.common.client.types.TypeMarshallers.addMarshaller(
    org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent.class,
    new org.jboss.errai.common.client.types.Marshaller<org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent>() {
        public String marshall(org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent o, org.jboss.errai.common.client.types.EncodingContext ctx) {
            if (ctx.isEncoded(o)) return "{\"__EncodedType\":\"org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent\",\"__ObjectID\":\"$" + ctx.markRef(o) + "\"}";

            try {

                ctx.markEncoded(o);
                StringBuilder json = new StringBuilder("{\"__EncodedType\":\"org.jboss.errai.enterprise.client.cdi.events.BusReadyEvent\",\"__ObjectID\":\"" + o.hashCode() + "\"");
                
                return json.append("}").toString();
                
                
            }
            catch (Exception e) {
                System.out.println("o=" + o + ";ctx=" + ctx);
                e.printStackTrace();
                return null;
            }
        }
    }
);
org.jboss.errai.common.client.types.TypeDemarshallers.addDemarshaller(
    org.cnpc.system.client.shared.ResponseEvent.class,
    new org.jboss.errai.common.client.types.Demarshaller<org.cnpc.system.client.shared.ResponseEvent>() {
        public org.cnpc.system.client.shared.ResponseEvent demarshall(com.google.gwt.json.client.JSONObject o, org.jboss.errai.common.client.types.DecodingContext decodingContext) {
            Object v = null;
            try {
final org.cnpc.system.client.shared.ResponseEvent n = new org.cnpc.system.client.shared.ResponseEvent();
JSONString message = o.get("message").isString(); if (message != null) { n.setMessage(message.stringValue()); }



n.setId(new Double(o.get("id").isNumber().doubleValue()).intValue());

return n;
            }
            catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("could not demarshall type: org.cnpc.system.client.shared.ResponseEvent; value=" + o, e);
            }
        }
    }
);


org.jboss.errai.common.client.types.TypeMarshallers.addMarshaller(
    org.cnpc.system.client.shared.ResponseEvent.class,
    new org.jboss.errai.common.client.types.Marshaller<org.cnpc.system.client.shared.ResponseEvent>() {
        public String marshall(org.cnpc.system.client.shared.ResponseEvent o, org.jboss.errai.common.client.types.EncodingContext ctx) {
            if (ctx.isEncoded(o)) return "{\"__EncodedType\":\"org.cnpc.system.client.shared.ResponseEvent\",\"__ObjectID\":\"$" + ctx.markRef(o) + "\"}";

            try {

                ctx.markEncoded(o);
                StringBuilder json = new StringBuilder("{\"__EncodedType\":\"org.cnpc.system.client.shared.ResponseEvent\",\"__ObjectID\":\"" + o.hashCode() + "\"");
                
                json.append(",");
                org.jboss.errai.common.client.json.JSONEncoderCli jsonEncoder = new org.jboss.errai.common.client.json.JSONEncoderCli();
                json.append("\"message\":").append(jsonEncoder.encode(o.getMessage(), ctx)).append(",\"id\":").append(jsonEncoder.encode(o.getId(), ctx)).append("}");
                return json.toString();
                
                
            }
            catch (Exception e) {
                System.out.println("o=" + o + ";ctx=" + ctx);
                e.printStackTrace();
                return null;
            }
        }
    }
);}
}
