package org.pentaho.ui.xul.test.swing;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.pentaho.ui.xul.XulDomContainer;
import org.pentaho.ui.xul.components.XulTextbox;
import org.pentaho.ui.xul.containers.XulTabbox;
import org.pentaho.ui.xul.dom.Document;
import org.pentaho.ui.xul.swing.SwingXulLoader;

public class SwingTextboxTest {

  Document doc = null;
  XulDomContainer container;
  
  @Before
  public void setUp() throws Exception {
    
    container = new SwingXulLoader().loadXul("resource/documents/textboxtest.xul");
    doc = container.getDocumentRoot();
    
  }
  
  
  @Test
  public void maxLengthTest(){
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox1");
    
    assertEquals(10, txt.getMaxlength());
    txt.setMaxlength(15);
    assertEquals(15, txt.getMaxlength());
  }
  
  @Test
  public void maxTest(){
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox3");
    assertEquals("500", txt.getMax());
  }
  
  @Test
  public void minTest(){
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox3");
    assertEquals("4", txt.getMin());
  }
  
  @Test
  public void disabledText(){
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox2");
    assertTrue(txt.isDisabled());
    txt.setDisabled(false);
    assertTrue(!txt.isDisabled());
    
  }

  @Test
  public void multilineTest(){
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox1");
    assertTrue(txt.isMultiline());
  }

  @Test
  public void readonlyTest(){
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox1");
    assertTrue(txt.isReadonly());
  }
  
  @Test
  public void getTypeTest() throws Exception{
    
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox3");
    assertEquals("NUMERIC", txt.getType());
    
    txt = (XulTextbox) doc.getElementById("textbox1");
    assertEquals("NORMAL", txt.getType());
  }
  
  @Test
  public void getValue() throws Exception{
    
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox1");
    assertEquals("default", txt.getValue());
    
  }
  @Test
  public void numericTest() throws Exception{
    
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox3");

    txt.setValue("asd");
    assertEquals("", txt.getValue());
    txt.setValue("-");
    assertEquals("-", txt.getValue());
    txt.setValue("-12");
    assertEquals("-12", txt.getValue());
    txt.setValue("10.5");
    assertEquals("10.5", txt.getValue());
    txt.setValue("600");
    assertEquals("", txt.getValue());
  }

  @Test
  public void selectAllTest() throws Exception{
    
    XulTextbox txt = (XulTextbox) doc.getElementById("textbox3");
    txt.selectAll();
  }
  
}

  