package com.crusaders.gauntlet.java.keyPress;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.crusaders.gauntlet.java.util.KeySequence;

public class RobotKeyPresser implements KeyPresser, KeySequencePresser {
	
	Robot robo;
	
	private static boolean isShiftPressed = false; 
	private static boolean isAltPressed = false; 
	private static boolean isEscapePressed = false;
	private static boolean isControlPressed = false;
	private static boolean isDeletePressed = false;
	
	private static boolean isLeftMousePressed = false; 
	private static boolean isRightMousePressed = false; 
	private static boolean isMiddleMousePressed = false;
	
	public RobotKeyPresser()
	{
		initDependencies();
	}
	
	private void initDependencies() {
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pressKey( Integer key ) {
		
		if(key == null)
		{
			return;
		}
		
		switch (key.intValue()) {
		case KeyEvent.VK_SHIFT:
			if ( !isShiftPressed ) 
			{ 
			    pressShift(); 
			    isShiftPressed = true;
			} 
			else 
			{
			    releaseShift();
			    isShiftPressed = false;
			}
			break;
		case KeyEvent.VK_ALT:
		    if(!isAltPressed)
			{
				isAltPressed= true;
				pressAlt();
			}else{
				isAltPressed = false; 
				releaseAlt();
			}
		    break;
		case KeyEvent.VK_ESCAPE:
		    if(!isEscapePressed)
            {
		        isEscapePressed= true;
                pressEsc();
            }else{
                isEscapePressed = false; 
                releaseEsc();
            }
            break;
		case KeyEvent.VK_CONTROL:
		    if(!isControlPressed)
            {
		        isControlPressed= true;
                pressCtrl();
            }else{
                isControlPressed = false; 
                releaseCtrl();
            }
            break;
		case KeyEvent.VK_DELETE:
		    if(!isDeletePressed)
            {
		        isDeletePressed= true;
                pressDel();
            }else{
                isDeletePressed = false; 
                releaseDel();
            }
            break;
		case KeyEvent.VK_CAPS_LOCK: pressCaps(); break;
		case KeyEvent.VK_TAB: pressTab(); break;
		case KeyEvent.VK_F1: pressF(1); break;
		case KeyEvent.VK_F2: pressF(2); break;
		case KeyEvent.VK_F3: pressF(3); break;
		case KeyEvent.VK_F4: pressF(4); break;
		case KeyEvent.VK_F5: pressF(5); break;
		case KeyEvent.VK_F6: pressF(6); break;
		case KeyEvent.VK_F7: pressF(7); break;
		case KeyEvent.VK_F8: pressF(8); break;
		case KeyEvent.VK_F9: pressF(9); break;
		case KeyEvent.VK_F10: pressF(10); break;
		case KeyEvent.VK_F11: pressF(11); break;
		case KeyEvent.VK_F12: pressF(12); break;
		case KeyEvent.VK_PRINTSCREEN: pressPrtScreen();break;
		case KeyEvent.VK_PAUSE: pressPauseBreak(); break;
		case KeyEvent.VK_HOME: pressHome(); break;
		case KeyEvent.VK_PAGE_UP: pressPgUp(); break;
		case KeyEvent.VK_PAGE_DOWN: pressPgDown(); break;
		case KeyEvent.VK_NUM_LOCK: pressNumLock(); break;
            
		case KeyEvent.BUTTON1_DOWN_MASK:
            if(!isLeftMousePressed)
            {
                isLeftMousePressed= true;
                robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            }else{
                isLeftMousePressed = false; 
                robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            }
            break;
        case KeyEvent.BUTTON2_DOWN_MASK:
            if(!isRightMousePressed)
            {
                isRightMousePressed= true;
                robo.mousePress(KeyEvent.BUTTON2_DOWN_MASK);
            }else{
                isRightMousePressed = false; 
                robo.mouseRelease(KeyEvent.BUTTON2_DOWN_MASK);
            }
            break;
        case KeyEvent.BUTTON3_DOWN_MASK:
            if(!isMiddleMousePressed)
            {
                isMiddleMousePressed= true;
                robo.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
            }else{
                isMiddleMousePressed = false; 
                robo.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);
            }
            break;
		default:
		    singlePressButton( key );
			break;
		}
		
	}
	
	@Override
	public void pressMouse(Integer button) 
	{ 
	    switch ( button )
            {
                case KeyEvent.BUTTON1_DOWN_MASK : pressLeftMouseButton(); isLeftMousePressed = true ; break;
                case KeyEvent.BUTTON2_DOWN_MASK : pressMiddleMouseButton(); isMiddleMousePressed = true ; break;
                case KeyEvent.BUTTON3_DOWN_MASK : pressRightMouseButton(); isRightMousePressed = true; break;
            }
	}
	
	@Override
	public void releaseMouse(Integer button) { 
	    switch ( button )
        {
            case KeyEvent.BUTTON1_DOWN_MASK : releaseLeftMouseButton(); isLeftMousePressed = false ; break;
            case KeyEvent.BUTTON2_DOWN_MASK : releaseMiddleMouseButton(); isMiddleMousePressed = false ; break;
            case KeyEvent.BUTTON3_DOWN_MASK : releaseRightMouseButton(); isRightMousePressed = false ; break;
        }
	}

