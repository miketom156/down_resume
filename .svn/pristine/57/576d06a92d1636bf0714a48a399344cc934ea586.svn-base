/**
 * Copyright (c) 2000-2003 Liferay Corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.job5156.util;

import java.util.Collection;
import java.util.Map;


/**
 * <a href="Validator.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Chan
 * @version $Revision: 1.1.1.1 $
 *
 */
public class Validator {

	public static boolean isAddress(String address) {
		if (isNull(address)) {
			return false;
		}

		char[] c = address.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if ((!isChar(c[i])) &&
				(!isDigit(c[i])) &&
				(!Character.isWhitespace(c[i]))) {

				return false;
			}
		}

		return true;
	}

	public static boolean isChar(char c) {
		return Character.isLetter(c);
	}

	public static boolean isChar(String s) {
		if (isNull(s)) {
			return false;
		}

		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (!isChar(c[i])) {
				return false;
			}
		}

		return true;
	}

	public static boolean isCreditCard(String number) {
		return isLUHN(number);
	}

	public static boolean isDigit(char c) {
		int x = (int)c;

		if ((x >= 48) && (x <= 57)) {
			return true;
		}

		return false;
	}

	public static boolean isDigit(String s) {
		if (isNull(s)) {
			return false;
		}

		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (!isDigit(c[i])) {
				return false;
			}
		}

		return true;
	}
    public static boolean isFloat(String s) {
        if (isNull(s)) {
            return false;
        }
        boolean hasDot = false;
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i]=='.'&&!hasDot) {
                hasDot = true;
            }
            else if(c[i]=='.'&&hasDot)
            {
                return false;
            }
            else if(!isDigit(c[i]))
            {
                return false;
            }
        }

        return true;
    }


	public static boolean isHex(String s) {
		if (isNull(s)) {
			return false;
		}

		return true;
	}

	public static boolean isHTML(String s) {
		if (isNull(s)) {
			return false;
		}

		if (((s.indexOf("<html>") != -1) || (s.indexOf("<HTML>") != -1)) &&
			((s.indexOf("</html>") != -1) || (s.indexOf("</HTML>") != -1))) {

			return true;
		}

		return false;
	}

	public static boolean isLUHN(String number) {
		if (number == null) {
			return false;
		}

		number = StringUtil.reverse(number);

		int total = 0;

		for (int i = 0; i < number.length(); i++) {
			int x = 0;

			if (((i + 1) % 2) == 0) {
				x = Integer.parseInt(number.substring(i, i + 1)) * 2;

				if (x >= 10) {
					String s = Integer.toString(x);

					x = Integer.parseInt(s.substring(0, 1)) +
						Integer.parseInt(s.substring(1, 2));
				}
			}
			else {
				x = Integer.parseInt(number.substring(i, i + 1));
			}

			total = total + x;
		}

		if ((total % 10) == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isEmailAddress(String ea) {
		if (isNull(ea)) {
			return false;
		}

		int eaLength = ea.length();

		if (eaLength < 6) {

			// j@j.c

			return false;
		}

        int at = ea.indexOf('@');

        if ((at > 24) || (at == -1) || (at == 0) ||
			((at <= eaLength) && (at > eaLength - 5))) {

			// 123456789012345678901234@joe.com
			// joe.com
			// @joe.com
			// joe@joe
			// joe@jo
			// joe@j

			return false;
		}

		int dot = ea.lastIndexOf('.');

		if ((dot == -1) || (dot < at) || (dot > eaLength - 3)) {

			// joe@joecom
			// joe.@joecom
			// joe@joe.c

			return false;
		}

		if (ea.indexOf("..") != -1) {

			// joe@joe..com

			return false;
		}

		char[] name = ea.substring(0, at).toCharArray();

		for (int i = 0; i < name.length; i++) {
			if ((!isChar(name[i])) &&
				(!isDigit(name[i])) &&
				(name[i] != '.') &&
				(name[i] != '-') &&
				(name[i] != '_')) {

				return false;
			}
		}

		if ((name[0] == '.') || (name[name.length - 1] == '.') ||
			(name[0] == '-') || (name[name.length - 1] == '-') ||
			(name[0] == '_')) { // || (name[name.length - 1] == '_')) {

			// .joe.@joe.com
			// -joe-@joe.com
			// _joe_@joe.com

			return false;
		}

        char[] host = ea.substring(at + 1, ea.length()).toCharArray();

		for (int i = 0; i < host.length; i++) {
			if ((!isChar(host[i])) &&
				(!isDigit(host[i])) &&
				(host[i] != '.') &&
				(host[i] != '-')) {

				return false;
			}
		}

		if ((host[0] == '.') || (host[host.length - 1] == '.') ||
			(host[0] == '-') || (host[host.length - 1] == '-')) {

			// joe@.joe.com.
			// joe@-joe.com-

			return false;
		}

        return true;
	}

	public static boolean isValidEmailAddress(String ea) {
		if (isEmailAddress(ea)) {
		}

		return false;
	}

	public static boolean isName(String name) {
		if (isNull(name)) {
			return false;
		}

		char[] c = name.trim().toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (((!isChar(c[i])) &&
				(!Character.isWhitespace(c[i]))) ||
					(c[i] == ',')) {

				return false;
			}
		}

		return true;
	}

	public static boolean isNumber(String number) {
		if (isNull(number)) {
			return false;
		}

		char[] c = number.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (!isDigit(c[i])) {
				return false;
			}
		}

		return true;
	}

	public static boolean isNull(String s) {
		if (s == null) {
			return true;
		}
		s = s.trim();
		//为了快速倒换位置 fox
		return (s.equalsIgnoreCase(StringPool.BLANK) || s.equalsIgnoreCase(StringPool.NULL));
	}
	
	public static boolean isNull(Collection coll) {
			if (coll == null) {
				return true;
			}
			if(coll.size()==0)
				return true;			
			return false;
	}
	
	public static boolean isNotNull(Collection coll) {
		return !isNull(coll);
	}
		
	public static boolean isNull(Map map) {
			if (map == null) {
				return true;
			}
			if(map.size()==0)
				return true;			
			return false;
			}
	
		public static boolean isNotNull(Map map) {
			return !isNull(map);
		}
		
		
	public static boolean isNotNull(String s) {
		return !isNull(s);
	}

	public static boolean isPassword(String password) {
		if (isNull(password)) {
			return false;
		}

		if (password.length() < 4) {
			return false;
		}

		char[] c = password.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if ((!isChar(c[i])) &&
				(!isDigit(c[i]))) {

				return false;
			}
		}

		return true;
	}

	public static boolean isPhoneNumber(String phoneNumber) {
		return isNumber(PhoneNumber.strip(phoneNumber));
	}
	
	public static boolean isIPAdress(String ipAddress)
	{
		if (isNull(ipAddress)) {
			return false;
		}
		ipAddress= ipAddress.trim().replace('.',',');
		String[] ips = ipAddress.split(",");
		
		if(ips.length!=4)
			return false;
		for(int i=0;i<4;i++)
		{
			String ipNum = (String)ips[i];
			
			if(isDigit(ipNum)&&Integer.parseInt(ipNum)<=255)
				continue;
			else
				return false;
			
		}
		return true;
	}
	
	public static boolean isValidYear(String year){
		if(isNull(year) || !isDigit(year))
			return false;
			
		if(Integer.parseInt(year) >2100 ||Integer.parseInt(year) < 1900)
			return false;
		return true;
	}
}