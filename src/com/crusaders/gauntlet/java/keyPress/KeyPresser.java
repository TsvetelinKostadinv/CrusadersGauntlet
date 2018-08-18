package com.crusaders.gauntlet.java.keyPress;

public interface KeyPresser 
{
    void pressShift();
	void releaseShift();
	
    void pressCtrl();
    void releaseCtrl();
    
    void pressEsc();
    void releaseEsc();
    
    void pressDel();
    void releaseDel();
    
    void pressAlt();
    void releaseAlt();
    
    void pressF(int index);
    
    void pressF1();
    void pressF2();
    void pressF3();
    void pressF4();
    void pressF5();
    void pressF6();
    void pressF7();
    void pressF8();
    void pressF9();
    void pressF10();
    void pressF11();
    void pressF12();
    
    void pressCaps();
    
    void pressTab();
    
    void pressPrtScreen();
    
    void pressPauseBreak();
    
    void pressHome();
    
    void pressPgUp();
    void pressPgDown();
    
    void pressNumLock();
	
	void pressKey(Integer key);
	
	void singlePressButton(Integer key);
	
	public void pressMouse(Integer button);
	public void releaseMouse(Integer button);
	
	public void pressLeftMouseButton();
	public void releaseLeftMouseButton();
	
	public void pressRightMouseButton();
    public void releaseRightMouseButton();
    
    public void pressMiddleMouseButton();
    public void releaseMiddleMouseButton();
	
}