    @Override
    public void pressShift () { robo.keyPress( KeyEvent.VK_SHIFT );}
    @Override
    public void releaseShift(){ robo.keyRelease(KeyEvent.VK_SHIFT); }

    @Override
    public void pressKeys ( KeySequence keys ) {

        for(Integer i : keys.getKeysAsList())
        {
            pressKey(i);
        }
        
    }

    @Override
    public void pressCtrl () { robo.keyPress( KeyEvent.VK_CONTROL ); }
    @Override
    public void releaseCtrl () { robo.keyRelease( KeyEvent.VK_CONTROL ); }

    @Override
    public void pressEsc () { robo.keyPress( KeyEvent.VK_ESCAPE ); }
    @Override
    public void releaseEsc () { robo.keyRelease( KeyEvent.VK_ESCAPE ); }

    @Override
    public void pressDel () { robo.keyPress( KeyEvent.VK_DELETE ); }
    @Override
    public void releaseDel () { robo.keyRelease( KeyEvent.VK_DELETE ); }

    @Override
    public void pressAlt () { robo.keyPress( KeyEvent.VK_ALT );}
    @Override
    public void releaseAlt () { robo.keyRelease( KeyEvent.VK_ALT ); }

    @Override
    public void pressCaps () { singlePressButton( KeyEvent.VK_CAPS_LOCK ); }

    @Override
    public void pressTab () { singlePressButton( KeyEvent.VK_TAB ); }
    
    @Override
    public void singlePressButton(Integer key) 
    {
        robo.keyPress(key);
        robo.keyRelease(key);
    }
    
    @Override
    public void pressF ( int index ) {

        switch ( index )
            {
                case 1 :
                    pressF1();
                    break;
                case 2 :
                    pressF2();
                    break;
                case 3 :
                    pressF3();
                    break;
                case 4 :
                    pressF4();
                    break;
                case 5 :
                    pressF5();
                    break;
                case 6 :
                    pressF6();
                    break;
                case 7 :
                    pressF7();
                    break;
                case 8 :
                    pressF8();
                    break;
                case 9 :
                    pressF9();
                    break;
                case 10 :
                    pressF10();
                    break;
                case 11 :
                    pressF11();
                    break;
                case 12 :
                    pressF12();
                    break;
                
            }
        
    }

    @Override
    public void pressF1 () { singlePressButton( KeyEvent.VK_F1 ); }
    @Override
    public void pressF2 () { singlePressButton( KeyEvent.VK_F2 ); }
    @Override
    public void pressF3 () { singlePressButton( KeyEvent.VK_F3 ); }
    @Override
    public void pressF4 () { singlePressButton( KeyEvent.VK_F4 ); }
    @Override
    public void pressF5 () { singlePressButton( KeyEvent.VK_F5 ); }
    @Override
    public void pressF6 () { singlePressButton( KeyEvent.VK_F6 ); }
    @Override
    public void pressF7 () { singlePressButton( KeyEvent.VK_F7 ); }
    @Override
    public void pressF8 () { singlePressButton( KeyEvent.VK_F8 ); }
    @Override
    public void pressF9 () { singlePressButton( KeyEvent.VK_F9 ); }
    @Override
    public void pressF10 () { singlePressButton( KeyEvent.VK_F10 ); }
    @Override
    public void pressF11 () { singlePressButton( KeyEvent.VK_F11 ); }
    @Override
    public void pressF12 () { singlePressButton( KeyEvent.VK_F12 ); }

    @Override
    public void pressPrtScreen () { singlePressButton( KeyEvent.VK_PRINTSCREEN ); }

    @Override
    public void pressPauseBreak () { singlePressButton( KeyEvent.VK_PAUSE ); }

    @Override
    public void pressHome () { singlePressButton( KeyEvent.VK_HOME ); }

    @Override
    public void pressPgUp () { singlePressButton( KeyEvent.VK_PAGE_UP ); }

    @Override
    public void pressPgDown () { singlePressButton( KeyEvent.VK_PAGE_DOWN ); }

    @Override
    public void pressNumLock () { singlePressButton( KeyEvent.VK_NUM_LOCK ); }

    @Override
    public void pressLeftMouseButton () { robo.keyPress( KeyEvent.BUTTON1_DOWN_MASK ); }
    @Override
    public void releaseLeftMouseButton () { robo.keyRelease( KeyEvent.BUTTON1_DOWN_MASK ); }
    
    @Override
    public void pressRightMouseButton () { robo.keyPress( KeyEvent.BUTTON3_DOWN_MASK ); }
    @Override
    public void releaseRightMouseButton () { robo.keyRelease( KeyEvent.BUTTON3_DOWN_MASK ); }

    @Override
    public void pressMiddleMouseButton () { robo.keyPress( KeyEvent.BUTTON2_DOWN_MASK ); }
    @Override
    public void releaseMiddleMouseButton () { robo.keyRelease( KeyEvent.BUTTON2_DOWN_MASK ); }
}
