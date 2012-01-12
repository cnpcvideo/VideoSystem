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

import java.io.UnsupportedEncodingException;

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
    
    public void addPersonHandler(@Observes PersonVo personVo) throws UnsupportedEncodingException {
    	Person person = new Person();
    	String firstNameString = new String(personVo.getFirstName().getBytes("iso8859-1"),"utf-8");
    	String secondNameString = new String(personVo.getSecondName().getBytes("iso8859-1"),"utf-8");
    	person.setCurrentFirstName(firstNameString);
    	person.setCurrentLastName(secondNameString);
    	System.out.println("Received Message from Client: " + personVo.getFirstName());
    	personDAO.savePerson(person);
        
        responseEvent.fire(new ResponseEvent(personVo.getFirstName() + " @ timemillis: " + System.currentTimeMillis()));
    }
}
