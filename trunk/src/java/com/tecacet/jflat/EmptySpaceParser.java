package com.tecacet.jflat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.tecacet.jflat.LineParser;

/**
 * Parses lines where the contents are seperated by anarbitrary number of spaces
 * 
 * @author Dimitri Papaioannou
 *
 */
public class EmptySpaceParser implements LineParser {

    @Override
    public String[] parseLine(String line) throws IOException {
        StringTokenizer st = new StringTokenizer(line, " ");
        List<String> columns = new ArrayList<String>();
        for (int col = 0; st.hasMoreTokens(); col++) {
            String token = st.nextToken().trim();
            columns.add(token);
        } // end for each column
        return columns.toArray(new String[columns.size()]);
    }

}