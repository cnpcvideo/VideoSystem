/*
 * Copyright 2009 JBoss, a divison Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cnpc.system.server;


import java.util.ArrayList;
import java.util.List;

import org.cnpc.system.client.shared.MessageEvent;
import org.cnpc.system.client.shared.PModle;
import org.cnpc.system.client.shared.PersonVo;
import org.cnpc.system.client.shared.ResponseEvent;
import org.cnpc.system.dao.PersonDAO;
import org.cnpc.system.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * A very simple CDI based service.
 */
@ApplicationScoped
public class SimpleCDIService {
    @Inject
    private Event<ResponseEvent> responseEvent;
    @Inject
    private PersonDAO personDAO;
    
    private ResponseEvent respEvent= new ResponseEvent();
    
    public void addPersonHandler(@Observes PersonVo personVo){
    	Person person = new Person();
    	String firstName = personVo.getFirstName();//new String(personVo.getFirstName().getBytes("iso8859-1"),"utf-8");
    	String secondName = personVo.getSecondName();//new String(personVo.getSecondName().getBytes("iso8859-1"),"utf-8");
    	person.setCurrentFirstName(firstName);
    	person.setCurrentLastName(secondName);
    	System.out.println("Received Message from Client: " + personVo.getFirstName() + " " + person.getCurrentLastName());
    	personDAO.savePerson(person);
        PModle pModle1 = new PModle();
        PModle pModle2 = new PModle();
        PModle pModle3 = new PModle();
        ArrayList<PModle> pmodleList = new ArrayList<PModle>();
        pModle1.setString1("pmodle1");
        pModle2.setString1("pmodle2");
        pModle3.setString1("pmodle3");
        pmodleList.add(pModle1);
        pmodleList.add(pModle2);
        pmodleList.add(pModle3);
        respEvent.setPmodleList(pmodleList);
        for (int i = 0; i < 2; i++) {
			
		}
        responseEvent.fire(respEvent);
    }
    
    public void deletePersonHandler(@Observes MessageEvent messageEvent){

    }
}
