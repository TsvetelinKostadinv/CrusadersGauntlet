//18.08.2018 ã. at 15:30:09
//ActionTaker.java created by Tsvetelin

package com.crusaders.gauntlet.java.actions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * This annotates an object which can execute actions for given Gauntlet input data. <br>
 * They can be stored in the <code>ActionManager</code> who in turn will execute when the container is called <br>
 * This helps to make the API better
 * 
 * 
 * @author Tsvetelin
 *
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionTaker
{
    
}
