package com.ChrisIngram;

import java.util.ArrayList;
import java.util.List;

public class EventLog {

  private List<Event> eventList;



  public EventLog() {
    this.eventList = new ArrayList<>();

  }

  public boolean addEvent(Event event)throws IllegalArgumentException{
    if (event == null){
      throw new IllegalArgumentException("Event is null");
    }
    if (event.getAction() == null || event.getName() == null){
      throw new IllegalArgumentException("Event.Action or Event.name is null");
    }

    switch(event.getAction()){
      case "Face2Face":
      case "PhoneCall":
      case "TextMessaging":
      case "Unknown":
        break;
      default:
        throw new IllegalArgumentException("Event Action is invalid");
    }


    System.out.println(event.getName() + " " + event.getAction());
    eventList.add(event);
    return true;
  }

  public int getNumEvents(){
    return eventList.size();
  }

  public EventLog(List<Event> eventList) {
    this.eventList = eventList;
  }
}
