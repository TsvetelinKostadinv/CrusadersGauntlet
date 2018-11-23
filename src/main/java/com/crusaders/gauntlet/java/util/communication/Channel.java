/*
 * 23/35/2018 at 13:35:11 ÷.
 * Channel.java created by Tsvetelin
 */

/**
 * 23/35/2018 at 13:35:11 ÷.
 * Channel.java created by Tsvetelin
 */
package com.crusaders.gauntlet.java.util.communication;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author Tsvetelin
 *
 */
public class Channel < WhatIsTranferred > implements Iterator< WhatIsTranferred >
{

    private volatile List< WhatIsTranferred > medium = new ArrayList<>();


    public void add ( WhatIsTranferred e )
    {

        medium.add( e );
    }


    public WhatIsTranferred read ()
    {

        return this.hasNext() ? this.medium.remove( 0 ) : null;
    }


    @Override
    public boolean hasNext ()
    {

        return !medium.isEmpty();
    }


    @Override
    public WhatIsTranferred next ()
    {

        return this.read();
    }

}
