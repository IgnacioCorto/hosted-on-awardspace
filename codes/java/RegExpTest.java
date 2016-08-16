// http://docs.oracle.com/javase/tutorial/essential/regex/test_harness.html

package com.topcoder.luis3ignacio.inv2001semicd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {

	public RegExpTest() {

		Pattern pattern = Pattern.compile("(\\d)(\\d)+");
		Matcher matcher = pattern.matcher("123");

		boolean found = false;
		while (matcher.find()) {
			for (int groupNo = 0; groupNo <= matcher
					.groupCount(); groupNo++) {
				System.out.format("Group %d: \"%s\" at %d-%d\n", groupNo, matcher
						.group(groupNo), matcher.start(groupNo),
						matcher.end(groupNo));
				found = true;
			}
		}
		if (!found) {
			System.out.format("No match found.%n");
		}

	}

}
