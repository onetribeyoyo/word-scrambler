/*
 *  Copyright (c) Andrew R. Miller 2009.  All Rights Reserved.
 *
 * $Id$
 */
package amiller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


/**
 *
 *
 *  @author  Andy Miller
 *  @version $Revision$, last changes made by $Author$ $Date$
 */
public class Main
    extends Object
{
    //~ Static variables/initializers --------------------------------------------------------------


    //~ Instance variables -------------------------------------------------------------------------


    //~ Constructors -------------------------------------------------------------------------------


    //~ Methods ------------------------------------------------------------------------------------

    public static void main(String[] args)
    {
        WordScrambler scrambler = new WordScrambler();
        for (int i = 0; i < args.length; i++) {
            String word = String.valueOf(args[i]);
            System.out.print(scrambler.scramble(word));
            System.out.print(" ");
        }
        System.out.println();
    }


    //~ Inner-classes ------------------------------------------------------------------------------

    }

// END OF FILE
