package org.pentaho.ui.xul.test.swt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JCheckBox;

import org.dom4j.Document;
import org.eclipse.swt.widgets.Button;
import org.junit.Before;
import org.junit.Test;
import org.pentaho.ui.xul.XulDomContainer;
import org.pentaho.ui.xul.XulRunner;
import org.pentaho.ui.xul.components.XulCheckbox;
import org.pentaho.ui.xul.swt.SwtXulLoader;

public class SwtCheckboxTest {

  XulRunner runner = null;
  Document doc = null;
  XulDomContainer container;
  XulCheckbox check;
  XulCheckbox check2;
  
  @Before
  public void setUp() throws Exception {
    
    container = new SwtXulLoader().loadXul("resource/documents/allTags.xul");

    check = (XulCheckbox) container.getDocumentRoot().getElementById("checkbox");
    check2 = (XulCheckbox) container.getDocumentRoot().getElementById("checkbox2");
      
  }


  @Test
  public final void testLabel() {
    assertEquals("test", check.getLabel());
  }
  
  @Test
  public final void testCommand() {
    assertEquals("foo.test()", check.getCommand());
  }
  
  
  @Test
  public final void testIsChecked() {
    assertTrue(check.isChecked());
  }
  
  @Test
  public final void testSetChecked() {
    check2.setChecked(false);
    assertTrue(!check2.isChecked());
    check2.setChecked(true);
    assertTrue(check2.isChecked());
    
  }

  @Test
  public final void testIsDisabled() {
    assertTrue(!check.isDisabled());
  }

  @Test
  public final void testSetDisabled() {
    check.setDisabled(true);
    assertTrue(check.isDisabled());
    check.setDisabled(false);
    assertTrue(!check.isDisabled());
  }
  
  @Test
  public final void setManagedObject(){
    assertTrue(check.getManagedObject() instanceof Button);
  }
  
}
