//18.08.2018 ã. at 15:30:09
//ActionTaker.java created by Tsvetelin

package com.crusaders.gauntlet.java.actions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionTaker
{
    
}
