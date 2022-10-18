package org.example.javaversion;

import org.example.javaversion.Java15.Java15Test;

public abstract sealed class Java15Abstract permits Java15, Java15Test {
  // only allow Java15 and Java15Test extends
}
