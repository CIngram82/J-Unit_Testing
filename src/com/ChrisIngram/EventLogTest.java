package com.ChrisIngram;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class EventLogTest {
  EventLog testLog = new EventLog();

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {
  }
  @Test
  public void actionTypeCheck(){
    Event face = new Event("Name", "Face2Face");
    Event call = new Event("Name", "PhoneCall");
    Event txt = new Event("Name", "TextMessaging");
    Event unknown = new Event("Name", "Unknown");

//    assertTrue(face.getAction() == "Face2Face"); // Way I was going to build the tests.

    testLog.addEvent(face);
    testLog.addEvent(call);
    testLog.addEvent(txt);
    testLog.addEvent(unknown);

    assertEquals(4, testLog.getNumEvents()); // you just checked to see if all 4 got added.


  }

  @Test
  public void testNullFields() throws Exception {
    Event noParty = new Event(null, null);
    Event noName = new Event(null, "action");
    Event noAction = new Event("Name", null);

    expected.expect(IllegalArgumentException.class);
    testLog.addEvent(noParty);
    testLog.addEvent(noName);
    testLog.addEvent(noAction);
    testLog.addEvent(null);
  }

  @Test
  public void addEvent() throws Exception {

    int testNum = testLog.getNumEvents();
    Event party = new Event("Name", "Unknown");

    assertTrue(testLog.addEvent(party));
    assertTrue((testLog.getNumEvents() == testNum + 1));
  }

  @Rule
  public ExpectedException expected = ExpectedException.none();


  @Test
  public void getNumEvents() throws Exception {

  }

}