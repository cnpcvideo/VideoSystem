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
package org.cnpc.system.client.local;

import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.EntryPoint;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import org.cnpc.system.client.shared.PersonVo;
import org.cnpc.system.client.shared.ResponseEvent;

/**
 * Main application entry point.
 */
@EntryPoint
public class App {
    @Inject
    private Event<PersonVo> personEvent;
    
    private PersonVo personVo = new PersonVo();
    
    private final Label responseLabel = new Label();

    @PostConstruct
    public void buildUI() {
    	
    	final FlexTable flexTable = new FlexTable();
        final TextBox textNameBox = new TextBox();
        final TextBox textSexBox = new TextBox();
        final Label tipLabel = new Label("请输入联系人信息："); 
        final Grid grid = new Grid(4, 3);
        final Button addContractButton = new Button("增加联系人");
        
        flexTable.setText(0, 0, "姓名");
        flexTable.setText(0, 1, "性别");
        flexTable.setText(0, 2, "ID");
        flexTable.setText(0, 3, "电话");
        flexTable.setText(0, 4, "删除");
        flexTable.setStyleName("watchList");
        flexTable.getCellFormatter().addStyleName(0, 0, "watchListNumericColumn");
        flexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
        flexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
        flexTable.getCellFormatter().addStyleName(0, 3, "watchListNumericColumn");
        flexTable.getCellFormatter().addStyleName(0, 4, "watchListRemoveColumn");


        //输入框
        grid.setText(0, 0, "姓：");
        grid.setText(1, 0, "名：");
        grid.setWidget(0, 1, textNameBox);
        grid.setWidget(1, 1, textSexBox);
        grid.setWidget(1, 2, addContractButton);
        
        VerticalPanel verticalMainPanel = new VerticalPanel();
        verticalMainPanel.add(flexTable);
        verticalMainPanel.add(tipLabel);
        verticalMainPanel.add(grid);
        verticalMainPanel.add(responseLabel);
        
        addContractButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				personVo.setFirstName(textNameBox.getText());
				personVo.setSecondName(textSexBox.getText());
				personEvent.fire(personVo);
			}
		}); 
        RootPanel.get().add(verticalMainPanel);
    }

    public void response(@Observes ResponseEvent event) {
    	String messageString = "";
		messageString = event.getMessage();
        responseLabel.setText("Message from Server: " + messageString);
    }
}